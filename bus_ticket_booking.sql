-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2020 at 04:21 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bus_ticket_booking`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `pass` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile_number` varchar(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`pass`, `email`, `mobile_number`, `name`) VALUES
('', '', '', ''),
('as', 'a', '123', 'as'),
('123', 'asd', '123123', ''),
('asd', 'asdas', '123123', 'asd'),
('asdasdasd', 'asdasdasd', 'asdasdasd', 'asdasdasd'),
('123123', 'asdasdasdsad', '123123', 'asdasdasd'),
('123', 'asfSFsd', '123124', 'asfasf'),
('123', 'jkhjhsajd', '123', 'sadasd'),
('asd', 'qwe', '14134', 'asdasd');

-- --------------------------------------------------------

--
-- Table structure for table `refund`
--

CREATE TABLE `refund` (
  `refund_id` int(11) NOT NULL,
  `customer_id_fk` varchar(255) NOT NULL,
  `refund_value` varchar(255) NOT NULL,
  `bkash_no` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `refund`
--

INSERT INTO `refund` (`refund_id`, `customer_id_fk`, `refund_value`, `bkash_no`) VALUES
(1, 'asd', '1800', '123123'),
(2, 'qwe', '2700', '123123'),
(3, 'qwe', '0', '35235252');

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `id` int(11) NOT NULL,
  `coach` varchar(20) NOT NULL,
  `date` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `route` varchar(100) NOT NULL,
  `A1` varchar(100) NOT NULL DEFAULT '0',
  `A2` varchar(100) NOT NULL DEFAULT '0',
  `A3` varchar(100) NOT NULL DEFAULT '0',
  `A4` varchar(100) NOT NULL DEFAULT '0',
  `B1` varchar(100) NOT NULL DEFAULT '0',
  `B2` varchar(100) NOT NULL DEFAULT '0',
  `B3` varchar(100) NOT NULL DEFAULT '0',
  `B4` varchar(100) NOT NULL DEFAULT '0',
  `C1` varchar(100) NOT NULL DEFAULT '0',
  `C2` varchar(100) NOT NULL DEFAULT '0',
  `C3` varchar(100) NOT NULL DEFAULT '0',
  `C4` varchar(100) NOT NULL DEFAULT '0',
  `D1` varchar(100) NOT NULL DEFAULT '0',
  `D2` varchar(100) NOT NULL DEFAULT '0',
  `D3` varchar(100) NOT NULL DEFAULT '0',
  `D4` varchar(100) NOT NULL DEFAULT '0',
  `E1` varchar(100) NOT NULL DEFAULT '0',
  `E2` varchar(100) NOT NULL DEFAULT '0',
  `E3` varchar(100) NOT NULL DEFAULT '0',
  `E4` varchar(100) NOT NULL DEFAULT '0',
  `F1` varchar(100) NOT NULL DEFAULT '0',
  `F2` varchar(100) NOT NULL DEFAULT '0',
  `F3` varchar(100) NOT NULL DEFAULT '0',
  `F4` varchar(100) NOT NULL DEFAULT '0',
  `G1` varchar(100) NOT NULL DEFAULT '0',
  `G2` varchar(100) NOT NULL DEFAULT '0',
  `G3` varchar(100) NOT NULL DEFAULT '0',
  `G4` varchar(100) NOT NULL DEFAULT '0',
  `H1` varchar(100) NOT NULL DEFAULT '0',
  `H2` varchar(100) NOT NULL DEFAULT '0',
  `H3` varchar(100) NOT NULL DEFAULT '0',
  `H4` varchar(100) NOT NULL DEFAULT '0',
  `H5` varchar(100) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`id`, `coach`, `date`, `time`, `route`, `A1`, `A2`, `A3`, `A4`, `B1`, `B2`, `B3`, `B4`, `C1`, `C2`, `C3`, `C4`, `D1`, `D2`, `D3`, `D4`, `E1`, `E2`, `E3`, `E4`, `F1`, `F2`, `F3`, `F4`, `G1`, `G2`, `G3`, `G4`, `H1`, `H2`, `H3`, `H4`, `H5`) VALUES
