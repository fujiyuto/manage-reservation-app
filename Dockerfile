# ビルドイメージ指定
FROM gradle:jdk17 AS build

# 作業ディレクトリ
WORKDIR /app

#プロジェクトファイルのコピー
COPY . .

# プロジェクトのビルド
RUN gradle bootJar --no-daemon

# 実行環境のためのイメージ指定
FROM openjdk:17-jdk-slim

# 作業ディレクトリ
WORKDIR /app

# ビルド済み
COPY --from=build /app/build/libs/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]