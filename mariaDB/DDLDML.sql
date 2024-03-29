/* database DDL
create database NAME
drop datebase NAME
*/
USE hr;
DESC employees;

# table 구조 복사 (전체 column만, row는 없음)
CREATE TABLE sample_emp LIKE employees;
DESC sample_emp;
SELECT * FROM sample_emp;

# table 전체 복사 ( 선택한 column, row 모두)
CREATE TABLE temp_emp(
	SELECT employee_id, first_name, salary
	FROM employees
);
DESC temp_emp;
SELECT * FROM temp_emp;


# table 구조 복사 (선택한 column만, row는 없음)
CREATE TABLE part_emp(
	SELECT employee_id, first_name, hire_date, salary
	FROM employees
	WHERE 1=0
);
DESC part_emp;
SELECT * FROM part_emp;

# where 1=1 이면 row도 모두 가져온다 
CREATE TABLE part2_emp(
	SELECT employee_id, first_name, hire_date, salary
	FROM employees
	WHERE 1=1
);
SELECT * FROM part2_emp;


# 구조복사한 테이블에 row를 선택적으로 추가 
# 컬럼을 구조복사한 대로 정확히 일치시켜야 한다. 
INSERT INTO part_emp(
	SELECT employee_id, first_name, hire_date, salary
	FROM employees
	WHERE YEAR(hire_date) = 2000
);
SELECT * FROM part_emp;


/* data type
char(10) : 고정 길이 10
varchar(10) : 가변 길이 1~10
decimal(4,2) : 전체 4자리 중 정수부 2자리, 소수부 2자리 
*/

CREATE TABLE typeExam(
	tid int
	,NAME VARCHAR(5)
);

ALTER TABLE typeExam ADD sosu DECIMAL(4,2);

INSERT INTO typeExam VALUES(1,'hong',2.2);
# out of range decimal
INSERT INTO typeExam(tid,sosu) VALUES(2,5130.2);

SELECT * FROM typeExam;

DROP TABLE typeExam;


# DML - insert, update, delete
CREATE TABLE t1(
	tid INT primary key auto_increment
	,NAME VARCHAR(20)
	,birth date
	,age int
	,tall DECIMAL(5,2)
);

INSERT INTO t1(NAME, birth, age, tall) VALUES('hong', NOW(), 20, 179.555);
INSERT INTO t1(NAME, birth) VALUES('park','2020-01-01');
INSERT INTO t1(NAME, birth, age) 
VALUES('t1','2020-03-01',21),('t2','2021-01-01',20),('t3','2000-01-01',25);

# delete는 row단위로 적용, select 는 column단위로 적용
DELETE FROM t1 WHERE age=20;

UPDATE t1
SET NAME='lee',birth=NOW(),tall=156.345
WHERE tid=3;

SELECT * FROM t1;


/* constraints 5
1. not null
2. unique(중복x)
3. primary key(not null && unique, onlyone)
4. check(데이터의 조건 지정)
5. foreign key

default는 초기값을 미리 설정해 놓는 것. 
*/
CREATE TABLE t2(
	tid INT PRIMARY KEY  
	,NAME varchar(20) NOT null 
	,addr VARCHAR(50) unique
	,age INT CHECK(age>=0 AND age<=150) 
	,campus VARCHAR(30) DEFAULT 'shinchon'
);
DESC t2;
SELECT * FROM information_schema.TABLE_CONSTRAINTS;

INSERT INTO t2(tid,name) VALUES(1,'hong');
INSERT INTO t2(tid, addr) VALUES(2,'seoul');
INSERT INTO t2 VALUES(2,'park','seoul');

# unique는 중복이 되면 안 된다. 
insert INTO t2 VALUES(3,'hong','seoul');
# null은 중복 가능 (unique는 not null과 독립적임)
INSERT INTO t2(tid, addr) VALUES(3,'suwon');

INSERT INTO t2(tid,NAME,age) VALUES(4,'park',20);
insert INTO t2(tid,NAME,campus) VALUES(5,'kang','songdo');


DROP TABLE t2;
SELECT * FROM t2;

