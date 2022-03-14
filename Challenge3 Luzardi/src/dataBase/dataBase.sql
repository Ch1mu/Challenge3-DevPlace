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
since date NOT NULL
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

select fname, lastname, phone, email, sname, pname 
from employees e 
left join states s on (e.state = s.id)
left join jobs j on (e.jobPos = j.id)
where e.salary >70000 and (15> NOW() - YEAR(e.since) >10 );
