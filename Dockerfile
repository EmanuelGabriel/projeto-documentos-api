FROM openjdk:11
ADD target/projeto-api-meta.jar projeto-api-meta.jar 
EXPOSE 9090
ENTRYPOINT [ "java", "-jar", "projeto-api-meta.jar"]