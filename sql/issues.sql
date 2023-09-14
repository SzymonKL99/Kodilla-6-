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

SELECT ID, LASTNAME FROM USERS;
SELECT ID, FIRSTNAME FROM USERS
WHERE (ID >= 4 AND ID <= 10)
OR ID = 1;
SELECT COUNT(*) FROM users;
SELECT MIN(ID), MAX(ID) FROM users;
SELECT SUM(ID) AS TOTAL, AVG(ID) AS AVERAGE FROM USERS;
SELECT U.FIRSTNAME, U.LASTNAME, P.BODY
FROM USERS U
         JOIN POSTS P ON U.ID = P.USER_ID;
SELECT USER_ID, COUNT(*) AS POSTS_NUMBER
FROM POSTS
GROUP BY USER_ID
HAVING COUNT(*) > 1;
SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER
FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID
GROUP BY P.USER_ID
HAVING COUNT(*) > 1
ORDER BY U.LASTNAME, U.FIRSTNAME;


