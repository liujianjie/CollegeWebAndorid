select s.*,t.intenname,t.intenid from says s inner join student t on s.sayface=t.intenid where sayface=10001
select e.ename,e.eid from classes c inner join emp e on e.eid=c.empteaches
select s.*,t.intenname from says s inner join student t on t.intenid=s.sayface where sayface=10001 and sayempid=59
