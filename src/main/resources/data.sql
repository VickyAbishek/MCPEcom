INSERT INTO product (title, description) VALUES
('Laptop', 'High performance laptop'),
('Smartphone', 'Latest model smartphone'),
('Headphones', 'Noise cancelling headphones'),
('Keyboard', 'Mechanical keyboard'),
('Mouse', 'Wireless mouse'),
('Monitor', '4K monitor'),
('Printer', 'All-in-one printer'),
('Tablet', '10-inch tablet'),
('Camera', 'DSLR camera'),
('Speaker', 'Bluetooth speaker');

INSERT INTO "user" (username, email) VALUES
('alice', 'alice@example.com'),
('bob', 'bob@example.com'),
('carol', 'carol@example.com'),
('dave', 'dave@example.com'),
('eve', 'eve@example.com');

INSERT INTO "order" (user_id, product_id) VALUES
(1, 1), (1, 2), (2, 3), (2, 4), (3, 5),
(3, 6), (4, 7), (4, 8), (5, 9), (5, 10);