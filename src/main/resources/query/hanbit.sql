select * from tab;
select * from member;
alter table member modify ssn varchar2(10) UNIQUE;
alter table member modify phone varchar2(13) UNIQUE;
alter table subject modify subj_name varchar2(20) UNIQUE;
alter table board modify category varchar2(20) UNIQUE;

-- select sequence_owner, sequence_name from dba_sequences where sequence_owner = 'GKSQLC';
drop sequence seq;
--CREATE
DROP SEQUENCE grade_seq;
DROP SEQUENCE art_seq;
DROP SEQUENCE subj_seq;
DROP SEQUENCE major_seq;
DROP SEQUENCE exam_seq;

CREATE SEQUENCE grade_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE art_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE subj_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE major_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE exam_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;

DROP TABLE major cascade constraint;
DROP TABLE Member cascade constraint;
DROP TABLE Grade cascade constraint;
DROP TABLE Board cascade constraint;
DROP TABLE subject cascade constraint;
DROP TABLE exam cascade constraint;
--- 테이블 생성순서 1
CREATE TABLE Major(
       major_seq INT CONSTRAINT major_pk PRIMARY KEY,
       title VARCHAR2(20) NOT NULL UNIQUE
);   
--- 테이블 생성순서 2
CREATE TABLE Member(
  mem_id VARCHAR2(20) CONSTRAINT member_pk PRIMARY KEY,
  pw VARCHAR2(20) NOT NULL,
  name VARCHAR2(20) NOT NULL,
  gender VARCHAR2(10) NOT NULL,
  reg_date VARCHAR2(20) NOT NULL,
  ssn VARCHAR2(10) NOT NULL UNIQUE,
  email VARCHAR2(30),
  profile_img VARCHAR2(100) DEFAULT 'default.jpg',
  role VARCHAR2(10) DEFAULT 'STUDENT',
  phone VARCHAR2(13) NOT NULL UNIQUE,
  major_seq INT,
  CONSTRAINT gender_ck CHECK (gender IN ('MALE', 'FEMALE')),
  CONSTRAINT major_member_fk FOREIGN KEY (major_seq) REFERENCES Major(major_seq) ON DELETE CASCADE
  );
  --- 테이블 생성순서 3        
CREATE TABLE Grade(
        grade_seq INT CONSTRAINT grade_pk PRIMARY KEY,
        grade VARCHAR2(5) NOT NULL,
        term VARCHAR2(10) NOT NULL,
        mem_id VARCHAR2(20) NOT NULL,
        CONSTRAINT member_grade_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE 
);
CREATE TABLE Board(
       art_seq INT CONSTRAINT board_pk PRIMARY KEY,
       category VARCHAR2(20) NOT NULL UNIQUE,
       title VARCHAR2(30) DEFAULT 'NO TITLE',
       reg_date VARCHAR2(20) NOT NULL,
       content VARCHAR2(100) DEFAULT 'NO CONTENT',
       mem_id VARCHAR2(20),
       CONSTRAINT member_board_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE 
);  
CREATE TABLE Subject(
       subj_seq INT CONSTRAINT subject_pk PRIMARY KEY,
       subj_name VARCHAR2(20) NOT NULL UNIQUE,
       mem_id VARCHAR2(20) NOT NULL,
       CONSTRAINT member_subject_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE 
);
CREATE TABLE Exam(
       exam_seq INT CONSTRAINT exam_pk PRIMARY KEY,
       term VARCHAR2(10) NOT NULL,
       score INT DEFAULT 0,
       subj_seq INT,
       mem_id VARCHAR2(20),
       CONSTRAINT subject_exam_fk FOREIGN KEY (subj_seq) REFERENCES Subject(subj_seq) ON DELETE CASCADE,
       CONSTRAINT member_exam_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE 
); 

CREATE or replace VIEW Major_view 
AS 
SELECT 
 m.major_seq as majorSeq,
 m.title AS majorTitle,
 u.mem_id AS id,
 u.pw AS pw,
 u.name AS name,
 u.gender AS gender,
 u.reg_date AS regDate,
 u.ssn AS ssn,
 u.email AS email,
 u.profile_img AS profileImg,
 u.role AS role,
 u.phone AS phone
