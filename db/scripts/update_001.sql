CREATE TABLE if not exists POST (
    id serial primary key,
    name text,
    description text,
    created timestamp
);

create table if not exists candidate (
    id serial primary key,
    name text,
    city_id integer,
    created timestamp
);

CREATE TABLE if not exists users (
    id serial primary key,
    name text,
    email text,
    password text
);
create table if not exists city (
    id serial primary key,
    name text
);

