use 还原的数据库
--给student添加列
alter table student add score char(2) check(score>=0 and score<=100) default 0 not null