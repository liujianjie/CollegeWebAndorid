--Ԥ�����쳣��ORACLE�ṩ���쳣����
--�Զ����쳣���û��Զ�����쳣
declare
       v_name emp.ename%type;
       ex_my_exception exception;--�Զ����쳣,һ��ҵ�����⣬�����ֶ��׳��쳣
       v_money number(5):=8888;
begin
     raise_application_error(-20160,'����ܶ��쳣');--�������Զ����쳣�����޷���׼����ֻ��ͨ��others������
     if v_money<10000 then
        raise ex_my_exception;--�ֶ����쳣
     end if;
     
     dbms_output.put_line(0/0);
     --select into������ֻ�ܷ���һ����¼������һ���ͻ���쳣
     --too_many_rows:���ض��м�¼
     --no_data_found:�޼�¼
     select ename into v_name from emp where 1<>1;
     dbms_output.put_line('Ա��������'||v_name);
     exception
           when ex_my_exception then
              dbms_output.put_line('�ʽ��㣬��ţ�'||sqlcode||':'||sqlerrm);
           when too_many_rows then
              dbms_output.put_line('���ص�������̫��,��ţ�'||sqlcode||'��'||sqlerrm);
           when no_data_found then
               dbms_output.put_line('�����ݣ����룺'||sqlcode||':'||sqlerrm); 
           when others then--�������
           dbms_output.put_line('�����쳣,��ţ�'||sqlcode||':'||sqlerrm);  
end;