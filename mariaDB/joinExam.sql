USE hr;

# Q1 마케팅 부서의 사원들 
SELECT employee_id, first_name, hire_date, salary, department_name
FROM employees e INNER JOIN departments d
	ON e.department_id = d.department_id
WHERE department_name = 'Marketing';

# Q2 직무가 프로그래머인 사원들
SELECT employee_id, first_name, hire_date, salary, job_title
FROM employees e, jobs j
where e.job_id = j.job_id and job_title = 'Programmer';

#Q3 부서의 사원들 조회 
SELECT d.department_id, department_name, d.manager_id, employee_id, first_name, email, phone_number 
FROM departments d INNER JOIN employees e
	ON d.department_id = e.department_id
WHERE department_name = 'Purchasing';
# on 조건을 manager_id 로 거는 경우, 부서의 매니저는 조회되지 않는다. 
# 부서의 매니저는 manager_id가 자기 상사이기 때문.

# Q4 시애틀 근무 사원들 조회 
SELECT employee_id, first_name, email, department_name, l.postal_code, city
FROM employees e INNER JOIN departments d
	ON e.department_id = d.department_id
	INNER JOIN locations l
	ON d.location_id = l.location_id
WHERE l.city = 'Seattle';
# equi join
SELECT employee_id, first_name, email, department_name, l.postal_code, city
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id 
	and d.location_id = l.location_id and l.city = 'Seattle';
	
/*
SELECT department_name, d.manager_id, city, COUNT(employee_id)
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id and d.location_id = l.location_id 
GROUP BY city, department_name
ORDER BY d.department_id;
*/	

# 여러 테이블을 조인할 경우, 어떤 순서로 결합하는게 좋을지 생각해 볼 것	
USE employees;	
# Q1
SELECT e.emp_no, first_name, hire_date, d.from_date
FROM employees e INNER JOIN dept_emp d
	ON e.emp_no = d.emp_no
	INNER JOIN departments d2
	ON d.dept_no = d2.dept_no
WHERE d2.dept_name = 'Finance' 
	AND d.to_date = '9999-01-01';

# Q2
SELECT d.dept_no, dept_name, d.emp_no, first_name, gender, hire_date
FROM employees e INNER JOIN dept_manager d
	ON e.emp_no = d.emp_no
	INNER JOIN departments d2
	ON d.dept_no = d2.dept_no
WHERE d2.dept_name = 'Marketing' 
	AND d.to_date = '9999-01-01';

/*	위와 똑같은데 테이블 결합순서 달리해봄 
SELECT d.dept_no, dept_name, d.emp_no, first_name, gender, hire_date
FROM dept_manager d INNER JOIN departments d2  
	ON d.dept_no = d2.dept_no 
	INNER JOIN employees e 
	ON d.emp_no = e.emp_no 
WHERE d2.dept_name = 'Marketing' 
	AND d.to_date = '9999-01-01';
*/

# Q3
SELECT d2.dept_name, d.dept_no, e.emp_no, e.first_name, salary
FROM departments d2 INNER JOIN dept_manager d
	ON d2.dept_no = d.dept_no
	INNER JOIN employees e
	ON e.emp_no = d.emp_no
	INNER JOIN salaries s
	ON e.emp_no = s.emp_no
WHERE d2.dept_name = 'Research' 
	AND d.to_date = '9999-01-01' 
	AND s.to_date = '9999-01-01';


USE hr;

# IT 부서장의 사원, 위치, 지역, 국가정보
SELECT first_name, email, e.phone_number
	,l.city, c.country_name, r.region_name   
FROM employees e INNER JOIN departments d
	ON d.manager_id = e.employee_id
	INNER JOIN locations l
	ON d.location_id = l.location_id 
	INNER JOIN countries c
	ON l.country_id = c.country_id
	INNER JOIN regions r
	ON c.region_id = r.region_id
WHERE d.department_name = 'IT';

# 시애틀 근무자의 사원, 부서정보 
SELECT first_name, hire_date, salary, d.department_name
FROM employees e INNER JOIN departments d
	ON e.department_id = d.department_id
	INNER JOIN locations l
	ON d.location_id = l.location_id
WHERE l.city = 'Seattle';
	  
# 스티븐의 부서, 지역 정보
SELECT d.department_name, city,l.postal_code
FROM employees e INNER JOIN departments d
	ON e.department_id = d.department_id
	INNER JOIN locations l
	ON d.location_id = l.location_id
WHERE e.first_name = 'Steven';

# 2000년 입사자 사원, 부서, 지역 정보 
SELECT e.employee_id, first_name, hire_date, d.department_name, 
	city, l.street_address
FROM employees e INNER JOIN departments d
	ON e.department_id = d.department_id
	INNER JOIN locations l
	ON d.location_id = l.location_id
WHERE YEAR(hire_date) = 2000;

# 시애틀 근무자의 평균급여 
SELECT AVG(salary)
FROM employees e INNER JOIN departments d
	ON e.department_id = d.department_id
	INNER JOIN locations l
	ON d.location_id = l.location_id
WHERE city = 'Seattle';