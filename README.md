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
./mvnw spring-boot:build-image
# Run & Test Container Image Locally
docker run -it --rm -p 8080:8080 --network=host -e="SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/javaspringtest" appsdata:0.0.1-SNAPSHOT
```

3. Start UI on http://localhost:8081

```bash
cd ui
npm install
npm run serve
```