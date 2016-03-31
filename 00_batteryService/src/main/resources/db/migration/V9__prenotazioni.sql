CREATE TABLE `prenotazioni` (
  id VARCHAR(255) not null primary key,
  `codice` VARCHAR(45) NOT NULL,
  `stazione` VARCHAR(255) NULL,
  `citta` VARCHAR(45) NULL,
  `latitudine` DECIMAL(10,8) NOT NULL,
  `longitudine` DECIMAL(10,8) NOT NULL
  );
