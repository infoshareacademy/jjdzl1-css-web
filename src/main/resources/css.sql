-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: kamil-mysql
-- Czas generowania: 27 Mar 2019, 15:32
-- Wersja serwera: 8.0.13
-- Wersja PHP: 7.2.13

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
  `reservation_id` int(12) NOT NULL,
  `car_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `reservations`
--

INSERT INTO `reservations` (`reservation_id`, `car_id`, `user_id`, `start_date`, `end_date`) VALUES
(1, 3, 1, '2018-10-10', '2018-10-15'),
(2, 9, 1, '2018-10-10', '2018-10-30'),
(3, 1, 1, '2018-10-10', '2018-10-20'),
(4, 11, 2, '2019-04-05', '2019-04-06'),
(5, 4, 1, '2018-10-10', '2018-10-30'),
(6, 5, 1, '2018-10-10', '2018-10-15'),
(7, 2, 1, '2018-10-10', '2018-10-15'),
(8, 8, 1, '2018-10-10', '2018-10-20'),
(9, 12, 2, '2018-12-01', '2018-12-01'),
(10, 17, 1, '2019-02-04', '2019-02-09'),
(11, 6, 1, '2019-01-20', '2019-03-10'),
(12, 7, 1, '2019-10-10', '2019-12-30'),
(13, 4, 2, '2018-10-10', '2018-11-01'),
(15, 10, 4, '2019-03-24', '2019-03-25'),
(16, 16, 4, '2019-03-31', '2019-03-31'),
(17, 6, 4, '2019-03-30', '2019-03-31'),
(18, 13, 3, '2018-10-10', '2018-10-15'),
(19, 14, 3, '2018-10-10', '0201-10-11'),
(20, 15, 2, '2018-10-10', '2018-10-30'),
(21, 18, 2, '2018-11-01', '2018-12-01'),
(22, 19, 2, '2018-12-01', '2018-12-02');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
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
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `authorization_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `is_account_active` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`user_id`, `user_type`, `login`, `password`, `email`, `phone_number`, `first_name`, `last_name`, `birth_date`, `street_address`, `postal_code`, `city`, `authorization_number`, `is_account_active`) VALUES
(1, 1, 'admin', '$31$16$S2AdQ1Iotlgr3ozsDMR-3OY0Fyql8_uermIXQsG-eRM', 'admin@example.com', '601001003', 'Admin', 'Adminowski', '1990-05-18', 'Chopina 5', '20-150', 'Lublin', '', 1),
(2, 0, 'marek', '$31$16$uSIi1BcynFCxhSLZgNHmONddmL0FfTy0sZsGcTOnR4Q', 'marek@example.com', '691029123', 'Marek', 'Kowalski', '1985-10-11', 'Koncertowa 4', '20-155', 'Lublin', '', 1),
(3, 0, 'Ewa', '$31$16$PCyovEJEPnqCNvyHRyOzoKt-4Tma0pPJyQbl7JkjKt8', 'ewa@example.com', '691029123', 'Ewa', 'Konieczna', '2004-07-23', 'Nadbystrzycka 48A', '20-123', 'Lublin', '', 1),
(4, 0, 'darek', '$31$16$esmoxUes48YBzDF6YMmwonlz4T-ICNFGjFqHyweoWWY', 'darek_giza@op.pl', '772123124', 'Darek', 'Giza', '1981-01-15', 'Al. Królewska 41', '20-121', 'Lublin', '', 1),
(5, 0, 'lulek', '$31$16$D24IUZGD8y2oF6eR85YflS_HSmgT7A5r4xMRdQL0Ppg', 'lulek@gmail.com', '578510123', 'Marcin', 'Turlaj', '1995-03-05', 'Północna 11', '20-150', 'LU', '', 1),
(6, 0, 'Kamil', '$31$16$v0fxEwt8kXa_xJY_4suVp8HDvFE2JRpPY3KZfli_6qM', 'kamil@kamil.com', '123123123', 'asd', 'asd', '1996-03-26', '', '', '', 'be2d91e8-7739-4835-ae68-09eb53cda7d7', 0),
(12, 0, 'Mareczek', '$31$16$oZOmkKsVZiKLaE1S65Gy8BtSvEkJfwSzT-_rHIVVWIk', 'carsharingsystem.help@gmail.com', '123123123', '123', '123', '1993-03-26', '', '', '', '786f968c-a40b-46a2-bce8-f431d23935e8', 1);

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `cars`
--
ALTER TABLE `cars`
  MODIFY `car_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT dla tabeli `reservations`
--
ALTER TABLE `reservations`
  MODIFY `reservation_id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
