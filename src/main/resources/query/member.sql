select * from member;
create table member(
	id varchar2(20) primary key,
	pw varchar2(20),
	name varchar2(20),
	reg_date varchar2(20),
	ssn varchar2(10),
	email varchar2(30),
	profile_img varchar2(100)
);
-- CREATE
insert into member(id,pw,name,reg_date,ssn,email,profile_img) 
values('lee','1','이순신','2016-07-01','800101-1','lee@test.com','lee.jpg');
insert into member(id,pw,name,reg_date,ssn,email,profile_img) 
values('hong2','1','홍길동','2015-07-01','100701-1','hong2@test.com','hong2.jpg');
insert into member(id,pw,name,reg_date,ssn,email,profile_img) 
values('kim','1','김유신','2013-07-01','090701-3','kim@test.com','kim.jpg');
-- READ ()
select * from member; 
select * from member where id = 'hong';
select * from member where gender = '남';
select count(*) as count from member where id = 'hong'; 

-- UPDATE
update member set email = id || '@test.com'; 
update member set email = 'hong@test.com'where id = 'hong';
alter table member add email varchar2(30);
alter table member add profile_img varchar2(100);
update member set ssn = '900301-1' where id = 'park';
update member set profile_img = id ||'.jpg' where profile_img IS NULL;
-- DELETE
delete from member where id = 'test';
select * from member;

select * from member where id='hong';

