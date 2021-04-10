-- 单表查询

select distinct
from
where
group by  having
order by    desc

select Sname NAME, 2014 - Sage Birthday 
from Student
where Sdept = 'CS'
order by Sdept, Sage DESC;

select Cno, Cname, count(Sno)
from SC
where Cname <> 'CS'
group by Cno having count(*) > 3;
order by Cno desc, Cname asc;

/*从from中按where的要求选出select中的列，接着按照group by中的列分组算出select中的
聚集函数值，过滤出满足having条件的组，将结果按照order by排序*/

-- 多表查询

/*等值连接 非等值连接 自然连接（公共字段值相同的连接起来 natural join） 自身连接
外连接(outer join) 左外 右外 全外 内连接(inner join, inner 是可选的)
复合连接*/

select sum(Credit) as sum_credict
from SC, Course
where Sno = '201521210023' and SC.Cno = Course.Cno;

r1 join r2 using(A1, A2)

select Student.Sno, Sname, Ssex, Sage, Sdept, Cno, Grade, SC.*
from Student left outer join SC on (Student.Sno = SC.Sno)
where 

注：0. on 类似于where这样的条件；
1. join 会让*里面重复的属性都出现在结果中；
2. 

-- 数据类型
date
time
timestamp
interval 数据类型
cast e as t 
时间函数，算术运算，比较运算
create type // domain

clob blob

-- 运算
0. 算术运算：空值结果为空
1. 比较运算符：算术、字符串、日期；空值结果为unknown；
2. not like "%lu_\%" escape "\"
3. not between a and b 表示 a <= x <= b；not in 
4. 集合运算：union all: 不去重
    intersect all
    except all
5. 聚集：count(distinct id) max, min, avg, sum, some, every, 空值可以进入count运算；空集的count为0；
6. case
       when salary > 10000, then salary * 1.2
       when salary > 100000, then salary * 1.3
       else salary * 1.4
   end

-- 嵌套查询
1. 集合成员资格：in 子句
2. 集合比较：> some (), > all ()
3. 空查询集合判断：exists ()
相关子查询：使用了外层查询的相关名称
4. unique: 重复元组测试
5. from 子句：
6. with dept_total(dept_name, value) as
       (select
        from 
        where)
        dept_avg(dept_name, value) as
        (select
        from 
        where)
7. 标量子查询：
