/*
  带有out参数的存储过程，会有返回值，in的参数只是入参，不能赋值和返回
*/
create or replace procedure proc_return_money(p_empno in emp.empno%type,v_money out number)
is
v_sal emp.sal%type;
begin
     select sal into v_sal from emp where empno=p_empno;
     v_money:=v_sal*0.03;
end proc_return_money;
/