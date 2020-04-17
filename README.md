# pitang-api
API RESTful para Sistema de Usuários de Carros

## Technical Details
* Java 
* Spring-boot
* Spring-security
* Spring-data
* Spring-tests
* H2 Database
* Lombok
* Swagger
* Angular
* Node
* AWS EC2
* Sonar Qube

Utilização de melhores práticas e frameworks disponíveis para implementação de api.

## Instalação

**Build Api**

mvn clean install

mvn package spring-boot:repackage

**Execução Api**

java -jar pitang-api-0.0.1-SNAPSHOT.jar

**Teste Api**

http://{server}:{port}/api

Ex: http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api

**Build Front (Angular)**

npm install

ng build --prod

**Execução Front**

ng serve

**Teste Front**

http://{server}:{port}/#/login

Ex: http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/#/login


## User stories

**Login**
Acessar api de usuários e carros utilizando login e senha.
Para o primeiro acesso, deverá ser criado um novo usuário.

**Cadastro**
Criar registro de usuário para acesso à api, informando dados de acesso, pessoais e dados do carro principal.
Os dados de usuário requisitados são nome, sobrenome, data de nascimento, e-mail, login, senha, celular.
Os dados do carro principal requisitados são placa, cor, modelo, ano.

**Usuário**
Manter o cadastro de usuários apresentando os dados do usuário e carros do usuário, permitindo incluir novos usuários, alterar e apagar os já existentes.

**Carros**
Manter o cadastro de carros apresentando os dados do veículo, permitindo incluir novos carros, alterar e apagar os já existentes.
Poderá ser enviada foto do veículo cadastrado.


## Requisitos
JWT como token

Servidor deve estar embutido na aplicação (Tomcat, Undertow ou Jetty); 

Processo de build via Maven; 

Banco de dados em memória, como H2; 

Framework Spring; 

Utilizar no mínimo Java 8; 

Persistência com Spring Data; 

Disponibilizar a API rodando em algum host AWS

Testes unitários; 

Criar um repositório público em alguma ferramenta de git. 

O desenvolvimento deve simular uma mini-sprint (Scrum), dividindo o desafio em estórias de usuário (story users). 

O README.md do projeto deverá ter uma seção ESTÓRIAS DE USUÁRIO com a lista numerada de estórias de usuário que foram concebidas para a implementação do desafio. A primeira linha de cada commit do repositório deve utilizar a descrição da estória de usuário associada. 

O README.md do projeto deverá ter uma seção SOLUÇÃO com as justificativas e defesa técnica da solução que está sendo entregue. 

O README.md do projeto deve ser claro e mostrar tudo que precisa ser feito para executar o build do projeto, deploy, testes, etc. 


Documentação (Javadoc); 

Design Pattern: MVC; 

Integração com SonarQube; 

Swagger: http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/swagger-ui.html


## EndPoints

createUser -> [POST] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users

login -> [POST] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/signin

createCar -> [POST] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/cars

getUsers -> [GET] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users

getUserById -> [GET] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users/1

getCars -> [GET] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/cars

getCar -> [GET] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users/1

updateUser -> [PUT] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users/1

deleteUser -> [DELETE] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users/1


