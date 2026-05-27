select u.*, b.*
from usertbl u
join buytbl b on u.userID = b.userID;

select u.*, b.*
from usertbl u
join buytbl b on u.userID = b.userID
where b.userID = 'JYP';

select u.userID, u.name, b.prodName, u.addr, concat(u.mobile1, u.mobile2) 연락처
from usertbl u
left outer join buytbl b on u.userID = b.userID
order by u.userID;

select * from usertbl
where mobile1 is not null and mobile2 is not null;

select * from usertbl
where mobile1 is null or mobile2 is null;

