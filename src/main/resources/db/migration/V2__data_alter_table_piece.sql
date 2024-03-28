ALTER TABLE Piece ADD COLUMN state TINYINT(1);

ALTER TABLE Piece MODIFY pieceId BIGINT AUTO_INCREMENT;

INSERT INTO Piece (pieceId,name, unitPrice, minimumStock, state) VALUES (1,'Pata redonda',375,5,1),(2,'Pata Cuadrada',250,10,1),(3,'Base Redonda',175,5,1);