## login db

`mysql -u root -proot`

## show database

`show databases;`

## switch database or table

`use db`

`show tables;`

## show  how to create table

```mysql
show create table company1\G
 CREATE TABLE `company1` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

## explain cmd

```mysql
explain select * from company1;
+----+-------------+----------+------------+------+---------------+------+---------+------+------+----------+-------+
| id | select_type | table    | partitions | type | possible_keys | key  | key_len | ref  | rows | filtered | Extra |
+----+-------------+----------+------------+------+---------------+------+---------+------+------+----------+-------+
|  1 | SIMPLE      | company1 | NULL       | ALL  | NULL          | NULL | NULL    | NULL |    2 |   100.00 | NULL  |
+----+-------------+----------+------------+------+---------------+------+---------+------+------+----------+-------+
```

> https://dev.mysql.com/doc/refman/5.7/en/show-create-table.html

