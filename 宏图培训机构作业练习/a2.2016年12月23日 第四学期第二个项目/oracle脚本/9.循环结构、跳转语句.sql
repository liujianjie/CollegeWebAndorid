--ѭ���ṹ
declare
       v_num1 number(3):=0;
       v_num2 number(3):=0;
begin
     <<label_loop1>>
     loop
         exit label_loop1 when v_num1>100;
         dbms_output.put_line(v_num1);
         v_num1:=v_num1+1;
     end loop label_loop1;
    
     <<label_loop2>>
     while v_num2<=100
     loop
          dbms_output.put_line(v_num2);
          v_num2:=v_num2+1;
     end loop label_loop2;
     
     <<lable_loop3>>
     for i in 0..100
     loop
       if i=3 then
          goto label_out;--������continue������goto��ֱ����ת����Ǵ���label�����Ӷ�ʡ���м�����ִ��
       end if;
       dbms_output.put_line('i:'||i);
       <<label_out>>
       if i=33 then
          exit lable_loop3;--�˳�ѭ��
       end if;
       if i=66 then
          null;--��ռλ����֤����������
       end if;
     end loop lable_loop3;
end;