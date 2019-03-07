--liquibase formatted sql

--changeset paulohfcanuto:1
CREATE TABLE DEMO.PRODUTOS (
  ID UUID NOT NULL CONSTRAINT PK_PRODUTOS PRIMARY KEY,
  NOME VARCHAR(255) NOT NULL,
  PRECO FLOAT8 NOT NULL
);
--rollback DROP TABLE PRODUTOS;

--changeset paulohfcanuto:2
COMMENT ON TABLE DEMO.PRODUTOS IS 'Produtos';
COMMENT ON COLUMN DEMO.PRODUTOS.ID IS 'Id do produto';
COMMENT ON COLUMN DEMO.PRODUTOS.NOME IS 'Nome do produto';
--rollback not required;


--changeset paulohfcanuto:3
GRANT SELECT, INSERT, UPDATE, DELETE ON DEMO.PRODUTOS TO DEMO_API_SYSTEM;
--rollback not required;