select * from bottom b left join mold m on b.mold_id=m.mold_id where b.mold_id=1;
select * from goods g left join bottom b on g.bottom_id=b.bottom_id where g.bottom_id=1;
select * from goods g left join bottom b on b.bottom_id=g.bottom_id where g.g_id=1