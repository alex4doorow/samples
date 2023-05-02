

BEGIN;
UPDATE 
  accounts 
SET 
  balance = balance - 100.00 
WHERE 
  name = 'Маша';
SAVEPOINT my_savepoint;
UPDATE 
  accounts 
SET 
  balance = balance + 100.00 
WHERE 
  name = 'Ваня';
-- ошибочное действие, откатить его и использовать счёт Лёши
ROLLBACK TO my_savepoint;
UPDATE 
  accounts 
SET 
  balance = balance + 100.00 
WHERE 
  name = 'Лёша';
COMMIT;

--Удалить точку сохранения можно следующим образом:
BEGIN;
INSERT INTO table1
VALUES
  (3);
SAVEPOINT my_savepoint;
INSERT INTO table1
VALUES
  (4);
RELEASE SAVEPOINT my_savepoint;
-- удаление точки сохранения COMMIT;