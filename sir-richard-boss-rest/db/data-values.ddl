SET SQL_SAFE_UPDATES = 0;

insert into oc_setting
(`store_id`,`code`,`key`,`value`,`serialized`)
values
(0, 'yandex_beru', 'yandex_beru_auth_token', '7C00000130783B1E', 0);
insert into oc_setting
(`store_id`,`code`,`key`,`value`,`serialized`)
values
(0, 'yandex_beru', 'yandex_beru_2_auth_token', '81000001227D383D', 0);
insert into oc_setting
(`store_id`,`code`,`key`,`value`,`serialized`)
values
(0, 'yandex_beru', 'yandex_beru_3_auth_token', '550000019F7E2527', 0);
insert into oc_setting
(`store_id`,`code`,`key`,`value`,`serialized`)
values
(0, 'yandex_beru', 'yandex_beru_dbs_auth_token', 'BD0000018B82AA8F', 0);

INSERT INTO sr_sys_config
(code, value, annotation)
VALUES
("company_j_name", "ИП Федоров Алексей Анатольевич", "наименование организации"),
("company_j_inn", "771872248140", "ИНН организации"),
("company_j_address", "107241, г.Москва, Щелковское Шоссе д.29", "адрес организации"),
("company_shop_address", "107241, г.Москва, Щелковское Шоссе д.29", "точка самовывоза"),
("company_shop_name_short", "СЭР РИЧАРД РУ", "наименование интернет-магазина"),
("company_shop_name_long", "ИНТЕРНЕТ-КОМПАНИЯ СЭР РИЧАРД РУ", "наименование интернет-магазина"),
("order_no_current", "4285", "текущий номер заказа"),
("alarm_car_host", "192.168.1.68", "ip адрес хоста автомобильной сигнализации"),
("ozon_enabled", "false", "озон включен (да/нет)");

INSERT INTO sr_sys_total_amount
(id, annotation)
VALUES
(101, "рекламный бюджет за период"),
(102, "число сеансов за период"),
(107, "число уникальных посетителей за период"),
(111, "число новых посетителей за период"),
(103, "доход за период"),
(104, "прибыль за период"),
(105, "наложка за период"),
(106, "число реальных заказов за период"),
(108, "наложенный платеж СДЭК"),
(109, "наложенный платеж Почта России"),
(110, "постоплата организаций"),
(127, "конверсия в заказ"),
(128, "конверсия в заявку");

INSERT INTO sr_wiki_crm
(id, annotation)
VALUES
(1, "Админка сайта Opencart"),
(2, "Быстрй заказ"),
(3, "СДЭК");

INSERT INTO sr_wiki_crm_status
(id, annotation)
VALUES
(0, "Нет обработки"),
(1, "Успешно"),
(2, "Ошибка");

INSERT INTO sr_wiki_customer_type
(id, annotation)
VALUES
(1, "физическое лицо"),
(2, "юридическое лицо"),
(3, "индивидуальный предприниматель"),
(4, "нерезидент, физическое лицо"),
(5, "нерезидент, юридическое лицо"),
(6, "неопределен");

INSERT INTO sr_wiki_customer_status
(id, annotation)
VALUES
(1, "действует"),
(2, "удален"),
(3, "черный список");

INSERT INTO sr_wiki_address_type
(id, annotation)
VALUES
(1, "главный"),
(2, "дополнительный"),
(3, "пункт выдачи"),
(4, "терминал"),
(5, "самовывоз");

INSERT INTO sr_wiki_contact_type
(id, annotation)
VALUES
(1, "главный"),
(2, "дополнительный");

INSERT INTO sr_wiki_order_source
(id, annotation)
VALUES
(1, "звонок"),
(2, "чат"),
(3, "письмо"),
(4, "лид"),
(5, "быстрый заказ"),
(6, "обратный звонок"),
(8, "тендер");

INSERT INTO sr_wiki_order_advert
(id, annotation)
VALUES
(1, "реклама"),
(2, "поиск"),
(3, "youtube"),
(4, "сарафанное радио"),
(5, "повторное обращение"),
(6, "холодный звонок"),
(8, "тендер");

