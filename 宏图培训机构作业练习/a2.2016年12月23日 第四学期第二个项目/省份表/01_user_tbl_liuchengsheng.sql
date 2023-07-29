CREATE TABLE Province(
	ProvinceID varchar2(4),
	Name nvarchar2(50)
);
comment on table  Province is '省份表';
comment on column Province.ProvinceID is '省份ID';
comment on column Province.Name is '省份名称';
create unique index un_ix_Province on Province(ProvinceID);
alter table Province add constraint pk_Province
      primary key(ProvinceID) using index un_ix_Province;
CREATE TABLE City(
	CityID varchar2(4),
	ProvinceID varchar2(4) ,
	Name nvarchar2(50)
);
comment on table  City is '市(区)表';
comment on column City.ProvinceID is '省份ID';
comment on column City.CityID is '省市(区)ID';
comment on column City.Name is '市(区)名称';
create unique index un_ix_City on City(CityID);
alter table City add constraint pk_City
      primary key(CityID) using index un_ix_City;