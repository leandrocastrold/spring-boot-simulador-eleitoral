# (Spring Boot) Simulador Eleitoral API

Essa API REST é responsável por gerenciar candidatos e votos, simulando um sistema eleitoral. Utiliza validação, paginação e conexão com banco de dados MySQL.

Esse projeto faz parte do Simulador Eleitoral, que use React como Front-end.

## UPDATE
O banco de dados e a aplicação back-end estão configurados para rodar em containeres, utilizando o docker-compose do Docker.
Para rodar a aplicação em ambientes isolados, execute o comando:

```
docker compose up --build
```

## Instalação

```
git clone https://github.com/leandrocastrold/spring-boot-simulador-eleitoral.git
```

## Rotas

### GET

**`http://localhost:8080/api/v1/candidates`**

Lista todos os candidatos

**`http://localhost:8080/api/v1/candidates/number/{number}`**

Retorna candidato pelo número (não id)

**`http://localhost:8080/api/v1/candidates/total`**

Retorna total de candidatos cadastrados


**`http://localhost:8080/api/v1/candidates/validvotes`**

Retorna o total de votos válidos


**`http://localhost:8080/api/v1/notvalid/getblankvotes`**

Retorna o total de votos brancos

**`http://localhost:8080/api/v1/notvalid/getnullvotes`**

Retorna o total de votos nulos

**`http://localhost:8080/api/v1/notvalid/nullvote`**

Incrementa contador de votos nulos

**`http://localhost:8080/api/v1/notvalid/blankvote`**

Incrementa contador de votos brancos

<hr/>

### POST
**`http://localhost:8080/api/v1/savecandidate`**

Cadastra novo candidato

**`http://localhost:8080/api/v1/vote/{id}`**

Confirma voto para o candidato com id igual ao parâmetro

<hr/>

### UPDATE

**`http://localhost:8080/api/v1/updatecandidate/{id}`**

Atualiza candidato
<hr/>

### DELETE

**`http://localhost:8080/api/v1/deletecandidate`**

Exclui candidato do banco de dados
<hr/>


