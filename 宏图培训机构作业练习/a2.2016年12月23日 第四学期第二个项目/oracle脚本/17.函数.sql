/*
  函数只有一个返回值，可以用于任何的sql语句，可以赋值给程序变量
*/
create or replace function func_return_money(p_empno in emp.empno%type)
       return number
      is
      v_money number;
      v_sal emp.sal%type;
begin
select sal into v_sal from emp where empno=p_empno;
       v_money:=v_sal*0.03;
      return v_money;
end   func_return_money;
/