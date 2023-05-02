WITH avg_prices AS (
  SELECT
    category,
    AVG(price) AS avg_price
  FROM
    products
  GROUP BY
    category
)
SELECT
  MAX(avg_price)
FROM
  avg_prices;

WITH order_total AS (
  SELECT
    order_id,
    SUM(price * amount) AS order_price
  FROM
    positions
    JOIN PRODUCTS ON products.ID = positions.PRODUCT_ID
  GROUP BY
    POSITIONS.order_id
)
SELECT
  client_id,
  AVG(order_price) AS avg_order_price
FROM
  order_total
  JOIN orders ON orders.id = order_total.order_id
GROUP BY
  client_id
ORDER BY
  avg_order_price DESC;

--Просуммируем числа от 1 до 100:
WITH RECURSIVE t(n) AS (
  VALUES
    (1) --создаёт таблицу с единственным значением, которое равно 1
  UNION ALL
  SELECT
    n + 1
  FROM
    t
  WHERE
    n < 100 --рекурсивная часть
    )
SELECT
  sum(n)
FROM
  t;

-- Например, найдем все категории, в которых есть более трёх товаров:
select
  category,
  count(*)
from
  products
group by
  category
having
  count(*) > 3;

-- запрос, который возвращает названия всех товаров, которые были в самом последнем (по дате) заказе
select
  products.name
from
  orders
  join positions on orders.id = positions.order_id
  join products on positions.product_id = products.id
where
  orders.date = (
    select
      max(date)
    from
      orders
  );