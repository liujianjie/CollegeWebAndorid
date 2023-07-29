--触发器：在数据操作前后所触发的逻辑，称为触发器
--触发器伪列： NEW OLD
--触发器和DML语句是同一个事务
--触发器的类型：insert update delete
--触发器的时机：before after
create trigger tri_d_emp
 before delete on emp
 for each row
 begin
 insert into emp_bak(empno,ename,job,mgr,hiredate,sal,comm,deptno)
 values(:old.empno,:old.ename,:old.job,:old.mgr,:old.hiredate,:old.sal,:old.comm,:old.deptno);
 end tri_d_emp;
/
 
 
 