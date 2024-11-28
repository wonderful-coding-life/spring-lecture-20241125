-- for JdbcUserDetailsManager
INSERT INTO users(username, password, enabled) VALUES('user', '$2a$12$hYUqLSsCfWsFxQd9w8AUOeJvXx4ICsK/inDl5rcoN4/FUdNHE33.e', TRUE);
INSERT INTO users(username, password, enabled) VALUES('admin', '$2a$12$hYUqLSsCfWsFxQd9w8AUOeJvXx4ICsK/inDl5rcoN4/FUdNHE33.e', TRUE);
INSERT INTO users(username, password, enabled) VALUES('tony', '$2a$12$hYUqLSsCfWsFxQd9w8AUOeJvXx4ICsK/inDl5rcoN4/FUdNHE33.e', TRUE);
INSERT INTO authorities(username, authority) VALUES('tony', 'MANAGER');
INSERT INTO authorities(username, authority) VALUES('user', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES('admin', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES('admin', 'ROLE_ADMIN');

-- full custom
INSERT INTO member(name, email, password) VALUES('윤서준', 'SeojunYoon@hanbit.co.kr', '$2a$12$hYUqLSsCfWsFxQd9w8AUOeJvXx4ICsK/inDl5rcoN4/FUdNHE33.e');
INSERT INTO member(name, email, password) VALUES('윤광철', 'KwangcheolYoon@hanbit.co.kr', '$2a$12$hYUqLSsCfWsFxQd9w8AUOeJvXx4ICsK/inDl5rcoN4/FUdNHE33.e');
INSERT INTO member(name, email, password) VALUES('공미영', 'MiyeongKong@hanbit.co.kr', '$2a$12$hYUqLSsCfWsFxQd9w8AUOeJvXx4ICsK/inDl5rcoN4/FUdNHE33.e');
INSERT INTO member(name, email, password) VALUES('김도윤', 'DoyunKim@hanbit.co.kr', '$2a$12$hYUqLSsCfWsFxQd9w8AUOeJvXx4ICsK/inDl5rcoN4/FUdNHE33.e');
INSERT INTO authority(authority, member_id) VALUES('ROLE_USER', 1);
INSERT INTO authority(authority, member_id) VALUES('ROLE_USER', 2);
INSERT INTO authority(authority, member_id) VALUES('ROLE_ADMIN', 2);