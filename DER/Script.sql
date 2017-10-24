CREATE TABLE IF NOT EXISTS bitbr.Configuration (
  idInstance INTEGER NOT NULL,
  txMimPurchase DOUBLE NULL,
  txMaxPurchase DOUBLE NULL,
  txMimSale DOUBLE NULL,
  txMaxSale DOUBLE NULL,
  PRIMARY KEY (idInstance),
  CONSTRAINT Instance_FKConfiguration FOREIGN KEY (idInstance) REFERENCES bitbr.Instance(id)
);

CREATE TABLE IF NOT EXISTS bitbr.Instance (
  id INTEGER INTEGER NOT NULL,
  name VARCHAR(50) NULL,
  server VARCHAR(100) NULL,
  port VARCHAR(6) NULL,
  description VARCHAR(255) NULL,
  PRIMARY KEY(id)
);



