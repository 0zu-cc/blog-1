package com.yltrcc.blog.api;

import com.yltrcc.blog.model.domain.Question;
import com.yltrcc.blog.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Package: com.yltrcc.blog.api
 * Date：2022-01-17
 * Time：15:27
 * Description：TODO
 *
 * @author yltrcc
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/random")
public class RandomController {

    /**
     * 上一个随机数，初始值-1
     */
    int lastNums = -1;

    @Autowired
    private QuestionService questionService;

    /**
     * 获取Markdown格式的面试题 - 用于微信公众号，安卓端
     * @return
     */
    @GetMapping("/getmk")
    public String getmk(@RequestParam("nums") Integer nums) {

        int count = questionService.getCounts();

        if (count == 0) {
            return "Sorry, 没有数据，请添加数据";
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<nums; i++) {
            //获取随机数
            int i2 = random.nextInt(count) + 1;
            while (i2 == lastNums) {
                i2 = random.nextInt(count) + 1;
            }
            Question question = questionService.findByQuestionId(i2);
            lastNums = i2;
            sb.append(question.getArticleContentMd());
            sb.append("\n---\n");
        }

        return sb.toString();
    }

    /**
     * 获取Html格式的面试题
     * @return
     */
    @GetMapping("/getpage")
    public String getpage(@RequestParam("nums") Integer nums) {

        int count = questionService.getCounts();


        if (count == 0) {
            return "Sorry, 没有数据，请添加数据";
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<nums; i++) {
            //获取随机数
            int i2 = random.nextInt(count) + 1;
            Question question = questionService.findByQuestionId(i2);
            sb.append(question.getArticleContent());
            sb.append("\n\n");
        }

        return sb.toString();
    }
}
