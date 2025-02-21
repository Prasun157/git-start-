
-- CREATE TABLE Customers (
--     customer_id INT AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(50),
--     email VARCHAR(50),
--     mobile VARCHAR(15)
-- );

-- CREATE TABLE Products (
--     id INT,
--     name VARCHAR(50) NOT NULL,
--     description VARCHAR(200),
--     price DECIMAL(10,2) NOT NULL,
--     category VARCHAR(50)
-- );

-- SHOW tables;

-- alter table customers modify column name varchar(50) not null, modify column email varchar(50) not null unique;

-- alter table customers add column age int;

-- alter table products change column id product_id int;

-- alter table products modify column product_id int auto_increment primary key;

-- alter table products modify column description text;

-- create table Orders (
-- order_id int auto_increment primary key,
-- customer_id int,
-- product_id int ,
-- quantity int not null,
-- order_date date not null,
-- stutus enum('Pending' , 'success' , 'cancel'),
-- payment_method enum('credit' , 'debit' , 'upi'),
-- total_amount decimal(10,2) not null,
-- foreign key (customer_id) references Customers(customer_id)
-- );

-- alter table  Orders rename to Orders;
-- alter table orders change column stutus status  enum('Pending' , 'success' , 'cancel') default 'Pending' ;

-- alter table Orders modify column payment_method enum('Credit', 'Debit', 'UPI', 'COD');

-- alter table Orders add constraint fk_product foreign key (product_id) references Products(product_id);

-- insert into Customers (name, email, mobile, age) values
-- ('Logan', 'logan@example.com', '1234567890', 65),
-- ('Kendall', 'kendall@example.com', '1234567891', 40),
-- ('Shiv', 'shiv@example.com', '1234567892', 38),
-- ('Roman', 'roman@example.com', '1234567893', 35),
-- ('Daenerys', 'daenerys@example.com', '1234567894', 30),
-- ('Jon', 'jon@example.com', '1234567895', 32),
-- ('Tyrion', 'tyrion@example.com', '1234567896', 42),
-- ('Arya', 'arya@example.com', '1234567897', 28),
-- ('Michael', 'michael@example.com', '1234567898', 45),
-- ('Dwight', 'dwight@example.com', '1234567899', 40),
-- ('Jim', 'jim@example.com', '1234567800', 38),
-- ('Pam', 'pam@example.com', '1234567801', 36),
-- ('Ross', 'ross@example.com', '1234567802', 38),
-- ('Rachel', 'rachel@example.com', '1234567803', 37),
-- ('Chandler', 'chandler@example.com', '1234567804', 39),
-- ('Monica', 'monica@example.com', '1234567805', 38),
-- ('Rick', 'rick@example.com', '1234567806', 70),
-- ('Morty', 'morty@example.com', '1234567807', 17),
-- ('Bugs', 'bugs@example.com', '1234567808', 80),
-- ('Daffy', 'daffy@example.com', '1234567809', 78);

-- insert into Products (name, price, category) values
-- ('T-Shirt', 200, 'Merch'),
-- ('Hoodie', 250, 'Merch'),
-- ('Cap', 155, 'Merch'),
-- ('Mug', 10, 'Merch'),
-- ('Sticker ', 5, 'Merch'),
-- ('Smartphone', 700, 'Electronics'),
-- ('Laptop', 1200, 'Electronics'),
-- ('Mouse', 60, 'Electronics'),
-- ('Keyboard', 100, 'Electronics'),
-- ('Earbuds', 150, 'Electronics'),
-- ('burger', 8, 'Food'),
-- ('pizza', 12, 'Food'),
-- ('pasta', 10, 'Food'),
-- ('Sushi ', 25, 'Food'),
-- ('chocolate', 15, 'Food'),
-- ('energy band', 3, 'fashion'),
-- ('Coffee', 20, 'Food'),
-- ('tea', 10, 'Food'),
-- ('shoes', 70, 'fashion'),
-- ('sneakers', 500, 'fashion');

-- insert into Orders (customer_id, product_id, quantity, order_date, status, payment_method, total_amount) values
-- (1, 1, 2, '2025-02-01', 'Success', 'Credit', 400),
-- (7, 12, 1, '2025-02-07', 'Cancel', 'UPI', 12),
-- (8, 7, 1, '2025-02-08', 'Success', 'Credit', 1200),
-- (12, 4, 1, '2025-02-12', 'Success', 'Credit', 10),
-- (15, 9, 2, '2025-02-15', 'Pending', 'COD', 200),
-- (3, 10, 1, '2025-02-03', 'Cancel', 'UPI', 150),
-- (4, 15, 3, '2025-02-04', 'Success', 'COD', 45),
-- (5, 2, 1, '2025-02-05', 'Pending', 'Credit', 50),
-- (7, 12, 1, '2025-02-07', 'Cancel', 'UPI', 12),
-- (8, 7, 1, '2025-02-08', 'Success', 'Credit', 1200),
-- (9, 3, 4, '2025-02-09', 'Pending', 'COD', 620),
-- (10, 19, 1, '2025-02-10', 'Success', 'Debit', 70),
-- (11, 8, 2, '2025-02-11', 'Pending', 'UPI', 120),
-- (12, 4, 1, '2025-02-12', 'Success', 'Credit', 10),
-- (15, 9, 2, '2025-02-15', 'Pending', 'COD', 200),
-- (16, 14, 1, '2025-02-16', 'Success', 'Credit', 15),
-- (17, 5, 5, '2025-02-17', 'Success', 'Debit', 25),
-- (20, 16, 1, '2025-02-20', 'Success', 'Credit', 3);






select category , count(*) as product_count from Products group by category;

-- Retrieve all products that belong to the 'Electronics' category, have a price between $50 and $500, and whose name contains the letter 'a'.
select * from Products where category ='Electronics' and  name like '%a%' and price>=50 and price<=500;

-- c.	Get the top 5 most expensive products in the 'Electronics' category, skipping the first 2.
select * from Products where category='Electronics' order by price desc limit 2,5;
-- d.	Retrieve customers who have not placed any orders.
select * from Customers 
left join Orders 
using(customer_id)
where product_id is null;


-- e.	Find the average total amount spent by each customer.
select c.name , ifnull(avg(o.total_amount),0) as average_amount_spent from Customers c left join  Orders o  using(customer_id)
group by c.name;


-- f.	Get the products that have a price less than the average price of all products
select * from Products where price<(select avg(price) from Products);


-- g.	Calculate the total quantity of products ordered by each customer:
select c.name , ifnull(sum(o.quantity),0) as total_quantity from Customers c 
left join Orders o 
using(customer_id)
group by c.customer_id;



-- h.	List all orders along with customer name and product name.
select c.name  Customer_name, p.name Product_name, o.* from Orders o 
inner join Customers c using(customer_id) 
inner join Products p using(product_id);




-- i.	Find products that have never been ordered.

select p.* from Products p 
left join Orders o 
using(product_id) 
where o.order_id is null





