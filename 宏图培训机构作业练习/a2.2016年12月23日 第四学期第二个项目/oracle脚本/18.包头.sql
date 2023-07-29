/*
package的作用：1.用于包装相同的业务的存储过程及函数
               2.跨用户授权可以避免被对方读取到业务代码，只能读取包头代码
package由包头和包体所组成
包头只能声明过程和函数，不能实现,类似于java程序的接口
包体实现逻辑
*/
create or replace package emp_crud_pkg is--创建包头
--声明过程及函数
procedure proc_show_my_name(p_name in varchar2);

procedure proc_return_money(p_empno in emp.empno%type,v_money out number);

function func_return_money(p_empno in number) return number;
end emp_crud_pkg;
/