DECLARE
  v_info_id informations.id%TYPE; --引用informations的id类型作为变量类型
BEGIN
  --获得informations的主键，并用insert和replies的外键
  SELECT seq_info.NEXTVAL INTO v_info_id FROM dual;
  INSERT INTO informations
    (id, title, content, replycount, viewcount, reporttime, lastposttime)
  VALUES
    (v_info_id,
     'android开发者',
     'GOOGLE 开发者预览版可以下载了',
     1,
     0,
     SYSDATE,
     SYSDATE);
     
  INSERT INTO replies
    (id, content, replytime, infoid)
  VALUES
    (seq_replies.NEXTVAL, 'ANDROID很好很强大', SYSDATE, v_info_id);
--
  SELECT seq_info.NEXTVAL INTO v_info_id FROM dual;
  INSERT INTO informations
    (id, title, content, replycount, viewcount, reporttime, lastposttime)
  VALUES
    (v_info_id,
     'IOS开发者',
     'Apple 开发者预览版可以下载了',
     1,
     0,
     SYSDATE,
     SYSDATE);
  INSERT INTO replies
    (id, content, replytime, infoid)
  VALUES
    (seq_replies.NEXTVAL, 'IPAD很好很强大', SYSDATE, v_info_id);
--
  SELECT seq_info.NEXTVAL INTO v_info_id FROM dual;
  INSERT INTO informations
    (id, title, content, replycount, viewcount, reporttime, lastposttime)
  VALUES
    (v_info_id,
     '.NET开发者',
     'Microsoft 开发者预览版可以下载了',
     1,
     0,
     SYSDATE,
     SYSDATE);
  INSERT INTO replies
    (id, content, replytime, infoid)
  VALUES
    (seq_replies.NEXTVAL, 'WINDOWS很好很强大', SYSDATE, v_info_id);
  COMMIT;
END;
/