#모든 함수는 음수, null, 다른 타입 등을 넣어서 연습해 볼 것.

#numeric function
SELECT MOD(10,3), 10%3, 10 MOD 3;
SELECT ABS(10), ABS(-10), ABS(10.2), ABS(-10.2);
SELECT EXP(2), EXP(1), LOG(2), LOG(1); 
SELECT GREATEST(10, 2, 5, -29, 358), LEAST(10,2,5,-29,358);
SELECT PI(), RAND();
SELECT POW(3,2), POWER(3,2);

SELECT CEIL(10.3), CEILING(-10.7), FLOOR(10.3),FLOOR(-10.7), ROUND(10.3), ROUND(-10.7);
#round는 반올림, truncate는 절삭
SELECT ROUND(10.2323,1), ROUND(10.4256,3), ROUND(12345.12,-1), ROUND(12345.123,0);
SELECT TRUNCATE(12345.5345, 1), TRUNCATE(12345.234, -1); 
#salary 10% 인상 후 소수점 버림 
SELECT emp_no, salary, truncate(salary*1.1,0)
FROM salaries
WHERE to_date = '9999-01-01';


#String function
SELECT CHAR(65), CHAR(93);
SELECT LCASE('Hong'), LOWER('Gil'), UCASE('hong'), UPPER('gil');
SELECT ELT(3, 'a1', 'a2', 'a3'), ELT(0, 'a1', 'a2', 'a3');
SELECT RIGHT('hong gil dong',4), LEFT('hong gil dong',4);
SELECT INSERT('hello world hong gil dong',7,5,'this is'),
	INSERT('hello world hong gil dong',13,100,'harry potter');
SELECT FORMAT(12345678910,2); #소수점 2째자리까지 1000단위로
SELECT repeat('hong',2);
SELECT REPLACE('hong gil dong','gil','joon');
SELECT REVERSE('hong gil');
SELECT CONCAT('hong',QUOTE('gil'),'dong');
SELECT STRCMP('hong','hong'), STRCMP('a','hello'), STRCMP('test','abc');

#length는 byte 기준
SELECT LENGTH('안녕'), LENGTH('hi'); 
#char_length는 byte 기준이 아니라 글자 기준 
SELECT first_name, CHAR_LENGTH(first_name), CHARACTER_LENGTH('hong'), CHAR_LENGTH('안녕')
FROM employees;
SELECT emp_no, first_name, hire_date
FROM employees
WHERE CHAR_LENGTH(first_name) = 5; 
#WHERE first_name like '_____';

SELECT CONCAT('hello, world', ' hong', 'gil','dong');
SELECT CONCAT_WS('/', 'aaa', 'bbb','ddd');
SELECT emp_no, CONCAT_WS(' ',first_name,last_name) AS full_name, hire_date
FROM employees;

#문자열에서 처음으로 발견되는 글자의 인덱스 (인덱스는 1부터 시작)
SELECT INSTR('hong gil dong','gil');
SELECT LOCATE('on','hong gil dong',4);
SELECT SUBSTRING_INDEX('hong gil dong',' ',-2);
SELECT SUBSTRING('hong gil dong',6), 
	SUBSTR('hong gil dong',6,3), SUBSTR('hong gil dong',6,20); 
  
#substring(문자열, 시작idx, length)
#substring_index(문자열, 타겟문자열, n번째 타겟문자열) 
#양수면 왼쪽부터 n번째 타겟 문자열까지, 음수면 오른쪽부터 n번째 타겟 문자열까지 슬라이스 
SELECT SUBSTRING('abc@naver.com',1,INSTR('abc@naver.com','@')-1), 
	SUBSTRING('abc@naver.com',INSTR('abc@naver.com','@')+1);
SELECT LEFT('abc@naver.com',INSTR('abc@naver.com','@')-1);
SELECT SUBSTRING_INDEX('abc@naver.com','@',1), 
	SUBSTRING_INDEX('abc@naver.com','@',-1); 

#trim 
SELECT CONCAT('__',TRIM('  init hello  '),'__'), 
	CONCAT('__',RTRIM('  init hello  '),'__'), 
	CONCAT('__',LTRIM('  init hello  '),'__');
SELECT CONCAT('**',TRIM(LEADING FROM '   abc   '),'**'),
	CONCAT('**',TRIM(TRAILING FROM '   abc  '),'**'), 
	CONCAT('**',TRIM(BOTH '<' FROM '<<<<a<bc<<'),'**');
SELECT TRIM(TRAILING '>' FROM TRIM(LEADING '<' FROM '<<a<b>c>>'));  	

#pad(문자열, 전체length, 채울 문자열)
SELECT concat(LPAD('hong',10,'*'),RPAD('*',6,'*'));
SELECT LPAD('hong',3,'*'); #전체 length가 문자열보다 작으면 짤림

	
#Date & Time function
SELECT hire_date, YEAR(hire_date) FROM employees; #숫자 타입으로 바뀐다
SELECT NOW(), 
	DATE(NOW()), last_day(NOW()+INTERVAL 8 day),
	MONTHNAME(NOW()),QUARTER(NOW()),
	DAY(NOW()), 
	DAYNAME(NOW()), DAYOFWEEK(NOW()), 
	DAYOFYEAR(NOW()),
	HOUR(NOW());
# day() == dayofmonth()
#dataname은 요일, dayofweek은 숫자(일요일부터 1)

SELECT NOW(), 
	NOW()+INTERVAL 1 SECOND, 
	NOW()+INTERVAL 2 MINUTE,
	NOW()-INTERVAL 3 DAY, 
	NOW()+INTERVAL 1 year;
SELECT NOW(), 
	NOW()+INTERVAL '10:10' MINUTE_SECOND, 
	NOW()-INTERVAL '1:00:00' HOUR_SECOND, 
	NOW()+INTERVAL '1:1' YEAR_MONTH;
SELECT add_months('2024-01-01',-3);
SELECT NOW(), ADDDATE(NOW(),-10), ADDDATE(NOW(), INTERVAL -20 DAY);
SELECT NOW(), ADDTIME(NOW(),'1:0:0'); 
SELECT NOW(), curdate(), CURRENT_DATE(), CURRENT_TIME(), CURTIME();
SELECT DATEDIFF(NOW(),'2024-03-01');
SELECT EXTRACT(YEAR FROM NOW()), YEAR(NOW());
#일년을 주차별로 계산, 모드에 따라 기준 다름 
SELECT WEEK('2024-01-01',0), WEEK('2024-01-01',1),WEEK('2024-01-01',2),
	WEEK('2024-01-01',3), WEEK('2024-01-01',4), WEEK('2024-01-01',5),
	WEEK('2024-01-01',6), WEEK('2024-01-01',7);
SELECT DATE_FORMAT(NOW(),'%Y-%m-%d');
SELECT DATE_FORMAT(NOW(), '%i %U %u %w');


#cast, convert, to_char
SELECT emp_no, CAST(emp_no AS CHAR), CAST(birth_date AS CHAR),
	CAST(DATE_FORMAT(birth_date,'%Y-%m') AS INT),
	CONVERT(birth_date,int), CONVERT('1000',INT), CONVERT('2024-03-26',DATE)
FROM employees;
SELECT NOW(), DATE_FORMAT(NOW(),'%Y-%m-%d'), to_char(NOW(), 'hh:mi:ss'),
	to_char(NOW(),'DD DY DAY'), to_char(NOW(),'MONTH MON');

SELECT first_name
from employees
where MIN(char_LENGTH(first_name));
