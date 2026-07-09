-- Inserindo categorias
INSERT INTO categories (id, name) VALUES (1, 'Electronics');
INSERT INTO categories (id, name) VALUES (2, 'Books');

-- Inserindo produtos e vinculando com as categorias pelo ID (category_id)
INSERT INTO products (id, name, price, category_id) VALUES (1, 'TV', 2200.00, 1);
INSERT INTO products (id, name, price, category_id) VALUES (2, 'Domain Driven Design', 120.00, 2);
INSERT INTO products (id, name, price, category_id) VALUES (3, 'PS5', 2800.00, 1);
INSERT INTO products (id, name, price, category_id) VALUES (4, 'Docker', 100.00, 2);