-- eliminar todas as sessoes menos a principal
SELECT pg_terminate_backend(pid) 
   FROM pg_stat_activity 
  WHERE pid <> pg_backend_pid();

-- Exclui o banco de dados se ja estiver criado
DROP DATABASE sportsgo;

-- excluir usuario se ja criado
DROP USER usuario; 

-- Cria o banco de dados
CREATE DATABASE sportsgo
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = 1000;

-- conecta ao banco de dados
-- \c sportsgo postgres

-- cria  a tabela Usuario
CREATE TABLE public.usuario
(
    id serial not null,
    datacadastro date not null,
    nome varchar(40) not null,
    sobrenome varchar(60) not null,
    cpfcnpj varchar(20) not null,
    login varchar(60) not null,
    senha text not null,
    pessoajuridica boolean not null,
    pessoafisica boolean not null,
    PRIMARY KEY(id)
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.usuario
    OWNER to postgres;

-- cria  a tabela Endereco
CREATE TABLE public.endereco
(
    codendereco serial gint not null,
    logradouro varchar(100) not null,
    numero varchar(12) not null,
    complemento varchar(60),
    bairro varchar(60),
    cidade varchar(60) not null,
    estado varchar(60) not null,
    pais varchar(60) not null,
    cep varchar(15),
    id bigint not null,
    PRIMARY KEY(codendereco),
    CONSTRAINT ENDERECO_USUARIO_FK1 FOREIGN KEY (id)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.endereco
    OWNER to postgres;

-- cria  a tabela Telefone
CREATE TABLE public.telefone
(
    codpais varchar(7) not null,
    dddnumero varchar(15) not null,
    tipo varchar(15) not null,
    id bigint not null,
    PRIMARY KEY(codpais, dddnumero),
    CONSTRAINT TELEFONE_USUARIO_FK1 FOREIGN KEY (id)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.telefone
    OWNER to postgres;

-- cria  a tabela RedeSocial
CREATE TABLE public.redesocial
(
    nomerede varchar(50) not null,
    profile varchar(80) not null,
    id bigint not null,
    PRIMARY KEY(nomerede, profile),
    CONSTRAINT REDESOCIAL_USUARIO_FK1 FOREIGN KEY (id)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.redesocial
    OWNER to postgres;

-- cria  a tabela Email
CREATE TABLE public.email
(
    loginconta varchar(60) not null,
    notificacoes boolean not null,
    id bigint not null,
    PRIMARY KEY (loginconta, notificacoes, id),
    CONSTRAINT REDESOCIAL_USUARIO_FK1 FOREIGN KEY (id)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.email
    OWNER to postgres;

-- cria  a tabela Anuncio
CREATE TABLE public.anuncio
(
    codanuncio bigint not null,
    descricao varchar(250) not null,
    datainclusao date not null,
    datatermino date not null,
    precoevento numeric(7, 2),
    modalidade varchar(60),
    nrview integer,
    id bigint not null,
    PRIMARY KEY (codanuncio),
    CONSTRAINT ANUNCIO_USUARIO_FK1 FOREIGN KEY (id)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.anuncio
    OWNER to postgres;

-- cria  a tabela Anuncio_Alteracao
CREATE TABLE public.anuncio_alteracao
(
    data date not null,
    observacao varchar(60) not null,
    codanuncio bigint not null,
    PRIMARY KEY (data, observacao, codanuncio),
    CONSTRAINT ALTERACAO_ANUNCIO FOREIGN KEY (codanuncio)
        REFERENCES public.anuncio (codanuncio) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.anuncio_alteracao
    OWNER to postgres;

-- cria  a tabela Anuncio_DtEvento
CREATE TABLE public.anuncio_dtevento
(
    dataevento date not null,
    codanuncio bigint not null,
    PRIMARY KEY (dataevento, codanuncio),
    CONSTRAINT DATAEVENTO_ANUNCIO_FK1 FOREIGN KEY (codanuncio)
        REFERENCES public.anuncio (codanuncio) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.anuncio_dtevento
    OWNER to postgres;


-- cria  a tabela Anuncio_EndArquivo
CREATE TABLE public.anuncio_endarquivo
(
    enderecoarquivo varchar(120) not null,
    codanuncio bigint not null,
    PRIMARY KEY (enderecoarquivo, codanuncio),
    CONSTRAINT DATAEVENTO_ANUNCIO_FK1 FOREIGN KEY (codanuncio)
        REFERENCES public.anuncio (codanuncio) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.anuncio_endarquivo
    OWNER to postgres;


-- cria  a tabela Anuncio_Pendencia
CREATE TABLE public.anuncio_pendencia
(
    datainclusao date not null,
    descricao varchar(60) not null,
    solucao varchar(60) not null,
    datasolucao date not null,
    codanuncio bigint not null,
    PRIMARY KEY (datainclusao, descricao, solucao, datasolucao, codanuncio),
    CONSTRAINT PENDENCIA_ANUNCIO_FK1 FOREIGN KEY (codanuncio)
        REFERENCES public.anuncio (codanuncio) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.anuncio_pendencia
    OWNER to postgres;


-- cria  a tabela Anuncio_Status
CREATE TABLE public.anuncio_status
(
    dataalteracao date not null, 
    emanalise boolean not null,
    publicado boolean not null,
    bloqueado boolean not null,
    profissional boolean not null,
    statusalterado varchar(30) not null,
    codanuncio bigint not null,
    PRIMARY KEY (dataalteracao, emanalise, publicado, bloqueado, profissional, statusalterado, codanuncio),
    CONSTRAINT STATUS_ANUNCIO_FK1 FOREIGN KEY (codanuncio)
        REFERENCES public.anuncio (codanuncio) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.anuncio_status
    OWNER to postgres;


-- cria  a tabela Anuncio_Premium
CREATE TABLE public.anuncio_premium
(
    datainicio date not null,
    datatermino date not null,
    valor numeric(7,2) not null,
    codanuncio bigint not null,
    PRIMARY KEY (datainicio, datatermino, valor, codanuncio),
    CONSTRAINT PREMIUM_ANUNCIO_FK1 FOREIGN KEY (codanuncio)
        REFERENCES public.anuncio (codanuncio) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.anuncio_premium
    OWNER to postgres;

-- cria  a tabela Anuncio_Local
CREATE TABLE public.anuncio_local
(
    local varchar(120) not null,
    codanuncio bigint not null,
    PRIMARY KEY (local, codanuncio),
    CONSTRAINT LOCAL_ANUNCIO_FK1 FOREIGN KEY (codanuncio)
        REFERENCES public.anuncio (codanuncio) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);
ALTER TABLE public.anuncio_local
    OWNER to postgres;

-- criar usuario usuario
CREATE USER usuario WITH
	LOGIN
	NOSUPERUSER
	NOCREATEDB
	NOCREATEROLE
	INHERIT
	NOREPLICATION
	CONNECTION LIMIT 1000
	PASSWORD 'construcaosw';

-- conceder ao user usuario conexao ao BD sportsgo
GRANT CONNECT ON DATABASE sportsgo TO usuario;

-- concerder privilegios sobre o schema public ao user usuario
GRANT SELECT ON ALL TABLES IN SCHEMA public TO usuario;
GRANT INSERT ON ALL TABLES IN SCHEMA public TO usuario;
GRANT UPDATE ON ALL TABLES IN SCHEMA public TO usuario;
GRANT DELETE ON ALL TABLES IN SCHEMA public TO usuario;












