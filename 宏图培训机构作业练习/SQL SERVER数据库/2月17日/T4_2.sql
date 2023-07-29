
--利用系统存储过程创建登录名
exec sp_addlogin 'test2','123456'

--删除登录名
exec sp_droplogin 'test2'

--利用sql语句来创建登录名
create login test2 with password='123456'

--sql语句创建用户
use T1
create user test2 for login test2--没有权限
sp_grantdbaccess 'test','text'--也没有权限
sp_revokedbaccess 'text'--删除

--角色是分配系统特权的主要方式
--分为 数据库角色 和 服务器角色

--权限分配

--登录名存在的表
select * from syslogins

--查看登录名信息
sp_helplogins 'sa'

1、SQL Server对用户的验证分哪几个层次？根据你的理解，登录名和用户是什么关系？角色和用户之间又是什么关系？

	(1)两个层次:登录验证,权限验证
	(2)登录名和用户是什么关系:登录名决定用户的存在 一个登录名可以有多个用户
	(3)角色和用户是什么关系:角色决定用户对数据库的权限 一个用户可以有多个角色

2、叙述一个如果让你来给你的客户建立数据库，你会为你的客户安排什么样的用户（也就是给什么样的权限）

	1个权限:select查询权限

3、列出SQL-SERVER2000中所有的用户角色

	db_owner 在数据库中有全部权限。
	db_accessadmin 可以添加或删除用户和角色
	db_securityadmin 可以管理全部权限、对象所有权、角色和角色成员资格。
	db_ddladmin 可以添加,修改或者删除数据库中的对象.
	db_backupoperator 可以备份和恢复数据库。
	db_datareader 可以选择数据库内任何用户表中的所有数据。
	db_datawriter 可以更改数据库内任何用户表中的所有数据。
	db_denydatareader 与db_datareader相反,不能选择数据库内任何用户表中的任何数据。
	db_denydatawriter 与db_datawriter相反,不能更改数据库内任何用户表中的任何数据。


