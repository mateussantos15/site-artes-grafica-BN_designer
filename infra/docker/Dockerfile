# =====================================================================
# 🧱 1) BUILD STAGE — Usa Maven + JDK 21 para compilar o projeto
# =====================================================================

FROM maven:3.9.4-eclipse-temurin-21 AS build

# Define o diretório de trabalho dentro da imagem
WORKDIR /workspace

# Copia apenas o pom.xml para ativar o cache de dependências
COPY pom.xml .

# Baixa todas as dependências do Maven usando o pom.xml
RUN mvn -B dependency:go-offline

# Agora copia TODO o restante do projeto
COPY . .

# Compila a aplicação e gera o .jar dentro de target/
RUN mvn -B clean package -DskipTests

# =====================================================================
# 🚀 2) RUNTIME STAGE — Imagem final limpa e leve com JRE 21
# =====================================================================

FROM eclipse-temurin:21-jre-alpine

# Define o diretório de trabalho no container final
WORKDIR /app

# Copia o jar gerado na primeira etapa (sempre app.jar)
COPY --from=build /workspace/target/app.jar /app/app.jar

# Expõe a porta da aplicação Spring Boot
EXPOSE 8080

# Define o profile padrão dentro do container
ENV SPRING_PROFILES_ACTIVE=docker

# Comando que inicia a aplicação quando o container sobe
ENTRYPOINT ["java", "-jar", "/app/app.jar"]