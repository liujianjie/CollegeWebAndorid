use ��ԭ�����ݿ�
create table score(
	score_no  uniqueidentifier primary key DEFAULT NEWID() not null,--����
	/*stu_name varchar(20) not null foreign key references student(stu_name),--����ѧ������ ��Ҫ��д*/
	score int check(score>0 and score<=100) not null --��������
)