package com.yltrcc.blog.api;

import org.springframework.web.bind.annotation.*;

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



    /**
     * 获取Json格式的面试题 用于安卓端口
     * @return
     */
    @GetMapping("/random/getjson")
    public String getJson() {

        return "fsfsdf";
    }


}
