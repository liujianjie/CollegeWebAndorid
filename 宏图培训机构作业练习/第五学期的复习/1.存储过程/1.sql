/*�ô洢����ʵ�֣�
*--1.����3k��Ա����н��3K
*--2.û�и�����Ա��������300����
*--3.����3k��Ա������н10%
*--4.������ְʱ���10��
*--5.ְλΪMANAGER��Ա��ͳһ�ҿ���ceo��
*/
select * from emp
create or replace procedure pro_emp_manage is
       --�������֣�
       Cursor cur_a is select * from emp;
       cur_b  cur_a%rowtype;
       ceo_id emp.empno%type;
       begin
              --���ceo��empno
              select empno into ceo_id from emp where job = 'ceo';
              open cur_a;
              Loop
                   fetch cur_a
                         into cur_b;
                   exit when cur_a%notfound;
                   --1.����3k��Ա����н��3K
                   if cur_b.sal<3000 then
                      update emp set sal=sal+3000 where empno = cur_b.empno;
	                           elsif cur_b.sal>=3000 then
                                   --3.����3k��Ա������н10%
                                   update emp set sal=sal+sal*0.1 where empno = cur_b.empno;
                   end if;
                   --2.û�и�����Ա��������300����
                   if cur_b.comm is null then
                      update emp set comm=nvl(comm,0)+300 where empno = cur_b.empno;
                   end if;
                   --4.������ְʱ���10��
                   update emp set hiredate = add_months(trunc(hiredate,'month'),120) where empno = cur_b.empno;
                   --5.ְλΪMANAGER��Ա��ͳһ�ҿ���ceo��
                   if cur_b.job='manager' then
                     update emp set mgr = ceo_id where  empno = cur_b.empno;
                   end if;
              end loop;
              close cur_a;

       end pro_emp_manage;
       
--����
call pro_emp_manage();
