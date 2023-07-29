--内容1
USE 学生管理
GO 

SELECT *
FROM S;

SELECT *
FROM C;

SELECT *
FROM SC;

SELECT stu.Sname
FROM S stu
	INNER JOIN SC stucour ON stu.Sno = stucour.Sno
WHERE stucour.grade > 85
	AND stucour.Cno = 1

GO


--内容2
SELECT stu.Sname
FROM S stu
	INNER JOIN SC stucour ON stu.Sno = stucour.Sno
WHERE stucour.grade > 80
	AND stucour.Cno = (
		SELECT Cno
		FROM C
		WHERE Cname = '数据库技术及应用'
	)
SELECT stu.Sname
FROM S stu
	INNER JOIN SC stucour ON stu.Sno = stucour.Sno
	INNER JOIN C course ON course.Cno = stucour.Cno
WHERE stucour.grade > 80
	AND course.Cname = '数据库技术及应用'




--内容3

SELECT stucour.Sno
FROM SC stucour
WHERE stucour.grade = SOME (
		SELECT MAX(grade)
		FROM SC stucourse
		WHERE stucourse.Cno = (
			SELECT Cno
			FROM C course
			WHERE course.Cname = '管理信息系统'
		)
	)
	AND stucour.Cno = (
		SELECT Cno
		FROM C
		WHERE Cname = '管理信息系统'
	)


