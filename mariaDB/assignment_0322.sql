USE employees;

SHOW TABLES;

DESC employees;

# Q1
SELECT emp_no, first_name, gender
FROM employees
WHERE hire_date LIKE '1999-08%';

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

