create table air_quality_index(
       a_id number(3) primary key,
       d_id number(3) not null,
       a_time varchar(22) not null,
       a_pm10 number(10) not null,
       a_pm25 number(10) not null,
       a_station varchar2(200) not null,
       a_latetime varchar(22)  not null
)
comment on table scott.air_quality_index is '��������ָ����';
comment on column scott.air_quality_index.a_id is '����';
comment on column scott.air_quality_index.d_id is '������';
comment on column scott.air_quality_index.a_time is '���ʱ��';
comment on column scott.air_quality_index.a_pm10 is 'pm10ֵ';
comment on column scott.air_quality_index.a_pm25 is 'pm2.5ֵ';
comment on column scott.air_quality_index.a_station is '���վ';
comment on column scott.air_quality_index.a_latetime is '�����ʱ��';

insert into air_quality_index values(seq_air.nextval,1,'2016-12-19',20,10,'111','201612-19');


update air_quality_index set d_id = ,a_time=,a_pm10=,a_pm25=,a_station=,a_latetime= where a_id = 

--��������
create sequence seq_air
increment by 1--����
start with 1 --��ʼֵ
