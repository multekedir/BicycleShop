conn bicycle_shop_app/p4ssw0rd;

/*******************************************************************************
   Create Tables
********************************************************************************/
create table users
(
    "EmployeeID " number(10) generated as identity,
    "UserName"    varchar2(255) not null,
    "FirstName "  varchar2(255) not null,
    "LastName "   varchar2(255) not null,
    "Password"    varchar2(255) not null,
    "Role"        varchar2(100) not null
)
/

create unique index "USERS_EMPLOYEEID _UINDEX"
    on users ("EmployeeID ")
/

create unique index USERS_USERNAME_UINDEX
    on users ("UserName")
/

alter table users
    add constraint USERS_PK
        primary key ("EmployeeID ")
/

commit;
exit;