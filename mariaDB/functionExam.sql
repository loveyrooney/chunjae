USE employees;
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


# Q1 근속년수 30년 이상 직원 
SELECT emp_no, first_name, hire_date, year(NOW())-year(hire_date) AS 근무년수
FROM employees
WHERE year(NOW())-year(hire_date) >= 30; 
# year로만 계산하면 근무 시작일 기준이 아니기 때문에 datediff 사용
SELECT emp_no, FIRST_name, hire_date, DATEDIFF(NOW(),hire_date) DIV 365 AS 근무년수
FROM employees
WHERE DATEDIFF(NOW(),hire_date) DIV 365 >= 30;
#period_diff, date_format으로도 쓸 수 있다. 
select PERIOD_DIFF(DATE_FORMAT(NOW(),'%Y%m'),DATE_FORMAT(hire_date,'%Y%m')) div 12
FROM employees;

# Q2 나이가 70세 이상인 직원
SELECT emp_no, first_name, hire_date, birth_date, YEAR(NOW())-YEAR(birth_date) AS 나이
FROM employees
WHERE YEAR(NOW())-YEAR(birth_date) >=70;

# Q4
SELECT *
FROM employees
WHERE gender = 'M' AND month(birth_date) = 3;

SELECT * FROM emp;
# Q5
SELECT emp_no, ename, age, sal, ifnull(sal*12, 'nodata') AS 연봉  
FROM emp;

SELECT emp_no, first_name, birth_date, hire_date
FROM employees
WHERE hire_date BETWEEN '1985-04-01' AND '1985-04-30';
WHERE EXTRACT(YEAR_MONTH FROM hire_date) =198504;
WHERE DATE_FORMAT(hire_date, '%Y-%m') = '1985-04';


# case when exams
SELECT *
	, case when year(hire_date) >= 1985 AND year(hire_date) <=1989 then 'before'
	       when year(hire_date) >= 1990 AND year(hire_date) <=1999 then '1990s'
	       ELSE 'after 2000'
	END AS result
FROM employees;

SELECT emp_no, dept_no
	, case when dept_no IN ('d001','d002','d003') then 'group-A'
	       when dept_no IN ('d004','d005') then 'group-B'
	       ELSE 'group-C'
	END AS result
FROM dept_emp
WHERE to_date = '9999-01-01';  


#
SELECT emp_no, first_name, birth_date, hire_date
FROM employees
#WHERE YEAR(hire_date) >= 2000;
#WHERE DATE_FORMAT(hire_date,'%Y') >= 2000;
#WHERE EXTRACT(YEAR FROM hire_date) >= 2000;
#WHERE to_char(hire_date,'yyyy') >=2000;
WHERE SUBSTRING_INDEX(hire_date,'-',1) >= 2000;

SELECT emp_no, first_name, last_name
FROM employees
#WHERE last_name LIKE 'A%' OR last_name LIKE 'B%';
#WHERE substring(last_name,1,1) = 'A' OR SUBSTRING(last_name,1,1) = 'B';
WHERE LEFT(last_name,1) IN ('A','B');

SELECT emp_no, first_name, birth_date
FROM employees
#WHERE first_name LIKE '%e_';
WHERE SUBSTRING(first_name,-2,1) = 'e';     

SELECT emp_no, first_name, hire_date
FROM employees
#WHERE first_name LIKE '____';
WHERE char_length(first_name) = 4;


#group by
# Q1
SELECT hak, ban, AVG(kor)
FROM sungjuck
GROUP BY hak, ban;

# Q2 평균이 50이상인 학급
SELECT hak, ban, AVG(kor)
FROM sungjuck
GROUP BY hak, ban
HAVING AVG(kor)>=50;

# Q3 50점 이상의 평균 
SELECT hak, AVG(kor)
FROM sungjuck
WHERE kor>=50
GROUP BY hak;

# Q1 
SELECT MAX(salary), MIN(salary), truncate(AVG(salary),0) 
FROM salaries
WHERE to_date = '9999-01-01';

# Q2 입사년도별 인원수
SELECT year(hire_date), COUNT(*)
FROM employees
GROUP BY YEAR(hire_date);

# Q3 입사인원이 10000명 이상인 연도와 인원
SELECT YEAR(hire_date), COUNT(*)
FROM employees
GROUP BY YEAR(hire_date)
HAVING COUNT(*)>=10000;

