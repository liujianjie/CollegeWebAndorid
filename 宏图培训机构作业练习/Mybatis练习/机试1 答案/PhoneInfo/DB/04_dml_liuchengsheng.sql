DECLARE
  v_info_id informations.id%TYPE; --����informations��id������Ϊ��������
BEGIN
  --���informations������������insert��replies�����
  SELECT seq_info.NEXTVAL INTO v_info_id FROM dual;
  INSERT INTO informations
    (id, title, content, replycount, viewcount, reporttime, lastposttime)
  VALUES
    (v_info_id,
     'android������',
     'GOOGLE ������Ԥ�������������',
     1,
     0,
     SYSDATE,
     SYSDATE);
     
  INSERT INTO replies
    (id, content, replytime, infoid)
  VALUES
    (seq_replies.NEXTVAL, 'ANDROID�ܺú�ǿ��', SYSDATE, v_info_id);
--
  SELECT seq_info.NEXTVAL INTO v_info_id FROM dual;
  INSERT INTO informations
    (id, title, content, replycount, viewcount, reporttime, lastposttime)
  VALUES
    (v_info_id,
     'IOS������',
     'Apple ������Ԥ�������������',
     1,
     0,
     SYSDATE,
     SYSDATE);
  INSERT INTO replies
    (id, content, replytime, infoid)
  VALUES
    (seq_replies.NEXTVAL, 'IPAD�ܺú�ǿ��', SYSDATE, v_info_id);
--
  SELECT seq_info.NEXTVAL INTO v_info_id FROM dual;
  INSERT INTO informations
    (id, title, content, replycount, viewcount, reporttime, lastposttime)
  VALUES
    (v_info_id,
     '.NET������',
     'Microsoft ������Ԥ�������������',
     1,
     0,
     SYSDATE,
     SYSDATE);
  INSERT INTO replies
    (id, content, replytime, infoid)
  VALUES
    (seq_replies.NEXTVAL, 'WINDOWS�ܺú�ǿ��', SYSDATE, v_info_id);
  COMMIT;
END;
/