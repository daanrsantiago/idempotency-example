# Exemplo Idempotência

Este repositório contém uma aplicação em **Kotlin** usando **Spring Boot 3.4.2** criada com o intúito de demonstrar estratégias de implementação de idempotência.

## Requisitos
- Java 21

## Instalação e Execução

1. Clone o repositório

```bash
git clone https://github.com/daanrsantiago/idempotency-example
```

2. Navegue até o diretório do projeto:

```bash
cd idempotency-example
```

3. Compile o projeto usando o gradle

```bash
./gradlew build
```

4. Execute o docker compose

```bash
docker compose up
```

5. Execute a aplicação

```bash
java -jar build/libs/idempotency-example-0.0.1-SNAPSHOT.jar
```

## Documentação da API

A aplicação disponibiliza:

- Swagger UI: A interface gráfica para explorar a API está disponível em http://localhost:8080/swagger-ui.html.
- Especificação OpenAPI: O arquivo JSON com a descrição da API está disponível em http://localhost:8080/openapi.json.