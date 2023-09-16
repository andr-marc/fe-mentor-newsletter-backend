create schema if not exists newsletter;

create table if not exists newsletter.inscricao(
     id serial primary key,
     email varchar unique not null
);