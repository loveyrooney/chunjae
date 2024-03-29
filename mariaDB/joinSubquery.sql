/* 식별키
슈퍼키 : row를 식별할 수 있는 컬럼의 집합
후보키 : 슈퍼키를 최소한으로 줄인 것 
기본키 : 후보키중에 선택한 것 
대체키 : 후보키중에 기본키를 대체할 수 있는 것
외래키 : 다른 테이블에서 참조한 키 (기본키를 참조했으면 식별관계, 아니면 비식별관계)
*/

/* 정규화 : 테이블마다 중복되는 자료로 인한 삽입, 삭제, 갱신이상의 문제를 해결하기 위해
종속관계를 분석하여 여러개의 테이블로 분해하는 과정 
1NF - 컬럼하나에는 하나의 값만 가져야 한다.
2NF - 모든 컬럼은 기본키에 의존적이어야 한다. (컬럼의 존재이유가 기본키에 근거)
3NF - 2NF 를 만족하며 이행함수 종속을 제거.  
*/

#join이 subquery보다 빠르다. 

USE hr;

# cross join : 양쪽 테이블의 모든 자료를 대응한다. 
# (count(R) * count(L), 카티션 곱)
SELECT *
	FROM employees CROSS JOIN departments; 
# 축약 : from employees, departments;


# inner join : join 하는 테이블 안에 있는 자료만 보여준다.(일대일 대응)
SELECT employee_id, first_name, salary
	, e.department_id, department_name, location_id
FROM employees e INNER JOIN departments d
	ON e.department_id = d.department_id;
# 축약 : employees e join departments d
	
# equi join, 동등 조인 (==inner join)
SELECT * 
FROM employees, departments
WHERE employees.department_id = departments.department_id;
# cross join 에서 일대일 대응의 조건을 적용

/*
CREATE TABLE salgrade (
 s_code INT PRIMARY KEY auto_increment
 ,s_degree VARCHAR(5)
 ,lowsal float
 ,highsal int
);

INSERT INTO salgrade VALUES(1,'a',2000,3999);
INSERT INTO salgrade VALUES(2,'b',4000,7999);
INSERT INTO salgrade VALUES(3,'c',8000,9999);
INSERT INTO salgrade VALUES(4,'d',10000,30000);
*/

SELECT * FROM salgrade;

# non-equi join, 비동등 조인 (1:N 대응, 조건절에 범위가 주로 들어감)
SELECT employee_id,first_name, salary, s_degree
FROM employees, salgrade
WHERE salary>lowsal AND salary <highsal;


# self join
SELECT e1.employee_id, e1.first_name AS Me
	,e2.employee_id, e2.first_name AS Boss 
FROM employees e1 INNER JOIN employees e2
	ON e1.manager_id = e2.employee_id;

/*
CREATE TABLE book(
	id INT PRIMARY KEY auto_increment
	,title VARCHAR(20)
	,price INT
);

INSERT INTO book(title,price) VALUES('a1',100);
INSERT INTO book(title,price) VALUES('a2',200);
INSERT INTO book(title,price) VALUES('a3',500);
INSERT INTO book(title,price) VALUES('a1',250),('a4',300);
*/

# 비식별관계의 self join 
SELECT b1.title, b1.price, b2.title, b2.price
FROM book b1 INNER JOIN book b2
	ON b1.title = b2.title
WHERE b1.price <> b2.price;


/* outer join : join 하는 테이블의 left/right 지정하면 
지정한 테이블의 모든 자료를 보여준다. */

SELECT e.employee_id, e.first_name, e.department_id 
FROM employees e LEFT OUTER JOIN departments d
	ON e.department_id = d.department_id;
# 부서가 없는 사원도 출력
# 축약 : from employees e left join departments d 
	
SELECT e.employee_id, e.first_name, d.department_name
FROM departments d LEFT OUTER JOIN employees e
	ON d.department_id = e.department_id;
# 사원이 없는 부서도 출력

/* oracle에서는 equi join 으로 outer join 가능 
SELECT e.employee_id, e.first_name, d.department_name
FROM departments, employees e
where d.department_id(+) = e.department_id;
*/

# full outer join : 양쪽 모두를 보여준다. (mariaDB는 지원 x) 
# cross join은 좌우의 교집합, full outer join은 좌우의 합집합이다. 

/* Union : 두 자료를 위아래로 합친 것 (join은 두 자료를 양옆으로 합친 것)
union의 주의할 점은, 컬럼 타입을 맞춰줘야 함. 
타입이 다르면 mariaDB의 경우 형변환, oracle은 동작하지 않는다. 
*/
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id=10
UNION
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id=30;

# mariaDB의 full outer join은 left와 right를 union 해서 출력
SELECT e.employee_id, e.first_name, d.department_name
FROM departments d LEFT OUTER JOIN employees e
	ON d.department_id = e.department_id
union
SELECT e.employee_id, e.first_name, d.department_name
FROM departments d right OUTER JOIN employees e
	ON d.department_id = e.department_id;
	
	
# subquery 

# 사원정보들은 개별자료, 평균급여는 그룹 자료 이므로 성격이 다름. 
# 그래서 그룹 자료를 select에 나란히 놓지 않고 subquery를 통해 출력
SELECT employee_id, first_name, salary
	,(SELECT AVG(salary) FROM employees) AS avg_salary
FROM employees;

# (dinel과 같은 급여)를 받는 사원정보
SELECT employee_id, first_name, salary, hire_date
FROM employees
WHERE salary=(
	SELECT salary
	FROM employees
	WHERE first_name = 'Daniel'
);

# (평균급여)보다 많이 받는 사원정보
SELECT employee_id, first_name, salary, hire_date
FROM employees
WHERE salary>(
	SELECT AVG(salary)
	FROM employees
);

# (전화번호가 515인 사람'들')의 사원정보
SELECT e.employee_id, e.first_name, e.hire_date
WHERE e.employee_id IN (
	SELECT employee_id
	FROM employees
	WHERE phone_number LIKE '515%'
);


/*
CREATE TABLE sample(
	id int PRIMARY KEY auto_increment
	,price int
	,groupId int
);

INSERT INTO sample(price, groupId) VALUES(100,1),(200,2),(200,2),(100,3),(100,3),(200,3),(200,3);
*/

SELECT * FROM sample;

# 서브쿼리 내의 그룹핑이 본쿼리에 적용되지 않는다.
SELECT *
FROM sample
WHERE price in (SELECT AVG(price)
					 FROM sample
					 GROUP BY groupId);

# 서브쿼리와 본쿼리의 그룹기준을 연결한다. 
SELECT *
FROM sample s1
WHERE price in (SELECT AVG(price)
					 FROM sample
					 WHERE s1.groupId = groupId);
					 
					 
# subquery를 from절에 쓰기 
SELECT t.*
FROM ( SELECT department_id, CONCAT_WS(' ',first_name,last_name) AS NAME
		 FROM employees
		 WHERE department_id = 30 ) t;