-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 02, 2020 at 10:19 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `FrontDesk`
--

-- --------------------------------------------------------

--
-- Table structure for table `ClientInfo`
--

CREATE TABLE `ClientInfo` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `academic` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `height` float DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `maritalStatus` varchar(255) DEFAULT NULL,
  `createdAt` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ClientInfo`
--

INSERT INTO `ClientInfo` (`id`, `name`, `academic`, `status`, `email`, `phone`, `weight`, `address`, `age`, `date`, `remark`, `height`, `gender`, `maritalStatus`, `createdAt`) VALUES
(4, 'ashish', NULL, NULL, 'rock@gmail.com', '123456789', NULL, NULL, 24, NULL, NULL, NULL, NULL, NULL, '2020-07-02 08:12:18'),
(5, 'abhinay', NULL, NULL, 'ab@gmail.com', '123456789', NULL, NULL, 23, NULL, NULL, NULL, NULL, NULL, '2020-07-02 08:13:17'),
(6, 'test3', NULL, NULL, NULL, NULL, 0, NULL, 23, '1996-05-05', 'test', NULL, NULL, NULL, '2020-07-02 08:17:13');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ClientInfo`
--
ALTER TABLE `ClientInfo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ClientInfo`
--
ALTER TABLE `ClientInfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
