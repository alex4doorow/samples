INSERT INTO hotels(name, address, rating)
VALUES
  (
    'Центр-Отель', 'г. Симферополь, ул. Горького, 19',
    8
  );
INSERT INTO hotels(name, address, rating)
VALUES
  (
    'Plasa', 'г. Город, ул. Ленина, 1',
    9
  );
INSERT INTO hotels(name, address, rating)
VALUES
  (
    'Hostel Fun', 'г. Урюпинск, ул. Задворкина, 153б',
    6
  );
INSERT INTO hotels(name, address, rating)
VALUES
  (
    'Amparo', 'Mexico, San Miguel de Allende',
    10
  );
INSERT INTO hotels(name, address, rating)
VALUES
  (
    'у бабы Люды', 'Крым, г. Ялта, ул. Лесная, 11',
    3
  );
INSERT INTO hotels(name, address, rating)
VALUES
  (
    'Hilton Leningradskaya', 'Каланчёвская ул., 21/40',
    8
  );


INSERT INTO room_type(
  hotel_id, name, total_count, number_of_beds,
  price_per_night, description
)
VALUES
  (1, 'standard', 5, 2, 40, NULL);
INSERT INTO room_type(
  hotel_id, name, total_count, number_of_beds,
  price_per_night, description
)
VALUES
  (
    1, 'half-luxe', 1, 2, 100, 'Мы хотели сделать Люкс, но сделали только половинку'
  );
INSERT INTO room_type(
  hotel_id, name, total_count, number_of_beds,
  price_per_night, description
)
VALUES
  (
    2, 'standard', 50, 2, 35, 'Стандартный номер со стандартным набором стандартов'
  );
INSERT INTO room_type(
  hotel_id, name, total_count, number_of_beds,
  price_per_night, description
)
VALUES
  (
    2, 'luxe', 2, 4, 110, 'Номер-люкс с лучшим видом на лучшую статую В.И.Ленина в области'
  );
INSERT INTO room_type(
  hotel_id, name, total_count, number_of_beds,
  price_per_night, description
)
VALUES
  (
    3, 'bed in 12-bed room', 12, 1, 5, NULL
  );
INSERT INTO room_type(
  hotel_id, name, total_count, number_of_beds,
  price_per_night, description
)
VALUES
  (
    4, 'standard', 20, 2, 200, 'Стандартный номер в отличном отеле'
  );
INSERT INTO room_type(
  hotel_id, name, total_count, number_of_beds,
  price_per_night, description
)
VALUES
  (
    4, 'luxe', 3, 4, 1100, 'Отличный номер в отличном отеле'
  );
INSERT INTO room_type(
  hotel_id, name, total_count, number_of_beds,
  price_per_night, description
)
VALUES
  (
    5, 'что дают', 1, 2, 50, 'Как будто у тебя выбор есть'
  );
INSERT INTO room_type(
  hotel_id, name, total_count, number_of_beds,
  price_per_night, description
)
VALUES
  (
    6, 'standard', 200, 2, 100, 'У нас есть очень большая люстра и вокзал рядом'
  );
INSERT INTO room_type(
  hotel_id, name, total_count, number_of_beds,
  price_per_night, description
)
VALUES
  (
    6, 'luxe', 15, 4, 450, 'Смотрите на привокзальную толпу с высоты!'
  );


INSERT INTO clients(
  first_name, second_name, surname,
  passport_number
)
VALUES
  (
    'Владимир', 'Владимирович',
    'Маяковский', 'из широких штанин'
  );
INSERT INTO clients(
  first_name, second_name, surname,
  passport_number
)
VALUES
  (
    'Владимир', 'Владимирович',
    'Путин', 'почётный паспорт РФ №1'
  );
INSERT INTO clients(
  first_name, second_name, surname,
  passport_number
)
VALUES
  (
    'Василий', 'Сергеевич',
    'Пупкин', '9876 123456'
  );
INSERT INTO clients(
  first_name, second_name, surname,
  passport_number
)
VALUES
  (
    'Александр', 'Сергеевич',
    'Пушкин', '1234 567890'
  );
INSERT INTO clients(
  first_name, second_name, surname,
  passport_number
)
VALUES
  (
    'Владимир', 'Ильич',
    'Ульянов', 'Паспорт СССР #1'
  );
INSERT INTO clients(
  first_name, second_name, surname,
  passport_number
)
VALUES
  (
    'Брат', 'Братан', 'Братишка',
    '777'
  );
INSERT INTO clients(
  first_name, second_name, surname,
  passport_number
)
VALUES
  (
    'Анна', 'Семёновна',
    'Петренко', '8609 914771'
  );
INSERT INTO clients(
  first_name, second_name, surname,
  passport_number
)
VALUES
  (
    'Ernest', 'Miller', 'Hemingway', '1111 2222 3333'
  );


INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    1, 10, '1929-01-01', '1929-01-31',
    'CLOSED'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    1, 10, '1930-04-10', '1930-04-20',
    'CANCELLED'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    2, 10, '2020-01-01', '2020-01-10',
    'CLOSED'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    3, 3, '2019-05-01', '2019-05-09', 'CLOSED'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    3, 8, '2020-10-05', '2020-10-12', 'PAID'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    3, 1, '2021-05-01', '2021-05-09', 'PAYMENT_PENDING'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    4, 4, '1833-03-17', '1833-04-05', 'CLOSED'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    5, 6, '1907-07-07', '1908-08-08', 'CANCELLED'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    5, 10, '1966-06-01', '1966-06-18',
    'CLOSED'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    6, 8, '2019-07-12', '2019-07-26', 'CLOSED'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    6, 7, '2019-09-10', '2019-09-20', 'CLOSED'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    7, 4, '2019-08-05', '2019-08-12', 'CANCELLED'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    8, 6, '1952-02-21', '1952-02-29', 'CLOSED'
  );
INSERT INTO reservations(
  client_id, room_type_id, start_date,
  end_date, STATUS
)
VALUES
  (
    8, 5, '1940-11-01', '1940-11-05', 'CANCELLED'
  );

INSERT INTO services(name, price)
VALUES
  ('завтрак', 10);
INSERT INTO services(name, price)
VALUES
  ('химчистка', 5);
INSERT INTO services(name, price)
VALUES
  ('ужин', 20);
INSERT INTO services(name, price)
VALUES
  ('чай', 40);
INSERT INTO services(name, price)
VALUES
  ('что угодно', 10000);

INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (1, 1);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (1, 2);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (2, 5);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (3, 4);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (4, 1);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (5, 1);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (5, 3);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (6, 1);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (7, 3);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (8, 4);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (9, 5);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (10, 1);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (10, 3);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (11, 5);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (12, 1);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (13, 4);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (13, 2);
INSERT INTO services_booked(reservation_id, service_id)
VALUES
  (14, 1);