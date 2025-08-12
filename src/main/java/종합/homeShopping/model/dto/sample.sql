drop  database if exists assessment  ;
create database assessment;
use assessment;
create table MEMBER_TBL_02(
	CUSTNO int auto_increment not null,
    constraint primary key(CUSTNO),
    CUSTNAME varchar(20),	-- 회원이름
    PHONE varchar(13), 		-- 연락처
    ADDRESS varchar(60),	-- 주소
    JOINDATE date default(current_date),	-- 가입일자
    GRADE char(1),	-- 고객등급
    CITY char(2)	-- 거주 도시	
)AUTO_INCREMENT = 100001;

create table MONEY_TBL_02(
	CUSTNO int  not null,
    constraint foreign key (CUSTNO) references MEMBER_TBL_02(CUSTNO),
    SALENOL int not null,
    constraint primary key(SALENOL),
    PCOST int,		-- 단가
    AMOUNT int,		-- 수량
    PRICE int,		-- 가격
    PCODE varchar(4), -- 상품코드
    SDATE date -- 판매일자
);

insert into MEMBER_TBL_02 (CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) values
( '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '2015-12-02', 'A', '01'),
( '이축복', '010-1111-3333', '서울 동대문구 휘경2동', '2015-12-06', 'B', '01'),
( '장민음', '010-1111-4444', '울릉군 울릉읍 독도1리', '2015-10-01', 'B', '30'),
( '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', '2015-11-13', 'A', '30'),
( '진평화', '010-1111-6666', '제주도 제주시 외나무골', '2015-12-25', 'B', '60'),
( '자공단', '010-1111-7777', '제주도 제주시 감나무골', '2015-12-11', 'C', '60');

insert into MONEY_TBL_02(CUSTNO,SALENOL,PCOST,AMOUNT,PRICE,PCODE,SDATE) values
(100001,20160001,500,5,2500,"A001","2016-01-01"),
(100001,20160002,1000,4,4000,"A002","2016-01-01"),
(100001,20160003,500,3,1500,"A008","2016-01-01"),
(100002,20160005,500,1,500,"A001","2016-01-03"),
(100003,20160006,1500,2,3000,"A003","2016-01-03"),
(100004,20160007,500,2,1000,"A001","2016-01-04"),
(100004,20160008,300,1,300,"A005","2016-01-04"),
(100004,20160009,600,1,600,"A006","2016-01-04"),
(100004,20160010,3000,1,3000,"A007","2016-01-06");

SELECT *FROM MEMBER_TBL_02;
SELECT *FROM MONEY_TBL_02;

select mem.custno,mem.custname,mem.grade,sum(mon.price)매출 from member_tbl_02 mem inner join  money_tbl_02 mon on mem.custno = mon.custno group by mem.custno,mem.custname,mem.grade order by 매출 desc;