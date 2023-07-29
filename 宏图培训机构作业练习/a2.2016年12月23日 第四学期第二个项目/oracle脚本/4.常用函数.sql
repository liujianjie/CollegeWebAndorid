--1.字符函数
select upper('oracle'),lower('JAVA') from dual;
--左右追加,长度不足的情况下，向左补充字符
select lpad(10,3,0)  from dual;
select rpad(10,4,'#') from dual;

--2.数字函数
select round(3.15,1) from dual;--四舍五入
select trunc(3.14159,3) from  dual;--非四舍五入

--3.日期函数
select sysdate from dual;--当期时间
select sysdate+1 from dual;--明天
select sysdate-1 from dual;--昨天
select add_months(sysdate,1) from  dual;--下一个月的今天
select next_day(sysdate,7) from dual;--下一个星期几，星期天：1-—星期六：7
select last_day(sysdate) from dual; --每月最后一天
select trunc(sysdate) from dual;--当天日期（凌晨0点）
select trunc(sysdate,'yyyy') from dual;--当年第一天(0点)
select trunc(sysdate,'MM') from dual;--当月第一天(0点)

select trunc(sysdate)+((30/60+7)/60+18)/24 from dual;--当天 18:07:30
--4.转换函数
select to_date('2008-08-08 08:08:08','yyyy-MM-dd hh24:mi:ss') from dual;--字符串转日期
select to_char(sysdate,'yyyy-MM-dd hh24:mi:ss') from dual;--日期转字符串
--格式化数字
select to_char(8758768767868.9878,'999,999,999,999,990.00') from dual;
select to_number('7687')+1 from dual;--字符串转数字
--5.其他函数
select nvl('me','你是空的') from dual;--如果空取后面那个参数
select nvl2('me','你是不空的','你是空的') from dual;--如果不为空取第一个参数，否则去最后一个参数
select decode('xxxx','a','我是a','b','null','else') from dual;--第一个参数和偶数项比较，如果匹配，取该项后面的值