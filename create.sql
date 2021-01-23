create table security.users
(
    id      bigserial not null
        constraint users_pk
            primary key,
    login   text      not null,
    name    text      not null,
    surname text      not null,
    email   text      not null
);

alter table security.users
    owner to postgres;

create unique index users_login_uindex
    on security.users (login);

