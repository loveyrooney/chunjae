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


USE hr;

# cross join : 양쪽 테이블의 모든 자료를 대응한다. (count(R) * count(L))
SELECT *
	FROM employees CROSS JOIN departments; 
# from employees, departments;

# inner join : join 하는 테이블 안에 있는 자료만 보여준다.(일대일 대응)
SELECT employee_id, first_name, salary
	, e.department_id, department_name, location_id
FROM employees e INNER JOIN departments d
	ON e.department_id = d.department_id;
	
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
	ON e1.manager_id = e2.employee_id

