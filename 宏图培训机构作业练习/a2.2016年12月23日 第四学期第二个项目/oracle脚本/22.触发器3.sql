/*
	��ĩ���������޸�
*/
CREATE TRIGGER tri_iud_emp
  BEFORE INSERT OR UPDATE OR DELETE ON emp
  FOR EACH ROW
BEGIN
  IF to_char(SYSDATE, 'DAY') IN ('������', '������') THEN
    raise_application_error(-20999, '�ǹ��������ݲ��ɲ���');
  END IF;
END tri_iud_emp;
/
