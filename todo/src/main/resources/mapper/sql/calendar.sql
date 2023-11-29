CREATE TABLE calendar_table (
                                no        		NUMBER PRIMARY KEY ,
                                id        		varchar2(100) NOT NULL,
                                startDate     	date,  -- 2023-11-29 10:30
                                endDate       	date,  -- 2023-11-29 10:30
                                allDay    		char(1),     -- oracle 에는 boolean없음 23 부터는 있음
                                title     		varchar2(1000),
                                backgroundColor  	varchar2(100),
                                borderColor  		varchar2(100)
);



DROP TABLE calendar_table;

CREATE SEQUENCE calendar_seq
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 999999;