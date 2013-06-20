drop table if exists CONTACTS;

create table CONTACTS (
  ID binary(16) not null,
  CREATE_DATE date,
  CREATED_BY varchar(60),
  DELETE_DATE date,
  DELETED_BY varchar(60),
  UPDATE_DATE date,
  UPDATED_BY varchar(60),
  EMAIL varchar(255),
  FIRSTNAME varchar(255),
  LASTNAME varchar(255),
  TELEPHONE varchar(255),
  primary key (ID)
);

drop table if exists PERSON;

create table PERSON (
  ID binary(16) not null,
  CREATE_DATE date,
  CREATED_BY varchar(60),
  DELETE_DATE date,
  DELETED_BY varchar(60),
  UPDATE_DATE date,
  UPDATED_BY varchar(60),
  DEPARTMENT_ID varchar(255),
  EXPDATE varchar(255),
  FIRSTNAME varchar(255),
  LASTNAME varchar(255),
  MIDDLENAME varchar(255),
  PHOTO longblob,
  REGDATE varchar(255),
  primary key (ID)
);