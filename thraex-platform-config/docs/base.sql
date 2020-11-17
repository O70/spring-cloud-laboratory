DROP DATABASE IF EXISTS `thraex-config`;

CREATE DATABASE IF NOT EXISTS `thraex-config` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `thraex-config`.properties;
CREATE TABLE `thraex-config`.properties (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    application VARCHAR(100),
    profile VARCHAR(100),
    label VARCHAR(100)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `thraex-config`.values;
CREATE TABLE `thraex-config`.values (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    pid VARCHAR(36),
    `key` VARCHAR(200),
    value VARCHAR(200)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
