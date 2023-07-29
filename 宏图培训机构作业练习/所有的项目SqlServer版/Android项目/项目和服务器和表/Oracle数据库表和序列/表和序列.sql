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


--用户表
create table android_qq_user(
       qq_id number(5) primary key,
       qq_zhanghao varchar2(15) not null,--账号
       qq_mima varchar2(11) not null,--密码
       qq_touxiang varchar2(100),--头像
       qq_name varchar2(20),--昵称
       qq_mark varchar2(100),--个性签名
       qq_sex varchar2(2),--性别
       qq_address varchar2(80),--地址
       qq_phone varchar2(11),--电话
       qq_statu number(1)--QQ状态 0下线 1上线
)

--好友表
create table android_qq_hy(
       hy_id number(5) primary key,
       myqq_id number(5),
       myqq_zhanghao varchar2(15),--账号
       myqq_name varchar2(20),--昵称
       myqq_touxiang varchar2(100),--头像
       myqq_mark varchar2(100),--个性签名
       myqq_statu number(1),--自己的状态
       myqq_fengzu number(1),--分组
       hyqq_id number(5),
       hyqq_zhanghao varchar2(15),--账号
       hyqq_name varchar2(20),
       hyqq_touxiang varchar2(100),
       hyqq_mark varchar2(100),--个性签名
       hyqq_statu number(1),--好友的状态
       hyqq_fengzu number(1),--分组 1好友，2.家人 3.同学  4.朋友
       hy_statu number(1)--好友状态 0未确认，1为好友，
)
--动态表
create table android_qq_dynamic(
       dy_id number(5) primary key,
       qq_id number(5),--QQid
       qq_zhanghao varchar2(15),--QQ账号
       qq_name varchar2(20),--昵称
       qq_touxiang varchar2(100),--头像
       dy_date varchar2(30),
       dy_content varchar2(500),
       dy_photos varchar2(500)--存储多张图片，用逗号隔开未避免冲突格式为 QQ号+时间
)

--消息表
create table android_qq_message(
       m_id number(6) primary key,
       qq_id number(5),--发送者id
       qq_zhanghao varchar2(15),--账号
       qq_name varchar2(20),--昵称
       qq_touxiang varchar2(100),--头像
       m_message varchar2(200),--内容 100个字
       m_date date,--消息发送时间
       m_jsid number(5),--接受者id
       m_zhanghao varchar2(15),--账号
       m_name varchar2(20),--接受者昵称]
       m_touxiang varchar2(100),
       m_statu number(1)--1.已接收 0.未被接受
 )
 
