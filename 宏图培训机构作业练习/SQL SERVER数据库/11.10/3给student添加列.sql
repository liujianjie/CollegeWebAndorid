use ��ԭ�����ݿ�
--��student�����
alter table student add score char(2) check(score>=0 and score<=100) default 0 not null