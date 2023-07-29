create table system_user(
	userId int auto_increment comment '主键',
	userName varchar(20) comment '用户名称',
	userPassword varchar(20) comment '用户登录密码',
	primary key(userId)
)Engine = INNODB #设置存储引擎
Auto_increment = 1000 # 设置自增初始值
DEFAULT CHARSET = UTF8 #默认字符集
comment '用户表';
