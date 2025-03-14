## Documentação LadyDrive

### Projeto: Aplicativo de Carona

### Integrantes:
- Abiqueila / [GitHub](https://github.com/Abilafora/)
- Ana Beatriz / [GitHub](https://github.com/dsilvasantosgit)
- Evelyn Pereira / [GitHub](https://github.com/EvelynSantos6?tab=repositories)
- Hellen Gleice / [GitHub](https://github.com/hellengleice)
- Isabela Santos / [GitHub](https://github.com/Isabela-prog)
- Maytê Araújo / [GitHub](https://github.com/maytearaujo)
- Thainara Cruz / [GitHub](https://github.com/ThainaraCruz)

### Objetivo:
O **LadyDrive** é um aplicativo de carona compartilhada, exclusivo para mulheres. Ele permite o cadastro de usuárias, o gerenciamento de veículos e viagens, e a associação de motoristas e passageiros.

## 1. Packages Utilizados:

### 1.1 Model
Representa os dados (Veículo).

### 1.2 Viagem Controller
Controlador para manipulação das requisições.

### 1.3 Repository
Camada responsável pela comunicação com o banco de dados.

### 1.4 Service
Camada responsável pela regra de negócio.

---

## Etapas do Projeto

### Pacote: model
Contém as classes de modelo que representam as entidades do banco de dados.

- **Usuario**
  - Atributos: id, nome, usuario, senha, foto, sexo.
  - Relacionamento: Um usuário pode ter vários veículos.
  
- **Veiculo**
  - Atributos: id, modelo, placa, cor, motorista.
  - Relacionamento: Cada veículo pertence a uma viagem e a um usuário.

- **Viagem**
  - Atributos: id, origem, destino.
  - Relacionamento: Uma viagem pode ter vários veículos associados.

### Pacote: repository
Contém os repositórios responsáveis pela persistência de dados usando Spring Data JPA.

- **UsuarioRepository**: Interface para manipulação de dados de usuários.
- **VeiculoRepository**: Interface para manipulação de dados de veículos.
- **ViagemRepository**: Interface para manipulação de dados de viagens.

### Pacote: controller
Contém as classes responsáveis por expor as funcionalidades como endpoints REST.

- **UsuarioController**: Define endpoints para cadastro, atualização e consulta de usuários.
- **VeiculoController**: Define endpoints para cadastro, atualização, consulta e exclusão de veículos.
- **ViagemController**: Define endpoints para cadastro, atualização e consulta de viagens.

### Pacote: service
Contém a lógica de negócios, como validações e regras específicas.

- **UsuarioService**: Contém a lógica de validação do cadastro de usuário, garantindo que o sexo seja feminino.

---

## Endpoints

### 1. UsuarioController

- **GET /usuarios/all**: Retorna todos os usuários cadastrados.
- **GET /usuarios/{id}**: Retorna um usuário específico pelo ID.
- **POST /usuarios/cadastrar**: Cria um novo usuário (somente mulheres).
- **PUT /usuarios/atualizar**: Atualiza os dados de um usuário.

### 2. VeiculoController

- **GET /veiculos**: Retorna todos os veículos cadastrados.
- **GET /veiculos/{id}**: Retorna um veículo específico pelo ID.
- **GET /veiculos/modelo/{modelo}**: Retorna veículos filtrados pelo modelo.
- **POST /veiculos**: Cria um novo veículo, associando-o a uma viagem e a um usuário.
- **PUT /veiculos**: Atualiza os dados de um veículo.
- **DELETE /veiculos/{id}**: Exclui um veículo pelo ID.

### 3. ViagemController

- **GET /viagens**: Retorna todas as viagens cadastradas.
- **GET /viagens/{id}**: Retorna uma viagem específica pelo ID.
- **GET /viagens/destino/{destino}**: Filtra viagens pelo destino.
- **POST /viagens**: Cria uma nova viagem.
- **PUT /viagens**: Atualiza os dados de uma viagem.
- **DELETE /viagens/{id}**: Exclui uma viagem pelo ID.

---

## Validações

### 1. Cadastro de Usuário
- **Sexo**: Somente usuários do sexo feminino podem se cadastrar. O sexo é validado na **UsuarioService**.

### 2. Veículo e Viagem
- A criação de veículos e viagens exige que os dados estejam corretos, como o preenchimento obrigatório dos campos modelo, placa, cor e motorista.

---

## Tecnologias Utilizadas

- **Spring Framework**: Framework principal para desenvolvimento da aplicação.
- **Spring Boot**: Facilita a criação e configuração do projeto Spring. Configuração automática de servidores embutidos (como Tomcat e Jetty) e simplificação da criação de APIs RESTful.
- **JPA (Java Persistence API)**: Usado para mapear objetos Java para tabelas de bancos de dados relacionais.
- **Spring Web**: Facilita a criação de APIs RESTful. Usamos `@RestController` e `@RequestMapping` para definir as rotas e métodos de manipulação de requisições.
- **Insomnia**: Ferramenta de cliente HTTP para testar e depurar APIs RESTful.
- **MySQL**: Banco de dados relacional utilizado para persistir os dados dos funcionários. Integrado com JPA para mapear as entidades Java para tabelas no MySQL e realizar operações de CRUD no banco de dados.

---

## Como Executar o Projeto

### Pré-requisitos:
- **Java 17 ou superior**: O projeto utiliza o Spring Boot 2.x.
- **IDE (como STS)**: Para editar e rodar o projeto.
- **Maven**: Para gerenciar as dependências do projeto.

