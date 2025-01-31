FROM openjdk:22
COPY address-service/target /app
COPY addressdb.mv.db /app
WORKDIR /app
EXPOSE 8082
CMD ["java", "-jar", "address-service-0.0.1-SNAPSHOT.jar"]
