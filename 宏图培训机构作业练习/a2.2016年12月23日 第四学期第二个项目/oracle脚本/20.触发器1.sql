--�������������ݲ���ǰ�����������߼�����Ϊ������
--������α�У� NEW OLD
--��������DML�����ͬһ������
--�����������ͣ�insert update delete
--��������ʱ����before after
create trigger tri_d_emp
 before delete on emp
 for each row
 begin
 insert into emp_bak(empno,ename,job,mgr,hiredate,sal,comm,deptno)
 values(:old.empno,:old.ename,:old.job,:old.mgr,:old.hiredate,:old.sal,:old.comm,:old.deptno);
 end tri_d_emp;
/
 
 
 