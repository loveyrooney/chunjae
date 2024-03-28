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

# 숙제 Q1 
SELECT d2.dept_name, d.dept_no, e.emp_no, e.first_name, d.from_date, salary
FROM departments d2 INNER JOIN dept_manager d
	ON d2.dept_no = d.dept_no
	INNER JOIN employees e
	ON e.emp_no = d.emp_no
	INNER JOIN salaries s
	ON e.emp_no = s.emp_no
WHERE d2.dept_name = 'Research' 
	AND d.to_date = '9999-01-01' 
	AND s.to_date = '9999-01-01';
	
# 숙제 Q2
SELECT e.emp_no, first_name, salary, hire_date, gender
FROM employees e INNER JOIN salaries s
	ON e.emp_no = s.emp_no
WHERE s.to_date = '9999-01-01';

# 숙제 Q3
SELECT e.emp_no, e.first_name, d.dept_name, e2.first_name AS manager_name
FROM employees e INNER JOIN dept_emp de
	ON e.emp_no = de.emp_no
	INNER join departments d
	ON de.dept_no = d.dept_no
	INNER JOIN dept_manager dm
	ON d.dept_no = dm.dept_no
	inner join employees e2
	ON dm.emp_no = e2.emp_no 
WHERE dm.to_date = '9999-01-01';
	 
	

USE hr;
# 여러 테이블을 조인할 경우, 어떤 순서로 결합하는게 좋을까?

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


# Q1
SELECT employee_id, last_name, hire_date, department_id
FROM employees
WHERE employee_id BETWEEN 150 AND 200
	AND (last_name LIKE 'P%' OR last_name LIKE 'A%');
	
# Q2
SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE first_name LIKE '%r_';

# Q3
SELECT employee_id, first_name, last_name, salary, hire_date
FROM employees
WHERE char_length(first_name) >=6 AND right(first_name,1)='a';
# first_name like '%_____a';

# Q4
SELECT *
FROM employees
WHERE first_name IN ('Steven', 'Stephen');

# Q5
SELECT REPLACE(phone_number,'.','-')
FROM employees;

# Q6
SELECT REPLACE('1230456700800','0','');


# self join

# david의 상사정보 
SELECT e1.first_name, e2.first_name AS manager_name, e2.salary, e2.hire_date, e2.phone_number
FROM employees e1 INNER JOIN employees e2
	ON e1.manager_id = e2.employee_id
WHERE e1.first_name = 'David';

# john의 부하정보 
SELECT e2.first_name AS manager_name, 
	e1.first_name, e1.salary, e1.hire_date, e1.email
FROM employees e1 INNER JOIN employees e2
	ON e1.manager_id = e2.employee_id
WHERE e2.first_name = 'John';

# marketing 부서장의 부하정보 
SELECT e1.employee_id, e1.first_name, e1.salary, e1.hire_date
FROM departments d INNER JOIN employees e1
	ON d.manager_id = e1.manager_id
WHERE d.department_name = 'Marketing';
#부서장 정보는 필요없기 때문에 바로 연결

SELECT e1.employee_id, e1.first_name, e1.salary, e1.hire_date
FROM departments d INNER JOIN employees e
	ON d.manager_id = e.employee_id
	INNER JOIN employees e1
	ON e.employee_id = e1.manager_id
WHERE d.department_name = 'Marketing';
#부서장과 부하의 셀프조인 

# Den의 부하정보, 부서정보
SELECT e2.first_name AS manager, e1.first_name, e1.hire_date, d.department_name, l.city
FROM employees e1 INNER JOIN departments d
	ON e1.department_id = d.department_id
	INNER JOIN locations l
	ON d.location_id = l.location_id
	INNER JOIN employees e2
	ON e1.manager_id = e2.employee_id
WHERE e2.first_name = 'Den';

SELECT e2.first_name AS manager, e1.first_name, e1.hire_date, d.department_name, l.city
FROM employees e2 INNER JOIN employees e1
	ON e2.employee_id = e1.manager_id
	INNER JOIN departments d
	ON e1.department_id = d.department_id
	INNER JOIN locations l
	ON d.location_id = l.location_id
