# question
/*
 表: Orders

+-----------------+----------+
| Column Name     | Type     |
+-----------------+----------+
| order_number    | int      |
| customer_number | int      |
+-----------------+----------+
Order_number是该表的主键。
此表包含关于订单ID和客户ID的信息。

编写一个SQL查询，为下了 最多订单 的客户查找 customer_number 。

测试用例生成后， 恰好有一个客户 比任何其他客户下了更多的订单。

查询结果格式如下所示。

输入: 
Orders 表:
+--------------+-----------------+
| order_number | customer_number |
+--------------+-----------------+
| 1            | 1               |
| 2            | 2               |
| 3            | 3               |
| 4            | 3               |
+--------------+-----------------+
输出: 
+-----------------+
| customer_number |
+-----------------+
| 3               |
+-----------------+
解释: 
customer_number 为 '3' 的顾客有两个订单，比顾客 '1' 或者 '2' 都要多，因为他们只有一个订单。
所以结果是该顾客的 customer_number ，也就是 3 。
 */

# framework
Create table If Not Exists orders
(
    order_number    int,
    customer_number int
);
Truncate table orders;
insert into orders (order_number, customer_number)
values ('1', '1');
insert into orders (order_number, customer_number)
values ('2', '2');
insert into orders (order_number, customer_number)
values ('3', '3');
insert into orders (order_number, customer_number)
values ('4', '3');

# answer
select customer_number
from Orders
group by customer_number
order by count(order_number) desc
limit 0, 1;