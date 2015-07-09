CREATE DATABASE IF NOT EXISTS user_management DEFAULT CHARACTER SET utf8;
USE user_management;

DROP TABLE IF EXISTS user;

CREATE TABLE user(
  id int auto_increment primary key,
  name varchar(20),
  gender varchar(10),
  email varchar(50),
  age int
);

insert into user values (null,'张三','男','aaa@qq.com',12);
insert into user values (null,'李四','男','bbb@qq.com',15);
insert into user values (null,'王五','男','ccc@qq.com',14);
