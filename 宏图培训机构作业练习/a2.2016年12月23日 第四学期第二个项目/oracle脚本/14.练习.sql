--2-3.
declare
v_empno emp.empno%type:=7369;
v_sal   emp.sal%type;
begin
     select sal into v_sal from emp_bak where empno=v_empno;
     if v_sal<1500 then
        delete from emp_bak where empno=v_empno;
     else
         dbms_output.put_line('��ϲ�㣬��ù���');
     end if;
end;
--2-4:
declare
cursor cur_emp is 
       select * from  emp_bak;
v_cur_emp cur_emp%rowtype;       
begin
     open cur_emp;
     loop
         fetch cur_emp into v_cur_emp;
         exit when cur_emp%notfound;
         if v_cur_emp.sal<2000 then
            dbms_output.put_line('�����ǹ���');
          else
              dbms_output.put_line('��Ĺ����Ѵ��');
         end if;
     end loop;
     close cur_emp;
end;

