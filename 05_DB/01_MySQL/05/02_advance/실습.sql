create table userTBL
(
    userID    char(8)     not null primary key,
    name      varchar(10) not null,
    birthyear int         not null
);

create table buytbl
(
    num      int     not null primary key auto_increment,
    userID   char(8) not null,
    prodName char(6) not null,

    foreign key (userID) references userTBL(userID)
);

drop table buytbl, userTBl;

create table userTBL
(
    userID    char(8)     not null primary key,
    name      varchar(10) not null,
    birthyear int         not null,
    email     char(30) unique
);

drop table userTBL;

create table userTBL
(
    userID    char(8) not null primary key,
    name      varchar(10),
    birthYear int check ( birthYear >= 1900 && birthYear <= 2023 ),
    mobile    char(3) not null
);
drop table userTBL;

CREATE TABLE userTBL
(
    userID    CHAR(8)     NOT NULL PRIMARY KEY,  -- 고정문자(8), 필수, 기본키
    name      VARCHAR(10) NOT NULL,              -- 가변문자(10), 필수
    birthYear INT         NOT NULL DEFAULT -1,   -- 정수, 필수, 기본값 -1
    addr      CHAR(2)     NOT NULL DEFAULT '서울', -- 고정문자(2), 필수, 기본값 '서울'
    mobile1   CHAR(3)     NULL,                  -- 고정문자(3), 옵션
    mobile2   CHAR(8)     NULL,                  -- 고정문자(8), 옵션
    height    SMALLINT             DEFAULT 170,  -- 작은 정수, 옵션, 기본값 170
    mDate     DATE        NULL                   -- 날짜, 옵션
);

alter table userTBL drop column mobile1;

alter table userTBL rename column name to uName;

alter table userTBL drop primary key;

create view EMPLOYEES_INFO as
select e.emp_no, birth_date, first_name, last_name, gender, hire_date, t.title, t.from_date t_from, t.to_date t_to, s.salary, s.from_date s_from,s.to_date s_to
from employees e
         join titles t on e.emp_no = t.emp_no
         join salaries s on e.emp_no = s.emp_no;

select * from EMPLOYEES_INFO where s_to = '9999_01-01';

create view EMP_DEPT_INFO as
select e.emp_no, d.dept_no, p.dept_name, from_date, to_date
from employees e
         join dept_emp d on e.emp_no = d.emp_no
         join departments p on d.dept_no = p.dept_no;

select * from EMP_DEPT_INFO where to_date = '9999_01_01';