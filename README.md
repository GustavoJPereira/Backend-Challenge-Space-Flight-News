
# Backend Challenge Space Flight News

Este projeto é uma Rest API construída tendo em base a API Space Flight News. Ela funciona de forma semelhante e ainda copia os dados da API original para esta.



## Stack utilizada

**Linguagem de programação:** Java

**Framework:** Spring Boot

**IDE:** IntelliJ 

**Banco de dados:** MySQL

## Instalação

Primeiramente, troque as variáveis de ambiente ${SQL_USER} e ${SQL_PASSWORD}, em 
**application.properties**, pelo usuário e senha do banco MySQL. Além disto, crie um banco
de dados dentro do MySQL com o seguinte comando:

```SQL
CREATE DATABASE IF NOT EXISTS testecoodesh
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;
```

Então, para iniciar a aplicação, execute a classe **DesafioCoodeshApplication** em 
**com.testes.desafiocoodesh**. 
    
## Documentação

A rota padrão para a aplicação é http://localhost:8080 e para acessar a documentação 
adicione **/swagger-ui/index.html** a rota.


### Aviso
Caso queira ultilizar o script que copia o banco **copiarSpacefly()** fora do cron, 
também execute estas linha de código antes dele, para garantir o pelo funcionamento:

```Java
if (!repositoryUltimoIdSpacefly.findById(1L).isPresent()){
        repositoryUltimoIdSpacefly.iniciarBanco();
    }
``` 
## Apêndice

Link da apresentação da API no Loom [Aqui](https://www.loom.com/share/4ada9fc1efed4564af961621928fb046?sharedAppSource=personal_library).




> This is a challenge by Coodesh.