/*
	周末不做数据修改
*/
CREATE TRIGGER tri_iud_emp
  BEFORE INSERT OR UPDATE OR DELETE ON emp
  FOR EACH ROW
BEGIN
  IF to_char(SYSDATE, 'DAY') IN ('星期六', '星期日') THEN
    raise_application_error(-20999, '非工作日数据不可操作');
  END IF;
END tri_iud_emp;
/
