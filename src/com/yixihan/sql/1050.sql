# question
/*
 ActorDirector 表：

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| actor_id    | int     |
| director_id | int     |
| timestamp   | int     |
+-------------+---------+
timestamp 是这张表的主键.

写一条SQL查询语句获取合作过至少三次的演员和导演的 id 对 (actor_id, director_id)

ActorDirector 表：
+-------------+-------------+-------------+
| actor_id    | director_id | timestamp   |
+-------------+-------------+-------------+
| 1           | 1           | 0           |
| 1           | 1           | 1           |
| 1           | 1           | 2           |
| 1           | 2           | 3           |
| 1           | 2           | 4           |
| 2           | 1           | 5           |
| 2           | 1           | 6           |
+-------------+-------------+-------------+

Result 表：
+-------------+-------------+
| actor_id    | director_id |
+-------------+-------------+
| 1           | 1           |
+-------------+-------------+
唯一的 id 对是 (1, 1)，他们恰好合作了 3 次。
 */

# framework
Create table If Not Exists ActorDirector
(
    actor_id    int,
    director_id int,
    timestamp   int
);
Truncate table ActorDirector;
insert into ActorDirector (actor_id, director_id, timestamp)
values ('1', '1', '0');
insert into ActorDirector (actor_id, director_id, timestamp)
values ('1', '1', '1');
insert into ActorDirector (actor_id, director_id, timestamp)
values ('1', '1', '2');
insert into ActorDirector (actor_id, director_id, timestamp)
values ('1', '2', '3');
insert into ActorDirector (actor_id, director_id, timestamp)
values ('1', '2', '4');
insert into ActorDirector (actor_id, director_id, timestamp)
values ('2', '1', '5');
insert into ActorDirector (actor_id, director_id, timestamp)
values ('2', '1', '6');

# answer
select actor_id, director_id
from ActorDirector
group by actor_id, director_id
having count(timestamp) >= 3;