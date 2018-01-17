create database if not exists db1;
use db1;

create table if not exists `Car` (
    `id` int auto_increment primary key,
    `name` text,
    `price` real
);

create table if not exists `Accessory` (
    `id` int auto_increment primary key,
    `description` text,
    `car_id` int references `Car` (`id`)
);
