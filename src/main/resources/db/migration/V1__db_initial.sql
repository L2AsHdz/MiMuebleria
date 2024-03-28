
CREATE TABLE IF NOT EXISTS User (
    userId BIGINT NOT NULL AUTO_INCREMENT,
    role ENUM('ADMIN', 'FACTORY', 'SALES') NOT NULL,
    name VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(500) NOT NULL,
    status TINYINT(1) NULL DEFAULT 1,
    PRIMARY KEY (userId)
);

CREATE TABLE IF NOT EXISTS Piece (
    pieceId BIGINT NOT NULL,
    name VARCHAR(60) NULL,
    unitPrice DOUBLE NOT NULL,
    minimumStock INT NOT NULL,
    PRIMARY KEY (pieceId)
);

CREATE TABLE IF NOT EXISTS Assembly (
    assemblyId BIGINT NOT NULL,
    name VARCHAR(60) NOT NULL,
    instructions VARCHAR(1000) NOT NULL,
    description VARCHAR(100) NOT NULL,
    PRIMARY KEY (assemblyId)
);

CREATE TABLE IF NOT EXISTS AssemblyDetail (
    assemblyDetailId BIGINT NOT NULL,
    assemblyId BIGINT NOT NULL,
    pieceId BIGINT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (assemblyDetailId),
    CONSTRAINT FK_AssemblyDetail_TO_Assembly
    FOREIGN KEY (assemblyId)
    REFERENCES Assembly (assemblyId)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    CONSTRAINT FK_AssemblyDetail_TO_Piece
    FOREIGN KEY (pieceId)
    REFERENCES Piece (pieceId)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

CREATE TABLE IF NOT EXISTS Client (
    nit VARCHAR(15) NOT NULL,
    name VARCHAR(45) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    PRIMARY KEY (nit)
);

CREATE TABLE IF NOT EXISTS Invoice (
    invoiceId BIGINT NOT NULL AUTO_INCREMENT,
    nit VARCHAR(15) NOT NULL,
    sellingUserId BIGINT NOT NULL,
    saleDate TIMESTAMP NOT NULL,
    PRIMARY KEY (invoiceId),
    CONSTRAINT fk_Invoice_to_User
    FOREIGN KEY (sellingUserId)
    REFERENCES User (userId)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    CONSTRAINT fk_Invoice_to_Client
    FOREIGN KEY (nit)
    REFERENCES Client (nit)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

CREATE TABLE IF NOT EXISTS Furniture (
    furnitureId BIGINT NOT NULL,
    assemblyId BIGINT NOT NULL,
    assemblyDate TIMESTAMP NOT NULL,
    sellingPrice DOUBLE NOT NULL,
    assemblyCost DOUBLE NOT NULL,
    status TINYINT(1) NULL DEFAULT 0,
    PRIMARY KEY (furnitureId),
    CONSTRAINT fk_Furniture_to_Assembly
    FOREIGN KEY (assemblyId)
    REFERENCES Assembly (assemblyId)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

CREATE TABLE IF NOT EXISTS InvoiceDetail (
    invoiceDetailId BIGINT NOT NULL,
    invoiceId BIGINT NOT NULL,
    furnitureId BIGINT NOT NULL,
    PRIMARY KEY (invoiceDetailId),
    CONSTRAINT fk_InvoiceDetail_to_Furniture
    FOREIGN KEY (furnitureId)
    REFERENCES Furniture (furnitureId)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    CONSTRAINT fk_InvoiceDetail_to_Invoice
    FOREIGN KEY (invoiceId)
    REFERENCES Invoice (invoiceId)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

CREATE TABLE IF NOT EXISTS Refund (
    refundId BIGINT NOT NULL,
    invoiceDetailId BIGINT NOT NULL,
    description VARCHAR(60) NOT NULL,
    refundDate DATE NOT NULL,
    userId BIGINT NOT NULL,
    loss DOUBLE NOT NULL,
    PRIMARY KEY (refundId),
    CONSTRAINT fk_Refund_to_InvoiceDetail
    FOREIGN KEY (invoiceDetailId)
    REFERENCES InvoiceDetail (invoiceDetailId)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    CONSTRAINT fk_Refund_to_User
    FOREIGN KEY (userId)
    REFERENCES User (userId)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

CREATE TABLE IF NOT EXISTS PieceInventory (
    pieceInventoryId BIGINT NOT NULL,
    pieceId BIGINT NOT NULL,
    cost DOUBLE NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (pieceInventoryId),
    CONSTRAINT fk_PieceInventory_to_Piece
    FOREIGN KEY (pieceId)
    REFERENCES Piece (pieceId)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

CREATE TABLE IF NOT EXISTS FurnitureDetail (
    furnitureDetailId BIGINT NOT NULL,
    furnitureId BIGINT NOT NULL,
    pieceId BIGINT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (furnitureDetailId),
    CONSTRAINT fk_FurnitureDetail_to_Furniture
    FOREIGN KEY (furnitureId)
    REFERENCES Furniture (furnitureId)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    CONSTRAINT fk_FurnitureDetail_to_Piece
    FOREIGN KEY (pieceId)
    REFERENCES Piece (pieceId)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);