-- 7
CREATE DATABASE FriendsOfHuman1;
USE FriendsOfHuman1;

-- 8
CREATE TABLE Animals (
    id INT PRIMARY KEY AUTO_INCREMENT,
    animal_class VARCHAR(255)
   );

CREATE TABLE Pets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    animal_id INT,
    name VARCHAR(255),
    command VARCHAR(255),
    birth_date DATE,
    FOREIGN KEY (animal_id)
        REFERENCES Animals (id)
);


CREATE TABLE PackAnimals (
    id INT PRIMARY KEY AUTO_INCREMENT,
    animal_id INT,
    name VARCHAR(255),
    command VARCHAR(255),
    birth_date DATE,
    FOREIGN KEY (animal_id)
        REFERENCES Animals (id)
);

-- 9
INSERT INTO Animals (animal_class)
   VALUES ('Pets'), ('PackAnimals');

INSERT INTO Pets (animal_id, name, command, birth_date)
   VALUES (1, 'Хомяк1', 'Крутиться в колесе', '2021-07-01'),
          (1, 'Собака1', 'Сидеть', '2021-05-10'),
          (1, 'Кошка1', 'Ловить мышей', '2022-12-15');

INSERT INTO PackAnimals (animal_id, name, command, birth_date)
   VALUES (2, 'Лошадь1', 'Тащить телегу', '2023-03-20'),
          (2, 'Верблюд1', 'Переносить грузы', '2022-02-10'),
          (2, 'Осел1', 'Нести грузы', '2016-06-25');

-- 10
DELETE FROM PackAnimals WHERE name LIKE 'Верблюд%';

CREATE TABLE HorsesAndDonkeys AS
   SELECT * FROM PackAnimals;
   
-- 11
 CREATE TABLE YoungAnimals AS SELECT *,
CONCAT(TIMESTAMPDIFF(YEAR, birth_date, NOW()), ' года и ', 
       TIMESTAMPDIFF(MONTH, birth_date, NOW()) % 12, ' месяцев') as age
FROM(
  SELECT * FROM Pets
  UNION ALL
  SELECT * FROM PackAnimals
) AS T
WHERE TIMESTAMPDIFF(YEAR, birth_date, NOW()) > 1 AND TIMESTAMPDIFF(YEAR, birth_date, NOW()) < 3;
   

-- 12
CREATE TABLE AllAnimals AS
SELECT 'Pets' AS animal_type, id, name, command, birth_date
FROM Pets
UNION ALL
SELECT 'PackAnimals' AS animal_type, id, name, command, birth_date
FROM PackAnimals;

SELECT * FROM AllAnimals;