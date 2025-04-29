-- 1. Получить все товары
SELECT *
FROM product;

-- 2. Получить всех пользователей
SELECT *
FROM users;

-- 3. Получить все заказы с именем покупателя и описанием товара
SELECT o.id, u.fio, p.description, o.order_date, o.count_of_orders
FROM orders o
         JOIN users u ON o.user_id = u.id
         JOIN product p ON o.product_id = p.id;

-- 4. Получить все заказы, сделанные после 5 апреля 2025 года
SELECT *
FROM orders
WHERE order_date > '2025-04-05';

-- 5. Обновить количество товара у товара с id = 1 (добавить 5 штук на склад)
UPDATE product
SET quantity = quantity + 5
WHERE id = 1;

-- 6. Изменить ФИО пользователя с id = 2
UPDATE users
SET fio = 'Петрова Наталья Сергеевна'
WHERE id = 2;

-- 7. Изменить количество товаров в заказе id = 3 на 10 штук
UPDATE orders
SET count_of_orders = 10
WHERE id = 3;

-- 8. Удалить заказ с id = 5
DELETE
FROM orders
WHERE id = 5;

-- 9. Удалить пользователя с id = 7
DELETE
FROM users
WHERE id = 7;

-- 10. Удалить товар с id = 9
DELETE
FROM product
WHERE id = 9;