USE employees;

# Q1
SELECT * 
FROM employees
WHERE hire_date LIKE '2000%';

# Q2
SELECT emp_no, first_name, last_name, gender
FROM employees
WHERE first_name LIKE 'U%' OR first_name LIKE 'M%';

# Q3
SELECT emp_no, first_name, gender
FROM employees
WHERE first_name LIKE '%a_';

# Q4
SELECT emp_no, first_name, birth_date
FROM employees
WHERE first_name LIKE '_____';

# Q5
SELECT emp_no, salary
FROM salaries
WHERE salary BETWEEN 70000 AND 80000 
	AND to_date LIKE '9999-01-01';

# Q6
SELECT emp_no, first_name, birth_date, hire_date
FROM employees
WHERE hire_date LIKE '1999-12%';




