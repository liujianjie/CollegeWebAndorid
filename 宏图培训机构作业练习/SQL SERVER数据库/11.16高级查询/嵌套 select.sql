F--�л����ݿ�
use ��ϰ

--all any �߼���ѯ�� ���� allany allany2 
--������ѯ��
select * from allany2 where allany2_no=1 and allany2_age > all(select allany2_age from allany2 where allany2_no=2)
select * from allany2 where allany2_no=1 and allany2_age > any(select allany2_age from allany2 where allany2_no=2)

--�߼���ѯ  ԭ��������õļ���ҲҪ����
select * from allany2 where allany2_no=(select allany_no from allany where allany_name='������') and allany2_age > all 
	(select allany2_age from allany2 where allany2_no=(select allany_no from allany where allany_name='�Ǻ�'))

select * from allany2 where allany2_no=(select allany_no from allany where allany_name='������') and allany2_age > any 
	(select allany2_age from allany2 where allany2_no=(select allany_no from allany where allany_name='�Ǻ�'))

--�Ӳ�ѯ ��ͨ��
select * from allany2 where allany2_no in(select allany_no from allany where allany_name='������')--����Ϊ1������
select * from allany2 where allany2_no in(select allany_no from allany where allany_name='�Ǻ�')--����Ϊ2������

--��һ�ſγ����� ����
--�ȴ���
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
--�ȿ�ʼ��ͨ�Ĳ��
select st.stu_name,c.course_name,s.score from student st,course c,score s 
	where st.course_no=c.course_no and st.score_no=s.score_no 
	
--
select st.stu_name,(select score from score where score_no=st.score_no and st.course_no=
					(select course_no from course where course_name='����'))����,
					(select score from score where score_no=st.score_no and st.course_no=
					(select course_no from course where course_name='��ѧ'))��ѧ
		from student st
select st.stu_name,(select score from score where score_no=st.score_no and st.course_no=
					(select course_no from course where course_name='����'))����
		from student st
--ɾ���Ǹ���
alter table student drop column stu_age  

--�����
alter table student add 
���� ��˵���Ļ��㲻���ŵ ����̫�಻�� ��˵���Ļ��㲻���ŵ���㾹Ȼѧ������ �㲻������Ҹе�������������Ȼ��Ƿ���ҵ���̫������Ĵ�������ʲô��ÿ�ε绰����ҵĺܿ�
������ ����Ҫ�뿪 ÿ���������ߵĺܿ� Ҳ������Ҫ�Ŀ������㾹Ȼѧ������ �㲻������Ҹе�������������Ȼ��Ƿ �ҵ��� ��޿޲����� ���û������ ̫������Ĵ���
��˵����С�� �Ҿ��Ǹ���������ʲô�� ������Ҵ�ææ˵�˾��� �Ҹ���˵��ִٵĽ��ĺ�֪���ֵʣ������Ҳ������Ҫ��̫�಻�� ��˵���Ļ��㲻���ŵ
�������㾹Ȼѧ������ ˯��˯���� ��������Ȼ��ǣ�� �ҵ��� �ճ� 
��Ϸ̫�� 
���Ц����ת���������������������������  �ۺ�ɫ���������˵��촽 ��ʵ��ĺ���·�� ������Ϸ̫���� ������Ϸ̫��һ��д���׸�Խ�� ��� ������Ϸ���� һ��д�����
���ɫ���˵��촽 qeqeqw ǳ��ɫ��Ӱ���ֵ�������Ӣ�ͷ�
ԭ��ɳ���еĵ����׸�Խ��Խ���ò��� ԭ��ɵɵ�ĵ��ѱ��ĵ� ������Ϸ�� ��ʹת�������� ���˰�
������� ���ڵȹ��� ������������ �������������ֻ�� ͨ��������֪��������  ��������
 �ӵ�һ������ ��һֱ���� �����㵺��Զ ̤��������� ���ǵİ����� ��ʼ����ð�� ��֪����������һ���� ���������  �����ε���԰ ������� �����ҵ���Ь ӵ�����˲��
