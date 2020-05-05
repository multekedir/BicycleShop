-- DROP USER bicycle_shop_app CASCADE;

-- CREATE USER bicycle_shop_app
--     IDENTIFIED BY p4ssw0rd
--     DEFAULT TABLESPACE users
--     TEMPORARY TABLESPACE temp
--     QUOTA 10 M ON users;
--
-- GRANT connect to bicycle_shop_app;
-- GRANT resource to bicycle_shop_app;
-- GRANT create session TO bicycle_shop_app;
-- GRANT create table TO bicycle_shop_app;
-- GRANT create view TO bicycle_shop_app;


conn bicycle_shop_app/p4ssw0rd;

/*******************************************************************************
   Create Tables
********************************************************************************/
create table users
(
    id         number(10) generated as identity,
    user_name  varchar2(255) not null,
    first_name varchar2(255) not null,
    last_name  varchar2(255) not null,
    password   varchar2(255) not null,
    role       varchar2(100) not null
)
/

create unique index "USERS_EMPLOYEEID _UINDEX"
    on users (id)
/

create unique index USERS_USERNAME_UINDEX
    on users (user_name)
/

alter table users
    add constraint USERS_PK
        primary key (id)
/


create table bicycles
(
    ID    int generated as identity,
    NAME  VARCHAR2(25) not null,
    COST  NUMBER       not null,
    OWNER int
        constraint OWNER
            references USERS
)
/

create unique index BICYCLES_ID_UINDEX
    on bicycles (ID)
/

alter table bicycles
    add constraint BICYCLES_PK
        primary key (ID)
/

create table offers
(
    user_id    int
        constraint OFFERS_USERS_ID_FK
            references USERS
                on delete set null,
    bicycle_id int
        constraint OFFERS_BICYCLES_ID_FK
            references BICYCLES
                on delete set null,
    amount     Number not null,
    status     varchar2(10) default null
)
/


commit;
exit;