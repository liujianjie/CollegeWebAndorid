/*
package�����ã�1.���ڰ�װ��ͬ��ҵ��Ĵ洢���̼�����
               2.���û���Ȩ���Ա��ⱻ�Է���ȡ��ҵ����룬ֻ�ܶ�ȡ��ͷ����
package�ɰ�ͷ�Ͱ��������
��ͷֻ���������̺ͺ���������ʵ��,������java����Ľӿ�
����ʵ���߼�
*/
create or replace package emp_crud_pkg is--������ͷ
--�������̼�����
procedure proc_show_my_name(p_name in varchar2);

procedure proc_return_money(p_empno in emp.empno%type,v_money out number);

function func_return_money(p_empno in number) return number;
end emp_crud_pkg;
/