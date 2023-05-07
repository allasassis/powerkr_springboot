# PowerKR API

API Restful com Java e Springboot para a 2ª etapa do processo seletivo da PowerKR.

## Versão recomendada

- PostgreSQL 15

## Como configurar a aplicação

- Criar uma database no banco de dados e substituir no `application.properties`
- Dentro de um server, criar uma database chamada `powerkr`
- URL do banco de dados = `jdbc:postgresql://localhost:5432/powerkr`
- Por padrão, o usuário do banco de dados é chamado de `postgres`

## DTOs

Todas os controladores contam com entradas de dados na saída e na entrada.
Optei por criar uma classe DTO para lista e outra para o objeto detalhado, porque em situações futuras, pode ser necessário alterar um método e outro não,
por exemplo, pode acontecer do cliente querer que a lista devolva apenas 2 atributos, enquanto o método "encontrar pelo id" devolva todos os atributos.

## Validações

As validações (NotBlank) foram implementadas diretamente no DTO, se algum campo deles está vazio ou nulo, a API não vai receber.

## Tratamento de erros

A API também conta com tratador de erros, quando ocorre uma exception jogada pela própria API, ela devolve o código
HTTP 400 (Bad request), e a mensagem de erro, exemplo ("Esse e-mail já foi cadastrado" ou "Esse ID não existe").

## Senhas

Todas as senhas são criptografadas no banco de dados, foi usado o algoritmo BCrypt.

## Métodos que não precisam de autenticação

Todos os endpoints e métodos precisam de autenticação para serem usados, menos os métodos de cadastrar usuário e efetuar login,
 que devem permitir o usuário enviar as credenciais.

## Tempo de expiração do token JWT

O Token JWT dura 2 horas, após esse tempo ele é invalidado e não funciona mais.

## Atualização do e-mail

Caso você atualize o e-mail, terá que fazer o login novamente e gerar outro token.

## UserDetailsService

Classe `Usuario` e `UsuarioService` implementa a interface `UserDetailsService` 
do Spring Security, que é uma boa prática para delegar a autenticação e autorização de usuários para o framework de segurança.

## Formato de data

O formato de data para a criação de tarefas é o brasileiro: `dd/MM/yyyy HH:mm`
```
{
    "titulo": "Fazer compras",
    "descricao": "Comprar alimentos para a semana",
    "dataConclusao": "12/05/2023 18:00"
}
