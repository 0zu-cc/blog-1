
<h1><a href="https://blog.yltrcc.com">blog</a></h1>

>  **blog是springboot和thymeleaf编写的一个java博客系统，练手的**

![JDK](https://img.shields.io/badge/jdk-1.8-green.svg?style=flat-square) 
[![LICENSE](https://img.shields.io/github/license/ttxxly/blog.svg?style=flat-square)](https://github.com/yltrcc/blog/master/LICENSE)
[![star](https://img.shields.io/github/stars/yltrcc/blog.svg?label=Stars&style=social)](https://github.com/yltrcc/blog)

# 部署说明
## windows 环境
1. 下载代码
   `git clone https://github.com/yltrcc/blog.git`
2. 运行sql文件夹下的sql文件
3. 到src/main/resources下的application.yaml下修改你的数据库链接
4. 保存好以后 mvn package打包
5. 进入target文件夹运行nohup java -jar blog.jar &
6. 访问http://localhost:8091
7. 后台管理系统地址http://localhost:8091/admin

## Linux 环境
默认你是 Linux Centos 环境
* 请下载 Docker以及Docker compose
* 使用 Docker compose 来安装我们需要的环境
  * 两个Nginx：双机热备
  * 两个应用：CICD，建立两个job
  * 一个mysql



# CICD

目前Nginx 和 mysql 自动安装
项目jar使用Jenkins、docker配合github hook实现自动构建部署到docker容器中


# 评论
目前没有打算自己写评论功能。用的两个评论插件[gitalk](https://github.com/gitalk/gitalk)和[valine](https://ioliu.cn/2017/add-valine-comments-to-your-blog/)
# 开源协议
[MIT](https://gitee.com/song_haozhi/blog/blob/master/LICENSE)
# 致谢：
 1. [SpringBoot](http://spring.io/projects/spring-boot) 版本2.0.4
 2. [MyBatis](http://www.mybatis.org/mybatis-3/) ORM框架
 3. [MySQL](https://www.mysql.com/) 数据库，版本5.6
 4. [Maven](http://maven.apache.org/)  依赖管理
 5. [Druid](https://github.com/alibaba/druid/) 阿里连接池
 6. [Thymeleaf](https://www.thymeleaf.org/) spring官方推荐的模板引擎
 7. [Vali Admin](https://github.com/pratikborsadiya/vali-admin) 后台模板
 8. [jquery toast插件](http://www.jqueryfuns.com/resource/2412) 信息提示插件
 9. [Font Awesome](http://www.fontawesome.com.cn/faicons/) 图标库
 10. [Thumbnailator](https://github.com/coobird/thumbnailator) 压缩图片工具类
 11. [Hutool](http://hutool.mydoc.io/) Hutool是一个Java工具包
 12. [PageHelper](https://pagehelper.github.io/) mybatis分页插件
 13. [Bootstrap-Fileinput](https://github.com/kartik-v/bootstrap-fileinput) bootstrap上传控件
 14. [halo](https://github.com/ruibaby/halo)  halo博客系统
 15. [Ehcache](http://www.ehcache.org/) Java的进程内缓存框架
 16. [MDTool](https://github.com/cevin15/MDTool) 将markdown转换为html的工具
 17. [viewerjs](https://github.com/fengyuanchen/viewerjs) 图片预览工具



