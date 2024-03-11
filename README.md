# Projet d'Exemple avec Spring Boot et JPA

Ce projet est un exemple de configuration de base pour démarrer un projet Spring Boot intégrant JPA (Java Persistence API). L'utilisation de JPA permet de simplifier le mapping entre les objets Java et la base de données relationnelle.

## Utilisation de JPA

JPA (Java Persistence API) est une spécification créée pour standardiser le mapping Objet-Relationnel (ORM). Elle définit un ensemble d'interfaces, de classes abstraites et d'annotations qui facilitent la description du mapping objet-relationnel. L'utilisation de JPA permet à votre application d'être indépendante du framework ORM utilisé.

## Configuration du Projet

Le projet a été initialement créé avec Spring Initializer, en incluant les dépendances suivantes :

- `spring-boot-starter-data-jpa` : Dépendance pour l'intégration de JPA avec Spring Boot.
- `spring-boot-starter-web` : Dépendance pour le développement d'applications web avec Spring Boot.
- `h2` : Base de données H2 en tant que dépendance de runtime pour les tests et le développement.
- `lombok` : Bibliothèque Lombok pour la génération automatique de code boilerplate.
- `spring-boot-starter-test` : Dépendance pour les tests unitaires avec Spring Boot.
- `mysql-connector-j` : Driver JDBC pour MySQL.

  On peut utiliser ce site pour generer les dependecies : https://start.spring.io/

Voici le snippet XML de configuration Maven pour ces dépendances :

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <excludes>
                    <exclude>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok</artifactId>
                    </exclude>
                </excludes>
            </configuration>
        </plugin>
    </plugins>
</build>
```
