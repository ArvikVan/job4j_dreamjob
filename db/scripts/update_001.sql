CREATE TABLE if not exists post (
    id serial primary key,
    name text
);

create table if not exists candidate (
    id serial primary key,
    name text
);

CREATE TABLE if not exists user (
    id serial primary key,
    name text,
    email text,
    password text
);