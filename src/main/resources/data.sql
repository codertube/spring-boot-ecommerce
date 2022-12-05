DELETE from product;
DELETE from category;

ALTER SEQUENCE category_id_seq RESTART WITH 1;
ALTER SEQUENCE product_id_seq RESTART WITH 1;

INSERT INTO category(category_type)
VALUES ('Bakes');
INSERT INTO category(category_type)
VALUES ('Used-Items');

INSERT INTO product(name, price, quantity, units_in_stock, category_id, image_url)
VALUES ('Brownie', 00.65, 48, 48, 1,'assets/images/Brownie.jpg');
INSERT INTO product(name, price, quantity, units_in_stock, category_id, image_url)
VALUES ('Muffin', 1.00, 36, 36, 1,'assets/images/Muffin.jpg');
INSERT INTO product(name, price, quantity, units_in_stock, category_id, image_url)
VALUES ('Cake Pop', 1.35, 24, 24, 1,'assets/images/Cake_pops.jpg');
INSERT INTO product(name, price, quantity, units_in_stock, category_id, image_url)
VALUES ('Apple tart', 1.50, 60, 60, 1,'assets/images/Apple_tart.jpg');
INSERT INTO product(name, price, quantity, units_in_stock, category_id, image_url)
VALUES ('Water', 1.50, 30, 30, 1,'assets/images/Water.jpg');

INSERT INTO product(name, price, quantity, units_in_stock, category_id, image_url)
VALUES ('Shirt', 2.00, 25, 25, 2,'assets/images/Shirt.jpg');
INSERT INTO product(name, price, quantity, units_in_stock, category_id, image_url)
VALUES ('Pants', 3.00, 15, 15, 2,'assets/images/Pants.jpg');
INSERT INTO product(name, price, quantity, units_in_stock, category_id, image_url)
VALUES ('Jacket', 4.00, 16, 16, 2,'assets/images/Jacket.jpg');
INSERT INTO product(name, price, quantity, units_in_stock, category_id, image_url)
VALUES ('Toy', 1.00, 10, 10, 2,'assets/images/Toy.jpg');