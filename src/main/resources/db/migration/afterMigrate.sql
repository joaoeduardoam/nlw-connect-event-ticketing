-- Populando tabela de usuários (heróis)
INSERT INTO users (user_id, user_name, user_email) VALUES
(1, 'Superman', 'superman@justice.com'),
(2, 'Batman', 'batman@wayne.com'),
(3, 'Wonder Woman', 'diana@themyscira.com'),
(4, 'Spider-Man', 'peter@dailybugle.com'),
(5, 'Iron Man', 'tony@stark.com'),
(6, 'Black Widow', 'natasha@shield.com'),
(7, 'Thor', 'thor@asgard.com'),
(8, 'Captain America', 'steve@avengers.com'),
(9, 'Black Panther', 'tchalla@wakanda.com'),
(10, 'Doctor Strange', 'strange@sanctum.com'),
(11, 'Hulk', 'banner@science.com'),
(12, 'Flash', 'barry@speedforce.com'),
(13, 'Green Lantern', 'hal@corps.com'),
(14, 'Aquaman', 'arthur@atlantis.com'),
(15, 'Captain Marvel', 'carol@kree.com'),
(16, 'Ant-Man', 'scott@quantum.com'),
(17, 'Hawkeye', 'clint@shield.com'),
(18, 'Black Canary', 'dinah@birds.com'),
(19, 'Green Arrow', 'oliver@starling.com'),
(20, 'Scarlet Witch', 'wanda@vision.com'),
(21, 'Vision', 'vision@mind.com'),
(22, 'Falcon', 'sam@wings.com'),
(23, 'War Machine', 'rhodes@military.com'),
(24, 'Winter Soldier', 'bucky@hydra.com'),
(25, 'Star-Lord', 'quill@galaxy.com'),
(26, 'Gamora', 'gamora@zen.com'),
(27, 'Drax', 'drax@destroyer.com'),
(28, 'Rocket', 'rocket@raccoon.com'),
(29, 'Groot', 'groot@guardian.com'),
(30, 'Nova', 'rider@corps.com');

-- Populando tabela de eventos
INSERT INTO events (event_id, title, pretty_name, location, price, start_date, end_date, start_time, end_time) VALUES
(1, 'Justice League Summit 2025', 'justice-league-summit-2025', 'Watchtower', 500, '2025-04-15', '2025-04-17', '09:00:00', '18:00:00'),
(2, 'Avengers Training Camp', 'avengers-training-camp', 'Avengers Compound', 750, '2025-05-01', '2025-05-03', '08:00:00', '17:00:00'),
(3, 'Multiverse Defense Workshop', 'multiverse-defense', 'Sanctum Sanctorum', 1000, '2025-06-10', '2025-06-12', '10:00:00', '16:00:00'),
(4, 'Super Power Control Seminar', 'power-control-seminar', 'Xavier Institute', 300, '2025-07-01', '2025-07-03', '09:00:00', '15:00:00'),
(5, 'Villain Reform Conference', 'villain-reform-conf', 'Arkham Facility', 450, '2025-08-15', '2025-08-17', '10:00:00', '17:00:00'),
(6, 'Cosmic Defense Initiative', 'cosmic-defense', 'SHIELD Helicarrier', 800, '2025-09-01', '2025-09-03', '08:00:00', '18:00:00'),
(7, 'Technology & Magic Symposium', 'tech-magic-symposium', 'Stark Tower', 600, '2025-10-15', '2025-10-17', '09:00:00', '16:00:00'),
(8, 'Underwater Combat Training', 'underwater-combat', 'Atlantis', 550, '2025-11-01', '2025-11-03', '08:00:00', '15:00:00'),
(9, 'Space Travel Basics', 'space-travel-101', 'Guardians Ship', 900, '2025-12-01', '2025-12-03', '10:00:00', '17:00:00'),
(10, 'Secret Identity Management', 'identity-management', 'Batcave', 400, '2026-01-15', '2026-01-17', '09:00:00', '16:00:00');

-- Primeiros 5 usuários se inscrevendo sem indicação
INSERT INTO subscriptions (subscription_number, subscribed_user_id, indication_user_id, event_id, designation) VALUES
(1, 1, NULL, 2, NULL),
(2, 2, NULL, 1, NULL),
(3, 3, NULL, 3, NULL),
(4, 4, NULL, 2, NULL),
(5, 5, NULL, 1, NULL);

-- 25 inscrições com distribuição irregular de indicações
-- Tony Stark (5) e Batman (2) são os que mais indicam por serem mais influentes
-- Superman (1) e Spider-Man (4) fazem indicações ocasionais
-- Wonder Woman (3) faz poucas indicações
INSERT INTO subscriptions (subscription_number, subscribed_user_id, indication_user_id, event_id, designation) VALUES
-- Tony Stark (ID: 5) - 8 indicações
(6, 6, 5, 4, NULL),
(7, 7, 5, 5, NULL),
(8, 8, 5, 6, NULL),
(9, 9, 5, 6, NULL),
(10, 10, 5, 6, NULL),
(11, 11, 5, 6, NULL),
(12, 12, 5, 10, NULL),
(13, 13, 5, 1, NULL),

-- Batman (ID: 2) - 7 indicações
(14, 14, 2, 2, NULL),
(15, 15, 2, 3, NULL),
(16, 16, 2, 4, NULL),
(17, 17, 2, 5, NULL),
(18, 18, 2, 6, NULL),
(19, 19, 2, 7, NULL),
(20, 20, 2, 8, NULL),

-- Superman (ID: 1) - 5 indicações
(21, 21, 1, 9, NULL),
(22, 22, 1, 10, NULL),
(23, 23, 1, 1, NULL),
(24, 24, 1, 2, NULL),
(25, 25, 1, 6, NULL),

-- Spider-Man (ID: 4) - 3 indicações
(26, 26, 4, 6, NULL),
(27, 27, 4, 6, NULL),
(28, 28, 4, 6, NULL),

-- Wonder Woman (ID: 3) - 2 indicações
(29, 29, 3, 6, NULL),
(30, 30, 3, 6, NULL);