-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 30 Paź 2022, 12:34
-- Wersja serwera: 10.4.25-MariaDB
-- Wersja PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `nbp`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `nbp`
--

CREATE TABLE `nbp` (
  `id` int(11) NOT NULL,
  `base_value` double NOT NULL,
  `convert_from` varchar(10) COLLATE utf8_polish_ci NOT NULL,
  `convert_to` varchar(10) COLLATE utf8_polish_ci NOT NULL,
  `converted_value` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `nbp`
--

INSERT INTO `nbp` (`id`, `base_value`, `convert_from`, `convert_to`, `converted_value`) VALUES
(22, 100, 'PLN', 'HRK', 159.56598053295036),
(23, 100, 'PLN', 'EUR', 21.186889552744763),
(24, 100, 'EUR', 'HRK', 753.1354715174724);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `nbp`
--
ALTER TABLE `nbp`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `nbp`
--
ALTER TABLE `nbp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
