-- create database Library_MGT_SW;
-- use Library_MGT_SW
-- create table Books (
--     SN varchar(50) primary key,
--     Title varchar(50) not null,
--     Author varchar(50) not null,
--     Publisher varchar(50) not null,
--     Price decimal(10 , 2 ) not null,
--     Quantity int not null,
--     IssuedQTY int not null default 0,
--     addedDate timestamp default current_timestamp
-- );

-- insert into Books (SN, Title, Author, Publisher, Price, Quantity, IssuedQTY, addedDate)
-- values ('B001', 'Snow White and the Seven Dwarfs', 'Walt Disney', 'Disney Press', 14.99, 10, 5, current_timestamp ),
--        ('B002', 'Winnie the Pooh', 'A.A. Milne', 'Dutton Books', 12.99, 8, 2, current_timestamp),
--        ('B003', 'Finding Nemo', 'Andrew Stanton', 'Disney Press', 15.99, 12, 0, current_timestamp),
--        ('B004', 'The Lion King', 'Irene Mecchi', 'Disney Press', 16.99, 9, 9, current_timestamp),
--        ('B005', 'Kung Fu Panda', 'Jonathan Aibel', 'DreamWorks Press', 14.99, 7, 1, current_timestamp),
--        ('B006', 'Tom and Jerry', 'William Hanna', 'Hanna-Barbera Press', 13.99, 11, 2, current_timestamp),
--        ('B007', 'Happy Feet', 'George Miller', 'Warner Bros Press', 17.99, 6, 3, current_timestamp),
--        ('B008', 'Pokémon', 'Satoshi Tajiri', 'VIZ Media', 10.99, 15, 0, current_timestamp),
--        ('B009', 'Dooly the Little Dinosaur', 'Kim Soo-jung', 'Korean Cartoon Press', 12.49, 8, 1, current_timestamp),
--        ('B010', 'Pororo the Little Penguin', 'Iconix Entertainment', 'Korean Cartoon Press', 10.99, 10, 10, current_timestamp);


-- create table Students (
--     StudentId int primary key,
--     Name varchar(50) not null,
--     Contact varchar(50) not null
-- );

-- insert into Students (StudentId, Name, Contact)
-- values (2295484, 'Amy', '3bearhug@gmail.com'),
--        (2295485, 'Tom', 'findjerry@gmail.com'),
--        (2295486, 'Jerry', 'run@gmail.com'),
--        (2295487, 'Nemo', 'dontfindme@gmail.com'),
--        (2295488, 'Lionking', 'babyking@gmail.com'),
--        (2295489, 'Pooh', 'weneedunderwear@gmail.com'),
--        (2295490, 'Dooly', 'greenboy@gmail.com'),
--        (2295491, 'Pororo', 'imthenumberone@gmail.com'),
--        (2295492, 'Elsa', 'letItCome@gmail.com'),
--        (2295493, 'Panda', 'imthecutest@gmail.com');

-- create table IssuedBooks (
--     id int primary key auto_increment,
--     sn varchar(50) not null,
--     stid int,
--     stname varchar(50) not null,
--     studentcontact varchar(100),
--     issuedate timestamp default current_timestamp,
--     foreign key (sn)
--         references books (sn),
--     foreign key (stid)
--         references students (studentid)
-- );

-- insert into IssuedBooks (SN, StId, stName, StudentContact, IssueDate)
-- values ('B001', 2295484, 'Amy', '3bearhug@gmail.com', current_timestamp),
--        ('B002', 2295485, 'Tom', 'findjerry@gmail.com', current_timestamp),
--        ('B003', 2295486, 'Jerry', 'run@gmail.com', current_timestamp),
--        ('B004', 2295487, 'nimo', 'dontfindme@gmail.com', current_timestamp),
--        ('B005', 2295488, 'lionking', 'babyking@gmail.com', current_timestamp),
--        ('B006', 2295489, 'pooh', 'weneedunderwear@gmail.com', current_timestamp),
--        ('B007', 2295490, 'dooly', 'greenboy@gmail.com', current_timestamp),
--        ('B008', 2295491, 'pororo', 'imthenumberone@gmail.com', current_timestamp),
--        ('B009', 2295492, 'elsa', 'winterisover@gmail.com', current_timestamp),
--        ('B010', 2295493, 'panda', 'imthecutest@gmail.com', current_timestamp);

-- select IssuedBooks.id, Books.Title, Books.Author, Students.Name, Students.Contact, IssuedBooks.IssueDate 
-- from IssuedBooks 
-- join Books on IssuedBooks.sn = Books.SN 
-- join Students on IssuedBooks.stid = Students.StudentId;

-- select IssuedBooks.id, Books.Title, IssuedBooks.IssueDate, Students.Name, Students.Contact 
-- from IssuedBooks 
-- join Books on IssuedBooks.sn = Books.SN 
-- join Students on IssuedBooks.stid = Students.StudentId;

-- select IssuedBooks.id, IssuedBooks.sn, Students.Name, Students.Contact, IssuedBooks.issuedate
-- from IssuedBooks
-- inner join Students
-- on IssuedBooks.StId = Students.StudentId;

-- select * from books;






