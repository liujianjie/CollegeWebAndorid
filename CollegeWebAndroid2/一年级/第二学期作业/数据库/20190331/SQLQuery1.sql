
--1.
select
	Sno,
	Sname,
	Birth
from student
where DATEPART("YYYY",getdate()) - DATEPART("YYYY",Birth) < 28

--2.
select
	Sno,
	Sname
from student
where Birth between '1991-1-1' and '1991-5-30'

--3.
select
	DormNo,
	Build,
	Storey,
	RoomNo
from Dorm
where Tel is null

--4.
select
	ClassNo,
	ClassName,
	Enteryear
from Class
where Specialty in ('计算机应用技术','软件技术')

--5
select
	COUNT(distinct Specialty) as '专业个数'
from Class
group by College
--6.
select
	College,
	Specialty,
	COUNT(distinct ClassNo)
from Class
group by College,Specialty

--7.
select
	ClassNo,
	COUNT(ClassNo)
from Student
group by ClassNo

--8.
select
	Cno as '课程编号',
	COUNT(Sno)
from Score
group by Cno
--9.
select
	AVG(UScore) as '平时成绩平均分',
	AVG(EndScore) as '期末成绩平均分'
from Score
group by Cno

--10.
select 
	Cno
from Score
group by Cno
having COUNT(Sno) > 2

--11.
select
	AVG(Score)
from CheckHealth
group by CheckDate
having datepart("YYYY",CheckDate) = '2010' and datepart("MM",CheckDate) = '11'

--12.
select
	COUNT(dormNo)
from Dorm
group by build

--13
select 
	COUNT(Sno)
from Live
group by DormNo

--14.
select
	AVG(Score)
from CheckHealth
group by DormNo

--15.
select
	DormNo
from CheckHealth
group by DormNo
having AVG(Score) > 90

--16.
select
	DormNo
from CheckHealth
group by DormNo
having COUNT(DormNo) > 3

--17.
select
	*
from Dorm
where DormType = '男'
order by build asc, DormNo asc

--18.?
select
	Sno,
	Cno
from Score
where Uscore > 90 or EndScore > 90
order by Sno asc, Cno asc

--19.
select
	top 1
	DormNo,
	CheckDate
from CheckHealth
where datepart("YYYY",CheckDate) = '2010' and datepart("MM",CheckDate) = '11'
order by Score desc

--20.?
select
	*
from Score s
where Cno = (select c.Cno from Course c where c.Cname = '数据库技术与应用1')

--21.?
select
	Sno
from Score
where Cno = '0901170' and Uscore < (
select 
	AVG(Uscore)
from Score
where Cno = '0901170'
group by Cno)


--22.
select
	*
from Student
where ClassNo = (select ClassNo from Student where Sname = '林芳')

--23.
select
	Sname,
	ClassNo
from Student
where Sno in (select Sno from Score 
where Cno = (select Cno from Course where Cname = '数据库技术与应用1'))

--24.
select
	Sno,
	Sname
from Student
where Sno in (select Sno from Score where Cno = '0901170')

--25
select
	Sno,
	Sname
from Student
where Sno not in (select Sno from Score where Cno = '0901170')

--26.
select
	Sno,
	Sname
from Student
where Sno not in (select Sno from Score 
where Cno = (select Cno from Course where Cname = '计算机文化基础'))

--27.
select
	COUNT(*) as '学生总人数',
	AVG(EndScore) as '期末平均成绩',
	SUM(EndScore) as '期末总成绩'
from Score
where Cno = (select Cno from Course where Cname = '计算机文化基础')
group by Cno

--28.
select 
	(select Cname from Course cr where cr.Cno = se.Cno) as '课程名称',
	AVG(EndScore) as '平均分',
	MAX(EndScore) as '最高分'
from Score se
group by Cno


select * from CheckHealth
select * from Class
select * from Course
select * from Score
select * from Student
