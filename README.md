
---

# Projeto API
---

Usuário: user_admin
senha: admin

O **Projeto API** é um aplicativo Java backend baseado em Spring Boot que utiliza um banco de dados em memória H2. Ele foi desenvolvido com as seguintes tecnologias:

- **Java 11**
- **Spring Boot 2.7.18**
- **JPA (Java Persistence API)**
- **ModelMapper**
- **Spring Boot Starter Data JPA**
- **Spring Boot Starter Web**
- **Lombok**

## Configurações do Banco de Dados

As configurações do banco de dados estão definidas no arquivo `application.properties`:

```properties
spring.application.name=projetopi
spring.datasource.url=jdbc:h2:mem:projetopi
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=teste
spring.datasource.password=teste
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
security.jwt.token.secret-key=412466c6f4b1dd5debad939b9b18dac6b323222bc0283473596997979f6bc207
```

## Dependências Adicionais

Além das dependências mencionadas acima, foi adicionado as seguintes bibliotecas:

- **Hibernate Validator**: Para validação de dados.
- **Spring Boot Starter Security**: Para segurança e autenticação.
- **JJWT (Java JSON Web Tokens)**: Para trabalhar com tokens JWT.

Lembre-se de atualizar o arquivo `pom.xml` com as dependências correspondentes.

## Passo a passo:



---

 **"🔨 Ainda martelando e lixando, mas já estamos no caminho certo! 🔧"**



 