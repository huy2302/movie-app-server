-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3307
-- Thời gian đã tạo: Th10 17, 2023 lúc 04:54 PM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `movie`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `actor`
--

CREATE TABLE `actor` (
  `actorID` int(11) NOT NULL,
  `actorName` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `country` varchar(20) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `avt` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `actor`
--

INSERT INTO `actor` (`actorID`, `actorName`, `age`, `country`, `gender`, `avt`, `description`) VALUES
(1, 'Bradley Cooper', 30, '', 1, 'jkasjdaksjdakdsj', 'asdjalsdjaslkdjla'),
(2, 'Brie Larson', 36, '', 1, 'asjdkahsdjkh', 'asdajksdhaksd'),
(3, 'Chris Hemsworth', 46, '', 0, 'aksjdkasd', 'jkashdjkahsdkj'),
(4, 'Chris Evans', 45, '', 1, 'asjdajshdaksjhd', 'asdjkahsdjahsjd');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `director`
--

CREATE TABLE `director` (
  `directorID` int(11) NOT NULL,
  `directorName` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `country` varchar(20) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `avt` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `director`
--

INSERT INTO `director` (`directorID`, `directorName`, `age`, `country`, `gender`, `avt`, `description`) VALUES
(1, 'Anthony Russo', 28, '', 1, 'asdjaksd', 'asjkdasdj'),
(2, 'Joe Russo', 29, '', 1, 'askdjasdj', 'asjkdasdj');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `genre`
--

CREATE TABLE `genre` (
  `genreID` int(11) NOT NULL,
  `genre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `genre`
--

INSERT INTO `genre` (`genreID`, `genre`) VALUES
(1, 'Action'),
(2, 'Fantasy');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `movie`
--

CREATE TABLE `movie` (
  `movieID` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `year` varchar(50) DEFAULT NULL,
  `rated` double DEFAULT NULL,
  `released` varchar(50) DEFAULT NULL,
  `runtime` int(11) NOT NULL,
  `language` varchar(40) DEFAULT NULL,
  `country` varchar(40) DEFAULT NULL,
  `awards` varchar(50) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `poster` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `movie`
--

INSERT INTO `movie` (`movieID`, `title`, `year`, `rated`, `released`, `runtime`, `language`, `country`, `awards`, `description`, `poster`) VALUES
(1, 'Avengers: Endgame', '2019', 8.5, '26 Apr 2019', 160, 'English', 'USA', '', 'After the devastating events of Avengers: Infinity War(2018), the unity of remaning allies, the Avengers assenble once more in order to undo Thanos action universe', 'https://m.media-amazon.com/images/M/ashdjkahsdkjahsdkjahsd'),
(2, 'I Am Legend', '2007', 8.2, '14 Dec 2007', 150, 'Spain', 'USA', '9 wins & 21 nominations.', 'Years after a plague kills most of humanity and transforms the rest into monsters, the sole survivor in New York City struggles valiantly to find a cure.', 'http://ia.media-imdb.com/images/M/MV5BMTU4NzMyNDk1OV5BMl5BanBnXkFtZTcwOTEwMzU1MQ@@._V1_SX300.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `movie_actor`
--

CREATE TABLE `movie_actor` (
  `id` int(11) NOT NULL,
  `movieID` int(11) DEFAULT NULL,
  `actorID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `movie_actor`
--

INSERT INTO `movie_actor` (`id`, `movieID`, `actorID`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 2, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `movie_director`
--

CREATE TABLE `movie_director` (
  `movieID` int(11) NOT NULL,
  `directorID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `movie_director`
--

INSERT INTO `movie_director` (`movieID`, `directorID`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `movie_production`
--

CREATE TABLE `movie_production` (
  `movieID` int(11) DEFAULT NULL,
  `productionID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `movie_production`
--

INSERT INTO `movie_production` (`movieID`, `productionID`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `movie_writer`
--

CREATE TABLE `movie_writer` (
  `movieID` int(11) NOT NULL,
  `writerID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `movie_writer`
--

INSERT INTO `movie_writer` (`movieID`, `writerID`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 1),
(2, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `production`
--

CREATE TABLE `production` (
  `productionID` int(11) NOT NULL,
  `production` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `production`
--

INSERT INTO `production` (`productionID`, `production`, `year`, `country`, `description`) VALUES
(1, 'Marvel Studios', 1998, 'USA', 'none'),
(2, 'Disley', 1997, 'England', 'none');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `userID` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`userID`, `username`, `password`, `phone_number`) VALUES
(1, 'huydevtr', '123456', '0123456789');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `writer`
--

CREATE TABLE `writer` (
  `writerID` int(11) NOT NULL,
  `writerName` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `country` varchar(20) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `avt` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `writer`
--

INSERT INTO `writer` (`writerID`, `writerName`, `age`, `country`, `gender`, `avt`, `description`) VALUES
(1, 'Christopher Markus', 39, '', 1, 'asdklasjd', 'askldjaslkdj'),
(2, 'Stephen McFeely', 48, '', 1, 'ajshdakjshd', 'akjshdakjshdkajs'),
(3, 'Stan Lee (based on the Marvel the Marvel comics by', 34, '', 1, 'aksdjaksdj', 'kjaksdjkasdjaksjd'),
(4, 'Jim Starlin (comic book)', 23, '', 0, 'asdjaksjdas', 'ajskdjakjsdakjsda');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`actorID`);

--
-- Chỉ mục cho bảng `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`directorID`);

--
-- Chỉ mục cho bảng `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`genreID`);

--
-- Chỉ mục cho bảng `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movieID`);

--
-- Chỉ mục cho bảng `movie_actor`
--
ALTER TABLE `movie_actor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `movieID` (`movieID`),
  ADD KEY `actorID` (`actorID`);

--
-- Chỉ mục cho bảng `movie_director`
--
ALTER TABLE `movie_director`
  ADD PRIMARY KEY (`movieID`,`directorID`),
  ADD KEY `directorID` (`directorID`);

--
-- Chỉ mục cho bảng `movie_production`
--
ALTER TABLE `movie_production`
  ADD KEY `movieID` (`movieID`),
  ADD KEY `productionID` (`productionID`);

--
-- Chỉ mục cho bảng `movie_writer`
--
ALTER TABLE `movie_writer`
  ADD PRIMARY KEY (`movieID`,`writerID`),
  ADD KEY `writerID` (`writerID`);

--
-- Chỉ mục cho bảng `production`
--
ALTER TABLE `production`
  ADD PRIMARY KEY (`productionID`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`);

--
-- Chỉ mục cho bảng `writer`
--
ALTER TABLE `writer`
  ADD PRIMARY KEY (`writerID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `actor`
--
ALTER TABLE `actor`
  MODIFY `actorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `director`
--
ALTER TABLE `director`
  MODIFY `directorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `genre`
--
ALTER TABLE `genre`
  MODIFY `genreID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `movie`
--
ALTER TABLE `movie`
  MODIFY `movieID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `movie_actor`
--
ALTER TABLE `movie_actor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `production`
--
ALTER TABLE `production`
  MODIFY `productionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `writer`
--
ALTER TABLE `writer`
  MODIFY `writerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `movie_actor`
--
ALTER TABLE `movie_actor`
  ADD CONSTRAINT `movie_actor_ibfk_1` FOREIGN KEY (`movieID`) REFERENCES `movie` (`movieID`),
  ADD CONSTRAINT `movie_actor_ibfk_2` FOREIGN KEY (`actorID`) REFERENCES `actor` (`actorID`);

--
-- Các ràng buộc cho bảng `movie_director`
--
ALTER TABLE `movie_director`
  ADD CONSTRAINT `movie_director_ibfk_1` FOREIGN KEY (`movieID`) REFERENCES `movie` (`movieID`),
  ADD CONSTRAINT `movie_director_ibfk_2` FOREIGN KEY (`directorID`) REFERENCES `director` (`directorID`);

--
-- Các ràng buộc cho bảng `movie_production`
--
ALTER TABLE `movie_production`
  ADD CONSTRAINT `movie_production_ibfk_1` FOREIGN KEY (`movieID`) REFERENCES `movie` (`movieID`),
  ADD CONSTRAINT `movie_production_ibfk_2` FOREIGN KEY (`productionID`) REFERENCES `production` (`productionID`);

--
-- Các ràng buộc cho bảng `movie_writer`
--
ALTER TABLE `movie_writer`
  ADD CONSTRAINT `movie_writer_ibfk_1` FOREIGN KEY (`movieID`) REFERENCES `movie` (`movieID`),
  ADD CONSTRAINT `movie_writer_ibfk_2` FOREIGN KEY (`writerID`) REFERENCES `writer` (`writerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
