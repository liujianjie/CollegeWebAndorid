--����1��
USE ѧ������
GO

CREATE VIEW stud_view1
AS
SELECT stu.Sno, stu.Sname, course.Cname, stucour.grade
FROM S stu
	INNER JOIN SC stucour ON stucour.Sno = stu.Sno
	INNER JOIN C course ON course.Cno = stucour.Cno

GO

--����2


SELECT AVG(grade) AS ���ݿ⼼����Ӧ��ƽ���ɼ�
FROM stud_view1
WHERE Cname = '���ݿ⼼����Ӧ��'

GO