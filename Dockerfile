# Dockerfile
FROM openjdk:11-jdk-slim

# Set environment variables for GitHub
ENV GITHUB_TOKEN=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
ENV REPO_URL=github.com/cinch-health-v2/rpm-common-libs.git

RUN apt-get update && apt-get install -y git


# Clone the private repository
RUN git clone https://ChinmaiMod:${GITHUB_TOKEN}@${REPO_URL} /app


WORKDIR /app

RUN chmod +x ./mvnw

# Build your application (if it's a Maven project)
RUN ./mvnw clean package 