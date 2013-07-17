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

delimiter $$

CREATE TABLE `PERSON` (
  `ID` int(11) NOT NULL auto_increment,
  `CREATE_DATE` timestamp NULL default NULL,
  `CREATED_BY` varchar(60) default NULL,
  `DELETE_DATE` timestamp NULL default NULL,
  `DELETED_BY` varchar(60) default NULL,
  `UPDATE_DATE` timestamp NULL default NULL,
  `UPDATED_BY` varchar(60) default NULL,
  `FIRSTNAME` varchar(45) default NULL,
  `LASTNAME` varchar(45) default NULL,
  `MIDDLENAME` varchar(45) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `IDENTIFICATION` (
  `id` int(11) NOT NULL auto_increment,
  `PERSON_ID` int(11) NOT NULL,
  `DATE_TIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `scans` (
  `id` int(11) NOT NULL auto_increment,
  `scan_date` timestamp NULL default CURRENT_TIMESTAMP,
  `data` blob,
  `CREATED_BY` varchar(60) default NULL,
  `DELETE_DATE` timestamp NULL default NULL,
  `DELETED_BY` varchar(60) default NULL,
  `ANGLE` int(11) default NULL,
  `PERSON_ID` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8$$

