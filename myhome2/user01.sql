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
