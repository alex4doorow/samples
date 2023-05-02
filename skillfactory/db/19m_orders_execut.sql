DO $$ DECLARE i INTEGER;
--объявление переменной
BEGIN FOR i IN 1..10 --начало цикла
LOOP EXECUTE (
  'create table temp_table_' || i || '(x int);'
);
END LOOP;
--конец цикла
END $$;

--Как видите, вы можете использовать не только циклы, но и условные операторы. Обратите внимание, что вложенные блоки
--обязательно закрываются с помощью инструкции END, которая заканчивает блоки для вложенного цикла и выражения IF.
--Кроме этого, мы используем уже несколько переменных, для того чтобы получить результат.
DO $$
DECLARE
         i INTEGER;
         j INTEGER;
         q TEXT;
BEGIN
         FOR i IN 1..120 LOOP
                 q = 'create table temp_table_' || i || '(';
                 FOR j IN 1..20 LOOP
                         IF j <> 1 THEN
                                 q = q || ',';
                         END IF;
                         q = q || 'attr_' || j || ' int';
                 END LOOP;
                 q = q || ');';
                 EXECUTE q;
         END LOOP;
END $$;