--ѡ��ṹ
declare
v_score number(3):=68;
v_num   number(1):=2;
begin
     if v_score>80 then
        dbms_output.put_line('����һ��MP3');
     else
         dbms_output.put_line('����');
     end if ;
  
     --��ǰ�������н���
     if v_num=1 then
          dbms_output.put_line('����һ̨�ʼǱ�');
     elsif v_num=2 then
           dbms_output.put_line('����һ�����г�');
     elsif v_num=3 then
           dbms_output.put_line('����һ���ƶ�Ӳ��');
     else
           dbms_output.put_line('�޽���');
     end if;
     --case
     --��ӱ�ǩ������ģ�黯������ͬ�﷨�Ĵ����������
     <<label_case1>>
     case
         when v_num=1 then
           dbms_output.put_line('����һ̨�ʼǱ�');
         when v_num=2 then
           dbms_output.put_line('����һ�����г�');
         when v_num=3 then
           dbms_output.put_line('����һ���ƶ�Ӳ��');
          else
           dbms_output.put_line('�޽���');
     end case label_case1;
     
     <<label_case2>>
     case v_num
         when 1 then
           dbms_output.put_line('����һ̨�ʼǱ�');
         when 2 then
           dbms_output.put_line('����һ�����г�');
         when 3 then
           dbms_output.put_line('����һ���ƶ�Ӳ��');
          else
           dbms_output.put_line('�޽���');
     end case label_case2;
end;