create table customers (
	id serial primary key,
	customersID int,
	customersName varchar(50)
);

insert into customers (customersID, customersName) values (1254, 'Иванов Иван');
insert into customers (customersID, customersName) values (7544, 'Велесов Велес');
insert into customers (customersID, customersName) values (3524, 'Петров Петр');
insert into customers (customersID, customersName) values (1134, 'Валеров Варела');
insert into customers (customersID, customersName) values (2587, 'Иванов Иван');
select * from customers;

create table ordersV (
	id serial primary key,
	ordersID int,
	ordersName varchar (50),
	customer_ID integer references customers(id)
);

insert into ordersV (ordersID, ordersName, customer_ID) values (1111, 'Первый', 1);
insert into ordersV (ordersID, ordersName, customer_ID) values (1112, 'Второй', 1);
insert into ordersV (ordersID, ordersName, customer_ID) values (1113, 'Третий', 2);
insert into ordersV (ordersID, ordersName, customer_ID) values (1114, 'Четвертый', 2);
insert into ordersV (ordersID, ordersName, customer_ID) values (1115, 'Пятый', 2);
select * from ordersV;

select customers.customersName, ordersV.ordersID from customers
join ordersV
on customers.id = ordersV.customer_ID
order by customers.customersName;

create view show_customersName_with_ordersId
as select customers.customersName, ordersV.ordersID from customers
join ordersV
on customers.id = ordersV.customer_ID
order by customers.customersName;

select * from show_customersName_with_ordersId;