-- 기존 DB 삭제 후 새로 생성
DROP DATABASE IF EXISTS SQLDB;
CREATE DATABASE SQLDB;
USE SQLDB;

-- =========================
-- DDL : buytbl 테이블 생성
-- =========================
DROP TABLE IF EXISTS buytbl;

CREATE TABLE buytbl (
                        num INT AUTO_INCREMENT PRIMARY KEY,
                        userID CHAR(8) NOT NULL,
                        prodName VARCHAR(20) NOT NULL,
                        groupName VARCHAR(20),
                        price INT NOT NULL,
                        amount INT NOT NULL
);

-- =========================
-- DML : buytbl 데이터 입력
-- =========================
INSERT INTO buytbl (userID, prodName, groupName, price, amount)
VALUES
    ('KBS', '운동화', '의류', 30, 2),
    ('KBS', '노트북', '전자', 1000, 1),
    ('JYP', '모니터', '전자', 200, 1),
    ('BBK', '청바지', '의류', 50, 3),
    ('EJW', '책', '서적', 15, 5),
    ('SSK', '마우스', '전자', 20, 2),
    ('LJB', '커피', '식품', 5, 10),
    ('YJS', '키보드', '전자', 80, 1);

-- 데이터 확인
SELECT * FROM buytbl;

-- =========================
-- 트랜잭션 실습 -1
-- =========================
START TRANSACTION;

DELETE FROM buytbl WHERE num = 1;
DELETE FROM buytbl WHERE num = 2;

-- 삭제된 상태 확인
SELECT * FROM buytbl;

-- 삭제 취소
ROLLBACK;

-- 원상복구 확인
SELECT * FROM buytbl;

-- =========================
-- 트랜잭션 실습 -2
-- =========================
START TRANSACTION;

DELETE FROM buytbl WHERE num = 1;
DELETE FROM buytbl WHERE num = 2;

-- 삭제된 상태 확인
SELECT * FROM buytbl;

-- 삭제 반영
COMMIT;

-- 확인
SELECT * FROM buytbl;