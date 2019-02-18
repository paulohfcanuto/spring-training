--liquibase formatted sql


--changeset paulohfcanuto:1
CREATE SCHEMA IF NOT EXISTS DEMO;
--rollback DROP SCHEMA DEMO


--changeset paulohfcanuto:2
GRANT USAGE ON SCHEMA DEMO TO DEMO_API_SYSTEM;
--rollback not required;


--changeset paulohfcanuto:3
CREATE EXTENSION IF NOT EXISTS "uuid-ossp" SCHEMA DEMO;
--rollback not required;


--changeset paulohfcanuto:4
CREATE TABLE DEMO.CATEGORIAS (
  ID UUID NOT NULL CONSTRAINT PK_CATEGORIAS PRIMARY KEY,
  NOME VARCHAR(255) NOT NULL
);
--rollback DROP TABLE CATEGORIAS;


--changeset paulohfcanuto:5
COMMENT ON TABLE DEMO.CATEGORIAS IS 'Categorias';
COMMENT ON COLUMN DEMO.CATEGORIAS.ID IS 'Id da categoria';
COMMENT ON COLUMN DEMO.CATEGORIAS.NOME IS 'Nome da categoria';
--rollback not required;


--changeset paulohfcanuto:6
GRANT SELECT, INSERT, UPDATE, DELETE ON DEMO.CATEGORIAS TO DEMO_API_SYSTEM;
--rollback not required;