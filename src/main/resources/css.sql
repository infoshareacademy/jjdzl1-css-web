-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 26 Lut 2019, 13:23
-- Wersja serwera: 10.1.36-MariaDB
-- Wersja PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `css`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `cars`
--

CREATE TABLE `cars` (
  `car_id` int(11) NOT NULL,
  `car_type` int(4) NOT NULL,
  `make` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `model` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `year` int(4) NOT NULL,
  `mileage` int(10) NOT NULL,
  `engine_power` float DEFAULT NULL,
  `fuel_source` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `transmission` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `body_type` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `color` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `seats` int(2) DEFAULT NULL,
  `capacity` int(15) DEFAULT NULL,
  `cargo_space` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `cars`
--

INSERT INTO `cars` (`car_id`, `car_type`, `make`, `model`, `year`, `mileage`, `engine_power`, `fuel_source`, `transmission`, `body_type`, `color`, `seats`, `capacity`, `cargo_space`) VALUES
(1, 1, 'BMW', 'M5', 2015, 65000, 350, 'PETROL', 'MANUAL', 'SEDAN', 'WHITE', 5, NULL, NULL),
(2, 1, 'Audi', 'R8', 2015, 35000, 435, 'PETROL', 'AUTOMATIC', 'COUPE', 'RED', 5, NULL, NULL),
(3, 1, 'BMW', 'E90', 2011, 65000, 220, 'DIESEL', 'MANUAL', 'SEDAN', 'WHITE', 5, NULL, NULL),
(4, 1, 'Audi', 'Q5', 2017, 60000, 240, 'DIESEL', 'AUTOMATIC', 'COUPE', 'SILVER', 5, NULL, NULL),
(5, 1, 'BMW', 'M3', 2015, 120000, 435, 'DIESEL', 'MANUAL', 'COUPE', 'BLACK', 4, NULL, NULL),
(6, 1, 'BMW', 'X3', 2016, 15000, 200, 'DIESEL', 'AUTOMATIC', 'SUV', 'SILVER', 7, NULL, NULL),
(7, 1, 'Opel', 'Astra', 2018, 15000, 75, 'PETROLANDGAS', 'MANUAL', 'SEDAN', 'RED', 5, NULL, NULL),
(8, 1, 'Opel', 'Meriva', 2014, 35000, 130, 'DIESEL', 'AUTOMATIC', 'SEDAN', 'BEIGE', 7, NULL, NULL),
(9, 1, 'Opel', 'Insignia', 2019, 5000, 180, 'DIESEL', 'AUTOMATIC', 'COUPE', 'BLACK', 5, NULL, NULL),
(10, 1, 'Toyota', 'C-HR', 2017, 25000, 170, 'DIESEL', 'AUTOMATIC', 'SUV', 'WHITE', 7, NULL, NULL),
(11, 1, 'Mercedes', 'ML350', 2016, 115000, 280, 'PETROL', 'AUTOMATIC', 'SUV', 'BLACK', 7, NULL, NULL),
(12, 1, 'Jeep', 'Cherokee', 2018, 15000, 180, 'DIESEL', 'AUTOMATIC', 'SUV', 'RED', 7, NULL, NULL),
(13, 1, 'Mitsubishi', 'L200', 2013, 76000, 235, 'DIESEL', 'AUTOMATIC', 'SUV', 'BLACK', 7, NULL, NULL),
(14, 1, 'Mercedes', 'GLK', 2009, 160000, 265, 'DIESEL', 'AUTOMATIC', 'SUV', 'BLACK', 7, NULL, NULL),
(15, 1, 'Porsche', 'Cayenne', 2016, 35000, 280, 'PETROL', 'AUTOMATIC', 'SUV', 'BLACK', 5, NULL, NULL),
(16, 2, 'Mercedes', 'Sprinter', 2016, 60000, 190, 'DIESEL', 'MANUAL', 'WAGON', 'WHITE', 3, 0, 0),
(17, 2, 'Mercedes', 'Sprinter', 2018, 35000, 180, 'DIESEL', 'MANUAL', 'WAGON', 'WHITE', 3, 0, 0),
(18, 2, 'Mercedes', 'Vito', 2013, 130000, 130, 'DIESEL', 'MANUAL', 'WAGON', 'WHITE', 3, 0, 0),
(19, 2, 'Iveco', 'Daily', 2015, 235000, 280, 'DIESEL', 'MANUAL', 'WAGON', 'WHITE', 3, 0, 0),
(20, 1, 'gdas', 'gds', 1990, 5351, 100, 'PETROLANDGAS', 'AUTOMATIC', 'SEDAN', 'RED', 6, NULL, NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `reservations`
--

CREATE TABLE `reservations` (
  `reservation_id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `car_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `reservations`
--

INSERT INTO `reservations` (`reservation_id`, `car_id`, `user_id`, `start_date`, `end_date`) VALUES
('1', 3, 1, '2018-10-10', '2018-10-15'),
('10', 16, 1, '2019-02-04', '2019-02-09'),
('11', 6, 1, '2019-01-20', '2019-03-10'),
('12', 7, 1, '2019-10-10', '2019-12-30'),
('13', 4, 2, '2018-10-10', '2018-11-01'),
('2', 9, 1, '2018-10-10', '2018-10-30'),
('3', 1, 1, '2018-10-10', '2018-10-20'),
('4', 11, 2, '2019-04-05', '2019-04-06'),
('5', 4, 1, '2018-10-10', '2018-10-30'),
('6', 5, 1, '2018-10-10', '2018-10-15'),
('7', 1, 1, '2018-10-10', '2018-10-15'),
('8', 8, 1, '2018-10-10', '2018-10-20'),
('9', 12, 2, '2018-12-01', '2018-12-01');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_type` int(1) NOT NULL,
  `login` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `birth_date` date DEFAULT NULL,
  `street_address` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `postal_code` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`user_id`, `user_type`, `login`, `password`, `email`, `phone_number`, `first_name`, `last_name`, `birth_date`, `street_address`, `postal_code`, `city`) VALUES
(1, 1, 'admin', '12345', 'admin@example.com', '601001001', 'Admin', 'Aplikacji', '1990-05-01', 'Chopina 10', '20-140', 'Lublin'),
(2, 0, 'marek', 'maro123', 'marek@example.com', '691029123', 'Marek', 'Kowalski', '1985-10-11', 'Koncertowa 4', '20-155', 'Lublin'),
(3, 0, 'Ewa', 'eww11.', 'ewa@example.com', '691029123', 'Ewa', 'Konieczna', '2004-07-23', 'Nadbystrzycka 48A', '20-123', 'Lublin'),
(4, 0, 'darek', '0000', 'darek_giza@op.pl', '772123124', 'Darek', 'Giza', '1981-01-15', 'Al. Królewska 41', '20-121', 'Lublin');

--
-- Struktura tabeli `users_authorization`
--

CREATE TABLE `users_authorization` (
                       `id_authorization` int(11) NOT NULL,
                       `user_id` int(11) NOT NULL,
                       `authorization_number` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
                       `is_account_active` boolean default false
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users_authorization` (`id_authorization`, `user_id`, `authorization_number`, `is_account_active`) VALUES
(1,1,null, default);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`car_id`) USING BTREE;

--
-- Indeksy dla tabeli `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `fk_users` (`user_id`),
  ADD KEY `fk_cars` (`car_id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indeksy dla tabeli `users_authorization`
--
ALTER TABLE `users_authorization`
  ADD PRIMARY KEY (`id_authorization`),
  ADD KEY `fk_users` (`user_id`);
--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `cars`
--
ALTER TABLE `cars`
  MODIFY `car_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users_authorization`
  MODIFY `id_authorization` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `fk_cars` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`),
  ADD CONSTRAINT `fk_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

--
-- Ograniczenia dla tabeli `users_authorization`
--
ALTER TABLE `users_authorization`
  ADD CONSTRAINT `fk_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
