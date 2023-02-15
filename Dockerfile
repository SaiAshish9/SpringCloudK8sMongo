FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/springboot-k8s-mongo.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]