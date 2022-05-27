insert into Role (name) values ('admin');
insert into Role (name) values ('user');
INSERT INTO User (name, password, email, IS_BANNED, IS_ADMIN) VALUES ('admin', 'admin', 'admin1@gmail.com', false, true);
INSERT INTO User (name, password, email, IS_BANNED, IS_ADMIN) VALUES ('user1', 'user1', 'user1@gmail.com', false, false);
INSERT INTO User (name, password, email, IS_BANNED, IS_ADMIN) VALUES ('user2', 'user2', 'user2@gmail.com', false, false);
INSERT INTO User (name, password, email, IS_BANNED, IS_ADMIN) VALUES ('user3', 'user3', 'user3@gmail.com', false, false);
INSERT INTO User (name, password, email, IS_BANNED, IS_ADMIN) VALUES ('user4', 'user4', 'user4@gmail.com', false, false);
INSERT INTO User (name, password, email, IS_BANNED, IS_ADMIN) VALUES ('user5', 'user5', 'user5@gmail.com', true, false);
