DROP TABLE dutymap.transaction;

CREATE TABLE dutymap.transaction (
  `id_transaction` int(11) NOT NULL AUTO_INCREMENT,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `comment` varchar(140) DEFAULT NULL,
  `to_user` bigint(20) DEFAULT NULL,
  `from_user` bigint(20) DEFAULT NULL,
  `id_state` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_transaction`),
  UNIQUE KEY `id_transaction_UNIQUE` (`id_transaction`),
  KEY `id_transaction_2` (`id_transaction`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
SELECT * FROM dutymap.transaction;