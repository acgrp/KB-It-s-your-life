show databases;

use employees;

show tables;

select * from employees;


select * from titles;

select first_name from titles;

select first_name, last_name, gender from titles;

select CONCAT(first_name, ' ',last_name) 이름, gender 성별, hire_date '회사 입사일' from employees;


select * from usertbl where name = '김경호';

select * from usertbl where birthYear >= 1970 and height >= 182;

select * from usertbl where height between 180 and 183;

select * from usertbl where addr in ('경남', '전남', '전북');

select * from usertbl where name like '김%';

select name, height from usertbl where height > (select height from usertbl where name = '김경호');

select * from usertbl order by mDate;

select * from usertbl order by mDate desc;

select * from usertbl order by height desc, name desc;

select distinct addr from usertbl order by addr;

select * from city where CountryCode = 'KOR' order by population desc;

select CountryCode, population from city order by CountryCode, population desc;

select count(CountryCode) from city where CountryCode = 'KOR';

select * from city where CountryCode in ('KOR', 'CHN', 'JPN');

select * from city where CountryCode = 'KOR' and Population >= 1000000;

select * from city where CountryCode = 'KOR' limit 10;

select * from city where CountryCode = 'KOR' and Population between 1000000 and 5000000;