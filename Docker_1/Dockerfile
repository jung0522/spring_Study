# JDK 17을 기반으로 하는 이미지를 사용
FROM openjdk:17-jdk-slim

# 애플리케이션 JAR 파일 위치 설정
ARG JAR_FILE=build/libs/*.jar

# 컨테이너에서 JAR 파일을 실행할 위치로 복사
COPY ${JAR_FILE} app.jar

# 애플리케이션 실행 명령
ENTRYPOINT ["java", "-jar", "/app.jar"]

# docker build -t docker1 .
# docker build: Docker 이미지를 빌드하는 명령어다.
#-t docker1: 생성할 이미지에 docker1이라는 태그를 붙인다.
#.: 현재 디렉토리를 빌드 컨텍스트로 지정합니다. 여기서 Docker는 Dockerfile을 찾는다.