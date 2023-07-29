--切换数据库
use 练习

alter table student add stu_age int
--开始
--内部联接
select * from student st inner join course c on st.course_no=c.course_no

--左联接
select * from student st left join score s on st.score_no=s.score_no

--右联接
select * from student st right join course s on st.course_no=s.course_no

--全部联接
select * from student st full join score s on st.score_no=s.score_no

--交叉连接
select * from student cross join course