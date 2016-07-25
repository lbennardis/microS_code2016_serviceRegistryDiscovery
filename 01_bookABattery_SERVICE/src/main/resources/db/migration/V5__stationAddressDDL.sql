CREATE TABLE `stationaddress` (
  `stationid` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NULL,
  `city` VARCHAR(45) NULL,
  `latitude` DECIMAL(10,8) NOT NULL,
  `longitude` DECIMAL(10,8) NOT NULL,
  PRIMARY KEY (`stationId`));
