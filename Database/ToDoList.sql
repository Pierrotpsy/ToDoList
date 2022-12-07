drop database if exists todolist;

create database todolist;

use todolist;

CREATE TABLE todos (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ID_UNIQUE` (`id` ASC) VISIBLE);
  
CREATE TABLE users (
  `name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(1000) NULL,
  PRIMARY KEY (`name`),
  UNIQUE INDEX `NAME_UNIQUE` (`name` ASC) VISIBLE);
  
CREATE TABLE roles (
  `name` VARCHAR(50) NOT NULL,
  `role` VARCHAR(1000) NULL,
  PRIMARY KEY (`name`),
  UNIQUE INDEX `NAME_UNIQUE` (`name` ASC) VISIBLE);
  
insert into todos value (1, 'test');
insert into todos value (2, 'tast');
insert into todos value (3, 'tost');
insert into todos value (4, 'tist');
insert into todos value (5, 'tust');

insert into users value ('Pierrotpsy', 'pass');
insert into roles value ('Pierrotpsy', 'Teacher');
insert into users value ('Chaton', 'p');
insert into roles value ('Chaton', 'Student');
  
drop user if exists 'test'@'localhost';
create user 'test'@'localhost' identified by 'password';
grant all PRIVILEGES ON todos TO 'test'@'localhost';
grant all PRIVILEGES ON users TO 'test'@'localhost';
grant all PRIVILEGES ON roles TO 'test'@'localhost';