-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2020 at 02:19 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `appointdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `apptable`
--

CREATE TABLE `apptable` (
  `appID` int(10) NOT NULL,
  `patientName` varchar(30) NOT NULL,
  `phoneNo` int(15) NOT NULL,
  `email` varchar(20) NOT NULL,
  `address` varchar(40) NOT NULL,
  `issue` varchar(50) NOT NULL,
  `paymentID` int(10) NOT NULL,
  `docID` int(10) NOT NULL,
  `patientID` int(10) NOT NULL,
  `date` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `apptable`
--

INSERT INTO `apptable` (`appID`, `patientName`, `phoneNo`, `email`, `address`, `issue`, `paymentID`, `docID`, `patientID`, `date`) VALUES
(1, 'maleesha', 777777, 'ghfhhdhg', 'bcfxcfgcxgxgxcfg', 'bfdfgdghdghrd', 91, 564, 643, '2021/10/1'),
(10, '20', 12, 'ajhgdav', 'dhfgaue', 'shjdfbsdhfsdhd', 10, 677, 344, '23/10/2010');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apptable`
--
ALTER TABLE `apptable`
  ADD PRIMARY KEY (`appID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `apptable`
--
ALTER TABLE `apptable`
  MODIFY `appID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
