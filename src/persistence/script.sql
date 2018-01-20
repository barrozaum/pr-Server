drop database if exists aula;
create database aula;
use aula;

 create table produto(id int primary key auto_increment,nome varchar (50),
 preco double);
 
  insert into produto values (100,'macaquinho',100.);
  insert into produto values (101,'vacina',200.);
  insert into produto values (102,'flauta',300.);
  
  select * from produto;



