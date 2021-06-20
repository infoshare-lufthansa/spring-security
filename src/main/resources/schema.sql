drop table if exists orders;
drop table if exists order_user;
drop sequence if exists hibernate_sequence;

create table order_user
(
    id       int not null primary key,
    age      integer,
    email    varchar(255),
    role     varchar(255),
    password varchar(255)
);

create table orders
(
    id      integer not null
        constraint order_pkey
            primary key,
    comment varchar(255),
    size    varchar(255),
    type    varchar(255),
    user_id integer not null,
    constraint user_fkey foreign key (user_id)
        references order_user(id)
);

create sequence hibernate_sequence start with 7;

