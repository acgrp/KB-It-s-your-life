drop table usertbl;
drop table buytbl;

create table usertbl(
    userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null,
    addr char(2) not null,
    mobile1 char(3),
    mobile2 char(8),
    height smallint,
    mDate DATE
);

create table buytbl(
    num int not null primary key auto_increment,
    userID char(8) not null ,
    prodName char(6) not null,
    groupName char(4),
    price int not null,
    amount smallint not null,
    foreign key (userID) references usertbl(userID)
);

insert into usertbl(userID, name, birthyear, addr, mobile1, mobile2, height, mDate)
values ('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-08-08'),
       ('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-04-04'),
       ('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-07-07');

insert into buytbl(userid, prodname, groupname, price, amount)
values('KBS', '운동화', NULL, 30, 2),
      ('KBS', '노트북', '전자', 1000, 1),
      ('JYP', '모니터', '전자', 200, 1); -- JYP가 없음

drop table usertbl;

DROP TABLE IF EXISTS usertbl; -- 기존 테이블이 존재하면 삭제

CREATE TABLE usertbl (
                         userID CHAR(8) NOT NULL,      -- 고정문자(8), 필수
                         name VARCHAR(10) NOT NULL,    -- 가변문자(10), 필수
                         birthyear INT NOT NULL,       -- 정수, 필수

    -- 기본키를 테이블 레벨에서 정의하고 제약조건명 지정
                         CONSTRAINT pk_usertbl PRIMARY KEY (userID)
);

-- 2. prodTbl 정의
DROP TABLE IF EXISTS prodTbl; -- 기존 테이블이 존재하면 삭제

CREATE TABLE prodTbl (
                         prodCode CHAR(3) NOT NULL,    -- 고정문자(3), 필수
                         prodID CHAR(4) NOT NULL,      -- 고정문자(4), 필수
                         prodDate DATETIME NOT NULL,   -- 날짜시간, 필수
                         proCur CHAR(10) NULL,         -- 고정문자(10), 옵션 (NULL 허용)

    -- 기본키가 2개(prodCode, prodID)이므로 테이블 레벨에서 복합키로 지정
                         PRIMARY KEY (prodCode, prodID)
);

create view usertbl_buytbl as
    select u.userid, name, prodName, addr, concat(mobile1, mobile2) 연락처
from usertbl u
join buytbl b on u.userID = b.userID;

SELECT * FROM usertbl_buytbl WHERE name = '김범수';