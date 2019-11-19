# mybatis-plus
springboot整合mybatis-plus

mybatis-plus官方文档  https://mp.baomidou.com/guide/crud-interface.html

mybatis-plus相比mybatis有什么优势，我就不说了，官方文档都有，百度上也很多，自行搜索了解。

这个demo主要做了几个基本的crud操作和mybatis-plus的api调用，以及mybatis-plus的代码生成器，由于官方的文档上很多内容，就不一一测试了，但demo中的测试囊括了mybatis-plus的基本使用，在原理使用上都是一样的，参考我的demo，然后再看看源码和官方文档，基本没什么问题的。

再有问题就。。。就。。。百度或者谷歌吧。

所有接口的测试都放在test下的单元测试类中。

我的数据库名是book，测试用的表是books。

新建books表：

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `BNO` int(11) NOT NULL,
  `BNAME` varchar(50) DEFAULT NULL,
  `AUTHOR` varchar(50) DEFAULT NULL,
  `PRICE` int(11) DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  PRIMARY KEY (`BNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

填充books表：

INSERT INTO `books` VALUES ('1', '水浒传', '施耐庵', '50', '200');
INSERT INTO `books` VALUES ('2', '红楼梦', '曹雪芹', '26', '210');
INSERT INTO `books` VALUES ('3', '西游记', '吴承恩', '34', '162');
INSERT INTO `books` VALUES ('4', '三国演义', '罗贯中', '49', '27');
INSERT INTO `books` VALUES ('5', '计算网络', 'xxx', '46', '49');
INSERT INTO `books` VALUES ('6', '操作系统习题', '浙江大学', '20', '44');
INSERT INTO `books` VALUES ('7', '计算方法', '清华大学', '54', '75');
INSERT INTO `books` VALUES ('8', 'Java编程思想', '埃克尔', '108', null);
INSERT INTO `books` VALUES ('9', '语文', null, '1', null);
INSERT INTO `books` VALUES ('10', '数学', null, '2', null);
INSERT INTO `books` VALUES ('11', '英语', null, '3', null);
