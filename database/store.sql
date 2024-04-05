create database TestModule3;
use TestModule3;
create table Staff(
                        ID int not null primary key auto_increment,
                        NAME varchar(250) not null,
                        EMAIL varchar(250) not null,
                        ADDRESS varchar(250) not null,
                        PHONENUMBER varchar(250) not null,
                        SALARY double not null,
                        IDDEPARTMENT int,
                        foreign key (IDDEPARTMENT) references DEPARTMENT(ID)
);
create table Department(
                         ID int not null primary key auto_increment,
                         NAME varchar(250) not null
);
select * from staff;
insert into staff(name, email , address, phonenumber, salary, idDepartment) values (?,?,?,?,?,?);
select * from staff where id=?;
UPDATE staff
SET name = ?, email = ?, address=?, phonenumber =?, salary =?, idDepartment = ?
WHERE id=?;
DELETE FROM staff WHERE id = ?;
select staff.*, d.name as nameDepartment from staff join Department d on d.id = staff.idDepartment;
select staff.*, d.name as nameDepartment from staff join department d on d.id = staff.idDepartment where staff.id=?;