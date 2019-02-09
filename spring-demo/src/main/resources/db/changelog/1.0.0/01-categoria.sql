--liquibase formatted sql

--changeset paulohfcanuto:1
CREATE TABLE CATEGORIA (
  ID INT8 NOT NULL,
  NOME VARCHAR(255) NOT NULL,
  CONSTRAINT PK_CATEGORIA PRIMARY KEY (ID)
);
--rollback DROP TABLE CATEGORIA;

--changeset paulohfcanuto:2
CREATE SEQUENCE CATEGORIA_SEQUENCE START 1 INCREMENT 1;
--rollback DROP SEQUENCE CATEGORIA_SEQUENCE;

--changeset paulohfcanuto:3
REVOKE ALL ON SCHEMA demo FROM demo_system;
GRANT USAGE ON SCHEMA demo TO demo_system WITH GRANT OPTION;
--rollback not required;