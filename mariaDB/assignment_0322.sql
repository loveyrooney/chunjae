USE employees;

SHOW TABLES;

DESC employees;

#0322

# Q1
SELECT emp_no, first_name, gender
FROM employees
WHERE hire_date LIKE '1999-08%';
#date 타입에 like(문자열에 대한 연산)를 쓰는 것은 좋지않다. between이나 비교연산자 쓸 것.

# Q2
SELECT last_name, first_name, hire_date, birth_date
FROM employees;

# Q3
SELECT emp_no, first_name, hire_date, gender
FROM employees
WHERE (emp_no >= '100010' AND emp_no <= '101000')
	AND (last_name LIKE 'P%' OR last_name LIKE 'A%');

# Q4
SELECT *
FROM employees
WHERE gender='M' AND hire_date LIKE '1985-04%';

# Q5
SELECT emp_no, first_name, last_name, gender, hire_date
FROM employees
WHERE last_name = 'Swiss'
ORDER BY hire_date DESC;


#0401

CREATE TABLE user_jobs(
	job_id VARCHAR(10) PRIMARY KEY 
	,job_title VARCHAR(35) NOT NULL
	,min_salary DECIMAL(8,0) 
	,max_salary DECIMAL(8,0) 
);

CREATE TABLE user_departments(
	department_id INT PRIMARY KEY
	,department_name VARCHAR(30) NOT NULL
	,manager_id INT 
	,location_id INT
);

CREATE TABLE user_employees(
	employee_id INT 
	,first_name VARCHAR(20) NOT NULL
	,last_name VARCHAR(25)
	,email VARCHAR(25)
	,phone_number VARCHAR(20) NOT NULL
	,hire_date DATE 
	,job_id VARCHAR(10)
	,salary DECIMAL(8,2) 
	,commission_pct DECIMAL(2,2)
	,manager_id INT 
	,department_id INT 
	,CONSTRAINT PRIMARY KEY(employee_id)
	,CONSTRAINT jobs_fk FOREIGN KEY(job_id)
	 REFERENCES user_jobs(job_id)
	,CONSTRAINT emp_fk FOREIGN KEY(manager_id)
	 REFERENCES user_employees(employee_id)
	,CONSTRAINT dept_fk FOREIGN KEY(department_id)
	 REFERENCES user_departments(department_id)
	
);

ALTER table user_departments
	ADD constraint manager_fk FOREIGN KEY(manager_id)
	REFERENCES user_employees(employee_id);

