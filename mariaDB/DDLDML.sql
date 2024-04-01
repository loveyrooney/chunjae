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


/* constraints : 데이터의 무결성을 지키기 위한 제약조건 5
1. not null : 컬럼 단위로만 정해야 함
2. unique(중복x)
   컬럼 단위로 지정하거나 
   constraint 테이블명_컬럼명_uk unique(addr)
3. primary key(not null && unique, onlyone, 자동으로 클러스터형 인덱스 생성)
   단일키 : 컬럼 하나. ex) 202401101 연도/단과대및학과/번호
   hak_no,int, primary key
   복합키 : 컬럼 여러개. ex) 2024 011 01
   constraint 테이블명_컬럼명_pk primary key(year,class,number)
   현업에서 기본키에는 개인 식별정보를 사용하지 않고 임의의 번호를 쓴다. 
4. check(데이터의 조건 지정)
   컬럼단위로 지정하거나
   constraint 테이블명_컬럼명_ck check(age>=0 AND age<=150) 
5. foreign key (기본키에 의존적, 테이블 삭제시 유의할 것)
   컬럼명 INT REFERENCES 참조할테이블명(참조할 테이블의 컬럼명)
   CONSTRAINT user_dept_fk FOREIGN KEY(컬럼명) REFERENCES 참조테이블명(참조컬럼명)

default는 초기값을 미리 설정해 놓는 것. (제약조건은 아니다)
*/
CREATE TABLE t2(
	tid INT PRIMARY KEY  
	,NAME varchar(20) NOT null 
	,addr VARCHAR(50) unique
	,age INT CHECK(age>=0 AND age<=150) 
	,campus VARCHAR(30) DEFAULT 'shinchon'
);

/* constraint 사용하는 경우 
CREATE TABLE t2(
	tid INT   
	,NAME varchar(20) NOT null 
	,addr VARCHAR(50) 
	,age INT
	,campus VARCHAR(30) DEFAULT 'shinchon'
	,constraint t2_tid_pk primary key(tid)
	,constraint t2_addr_uk unique(addr)
	,constraint t2_age_ck check(age>=0 AND age<=150) 
);
*/

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

# foreign key
CREATE TABLE user_dept(
	udeptid INT auto_increment PRIMARY KEY 
	,udeptname VARCHAR(20) NOT null
);

CREATE TABLE user_emp(
	uid INT
	,uname VARCHAR(20) NOT null
	,udeptid INT REFERENCES user_dept(udeptid)
	,CONSTRAINT PRIMARY KEY(uid)
--	,CONSTRAINT user_dept_fk FOREIGN KEY(udeptid) 
--	REFERENCES user_dept(udeptid)
);

INSERT INTO user_dept VALUES(10,'part1');
INSERT INTO user_dept values(20,'part2');

INSERT INTO user_emp VALUES(1,'park',10);
INSERT INTO user_emp VALUES(2,'lee',20);

SELECT * FROM user_emp;
SELECT * FROM user_dept;
DROP TABLE user_emp;
DROP TABLE user_dept;


/* alter table 테이블명 add 제약조건 / add column 내용 
                        modify 내용 
                        alter 컬럼 set 내용
                        dtop 제약조건 / drop column 내용
                        rename column 컬럼 to 새이름
*/


# transaction : 작업단위. all or nothing (원자성)

SELECT @@autocommit;
SET autocommit=0;
SELECT @@autocommit;

START TRANSACTION
CREATE TABLE t3(
	id VARCHAR(20)
	,pwd VARCHAR(30)
);

INSERT INTO t3 VALUES('1','345');
INSERT INTO t3 VALUES('2','346');
INSERT INTO t3 VALUES('3','348');
SELECT * FROM t3;
COMMIT;

INSERT INTO t3 VALUES('4','567');
SELECT * FROM t3;
ROLLBACK;

INSERT INTO t3 VALUES('1','545');
INSERT INTO t3 VALUES('2','546');
INSERT INTO t3 VALUES('3','548');
SAVEPOINT s1;
INSERT INTO t3 VALUES('1','645');
INSERT INTO t3 VALUES('2','646');
INSERT INTO t3 VALUES('3','648');
SAVEPOINT s2;
UPDATE t3 SET pwd='test' WHERE id='3';

SELECT * FROM t3;
ROLLBACK TO s2;

# !!! ddl문은 자동으로 커밋이 일어나기 때문에, 
# dml 문과 같이 쓰지 않도록 주의할 것. (savepoint 분리)

/* transaction lock 
: 누군가 작업중이면서 commit 하지 않은 상태의 내용에
다른 사람이 접근을 시도하면 lock이 걸린다. (격리성) 
*/


/* view : 실제 테이블이 아닌, 테이블을 어떤 레이어로 바라볼 것인가. 
가상 테이블이다. 
*/
USE hr;

# 뷰의 메타데이터 조회 
SELECT * FROM information_schema.VIEWS;

# 단순뷰 
CREATE VIEW v1 AS 
	SELECT employee_id, first_name, salary
	FROM employees;
	
SELECT * FROM v1;

# 복합뷰
CREATE VIEW v2 AS
	SELECT e.employee_id, e.first_name, d.department_name
	FROM employees e INNER join departments d
	  ON e.department_id = d.department_id;

SELECT * FROM v2;

DROP VIEW v2;


# view의 조작 
CREATE TABLE emp90(
	SELECT employee_id, first_name, salary, department_id
	FROM employees
	WHERE department_id = 90
);

SELECT * from emp90;

CREATE VIEW v90 AS
	SELECT * 
	FROM emp90
	WHERE department_id=90;
	
SELECT * FROM v90;

# view의 조건에 해당하는 row는 추가 가능, 조회 가능
INSERT INTO v90 
VALUES(150,'aaa',1100,90);

# view의 조건에 해당하지 않는 row도 추가 가능, 조회 불가능 
# 그러나 테이블을 조회하면 추가한 row를 볼 수 있다. 
INSERT INTO v90 
VALUES(200,'park',100,100);


CREATE VIEW new_v90 
AS 
	SELECT * 
	FROM emp90
	WHERE department_id=90
	WITH CHECK OPTION;

/* check option을 쓰면 해당 뷰가 볼 수 없는 부분의 insert를 막아준다.
INSERT INTO new_v90 
VALUES(200,'park',100,100);
*/


/* index : select를 주로 하는 경우 조회 속도 빠름 
update, delete 가 잦은경우 성능저하. 바이너리형 인덱스

primary key는 클러스터형 인덱스, 검색 느림(전체 idx에서 찾음), 추가삭제 빠름
index는 비 클러스터형 인덱스(바이너리형), 검색 빠름(이진 검색), 추가삭제 느림
*/

CREATE TABLE in_emp(
	SELECT * 
	FROM employees
);

explain SELECT * FROM in_emp
WHERE hire_date = '1998-01-01';

CREATE INDEX hire_date 
ON in_emp(hire_date);

DROP INDEX hire_date ON in_emp;

