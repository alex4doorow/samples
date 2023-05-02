CREATE
OR REPLACE FUNCTION print_all_clients() RETURNS TRIGGER AS $$ DECLARE rec RECORD;
BEGIN FOR rec IN
SELECT
  id,
  name,
  phone
FROM
  clients
ORDER BY
  name DESC LOOP RAISE NOTICE 'id = %, name = %, phone = %',
  rec.id,
  rec.name,
  rec.phone;
END LOOP;
RETURN NULL;
--объясним дальше
END$$ LANGUAGE 'plpgsql';

CREATE TRIGGER print_clients_trigger
AFTER
  INSERT ON clients EXECUTE PROCEDURE print_all_clients();

CREATE TABLE emp (
     empname text, -- имя сотрудника
     salary integer, -- зарплата
     last_date timestamp -- время последнего обновления записи
     );
CREATE FUNCTION emp_stamp() RETURNS trigger AS $emp_stamp$
      BEGIN
         -- Проверить, что указаны имя сотрудника и зарплата
         IF NEW.empname IS NULL THEN
             RAISE EXCEPTION 'empname cannot be null';
         END IF;
         IF NEW.salary IS NULL THEN
             RAISE EXCEPTION '% cannot have null salary', NEW.empname;
         END IF;

         -- Кто будет работать, если за это надо будет платить?
         IF NEW.salary < 0 THEN
             RAISE EXCEPTION '% cannot have a negative salary', NEW.empname;
         END IF;

         -- Запомнить, когда изменена запись
         NEW.last_date := current_timestamp;

         RETURN NEW;
      END;
$emp_stamp$ LANGUAGE plpgsql;

CREATE TRIGGER emp_stamp BEFORE INSERT
OR
UPDATE
  ON emp FOR EACH ROW EXECUTE PROCEDURE emp_stamp();

