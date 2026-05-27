SELECT userID 사용자아이디, sum(amount) '총 구매 개수' FROM buytbl group by userID;

SELECT userID 사용자아이디, sum(price) '총 구매 액' FROM buytbl group by userID;

SELECT avg(amount) '평균 구매 개수' FROM buytbl;

select userID, avg(amount) '평균 구매 개수' from buytbl group by userID;

select name, height from usertbl where height = (select max(height) from usertbl) or height = (select min(height) from usertbl);

select count(mobile1) from usertbl;

select userID, sum(price) from buytbl group by userID;

select name, Population from city where CountryCode = 'KOR';

select min(city.Population) 최솟값 from city where CountryCode = 'KOR';

select avg(Population) from city where CountryCode = 'KOR';

select max(Population) 최대값 from city where CountryCode = 'KOR';

select name, CHAR_LENGTH(Name) 글자수 from country;

select concat(upper(left(name, 3)), substring(name,4)) from country;

select round(avg(country.LifeExpectancy), 0) from country;
-- truncate : 소숫점 자르기

select * from dept_manager where to_date = '9999-01-01';

select * from dept_manager where to_date = '9999-01-01' and dept_no = 'd005';

select * from employees order by hire_date desc limit 20 offset 140;

select count(emp_no) from dept_emp where to_date = '9999-01-01';

select avg(salary) from salaries where to_date = '9999-01-01';

select last_name from employees where emp_no in (select distinct emp_no from salaries where salary > (select avg(salary) from salaries where to_date = '9999-01-01'));

select dept_no, count(*) from dept_emp where to_date = '9999-01-01' group by dept_no order by dept_no;

