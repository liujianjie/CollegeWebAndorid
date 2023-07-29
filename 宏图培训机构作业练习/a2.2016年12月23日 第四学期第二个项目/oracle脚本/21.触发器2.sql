create trigger tri_u_emp
 after update on emp
 for each row
 begin
 insert into emp_bak(empno,ename,job,mgr,hiredate,sal,comm,deptno)
 values(:old.empno,:old.ename,:old.job,:old.mgr,:old.hiredate,:old.sal,:old.comm,:old.deptno);
 end tri_u_emp;
/