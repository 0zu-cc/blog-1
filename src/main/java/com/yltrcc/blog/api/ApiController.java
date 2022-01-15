package com.yltrcc.blog.api;

import com.yltrcc.blog.model.domain.Question;
import com.yltrcc.blog.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Package: com.yltrcc.blog.api
 * Date：2022-01-15
 * Time：14:54
 * Description：对外提供API接口服务
 *
 * @author yltrcc
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private QuestionsService questionsService;

    /**
     * 获取Markdown格式的面试题 - 用于微信公众号
     * @return
     */
    @GetMapping("/random/getmk")
    public String getmk(@RequestParam("nums") Integer nums) {

        int count = questionsService.getCounts();

        if (count == 0) {
            return "Sorry, 没有数据，请添加数据";
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<nums; i++) {
            //获取随机数
            int i2 = random.nextInt(count) + 1;
            Question question = questionsService.findByQuestionsId(i2);
            sb.append(question.getArticleContentMd());
            sb.append("\n---\n");
        }

        return sb.toString();
    }

    /**
     * 获取Json格式的面试题 用于安卓端口
     * @return
     */
    @GetMapping("/random/getjson")
    public String getJson() {

        return "fsfsdf";
    }


}
