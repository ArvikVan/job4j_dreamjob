CREATE TABLE if not exists POST (
    id serial primary key,
    name text
);

create table if not exists candidate (
    id serial primary key,
    name text
);

CREATE TABLE if not exists users (
    id serial primary key,
    name text,
    email text,
    password text
);