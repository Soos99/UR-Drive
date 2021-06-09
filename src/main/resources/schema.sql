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
    note_title       VARCHAR(256),
    note_description VARCHAR(1000),
    student_id          INT,
    foreign key (student_id) references STUDENTS (student_id)
);
CREATE TABLE IF NOT EXISTS FILES
(
    file_id      INT PRIMARY KEY auto_increment,
    file_name    VARCHAR(256),
    content_type VARCHAR(64),
    file_size    VARCHAR(64),
    student_id   INT,
    file_data    LONGBLOB,
    foreign key (student_id) references STUDENTS (student_id)
);

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