INSERT INTO sr_wiki_order_payment
(id, annotation)
VALUES
(1, "предоплата"),
(2, "постоплата"),
(5, "наличными курьеру"),
(6, "банковской картой"),
(7, "Apple Pay"),
(8, "Google Pay"),
(9, "в кредит");

INSERT INTO sr_wiki_order_payment_delivery
(id, annotation)
VALUES
(1, "оплачивает доставку покупатель"),
(2, "оплачивает доставку продавец");

INSERT INTO sr_wiki_order_type
(id, annotation)
VALUES
(1, "заказ"),
(2, "счет на оплату"),
(3, "коммерческое предложение"),
(4, "консультация"),
(11, "замена"),
(12, "возврат"),
(13, "подарок"),
(14, "тест-драйв"),
(15, "ремонт");

INSERT INTO sr_wiki_order_status
(id, annotation)
VALUES
(1, "заявка"),
(2, "подтвержден"),
(3, "ожидаем оплату"),
(4, "оплата получена"),
(5, "доставляется"),
-- (6, "на доставке у курьера"),
(7, "прибыл"),
(8, "завершен"),
(9, "отказ от вручения, возврат"),
(10, "получен"),
(11, "отсутствуют документы"),
(12, "заканчивается срок хранения"),
(13, "отменен"),
(15, "возврат получен"),
(16, "утерян"),
(21, "удален");

INSERT INTO sr_wiki_comment_type
(id, annotation)
VALUES
(1, "коментарий"),
(2, "конвертер");

INSERT INTO sr_wiki_order_delivery
(id, category, annotation)
VALUES
(101, "СДЭК", "СДЭК, ПВЗ"),
(102, "СДЭК", "СДЭК, ЭКОНОМ ПВЗ"),
(103, "СДЭК", "CDEK, курьер"),
(104, "СДЭК", "СДЭК, ЭКОНОМ курьер"),
(201, "Деловые Линии", "Деловые Линии"),
(301, "МОСКВА курьер 1-2 дня", "курьер, 1-2 дня"),
(302, "МОСКВА курьер, сегодня", "курьер, сегодня"),
(303, "МО курьер, 1-2 дня", "МО, курьер"),
(401, "ПОЧТА РОССИИ", "ПОЧТА, обычное"),
(402, "ПОЧТА РОССИИ", "ПОЧТА, 1-й класс"),
(405, "ПОЧТА EMS", "ПОЧТА, EMS"),
(403, "самовывоз, сегодня", "самовывоз"),
(501, "YANDEX MARKET", "до склада Яндекс-Маркет"),
(701, "OZON", "до склада OZON"),	
(601, "YANDEX GO", "Яндекс-Логистика"),
(801, "OZON Rocket", "OZON Rocket ПВЗ"),
(802, "OZON Rocket", "OZON Rocket постамат"),
(803, "OZON Rocket", "OZON Rocket курьер");

INSERT INTO sr_wiki_order_delivery_price
(id, delivery_id, annotation, price)
VALUES
(1, 301, NULL, 300),
(2, 302, NULL, 500),
(3, 303, "до 15 км от МКАД", 500),
(4, 303, "от 16 до 35 км от МКАД", 800),
(5, 303, "от 36 до 60 км от МКАД", 1300),
(6, 303, "от 61 км до 100 км от МКАД", 1900),
(7, 403, NULL, 0);

SET SQL_SAFE_UPDATES = 0;
DELETE FROM sr_wiki_category_product;

INSERT INTO sr_wiki_category_product
(id, type_group, annotation)
VALUES
(0, "прочие", "не определена"),

(101, "отпугиватели", "отпугиватели кротов"),
(102, "отпугиватели", "отпугиватели змей"),
(103, "отпугиватели", "отпугиватели птиц"),
(104, "отпугиватели", "отпугиватели грызунов"),
(105, "отпугиватели", "отпугиватели комаров"),
(107, "отпугиватели", "отпугиватели ос"),
(108, "отпугиватели", "отпугиватели собак"),
(109, "отпугиватели", "уничтожители насекомых"),
(110, "отпугиватели", "отпугиватели клещей"),