WHERE e2.first_name = 'Den';


# david lee 보다 먼저 입사한 직원정보 
SELECT e1.first_name, e1.hire_date, e2.first_name, e2.hire_date
FROM employees e1 INNER JOIN employees e2
	on e1.hire_date > e2.hire_date 
where e1.first_name = 'David' AND e1.last_name = 'Lee';

# lex보다 급여가 적은 직원정보
SELECT e2.employee_id, e2.first_name, e2.salary, e2.hire_date
FROM employees e1, employees e2
WHERE e1.salary > e2.salary
	AND e1.first_name = 'Lex';
	
# lex와 같은 부서 동료정보
SELECT e2.employee_id, e2.first_name, e2.salary, 
	e2.salary*12*(1+ifnull(e2.commission_pct,0)), e2.department_id
FROM employees e1, employees e2
WHERE e1.department_id = e2.department_id
	AND e1.first_name = 'Lex';
	
# david lee 와 같은해 입사자 정보
SELECT e2.employee_id, e2.first_name, e2.salary, e2.hire_date
FROM employees e1, employees e2
WHERE year(e1.hire_date) = year(e2.hire_date)
	AND e1.first_name = 'David' AND e1.last_name = 'Lee';
	
# adam의 부하정보
SELECT e1.employee_id, e1.first_name, e1.salary, e1.job_id
FROM employees e1, employees e2
WHERE e1.manager_id = e2.employee_id
	AND e2.first_name = 'Adam';
	
# steven king 부하정보
SELECT e1.first_name, e1.hire_date, e1.department_id
FROM employees e1 inner JOIN employees e2
	ON e1.manager_id = e2.employee_id
WHERE e2.first_name = 'Steven' AND e2.last_name = 'King';

# steven king 보다 이후 입사자 정보
SELECT e2.employee_id, e2.first_name, e2.hire_date
FROM employees e1 INNER JOIN employees e2
	ON e1.hire_date < e2.hire_date
WHERE e1.first_name = 'Steven' AND e1.last_name = 'King';

# 관리자보다 이전 채용의 관리자 정보
SELECT e1.first_name, e1.hire_date, e2.employee_id, e2.first_name, e2.hire_date 
FROM employees e1 INNER JOIN employees e2
	ON e1.manager_id = e2.employee_id
WHERE e1.hire_date < e2.hire_date;
	
# neena보다 급여 높은 직원정보
SELECT e2.employee_id, e2.first_name
	,DATEDIFF(NOW(),e2.hire_date) DIV 365 AS 근무년수
FROM employees e1 INNER JOIN employees e2	
	ON e1.salary < e2.salary
WHERE e1.first_name = 'Jennifer';

# neena와 같은 부서 직원정보
SELECT e2.employee_id, e2.last_name
FROM employees e1 INNER JOIN employees e2
	ON e1.department_id = e2.department_id
WHERE e1.first_name = 'Neena';


# outer join

# 직원과 상사 정보 (상사가 없는 직원 포함)
SELECT e2.first_name, IFNULL(e1.first_name,'CEO') AS manager_name
FROM employees e1 right OUTER JOIN employees e2
 	ON e1.employee_id = e2.manager_id;
 	
# 부서와 사원 정보 (사원 없는 부서 포함)
SELECT d.department_name, e.first_name
FROM departments d LEFT OUTER JOIN employees e
	ON d.department_id = e.department_id;
	
# 부서와 부서장 정보 (부서장 없는 부서 포함)
SELECT d.department_name, e.first_name
FROM departments d LEFT OUTER JOIN employees e
	ON d.manager_id = e.employee_id;

	
# aggregate & join 
	
# 부서원이 10명 이상인 부서인원 
SELECT department_name, COUNT(*)
FROM departments d INNER JOIN employees e
	ON d.department_id = e.department_id
GROUP BY department_name
HAVING COUNT(*)>=10;