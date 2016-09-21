CREATE TABLE `booking` (
  id VARCHAR(255) not null primary key,
  `batterycode` VARCHAR(45) NOT NULL,
  `stationid` VARCHAR(255) NULL,
  `city` VARCHAR(45) NULL,
  `latitude` DECIMAL(10,8) NOT NULL,
  `longitude` DECIMAL(10,8) NOT NULL
  );
