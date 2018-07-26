CREATE TABLE IF NOT EXISTS `drop_module_users` (
  `uniqueId` BINARY(16) PRIMARY KEY,
  `name` VARCHAR(16) NOT NULL UNIQUE,
  `level` INT(11) DEFAULT 1
)

