-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 02, 2020 at 10:48 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `RecentlyVisited`
--

CREATE TABLE `RecentlyVisited` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `view` tinyint(1) NOT NULL,
  `remark` text NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `RecentlyVisited`
--

INSERT INTO `RecentlyVisited` (`id`, `name`, `view`, `remark`, `date`) VALUES
(1, 'Abhinay Shrestha', 0, 'For Admission', '2020-05-19'),
(2, 'Utsab Timsina', 0, 'For Admission', '2020-06-19'),
(3, 'test3', 1, 'test', '1996-05-05');

-- --------------------------------------------------------

--
-- Table structure for table `Reminder`
--

CREATE TABLE `Reminder` (
  `id` int(11) NOT NULL,
  `task` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Reminder`
--

INSERT INTO `Reminder` (`id`, `task`, `date`, `status`) VALUES
(1, 'task1', '2020-06-09', 'Important'),
(2, 'task2', '2020-06-01', 'Done');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `birthDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `name`, `birthDate`) VALUES
(1, 'ashish', '1996-06-03'),
(2, 'anish', '1997-06-03');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ClientInfo`
--
ALTER TABLE `ClientInfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `RecentlyVisited`
--
ALTER TABLE `RecentlyVisited`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Reminder`
--
ALTER TABLE `Reminder`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ClientInfo`
--
ALTER TABLE `ClientInfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `RecentlyVisited`
--
ALTER TABLE `RecentlyVisited`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Reminder`
--
ALTER TABLE `Reminder`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `test`
--
ALTER TABLE `test`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
