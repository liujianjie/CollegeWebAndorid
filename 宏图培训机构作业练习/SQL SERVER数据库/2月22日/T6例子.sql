--T-SQL�α� ��ʹ�ò���
--1,�����α�
declare stu cursor scroll for select * from student
--2.���α�
open stu
--3.�����α�
fetch first from stu
--4.�ر��α�
close stu
--5.�ͷ��α�
deallocate stu

--scroll�����α꣨����ǰ����� forward only�αֻ꣨����ǰ��������first��Щһ��ʹ��
select * from student

declare stu cursor FORWARD_ONLY for select * from student
open stu
fetch next from stu
fetch first from stu--����ʹ��
close stu
deallocate stu

declare stu cursor scroll for select * from student
open stu
fetch next from stu
fetch first from stu--�α�Ĭ�ϵ�λ�ò����ǵ�һ������
fetch next from stu--�α��λ�û�ı� ����ÿ��ͣ��Ĭ��λ��
fetch prior from stu--��һ��
fetch absolute -5 from stu--����λ�� �����α�Ĭ��λ�����ƶ�
fetch relative 3 from stu--���λ�� �����α�����λ�����ƶ�
close stu
deallocate stu

--���������������ݷ�װ�ڱ�����
use task
declare @no varchar(20),@cno varchar(10),@score float
declare score cursor scroll for select * from studentcourse
open score
fetch next from score into @no,@cno,@score
close score
deallocate score
select @no,@cno,@score

--���α����ı�����ֵ �õ�ϵͳ���� @@fetch_status��һ��ֵfetch���صĽ��
declare @no varchar(20),@cno varchar(10),@score float
declare score cursor for select * from studentcourse
open score
fetch next from score into @no,@cno,@score
while(@@fetch_status=0)--��ȡ�ɹ�
begin 
	if @cno=201
	begin
		update studentcourse set score=score+5 where  current of score
	end
	if @cno=202
	begin
		update studentcourse set score=score+5 where  current of score
	end
	if @cno=203
	begin
		update studentcourse set score=score+5 where  current of score
	end
	fetch next from score into @no,@cno,@score--��û������ʱ��Ϊ -1 ��-2
end
close score
deallocate score

--����ȫ�ֱ��� @@cursor_rows��ѭ�������α��е�����
declare score cursor scroll static for select * from studentcourse
open score
declare @i int,@sc float--������������ 5 10 15.������
set @i=0
set @sc=5
while @i<@@cursor_rows
begin
	set @i=@i+1
	--update studentcourse set score=score+@sc where  current of score
	set @sc=@sc+5
	fetch next from score
end
close score
deallocate score