ALTER TABLE User ADD CONSTRAINT UQ_USERNAME UNIQUE (username);
ALTER TABLE User ADD CONSTRAINT UQ_EMAIL UNIQUE (email);

ALTER TABLE User MODIFY COLUMN status TINYINT(1) NOT NULL DEFAULT 1;

INSERT INTO User(role, name, email, username, password) values('ADMIN', 'admin', 'admin@email.com', 'admin', '$2a$10$jsOWNNxoZGt0/0qEXMLycuwotmKhnfEMDOGiyTPpFPZ6gIIFFD.Wu');
INSERT INTO User(role, name, email, username, password) values('FACTORY', 'factory', 'factory@email.com', 'factory', '$2a$10$jsOWNNxoZGt0/0qEXMLycuwotmKhnfEMDOGiyTPpFPZ6gIIFFD.Wu');
INSERT INTO User(role, name, email, username, password) values('SALES', 'sales', 'sales@email.com', 'sales', '$2a$10$jsOWNNxoZGt0/0qEXMLycuwotmKhnfEMDOGiyTPpFPZ6gIIFFD.Wu');