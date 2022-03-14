create database Challenge3;

use Challenge3;

drop table employees;
create table employees(
id  int auto_increment primary key,
fname varchar(25) NOT NULL,
lastname varchar(25) NOT NULL,
salary int NOT NULL,
phone varchar(25) NOT NULL,
email varchar(25) NOT NULL,
 jobPos int NOT NULL,
state int NOT NULL,
since int NOT NULL
);
drop table states;
create table states(
id  int auto_increment primary key,
sname varchar(25) NOT NULL
);

drop table jobs;
create table jobs(
id  int auto_increment primary key,
pname varchar(25) NOT NULL
);

select fname, lastname, phone, email, jobPos, state 
from employees e
where e.salary >70000 and e.since >10 and e.since <15;

SELECT sname, state , AVG(salary) as "Salary Average"
    FROM employees e
  join states s on (s.id = e.state)
   GROUP BY state
   having (AVG(salary)>70000);
  


select * from states;
select * from employees;
select *from jobs;

insert into jobs (pname) value ("Ingenierio");
insert into jobs (pname) value ("Programador");
insert into jobs (pname) value ("Tecnico");

insert into states (sname) value ("Mar del plata");
insert into states (sname) value ("Tandil");
insert into states (sname) value ("marcos paz");
insert into states (sname) value ("bsas");
insert into states (sname) value ("madrid");