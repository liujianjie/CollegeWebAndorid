--��ʱ����JOB��
DECLARE
  v_job_id BINARY_INTEGER;
BEGIN
  dbms_job.submit(job       => v_job_id,--JOB�������ID
                  what      => 'emp_crud_pkg.proc_timer_run(''job'');',--JOB���õĹ���
                  next_date => SYSDATE,--JOB��һ�ε�ִ��ʱ�䣨����ʱ��һ�Σ�
                  INTERVAL  => 'sysdate+5/1440'--JOB��ִ�м����5����һ��
                  );
            dbms_output.put_line(v_job_id);      
  COMMIT;
END;