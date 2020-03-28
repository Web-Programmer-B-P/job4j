create table if not exists engines
(
    id   serial not null
        constraint engines_pk
            primary key,
    type varchar(200)
);

create table if not exists car
(
    id        serial not null
        constraint car_pk
            primary key,
    name      varchar(100),
    engine_id integer
        constraint car_fk
            references engines
);

create table if not exists drivers
(
    id   serial not null
        constraint drivers_pk
            primary key,
    name varchar(200)
);

create table if not exists cars_drivers
(
    id        serial not null
        constraint cars_drivers_pk
            primary key,
    car_id    integer
        constraint car_fk
            references car,
    driver_id integer
        constraint driver_fk
            references drivers
);

