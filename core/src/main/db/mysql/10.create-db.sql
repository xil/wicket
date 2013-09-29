
    alter table PERSON 
        drop 
        foreign key FK_hfjruvja5peldg0o5hw7g0v51;

    alter table ROLE_TO_PERMISSION 
        drop 
        foreign key FK_rnherxb8242khbxdi27y022bb;

    alter table ROLE_TO_PERMISSION 
        drop 
        foreign key FK_lwwdu62jxvubui4annsb8uda6;

    alter table SCANNER_TASK 
        drop 
        foreign key FK_sb7ekumnbj0ee1wkkkaokuynp;

    alter table USER_TO_ROLES 
        drop 
        foreign key FK_ln9ev0ylplcc4mqjadqr0keoy;

    alter table USER_TO_ROLES 
        drop 
        foreign key FK_28ugs9imwewn8426ppkiq7amu;

    drop table if exists PERSON;

    drop table if exists ROLE_TO_PERMISSION;

    drop table if exists SCANNER_TASK;

    drop table if exists SEC_PERMISSION;

    drop table if exists SEC_ROLE;

    drop table if exists SEC_USER;

    drop table if exists USER_TO_ROLES;

    create table PERSON (
        ID bigint not null auto_increment,
        CREATE_DATE datetime,
        CREATED_BY varchar(60),
        DELETE_DATE datetime,
        DELETED_BY varchar(60),
        UPDATE_DATE datetime,
        UPDATED_BY varchar(60),
        VERSION integer,
        FIRSTNAME varchar(255),
        LASTNAME varchar(255),
        MIDDLENAME varchar(255),
        USER_ID bigint,
        primary key (ID)
    );

    create table ROLE_TO_PERMISSION (
        PERMISSION_ID bigint not null,
        ROLE_ID bigint not null
    );

    create table SCANNER_TASK (
        ID bigint not null auto_increment,
        CREATE_DATE datetime,
        CREATED_BY varchar(60),
        DELETE_DATE datetime,
        DELETED_BY varchar(60),
        UPDATE_DATE datetime,
        UPDATED_BY varchar(60),
        VERSION integer,
        REASON varchar(255),
        RESULT integer,
        PERSON_ID bigint,
        primary key (ID)
    );

    create table SEC_PERMISSION (
        ID bigint not null auto_increment,
        CREATE_DATE datetime,
        CREATED_BY varchar(60),
        DELETE_DATE datetime,
        DELETED_BY varchar(60),
        UPDATE_DATE datetime,
        UPDATED_BY varchar(60),
        VERSION integer,
        ACCESS boolean,
        PERMISSION_OBJECT varchar(255),
        primary key (ID)
    );

    create table SEC_ROLE (
        ID bigint not null auto_increment,
        CREATE_DATE datetime,
        CREATED_BY varchar(60),
        DELETE_DATE datetime,
        DELETED_BY varchar(60),
        UPDATE_DATE datetime,
        UPDATED_BY varchar(60),
        VERSION integer,
        DESCRIPTION longtext,
        NAME varchar(100),
        primary key (ID)
    );

    create table SEC_USER (
        ID bigint not null auto_increment,
        CREATE_DATE datetime,
        CREATED_BY varchar(60),
        DELETE_DATE datetime,
        DELETED_BY varchar(60),
        UPDATE_DATE datetime,
        UPDATED_BY varchar(60),
        VERSION integer,
        PASSWORD varchar(255),
        USERNAME varchar(255),
        primary key (ID)
    );

    create table USER_TO_ROLES (
        USER_ID bigint not null,
        ROLE_ID bigint not null
    );

    alter table PERSON 
        add index FK_hfjruvja5peldg0o5hw7g0v51 (USER_ID), 
        add constraint FK_hfjruvja5peldg0o5hw7g0v51 
        foreign key (USER_ID) 
        references SEC_USER (ID);

    alter table ROLE_TO_PERMISSION 
        add index FK_rnherxb8242khbxdi27y022bb (ROLE_ID), 
        add constraint FK_rnherxb8242khbxdi27y022bb 
        foreign key (ROLE_ID) 
        references SEC_ROLE (ID);

    alter table ROLE_TO_PERMISSION 
        add index FK_lwwdu62jxvubui4annsb8uda6 (PERMISSION_ID), 
        add constraint FK_lwwdu62jxvubui4annsb8uda6 
        foreign key (PERMISSION_ID) 
        references SEC_PERMISSION (ID);

    alter table SCANNER_TASK 
        add index FK_sb7ekumnbj0ee1wkkkaokuynp (PERSON_ID), 
        add constraint FK_sb7ekumnbj0ee1wkkkaokuynp 
        foreign key (PERSON_ID) 
        references PERSON (ID);

    alter table SEC_USER 
        add constraint UK_46psvtdbgrirs6s7ib5d3hs49 unique (USERNAME);

    alter table USER_TO_ROLES 
        add index FK_ln9ev0ylplcc4mqjadqr0keoy (ROLE_ID), 
        add constraint FK_ln9ev0ylplcc4mqjadqr0keoy 
        foreign key (ROLE_ID) 
        references SEC_ROLE (ID);

    alter table USER_TO_ROLES 
        add index FK_28ugs9imwewn8426ppkiq7amu (USER_ID), 
        add constraint FK_28ugs9imwewn8426ppkiq7amu 
        foreign key (USER_ID) 
        references SEC_USER (ID);
