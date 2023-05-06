CREATE TYPE status_enum AS ENUM ('ABERTA', 'FECHADA');

CREATE TABLE tarefas (

   id SERIAL PRIMARY KEY,
   titulo VARCHAR(255) NOT NULL,
   descricao TEXT NOT NULL,
   data_criacao TIMESTAMP NOT NULL,
   data_conclusao TIMESTAMP,
   status status_enum NOT NULL

);
