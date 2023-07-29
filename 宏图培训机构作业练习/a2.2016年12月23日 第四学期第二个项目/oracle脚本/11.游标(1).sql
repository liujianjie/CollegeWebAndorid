--多行记录所组成的集合
declare
  --声明游标
  cursor cur_emp is 
         select * from emp;
  --声明游标变量
  v_cur_emp cur_emp%rowtype;--游标的记录类型       
begin
  open cur_emp;--打开游标
       loop
           fetch cur_emp into v_cur_emp;--循环提取游标（获得记录）
           exit when cur_emp%notfound;--但提取的游标没有记录时，退出循环
           dbms_output.put_line('员工姓名:'||v_cur_emp.ename||' 工资：'||v_cur_emp.sal);
       end loop;
  close cur_emp;--关闭游标
    
  --循环游标
  for v_emp in (select * from emp)
  loop
      dbms_output.put_line('员工姓名:'||v_emp.ename||' 工资：'||v_emp.sal);
  end loop;
end;