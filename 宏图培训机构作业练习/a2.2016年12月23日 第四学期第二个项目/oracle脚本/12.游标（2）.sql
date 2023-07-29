--根据部门编号得到不同的数据
declare
cursor cur_emp(c_dept_no in number) is
       select * from  emp where deptno=c_dept_no;
v_deptno emp.deptno%type:=10;
v_cur_emp cur_emp%rowtype;       
begin
    open cur_emp(v_deptno);
         loop
             fetch cur_emp into v_cur_emp;
             exit when cur_emp%notfound;
              dbms_output.put_line('员工姓名:'||v_cur_emp.ename||' 工资：'||v_cur_emp.sal);             
         end loop;
    close cur_emp; 
end;