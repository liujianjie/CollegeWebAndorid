
declare
begin
dbms_job.run(job => 23);--�����ָ�ִ��
commit;
end;
--JOB�޸�
declare
begin
dbms_job.change(job => 23,what => 'emp_crud_pkg.proc_timer(''job'');', 
                    next_date => SYSDATE,--JOB��һ�ε�ִ��ʱ�䣨����ʱ��һ�Σ�
                  INTERVAL  => 'sysdate+5/1440');--JOB��ִ�м����5����һ��);
commit;
end;
--ɾ��JOB
declare
begin
dbms_job.remove(23);
commit;
end;
