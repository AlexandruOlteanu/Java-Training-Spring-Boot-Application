DROP TABLE IF EXISTS OrderDetails;
DROP TABLE IF EXISTS Payments;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Products;

CREATE TABLE IF NOT EXISTS Customers(
    id INT AUTO_INCREMENT NOT NULL,
    username VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    postalCode VARCHAR(50),
    country VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Users(
	 id INT AUTO_INCREMENT NOT NULL,
     username VARCHAR(255) NOT NULL,
     password VARCHAR(255) NOT NULL,
     customer INT NOT NULL,
	
     PRIMARY KEY(id),
	 FOREIGN KEY(customer) REFERENCES Customers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Orders(
    id INT AUTO_INCREMENT NOT NULL,
    order_date DATE NOT NULL,
    shipped_date DATE,
    status VARCHAR(15) NOT NULL,
    comments TEXT,
    customer_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(customer_id) REFERENCES Customers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Products(
	code VARCHAR(15) NOT NULL,
    name VARCHAR(70) NOT NULL,
    description TEXT NOT NULL,
    stock SMALLINT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(code)
);

CREATE TABLE IF NOT EXISTS Payments(
	id INT AUTO_INCREMENT NOT NULL,
	customer_id INT NOT NULL,
    payment_date DATE NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(customer_id) REFERENCES Customers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS OrderDetails(
	id INT NOT NULL,
    product_code VARCHAR(15) NOT NULL,
    quantity INT NOT NULL,
    priceEach DECIMAL(10,2) NOT NULL,
    FOREIGN KEY(id) REFERENCES Orders(id) ON DELETE CASCADE,
    FOREIGN KEY(product_code) REFERENCES Products(code) ON DELETE CASCADE
);

INSERT INTO Customers VALUES
 ( 1, 'username1', 'Voican', 'Vlad', '0745285423', 'Strada x', 'Oras1', '115200','Romania'),
 ( 2, 'username2', 'Voic', 'Vl', '0746582323', 'Strada y', 'Oras2', '445200','Romania'),
 ( 3, 'username3', 'Moraru', 'Andrei', '0736282523', 'Strada z', 'Oras3', '115200','Romania');

INSERT INTO Products VALUES
('32','Milk', 'Description1',35,2.50),
('12','Meat', 'Description2',15,7.50),
('45','Pizza', 'Description3',8,10),
('7','Water', 'Description4',90,1.25);

INSERT INTO Orders VALUES
(1,'2022-03-14','2022-03-15','Shipped',null,3),
(2,'2022-03-14','2022-03-17','Shipped','Comment2',1),
(3,'2022-03-15','2022-03-15','Shipped','Comment3',2);

INSERT INTO Payments VALUES
(1,1,'2022-03-17',5.50),
(2,2,'2022-03-15',6.50),
(3,3,'2022-03-15',3.50);

INSERT INTO Users VALUES 
(1, "TestUser", "test", 1);

UPDATE Orders
SET status="available"
WHERE id=2;

UPDATE Orders
SET comments='Comment1'
WHERE id=1;


SELECT * FROM Orders;

SELECT * FROM customers;

SELECT c.username, o.id, o.status FROM customers c JOIN orders o ON c.id= o.customer_id WHERE c.id=3;

INSERT INTO Orders VALUES
(4,'2022-05-14','2022-05-15','Delivered',null,2);

INSERT INTO OrderDetails VALUES (1, '32', 3, 34.5);

UPDATE Products p
JOIN orderdetails o on o.product_code = p.code 
SET p.stock = p.stock - o.quantity; 

SELECT * FROM products;

SELECT * FROM Customers;


