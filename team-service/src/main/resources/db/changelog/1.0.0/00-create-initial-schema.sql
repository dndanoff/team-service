CREATE TABLE MEMBER(
  ID BIGINT AUTO_INCREMENT,
  EMAIL VARCHAR(100) UNIQUE NOT NULL,
  FIRST_NAME VARCHAR(100) NOT NULL,
  LAST_NAME VARCHAR(100) NOT NULL,
  PHOTO_URL VARCHAR(1000),
  HIRE_DATE DATE NOT NULL,
  TEAM_ID BIGINT,
  PHONE_NUMBER VARCHAR,
  SKYPE VARCHAR,
  CONSTRAINT MEMBER_PK PRIMARY KEY (ID)
);

CREATE TABLE TEAM(
  ID BIGINT AUTO_INCREMENT,
  NAME VARCHAR(100) UNIQUE NOT NULL,
  PROJECT_NAME VARCHAR(100) NOT NULL,
  ESTABLISHED_DATE DATE NOT NULL,
  ROOM VARCHAR NOT NULL,
  TECHNOLOGIES VARCHAR,
  CONSTRAINT TEAM_PK PRIMARY KEY (ID)
);

ALTER TABLE MEMBER
ADD FOREIGN KEY (TEAM_ID) REFERENCES TEAM(ID); 