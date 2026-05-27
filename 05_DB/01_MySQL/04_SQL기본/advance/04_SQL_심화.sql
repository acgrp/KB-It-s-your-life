select s.stdName '학생 이름', s.addr '지역', c.clubName '가입한 동아리',c.roomNo '동아리방'
from stdtbl s
join stdclubtbl sc on s.stdName = sc.stdName
join clubtbl c on sc.clubName = c.clubName
;

select c.clubName, c.roomNo, s.stdName, s.addr from clubtbl c
join stdclubtbl sc on c.clubName = sc.clubName
join stdtbl s on s.stdName = sc.stdName;

select a.emp 부하직원, a.manager 직속상관, b.empTel 직속상관연락처
from emptbl a
join emptbl b on a.manager = b.emp
where a.emp = '우대리';

select e.emp_no, e.first_name, e.last_name, t.title from employees e
join titles t on e. emp_no = t.emp_no
WHERE t.to_date = '9999-01-01';

select e.emp_no, birth_date, first_name, last_name, gender, hire_date, t.title, s.salary from employees e
join titles t on e.emp_no = t.emp_no
join salaries s on e.emp_no = s.emp_no
WHERE t.to_date = '9999-01-01';

select e.emp_no, first_name, last_name, p.dept_name from employees e
join dept_emp d on e.emp_no = d.emp_no
join departments p on d.dept_no = p.dept_no
WHERE d.to_date = '9999-01-01'
order by e.emp_no;

select p.dept_no, p.dept_name, count(*) from employees e
join dept_emp d on e.emp_no = d.emp_no
join departments p on d.dept_no = p.dept_no
WHERE d.to_date = '9999-01-01'
group by d.dept_no;


select e.emp_no, e.first_name, e.last_name, p.dept_name, m.from_date, m.to_date
from employees e
join dept_emp m on e.emp_no = m.emp_no
join departments p on p.dept_no = m.dept_no
where e.emp_no = 10209;