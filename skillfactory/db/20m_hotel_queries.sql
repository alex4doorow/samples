SELECT
  *
FROM
  reservations
WHERE
  start_date >= '2019-01-01'
  AND end_date <= '2019-12-31';

SELECT
  clients.first_name,
  clients.second_name,
  clients.surname,
  hotels.name AS hotel
FROM
  reservations
  JOIN clients ON client_id = clients.id
  JOIN room_type ON room_type_id = room_type.id
  JOIN hotels ON room_type.hotel_id = hotels.id;

SELECT
  hotels.name,
  SUM(services.price)
FROM
  services_booked
  JOIN services ON service_id = services.id
  JOIN reservations ON reservation_id = reservations.id
  JOIN room_type ON room_type_id = room_type.id
  JOIN hotels ON hotel_id = hotels.id
GROUP BY
  hotels.id;

SELECT
  hotels.name,
  COUNT(*)
FROM
  reservations
  JOIN room_type ON room_type_id = room_type.id
  JOIN hotels ON hotel_id = hotels.id
WHERE
  reservations.status = 'CLOSED'
GROUP BY
  hotels.id;

SELECT
  services.*
FROM
  reservations
  JOIN services_booked sb ON sb.reservation_id = reservations.id
  JOIN services ON sb.service_id = services.id
  JOIN clients ON reservations.client_id = clients.id
WHERE
  clients.surname LIKE '%Пупкин%';

CREATE VIEW paid_centr_hotel AS (
  SELECT
    reservations.*
  FROM
    reservations
    JOIN room_type ON room_type_id = room_type.id
    JOIN hotels ON hotel_id = hotels.id
  WHERE
    hotels.name LIKE '%Центр-Отель%'
);

UPDATE
  reservations
SET
  STATUS = 'CLOSED'
WHERE
  STATUS = 'PAID';

