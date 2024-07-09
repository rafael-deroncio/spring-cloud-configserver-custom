Here is the documentation for your project, formatted similarly to the provided example:

# Config Server Project

## Description
Project for Spring Boot Config Server with GitHub and Vault integration.

## Table of Contents
1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Installation](#installation)
4. [Configuration](#configuration)
5. [Project Structure](#project-structure)
6. [Usage](#usage)
7. [Contribution](#contribution)
8. [License](#license)
9. [Contact](#contact)

## Introduction
This project demonstrates setting up a Spring Boot Config Server that uses HashiCorp Vault and GitHub as configuration sources.

## Prerequisites
- Java 17
- Maven 3.6.3+
- Docker and Docker Compose

## Installation
Steps to set up the development environment:

```bash
# Clone the repository
git clone https://github.com/rafael-deroncio/spring-cloud-configserver-custom.git

# Navigate to the project directory
cd spring-cloud-configserver-custom

# Build the project
mvn clean install
```

## Configuration

### Docker Compose
Start the Vault container using Docker Compose:

```bash
# Start Vault with Docker Compose
docker-compose up -d
```

### Properties File
Configure the `application.yml` file with Vault and GitHub settings:

```yaml
spring.application.name: configserver

server.port: 8888

spring.profiles.active: vault, git

spring.cloud.config.server.vault.host: 127.0.0.1
spring.cloud.config.server.vault.port: 8200
spring.cloud.config.server.vault.scheme: http
spring.cloud.config.server.vault.kv-version: 2
spring.cloud.config.server.vault.authentication: TOKEN
spring.cloud.config.server.vault.token: root
spring.cloud.config.server.vault.order: 1

spring.cloud.config.server.git.uri: https://github.com/<username>/<repository>
spring.cloud.config.server.git.searchPaths: "{application}"
spring.cloud.config.server.git.username: your_github_username
spring.cloud.config.server.git.password: your_github_token
spring.cloud.config.server.git.force-pull: true
spring.cloud.config.server.git.order: 2

spring.security.user.name: your_username
spring.security.user.password: your_password
```

## Project Structure
Description of the project directory structure and important files:

```
<repository>/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── company/
│   │   │           └── configserver/
│   │   │               ├── configuration/
│   │   │               ├── environment/
│   │   │               │   └── repository/
│   │   │               └── ConfigServerApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   └── test/
│       └── java/
│           └── com/
│               └── company/
│                   └── configserver/
└── pom.xml
```

## Usage
Instructions to run the project:

```bash
# Run the project
mvn spring-boot:run
```

### Available Endpoints
The following endpoints are available:

- `GET /configserver/{application}/{profile}` - Fetch configuration properties for a specific application and profile.

## Contribution
Guide to contribute to the project:

1. Fork the project
2. Create a branch for your feature (`git checkout -b feature/feature-name`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/feature-name`)
5. Open a Pull Request

## License
This project is licensed under the MIT License.

## Contact
For questions and support, contact:
- Email: [your_email@example.com](mailto:your_email@example.com)
- LinkedIn: [Your Name](https://linkedin.com/in/your-profile)

---

Adapt the placeholders with your actual values, such as `<username>`, `<repository>`, and your contact information.
