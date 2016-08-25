use vote2016;

set FOREIGN_KEY_CHECKS = 0;
truncate table voters;
truncate table candidates;
truncate table candidates_voters;
set FOREIGN_KEY_CHECKS = 1;

insert into voters (name, gender, race, age) values ('Andrew Mitzman', 'M', 'w', 12);
insert into voters (name, gender, race, age) values ('Billy Bob', 'M', 'b', 25);
insert into voters (name, gender, race, age) values ('Joey Sampson', 'M', 'a', 30);
insert into voters (name, gender, race, age) values ('Tina Rosen', 'F', 'l', 105);
insert into voters (name, gender, race, age) values ('Ella Douglas', 'F', 'w', 39);


insert into candidates (name, party, position) values ('Hollywood Hulk Hogan', 'R', 'President');
insert into candidates (name, party, position) values ('Bushwackers', 'D', 'President');
insert into candidates (name, party, position) values ('Macho Man Randy Savage', 'R', 'Senator');
insert into candidates (name, party, position) values ('Stone Cold Steve Austin', 'D', 'Senator');
insert into candidates (name, party, position) values ('Chyna', 'R', 'Governor');
insert into candidates (name, party, position) values ('Mr. Perfect', 'D', 'Governor');

INSERT INTO `vote2016`.`candidates_voters` (`candidate_id`, `voter_id`)
VALUES
  (1, 1),
  (3, 1),
  (5, 1),
  (1, 2),
  (4, 2),
  (6, 2),
  (2, 3),
  (3, 3),
  (5, 3),
  (1, 4),
  (3, 4),
  (5, 4),
  (1, 5),
  (4, 5),
  (6, 5);