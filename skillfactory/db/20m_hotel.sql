--Отель;
--Клиент;
--Бронирование;
--Тип номеров;
--Сервисы (завтрак, трансфер и т.д.);
--Бронь сервисов (в этой таблице вы будете хранить информацию о том, какие сервисы были дополнительно заказаны).

CREATE TABLE hotels (
  id SERIAL PRIMARY KEY,
  name VARCHAR NOT NULL,
  address VARCHAR NOT NULL,
  rating INTEGER CHECK(
    rating <= 10
    AND rating >= 0
  )
);
CREATE TABLE room_type (
  id SERIAL PRIMARY KEY,
  hotel_id INTEGER NOT NULL REFERENCES hotels(id),
  name VARCHAR NOT NULL,
  total_count INTEGER NOT NULL CHECK(total_count > 0),
  number_of_beds INTEGER NOT NULL CHECK(number_of_beds > 0),
  price_per_night money NOT NULL,
  description VARCHAR
);

ALTER TABLE
  room_type
ADD
  CONSTRAINT positive_price_per_night CHECK (price_per_night > 0 :: mоney);

CREATE TABLE clients (
  id serial PRIMARY KEY, first_name VARCHAR NOT NULL,
  surname VARCHAR NOT NULL, second_name VARCHAR,
  passport_number VARCHAR NOT NULL
);
CREATE TABLE reservations (
  id serial PRIMARY KEY,
  client_id INTEGER REFERENCES clients(id),
  room_type_id INTEGER REFERENCES room_type(id),
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  STATUS VARCHAR NOT NULL CHECK(
    STATUS IN (
      'PAYMENT_PENDING', 'PAID', 'CANCELLED',
      'CLOSED'
    )
  )
);
CREATE TABLE services (
  id serial PRIMARY KEY, name VARCHAR NOT NULL,
  price money NOT NULL
);
CREATE TABLE services_booked (
  reservation_id INTEGER REFERENCES reservations(id),
  service_id INTEGER REFERENCES services(id)
);

