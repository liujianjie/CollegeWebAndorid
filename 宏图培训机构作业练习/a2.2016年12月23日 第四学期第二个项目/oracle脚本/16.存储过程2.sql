/*
  ����out�����Ĵ洢���̣����з���ֵ��in�Ĳ���ֻ����Σ����ܸ�ֵ�ͷ���
*/
create or replace procedure proc_return_money(p_empno in emp.empno%type,v_money out number)
is
v_sal emp.sal%type;
begin
     select sal into v_sal from emp where empno=p_empno;
     v_money:=v_sal*0.03;
end proc_return_money;
/