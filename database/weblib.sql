DROP TABLE IF EXISTS `Books`;
CREATE TABLE `Books` (
    `id` int(11) NOT NULL auto_increment,
    `Title` varchar(255) collate utf8_unicode_ci default NULL,
    `Author` varchar(255) collate utf8_unicode_ci default NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `Books` VALUES ('1', 'Huckleberry Finn', 'Mark Twain');

DROP TABLE IF EXISTS `Users`;
CREATE TABLE `User` (
    `id` int(11) NOT NULL auto_increment,
    `username` varchar(255) collate utf8_unicode_ci NOT NULL,
    `password` varchar(255) collate utf8_unicode_ci NOT NULL,
    `email` varchar(255) collate utf8_unicode_ci NOT NULL,
    `role` varchar(255) collate utf8_unicode_ci NOT NULL,
    PRIMARY KEY (`id`)
);