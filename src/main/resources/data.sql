DROP TABLE IF EXISTS DT_USER_ROLE;

CREATE TABLE DT_USER_ROLE (
    NU_USER_CODE INT NOT NULL,
    NU_ROLE_CODE  INT NOT NULL,

 PRIMARY KEY (
    NU_USER_CODE,NU_ROLE_CODE
 )
);
INSERT INTO MST_ROLE (NU_ROLE_CODE, VC_ROLE_NAME) VALUES
  (1, 'ADMIN'),
  (2, 'USER');