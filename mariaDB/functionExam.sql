#function exam

# 1.10501~10550 사번인 사원 중 홀수인 사원
SELECT emp_no, first_name, hire_date
FROM employees
WHERE (emp_no >= '10501' AND emp_no <= '10550')
	AND MOD(emp_no,2) <> 0;
	
# 2. 'hEllo'라는 글자를 소문자, 대문자, 앞자만 대문자
SELECT LOWER('hEllo'), UPPER('hEllo'), 
	CONCAT(upper(LEFT('hEllo',1)),LOWER(RIGHT('hEllo',4))); 


# Q1 테이블 구조 
DESC employees;

# Q2
SELECT emp_no, first_name, hire_date, gender
FROM employees;

# Q3 이름이 6자 이상이고 n으로 끝나는
SELECT emp_no, first_name, last_name, birth_date
FROM employees
WHERE char_length(first_name) >=6 AND first_name LIKE '%n';
#where first_name like '%_____n');

# Q4 1985년 4월에 채용된 사람 
SELECT emp_no, first_name, gender, hire_date
FROM employees
WHERE hire_date BETWEEN '1985-04-01' AND '1985-04-30';

# Q5 1985년에 채용된 사람 
SELECT emp_no, first_name, birth_date, hire_date
FROM employees
#WHERE hire_date >= '1985-01-01' AND hire_date <= '1985-12-31';
#WHERE SUBSTRING_INDEX(hire_date, '-',1) = '1985';
#WHERE left(hire_date,INSTR(hire_date,'-')-1) = '1985';
WHERE SUBSTRING(hire_date,1,INSTR(hire_date,'-')-1) = '1985';


# Q1 1990년 2월에 입사한 사람 
SELECT emp_no, birth_date, hire_date
FROM employees
WHERE SUBSTRING_INDEX(hire_date,'-',2) = '1990-02'; 

# Q2 
SELECT CONCAT_WS(' ',first_name, last_name), hire_date, gender
FROM employees;

# Q3 10800~10900 사번 중에 이름이 P나 A로 시작하는 사람
SELECT emp_no, first_name, hire_date
FROM employees
WHERE emp_no BETWEEN '10800' AND '10900' 
	AND (first_name LIKE 'P%' OR FIRST_NAME LIKE 'A%');

# Q4 최근 입사한 남자
SELECT *
FROM employees
WHERE gender = 'M'
ORDER BY hire_date DESC;

# Q5 2000 1분기에 입사한 사람
SELECT *
FROM employees
WHERE hire_date >= '2000-01-01' AND hire_date <= '2000-03-31';
#WHERE SUBSTRING_INDEX(hire_date,'-',2) >= '1990-01' 
#	and SUBSTRING_INDEX(hire_date,'-',2) <= '1990-03';


# 000101-3010111 생년월일, 나이
SET @jumin = '000101-3010111';
SELECT CAST(SUBSTRING_INDEX(@jumin,'-',1) AS DATE) AS 생년월일, 
	YEAR(NOW())-YEAR(CAST(SUBSTRING_INDEX(@jumin,'-',1) AS DATE)) AS 나이;

# 2월생
SELECT *
FROM employees
WHERE MONTH(birth_date) = 2; 
#where substring(birth_date,6,2)='02';

#나이 구하기
SELECT emp_no, first_name, hire_date, birth_date, 
	YEAR(NOW())-YEAR(birth_date) AS age
FROM employees;

#숙제 : salay 테이블에서 emp_no, salary(현재급여), level 출력 
#10,000단위 마다 * 입력 10,000 미만은 공백, 120,000은 * 12개 
SELECT emp_no, salary, LPAD('',salary div 10000,'*') AS level
FROM salaries
WHERE to_date = '9999-01-01';
#Lpad('',truncate(salary/10000,0),'*') as level


# Q1 1990년 2사분기 입사자 
SELECT emp_no, first_name, hire_date
FROM employees
WHERE year(hire_date) = 1990 and quarter(hire_date) = 2;
#WHERE substring_index(hire_date,'-',2) >= '1990-04' AND SUBSTRING_INDEX(hire_date,'-',2) <= '1990-06';
#WHERE hire_date >= '1990-04-01' AND hire_date <= '1990-06-30';
#WHERE hire_date BETWEEN '1990-04-01' AND '1990-06-30';

# Q2 2월의 마지막날 
SELECT LAST_DAY('2024-02-01'); 

# Q3 3월의 마지막날 무슨요일 
SELECT dayname(LAST_DAY('2024-03-01'));

# Q4 어제는 무슨요일 
SELECT DAYNAME(NOW()-INTERVAL 1 DAY);
#SELECT dayname(ADDDATE(NOW(), -1));