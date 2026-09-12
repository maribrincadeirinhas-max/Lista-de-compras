# API Lista de Compras

API REST desenvolvida em **Java + Spring Boot** para gerenciar uma lista de compras.

## Tecnologias

* Java
* Spring Boot
* Gradle Kotlin
* JSON

## Endpoints

| Método | Endpoint                       | Função                     |
| ------ | ------------------------------ | -------------------------- |
| POST   | `/produtos`                    | Adicionar produto          |
| GET    | `/produtos`                    | Listar produtos            |
| DELETE | `/produtos/{produto}`          | Remover produto            |
| PUT    | `/produtos/{produto}/comprado` | Marcar como comprado       |
| GET    | `/produtos/total`              | Ver quantidade de produtos |

## Como executar

1. Execute o projeto pelo IntelliJ na classe ListaDeCompraApplication.
2. A API estará disponível em: http://localhost:8080
3. Se preferir, abra a pasta do projeto no Postman e utilize os Endpoints citados anteriosmente: http://localhost:8080/<Endpoint>

## Observação

Os produtos são armazenados apenas em memória. Portanto, os dados são perdidos quando a aplicação é encerrada.
