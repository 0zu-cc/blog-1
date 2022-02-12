package com.yltrcc.blog.web.controller.admin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HtmlUtil;
import com.github.pagehelper.PageInfo;
import com.yltrcc.blog.model.domain.*;
import com.yltrcc.blog.model.dto.BlogConst;
import com.yltrcc.blog.model.dto.JsonResult;
import com.yltrcc.blog.model.dto.LogConstant;
import com.yltrcc.blog.model.enums.ArticleStatus;
import com.yltrcc.blog.model.enums.BlogEnums;
import com.yltrcc.blog.model.enums.PostType;
import com.yltrcc.blog.service.*;
import com.yltrcc.blog.util.BlogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Package: com.yltrcc.blog.web.controller.admin
 * Date：2022-01-15
 * Time：15:31
 * Description：所有面试题
 *
 * @author yltrcc
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/question")
public class QuestionController extends BaseController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private QuestionCategoryService questionCategoryService;
    @Autowired
    private TagService tagService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private QuestionService questionService;

    /**
     * 显示所有面试题
     *
     * @param model
     * @param page
     * @param limit
     * @return
     */
    @GetMapping
    public String question(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "8") int limit,
                          @RequestParam(value = "title", defaultValue = "") String title,
                          @RequestParam(value = "status", defaultValue = "0") String status) {
        QuestionCustom questionCustom = new QuestionCustom();
        if (status == null || "null".equals(status)) {
            status = "0";
        }
        questionCustom.setArticleStatus(new Integer(status));
        questionCustom.setArticlePost(PostType.POST_TYPE_POST.getValue());
        if (title != null && !"".equals(title)) {
            questionCustom.setArticleTitle("%" + title + "%");
        }
        PageInfo<QuestionCustom> pageInfo = questionService.findPageQuestion(page, limit, questionCustom);
        model.addAttribute("info", pageInfo);
        return "admin/admin_question";
    }

    /**
     * 过滤空格
     *
     * @param articleTitle
     * @return
     */
    @PostMapping(value = "/filter")
    @ResponseBody
    public JsonResult filter(String articleTitle) {
        articleTitle = articleTitle.replaceAll(" ", "-");
        return new JsonResult(true, articleTitle);
    }

    /**
     * 保存文章
     *
     * @param question   面试题
     * @param tags      标签
     * @return
     */
    @PostMapping(value = "/new/save")
    @ResponseBody
    public JsonResult save(Question question, Long[] tags, Long category, HttpServletRequest request) {
        try {
            if (StrUtil.isEmpty(question.getArticleTitle())) {
                return new JsonResult(false, "标题不能为空");
            }
            if (category != null) {
                question.setCategoryId(category);
            }
            if (question.getId() == null) {
                // 判断文章链接是否重复
                if (!StrUtil.isEmpty(question.getArticleUrl())) {
                    if (question.getArticleUrl().length() > 50) {
                        return new JsonResult(false, "路径不能大于50");
                    }
                    // 查询url是否重复
                    int repeat = articleService.findRepeatByUrl(question.getArticleUrl());
                    if (repeat != 0) {
                        return new JsonResult(false, "路径已存在");
                    }
                }
                User user = (User) request.getSession().getAttribute(BlogConst.USER_SESSION_KEY);
                question.setUserId(user.getUserId());
                question.setArticleNewstime(DateUtil.date());
                question.setArticleUpdatetime(DateUtil.date());
                // 如果自定义链接为空则按时间戳生成链接
                if (StrUtil.isEmpty(question.getArticleUrl())) {
                    question.setArticleUrl(String.valueOf(System.currentTimeMillis() / 1000));
                }
                // 如果没有选择略缩图则随机一张图
                if (StrUtil.isEmpty(question.getArticleThumbnail())) {
                    question.setArticleThumbnail("/static/img/rand/" + RandomUtil.randomInt(1, 19) + ".jpg");
                }
                // 判断摘要是否为空
                if (StrUtil.isEmpty(question.getArticleSummary())) {
                    // 如果摘要为空则取前五十字为摘要
                    int post_summary = 50;
                    if (StrUtil.isNotEmpty(BlogConst.OPTIONS.get("post_summary"))) {
                        post_summary = Integer.parseInt(BlogConst.OPTIONS.get("post_summary"));
                    }
                    // 清理html标签和空白字符
                    String summaryText = StrUtil.cleanBlank(HtmlUtil.cleanHtmlTag(question.getArticleContent()));
                    // 设置文章摘要
                    if (summaryText.length() > post_summary) {
                        question.setArticleSummary(summaryText.substring(0, post_summary));
                    } else {
                        question.setArticleSummary(summaryText);
                    }
                }
                questionService.save(question, tags);
                // 添加日志
                logService.save(new Log(LogConstant.PUBLISH_AN_ARTICLE, LogConstant.SUCCESS,
                        ServletUtil.getClientIP(request), DateUtil.date()));
            } else {
                // 如果没有选择略缩图则随机一张图
                if (StrUtil.isEmpty(question.getArticleThumbnail())) {
                    question.setArticleThumbnail("/static/img/rand/" + RandomUtil.randomInt(1, 19) + ".jpg");
                }
                // 判断摘要是否为空
                if (StrUtil.isEmpty(question.getArticleSummary())) {
                    // 如果摘要为空则取前五十字为摘要
                    int post_summary = 50;
                    if (StrUtil.isNotEmpty(BlogConst.OPTIONS.get("post_summary"))) {
                        post_summary = Integer.parseInt(BlogConst.OPTIONS.get("post_summary"));
                    }
                    // 清理html标签和空白字符
                    String summaryText = StrUtil.cleanBlank(HtmlUtil.cleanHtmlTag(question.getArticleContent()));
                    // 设置文章摘要
                    if (summaryText.length() > post_summary) {
                        question.setArticleSummary(summaryText.substring(0, post_summary));
                    } else {
                        question.setArticleSummary(summaryText);
                    }
                }
                // 文章最后修改时间
                question.setArticleUpdatetime(DateUtil.date());
                questionService.update(question, tags);
                // 添加日志
                logService.save(new Log(LogConstant.UPDATE_AN_ARTICLE, LogConstant.SUCCESS,
                        ServletUtil.getClientIP(request), DateUtil.date()));
            }
        } catch (Exception e) {
            log.error("添加或更新失败" + e.getMessage());
            return new JsonResult(BlogEnums.ERROR.isFlag(), BlogEnums.ERROR.getMessage());
        }
        return new JsonResult(BlogEnums.PRESERVE_SUCCESS.isFlag(), BlogEnums.PRESERVE_SUCCESS.getMessage());
    }

    /**
     * 推送百度
     *
     * @param token 在搜索资源平台申请的推送用的准入密钥
     * @return
     */
    @PostMapping(value = "/pushBaidu")
    @ResponseBody
    public JsonResult pushBaidu(@RequestParam(value = "token") String token) {
        try {
            if (StrUtil.isEmpty(token)) {
                return new JsonResult(false, "请先填写token");
            }
            String blogUrl = BlogConst.OPTIONS.get("blog_url");
            List<ArticleCustom> articles = articleService.findAllArticle(ArticleStatus.PUBLISH.getStatus(),
                    PostType.POST_TYPE_POST.getValue());
            StringBuffer urls = new StringBuffer();
            for (ArticleCustom article : articles) {
                urls.append(blogUrl).append("/archives/").append(article.getArticleUrl()).append("\n");
            }
            String result = BlogUtil.baiduPost(blogUrl, token, urls.toString());
            if (StrUtil.isEmpty(result)) {
                return new JsonResult(false, "推送失败");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new JsonResult(true, "推送成功");
    }

    /**
     * 还原文章为发布状态
     *
     * @param id 文章id
     * @return
     */
    @PostMapping(value = "/restore")
    @ResponseBody
    public JsonResult restore(@RequestParam(value = "id") int id) {
        try {
            articleService.recycle(id, ArticleStatus.PUBLISH.getStatus());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new JsonResult(BlogEnums.OPERATION_SUCCESS.isFlag(), BlogEnums.OPERATION_SUCCESS.getMessage());
    }

    /**
     * 修改文章状态为回收站
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/recycle")
    public String updateStatus(@RequestParam(value = "id") int id) {
        try {
            articleService.recycle(id, ArticleStatus.RECYCLE.getStatus());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "redirect:/admin/article?status=0";
    }

    /**
     * 彻底删除文章
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/remove")
    public String remove(@RequestParam(value = "id") int id, HttpServletRequest request) {
        try {
            articleService.remove(id);
            // 添加日志
            logService.save(new Log(LogConstant.REMOVE_AN_ARTICLE, LogConstant.SUCCESS,
                    ServletUtil.getClientIP(request), DateUtil.date()));
        } catch (Exception e) {
            log.error("删除文章失败" + e.getMessage());
        }
        return "redirect:/admin/article?status=2";
    }

    /**
     * 新建文章页面
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/new")
    public String newArticle(Model model) {
        try {
            List<QuestionCategory> categorys =  questionCategoryService.findCategory(null, null);
            List<Tag> tags = tagService.findTags();
            model.addAttribute("categorys", categorys);
            model.addAttribute("tags", tags);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "admin/admin_new_question";
    }

    /**
     * 修改文章页面
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/edit")
    public String editArticle(Model model, @RequestParam(value = "article_id") Integer article_id) {
        try {
            // 获取所有分类
            List<QuestionCategory> categorys =  questionCategoryService.findCategory(null, null);
            // 获取所有标签
            List<Tag> tags = tagService.findTags();
            // 获取文章信息
            QuestionCustom questionCustom = questionService.findByQuestionId(article_id);
            model.addAttribute("categorys", categorys);
            model.addAttribute("tags", tags);
            model.addAttribute("questionCustom", questionCustom);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "admin/admin_edit_question";
    }

    /**
     * @param article_id 文章id
     * @return 该篇文章关联的分类和标签
     */
    @PostMapping(value = "/ids")
    @ResponseBody
    public Map<String, Object> ids(Integer article_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // 获取文章信息
            ArticleCustom articleCustom = articleService.findByArticleId(article_id);
            if (articleCustom.getTags() != null) {
                map.put("tagsIds", articleCustom.getTags().split(","));
            }
            if (articleCustom.getCategorys() != null) {
                map.put("categorysIds", articleCustom.getCategorys().split(","));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return map;
    }

}
