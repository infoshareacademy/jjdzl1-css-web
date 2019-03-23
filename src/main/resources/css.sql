-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: asgard-mysql
-- Czas generowania: 23 Mar 2019, 16:17
-- Wersja serwera: 8.0.14
-- Wersja PHP: 7.2.14

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
  `car_id` int(100) NOT NULL,
  `car_type` int(4) NOT NULL,
  `make` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `model` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `year` int(4) NOT NULL,
  `mileage` int(10) NOT NULL,
  `engine_power` float DEFAULT NULL,
  `fuel_source` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `transmission` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `body_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `color` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `seats` int(2) DEFAULT NULL,
  `capacity` int(15) DEFAULT NULL,
  `cargo_space` int(15) DEFAULT NULL,
  `photo_link` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `cars`
--

INSERT INTO `cars` (`car_id`, `car_type`, `make`, `model`, `year`, `mileage`, `engine_power`, `fuel_source`, `transmission`, `body_type`, `color`, `seats`, `capacity`, `cargo_space`, `photo_link`) VALUES
(1, 1, 'BMW', 'M5', 2015, 65000, 350, 'PETROL', 'MANUAL', 'SEDAN', 'WHITE', 5, NULL, NULL, 'img/1.jpeg'),
(2, 1, 'Audi', 'R8', 2015, 35000, 435, 'PETROL', 'AUTOMATIC', 'COUPE', 'RED', 5, NULL, NULL, 'img/2.jpeg'),
(3, 1, 'BMW', 'E90', 2011, 65000, 220, 'DIESEL', 'MANUAL', 'SEDAN', 'WHITE', 5, NULL, NULL, 'img/3.jpeg'),
(4, 1, 'Audi', 'Q5', 2017, 60000, 240, 'DIESEL', 'AUTOMATIC', 'COUPE', 'SILVER', 5, NULL, NULL, 'img/4.jpeg'),
(5, 1, 'BMW', 'M3', 2015, 120000, 435, 'DIESEL', 'MANUAL', 'COUPE', 'BLACK', 4, NULL, NULL, 'img/5.jpeg'),
(6, 1, 'BMW', 'X3', 2016, 15000, 200, 'DIESEL', 'AUTOMATIC', 'SUV', 'SILVER', 7, NULL, NULL, 'img/6.jpeg'),
(7, 1, 'Opel', 'Astra', 2018, 15000, 75, 'PETROLANDGAS', 'MANUAL', 'SEDAN', 'RED', 5, NULL, NULL, 'img/7.jpeg'),
(8, 1, 'Opel', 'Meriva', 2014, 35000, 130, 'DIESEL', 'AUTOMATIC', 'SEDAN', 'BEIGE', 7, NULL, NULL, 'img/8.jpeg'),
(9, 1, 'Opel', 'Insignia', 2019, 5000, 180, 'DIESEL', 'AUTOMATIC', 'COUPE', 'BLACK', 5, NULL, NULL, 'img/9.jpeg'),
(10, 1, 'Toyota', 'C-HR', 2017, 25000, 170, 'DIESEL', 'AUTOMATIC', 'SUV', 'WHITE', 7, NULL, NULL, 'img/10.jpeg'),
(11, 1, 'Mercedes', 'ML350', 2016, 115000, 280, 'PETROL', 'AUTOMATIC', 'SUV', 'BLACK', 7, NULL, NULL, 'img/11.jpeg'),
(12, 1, 'Jeep', 'Cherokee', 2018, 15000, 180, 'DIESEL', 'AUTOMATIC', 'SUV', 'RED', 7, NULL, NULL, 'img/12.jpeg'),
(13, 1, 'Mitsubishi', 'L200', 2013, 76000, 235, 'DIESEL', 'AUTOMATIC', 'SUV', 'BLACK', 7, NULL, NULL, 'img/13.jpeg'),
(14, 1, 'Mercedes', 'GLK', 2009, 160000, 265, 'DIESEL', 'AUTOMATIC', 'SUV', 'BLACK', 7, NULL, NULL, 'img/14.jpeg'),
(15, 1, 'Porsche', 'Cayenne', 2016, 35000, 280, 'PETROL', 'AUTOMATIC', 'SUV', 'BLACK', 5, NULL, NULL, 'img/15.jpeg'),
(16, 2, 'Mercedes', 'Sprinter', 2016, 60000, 190, 'DIESEL', 'MANUAL', 'WAGON', 'WHITE', 3, 0, 0, 'img/16.jpeg'),
(17, 2, 'Mercedes', 'Sprinter', 2018, 35000, 180, 'DIESEL', 'MANUAL', 'WAGON', 'WHITE', 3, 0, 0, 'img/17.jpeg'),
(18, 2, 'Mercedes', 'Vito', 2013, 130000, 130, 'DIESEL', 'MANUAL', 'WAGON', 'WHITE', 3, 0, 0, 'img/18.jpeg'),
(19, 2, 'Iveco', 'Daily', 2015, 245000, 280, 'DIESEL', 'MANUAL', 'WAGON', 'WHITE', 3, 0, 0, 'img/19.jpeg');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `reservations`
--

CREATE TABLE `reservations` (
  `reservation_id` int(100) NOT NULL,
  `car_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `reservations`
