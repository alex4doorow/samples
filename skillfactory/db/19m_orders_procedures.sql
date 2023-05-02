CREATE
OR REPLACE PROCEDURE create_table(name TEXT) AS $$ BEGIN EXECUTE (
  'create table ' || name || '(str varchar(100));'
);
END $$ LANGUAGE 'plpgsql';

DO $$ BEGIN CALL create_table('tmp_table' :: TEXT);
END $$;

CREATE OR REPLACE FUNCTION gen_abra_cadabra(len INT)
RETURNS TEXT AS
$$ DECLARE
res TEXT := 'abra cadabra ';
     BEGIN
     WHILE LENGTH(res) <= len
         LOOP
         res := res || res;
         END LOOP;
     RETURN SUBSTRING(res, 1, len);
END $$ LANGUAGE 'plpgsql';

DO $$ BEGIN PERFORM gen_abra_cadabra(100);
END $$;

DO $$ BEGIN RAISE NOTICE 'str = %',
gen_abra_cadabra(100);
END $$;

--Есть ещё один способ вызвать функцию и присвоить результат её работы переменной:
CREATE
OR REPLACE PROCEDURE just_print() AS $$ DECLARE txt TEXT;
BEGIN
SELECT
  gen_abra_cadabra(35) INTO txt;
RAISE NOTICE 'txt = %',
txt;
END $$ LANGUAGE 'plpgsql';

--В примере вызывается функция, и результат её работы помещается в переменную txt. С помощью этой инструкции вы можете
--помещать и запрашивать данные из таблицы. Например, если запрос возвращает единственное значение, то результат вы
--можете поместить в переменную:
CREATE
OR REPLACE PROCEDURE get_Kuropatkin_phone() AS $$ DECLARE txt TEXT;
BEGIN
SELECT
  phone
FROM
  clients
WHERE
  name = 'Куропаткин В В' INTO txt;
RAISE NOTICE 'txt = %',
txt;
END $$ LANGUAGE 'plpgsql';

--набор данных
DO $$ DECLARE rec RECORD;
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
  record.phone;
END LOOP;
END $$;