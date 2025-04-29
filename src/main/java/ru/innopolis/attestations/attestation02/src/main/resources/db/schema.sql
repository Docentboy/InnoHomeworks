-- Создание таблицы товаров
CREATE TABLE IF NOT EXISTS product
(
    id          BIGSERIAL PRIMARY KEY,
    description TEXT,
    price       NUMERIC(10, 2) NOT NULL,
    quantity    INTEGER        NOT NULL
);
COMMENT ON TABLE product IS 'Таблица товаров.';

-- Создание таблицы пользователей
CREATE TABLE IF NOT EXISTS users
(
    id  BIGSERIAL PRIMARY KEY,
    fio VARCHAR
);
COMMENT ON TABLE users IS 'Таблица покупателей.';

-- Создание таблицы заказов
CREATE TABLE IF NOT EXISTS orders
(
    id              BIGSERIAL PRIMARY KEY,
    product_id      BIGINT REFERENCES product (id),
    user_id         BIGINT REFERENCES users (id),
    order_date      DATE,
    count_of_orders NUMERIC
);
COMMENT ON TABLE orders IS 'Таблица заказов.';