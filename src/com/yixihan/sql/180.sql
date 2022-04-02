# question
/*
表：Logs

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
id 是这个表的主键。

编写一个 SQL 查询，查找所有至少连续出现三次的数字。

返回的结果表中的数据可以按 任意顺序 排列。

查询结果格式如下面的例子所示：

输入：
Logs 表：
+----+-----+
| Id | Num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+
输出：
Result 表：
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
解释：1 是唯一连续出现至少三次的数字。

*/

# framework
Create table If Not Exists Logs
(
    id  int,
    num int
);
Truncate table Logs;
insert into Logs (id, num)
values ('1', '1');
insert into Logs (id, num)
values ('2', '1');
insert into Logs (id, num)
values ('3', '1');
insert into Logs (id, num)
values ('4', '2');
insert into Logs (id, num)
values ('5', '1');
insert into Logs (id, num)
values ('6', '2');
insert into Logs (id, num)
values ('7', '2');

# answer
/*
与自关联或自连接相比，这种方法的效率更高，不受Logs表中的Id是否连续的限制，而且可以任意设定某个值连续出现的次数。

针对评论区朋友的疑问，这里做下解答：

1）逻辑：构建两个变量@prev 和@count ，前者用于与Num做比较判断，后者用于@prev和Num相等时的条件计数；

2）(select @prev := null,@count := null) as t 这句的作用是初始化两个变量，
并将初始化后的变量放到一张临时表t中，:=符号在MySQL中是赋值的意思；

3）when @prev = Num then @count := @count + 1和when (@prev := Num) is not null then @count := 1
这两个语句不能交换顺序，赋值语句永远非NULL，所以一旦执行顺序来到了第二个when，
@count 是一定会被赋值为1的，后者放到前面的话就达不到计数的目的；

4）(@prev := Num) is not null这部分去掉后面加的判断，SQL也能正常执行，上面SQL中case when的这种用法，
when后是判断条件，赋值后又加判断，我原以为这样会好理解点；

5）case when本质是一个函数，有值时就返回内部处理得到的值，无值就返回NULL，针对每一个Num，
上面SQL中的case when 都会有一个计数，并把这个计数返回给CNT。

 */
select distinct Num as ConsecutiveNums
from (
         select Num,
                case
                    when @prev = Num then @count := @count + 1
                    when (@prev := Num) is not null then @count := 1
                    end as CNT
         from Logs,
              (select @prev := null, @count := null) as t
     ) as temp
where temp.CNT >= 3;