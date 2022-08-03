create table board(
id number(10) primary key,
title varchar2(1000),
contents clob,
writer varchar2(60),
wdate date);

insert into board values('1','제목1','내용1','작성자1',sysdate);

insert into board values('2','제목2','내용2','작성자3',sysdate);

insert into board values('3','제목3','내용2','작성자3',sysdate);

commit;

create table grade(
id number(10) primary key,
name varchar2(10),
kor number(10),
math number(10),
eng number(10),
grade_sum number(30),
grade_avg number(30));

insert into grade values(1,'민수',50,50,50,150,50);

insert into grade values(2,'지혜',60,90,60,210,70);

commit;


create sequence boardSeq;
select boardSeq.nextVal from dual;
