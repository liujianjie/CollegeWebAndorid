create or replace procedure proc_show_my_name(p_name in varchar2)is
--��������
begin
--ִ�� ����
dbms_output.put_line('�ҵ������ǣ�'||p_name);
end proc_show_my_name;
/