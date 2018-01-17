create database if not exists db1;
use db1;

create table if not exists `Car` (
    `id` int auto_increment primary key,
    `name` text,
    `price` real
);
