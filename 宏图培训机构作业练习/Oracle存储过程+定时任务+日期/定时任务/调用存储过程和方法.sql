--���÷���
declare
bln boolean;
begin
  bln:=a_pack.deal_bhave2;
  if bln then
    dbms_output.put_line('��ֵ');
  else
    dbms_output.put_line('��ֵ');
  end if;
end;

--���ô洢����
call
a_pack.sel_btoa(1);
commit;

select * from a
