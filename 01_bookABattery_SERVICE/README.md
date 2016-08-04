 
 
 drop database bookABattery_DB;
 

 create database bookABattery_DB;

CREATE USER 'bab_USER'@'localhost' IDENTIFIED BY 'bab_USER';
CREATE DATABASE bookABattery_DB;
GRANT ALL ON bookABattery_DB.* TO 'bab_USER'@'localhost';
 

use bookABattery_DB;

 