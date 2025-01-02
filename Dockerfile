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
WORKDIR /var/www/html

# ビルド済み
COPY --from=build /app/build/libs/*.jar /var/www/html/app.jar

ENTRYPOINT [ "java", "-jar", "/var/www/html/app.jar" ]

# ポートを公開
EXPOSE 8080