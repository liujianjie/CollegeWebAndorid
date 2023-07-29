--��ʼд�洢����
/*
1.��Ӳ�������
2.�����洢����ʵ�ֿ������ܣ�����ҵ��������û���userinfo���һ����¼��ͬʱ���˻���
cardinifo�ͽ��׼�¼��transinfo������һ����¼
3.�����洢����ʵ��ȡ��ҵ����Ҫ��transinfo�����һ����¼�����޸�cardinfo���ж�Ӧ�˺�
���
4.�����洢����ʵ��ת��ҵ����������˻���ת10000Ԫ�����ġ���Ҫ��transinfo�����������¼
�����޸�cardinfo���ж�Ӧ�˻�����

*/

--��ͷ
create or replace package bank_pack is
       procedure adduser(
                         user_name in varchar2,
                         user_gender in char,
                         user_tel in varchar2,
                         user_card in char);--2
       procedure outmoney(p_card_id in varchar2,
                          p_out_money in number);--3 ���ź�ȡ��ֵ
       procedure tomoney(p_ycard_id in varchar2,
                         p_money in number,
                         p_tcard_id in varchar2);--4 Դ���ţ�Ǯ��Ŀ�꿨��
end bank_pack;

/

--��ı�д
create or replace package body bank_pack is
       procedure adduser(
                         user_name in varchar2,
                         user_gender in char,
                         user_tel in varchar2,
                         user_card in char) is
        -- userid number:=userinfo_user_id.nextval;
         cardid varchar2(32);
         begin
           --ҵ��2
           select sys_guid() into cardid from dual;
           insert into userinfo values(userinfo_user_id.nextval,user_name,user_gender,user_tel,user_card);--�¸�ֵ

           insert into cardinfo values(cardid,userinfo_user_id.currval,'��ͨ��','Ǯ',0);--��ǰֵ
           dbms_output.put_line('����Ϊ��'||cardid);
         end adduser;
       procedure outmoney(p_card_id in varchar2,
                          p_out_money in number) is
         currentmoney number(18,2);--ʣ��Ǯ
         begin
              --ҵ��3
              --�Ȳ�ѯ��������Ƿ�ȡ
              select current_money into currentmoney from cardinfo where card_id = p_card_id;
              if currentmoney>=p_out_money then
                 --�ȼ�������
                 update cardinfo set current_money = currentmoney-p_out_money where card_id= p_card_id;

                 --��ӽ��׼�¼
                 insert into transinfo values(sys_guid(),p_card_id,sysdate,'ȡ��',p_out_money);
                 elsif currentmoney<p_out_money then
                 dbms_output.put_line('���㣬ȡ��ʧ�ܡ�');

              end if;

         end outmoney;
       procedure tomoney(p_ycard_id in varchar2,
                         p_money in number,
                         p_tcard_id in varchar2) is
         currentmoney number(18,2);
         begin
             --ҵ��4
             --�Ȳ�ѯ��������Ƿ�ȡ
             select current_money into currentmoney from cardinfo where card_id = p_ycard_id;


             if currentmoney>=p_money then
                --����Ǯ
                update cardinfo set current_money = current_money-p_money where card_id = p_ycard_id;
                --����Ǯ
                update cardinfo set current_money = current_money+p_money where card_id = p_tcard_id;
                --��ӽ��׼�¼
                 insert into transinfo values(sys_guid(),p_ycard_id,sysdate,'ת��',p_money);
                 insert into transinfo values(sys_guid(),p_tcard_id,sysdate,'����',p_money);
                elsif currentmoney<p_money then
                 dbms_output.put_line('���㣬ת��ʧ�ܡ�');

             end if;
             

         end tomoney;


end bank_pack;
/


--����
declare
begin
   bank_pack.adduser('С��','Ů','18160774016','360732199812102638');  
   commit;
end;

--ȡ��
declare
begin
   bank_pack.outmoney('48895FDED2DC4B999D2A7CA7A6705E29',1200);  
   commit;
end;

--ת��
declare
begin
   bank_pack.tomoney('48895FDED2DC4B999D2A7CA7A6705E29',1200,'57E79863C49C4E23B5FE68C70E35500F');  
   commit;
end;

select * from userinfo
select * from transinfo
select * from cardinfo for update
