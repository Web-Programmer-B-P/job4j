create table if not exists accident
(
    id          serial not null
        constraint accident_pkey
            primary key,
    name        varchar(100),
    description text,
    address     varchar(200)
);