FROM Major m, Member u 
WHERE m.major_seq = u.major_seq; 

CREATE or replace VIEW Grade_view
AS
SELECT 
 u.mem_id AS id,
 u.pw AS pw,
 u.name AS name,
 u.gender AS gender,
 u.reg_date AS regDate,
 u.ssn AS ssn,
 u.email AS email,
 u.profile_img AS profileImg,
 u.role AS role,
 u.birth AS birth,
 u.phone AS phone,
 g.grade_seq AS gradeSeq,
 g.grade AS grade,
 g.term AS term,
 s.subj_seq AS subjSeq,
 s.subj_name AS subjName,
 x.exam_seq AS examSeq,
 x.score AS score
FROM Member u, Grade g, Subject s, Exam x 
WHERE u.mem_id = g.mem_id AND u.mem_id = s.mem_id AND u.mem_id = x.mem_id;

CREATE or replace VIEW Board_view
AS
SELECT 
u.mem_id AS id,
 u.pw AS pw,
 u.name AS name,
 u.gender AS gender,
 u.reg_date AS regDate,
 u.ssn AS ssn,
 u.email AS email,
 u.profile_img AS profileImg,
 u.role AS role,
 u.phone AS phone,
 b.title AS title,
 b.art_seq AS artSeq,
 b.category AS category,
 b.reg_date AS writeDate,
 b.content AS content
FROM Member u, Board b  
WHERE u.mem_id = b.mem_id;


EXEC insertMajor(major_seq.nextVal,'컴퓨터공학');
EXEC insertMember('lee','1','이순신','MALE','2016-07-01','800101-1','lee@test.com','lee.jpg','STUDENT','010-1234-5789','1000');


CREATE OR REPLACE PROCEDURE insertMajor(
	sp_title_seq IN Major.title%TYPE
	) AS
BEGIN
	INSERT INTO major(major_seq,title)
	VALUES(major_seq.nextval,sp_title_seq)
END insertMajor;

CREATE OR REPLACE PROCEDURE insertMember(
	sp_mem_id IN Member.mem_id%TYPE,
	sp_pw IN Member.pw%TYPE,
	sp_name IN Member.name%TYPE,
	sp_gender IN Member.gender%TYPE,
	sp_reg_date IN Member.reg_date%TYPE,
	sp_ssn IN Member.ssn%TYPE,
	sp_email IN Member.email%TYPE,
	sp_profile_img IN Member.profile_img%TYPE,
	sp_role IN Member.role%TYPE,
	sp_phone IN Member.phone%TYPE,
	sp_major_seq IN Member.major_seq%TYPE
) AS
BEGIN
	INSERT INTO member(mem_id,pw,name,gender,reg_date,ssn,email,profile_img,role,phone,major_seq)
	VALUES(sp_mem_id,sp_pw,sp_name,sp_gender,sp_reg_date,sp_ssn,sp_email,sp_profile_img,sp_role,sp_phone,sp_major_seq)
END insertMember;

CREATE OR REPLACE PROCEDURE insertGrade(
	sp_grade_seq IN Grade.grade_seq%TYPE,
	sp_grade IN Grade.grade%TYPE,
	sp_term IN Grade.term%TYPE
	) AS
BEGIN
	INSERT INTO grade(grade_seq,grade,term)
	VALUES(sp_grade_seq,sp_grade,sp_term)
END insertGrade;

CREATE OR REPLACE PROCEDURE insertBoard(
	sp_art_seq IN Board.art_seq%TYPE,
	sp_category IN Board.category%TYPE,
	sp_title IN Board.title%TYPE,
	sp_content IN Board.content%TYPE,
	sp_mem_id IN Board.mem_id%TYPE
	) AS
BEGIN
	INSERT INTO board(art_seq,category,title,content,mem_id)
	VALUES(sp_art_seq,sp_category,sp_title,sp_content,sp_mem_id)
END insertBoard;

CREATE OR REPLACE PROCEDURE insertSubject(
	sp_subj_seq IN Subject.subj_seq%TYPE,
	sp_subj_name IN Subject.subj_name%TYPE,
	sp_mem_id IN Subject.mem_id%TYPE
	) AS
