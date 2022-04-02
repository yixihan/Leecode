# question
/*
 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。

Customers 表：

+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Orders 表：

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
例如给定上述表格，你的查询应返回：

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
 */

# framework
Create table If Not Exists Customers
(
    id   int,
    name varchar(255)
);
Create table If Not Exists Orders
(
    id         int,
    customerId int
);
Truncate table Customers;
insert into Customers (id, name)
values ('1', 'Joe');
insert into Customers (id, name)
values ('2', 'Henry');
insert into Customers (id, name)
values ('3', 'Sam');
insert into Customers (id, name)
values ('4', 'Max');
Truncate table Orders;
insert into Orders (id, customerId)
values ('1', '3');
insert into Orders (id, customerId)
values ('2', '1');

# answer
select Name as `Customers`
from Customers
where Id not in (
    select Customers.Id
    from Orders
             left join Customers on Customers.Id = Orders.CustomerId
);

# 查找订购过东西的用户
# select Customers.Id
#     from Orders
#     left join Customers on Customers.Id = Orders.CustomerId

select c.Name as Customers
from Customers as c
where c.Id not in (
    select CustomerId
    from Orders
);