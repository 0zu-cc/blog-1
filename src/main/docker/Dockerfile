FROM java:8-jre
VOLUME /tmp
ADD *.jar blog.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/blog.jar"]