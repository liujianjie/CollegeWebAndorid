--���м�¼����ɵļ���
declare
  --�����α�
  cursor cur_emp is 
         select * from emp;
  --�����α����
  v_cur_emp cur_emp%rowtype;--�α�ļ�¼����       
begin
  open cur_emp;--���α�
       loop
           fetch cur_emp into v_cur_emp;--ѭ����ȡ�α꣨��ü�¼��
           exit when cur_emp%notfound;--����ȡ���α�û�м�¼ʱ���˳�ѭ��
           dbms_output.put_line('Ա������:'||v_cur_emp.ename||' ���ʣ�'||v_cur_emp.sal);
       end loop;
  close cur_emp;--�ر��α�
    
  --ѭ���α�
  for v_emp in (select * from emp)
  loop
      dbms_output.put_line('Ա������:'||v_emp.ename||' ���ʣ�'||v_emp.sal);
  end loop;
end;