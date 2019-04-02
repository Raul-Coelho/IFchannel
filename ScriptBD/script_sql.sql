--CREATE DATABASE IFchannel;

CREATE TABLE usuario(
    id serial,
    matriculation VARCHAR(12) NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    gender CHARACTER(1),
    photo VARCHAR,
    street VARCHAR(50),
    number VARCHAR(10),
    city VARCHAR(50),
    state CHARACTER(2),
    cep VARCHAR(15),
    phone VARCHAR(20),
    privilege VARCHAR(25),
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_matriculation_pkey UNIQUE(matriculation),
    CONSTRAINT usuario_email_key UNIQUE (email)
);

CREATE TABLE post(
    id serial,
    title VARCHAR (50),
    video VARCHAR,
    evaluation float,
    description VARCHAR (140),
    userid int,
    exclusivity VARCHAR (10),
    lat FLOAT ,
    lng FLOAT ,
    CONSTRAINT  post_pkey PRIMARY KEY (id),
    CONSTRAINT  fkey_userid FOREIGN KEY(userid) REFERENCES usuario (id)
    );