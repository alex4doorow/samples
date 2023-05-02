CREATE UNIQUE INDEX email_unique_key ON clients (
  lower(email)
);

CREATE INDEX products_index ON products(name)
WHERE
  price < 1000;

--Для того чтобы задать порядок, используется следующий синтаксис:
CREATE INDEX asc_index ON products (category NULLS FIRST);
CREATE INDEX asc_index ON products (category DESC NULLS LAST);