--

INSERT INTO `reservations` (`reservation_id`, `car_id`, `user_id`, `start_date`, `end_date`) VALUES
(1, 1, 1, '2017-10-10', '2017-10-15'),
(2, 2, 1, '2020-01-01', '2020-01-02'),
(3, 3, 1, '2018-10-10', '2018-10-20'),
(4, 4, 4, '2018-10-10', '2018-10-11'),
(5, 5, 1, '2018-10-10', '2018-10-30'),
(6, 6, 1, '2018-10-10', '2018-10-15'),
(7, 7, 1, '2018-10-10', '2018-10-15'),
(8, 8, 1, '2018-10-10', '2018-10-20'),
(9, 9, 3, '2018-12-01', '2018-12-01'),
(10, 10, 1, '2019-02-04', '2019-02-09'),
(11, 11, 1, '2019-01-20', '2019-03-10'),
(12, 12, 1, '2019-10-10', '2019-12-30'),
(13, 13, 2, '2018-10-10', '2018-11-01'),
(16, 14, 1, '2019-02-28', '2019-03-01'),
(17, 15, 1, '2019-02-28', '2019-03-30'),
(23, 17, 1, '2019-02-28', '2019-03-02'),
(36, 1, 4, '2019-03-01', '2019-03-02'),
(58, 3, 3, '2019-03-30', '2019-03-31'),
(61, 11, 4, '2019-03-23', '2019-03-24');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `user_id` int(100) NOT NULL,
  `user_type` int(1) NOT NULL,
  `login` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `birth_date` date DEFAULT NULL,
  `street_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `postal_code` varchar(6) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`user_id`, `user_type`, `login`, `password`, `email`, `phone_number`, `first_name`, `last_name`, `birth_date`, `street_address`, `postal_code`, `city`) VALUES
(1, 1, 'admin', '12345', 'admin@example.com', '601001001', 'Admin', 'Aplikacji', '1990-05-01', 'Chopina 10', '20-140', 'Lublin'),
(2, 0, 'marek', 'maro123', 'marek@example.com', '691029123', 'Marek', 'Kowalski', '1985-10-11', 'Koncertowa 4', '20-155', 'Lublin'),
(3, 0, 'Ewa', 'eww11.', 'ewa@example.com', '691029123', 'Ewa', 'Konieczna', '2004-07-23', 'Nadbystrzycka 48A', '20-123', 'Lublin'),
(4, 0, 'darek', '0000', 'darek_giza@op.pl', '513083053', 'Dariusz', 'Giza', '1982-03-26', 'Al.Królewska 11', '24-100', 'Puławy'),
(5, 0, 'dario', '3333', '', '', '', '', NULL, NULL, NULL, NULL);

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
  ADD PRIMARY KEY (`reservation_id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `cars`
--
ALTER TABLE `cars`
  MODIFY `car_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `reservations`
--
ALTER TABLE `reservations`
  MODIFY `reservation_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
