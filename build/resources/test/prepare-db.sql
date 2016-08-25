use vote2016;

set FOREIGN_KEY_CHECKS = 0;
truncate table voters;
set FOREIGN_KEY_CHECKS = 1;

insert into voters (name, gender, race, age) values ('Andrew Mitzman', 'M', 'w', 12);
insert into voters (name, gender, race, age) values ('Billy Bob', 'M', 'b', 25);
insert into voters (name, gender, race, age) values ('Joey Sampson', 'M', 'a', 30);
insert into voters (name, gender, race, age) values ('Tina Rosen', 'F', 'l', 105);
insert into voters (name, gender, race, age) values ('Ella Douglas', 'F', 'w', 39);