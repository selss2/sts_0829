/*
META PROCEDURE
*/	
SELECT OBJECT_NAME FROM USER_PROCEDURES;

/*
CREATE PROCEDURE
*/

CREATE OR REPLACE PROCEDURE insert_major(sp_title IN Major.title%TYPE) AS
BEGIN
	INSERT INTO Major(major_seq,title) VALUES(major_seq.nextval,sp_title);
	
END insert_major;

EXEC HANBIT.INSERT_MAJOR('컴퓨터공학');

CREATE OR REPLACE PROCEDURE insert_prof(
	sp_mem_id IN Member.mem_id%TYPE,
	sp_pw IN Member.pw%TYPE,
	sp_name IN Member.name%TYPE,
	sp_gender IN Member.gender%TYPE,
	sp_reg_date IN Member.reg_date%TYPE,
	sp_ssn IN Member.ssn%TYPE,
	sp_email IN Member.email%TYPE,
	sp_profile_img IN Member.profile_img%TYPE,
	sp_role IN Member.role%TYPE,
	sp_phone IN Member.phone%TYPE
) AS
BEGIN
	INSERT INTO Member(mem_id,pw,name,gender,reg_date,ssn,email,profile_img,role,phone) 
	VALUES(sp_mem_id,sp_pw,sp_name,sp_gender,sp_reg_date,sp_ssn,sp_email,sp_profile_img,sp_role,sp_phone);
END insert_prof;

