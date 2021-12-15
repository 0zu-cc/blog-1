FROM java:8-jre
VOLUME /tmp
ADD *.jar blog.jar
# 表示执行命令
RUN mkdir -p data/blog/app_logs
# 表示执行名利
RUN touch app_console.log
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/blog.jar"]