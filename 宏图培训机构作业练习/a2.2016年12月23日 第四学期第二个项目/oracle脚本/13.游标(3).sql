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
           if v_cur_emp.comm is null then
              update  emp set comm=300 where empno=v_cur_emp.empno;
           end if;
       end loop;
  close cur_emp;--�ر��α�
end;
commit;

select * from  emp where comm is null;