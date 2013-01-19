DROP TABLE IF EXISTS problem;
CREATE TABLE problem(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  json longtext,
  PRIMARY KEY (id)
);