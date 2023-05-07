# PowerKR API

API Restful com Java e Springboot para a 2ª etapa do processo seletivo da PowerKR. 


## Autenticação

O meio de autenticação utilizado na nossa API é o Spring Security com tokens JWT (JSON Web Tokens) gerados pela biblioteca Auth0. Esses tokens são usados para garantir que apenas usuários autenticados possam acessar as rotas protegidas da API.

Quando um usuário faz login na aplicação, o servidor gera um token JWT com informações do usuário e outras informações adicionais, como data de expiração do token. Esse token é então enviado para o cliente, que o armazena localmente, geralmente em um cookie ou no armazenamento do navegador.

A partir desse momento, todas as requisições subsequentes feitas pelo cliente para a API devem conter esse token no cabeçalho de autorização, no formato "Bearer <token>". O servidor verifica se o token é válido e, se for, permite o acesso à rota solicitada.

Todos os endpoints e métodos precisam de autenticação para serem usados, menos os métodos de cadastrar usuário e efetuar login,
 que devem permitir o usuário enviar as credenciais.

O Token JWT dura 2 horas, após esse tempo ele é invalidado e não funciona mais.

## UserDetailsService

Classe `Usuario` e `UsuarioService` implementa a interface `UserDetailsService` 
do Spring Security, que é uma boa prática para delegar a autenticação e autorização de usuários para o framework de segurança.

## Senhas

Todas as senhas são criptografadas no banco de dados, foi usado o algoritmo BCrypt.

## Atualização do e-mail

Caso você atualize o e-mail, terá que fazer o login novamente e gerar outro token.

## DTOs

Todas os controladores contam com entradas de dados na saída e na entrada.
Optei por criar uma classe DTO para lista e outra para o objeto detalhado, porque em situações futuras, pode ser necessário alterar um método e outro não,
por exemplo, pode acontecer do cliente querer que a lista devolva apenas 2 atributos, enquanto o método "encontrar pelo id" devolva todos os atributos.

## Validações

As validações (NotBlank) foram implementadas diretamente no DTO, se algum campo deles está vazio ou nulo, a API não vai nem receber.

## Tratamento de erros

A API também conta com tratador de erros, quando ocorre uma exception jogada pela própria API, ela devolve o código
HTTP 400 (Bad request), e a mensagem de erro, por exemplo ("Esse e-mail já foi cadastrado" ou "Esse ID não existe").

## Formato de data

O formato de data para a criação de tarefas é o brasileiro: `dd/MM/yyyy HH:mm`
```json
{
    "dataConclusao": "12/05/2023 18:00"
}
```

## Como usar?

A aplicação e o banco de dados já estão publicadas! Você apenas precisa acessar o link da documentação (Swagger), e fazer as requisições por lá, basta clicar [aqui](https://powerkrspringboot-production.up.railway.app/swagger-ui/index.html#/). Caso prefira, também pode usar o Postman ou Insomnia para fazer as requisições a partir do link: `https://powerkrspringboot-production.up.railway.app` com os endpoints disponibilizados abaixo.

Não se esqueça de se cadastrar/fazer login, e passar o token em todas as requisições autenticadas.

## Endpoints

### Usuarios:

- `/usuario/novo` - Método POST - Criar usuário

  ```json 
   {
    "nome": "Fulano",
    "email": "fulano@gmail.com",
    "senha": "teste123"
   }
  ```
- `/usuario/login` - Método POST - Efetuar Login

  ```json 
   {
    "email": "fulano@gmail.com",
    "senha": "teste123"
   }
  ```
- `/usuario` - Método GET - Listar usuários

- `/usuario/{id}` - Método GET - Buscar usuário por ID

- `/usuario/{id}` - Método PUT - Atualizar usuário
 - Todos os elementos são opcionais no método de atualização, você pode mudar apenas oque você quiser
 
   ```json 
    {
     "nome": "Fulano",
     "email": "fulano@gmail.com",
     "senha": "teste123"
    }
   ```
  
- `/usuario/{id}` - Método DELETE - Deletar usuário

### Tarefas:

- `/tarefa` - Método POST - Criar tarefa
 - Lembrando que o atributo "dataConclusao" é opcional!
   ```json 
    {
       "titulo": "Fazer compras",
       "descricao": "Comprar alimentos para a semana",
       "dataConclusao": "05/09/2023 19:00"
   }
   ```
- `/tarefa` - Método GET - Listar tarefas

- `/tarefa/{id}` - Método GET - Buscar tarefa por ID

- `/tarefa/{id}` - Método PUT - Atualizar tarefa
- Lembrando que, como no método atualizar usuário, aqui todos os itens são opcionais, você pode atualizar quantos atributos quiser.

   ```json 
    {
       "titulo": "Fazer compras",
       "descricao": "Comprar alimentos para a semana",
       "dataConclusao": "05/09/2023 19:00"
   }
   ```

- `/tarefa/{id}` - Método DELETE - Deletar tarefa

## Versões usadas

- PostgreSQL 15
- Springboot 3
- Java 17

