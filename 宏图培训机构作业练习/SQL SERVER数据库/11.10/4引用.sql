use ��ԭ�����ݿ�
create table score2(
	stu_name varchar(20) foreign key references student(stu_name),--����ѧ������ ��Ҫ��д
	score int check(score>=0 and score<=100) not null --��������
)
