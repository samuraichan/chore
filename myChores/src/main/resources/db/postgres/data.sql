INSERT INTO category VALUES (1, 'Babysitting', current_date, NULL, 'Y', 0);
INSERT INTO category VALUES (2, 'Bathrooms', current_date, NULL, 'Y', 0);
INSERT INTO category VALUES (3, 'Folding', current_date, NULL, 'Y', 0);
INSERT INTO category VALUES (4, 'Vehicles', current_date, NULL, 'Y', 0);
INSERT INTO category VALUES (5, 'Yard', current_date, NULL, 'Y', 0);
INSERT INTO category VALUES (6, 'Other', current_date, NULL, 'Y', 0);

INSERT INTO STATUS VALUES (100, 'Draft');
INSERT INTO STATUS VALUES (101, 'Submitted');
INSERT INTO STATUS VALUES (102, 'Approved');
INSERT INTO STATUS VALUES (103, 'Paid');

INSERT INTO chore_entry VALUES(10000, 1, 101, '2017-02-01', '1.00', null, '2017-02-01', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10001, 5, 102, '2017-02-02', '1.75', null, '2017-02-02', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10002, 3, 101, '2017-02-02', '2.35', null, '2017-02-02', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10003, 3, 103, '2017-02-03', '2.35', null, '2017-02-03', null, 'Y', 0);

INSERT INTO chore_entry VALUES(10004, 1, 100, '2017-03-01', '1.10', null, '2017-03-01', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10005, 2, 100, '2017-03-02', '5.75', null, '2017-03-02', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10006, 3, 100, '2017-03-02', '1.00', null, '2017-03-02', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10007, 4, 100, '2017-03-03', '.50', null,  '2017-03-03', null, 'Y', 0);

INSERT INTO chore_entry VALUES(10008, 1, 100, '2017-04-01', '1.10', null, '2017-04-01', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10009, 2, 100, '2017-04-02', '5.75', null, '2017-04-02', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10010, 3, 101, '2017-04-02', '1.00', null, '2017-04-02', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10011, 4, 103, '2017-04-03', '.50', null,  '2017-04-03', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10012, 1, 102, '2017-04-03', '1.10', null, '2017-04-03', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10013, 2, 102, '2017-04-04', '5.75', null, '2017-04-04', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10014, 3, 101, '2017-04-04', '1.00', null, '2017-04-04', null, 'Y', 0);
INSERT INTO chore_entry VALUES(10015, 4, 102, '2017-04-04', '.50', null,  '2017-04-04', null, 'Y', 0);