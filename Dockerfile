# =======================
# Étape 1 : Build de l'application avec Maven
# =======================
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# On définit le dossier de travail dans le container
WORKDIR /app

# On copie uniquement les fichiers pom.xml et les fichiers de config Maven d'abord
# pour utiliser le cache Docker (ça évite de re-télécharger toutes les dépendances à chaque build)
COPY pom.xml ./

# Télécharge toutes les dépendances (sans builder le projet)
RUN mvn dependency:go-offline -B

# On copie ensuite le code source
COPY src ./src

# Build du projet en générant le jar
RUN mvn clean package -DskipTests

# =======================
# Étape 2 : Image finale allégée
# =======================
FROM eclipse-temurin:21-jre

# On définit un dossier de travail
WORKDIR /app

# On copie uniquement le jar depuis l'étape précédente
COPY --from=builder /app/target/*.jar app.jar

# Exposition du port 8080 (celui de Spring Boot)
EXPOSE 8080

# Commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"]
