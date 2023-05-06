CREATE TYPE status_enum AS ENUM ('ABERTA', 'FECHADA');

CREATE DOMAIN status_domain AS varchar(255);
CREATE CAST (status_domain AS status_enum) WITH INOUT AS IMPLICIT;

CREATE TABLE tarefas (

   id SERIAL PRIMARY KEY,
   titulo VARCHAR(255) NOT NULL,
   descricao TEXT NOT NULL,
   data_criacao TIMESTAMP NOT NULL,
   data_conclusao TIMESTAMP,
   status status_domain NOT NULL

);
