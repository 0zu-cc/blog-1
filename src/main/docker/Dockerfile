FROM java:8-jre
VOLUME /tmp
ADD *.jar blog.jar
# 表示执行一段命令
RUN mkdir -p data/blog
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/blog.jar"]