(3, 'AC', '12/8/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(4, 'AC', '11/8/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(5, 'AC', '16/8/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', 'asd', '0', '0', '0', 'asd', 'asd', 'asd', '0', 'asd', 'asd', 'asd', '0', 'asd', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(6, 'AC', '17/8/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', 'asd', '0', '0', 'asd', 'asd', 'asd', 'asd', 'asd', 'asd', 'asd', '0', 'asd', 'asd', 'asd', 'asd', 'asd', 'asd', 'asd', 'asd', 'asd', 'asd', 'asd', '0', '0', 'asd', 'asd', '0', 'asd', 'asd', 'asd', 'asd'),
(7, 'AC', '22/8/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(8, 'AC', '18/8/2020', '12:01 AM', 'Dhaka-Chottogram', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(9, '', '', '', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(10, 'AC', '16/08/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(11, 'AC', '21/9/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', 'asd', 'asd', '0', '0', 'asd', 'asd', '0', '0', 'asd', 'asd', '0', '0', '0', 'asd', 'asd', 'asd', '0', 'asd', 'asd', '0', '0', '0', '0', '0', '0', '0', 'asd', '0', '0'),
(12, 'androidx.appcompat.w', '22/9/2020', '04:00 PM', 'Sylhet-Dhaka', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(13, 'AC', '26/9/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', 'asd', '0', '0', '0', 'asd', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(14, 'androidx.appcompat.w', '21/9/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(15, 'androidx.appcompat.w', '21/9/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(16, 'androidx.appcompat.w', '21/9/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(17, 'androidx.appcompat.w', '21/9/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(18, 'androidx.appcompat.w', '21/9/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(19, 'NON-AC', '30/9/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'asd', '0', '0', '0', '0', 'asd', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(20, 'AC', '22/9/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'asd', '0', 'qwe', '0', 'asd', '0', 'qwe', '0', '0', 'qwe', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
(21, 'NON-AC', '21/9/2020', '08:00 PM', 'Dhaka-Rajshahi', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'asd', '0', 'asd', '0', '0', '0', '0', '0', 'asd', '0', 'asd'),
(22, 'AC', '24/9/2020', '12:01 AM', 'Dhaka-Khulna', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'qwe', '0', '0', 'qwe', '0', '0', '0', '0', '0', '0', '0', '0', 'qwe', '0', '0', '0', '0', '0', '0', '0'),
(23, 'AC', '22/9/2020', '12:01 AM', 'Dhaka-Rajshahi', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'qwe', 'qwe', '0', '0', 'qwe', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL,
  `customer_id_fk` varchar(255) NOT NULL,
  `route` varchar(100) NOT NULL,
  `coach` varchar(100) NOT NULL,
  `date` varchar(255) NOT NULL,
  `time` varchar(100) NOT NULL,
  `price` varchar(255) NOT NULL,
  `bkash_no` varchar(255) NOT NULL,
  `seats` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`ticket_id`, `customer_id_fk`, `route`, `coach`, `date`, `time`, `price`, `bkash_no`, `seats`) VALUES
(9, 'asd', 'Dhaka-Khulna', 'AC', '21/9/2020', '12:01 AM', '1800', '123', 'E3,F3'),
(11, 'asd', 'Dhaka-Khulna', 'AC', '26/9/2020', '12:01 AM', '1800', '123', 'B2,C2'),
(14, 'asd', 'Dhaka-Khulna', 'AC', '21/9/2020', '12:01 AM', '900', '123321', 'H3'),
(19, 'asd', 'Dhaka-Khulna', 'AC', '22/9/2020', '12:01 AM', '1800', '124124', 'C2,D2'),
(20, 'asd', 'Dhaka-Rajshahi', 'NON-AC', '21/9/2020', '08:00 PM', '3200', '213124', 'G1,H5,H3,F3'),
(22, 'qwe', 'Dhaka-Khulna', 'AC', '22/9/2020', '12:01 AM', '2700', '1212313', 'E3,C4,D4'),
(23, 'qwe', 'Dhaka-Khulna', 'AC', '22/9/2020', '12:01 AM', '2700', '1212313', 'E3,C4,D4'),
(24, 'qwe', 'Dhaka-Khulna', 'AC', '22/9/2020', '12:01 AM', '2700', '1212313', 'E3,C4,D4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `refund`
--
ALTER TABLE `refund`
  ADD PRIMARY KEY (`refund_id`),
  ADD KEY `rea1` (`customer_id_fk`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticket_id`),
  ADD KEY `t_fk_1` (`customer_id_fk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `refund`
--
ALTER TABLE `refund`
  MODIFY `refund_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `seat`
--
ALTER TABLE `seat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `ticket_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `refund`
--
ALTER TABLE `refund`
  ADD CONSTRAINT `rea1` FOREIGN KEY (`customer_id_fk`) REFERENCES `customer` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `t_fk_1` FOREIGN KEY (`customer_id_fk`) REFERENCES `customer` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
