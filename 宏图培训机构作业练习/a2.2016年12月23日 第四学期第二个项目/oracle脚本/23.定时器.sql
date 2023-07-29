--定时任务（JOB）
DECLARE
  v_job_id BINARY_INTEGER;
BEGIN
  dbms_job.submit(job       => v_job_id,--JOB创建后的ID
                  what      => 'emp_crud_pkg.proc_timer_run(''job'');',--JOB调用的过程
                  next_date => SYSDATE,--JOB下一次的执行时间（创建时第一次）
                  INTERVAL  => 'sysdate+5/1440'--JOB的执行间隔，5分钟一次
                  );
            dbms_output.put_line(v_job_id);      
  COMMIT;
END;