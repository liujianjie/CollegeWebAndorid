--1.�������� commit;--�ύ rollback;--�ع� 
insert into student(pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date)
             values('pk1','����',18,65,'M',sysdate,'system',sysdate,'system',sysdate);
insert into student(pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date)
             values('pk2','����',18,65,'M',sysdate,'system',sysdate,'system',sysdate);
insert into student(pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date)
             values('pk3','����',18,65,'M',sysdate,'system',sysdate,'system',sysdate);
insert into student(pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date)
             values('pk4','½��',18,65,'M',sysdate,'system',sysdate,'system',sysdate);                                       
commit;--�ύ
--2.�޸�����
update student set sex='F',updated_by='me',updated_date=sysdate where sex='M';
commit;
--3.ɾ������
delete from student;--�ɻָ����ᱣ����־,����DML
commit;
truncate table student;--�ضϱ���ɾ���������ݣ����������־�����ɻָ���ʹ��ع�մ�����״̬
--4.���������ݼ��ṹ       
create table student_bak as 
select * from student where 1<>1;

select a.*,rowid from student_bak a;
--5.������������
insert into student_bak(pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date)  
select pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date from student;
commit;
--6.ORACLEα��
--rowid�����ڱ��е��е�ַ
select a.*,rowid from student_bak a;
--rownum��ѯ��������������Ӧ���к�
select a.*,rownum from student a where rownum<=3 order by a.pk_serial desc;  
--7.oracle��ҳ���
--ÿҳ2����ȡ��2ҳ
select * from (select a.*, rownum rn from student a where rownum<5 ) b
where b.rn>2;          