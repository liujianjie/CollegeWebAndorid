--预定义异常：ORACLE提供的异常分类
--自定义异常：用户自定义的异常
declare
       v_name emp.ename%type;
       ex_my_exception exception;--自定义异常,一般业务问题，可以手动抛出异常
       v_money number(5):=8888;
begin
     raise_application_error(-20160,'今天很多异常');--类似于自定义异常，但无法精准捕获，只能通过others来处理
     if v_money<10000 then
        raise ex_my_exception;--手动抛异常
     end if;
     
     dbms_output.put_line(0/0);
     --select into必须且只能返回一条记录，不是一条就会出异常
     --too_many_rows:返回多行记录
     --no_data_found:无记录
     select ename into v_name from emp where 1<>1;
     dbms_output.put_line('员工姓名：'||v_name);
     exception
           when ex_my_exception then
              dbms_output.put_line('资金不足，编号：'||sqlcode||':'||sqlerrm);
           when too_many_rows then
              dbms_output.put_line('返回的数据行太多,编号：'||sqlcode||'：'||sqlerrm);
           when no_data_found then
               dbms_output.put_line('无数据，编码：'||sqlcode||':'||sqlerrm); 
           when others then--放在最后
           dbms_output.put_line('其他异常,编号：'||sqlcode||':'||sqlerrm);  
end;