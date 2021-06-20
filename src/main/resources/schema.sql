drop table if exists orders;
drop sequence if exists hibernate_sequence;

create table orders
(
    id      integer not null
        constraint order_pkey
            primary key,
    comment varchar(255),
    size    varchar(255),
    type    varchar(255)
);

create sequence hibernate_sequence start with 5;

