create database db_member;
\c db_member;
create table team_member(
student_id char(50) primary key not null,
name char(50),
gender char(50),
age int,
birthday char(50),
contact char(50),
email char(50),
classes char(50),
hobby char(50)
);