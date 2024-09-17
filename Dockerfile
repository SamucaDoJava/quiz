# Use a imagem base com OpenJDK 21
FROM openjdk:21-jdk-slim

# Defina as variáveis de ambiente MAVEN_HOME e M2_HOME
ENV MAVEN_VERSION=3.9.1 \
    MAVEN_HOME=/opt/maven \
    M2_HOME=/opt/maven \
    FLYWAY_VERSION=9.16.0 \
    FLYWAY_HOME=/opt/flyway

# Instale o Maven, Flyway CLI e outras dependências necessárias
RUN apt-get update && \
    apt-get install -y wget libfreetype6 libfontconfig1 && \
    # Instalar Maven
    wget -O apache-maven-$MAVEN_VERSION-bin.tar.gz https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
    tar -xzf apache-maven-$MAVEN_VERSION-bin.tar.gz -C /opt && \
    mv /opt/apache-maven-$MAVEN_VERSION /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn && \
    rm apache-maven-$MAVEN_VERSION-bin.tar.gz && \
    # Instalar Flyway CLI
    wget -O flyway-commandline-$FLYWAY_VERSION-linux-x64.tar.gz https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/$FLYWAY_VERSION/flyway-commandline-$FLYWAY_VERSION-linux-x64.tar.gz && \
    tar -xzf flyway-commandline-$FLYWAY_VERSION-linux-x64.tar.gz -C /opt && \
    mv /opt/flyway-$FLYWAY_VERSION $FLYWAY_HOME && \
    ln -s $FLYWAY_HOME/flyway /usr/local/bin/flyway && \
    rm flyway-commandline-$FLYWAY_VERSION-linux-x64.tar.gz

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo pom.xml e o diretório src para o contêiner
COPY pom.xml .
COPY src ./src

# Execute o Maven para construir a aplicação
RUN mvn clean install -U -DskipTests
RUN ls -la target

# Copie o arquivo WAR gerado para o diretório apropriado
COPY target/quiz-0.0.1-SNAPSHOT.war /app/quiz-0.0.1-SNAPSHOT.war

# Copie o diretório env para o contêiner
COPY env /app/env

# Defina o arquivo de configuração das variáveis de ambiente
ENV USE_ENV_FOLDER_PROFILE_ENVIRONMENTS=false
ENV ENV_FILE=docker
ENV ENV_PATH=/app/env

# Exponha as portas para o aplicativo e para a depuração
EXPOSE 8080
EXPOSE 8081
EXPOSE 8082
EXPOSE 50

# Comando para iniciar a aplicação Spring Boot
CMD ["java", "-jar", "/app/quiz-0.0.1-SNAPSHOT.war"]
