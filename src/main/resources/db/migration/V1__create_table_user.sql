CREATE TABLE tb_user (
 user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
 username VARCHAR(255) NOT NULL UNIQUE ,
 password VARCHAR(255) NOT NULL,
 email VARCHAR(255) NOT NULL UNIQUE,
);
