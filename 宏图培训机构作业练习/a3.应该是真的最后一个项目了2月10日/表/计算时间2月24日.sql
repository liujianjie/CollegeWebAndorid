select * from BORROWMONEY t
--���ʣ��ʱ�� 
/*
     ʣ��ʱ�䣺��ǰʱ��-������ʱ��+���ޣ���
		��������ǰʱ��-������ʱ��+���ޣ�<=0
    ״̬��Ͷ����
*/

select b_id,borrow_bt,b_money,rate,statu,tb_money,BORROW_TIME from Borrowmoney where BORROW_TIME <sysdate - 30  || BORROW_TIME >sysdate - 6*30

select b_id,borrow_bt,b_money,rate,statu,tb_money,BORROW_TIME from Borrowmoney where BORROW_TIME >sysdate - 6*30

select BORROW_TIME from Borrowmoney where BORROW_TIME<=add_months(trunc(sysdate,'month'),-1) && BORROW_TIME<=add_months(trunc(sysdate,'month'),-6)

select BORROW_TIME from Borrowmoney WHERE BORROW_TIME BETWEEN sysdate-30*6 AND sysdate-30

select BORROW_TIME from Borrowmoney WHERE BORROW_TIME BETWEEN '2016-01-01' AND '2016-11-01'

select sysdate - (add_months(sysdate,12)) from dual

select add_months(sysdate,1) from dual

select sysdate-30*6 from dual

select BORROWQX,BORROW_TIME,REPAY_LASTTIME from  Borrowmoney for update 

select * from  Borrowmoney WHERE BORROWQX=1 and 


select  round(((sysdate - (add_months(BORROW_TIME,BORROWQX)))*-1),0)syday,rownum,b.* from  Borrowmoney b WHERE (BORROWQX=1  and sysdate - (add_months(BORROW_TIME,BORROWQX))<0)  
       or (borrowqx=12 and sysdate - (add_months(BORROW_TIME,BORROWQX))<0 ) and rownum<3--ǰ����
          order by syday 
    
--���ա�����66666      ʣ��������ǰ���� ����
select  round(((sysdate - (add_months(BORROW_TIME,BORROWQX)))*-1),0)syday,rownum,b.* from  Borrowmoney b WHERE BORROWQX >=1 and borrowqx<=12
         and sysdate - (add_months(BORROW_TIME,BORROWQX))<=0
             and rownum<3
                 order by syday 

--�����ʧ�ܵ� ��һ��ʱ���
select b_id,borrow_bt,b_money,rate,statu,tb_money,BORROW_TIME from Borrowmoney WHERE BORROW_TIME
			BETWEEN sysdate-30*12 AND sysdate-30*2
      
			
      select b_id,borrow_bt,b_money,rate,statu,repayment,borrowqx,tb_money from(select rownum r,s.* from Borrowmoney s where rownum<=(9*1))where r>(1-1)*9


--�����ʱ������ Ӧ���� REPAY_LASTTIME-REPAY_STARTIME (������������-��ǰʱ��) �ó����� ������Ȼ�� 
       --��ǰʱ����ڿ�ʼ����ʱ�� �� ���ջ���ʱ�� ���ڵ�ǰʱ�� round ���ʮ

select b.*,round((select REPAY_LASTTIME-sysdate from Borrowmoney o where sysdate>REPAY_STARTIME 
       and REPAY_LASTTIME>sysdate  and o.b_id = b.b_id),0)syday
        from Borrowmoney b where b_id=#{id}
