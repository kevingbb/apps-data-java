# Apps and Data Sample with Java

## Local Setup

1. Open in Codespaces or as a DevContainer in VS Code
2. Start API on http://localhost:8080

```bash
cd api
# Run Spring Boot api App
./mvnw spring-boot:run
```

```bash
# Build Spring Boot api Container Image
./mvnw clean install spring-boot:repackage
docker build -t appsdata-java/api:v1 .
# Run & Test Container Image Locally
docker run -it --rm -p 8080:8080 --name appsdata-api --network=host -e="SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/javaspringtest" appsdata-java/api:v1
```

3. Start UI on http://localhost:8081

```bash
cd ui
npm install
npm run serve
```

```bash
# Build Vue ui Container Image
docker build -t appsdata-java/ui:v1 .
# Run & Test Container Image Locally
docker run -it --rm -p 8080:80 --name appsdata-ui appsdata-java/ui:v1
```
