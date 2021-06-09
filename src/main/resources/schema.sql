CREATE TABLE IF NOT EXISTS STUDENTS
(
    student_id    INT PRIMARY KEY auto_increment,
    username  VARCHAR(20) NOT NULL,
    salt      VARCHAR(256) NOT NULL,
    password  VARCHAR(256) NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name  VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS NOTES
(
    note_id          INT PRIMARY KEY auto_increment,
    note_title       VARCHAR(20),
    note_description VARCHAR(1000),
    student_id          INT,
    foreign key (student_id) references STUDENTS (student_id)
);
--
-- CREATE TABLE IF NOT EXISTS FILES
-- (
--     fileId      INT PRIMARY KEY auto_increment,
--     filename    VARCHAR,
--     contenttype VARCHAR,
--     filesize    VARCHAR,
--     userid      INT,
--     filedata    BLOB,
--     foreign key (userid) references USERS (userid)
-- );
--
-- CREATE TABLE IF NOT EXISTS CREDENTIALS
-- (
--     credentialid INT PRIMARY KEY auto_increment,
--     url          VARCHAR(100),
--     username     VARCHAR(30),
--     key          VARCHAR,
--     password     VARCHAR,
--     userid       INT,
--     foreign key (userid) references USERS (userid)
-- );
