--���õ��÷� ֻ�ǹ��� �ó� ����˳��һ����Ҫ���⼸�����ݵķ�Χ
use student 
create table shi(
	shi_no int primary key,
	shi_name varchar(20) not null,
)
create table shi2(
	shi2_no int not null foreign key references shi(shi_no),
	shi2_name varchar(20),

)