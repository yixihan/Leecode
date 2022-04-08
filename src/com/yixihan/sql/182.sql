# question
/*
 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
根据以上输入，你的查询应返回以下结果：

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
说明：所有电子邮箱都是小写字母。
 */

# framework
Create table If Not Exists Person
(
    id    int,
    email varchar(255)
);
Truncate table Person;
insert into Person (id, email)
values ('1', 'a@b.com');
insert into Person (id, email)
values ('2', 'c@d.com');
insert into Person (id, email)
values ('3', 'a@b.com');

# answer
select distinct p1.Email
from Person as p1
         left join Person as p2 on p1.Id != p2.Id
where p1.Email = p2.Email;

select distinct p1.Email
from Person as p1
         left join Person as p2 on p1.Email = p2.Email and p1.Id != p2.Id
where p2.Id is not null;