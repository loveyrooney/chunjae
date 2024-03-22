/*
DDL(정의어) : create, alter, drop
DML(조작어) : select(DQL), insert, update, delete
DCL(제어어) : grant, revoke
*/

SHOW DATABASES;

USE EMPLOYEES;

SHOW TABLES;

DESC EMP;

#distinct는 모든 컬럼에 적용
# SELECT DISTINCT gender, last_name FROM employees;

/* select 메서드 및 AS alias 
SELECT emp_no, upper(first_name) AS upper_first_name, 
	lower(last_name) AS family_name,
	CONCAT(first_name, last_name) AS full_name 
FROM employees;
*/

/*
CREATE TABLE emp(
	emp_no INT PRIMARY KEY AUTO_INCREMENT
	, ename varchar(30)
	, age int
	, sal FLOAT
);	
*/	

/*
INSERT INTO emp(ename, age, sal) VALUES("a1",20,300);
INSERT INTO emp(ename, age, sal) VALUES("A1",25,500);
insert INTO emp(ename, age, sal) VALUES("a2",31,NULL);
INSERT INTO emp(ename, age, sal) VALUES("a3",30,0);
*/

# 연산 결과의 조회도 가능
# SELECT '10'+20, '10'+'20';

# NULL이란 미지의 값이다. 값을 추가하지 않은 상태. NULL에 연산을 하면 NULL이다. 
SELECT emp_no, ename, age, sal, sal*1 FROM emp;

#NULL 값의 연산에 대한 디폴트 지정 
SELECT emp_no, ename, age, sal, IFNULL(sal,0)*1.1 FROM emp;


# where문
SELECT emp_no, ename, age
FROM emp
WHERE age>=30;


DESC employees;

SELECT emp_no, first_name, last_name, hire_date, birth_date, gender
FROM employees
WHERE hire_date >= '2000-01-01' AND hire_date <= '2000-12-31'
ORDER BY hire_date DESC, first_name;

# 논리 연산자에서 AND는 OR보다 우선순위이다. ()로 우선순위 확실히 지정.
#WHERE gender='M' AND birth_date LIKE '1955-01%' OR birth_date LIKE '1960-08%';
#WHERE gender='M' AND (birth_date LIKE '1955-01%' OR birth_date LIKE '1960-08%');

# <>는 !=의 의미이다. 
#WHERE emp_no <>10001;

/* mariaDB는 window 에서  대소문자 구별을 하지 않기 때문에, 
binary 메서드를 사용해야 함. */
#WHERE first_name = BINARY('georgi');

/* 사잇값은 비교연산자나 BETWEEN (start) AND (end) 를 사용 가능. 
BETWEEN AND 에는 작은 값 먼저 적어야 된다. */
#WHERE emp_no >= '10010' AND emp_no <= '10020';
#WHERE hire_date BETWEEN '1985-02-02' AND '1985-02-05'; 

# 포함하고 있는지 여부는 비교연산자나 IN을 사용가능.
#WHERE first_name = 'Arco' OR first_name = 'Mori' OR first_name = 'Sedat';
#WHERE first_name IN('Arco','Mori','Sedat');

/* 와일드 문자는 % (여러글자 인식) 와 _ (한 글자 인식) 가 있다. 
%a : a로 끝나는, a% : a로 시작하는, %a% : a를 포함하는
_a : 2글자이고 a로 끝나는, a_ : 2글자이고 a로 시작하는, _a_ : 3글자이고 가운데가 a인
활용=> %a_ : 뒤에서 2번째 글자가 a인 

와일드카드를 그냥 문자로 검색하고 싶을 때는
임의의 글자를 escape 하고 바로 다음 문자를 글자로 인식하도록 하면 된다. 
CREATE TABLE t1(col VARCHAR(10));

INSERT INTO t1 VALUES('AAA');
INSERT INTO t1 VALUES('ABA');
insert INTO t1 VALUES('ACA');
INSERT INTO t1 VALUES('A_A');

COMMIT;

SELECT *
FROM t1
WHERE col LIKE '%A*_A%' ESCAPE '*';
*/
#WHERE first_name LIKE '%rich';

# null이거나 아닌 것을 조건에 달려면 is null / is not null 
SELECT * 
FROM emp
WHERE sal IS NULL; 

/*
CREATE TABLE sungjuck(
  id INT AUTO_INCREMENT PRIMARY key
  , NAME VARCHAR(10)
  , kor int
  , hak int
  , ban INT
);  

INSERT INTO sungjuck(NAME, kor, hak, ban) VALUES('a',100,1,1);
INSERT INTO sungjuck(NAME, kor, hak, ban) VALUES('b',null,1,1);
INSERT INTO sungjuck(NAME, hak, ban) VALUES('c',1,1);
INSERT INTO sungjuck(NAME, kor, hak, ban) VALUES('d',50,1,2);
INSERT INTO sungjuck(NAME, kor, hak, ban) VALUES('e',30,1,3);
INSERT INTO sungjuck(NAME, kor, hak, ban) VALUES('f',60,2,1);
INSERT INTO sungjuck(NAME, kor, hak, ban) VALUES('g',70,2,1);
INSERT INTO sungjuck(NAME, kor, hak, ban) VALUES('h',30,2,2);
*/

/* order by절은 각 컬럼의 정렬 조건에 맞게 왼쪽부터 우선순위로 모두 적용
order by 절에 들어간 컬럼을 반드시 조회할 필요는 없다. */ 
SELECT *
FROM sungjuck
WHERE kor IS NOT NULL AND hak=2
ORDER BY hak, kor desc;



