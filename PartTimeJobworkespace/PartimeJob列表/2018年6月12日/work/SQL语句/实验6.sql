--内容1）
USE 学生管理
GO

CREATE VIEW stud_view1
AS
SELECT stu.Sno, stu.Sname, course.Cname, stucour.grade
FROM S stu
	INNER JOIN SC stucour ON stucour.Sno = stu.Sno
	INNER JOIN C course ON course.Cno = stucour.Cno

GO

--内容2


SELECT AVG(grade) AS 数据库技术及应用平均成绩
FROM stud_view1
WHERE Cname = '数据库技术及应用'

GO