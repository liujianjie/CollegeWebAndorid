create sequence android_qq_message_seq 
increment by 1
start with 1;

create sequence android_qq_hy_seq 
increment by 1
start with 1;

create sequence android_qq_dynamic_seq 
increment by 1
start with 1;


create sequence android_qq_user_seq 
increment by 1
start with 1;


--�û���
create table android_qq_user(
       qq_id number(5) primary key,
       qq_zhanghao varchar2(15) not null,--�˺�
       qq_mima varchar2(11) not null,--����
       qq_touxiang varchar2(100),--ͷ��
       qq_name varchar2(20),--�ǳ�
       qq_mark varchar2(100),--����ǩ��
       qq_sex varchar2(2),--�Ա�
       qq_address varchar2(80),--��ַ
       qq_phone varchar2(11),--�绰
       qq_statu number(1)--QQ״̬ 0���� 1����
)

--���ѱ�
create table android_qq_hy(
       hy_id number(5) primary key,
       myqq_id number(5),
       myqq_zhanghao varchar2(15),--�˺�
       myqq_name varchar2(20),--�ǳ�
       myqq_touxiang varchar2(100),--ͷ��
       myqq_mark varchar2(100),--����ǩ��
       myqq_statu number(1),--�Լ���״̬
       myqq_fengzu number(1),--����
       hyqq_id number(5),
       hyqq_zhanghao varchar2(15),--�˺�
       hyqq_name varchar2(20),
       hyqq_touxiang varchar2(100),
       hyqq_mark varchar2(100),--����ǩ��
       hyqq_statu number(1),--���ѵ�״̬
       hyqq_fengzu number(1),--���� 1���ѣ�2.���� 3.ͬѧ  4.����
       hy_statu number(1)--����״̬ 0δȷ�ϣ�1Ϊ���ѣ�
)
--��̬��
create table android_qq_dynamic(
       dy_id number(5) primary key,
       qq_id number(5),--QQid
       qq_zhanghao varchar2(15),--QQ�˺�
       qq_name varchar2(20),--�ǳ�
       qq_touxiang varchar2(100),--ͷ��
       dy_date varchar2(30),
       dy_content varchar2(500),
       dy_photos varchar2(500)--�洢����ͼƬ���ö��Ÿ���δ�����ͻ��ʽΪ QQ��+ʱ��
)

--��Ϣ��
create table android_qq_message(
       m_id number(6) primary key,
       qq_id number(5),--������id
       qq_zhanghao varchar2(15),--�˺�
       qq_name varchar2(20),--�ǳ�
       qq_touxiang varchar2(100),--ͷ��
       m_message varchar2(200),--���� 100����
       m_date date,--��Ϣ����ʱ��
       m_jsid number(5),--������id
       m_zhanghao varchar2(15),--�˺�
       m_name varchar2(20),--�������ǳ�]
       m_touxiang varchar2(100),
       m_statu number(1)--1.�ѽ��� 0.δ������
 )
 
