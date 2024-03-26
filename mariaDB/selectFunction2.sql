USE hr;

SELECT employee_id, first_name, hire_date, email, salary
FROM employees;

# 직장상사 
SELECT employee_id, first_name, hire_date, ifnull(manager_id,'CEO') AS 직장상사
FROM employees;

# 연봉 
SELECT employee_id, first_name, salary, hire_date, job_id, department_id, salary*(1+ifnull(commission_pct,0))
FROM employees; 


#control flow function
#ifnull은 mariadb에만 있다. 
SELECT commission_pct, IFNULL(commission_pct,0), nvl(commission_pct,0)
FROM employees;
#nvl은 있으면 출력 없으면 대체 / nvl2는 있으면 대체1, 없으면 대체2
SELECT nvl(commission_pct,0), nvl2(commission_pct, 'true', 'false') 
FROM employees;

SELECT commission_pct, ISNULL(commission_pct) FROM employees;

SELECT NULLIF(10,10), NULLIF(20,10), NULLIF('hong','hong'), NULLIF(null,20);

#if는 조건부로 결과를 표시 (where절과 헷갈리지 말 것)
SELECT employee_id, if(employee_id%2=0,'even','odd') AS result
FROM employees;
#else값을 안 넣으면 실행되지 않는다. 
SELECT employee_id, first_name, salary, if(salary>=10000, 'good','') AS result
FROM employees
ORDER BY salary DESC;

#decode, case..when..then
SELECT employee_id, first_name, department_id,
	DECODE_oracle(department_id, 10,'marketing',20,'finanace',30,'human resources',40,'development','others') AS result
FROM employees;

SELECT employee_id, first_name, department_id,
	case department_id when 10 then 'marketing' 
							 when 20 then 'finanace'
							 when 30 then 'human resources'
							 when 40 then 'deveplopment'
							 ELSE 'others'
	END AS result						 
FROM employees;

SELECT employee_id, first_name, department_id,
	case when department_id = 10 then 'marketing'
		  when department_id = 20 then 'finanace'
		  when department_id = 30 then 'human resources'
		  when department_id = 40 then 'development'
		  else 'others'
	end as result
from employees;		  

#decode는 switch문과 비슷한 방법으로 접근 
SELECT employee_id, first_name, hire_date, salary, 
	decode_oracle(salary DIV 4000,0,'low',1,'middle',2,'middle','high') AS result
FROM employees;

#case when then은 비교적 if문 처럼 쓸 수 있다. 
SELECT employee_id, first_name, hire_date, salary
	, case when salary DIV 4000 = 0 then 'low'
	       when salary DIV < 3 then 'middle'
	       ELSE 'high'
	END AS result
FROM employees;

SELECT employee_id, first_name, hire_date, salary
	, case when salary < 4000 then 'low'
	       when salary >=4000 AND salary <12000 then 'middle'
	       ELSE 'high'
	END AS result
FROM employees;


#aggregate functions
USE employees;

#count(*)은 null 포함, 즉 테이블의 row 개수, avg는 null을 제외한 결과
SELECT COUNT(*), COUNT(kor), SUM(kor), AVG(kor), MAX(kor), MIN(kor)
FROM sungjuck;

/* group by : row들을 grouping 해서 function 적용
group by 사용시 주의할 점은, select 항목에 row 하나에 해당하는 정보가 오면 안 된다. 
group에 대한 정보가 올 수는 있다.
*/
# select에 함수만 있고 그룹에 대한 컬럼이 없는 경우 전체에 대한 집계이다. 
SELECT COUNT(kor), AVG(kor)
FROM sungjuck;
# select에 그룹에 대한 컬럼이 있는 경우 각 그룹을 단위로 row를 구성한다. 
SELECT hak, COUNT(kor), AVG(kor)
FROM sungjuck
GROUP BY hak;
# group은 n개일 수 있다. 
SELECT hak, ban, AVG(kor)
FROM sungjuck
GROUP BY hak, ban;
#grouping한 row 중 조건에 해당하는 것만 보려면 having (그룹집계 후 컨디션 적용)
SELECT hak, AVG(kor)
FROM sungjuck
GROUP BY hak
HAVING hak = 1;
#where는 개별적으로 조건을 적용해 미리 필터링 한다. (컨디션 적용 후 그룹집계)
SELECT hak, AVG(kor)
FROM sungjuck
WHERE hak=1
GROUP BY hak;

	