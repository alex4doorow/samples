insert into sf_users(id, name, last_name, email, hash_pass)
values
(1, "Tester", "Testerov", "test@test.ru", "12345"),
(2, "Eric", "Viking", "Eric@north.se", "12345"),
(3, "Olaf", "Viking", "Olaf@north.se", "12345"),
(4, "Baleog", "Viking", "Baleog@north.se", "12345"),
(5, "ТипичноеИмя", "ТипичнаяФамилия", "typical@typical.ru", "12345"),
(6, "такое_же_длинное_имя_с_нестандартными_символами_#!@$#?\_вот", "Проверка_Поля_на_достаточно_длинную_и_нестандартную_фамилию", "почта@русская.ру", "12345");

insert into sf_messages(request_user_id, response_user_id, text, read_status, send_status)
values
(1, 2, "1-1-1--1-1-1-1", "NOT", "PREPARE"),
(3, 4, "1-1-1--1-1-1-1", "READ", "SEND");