CREATE OR REPLACE PROCEDURE insert_student(
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
	INSERT INTO Member(mem_id,pw,name,gender,reg_date,ssn,email,profile_img,role,phone,major_seq) 
	VALUES(sp_mem_id,sp_pw,sp_name,sp_gender,sp_reg_date,sp_ssn,sp_email,sp_profile_img,sp_role,sp_phone,sp_major_seq);
END insert_student;

EXEC HANBIT.INSERT_STUDENT('hong','1','홍길동','MALE','2016-06-01','800101-1','hong@test.com','default.jpg','STUDENT','010-1234-5678','1001');
EXEC HANBIT.INSERT_PROF('profx','1','찰스','MALE','2010-06-01','700101-1','profx@test.com','default.jpg','PROF','010-1234-5678');

CREATE OR REPLACE PROCEDURE insert_subject(
	sp_subj_name IN Subject.subj_name%TYPE,
	sp_mem_id IN Subject.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Subject(subj_seq,subj_name,mem_id) 
	VALUES(subj_seq.NEXTVAL,sp_subj_name,sp_mem_id);
END insert_subject;

EXEC HANBIT.INSERT_SUBJECT('java','profx');

CREATE OR REPLACE PROCEDURE insert_exam(
	sp_exam_seq IN Exam.exam_seq%TYPE,
	sp_term IN Exam.term%TYPE,
	sp_score IN Exam.score%TYPE,
	sp_subj_seq IN Exam.subj_seq%TYPE,
	sp_mem_id IN Exam.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Exam(exam_seq,term,score,subj_seq,mem_id) 
	VALUES(sp_exam_seq,sp_term,sp_score,sp_subj_seq,sp_mem_id);
END insert_exam;

CREATE OR REPLACE PROCEDURE insert_grade(
	sp_grade_seq IN Grade.grade_seq%TYPE,
	sp_grade IN Grade.grade%TYPE,
	sp_term IN Grade.term%TYPE,
	sp_mem_id IN Grade.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Grade(grade_seq,grade,term,mem_id) 
	VALUES(sp_grade_seq,sp_grade,sp_term,sp_mem_id);
END insert_grade;
	
CREATE OR REPLACE PROCEDURE insert_qna(
	sp_art_seq IN Board.art_seq%TYPE,
	sp_category IN Board.category%TYPE,
	sp_title IN Board.title%TYPE,
	sp_reg_date IN Board.reg_date%TYPE,
	sp_content IN Board.content%TYPE,
	sp_mem_id IN Board.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Board(art_seq,category,title,reg_date,content,mem_id) 
	VALUES(sp_art_seq,sp_category,sp_title,sp_reg_date,sp_content,sp_mem_id);
END insert_qna;

CREATE OR REPLACE PROCEDURE insert_notice(
	sp_art_seq IN Board.art_seq%TYPE,
	sp_category IN Board.category%TYPE,
	sp_title IN Board.title%TYPE,
	sp_reg_date IN Board.reg_date%TYPE,
	sp_content IN Board.content%TYPE
) AS
BEGIN
	INSERT INTO Board(art_seq,category,title,reg_date,content) 
	VALUES(sp_art_seq,sp_category,sp_title,sp_reg_date,sp_content);
END insert_notice;


/*
READ PROCEDURE
*/
CREATE OR REPLACE PROCEDURE select_students(
	mem_id OUT Member.mem_id%TYPE,
	pw OUT Member.pw%TYPE,
	name OUT Member.name%TYPE,
	gender OUT Member.gender%TYPE,
	reg_date OUT Member.reg_date%TYPE,
	ssn OUT Member.ssn%TYPE,
	email OUT Member.email%TYPE,
	profile_img OUT Member.profile_img%TYPE,
	role OUT Member.role%TYPE,
	phone OUT Member.phone%TYPE,
	major_seq OUT Member.major_seq%TYPE 
) AS
BEGIN
	SELECT mem_id,pw,name,gender,reg_date,ssn,email,profile_img,role,phone,major_seq 
	FROM Member WHERE major_seq IS NOT NULL;
END select_students;

/*
====== Major stored procedure ======
*/

-- count major

CREATE OR REPLACE PROCEDURE count_major(
	sp_count OUT NUMBER
) AS 
BEGIN
	SELECT COUNT(*) into sp_count FROM Major;
END count_major;


DECLARE
 sp_count NUMBER;
BEGIN
 count_major(sp_count);
 DBMS_OUTPUT.put_line ('전공 수량 : '||sp_count);
END;

-- find major

CREATE OR REPLACE PROCEDURE find_major(
	sp_major_seq IN OUT Major.major_seq%TYPE,
	sp_title OUT Major.title%TYPE,
	sp_result OUT VARCHAR2
) AS 
    sp_temp_count NUMBER;
BEGIN
    SELECT COUNT(*) into SP_temp_count from major where major_seq = sp_major_seq; 
	IF (sp_temp_count > 0) 
	THEN
        SELECT major_seq, title
        INTO sp_major_seq,sp_title 
        FROM Major 
        WHERE major_seq = sp_major_seq;
        sp_result :='과목번호 : '||sp_major_seq||', 과목명 : '||sp_title;
    ELSE  
        sp_result :='전공 과목이 없습니다';
    END IF;
END find_major;

DECLARE
 sp_major_seq NUMBER := 22;
 sp_result VARCHAR2(100);
 sp_title VARCHAR2(100);
BEGIN
 find_major(sp_major_seq,sp_title,sp_result);
  DBMS_OUTPUT.put_line (sp_result);
 END;

-- all major

CREATE OR REPLACE PROCEDURE HANBIT.all_major(
    sp_result OUT CLOB
) AS
    sp_temp CLOB;
    sp_cnt  NUMBER := 0;
BEGIN
        
    FOR major_rec IN (SELECT m.major_seq
                            ,m.title
                      FROM   major m
                     )
    LOOP
        sp_cnt := sp_cnt + 1;
        IF sp_cnt = 1 THEN
           sp_temp := major_rec.major_seq||','||major_rec.title;
           
        ELSE
        
          sp_temp := sp_temp||CHR(10)||
                     major_rec.major_seq||','||major_rec.title;
          
        END IF;
    END LOOP;
    
    sp_result := sp_temp;
    
END all_major;

DECLARE
     sp_result CLOB;
BEGIN
    all_major(sp_result);
    DBMS_OUTPUT.PUT_LINE(sp_result);
    
END; 

/*
===== Member stored procedure ====
*/
-- count_member

-- find_by_id_member

-- all_member




/*
UPDATE PROCEDURE
*/

/*
DROP PROCEDURE
*/
DROP PROCEDURE HANBIT.INSERTMEMBER;