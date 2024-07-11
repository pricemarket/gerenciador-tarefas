# Etapa de construção
FROM maven:3.8.4-openjdk-17-slim AS build

# Atualize e instale pacotes necessários
RUN apt-get update && \
    apt-get install -y wget unzip

# Defina o diretório de trabalho
WORKDIR /gerenciador-tarefas

# Copie o arquivo pom.xml e instale as dependências
COPY pom.xml .

# Instale as dependências sem executar os testes
RUN mvn dependency:go-offline -B

# Copie o código-fonte do aplicativo
COPY src ./src

# Compile o aplicativo
RUN mvn clean package -DskipTests

# Etapa de runtime
FROM openjdk:17-jdk-slim

# Exponha a porta 8080
EXPOSE 8080

# Defina o diretório de trabalho
WORKDIR /gerenciador-tarefas

# Copie o JAR do build stage para o diretório de trabalho
COPY --from=build /gerenciador-tarefas/target/gerenciador-tarefas-0.0.1-SNAPSHOT.jar /gerenciador-tarefas/

# Comando para executar o aplicativo quando o contêiner inicia
ENTRYPOINT ["java", "-jar", "gerenciador-tarefas-0.0.1-SNAPSHOT.jar"]