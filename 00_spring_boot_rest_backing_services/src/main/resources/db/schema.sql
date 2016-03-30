drop table if exists utenti  

create table utenti(
      id int not null primary key,
      name varchar(50) not null,
      author varchar(50) not null,
      price int);