# Q4 성별, 입사연도별 인원 
SELECT gender, YEAR(hire_date), COUNT(*)
FROM employees
GROUP BY gender, YEAR(hire_date);

# Q5 1993년 입사한 남녀 인원 
SELECT gender, COUNT(*)
FROM employees
WHERE year(hire_date) = 1993
GROUP BY gender;


# 같은 조건을 having, where로 쓸 때 having에 year(hire_date) 실행 안됨 
SELECT YEAR(hire_date) AS ipsa, COUNT(*)
FROM employees
GROUP BY YEAR(hire_date)
HAVING ipsa = 1985;

SELECT YEAR(hire_date) AS ipsa, COUNT(*)
FROM employees
WHERE YEAR(hire_date) = 1985
GROUP BY YEAR(hire_date);


SELECT month(birth_date), gender COUNT(*)
FROM employees
GROUP BY MONTH(birth_date), gender;

# 위 테이블의 피벗 컬럼 만들기  
/* count(if(gender='M',1,null)) : null을 제외한 row 개수를 센다.  
sum(if(gender='M',1,0)) : 모든 row의 '값'을 계산. sum += 1 처럼 */
SELECT month(birth_date), COUNT(if(gender='M',1,NULL)) AS M, COUNT(if(gender='F',1,NULL)) AS F
FROM employees
GROUP BY MONTH(birth_date);

#decode_oracle
SELECT MONTH(birth_date)
		,sum(decode_oracle(gender,'M',1,0)) AS M
		,sum(decode_oracle(gender,'F',1,0)) AS F
FROM employees
GROUP BY MONTH(birth_date);

#case when then 
SELECT gender
		,count(case when quarter(birth_date)=1 then 1 END) AS '1-3'
		,count(case when quarter(birth_date)=2 then 1 END) AS '4-6'
		,count(case when quarter(birth_date)=3 then 1 END) AS '7-9'
		,count(case when quarter(birth_date)=4 then 1 END) AS '10-12'
FROM employees
GROUP BY gender; 


# Q1 각 년도 입사자 피벗 
SELECT COUNT(*)
		,COUNT(if(YEAR(hire_date)=1992,1,null)) AS '1992'
		,COUNT(if(YEAR(hire_date)=1993,1,null)) AS '1993'
		,COUNT(if(DATE_FORMAT(hire_date,'%Y')=1994,1,null)) AS '1994'
		,COUNT(if(EXTRACT(YEAR FROM hire_date)=1995,1,null)) AS '1995'
FROM employees;

# Q2 각 년도 입사자 성별 피벗
SELECT gender,COUNT(*)
		,COUNT(if(YEAR(hire_date)=1992,1,null)) AS '1992'
		,COUNT(if(YEAR(hire_date)=1993,1,null)) AS '1993'
		,COUNT(if(DATE_FORMAT(hire_date,'%Y')=1994,1,null)) AS '1994'
		,COUNT(if(EXTRACT(YEAR FROM hire_date)=1995,1,null)) AS '1995'
FROM employees
GROUP BY gender;

# Q3 연대별 평균 급여
USE hr;

SELECT job_id
	,round(avg(if(YEAR(hire_date)>=1987 AND YEAR(hire_date)<=1990,salary,NULL)),1) AS '1987-1990'
	,round(avg(if(YEAR(hire_date)>=1991 AND YEAR(hire_date)<=1994,salary,NULL)),1) AS '1991-1994'
	,round(avg(if(YEAR(hire_date)>=1995 AND YEAR(hire_date)<=1997,salary,NULL)),1) AS '1995-1997'
	,round(AVG(if(YEAR(hire_date)>1997,salary,NULL)),1) AS others
FROM employees
GROUP BY job_id;
# if문에 else값에 0을 넣으면, 샐러리를 0으로 정하고 전체의 평균값을 구하게 된다. 

# Q1 
SELECT manager_id, MIN(salary)
FROM employees
GROUP BY manager_id
HAVING MIN(salary)>6000
ORDER BY MIN(salary);

# Q2
SELECT * FROM employees;
SELECT job_id 
		,case when job_id='AD_PRES' then 'A'
				when job_id='ST_MAN' then 'B'
				when job_id='IT_PROG' then 'C'
				when job_id NOT IN('AD_PRES','ST_MAN','IT_PROG') then 'others'
		END AS result
FROM employees;		