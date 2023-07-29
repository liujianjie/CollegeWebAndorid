--调用方法
declare
bln boolean;
begin
  bln:=a_pack.deal_bhave2;
  if bln then
    dbms_output.put_line('有值');
  else
    dbms_output.put_line('无值');
  end if;
end;

--调用存储过程
call
a_pack.sel_btoa(1);
commit;

select * from a
