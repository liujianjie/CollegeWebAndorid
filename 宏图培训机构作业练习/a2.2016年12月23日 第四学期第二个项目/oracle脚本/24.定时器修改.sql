
declare
begin
dbms_job.run(job => 23);--立即恢复执行
commit;
end;
--JOB修改
declare
begin
dbms_job.change(job => 23,what => 'emp_crud_pkg.proc_timer(''job'');', 
                    next_date => SYSDATE,--JOB下一次的执行时间（创建时第一次）
                  INTERVAL  => 'sysdate+5/1440');--JOB的执行间隔，5分钟一次);
commit;
end;
--删除JOB
declare
begin
dbms_job.remove(23);
commit;
end;
