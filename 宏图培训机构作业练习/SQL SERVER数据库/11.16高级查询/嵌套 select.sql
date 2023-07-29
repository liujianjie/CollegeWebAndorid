F--切换数据库
use 练习

--all any 高级查询查 表是 allany allany2 
--基本查询是
select * from allany2 where allany2_no=1 and allany2_age > all(select allany2_age from allany2 where allany2_no=2)
select * from allany2 where allany2_no=1 and allany2_age > any(select allany2_age from allany2 where allany2_no=2)

--高级查询  原理就是引用的键表也要用上
select * from allany2 where allany2_no=(select allany_no from allany where allany_name='刘建杰') and allany2_age > all 
	(select allany2_age from allany2 where allany2_no=(select allany_no from allany where allany_name='呵呵'))

select * from allany2 where allany2_no=(select allany_no from allany where allany_name='刘建杰') and allany2_age > any 
	(select allany2_age from allany2 where allany2_no=(select allany_no from allany where allany_name='呵呵'))

--子查询 普通的
select * from allany2 where allany2_no in(select allany_no from allany where allany_name='刘建杰')--查找为1的数据
select * from allany2 where allany2_no in(select allany_no from allany where allany_name='呵呵')--查找为2的数据

--把一门课程拉出 试试
--先创表
create table student(
	stu_no int not null,
	stu_name varchar(20) not null,
	course_no int not null foreign key references course(course_no),
	score_no int not null foreign key references score(score_no)

)
create table score(
	score_no int primary key not null,
	score int not null,
	course_name
)
create table course(
	course_no int primary key not null,
	course_name varchar(20) not null
)
--先开始普通的查表
select st.stu_name,c.course_name,s.score from student st,course c,score s 
	where st.course_no=c.course_no and st.score_no=s.score_no 
	
--
select st.stu_name,(select score from score where score_no=st.score_no and st.course_no=
					(select course_no from course where course_name='语文'))语文,
					(select score from score where score_no=st.score_no and st.course_no=
					(select course_no from course where course_name='数学'))数学
		from student st
select st.stu_name,(select score from score where score_no=st.score_no and st.course_no=
					(select course_no from course where course_name='语文'))语文
		from student st
--删除那个列
alter table student drop column stu_age  

--添加列
alter table student add 
不懂 你说过的话算不算承诺 看到太多不懂 你说过的话算不算承诺我你竟然学会闪躲 算不算你对我感到愧疚想念你依然还欠着我的手太在意你的存在这算什么简单每次电话都会挂的很快
才明白 你想要离开 每次你会独自走的很快 也许是我要的看到我你竟然学会闪躲 算不算你对我感到愧疚想念你依然还欠 我的手 想哭哭不出来 想叫没人明白 太在意你的存在
总说我想小孩 我就是个笨蛋这算什么简单 看着你匆匆忙忙说了句晚安 我更别说你局促的节拍后知后觉值剩下无奈也许是我要的太多不懂 你说过的话算不算承诺
看到我你竟然学会闪躲 睡吧睡吧你 想念你依然还牵着 我的手 日常 
入戏太深 
你的笑总数转作很天真空气中弥漫浪漫的气氛  粉红色长发的迷人的嘴唇 现实你的和他路边 是我入戏太深姐姐 怪我入戏太深一边写这首歌越唱 结局 怪我入戏他是 一边写的灵魂
风红色迷人的嘴唇 qeqeqw 浅蓝色眼影看街道的上落英缤纷
原地沙和尚的等着首歌越唱越觉得残忍 原地傻傻的等已变心的 是我入戏他 即使转过身来看 美人啊
你的项链 他在等国下 你能抛弃他妈 那是你的束缚吗只有 通过项链你知道名字吗  调下汽车
 从第一次遇见 我一直相信 能永恒岛永远 踏进你的世界 我们的爱不灭 开始浪漫冒险 不知不觉爱情这一条线 握着你的手  看见梦的乐园 海角天边 换上我的舞鞋 拥抱你的瞬间
从第一次遇见 我一直相信 能永恒  到永远 心跳呼吸越来月前 看见梦的乐园 换上我的舞鞋 拥抱你的瞬间 从第一次遇见 能永恒岛永远 我们的爱不灭 看见梦的乐园换上我的舞鞋
拥抱你的瞬间 幸福整片蓝天 我一直相信 能永恒岛永远 我们的爱不灭
当我在阳光下 我爱这冲动恋爱的冲淡 嗨 当我迎着风  都是她 把一切都教给她吧  天真的像动物 都是她把一切都交给她  放在那 天真得像动物
这看不透的认识 你那放不开的人生  嘿 你到底在害怕什么 好好地 一盆now一盆niowit  s ok let iwantyoubaby now 酷狗2015 传播音乐
不懂 你说过的话算不算 承诺 看到太多 不懂 你说过的话算不算承诺 看到我你竟然学会闪躲 算不算 你对我感到愧疚想念你依然还牵着我的手太在意你的存在 这算什么简单 每次电话都会
挂的很快 后知后觉 才明白 你想要离开
也许是我要的太多 不懂 你说过的话算不算承诺 看到我你竟然学会闪躲 算不算你对我感到愧疚 想你的时候蹲在摸个角落 想哭哭不出来 总说我哥笨蛋 这算什么简单 每次电话都会刮得很快 匆匆忙忙说了句晚安
每次你会独自走得很快 别让我一个人悄悄难过 也许是我要的太多 不懂 看到我你竟然学会闪躲 算不算你对我感到愧疚 想你的时候蹲在摸个角落 想你你还牵着我的手
想哭哭不出来 想叫没人明白他在呀你的存在 总数我就是笨蛋 对我只是习惯 离开会不行 这算什么  每次电话都会挂的很快 我跟不上你急促的节拍 别让我一个人悄悄难过 也许我要的太多不懂
你说过的话算不算承诺 也许你只是偏偏我 看到我你竟然学会闪躲 算不算你对想你的时候蹲在摸个角落想你你依然还牵着我的手
该歌曲暂无歌词 
byot  hoy mi amorhoytengculpadetuhoysequetuloquemasmeyunapenaquemedueletumentiraqueaqueldiadelvennomalevodellenodedolorrepiredeesehumoamayousoloporquebabytedigo
quetengolacamisa negra tengolacamisa negra tengolacamisanegrayatuamornomehoymesbeapuranisiquieramuestras y tus maletasenyfuepuratoditatuqueaquediateyouquedemoribundoylllenodedolorrespirede
esehumoamargo tutefuisteyosoloporquenegra tengoy casi pie tedigocondisiquetengoybebajo porquenegratengo yacasi pierdohastedigocondisimuloydebajotengoel difunto
不真爱得有结果被你夺走永远也不留感情的包袱 复杂又承重 好不了的上隐隐作痛 赢了什么算拥有坦白总会输给了沉默 追逐 和错过 谁能看透 余元 睡的愁 你不懂谁都没赢过 潮起潮落 泳镜了 我都留挣到什么
赢了什么算拥有坦白总会输给了沉默 追逐 和错过谁能看透 月圆月缺 看尽睡的愁 我在承受你不懂谁都没赢过 潮起潮落 你不放手 我逗留 挣到什么月圆月缺 看尽睡的愁
我在承受你不懂谁都没赢过 潮起潮落 你不妨手 我逗留挣到什么 月圆月缺 爱恨即使罢休  岁月穿梭 我的梦没有尽头
为什么一个人发呆 是否还有一些屋内 不如何我 我是电音之王  嗨嗨安徽 everbody