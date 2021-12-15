FROM java:8-jre
VOLUME /tmp
ADD *.jar blog.jar
# 表示执行命令
RUN mkdir -p data/blog/app_logs
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/blog.jar"]