(201, "для дома", "gsm розетки и реле"),
(202, "для дома", "gsm сигнализации"),
(203, "для дома", "автономные извещатели"),
(204, "для дома", "видеоглазки и видеодомофоны"),
(205, "для дома", "видеонаблюдение"),
(206, "для дома", "ножеточки"),
(207, "для дома", "эконаборы"),
(208, "для дома", "светильники"),
(209, "для дома", "столики для ноутбука"),
(210, "для дома", "роботы для уборки"),
(211, "для дома", "средства защиты"),

(301, "для автомобиля", "алкотестеры"),
(302, "для автомобиля", "пуско-зарядные устройства"),
(303, "для автомобиля", "гибкие камеры"),
(304, "для автомобиля", "гаджеты"),

(401, "для дачи", "изотермика"),
(403, "для дачи", "мобильный душ"),
(404, "для дачи", "системы полива"),
(405, "для дачи", "термосы"),

(501, "для детей", "микроскопы USB"),
(502, "для детей", "домашние планетарии"),
(503, "для детей", "видеоняни"),
(504, "для детей", "конструкторы"),

(601, "безопасность", "антижучки"),
(602, "безопасность", "обнаружители видеокамер"),
(603, "безопасность", "подавители диктофонов"),
(604, "безопасность", "подавители сотовых телефонов"),

(701, "путешествия", "стельки с подогревом"),
(702, "путешествия", "возвращатели"),
(703, "путешествия", "мини электростанции"),

(801, "музыка", "наушники"),
(802, "музыка", "колонки"),

(901, "для домашних животных", "фурминатор для кошек"),
(902, "для домашних животных", "фурминатор для собак"),
(903, "для домашних животных", "автокормушки и автопоилки"),
(904, "для домашних животных", "электронные ошейники"),

(1111, "производство", "инкубаторы"),

(1101, "прочие", "элементы питания"),
(1102, "прочие", "инструменты"),
(1103, "прочие", "подарки"),
(1104, "прочие", "для рыбалки"),
(1105, "прочие", "для охоты"),
(1106, "прочие", "фонари");

INSERT INTO sr_wiki_stock
(id, annotation)
VALUES
(1, "основной"),
(2, "СИТИТЕК, Москва");

INSERT INTO sr_wiki_supplier
(id, annotation)
VALUES
(1, "СИТИТЕК"),
(2, "ЭКОСНАЙПЕР"),
(3, "ДАДЖЕТ"),
(4, "КЕМПИНГ 2000"),
(5, "ТЕХНОЛОГИИ ДЛЯ ЖИЗНИ"),
(6, "ЛАДЬЯ"),
(7, "ЭЛАНГ"),
(8, "ТЕЛЕМЕТРИКА"),
(9, "ЮСТ"),
(10, "МИГОВАТТ"),
(11, "СЛЕДОПЫТ"),
(12, "ПИРОХАУС"),
(14, "HOONT"),
(15, "CARKU"),
(16, "ТОРНАДО"),
(21, "СЛЕДОПЫТ ЯМ-РЫБАЛКА");

INSERT INTO sr_stock
(product_id, stock_id, supplier_id, supplier_price, quantity)
VALUES
(45, 1, 5, 4500, 0);

/*
INSERT INTO sr_wiki_stock_supplier
(id, stock_id, supplier_id)
VALUES
(101, 1, 1),
(102, 1, 1),
(103, 1, 1),
(104, 1, 1),
(105, 1, 1),
(106, 1, 1),
(107, 1, 1),
(108, 1, 1),
(109, 1, 1),
(110, 1, 1),
(111, 2, 1);
*/

/*
INSERT INTO sr_product_key
(product_id, product_key)
SELECT product_id, name FROM sr_v_product;
*/

INSERT INTO sr_address
(id, type, country_iso_code_2, address)
VALUES
(0, 5, 'RU', '');

SET SQL_SAFE_UPDATES = 0;

INSERT INTO sr_wiki_alarm_event_type
(id, annotation)
VALUES
(1, "gps location"),
(2, "ping"),
(3, "проникновение"),
(4, "temperature & humidity"),
(5, "постановка"),
(6, "снятие");

