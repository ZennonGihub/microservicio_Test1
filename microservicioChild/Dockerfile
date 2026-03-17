FROM gradle:jdk21-alpine AS build

WORKDIR /home/gradle/project

COPY build.gradle settings.gradle ./

RUN gradle build --no-daemon > /dev/null 2>&1 || true

COPY src ./src

RUN gradle bootJar --no-daemon


# Segunda etapa

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /home/gradle/project/build/libs/app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]