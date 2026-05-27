--Parte 1
--Tabla vuelos
CREATE TABLE vuelos (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL UNIQUE,
    precio_boleto NUMERIC(10,2) NOT NULL CHECK (precio_boleto >= 0),
    asientos_disponibles INTEGER NOT NULL CHECK (asientos_disponibles >= 0)
);

--Inserts generados con IA
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles) VALUES
('AA-101', 150.00, 20),
('LA-234', 320.50, 8),
('UA-876', 280.00, 3),
('DL-452', 199.99, 12),
('AA-555', 450.00, 0),
('LA-777', 380.00, 6),
('IB-890', 220.00, 15),
('QR-102', 900.00, 4),
('AF-409', 670.00, 30),
('KL-332', 500.00, 2),
('TK-600', 750.00, 9),
('EK-777', 1200.00, 11),
('CM-045', 210.00, 7),
('AV-903', 180.00, 1),
('AR-112', 350.00, 25),
('BA-560', 700.00, 13),
('LH-333', 640.00, 5),
('AZ-445', 295.00, 0),
('AC-201', 430.00, 10),
('VS-909', 800.00, 3);