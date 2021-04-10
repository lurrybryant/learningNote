create schema lulei;
    -- 创建表结构
	create table Student (
		Sno  CHAR(9) PRIMARY KEY,
		Sname CHAR(20) UNIQUE,
		Ssex CHAR(2) not null,
		Sage SMALLINT check (Ssex in ('男', '女')),
		Sdept CHAR(20)
		   constraint c1 check (Sdept in ('CS','IS'))
		);

	create table Course (
		Cno CHAR(4) ,
		Cname CHAR(40) ,
		Cpno CHAR(4) ,
		Credit SMALLINT default 0,
        PRIMARY KEY (Cno) ,
		FOREIGN KEY Cpno REFERENCES Student(Cno)
		);

    create table temp_course like Course ;
    create table t1 as 
        (select *
         from Course
         where 
            )
    with data ;
    -- 修改表结构
	alter table Course add column entrance DATE unique (Cname)
	                   alter column Sage INT
	                   drop column Ssex;

	drop table Student;

	create cluster index Stusname on Student(Sname);
	create unique index Stusno on Student(Sno);
	drop index Stusno;
    
    /*可以插入子查询和元祖*/
    -- 增删改
    insert into Student (Sno, Sname, Ssex, Sdept, Sage) 
    	values ('201521210023','lulei','男','CS','24');

    update Student
    	set Sage = 22
    	where Sno = '201521210023';
    update Student
        set salary = 1.5*salary
        where salary < 10000

    delete from SC

    delete 
    	from SC
    	where 'SC' = zichaxunjieguo;
    -- 创建修改视图
    create view is_student as
    	select Sno, Sname, Sage
    	from Student
    	where Sdept = 'IS'
    with check option;

    drop view is_student;

    update delete insert 视图转为对基本表的操作,并非所有都可以更新;
    -- 事务
    set constraints constraints-list deferred
    -- 复制check条件与断言
    check (time_slot_id in (select time_slot_id from time_slot))
    create assertion timeslots_constraint check ()
    -- 授权
    grant select
    	on table Student, Course
    	to U1
    	with grant option;

    revoke insert
    on table SC
    from U5 CASCADE;

    create user lupleisj
    	with connect | resource | dba

    create role R1;
    grant select on table Student to R1 with admin option;
    grant R1 to 卢磊;
    revoke R1 from 卢磊;
    -- 触发器
    create trigger insert_or_update_sal
    	before insert or update on teacher
    	for each row
    	as begin
           if new.Job = '教授' and (new.Sal < 40000) then
              new.Sal = 4000;
           end if
    	end;

   drop trigger insert_or_update_sal on teacher;

drop schema lulei;



