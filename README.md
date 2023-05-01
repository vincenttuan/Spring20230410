# Spring20230410
Spring20230410
<pre>
-- 刪除 Emp 資料表
drop table if exists emp;
-- 建立 Emp 資料表
create table if not exists emp (
	eid integer NOT NULL AUTO_INCREMENT,
	ename text,
	age integer,
	createtime datetime default current_timestamp,
	PRIMARY KEY (eid)
);
-- 建立 Emp 範例資料
insert into emp(ename, age) values('john', 28);
insert into emp(ename, age) values('mary', 30);
insert into emp(ename, age) values('bobo', 29);
</pre>
