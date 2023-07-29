use 练习

select * from 添加约束
 
--通配符查询
--1.模糊查询 %
select * from 添加约束 where shu_name like '%刘%' 

--2._代表一个字符
select * from 添加约束 where shu_name like '刘_'

--3.[]范围查找
select * from 添加约束 where shu_id like '3243[1-3]'

--4.^ 取反操作 只适合在范围里
select * from 添加约束 where shu_id like '245[^3-7]'

--5.in 某个字段的值在什么范围
select * from 添加约束 where shu_no in(1,11,3,5,6,7,2)

--6.not in不在指定的值内
select * from 添加约束 where shu_no not in(1,3)

--7.两者之间between
select * from 添加约束 where shu_no between 1 and 9

--8.
select * from 添加约束 where shu_no not between 1 and 9