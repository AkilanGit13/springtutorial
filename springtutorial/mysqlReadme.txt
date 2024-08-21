--used this command in mysql workbench to create user and grant all permissions to user after creating a connection

create database productservice;
use productservice;
create user productserviceuser;
grant all privileges on productservice.* to productserviceuser;