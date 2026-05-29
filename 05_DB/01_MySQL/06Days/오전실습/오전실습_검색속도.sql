-- =========================================================
-- MySQL 8 인덱스 검색 속도 비교 실습
-- CTE 없이 대량 데이터 넣기
-- =========================================================

DROP DATABASE IF EXISTS index_test_simple;
CREATE DATABASE index_test_simple;
USE index_test_simple;

-- ---------------------------------------------------------
-- 1. 숫자 생성용 테이블
-- 0 ~ 9까지 숫자만 넣어둠
-- ---------------------------------------------------------

CREATE TABLE num (
                     n INT
);

INSERT INTO num VALUES
                    (0), (1), (2), (3), (4), (5), (6), (7), (8), (9);


-- ---------------------------------------------------------
-- 2. PK 없는 테이블
-- ---------------------------------------------------------

CREATE TABLE member_no_pk (
                              member_id INT NOT NULL,
                              member_name VARCHAR(30),
                              email VARCHAR(100),
                              address VARCHAR(20)
) ENGINE=InnoDB;


-- ---------------------------------------------------------
-- 3. PK 있는 테이블
-- ---------------------------------------------------------

CREATE TABLE member_pk (
                           member_id INT NOT NULL PRIMARY KEY,
                           member_name VARCHAR(30),
                           email VARCHAR(100),
                           address VARCHAR(20)
) ENGINE=InnoDB;


-- ---------------------------------------------------------
-- 4. 대량 데이터 한꺼번에 넣기
-- 10 x 10 x 10 x 10 x 10 = 100,000건
-- ---------------------------------------------------------

INSERT INTO member_no_pk
(member_id, member_name, email, address)
SELECT
    a.n * 10000 + b.n * 1000 + c.n * 100 + d.n * 10 + e.n + 1 AS member_id,
    CONCAT('회원', a.n * 10000 + b.n * 1000 + c.n * 100 + d.n * 10 + e.n + 1) AS member_name,
    CONCAT('user', a.n * 10000 + b.n * 1000 + c.n * 100 + d.n * 10 + e.n + 1, '@test.com') AS email,
    CASE
        WHEN e.n IN (0, 1) THEN '서울'
        WHEN e.n IN (2, 3) THEN '부산'
        WHEN e.n IN (4, 5) THEN '대구'
        WHEN e.n IN (6, 7) THEN '인천'
        ELSE '광주'
        END AS address
FROM num a
         CROSS JOIN num b
         CROSS JOIN num c
         CROSS JOIN num d
         CROSS JOIN num e;

select count(*) as row수 from member_no_pk;

-- PK 테이블에도 같은 데이터 복사
INSERT INTO member_pk
SELECT *
FROM member_no_pk;

select count(*) as row수 from member_pk;

-- 통계 갱신
ANALYZE TABLE member_no_pk;
ANALYZE TABLE member_pk;


-- ---------------------------------------------------------
-- 5. 데이터 개수 확인
-- ---------------------------------------------------------

SELECT COUNT(*) AS no_pk_count FROM member_no_pk;
SELECT COUNT(*) AS pk_count FROM member_pk;

-- =========================================
-- no pk
-- =========================================

-- 1	SIMPLE	member_no_pk		ALL	99675	10.00	Using where
-- member_id = 90000 찾기
-- ↓
-- member_id에 인덱스 없음
-- ↓
-- 처음부터 끝까지 전부 확인
-- ↓
-- 전체 테이블 탐색

EXPLAIN
SELECT *
FROM member_no_pk
WHERE member_id = 90000;


-- =========================================
-- pk
-- =========================================

-- 1	SIMPLE	member_pk	const	PRIMARY	PRIMARY	4	const	1	100.00
-- member_id = 90000 찾기
-- ↓
-- PRIMARY KEY 인덱스 사용
-- ↓
-- B+Tree로 빠르게 이동
-- ↓
-- 해당 행 찾기

EXPLAIN
SELECT *
FROM member_pk
WHERE member_id = 90000;

-- =========================================
-- no secondary index(보조 인덱스 없음)
-- =========================================
-- 1	SIMPLE	member_pk		ALL		100198	10.00	Using where
-- email = 'user90000@test.com' 찾기
-- ↓
-- email 인덱스 없음
-- ↓
-- 모든 행의 email 값을 하나씩 비교
-- ↓
-- 전체 테이블 탐색

EXPLAIN
SELECT *
FROM member_pk
WHERE email = 'user90000@test.com';

-- =========================================
-- secondary index(보조 인덱스 생성)
-- =========================================
CREATE INDEX idx_member_email
    ON member_pk(email);

ANALYZE TABLE member_pk;

show index from member_pk;

-- 1	SIMPLE	member_pk  ref	idx_member_email	403	const	1	100.00
EXPLAIN
SELECT *
FROM member_pk
WHERE email = 'user90000@test.com';

-- PK 없음 : 찾을 기준표가 없어서 전체를 뒤짐
-- PK 있음 : 기본키 인덱스로 빠르게 찾음
-- 보조 인덱스 없음 : PK가 있어도 다른 컬럼 검색은 느릴 수 있음
-- 보조 인덱스 있음 : 해당 컬럼용 찾아보기 표가 생겨서 빨라짐