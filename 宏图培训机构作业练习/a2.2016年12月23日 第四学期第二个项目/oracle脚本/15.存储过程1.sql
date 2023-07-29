create or replace procedure proc_show_my_name(p_name in varchar2)is
--声明部分
begin
--执行 部分
dbms_output.put_line('我的姓名是：'||p_name);
end proc_show_my_name;
/