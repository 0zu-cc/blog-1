package com.yltrcc.blog.api;

import cn.hutool.log.LogFactory;
import cn.hutool.log.StaticLog;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yltrcc.blog.api.entity.ApiResponse;
import com.yltrcc.blog.model.domain.Question;
import com.yltrcc.blog.model.domain.QuestionCategory;
import com.yltrcc.blog.model.domain.QuestionCustom;
import com.yltrcc.blog.service.QuestionCategoryService;
import com.yltrcc.blog.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.yltrcc.blog.api
 * Date：2022-02-03
 * Time：13:21
 * Description：用户获取面试题相关API
 *
 * @author yltrcc
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/question")
public class QuestionApiController {


    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionCategoryService questionCategoryService;


    @GetMapping("/getpage")
    public String getpage(@RequestParam("id") int id) {

        int count = questionService.getCounts();
        if (count == 0) {
            return "Sorry, 没有数据，请添加数据";
        }
        if (id > count) {
            return "Sorry, 当前数据库中没有此数据";
        }
        StringBuilder sb = new StringBuilder();
        Question question = questionService.findByQuestionId(id);
        sb.append(question.getArticleContent());
        sb.append("\n\n");

        return sb.toString();
    }

    @GetMapping("/getcount")
    public int getcount() {

        return questionService.getCounts();
    }

    @GetMapping("/getcategory")
    public ApiResponse<QuestionCategory> getcategory(Boolean isTop, String categoryId) {

        List<QuestionCategory> data = questionCategoryService.findCategory(isTop, categoryId);
        ApiResponse<QuestionCategory> response = new ApiResponse<>(data);
        response.setStatus(200);
        response.setCode(200);
        response.setMessage("获取成功！！！");

        return response;
    }

    @GetMapping("/queryByCategory")
    public ApiResponse<Question> queryByCategory(@RequestParam("categoryId") Long categoryId) {

        List<Question> data = questionService.findByCategory(categoryId);
        ApiResponse<Question> response = new ApiResponse<>(data);
        response.setStatus(200);
        response.setCode(200);
        response.setMessage("获取成功！！！");

        return response;
    }

    @GetMapping("/getAppVersionCode")
    public ApiResponse<String> getAppVersionCode() throws IOException {

        StringBuilder sb = new StringBuilder();
        //搜索当前目录下的APK文件
        String appPath = "usr/yltrcc/nginx/android";
        Path path = Paths.get(appPath);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                if (entry.toFile().isFile()) {
                    sb.append(entry.toFile().getName());
                }
            }
        }

        List<String> data = new ArrayList<>();
        data.add(sb.toString());
        ApiResponse<String> response = new ApiResponse<>(data);
        response.setStatus(200);
        response.setCode(200);
        response.setMessage("获取成功！！！");

        return response;
    }

}
