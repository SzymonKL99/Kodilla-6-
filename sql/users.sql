show DATABASES;
create DATABASE kodilla_course;
create user 'kodilla_user' identified with MYSQL_NATIVE_PASSWORD by 'kodilla_Pass123';
GRANT ALL PRIVILEGES ON kodilla_course.* to kodilla_user;

CREATE TABLE USERS
(
    ID SERIAL PRIMARY KEY,
    FIRSTNAME VARCHAR(100),
    LASTNAME VARCHAR(100)
);
SHOW TABLES;

CREATE TABLE POSTS
(
    ID SERIAL PRIMARY KEY,
    USER_ID BIGINT UNSIGNED NOT NULL,
    BODY VARCHAR(1024),
    FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);

SELECT * FROM USERS;

INSERT INTO USERS (FIRSTNAME, LASTNAME) VALUES ("John", "Smith");
COMMIT;
INSERT INTO POSTS (USER_ID, BODY)
VALUES (1, "This is my first post on this forum!");
COMMIT;

SELECT * FROM POSTS;

INSERT INTO POSTS (USER_ID, BODY)
VALUES (2, "This is my first post too!");

INSERT INTO USERS (FIRSTNAME, LASTNAME)
VALUES ("Zachary", "Lee");

INSERT INTO USERS (FIRSTNAME, LASTNAME)
VALUES ("Stephanie", "Kovalsky");

INSERT INTO USERS (FIRSTNAME, LASTNAME)
VALUES ("Thomas", "Landgren");

INSERT INTO USERS (FIRSTNAME, LASTNAME)
VALUES ("John", "Thomson");

INSERT INTO POSTS (USER_ID, BODY)
VALUES (2, "This is my first post too!");

INSERT INTO POSTS (USER_ID, BODY)
VALUES (2, "How are you?");

INSERT INTO POSTS (USER_ID, BODY)
VALUES (1, "Quite good, thanks bro!");

INSERT INTO POSTS (USER_ID, BODY)
VALUES (4, "Yo all! Here is Thomas!");
COMMIT;

SELECT * FROM USERS;
SELECT * FROM POSTS;

CREATE TABLE ISSUESLISTS (
                             ID SERIAL PRIMARY KEY,
                             NAME VARCHAR(250) NOT NULL
);

CREATE TABLE ISSUES (
                        ID SERIAL PRIMARY KEY,
                        ISSUESLIST_ID BIGINT UNSIGNED NOT NULL,
                        SUMMARY VARCHAR(255) NOT NULL,
                        DESCRIPTION TEXT,
                        USER_ID_ASSIGNEDTO BIGINT UNSIGNED NOT NULL,
                        FOREIGN KEY (ISSUESLIST_ID) REFERENCES ISSUESLISTS(ID),
                        FOREIGN KEY (USER_ID_ASSIGNEDTO) REFERENCES USERS(ID)
);

SELECT * FROM ISSUES;

INSERT INTO ISSUESLISTS (NAME)
VALUES ('ToDo'), ('In progress'), ('Done');

SELECT * FROM ISSUESLISTS;
COMMIT;

INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION, USER_ID_ASSIGNEDTO) VALUES
                                                                                 (1, 'Zadanie 1', 'Opis zadania 1', 1),
                                                                                 (1, 'Zadanie 2', 'Opis zadania 2', 2),
                                                                                 (1, 'Zadanie 3', 'Opis zadania 3', 1),
                                                                                 (1, 'Zadanie 4', 'Opis zadania 4', 3),
                                                                                 (1, 'Zadanie 5', 'Opis zadania 5', 2);

INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION, USER_ID_ASSIGNEDTO) VALUES
                                                                                 (2, 'Zadanie 6', 'Opis zadania 6', 3),
                                                                                 (2, 'Zadanie 7', 'Opis zadania 7', 2),
                                                                                 (2, 'Zadanie 8', 'Opis zadania 8', 1),
                                                                                 (2, 'Zadanie 9', 'Opis zadania 9', 3),
                                                                                 (2, 'Zadanie 10', 'Opis zadania 10', 1);


INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION, USER_ID_ASSIGNEDTO) VALUES
                                                                                 (3, 'Zadanie 11', 'Opis zadania 11', 1),
                                                                                 (3, 'Zadanie 12', 'Opis zadania 12', 2),
                                                                                 (3, 'Zadanie 13', 'Opis zadania 13', 3),
                                                                                 (3, 'Zadanie 14', 'Opis zadania 14', 2),
                                                                                 (3, 'Zadanie 15', 'Opis zadania 15', 1);

COMMIT;

SELECT * FROM ISSUES;
SELECT * FROM ISSUESLISTS;
SHOW DATABASES;

SELECT i.*, il.NAME AS ISSUESLIST_NAME
FROM ISSUES i
         JOIN ISSUESLISTS il ON i.ISSUESLIST_ID = il.ID;

SELECT i.*, u.FIRSTNAME, u.LASTNAME
FROM ISSUES i
         JOIN USERS u ON i.USER_ID_ASSIGNEDTO = u.ID;

SELECT u.FIRSTNAME, u.LASTNAME, COUNT(i.ID) AS NUM_ISSUES_ASSIGNED
FROM USERS u
         LEFT JOIN ISSUES i ON u.ID = i.USER_ID_ASSIGNEDTO
GROUP BY u.FIRSTNAME, u.LASTNAME;

UPDATE POSTS
SET USER_ID = 3
WHERE ID = 4;

COMMIT;

SELECT *FROM POSTS;

DELETE FROM POSTS
WHERE ID = 4;

COMMIT;

SELECT * FROM POSTS;

INSERT INTO POSTS (ID, USER_ID, BODY) VALUES
    (7,2,'Nice to meet you Thomas!');
SELECT * FROM POSTS;

UPDATE POSTS
SET BODY = 'Nice to meet you Thomas'
WHERE BODY = 'To delete';

UPDATE POSTS
SET BODY = 'TO DELETE'
WHERE ID = 7;

SELECT * FROM POSTS;

DELETE FROM POSTS
WHERE ID = 7;

SELECT *FROM POSTS;

SELECT U.FIRSTNAME, U.LASTNAME, I.SUMMARY
FROM USERS U
         JOIN ISSUES I ON U.ID = I.USER_ID_ASSIGNEDTO;

SELECT U.FIRSTNAME, U.LASTNAME, P.BODY
FROM USERS U
         JOIN POSTS P ON U.ID = P.USER_ID;

SELECT USER_ID, COUNT(*) AS POSTS_NUMBER
FROM POSTS
GROUP BY USER_ID;

SELECT u.FIRSTNAME, u.LASTNAME
FROM USERS u
         JOIN (
    SELECT USER_ID, COUNT(*) AS POST_COUNT
    FROM POSTS
    GROUP BY USER_ID
    HAVING POST_COUNT >= 2
) p ON u.ID = p.USER_ID;
COMMIT;




