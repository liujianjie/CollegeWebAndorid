/*用存储过程实现：
*--1.低于3k的员工涨薪至3K
*--2.没有福利的员工，增加300福利
*--3.高于3k的员工，涨薪10%
*--4.所有入职时间加10年
*--5.职位为MANAGER的员工统一挂靠在ceo下
*/
select * from emp
create or replace procedure pro_emp_manage is
       --声明部分：
       Cursor cur_a is select * from emp;
       cur_b  cur_a%rowtype;
       ceo_id emp.empno%type;
       begin
              --查出ceo的empno
              select empno into ceo_id from emp where job = 'ceo';
              open cur_a;
              Loop
                   fetch cur_a
                         into cur_b;
                   exit when cur_a%notfound;
                   --1.低于3k的员工涨薪至3K
                   if cur_b.sal<3000 then
                      update emp set sal=sal+3000 where empno = cur_b.empno;
	                           elsif cur_b.sal>=3000 then
                                   --3.高于3k的员工，涨薪10%
                                   update emp set sal=sal+sal*0.1 where empno = cur_b.empno;
                   end if;
                   --2.没有福利的员工，增加300福利
                   if cur_b.comm is null then
                      update emp set comm=nvl(comm,0)+300 where empno = cur_b.empno;
                   end if;
                   --4.所有入职时间加10年
                   update emp set hiredate = add_months(trunc(hiredate,'month'),120) where empno = cur_b.empno;
                   --5.职位为MANAGER的员工统一挂靠在ceo下
                   if cur_b.job='manager' then
                     update emp set mgr = ceo_id where  empno = cur_b.empno;
                   end if;
              end loop;
              close cur_a;

       end pro_emp_manage;
       
--调用
call pro_emp_manage();