BEGIN
	INSERT INTO subject(subj_seq,subj_name,mem_id)
	VALUES(sp_subj_seq,sp_subj_name,sp_mem_id)
END insertSubject;

CREATE OR REPLACE PROCEDURE insertExam(
	sp_exam_seq IN Exam.exam_seq%TYPE,
	sp_term IN Exam.term%TYPE,
	sp_score IN Exam.score%TYPE
	) AS
BEGIN
	INSERT INTO exam(exam_seq,term,score)
	VALUES(sp_exam_seq,sp_term,sp_score)
END insertExam;


INSERT INTO member(id,pw,name,reg_date,ssn,email,profile_img)
VALUES('lee','1','이순신','2016-07-01','800101-1','lee@test.com','lee.jpg');
INSERT INTO member(id,pw,name,reg_date,ssn,email,profile_img)
VALUES('hong1','1','홍길동','2015-07-01','901201-1','hong@test.com','hong.jpg');
INSERT INTO member(id,pw,name,reg_date,ssn,email,profile_img)
VALUES('you','1','유관순','2014-07-01','010701-4','you@test.com','you.jpg');
INSERT INTO member(id,pw,name,reg_date,ssn,email,profile_img)
VALUES('hong','1','홍길동','2015-07-01','301201-1','hoing2@test.com','hong.jpg');
INSERT INTO member(id,pw,name,reg_date,ssn,email,profile_img)
VALUES('hong3','1','홍길동','2015-07-01','501201-1','hong3@test.com','hong3.jpg');
INSERT INTO member(id,pw,name,reg_date,ssn,email,profile_img)
VALUES('choi','1','최진실','2015-07-01','501201-1','choi@test.com','choi.jpg');

--READ ()// static 개념으로 접근한다
SELECT * FROM member;-- list
SELECT * FROM member WHERE id = 'hong';-- findByPK map의 키값
SELECT * FROM member WHERE gender = '남';-- findByNotPK
SELECT count(*) AS count FROM member;--- count
--UPDATE
ALTER TABLE member ADD email VARCHAR2(30);
ALTER TABLE member ADD profile_img VARCHAR2(100);
UPDATE member SET email='hong@test.com' WHERE id = 'you';
UPDATE member SET email= id||'@test.com';
UPDATE member SET profile_img= id||'.jpg';
UPDATE member SET reg_date = '2015-03-03' WHERE reg_date is null;
UPDATE member SET phone = '010-3333-3333' WHERE mem_id = 'hong';
--delete
DELETE FROM member WHERE id = 'qqq';

DROP TABLE member1;


---------------grade----------------------
SELECT * FROM tab;
SELECT * FROM grade;

CREATE sequence seq
increment by 1
start with 1000
nocycle;

DROP TABLE grade;



ALTER TABLE grade ADD exam_date VARCHAR2(10);
--- CREATE
INSERT INTO grade(
seq,grade,java,sql,html,javAScript,id,exam_date
)VALUES(
seq.nextval,'C',75,78,72,70,'you','2016-05'
);
--- read : list
SELECT * FROM grade;
--- read : findByPk
SELECT * FROM grade WHERE seq='1000';
--- read : findByID
SELECT * FROM grade WHERE id = 'you';
---- read : count
SELECT count(*) FROM grade;
--- UPDATE : UPDATE
UPDATE grade SET exam_date = '2016-05'
WHERE seq = 1000;

DELETE FROM grade WHERE seq = '1000';

--------------------------------------------------------------------
---뷰 권한주기
sqlplus system/hanbit
grant dba to hanbit;

CREATE VIEW grade_view
AS SELECT * FROM grade;

SELECT * FROM grade_view;

DROP VIEW grade_view;

--join 조인


CREATE VIEW grade_member AS
SELECT  
    g.seq AS seq,
	g.grade AS grade,
	g.java AS java,
	g.sql AS sql,
	g.html AS html,
	g.javAScript AS js,
	g.exam_date AS exam_date,
	m.id AS id,
	m.pw AS pw,
	m.name AS name,
	m.reg_date AS reg_date,
	m.ssn AS ssn 
FROM member m,grade g WHERE m.id = g.id;

SELECT 
id,
name,
grade,
java,
sql,
html,
js
FROM grade_member;