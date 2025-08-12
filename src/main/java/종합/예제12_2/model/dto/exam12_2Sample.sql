drop database if exists exam12_2;
create database exam12_2;
use exam12_2;
create table waiting(
	wno int auto_increment, 
    wphone varchar(13) not null, 
    wcount int,
    constraint primary key (wno)
);

INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0001', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0002', '7');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0003', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0004', '5');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0005', '8');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0006', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0007', '9');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0008', '6');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0009', '4');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0010', '6');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0011', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0012', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0013', '7');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0014', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0015', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0016', '8');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0017', '5');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0018', '6');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0019', '9');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-0020', '4');
delete  from waiting  where wno = 21;
select *from waiting;

update waiting set wcount=? where wno=?;