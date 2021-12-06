BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

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

CREATE SEQUENCE seq_project_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	family int,
	family_role boolean,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE prizes (
    prize_id int DEFAULT nextval('seq_prize_id'::regclass) NOT NULL,
    name varchar(200),
    description varchar(600),
    milestone int,
    max_prizes int,
    start_date date,
    end_date date,
    CONSTRAINT PK_prize_id PRIMARY KEY (prize_id)
);

CREATE TABLE books (
    isbn varchar(16) NOT NULL,
    title varchar(100) NOT NULL,
    author varchar(100),
    CONSTRAINT PK_isbn PRIMARY KEY (prize_id)
);

CREATE TABLE reading_projects (
    project_id int DEFAULT nextval('seq_project_id'::regclass) NOT NULL,
    user_id int NOT NULL,
    isbn varchar(16) NOT NULL,
    format varchar(20) NOT NULL,
    time_read int DEFAULT 0,
    prize_id int,
    CONSTRAINT PK_project_id PRIMARY KEY (project_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT FK_isbn FOREIGN KEY (isbn) REFERENCES books (isbn),
    CONSTRAINT FK_prize_id FOREIGN KEY (prize_id) REFERENCES prizes (prize_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
