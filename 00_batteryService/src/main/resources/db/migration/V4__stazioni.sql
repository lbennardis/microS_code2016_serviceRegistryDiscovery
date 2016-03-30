CREATE TABLE `indirizzi` (
  `nome` VARCHAR(45) NOT NULL,
  `indirizzo` VARCHAR(255) NULL,
  `citta` VARCHAR(45) NULL,
  `latitudine` DECIMAL(10,8) NOT NULL,
  `longitudine` DECIMAL(10,8) NOT NULL,
  PRIMARY KEY (`nome`));
