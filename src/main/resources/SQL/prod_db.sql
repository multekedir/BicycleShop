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

commit;
exit;