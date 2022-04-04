FROM openjdk:8
WORKDIR /usr/app
COPY /build/libs/tripPricer-1.0.0.jar trip-pricer.jar
CMD ["java", "-jar", "trip-pricer.jar"]
EXPOSE 8081