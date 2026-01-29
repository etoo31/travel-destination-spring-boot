INSERT INTO users (username, password, type) VALUES
('youssef', 'password123', 'admin'),
('ahmed', 'password123', 'user'),
('sara', 'password123', 'user');


INSERT INTO approved_destination
(country, capital, region, population, currency, flag)
VALUES
('Egypt', 'Cairo', 'Africa', 112000000, 'EGP', 'https://flags.com/egypt.png'),
('France', 'Paris', 'Europe', 67000000, 'EUR', 'https://flags.com/france.png'),
('Japan', 'Tokyo', 'Asia', 125000000, 'JPY', 'https://flags.com/japan.png');


INSERT INTO favorite_destinations
(user_id, country, capital, region, population, currency, flag)
VALUES
(1, 'Italy', 'Paris', 'Europe', 67000000, 'EUR', 'https://flags.com/france.png'),
(1, 'Portugal', 'Tokyo', 'Asia', 125000000, 'JPY', 'https://flags.com/japan.png'),
(2, 'KSA', 'Cairo', 'Africa', 112000000, 'EGP', 'https://flags.com/egypt.png');
