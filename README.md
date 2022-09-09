## spring boot sharding jdbc demo介绍
MySQL水平分库使用sharding-jdbc
- MySQL 5.7
- MyBatis
- Spring Boot
- jdk 11

## How to start
- 准备两个库shard_00与shard_01
- 建表
```
CREATE TABLE test_user (
               id bigint primary key NOT NULL,
               username VARCHAR(225) DEFAULT NULL,
               password VARCHAR(225) DEFAULT NULL
);
```
- 启动，调用UserController API进行试验

## 测试join
1. shard-00执行
```
CREATE TABLE test_user_status (
                      id bigint primary key NOT NULL,
                      user_id bigint NOT NULL,
                      status varchar(100) NOT NULL
);

INSERT INTO `test_user` (`id`, `username`, `password`)
VALUES
	(0, 'hello', 'x');

INSERT INTO `test_user_status` (`id`, `user_id`, `status`)
VALUES
    (0, 1, '0');
```
2. shard-01执行
```
CREATE TABLE test_user_status (
                      id bigint primary key NOT NULL,
                      user_id bigint NOT NULL,
                      status varchar(100) NOT NULL
);

INSERT INTO `test_user` (`id`, `username`, `password`)
VALUES
	(1, 'hello', 'x');

INSERT INTO `test_user_status` (`id`, `user_id`, `status`)
VALUES
    (0, 0, '0');
```
3. 验证结果`curl localhost:8090/join`返回空，结论：sharding-jdbc不支持跨库join