--CREATE DATABASE IFchannel;

CREATE TABLE usuario(
    id serial,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    sex CHARACTER(1),
    photo BYTEA,
    street VARCHAR(50),
    number VARCHAR(10),
    city VARCHAR(50),
    state CHARACTER(2),
    cep VARCHAR(15),
    phone VARCHAR(20),
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_email_key UNIQUE (email)
)