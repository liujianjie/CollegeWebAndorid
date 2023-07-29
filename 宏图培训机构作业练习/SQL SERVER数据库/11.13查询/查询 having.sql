use 练习

--having 用法

select shu_age,sum(shu_no)号总数,avg(shu_age)年龄平均数 from 添加约束 group by shu_age having sum(shu_no)>3 order by 年龄平均数 desc

--取别名

select a.shu_name,a.shu_age,b.cite_no from 添加约束 a,cite b where a.shu_no=b.cite_no--一一对应 不会随机抽取