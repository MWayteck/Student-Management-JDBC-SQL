-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 05, 2021 at 06:07 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bigproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `cid` varchar(64) NOT NULL,
  `cname` varchar(64) DEFAULT NULL,
  `meets_at` varchar(64) DEFAULT NULL,
  `room` varchar(64) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `limits` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`cid`, `cname`, `meets_at`, `room`, `fid`, `limits`) VALUES
('AH1', 'Sociology', 'Thursday', 'room 099', 1, 55),
('CSC1', 'Intro to database', 'monday', 'room 102', 3, 40),
('CSC2', 'Intro to programming', 'wednesday', 'room 101', 3, 55),
('CSC3', 'OOP', 'Friday', 'room 109', 3, 70),
('CSC4', 'Data structures and algrothm', 'Monday', 'room 101', 3, 55),
('CSC5', 'Web Technologies', 'Thursday', 'room 046', 3, 55),
('CSC6', 'Visual programming', 'Tuesday', 'room 101', 3, 45),
('CSC7', 'Android programming', 'monday', 'room 107', 3, 45),
('ECE', 'Electronics 1', 'tuesday', 'room 098', 7, 50),
('ECE2', 'Electronics 2', 'Friday', 'room 056', 7, 45);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `did` int(11) NOT NULL,
  `dname` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`did`, `dname`) VALUES
(1, 'Agricultural Sciences'),
(2, 'Computer Science'),
(3, 'Arts and Humanities'),
(4, 'Business and Economics'),
(5, 'Administrative sciences'),
(6, 'Management Sciences'),
(7, 'Electrical Engineering'),
(8, 'Chemical Engineering'),
(9, 'Physics'),
(10, 'Biology');

-- --------------------------------------------------------

--
-- Table structure for table `enrollement`
--

CREATE TABLE `enrollement` (
  `sid` int(11) NOT NULL,
  `cid` varchar(64) NOT NULL,
  `exam1` int(11) DEFAULT NULL,
  `exam2` int(11) DEFAULT NULL,
  `final` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enrollement`
--

INSERT INTO `enrollement` (`sid`, `cid`, `exam1`, `exam2`, `final`) VALUES
(1, 'ECE', 76, 88, 91),
(2, 'ECE2', 89, 55, 63),
(3, 'CSC1', 56, 69, 84),
(4, 'CSC2', 56, 96, 84),
(5, 'CSC3', 96, 56, 74),
(6, 'CSC4', 66, 76, 69),
(7, 'CSC5', 89, 75, 67),
(8, 'CSC6', 34, 56, 78),
(9, 'CSC7', 49, 89, 76),
(10, 'AH1', 88, 97, 90);

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `fid` int(11) NOT NULL,
  `fname` varchar(64) DEFAULT NULL,
  `depid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`fid`, `fname`, `depid`) VALUES
(1, 'Nathan', 1),
(2, 'Theo', 1),
(3, 'Adrian', 2),
(4, 'Isaac', 2),
(5, 'Elvin', 6),
(6, 'Richard', 7),
(7, 'Brian', 7),
(8, 'Michael', 8),
(9, 'Keith', 9),
(10, 'Ralph', 10);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `sid` int(11) NOT NULL,
  `sname` varchar(64) DEFAULT NULL,
  `depid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`sid`, `sname`, `depid`) VALUES
(1, 'Owen', 1),
(2, 'Simon', 1),
(3, 'Norbert', 10),
(4, 'Wilber', 9),
(5, 'Autmn', 6),
(6, 'Smaeul', 7),
(7, 'Vincent', 9),
(8, 'Masood', 8),
(9, 'Irfan', 9),
(10, 'Kohli', 4);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `sid` int(11) NOT NULL,
  `sname` varchar(64) DEFAULT NULL,
  `major` varchar(64) DEFAULT NULL,
  `s_level` varchar(64) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`sid`, `sname`, `major`, `s_level`, `age`) VALUES
(1, 'John Doe', 'Computer Science', 'junior', 21),
(2, 'Noah', 'Electrical Eng.', 'Senior', 24),
(3, 'Jack', 'Computer Sceince', 'Sophomore', 20),
(4, 'Harry', 'Chemistry', 'Junior', 20),
(5, 'George', 'Biology', 'phd', 29),
(6, 'Amelia', 'Physics', 'Maters', 26),
(7, 'Isla', 'Computer Science', 'Junior', 18),
(8, 'Emily', 'Biology', 'Senior', 24),
(9, 'Thomas', 'Physics', 'Junior', 19),
(10, 'Jack', 'Biology', 'phd', 32);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`cid`),
  ADD KEY `fid` (`fid`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`did`);

--
-- Indexes for table `enrollement`
--
ALTER TABLE `enrollement`
  ADD PRIMARY KEY (`sid`,`cid`),
  ADD KEY `cid` (`cid`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`fid`),
  ADD KEY `depid` (`depid`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`sid`),
  ADD KEY `depid` (`depid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`sid`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`fid`) REFERENCES `faculty` (`fid`);

--
-- Constraints for table `enrollement`
--
ALTER TABLE `enrollement`
  ADD CONSTRAINT `enrollement_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `courses` (`cid`),
  ADD CONSTRAINT `enrollement_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`);

--
-- Constraints for table `faculty`
--
ALTER TABLE `faculty`
  ADD CONSTRAINT `faculty_ibfk_1` FOREIGN KEY (`depid`) REFERENCES `department` (`did`);

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`depid`) REFERENCES `department` (`did`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
