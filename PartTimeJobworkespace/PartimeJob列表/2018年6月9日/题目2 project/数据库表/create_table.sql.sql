create table system_user(
	userId int auto_increment comment '����',
	userName varchar(20) comment '�û�����',
	userPassword varchar(20) comment '�û���¼����',
	primary key(userId)
)Engine = INNODB #���ô洢����
Auto_increment = 1000 # ����������ʼֵ
DEFAULT CHARSET = UTF8 #Ĭ���ַ���
comment '�û���';
