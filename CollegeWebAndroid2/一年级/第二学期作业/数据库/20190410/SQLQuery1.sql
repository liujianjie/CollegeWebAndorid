--1
select
	st.Sno,
	sc.Cno,
	cs.Cname,
	cs.Credit,
	Uscore,
	EndScore
from Student st
left join Score sc
on st.Sno = sc.Sno
left join Course cs
on sc.Cno = cs.Cno

--2
select
	sc.Sno,
	sc.Cno,
	cs.Cname,
	sc.Uscore,
	sc.EndScore
from Course cs
left join Score sc 
on sc.Cno = cs.Cno
where cs.Cname like '%数据库%'

--3
select
	st.Sno,
	st.Sname,
	cl.ClassName,
	sc.Cno,
	sc.Uscore
from Student st
left join Class cl
on cl.ClassNo = st.ClassNo
left join Score sc
on st.Sno = sc.Sno

--4
select
	st.Sno,
	st.Sname,
	st.Sex,
	sc.Cno,
	cs.Cname
from Class cl
left join Student st 
on cl.ClassNo = st.ClassNo
left join Score sc
on st.Sno = sc.Sno
left join Course cs
on sc.Cno = cs.Cno
where cl.ClassNo = '200901001'

--5
select
	cs.Cno,
	cs.Cname,
	sc.Uscore
from Course cs
left join Score sc
on cs.Cno = sc.Cno
order by cs.Cno asc, sc.Uscore desc

--6
select
	cs.Cno,
	cs.Cname
from Course cs
left join Score sc 
on cs.Cno = sc.Cno
group by cs.Cno,cs.Cname
having SUM(EndScore) is null

--7
select
	st.Sno,
	st.Sname,
	st.Sex,
	sc.Cno,
	cs.Cname
from Class cl
left join Student st
on st.ClassNo = cl.ClassNo
left join Score sc
on st.Sno = sc.Sno
left join Course cs
on cs.Cno = sc.Cno
where cl.ClassName = '计算机092'

--8
select
	st.Sno,
	st.Sname,
	st.Sex,
	li.DormNo,
	dr.Build,
	dr.RoomNo,
	li.InDate
from Student st
left join Live li
on st.Sno = li.Sno
left join Dorm dr
on li.DormNo = dr.DormNo

--9
select
	dr.DormNo,
	dr.RoomNo,
	li.InDate
from Student st
inner join Live li
on st.Sno = li.Sno
left join Dorm dr
on li.DormNo = dr.DormNo
where st.Sname = '王康俊'

--10
select
	st.Sno,
	st.Sname,
	st.Sex,
	cl.ClassNo,
	cl.ClassName,
	li.DormNo,
	dr.Build,
	dr.RoomNo,
	li.InDate
from Student st
left join Class cl
on st.ClassNo = cl.ClassNo
left join Live li
on st.Sno = li.Sno
left join Dorm dr
on li.DormNo = dr.DormNo

--11
select
	st.Sno,
	st.Sname,
	st.Sex,
	cl.ClassNo,
	cl.ClassName,
	li.DormNo,
	dr.Build,
	dr.RoomNo,
	li.InDate
from Class cl
inner join Student st
on st.ClassNo = cl.ClassNo
left join Live li
on st.Sno = li.Sno
left join Dorm dr
on li.DormNo = dr.DormNo
where cl.Specialty = '计算机应用技术'
order by cl.ClassNo asc, st.Sno asc

--12
select 
	Sno,
	Sname
from Student 
where Sex = '女'
union
select 
	Sno,
	Sname
from Student 
where Sex = '男'


select
	*
from Class cl
inner join Student st
on st.ClassNo = cl.ClassNo
where cl.Specialty = '计算机应用技术'



select * from Score
select * from CheckHealth
select * from Class
select * from Course
select * from Dorm
select * from Live
select * from Score
select * from Student

--7
select
	st.Sno,
	st.Sname,
	st.Sex,
	sc.Cno,
	cs.Cname
from Student st
left join Score sc
on st.Sno = sc.Sno
left join Class cl
on st.ClassNo = cl.ClassNo
left join Course cs
on cs.Cno = sc.Cno
where cl.ClassName = '计算机092'

select
	st.Sno,
	sc.Cno,
	cs.Cname,
	cs.Credit,
	Uscore,
	EndScore
from Student st
left join Score sc
on st.Sno = sc.Sno
left join Course cs
on sc.Cno = cs.Cno

--2
select
	sc.Sno,
	sc.Cno,
	cs.Cname,
	sc.Uscore,
	sc.EndScore
from Course cs
left join Score sc 
on sc.Cno = cs.Cno
where cs.Cname like '%数据库%'

--3
select
	st.Sno,
	st.Sname,
	cl.ClassName,
	sc.Cno,
	sc.Uscore
from Student st
left join Class cl
on cl.ClassNo = st.ClassNo
left join Score sc
on st.Sno = sc.Sno

--4
select
	st.Sno,
	st.Sname,
	st.Sex,
	sc.Cno,
	cs.Cname
from Class cl
left join Student st 
on cl.ClassNo = st.ClassNo
left join Score sc
on st.Sno = sc.Sno
left join Course cs
on sc.Cno = cs.Cno
where cl.ClassNo = '200901001'

--5
select
	cs.Cno,
	cs.Cname,
	sc.Uscore
from Course cs
left join Score sc
on cs.Cno = sc.Cno
order by cs.Cno asc, sc.Uscore desc

--6
select
	cs.Cno,
	cs.Cname
from Course cs
left join Score sc 
on cs.Cno = sc.Cno
group by cs.Cno,cs.Cname
having SUM(EndScore) is null

--7
select
	st.Sno,
	st.Sname,
	st.Sex,
	sc.Cno,
	cs.Cname
from Class cl
left join Student st
on st.ClassNo = cl.ClassNo
left join Score sc
on st.Sno = sc.Sno
left join Course cs
on cs.Cno = sc.Cno
where cl.ClassName = '计算机092'

--8
select
	st.Sno,
	st.Sname,
	st.Sex,
	li.DormNo,
	dr.Build,
	dr.RoomNo,
	li.InDate
from Student st
left join Live li
on st.Sno = li.Sno
left join Dorm dr
on li.DormNo = dr.DormNo

--9
select
	dr.DormNo,
	dr.RoomNo,
	li.InDate
from Student st
inner join Live li
on st.Sno = li.Sno
left join Dorm dr
on li.DormNo = dr.DormNo
where st.Sname = '王康俊'

--10
select
	st.Sno,
	st.Sname,
	st.Sex,
	cl.ClassNo,
	cl.ClassName,
	li.DormNo,
	dr.Build,
	dr.RoomNo,
	li.InDate
from Student st
left join Class cl
on st.ClassNo = cl.ClassNo
left join Live li
on st.Sno = li.Sno
left join Dorm dr
on li.DormNo = dr.DormNo

--11
select
	st.Sno,
	st.Sname,
	st.Sex,
	cl.ClassNo,
	cl.ClassName,
	li.DormNo,
	dr.Build,
	dr.RoomNo,
	li.InDate
from Class cl
inner join Student st
on st.ClassNo = cl.ClassNo
left join Live li
on st.Sno = li.Sno
left join Dorm dr
on li.DormNo = dr.DormNo
where cl.Specialty = '计算机应用技术'
order by cl.ClassNo asc, st.Sno asc

--12
select 
	Sno,
	Sname
from Student 
where Sex = '女'
union
select 
	Sno,
	Sname
from Student 
where Sex = '男'
