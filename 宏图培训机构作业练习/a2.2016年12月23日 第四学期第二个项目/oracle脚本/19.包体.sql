CREATE OR REPLACE PACKAGE BODY emp_crud_pkg IS

  PROCEDURE proc_show_my_name(p_name IN VARCHAR2) IS
  BEGIN
    dbms_output.put_line('我的姓名是：' || p_name);
  END proc_show_my_name;

  PROCEDURE proc_return_money(p_empno IN emp.empno%TYPE,
                              v_money OUT NUMBER) IS
    v_sal emp.sal%TYPE;
  BEGIN
    SELECT sal INTO v_sal FROM emp WHERE empno = p_empno;
    v_money := v_sal * 0.03;
  END proc_return_money;

  FUNCTION func_return_money(p_empno IN NUMBER) RETURN NUMBER IS
    v_money NUMBER;
    v_sal   emp.sal%TYPE;
  BEGIN
    SELECT sal INTO v_sal FROM emp WHERE empno = p_empno;
    v_money := v_sal * 0.03;
    RETURN v_money;
  END func_return_money;

END emp_crud_pkg;
/