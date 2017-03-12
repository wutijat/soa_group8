DROP TABLE IF EXISTS reservation;

CREATE TABLE reservation (

  reservation_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  reservation_date DATE NOT NULL,
  reservation_checkout DATE NOT NULL,
  reservation_adult INTEGER NOT NULL DEFAULT 0,
  reservation_children INTEGER NOT NULL DEFAULT 0,
  reservation_status INTEGER NOT NULL DEFAULT 1,
  reservation_payment_type INTEGER NOT NULL DEFAULT 1,
  room_type INTEGER NOT NULL,
  customer_title_name VARCHAR(10),
  customer_full_name VARCHAR(150) NOT NULL,
  customer_email VARCHAR(150) NOT NULL,
  customer_tel VARCHAR(15),
  customer_country VARCHAR(50),
  customer_nation VARCHAR(50),
  credit_card_id VARCHAR(20) NOT NULL,
  credit_card_expired_date DATE NOT NULL,
  credit_card_cvv VARCHAR(4) NOT NULL

);

DROP TABLE IF EXISTS reservation_status;

CREATE TABLE reservation_status (

  status_id INTEGER NOT NULL,
  status_description VARCHAR(50) NOT NULL

);

DROP TABLE IF EXISTS payment_type;

CREATE TABLE payment_type (

  payment_type_id INTEGER NOT NULL,
  payment_type_description VARCHAR(50) NOT NULL

);