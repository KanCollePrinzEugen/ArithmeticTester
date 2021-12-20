SET NAMES 'utf8';
CREATE DATABASE arithmetic_tester_schema;
USE arithmetic_tester_schema;
CREATE TABLE child
(
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    pwd CHAR(5) NOT NULL,
    age INT DEFAULT 20
);
CREATE TABLE guardian
(
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    pwd CHAR(5) NOT NULL,
    guardian_id INT NOT NULL
);
CREATE TABLE ADMIN
(
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    pwd CHAR(5) NOT NULL
)