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
           if v_cur_emp.comm is null then
              update  emp set comm=300 where empno=v_cur_emp.empno;
           end if;
       end loop;
  close cur_emp;--关闭游标
end;
commit;

select * from  emp where comm is null;