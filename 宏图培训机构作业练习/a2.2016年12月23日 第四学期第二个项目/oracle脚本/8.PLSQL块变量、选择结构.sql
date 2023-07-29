--选择结构
declare
v_score number(3):=68;
v_num   number(1):=2;
begin
     if v_score>80 then
        dbms_output.put_line('奖励一个MP3');
     else
         dbms_output.put_line('补考');
     end if ;
  
     --对前三名进行奖励
     if v_num=1 then
          dbms_output.put_line('奖励一台笔记本');
     elsif v_num=2 then
           dbms_output.put_line('奖励一辆自行车');
     elsif v_num=3 then
           dbms_output.put_line('奖励一块移动硬盘');
     else
           dbms_output.put_line('无奖励');
     end if;
     --case
     --添加标签，代码模块化，对相同语法的代码进行区分
     <<label_case1>>
     case
         when v_num=1 then
           dbms_output.put_line('奖励一台笔记本');
         when v_num=2 then
           dbms_output.put_line('奖励一辆自行车');
         when v_num=3 then
           dbms_output.put_line('奖励一块移动硬盘');
          else
           dbms_output.put_line('无奖励');
     end case label_case1;
     
     <<label_case2>>
     case v_num
         when 1 then
           dbms_output.put_line('奖励一台笔记本');
         when 2 then
           dbms_output.put_line('奖励一辆自行车');
         when 3 then
           dbms_output.put_line('奖励一块移动硬盘');
          else
           dbms_output.put_line('无奖励');
     end case label_case2;
end;