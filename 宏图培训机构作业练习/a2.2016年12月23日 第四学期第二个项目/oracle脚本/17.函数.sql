/*
  ����ֻ��һ������ֵ�����������κε�sql��䣬���Ը�ֵ���������
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