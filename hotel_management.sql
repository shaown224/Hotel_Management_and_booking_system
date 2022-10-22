-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 27, 2021 at 09:27 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `room` int(11) NOT NULL,
  `deposit` int(11) NOT NULL,
  `days` date NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`name`, `email`, `room`, `deposit`, `days`, `status`) VALUES
('a', 'a@gmail.com', 101, 100, '0000-00-00', 'accept'),
('Alam', 'a@gmail.com', 101, 100, '2021-09-24', 'accept'),
('K', 'k@gmail.com', 101, 100, '2021-09-26', 'accept');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` set('Passport','National Id','Driving license') NOT NULL,
  `number` int(14) NOT NULL,
  `name` varchar(45) NOT NULL,
  `gender` set('Male','Female') NOT NULL,
  `country` varchar(45) NOT NULL,
  `room_number` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  `deposit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `department` varchar(45) NOT NULL,
  `budget` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`department`, `budget`) VALUES
('Receptionist', 120000);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `name` varchar(100) NOT NULL,
  `age` int(30) NOT NULL,
  `gender` set('Male','Female') NOT NULL,
  `job` varchar(100) NOT NULL,
  `salary` int(30) NOT NULL,
  `phone` text NOT NULL,
  `email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`name`, `age`, `gender`, `job`, `salary`, `phone`, `email`) VALUES
('Alam', 18, 'Male', 'Chef', 18000, '01680032074', 'm@gmail.com'),
('Rishad', 22, 'Male', 'Manager', 50000, '01680032074', 'rishad@gmail.com'),
('Zayed', 22, 'Male', 'Manager', 50000, '01234567890', 'Zayed@gmail.com'),
('Sayem', 22, 'Male', 'Accountant', 30000, '01680032074', 'sayem@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `room_number` int(11) NOT NULL,
  `availability` varchar(45) NOT NULL,
  `clean_status` set('Clean','Dirty') NOT NULL,
  `price` int(11) NOT NULL,
  `bed_type` set('single','double') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`room_number`, `availability`, `clean_status`, `price`, `bed_type`) VALUES
(101, 'Available', 'Dirty', 1500, 'single'),
(102, 'Available', 'Dirty', 2500, 'double'),
(103, 'Available', 'Clean', 2500, 'double'),
(104, 'Available', 'Clean', 1500, 'single'),
(105, 'Available', 'Clean', 2500, 'double'),
(106, 'Available', 'Clean', 1500, 'double');

-- --------------------------------------------------------

--
-- Table structure for table `user_account`
--

CREATE TABLE `user_account` (
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_account`
--

INSERT INTO `user_account` (`first_name`, `last_name`, `username`, `password`) VALUES
('b', 'b', 'a', 'b'),
('Alam', 'Rishad', 'a@gmail.com', '1234'),
('b', 'b', 'c', '1234'),
('b', 'f', 'f', '1'),
('k', 'k', 'k@gmail.com', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
