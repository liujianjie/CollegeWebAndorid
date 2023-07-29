--开始写存储过程
/*
1.添加测试数据
2.创建存储过程实现开卡功能，开卡业务包括向用户表userinfo添加一条记录，同时向账户表
cardinifo和交易记录表transinfo表各添加一条记录
3.创建存储过程实现取款业务，需要向transinfo表添加一条记录，并修改cardinfo表中对应账号
余额
4.创建存储过程实现转账业务，如从张三账户中转10000元给李四。需要向transinfo表添加两条记录
，并修改cardinfo表中对应账户的余额。

*/

--包头
create or replace package bank_pack is
       procedure adduser(
                         user_name in varchar2,
                         user_gender in char,
                         user_tel in varchar2,
                         user_card in char);--2
       procedure outmoney(p_card_id in varchar2,
                          p_out_money in number);--3 卡号和取款值
       procedure tomoney(p_ycard_id in varchar2,
                         p_money in number,
                         p_tcard_id in varchar2);--4 源卡号，钱，目标卡号
end bank_pack;

/

--体的编写
create or replace package body bank_pack is
       procedure adduser(
                         user_name in varchar2,
                         user_gender in char,
                         user_tel in varchar2,
                         user_card in char) is
        -- userid number:=userinfo_user_id.nextval;
         cardid varchar2(32);
         begin
           --业务2
           select sys_guid() into cardid from dual;
           insert into userinfo values(userinfo_user_id.nextval,user_name,user_gender,user_tel,user_card);--下个值

           insert into cardinfo values(cardid,userinfo_user_id.currval,'普通卡','钱',0);--当前值
           dbms_output.put_line('卡号为：'||cardid);
         end adduser;
       procedure outmoney(p_card_id in varchar2,
                          p_out_money in number) is
         currentmoney number(18,2);--剩余钱
         begin
              --业务3
              --先查询卡号余额是否够取
              select current_money into currentmoney from cardinfo where card_id = p_card_id;
              if currentmoney>=p_out_money then
                 --先减少数额
                 update cardinfo set current_money = currentmoney-p_out_money where card_id= p_card_id;

                 --添加交易记录
                 insert into transinfo values(sys_guid(),p_card_id,sysdate,'取款',p_out_money);
                 elsif currentmoney<p_out_money then
                 dbms_output.put_line('余额不足，取款失败。');

              end if;

         end outmoney;
       procedure tomoney(p_ycard_id in varchar2,
                         p_money in number,
                         p_tcard_id in varchar2) is
         currentmoney number(18,2);
         begin
             --业务4
             --先查询卡号余额是否够取
             select current_money into currentmoney from cardinfo where card_id = p_ycard_id;


             if currentmoney>=p_money then
                --减少钱
                update cardinfo set current_money = current_money-p_money where card_id = p_ycard_id;
                --增加钱
                update cardinfo set current_money = current_money+p_money where card_id = p_tcard_id;
                --添加交易记录
                 insert into transinfo values(sys_guid(),p_ycard_id,sysdate,'转账',p_money);
                 insert into transinfo values(sys_guid(),p_tcard_id,sysdate,'收账',p_money);
                elsif currentmoney<p_money then
                 dbms_output.put_line('余额不足，转账失败。');

             end if;
             

         end tomoney;


end bank_pack;
/


--开户
declare
begin
   bank_pack.adduser('小花','女','18160774016','360732199812102638');  
   commit;
end;

--取款
declare
begin
   bank_pack.outmoney('48895FDED2DC4B999D2A7CA7A6705E29',1200);  
   commit;
end;

--转账
declare
begin
   bank_pack.tomoney('48895FDED2DC4B999D2A7CA7A6705E29',1200,'57E79863C49C4E23B5FE68C70E35500F');  
   commit;
end;

select * from userinfo
select * from transinfo
select * from cardinfo for update
