CREATE TABLE Province(
	ProvinceID varchar2(4),
	Name nvarchar2(50)
);
comment on table  Province is 'ʡ�ݱ�';
comment on column Province.ProvinceID is 'ʡ��ID';
comment on column Province.Name is 'ʡ������';
create unique index un_ix_Province on Province(ProvinceID);
alter table Province add constraint pk_Province
      primary key(ProvinceID) using index un_ix_Province;
CREATE TABLE City(
	CityID varchar2(4),
	ProvinceID varchar2(4) ,
	Name nvarchar2(50)
);
comment on table  City is '��(��)��';
comment on column City.ProvinceID is 'ʡ��ID';
comment on column City.CityID is 'ʡ��(��)ID';
comment on column City.Name is '��(��)����';
create unique index un_ix_City on City(CityID);
alter table City add constraint pk_City
      primary key(CityID) using index un_ix_City;