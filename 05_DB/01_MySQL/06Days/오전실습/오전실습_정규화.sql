DROP DATABASE IF EXISTS normalization_lab;
CREATE DATABASE normalization_lab;
USE normalization_lab;

-- =====================================================
-- 0. 비정규형 예시
-- 한 칸에 여러 값이 들어간 상태
-- =====================================================

CREATE TABLE event_participation_unnormalized
(
    customer_id   VARCHAR(20),
    event_no      VARCHAR(100),
    win_yn        VARCHAR(100),
    grade         VARCHAR(20),
    discount_rate VARCHAR(10)
);

INSERT INTO event_participation_unnormalized
VALUES ('apple', 'E001,E005,E010', 'Y,N,Y', 'gold', '10%'),
       ('banana', 'E002,E005', 'N,Y', 'vip', '20%'),
       ('carrot', 'E003,E007', 'Y,Y', 'gold', '10%'),
       ('orange', 'E004', 'N', 'silver', '5%');

SELECT *
FROM event_participation_unnormalized;


-- =====================================================
-- 1. 제1정규형 1NF
-- 반복되는 값을 원자값으로 분리
-- 하지만 아직 중복과 이상 현상 존재
-- 기본키: customer_id + event_no
-- =====================================================

CREATE TABLE event_participation_1nf
(
    customer_id   VARCHAR(20),
    event_no      VARCHAR(10),
    win_yn        CHAR(1),
    grade         VARCHAR(20),
    discount_rate VARCHAR(10),
    PRIMARY KEY (customer_id, event_no)
);

INSERT INTO event_participation_1nf
VALUES ('apple', 'E001', 'Y', 'gold', '10%'),
       ('apple', 'E005', 'N', 'gold', '10%'),
       ('apple', 'E010', 'Y', 'gold', '10%'),
       ('banana', 'E002', 'N', 'vip', '20%'),
       ('banana', 'E005', 'Y', 'vip', '20%'),
       ('carrot', 'E003', 'Y', 'gold', '10%'),
       ('carrot', 'E007', 'Y', 'gold', '10%'),
       ('orange', 'E004', 'N', 'silver', '5%');

SELECT *
FROM event_participation_1nf;


-- 1NF 문제 확인: apple의 등급을 일부만 수정하면 갱신 이상 발생
UPDATE event_participation_1nf
SET grade = 'vip'
WHERE customer_id = 'apple'
  AND event_no = 'E001';

SELECT *
FROM event_participation_1nf
WHERE customer_id = 'apple';


-- 실습 복구
UPDATE event_participation_1nf
SET grade = 'gold'
WHERE customer_id = 'apple';


-- =====================================================
-- 2. 제2정규형 2NF
-- 부분 함수 종속 제거
-- customer_id -> grade, discount_rate 분리
-- customer_id + event_no -> win_yn 유지
-- =====================================================

CREATE TABLE customer_2nf
(
    customer_id   VARCHAR(20) PRIMARY KEY,
    grade         VARCHAR(20),
    discount_rate VARCHAR(10)
);

CREATE TABLE event_participation_2nf
(
    customer_id VARCHAR(20),
    event_no    VARCHAR(10),
    win_yn      CHAR(1),
    PRIMARY KEY (customer_id, event_no),
    FOREIGN KEY (customer_id) REFERENCES customer_2nf (customer_id)
);

INSERT INTO customer_2nf
VALUES ('apple', 'gold', '10%'),
       ('banana', 'vip', '20%'),
       ('carrot', 'gold', '10%'),
       ('orange', 'silver', '5%');

INSERT INTO event_participation_2nf
VALUES ('apple', 'E001', 'Y'),
       ('apple', 'E005', 'N'),
       ('apple', 'E010', 'Y'),
       ('banana', 'E002', 'N'),
       ('banana', 'E005', 'Y'),
       ('carrot', 'E003', 'Y'),
       ('carrot', 'E007', 'Y'),
       ('orange', 'E004', 'N');

SELECT *
FROM customer_2nf;
SELECT *
FROM event_participation_2nf;


-- 2NF 조인 결과
SELECT c.customer_id,
       e.event_no,
       e.win_yn,
       c.grade,
       c.discount_rate
FROM customer_2nf c
         JOIN event_participation_2nf e
              ON c.customer_id = e.customer_id
ORDER BY c.customer_id, e.event_no;


-- =====================================================
-- 3. 제3정규형 3NF
-- 이행적 함수 종속 제거
-- customer_id -> grade
-- grade -> discount_rate
-- 따라서 grade와 discount_rate를 별도 테이블로 분리
-- =====================================================

CREATE TABLE grade_3nf
(
    grade         VARCHAR(20) PRIMARY KEY,
    discount_rate VARCHAR(10)
);

CREATE TABLE customer_3nf
(
    customer_id VARCHAR(20) PRIMARY KEY,
    grade       VARCHAR(20),
    FOREIGN KEY (grade) REFERENCES grade_3nf (grade)
);

CREATE TABLE event_participation_3nf
(
    customer_id VARCHAR(20),
    event_no    VARCHAR(10),
    win_yn      CHAR(1),
    PRIMARY KEY (customer_id, event_no),
    FOREIGN KEY (customer_id) REFERENCES customer_3nf (customer_id)
);

INSERT INTO grade_3nf
VALUES ('gold', '10%'),
       ('vip', '20%'),
       ('silver', '5%');

INSERT INTO customer_3nf
VALUES ('apple', 'gold'),
       ('banana', 'vip'),
       ('carrot', 'gold'),
       ('orange', 'silver');

INSERT INTO event_participation_3nf
VALUES ('apple', 'E001', 'Y'),
       ('apple', 'E005', 'N'),
       ('apple', 'E010', 'Y'),
       ('banana', 'E002', 'N'),
       ('banana', 'E005', 'Y'),
       ('carrot', 'E003', 'Y'),
       ('carrot', 'E007', 'Y'),
       ('orange', 'E004', 'N');

SELECT *
FROM grade_3nf;
SELECT *
FROM customer_3nf;
SELECT *
FROM event_participation_3nf;


-- 3NF 최종 조인 결과
SELECT c.customer_id,
       e.event_no,
       e.win_yn,
       c.grade,
       g.discount_rate
FROM customer_3nf c
         JOIN event_participation_3nf e
              ON c.customer_id = e.customer_id
         JOIN grade_3nf g
              ON c.grade = g.grade
ORDER BY c.customer_id, e.event_no;