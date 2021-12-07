BEGIN TRANSACTION;

DROP TABLE IF EXISTS families_users;
DROP TABLE IF EXISTS reading_activity;
DROP TABLE IF EXISTS families_prizes;
DROP TABLE IF EXISTS reading_activity_bank;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS prizes;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS families;
DROP SEQUENCE IF EXISTS seq_family_id;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP SEQUENCE IF EXISTS seq_prize_id;
DROP SEQUENCE IF EXISTS seq_activity_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_prize_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_activity_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_family_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE families (
    family_id int DEFAULT nextval('seq_family_id'::regclass) NOT NULL,
    name varchar(50),
    CONSTRAINT PK_family_id       PRIMARY KEY (family_id)
);

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user            PRIMARY KEY (user_id)
);

CREATE TABLE families_users (
    family_id int,
    family_role boolean,
    user_id int,
    CONSTRAINT FK_FU_user_id      FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT FK_FU_family_id    FOREIGN KEY (family_id) REFERENCES families (family_id)
);

CREATE TABLE prizes (
    prize_id int DEFAULT nextval('seq_prize_id'::regclass) NOT NULL,
    name varchar(200),
    description varchar(600),
    time_requirement int,
    max_prizes int,
    start_date date,
    end_date date,
    CONSTRAINT PK_prize_id        PRIMARY KEY (prize_id)
);

CREATE TABLE families_prizes (
    prize_id int,
    family_id int,
    CONSTRAINT FK_FP_prize_id     FOREIGN KEY (prize_id) REFERENCES prizes (prize_id),
    CONSTRAINT FK_FP_family_id    FOREIGN KEY (family_id) REFERENCES families (family_id)
);

CREATE TABLE books (
    isbn varchar(16) NOT NULL,
    title varchar(100) NOT NULL,
    author varchar(100),
    CONSTRAINT PK_isbn            PRIMARY KEY (isbn)
);

CREATE TABLE reading_activity_log (
    activity_id int DEFAULT nextval('seq_activity_id'::regclass) NOT NULL,
    user_id int NOT NULL,
    isbn varchar(16) NOT NULL,
    format varchar(20) NOT NULL,
    time_read int DEFAULT 0,
    CONSTRAINT PK_activity_id     PRIMARY KEY (activity_id),
    CONSTRAINT FK_user_id         FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT FK_isbn            FOREIGN KEY (isbn) REFERENCES books (isbn)
);

/* this would normally just be attached to user */
CREATE TABLE reading_activity_bank (
    user_id int,
    minutes_read_bank int,
    CONSTRAINT FK_RAB_user_id     FOREIGN KEY (user_id) REFERENCES users (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
