--����1
USE ѧ������
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


--����2
SELECT stu.Sname
FROM S stu
	INNER JOIN SC stucour ON stu.Sno = stucour.Sno
WHERE stucour.grade > 80
	AND stucour.Cno = (
		SELECT Cno
		FROM C
		WHERE Cname = '���ݿ⼼����Ӧ��'
	)
SELECT stu.Sname
FROM S stu
	INNER JOIN SC stucour ON stu.Sno = stucour.Sno
	INNER JOIN C course ON course.Cno = stucour.Cno
WHERE stucour.grade > 80
	AND course.Cname = '���ݿ⼼����Ӧ��'




--����3

SELECT stucour.Sno
FROM SC stucour
WHERE stucour.grade = SOME (
		SELECT MAX(grade)
		FROM SC stucourse
		WHERE stucourse.Cno = (
			SELECT Cno
			FROM C course
			WHERE course.Cname = '������Ϣϵͳ'
		)
	)
	AND stucour.Cno = (
		SELECT Cno
		FROM C
		WHERE Cname = '������Ϣϵͳ'
	)