�ӵ�һ������ ��һֱ���� ������  ����Զ ��������Խ����ǰ �����ε���԰ �����ҵ���Ь ӵ�����˲�� �ӵ�һ������ �����㵺��Զ ���ǵİ����� �����ε���԰�����ҵ���Ь
ӵ�����˲�� �Ҹ���Ƭ���� ��һֱ���� �����㵺��Զ ���ǵİ�����
������������ �Ұ���嶯�����ĳ嵭 �� ����ӭ�ŷ�  ������ ��һ�ж��̸�����  ��������� ��������һ�ж�������  ������ ���������
�⿴��͸����ʶ ���ǷŲ���������  �� �㵽���ں���ʲô �úõ� һ��nowһ��niowit  s ok let iwantyoubaby now �ṷ2015 ��������
���� ��˵���Ļ��㲻�� ��ŵ ����̫�� ���� ��˵���Ļ��㲻���ŵ �������㾹Ȼѧ������ �㲻�� ����Ҹе�������������Ȼ��ǣ���ҵ���̫������Ĵ��� ����ʲô�� ÿ�ε绰����
�ҵĺܿ� ��֪��� ������ ����Ҫ�뿪
Ҳ������Ҫ��̫�� ���� ��˵���Ļ��㲻���ŵ �������㾹Ȼѧ������ �㲻������Ҹе����� �����ʱ������������� ��޿޲����� ��˵�Ҹ籿�� ����ʲô�� ÿ�ε绰����εúܿ� �Ҵ�ææ˵�˾���
ÿ���������ߵúܿ� ������һ���������ѹ� Ҳ������Ҫ��̫�� ���� �������㾹Ȼѧ������ �㲻������Ҹе����� �����ʱ������������� �����㻹ǣ���ҵ���
��޿޲����� ���û����������ѽ��Ĵ��� �����Ҿ��Ǳ��� ����ֻ��ϰ�� �뿪�᲻�� ����ʲô  ÿ�ε绰����ҵĺܿ� �Ҹ������㼱�ٵĽ��� ������һ���������ѹ� Ҳ����Ҫ��̫�಻��
��˵���Ļ��㲻���ŵ Ҳ����ֻ��ƫƫ�� �������㾹Ȼѧ������ �㲻����������ʱ���������������������Ȼ��ǣ���ҵ���
�ø������޸�� 
byot  hoy mi amorhoytengculpadetuhoysequetuloquemasmeyunapenaquemedueletumentiraqueaqueldiadelvennomalevodellenodedolorrepiredeesehumoamayousoloporquebabytedigo
quetengolacamisa negra tengolacamisa negra tengolacamisanegrayatuamornomehoymesbeapuranisiquieramuestras y tus maletasenyfuepuratoditatuqueaquediateyouquedemoribundoylllenodedolorrespirede
esehumoamargo tutefuisteyosoloporquenegra tengoy casi pie tedigocondisiquetengoybebajo porquenegratengo yacasi pierdohastedigocondisimuloydebajotengoel difunto
���氮���н�����������ԶҲ��������İ��� �����ֳ��� �ò��˵���������ʹ Ӯ��ʲô��ӵ��̹���ܻ�����˳�Ĭ ׷�� �ʹ�� ˭�ܿ�͸ ��Ԫ ˯�ĳ� �㲻��˭��ûӮ�� ������ Ӿ���� �Ҷ�������ʲô
Ӯ��ʲô��ӵ��̹���ܻ�����˳�Ĭ ׷�� �ʹ��˭�ܿ�͸ ��Բ��ȱ ����˯�ĳ� ���ڳ����㲻��˭��ûӮ�� ������ �㲻���� �Ҷ��� ����ʲô��Բ��ȱ ����˯�ĳ�
���ڳ����㲻��˭��ûӮ�� ������ �㲻���� �Ҷ�������ʲô ��Բ��ȱ ���޼�ʹ����  ���´��� �ҵ���û�о�ͷ
Ϊʲôһ���˷��� �Ƿ���һЩ���� ������� ���ǵ���֮��  ���˰��� everbody