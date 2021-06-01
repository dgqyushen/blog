/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.25 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `blog`;

/*Table structure for table `blog` */

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
  `blog_id` int NOT NULL AUTO_INCREMENT,
  `blog_title` varchar(255) DEFAULT NULL,
  `blog_content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `blog_created` date DEFAULT NULL,
  `blog_modified` date DEFAULT NULL,
  `blog_image` varchar(255) DEFAULT NULL,
  `blog_author` varchar(255) DEFAULT NULL,
  `blog_top` tinyint(1) DEFAULT NULL,
  `blog_visit_num` int DEFAULT '0',
  `blog_deleted` int DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;

/*Data for the table `blog` */

insert  into `blog`(`blog_id`,`blog_title`,`blog_content`,`blog_created`,`blog_modified`,`blog_image`,`blog_author`,`blog_top`,`blog_visit_num`,`blog_deleted`) values 
(1,'测试标题1','# Java算法与数据结构入门——稀疏数组\r\n\r\n第一次写博客，如有表达含糊等问题，请见谅.........\r\n\r\n## 算法是什么\r\n\r\n算法（Algorithm）是指解题方案的准确而完整的描述，是一系列解决问题的清晰指令，算法代表着用系统的方法描述解决问题的策略机制。也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、空间或效率来完成同样的任务。一个算法的优劣可以用“空间复杂度”与”时间复杂度“来衡量。\r\n\r\n## 数据结构是什么\r\n\r\n数据结构是计算机存储、组织数据的方式。数据结构是指相互之间存在一种或多种特定关系的数据元素的集合。通常情况下，精心选择的数据结构可以带来更高的运行或者存储效率。数据结构往往同高效的检索算法和索引技术有关。\r\n\r\n## 前提\r\n\r\n在阅读本文前，请保证你已掌握基础的c语言或者java语言的基础，我尽量以最简单的方式讲清楚这次的内容，那么，废话不多说，我们直接进入正题！\r\n\r\n## 二维数组\r\n\r\n二维数组上本质上是以数组作为数组元素的数组，它给我的感觉有点像x，y的坐标表，本质上用于存储数据，为非线性结构，在数据大多为有效值（即不为0）的时候有存在的必要性，那么当我们创建一个超大的二维数组，而其中的有效值（不为0的值）却占比很少的时候，且数据与数据间无明显的排序关系，就可以说我们的二维数组保存了很多的“无用的数据”，这时候就要引出我们的“稀疏数组”的概念。\r\n\r\n## 稀疏数组\r\n\r\n稀疏数组，故名思意，就是“稀疏”的数组嘛，它的主要用途用于在矩阵中（即二维数组中），可以利用所谓的“压缩算法”，将前面提到的二维数组压缩为一个稀疏数组，节约存储空间。\r\n\r\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20200807093944315.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RncXl1c2hlbg==,size_16,color_FFFFFF,t_70#pic_center)\r\n\r\n\r\n下面，我来讲解下第二个数组的形式，我就简称它为第二数组吧，第二数组第一行，用于记录原数组的行数，列数，与总共有多少个有效值。而后面的第二行及以后，则用于单个数据的坐标定位和有效值。下面展示代码：\r\n\r\n```java\r\n//首先我们先创建一个数组并给部分的点进行赋值 \r\nint[][] OriginArray = new int[11][11];\r\n        OriginArray[1][2] = 1;\r\n        OriginArray[2][3] = 2;\r\n//遍历数组并打印\r\n        for (int[] ints : OriginArray) {\r\n            for (int anInt : ints) {\r\n                System.out.printf(\"%d\\t\",anInt);\r\n            }\r\n            System.out.println();\r\n        }\r\n```\r\n\r\n\r\n\r\n结果为：\r\n\r\n																			0	0	0	0	0	0	0	0	0	0	0	\r\n																			0	0	1	0	0	0	0	0	0	0	0	\r\n																			0	0	0	2	0	0	0	0	0	0	0	\r\n																			0	0	0	0	0	0	0	0	0	0	0	\r\n																			0	0	0	0	0	0	0	0	0	0	0	\r\n																			0	0	0	0	0	0	0	0	0	0	0	\r\n																			0	0	0	0	0	0	0	0	0	0	0	\r\n																			0	0	0	0	0	0	0	0	0	0	0	\r\n																			0	0	0	0	0	0	0	0	0	0	0	\r\n																			0	0	0	0	0	0	0	0	0	0	0	\r\n																			0	0	0	0	0	0	0	0	0	0	0	\r\n\r\n得到了我们理想中的二维数组，然后我们可以通过遍历数组，得到我们该数组保存有多少有效值\r\n\r\n```java\r\n//遍历数组得到该二维数组总共有多少个有效值\r\n        int sum = 0;\r\n        for (int i = 0; i < 11; i++) {\r\n            for (int j = 0; j < 11; j++) {\r\n                if(OriginArray[i][j]!=0){\r\n                    sum++;\r\n                }\r\n            }\r\n        }\r\n```\r\n\r\n然后开始创建一个稀疏数组，并将有效值保存在稀疏数组中\r\n\r\n```java\r\n//创建稀疏数组 格式为newArray[sum+1][3]\r\n\r\n        int[][] spraseArray = new int[sum+1][3];\r\n\r\n        spraseArray[0][0] = 11;\r\n        spraseArray[0][1] = 11;\r\n        spraseArray[0][2] = sum;\r\n```\r\n\r\n```java\r\n //遍历二维数组，讲非0的值存入到稀疏数组中，进行压缩处理\r\n        int row = 1;\r\n        for (int i = 0; i < 11; i++) {\r\n            for (int j = 0; j < 11; j++) {\r\n                if(OriginArray[i][j]!=0){\r\n                    spraseArray[row][0] = i;\r\n                    spraseArray[row][1] = j;\r\n                    spraseArray[row][2] = OriginArray[i][j];\r\n                    row++;\r\n                }\r\n            }\r\n        }\r\n```\r\n\r\n结果为：\r\n\r\n                                                                                    11	11	2	\r\n                                                                                    1	2	1	\r\n                                                                                    2	3	2	\r\n\r\n然后我们就完成了所谓的压缩处理，经过io处理之后可以写入本地文件中，减少了存储空间。\r\n\r\n\r\n\r\n最后还要将稀疏数组转为二维数组到实际开发中去应用\r\n\r\n所以我们还要会识别稀疏数组\r\n\r\n```java\r\n        //稀疏数组转二维数组\r\n        int new_row = spraseArray[0][0]; \r\n        int new_col = spraseArray[0][1]; \r\n\r\n        int[][] newArray = new int[new_row][new_col];\r\n\r\n        new_col = 0;\r\n\r\n        new_col = 0;\r\n\r\n        int value= 0 ;\r\n        //创建数组\r\n\r\n		for (int i = 1; i <row ; i++) {\r\n            new_row = spraseArray[i][0];\r\n            new_col = spraseArray[i][1];\r\n            value = spraseArray[i][2];\r\n            newArray[new_row][new_col] = value;\r\n        }\r\n```\r\n\r\n\r\n\r\n打印结果为：\r\n\r\n																				0	0	0	0	0	0	0	0	0	0	0	\r\n																				0	0	1	0	0	0	0	0	0	0	0	\r\n																				0	0	0	2	0	0	0	0	0	0	0	\r\n																				0	0	0	0	0	0	0	0	0	0	0	\r\n																				0	0	0	0	0	0	0	0	0	0	0	\r\n																				0	0	0	0	0	0	0	0	0	0	0	\r\n																				0	0	0	0	0	0	0	0	0	0	0	\r\n																				0	0	0	0	0	0	0	0	0	0	0	\r\n																				0	0	0	0	0	0	0	0	0	0	0	\r\n																				0	0	0	0	0	0	0	0	0	0	0	\r\n																				0	0	0	0	0	0	0	0	0	0	0	\r\n\r\n即大功告成，最后还可以将方法封装起来，这样的话，使用起来就可以更方便且可以解耦。\r\n\r\n最后附上我的源码：\r\n\r\n```java\r\npublic class SparseArray {\r\n    public static void main(String[] args) {\r\n        int[][] OriginArray = new int[11][11];\r\n        OriginArray[1][2] = 1;\r\n        OriginArray[2][3] = 2;\r\n        //遍历数组并打印\r\n        for (int[] ints : OriginArray) {\r\n            for (int anInt : ints) {\r\n                System.out.printf(\"%d\\t\",anInt);\r\n            }\r\n            System.out.println();\r\n        }\r\n\r\n        //遍历数组得到该二维数组总共有多少个有效值\r\n        int sum = 0;\r\n        for (int i = 0; i < 11; i++) {\r\n            for (int j = 0; j < 11; j++) {\r\n                if(OriginArray[i][j]!=0){\r\n                    sum++;\r\n                }\r\n            }\r\n        }\r\n\r\n        //创建稀疏数组 格式为newArray[sum+1][3]\r\n\r\n        int[][] spraseArray = new int[sum+1][3];\r\n\r\n        spraseArray[0][0] = 11;\r\n        spraseArray[0][1] = 11;\r\n        spraseArray[0][2] = sum;\r\n\r\n        //遍历二维数组，讲非0的值存入到稀疏数组中，进行压缩处理\r\n        int row = 1;\r\n        for (int i = 0; i < 11; i++) {\r\n            for (int j = 0; j < 11; j++) {\r\n                if(OriginArray[i][j]!=0){\r\n                    spraseArray[row][0] = i;\r\n                    spraseArray[row][1] = j;\r\n                    spraseArray[row][2] = OriginArray[i][j];\r\n                    row++;\r\n                }\r\n            }\r\n        }\r\n        //System.out.println(\"row=\"+row);\r\n        System.out.println(\"=============================\");\r\n\r\n        for (int[] ints : spraseArray) {\r\n            for (int anInt : ints) {\r\n                System.out.printf(\"%d\\t\",anInt);\r\n\r\n            }\r\n            System.out.println();\r\n        }\r\n\r\n        //稀疏数组转二维数组\r\n        int new_row = spraseArray[0][0]; //11\r\n        int new_col = spraseArray[0][1]; //11\r\n\r\n        int[][] newArray = new int[new_row][new_col];\r\n\r\n        new_col = 0;\r\n\r\n        new_col = 0;\r\n\r\n        int value= 0 ;\r\n        //创建数组\r\n\r\n\r\n\r\n\r\n        for (int i = 1; i <row ; i++) {\r\n            new_row = spraseArray[i][0];\r\n            new_col = spraseArray[i][1];\r\n            value = spraseArray[i][2];\r\n            newArray[new_row][new_col] = value;\r\n        }\r\n\r\n        System.out.println(\"===================================\");\r\n\r\n        for (int[] ints : newArray) {\r\n            for (int anInt : ints) {\r\n                System.out.printf(\"%d\\t\",anInt);\r\n            }\r\n            System.out.println();\r\n        }\r\n	 }\r\n}\r\n```','2021-03-01','2021-05-29','','',0,1,0),
(2,'测试标题2','## 算法是什么\r\n\r\n算法（Algorithm）是指解题方案的准确而完整的描述，是一系列解决问题的清晰指令，算法代表着用系统的方法描述解决问题的策略机制。也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、空间或效率来完成同样的任务。一个算法的优劣可以用“空间复杂度”与”时间复杂度“来衡量。\r\n\r\n## 数据结构是什么\r\n\r\n数据结构是计算机存储、组织数据的方式。数据结构是指相互之间存在一种或多种特定关系的数据元素的集合。通常情况下，精心选择的数据结构可以带来更高的运行或者存储效率。数据结构往往同高效的检索算法和索引技术有关。\r\n\r\n## 前提\r\n\r\n在阅读本文前，请保证你已掌握基础的c语言或者java语言的基础，我尽量以最简单的方式讲清楚这次的内容，那么，废话不多说，我们直接进入正题！\r\n\r\n## 二维数组\r\n\r\n二维数组上本质上是以数组作为数组元素的数组，它给我的感觉有点像x，y的坐标表，本质上用于存储数据，为非线性结构，在数据大多为有效值（即不为0）的时候有存在的必要性，那么当我们创建一个超大的二维数组，而其中的有效值（不为0的值）却占比很少的时候，且数据与数据间无明显的排序关系，就可以说我们的二维数组保存了很多的“无用的数据”，这时候就要引出我们的“稀疏数组”的概念。\r\n\r\n## 稀疏数组\r\n\r\n稀疏数组，故名思意，就是“稀疏”的数组嘛，它的主要用途用于在矩阵中（即二维数组中），可以利用所谓的“压缩算法”，将前面提到的二维数组压缩为一个稀疏数组，节约存储空间。\r\n\r\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20200807093944315.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RncXl1c2hlbg==,size_16,color_FFFFFF,t_70#pic_center)\r\n\r\n\r\n下面，我来讲解下第二个数组的形式，我就简称它为第二数组吧，第二数组第一行，用于记录原数组的行数，列数，与总共有多少个有效值。而后面的第二行及以后，则用于单个数据的坐标定位和有效值。下面展示代码：\r\n\r\n```java\r\n//首先我们先创建一个数组并给部分的点进行赋值 \r\nint[][] OriginArray = new int[11][11];\r\n        OriginArray[1][2] = 1;\r\n        OriginArray[2][3] = 2;\r\n//遍历数组并打印\r\n        for (int[] ints : OriginArray) {\r\n            for (int anInt : ints) {\r\n                System.out.printf(\"%d\\t\",anInt);\r\n            }\r\n            System.out.println();\r\n        }\r\n```\r\n\r\n\r\n\r\n结果为：\r\n\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	1	0	0	0	0	0	0	0	0	\r\n	0	0	0	2	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n\r\n得到了我们理想中的二维数组，然后我们可以通过遍历数组，得到我们该数组保存有多少有效值\r\n\r\n```java\r\n//遍历数组得到该二维数组总共有多少个有效值\r\n        int sum = 0;\r\n        for (int i = 0; i < 11; i++) {\r\n            for (int j = 0; j < 11; j++) {\r\n                if(OriginArray[i][j]!=0){\r\n                    sum++;\r\n                }\r\n            }\r\n        }\r\n```\r\n\r\n然后开始创建一个稀疏数组，并将有效值保存在稀疏数组中\r\n\r\n```java\r\n//创建稀疏数组 格式为newArray[sum+1][3]\r\n\r\n        int[][] spraseArray = new int[sum+1][3];\r\n\r\n        spraseArray[0][0] = 11;\r\n        spraseArray[0][1] = 11;\r\n        spraseArray[0][2] = sum;\r\n```\r\n\r\n```java\r\n //遍历二维数组，讲非0的值存入到稀疏数组中，进行压缩处理\r\n        int row = 1;\r\n        for (int i = 0; i < 11; i++) {\r\n            for (int j = 0; j < 11; j++) {\r\n                if(OriginArray[i][j]!=0){\r\n                    spraseArray[row][0] = i;\r\n                    spraseArray[row][1] = j;\r\n                    spraseArray[row][2] = OriginArray[i][j];\r\n                    row++;\r\n                }\r\n            }\r\n        }\r\n```\r\n\r\n结果为：\r\n\r\n                                                                                    11	11	2	\r\n                                                                                    1	2	1	\r\n                                                                                    2	3	2	\r\n\r\n然后我们就完成了所谓的压缩处理，经过io处理之后可以写入本地文件中，减少了存储空间。\r\n\r\n\r\n\r\n最后还要将稀疏数组转为二维数组到实际开发中去应用\r\n\r\n所以我们还要会识别稀疏数组\r\n\r\n```java\r\n        //稀疏数组转二维数组\r\n        int new_row = spraseArray[0][0]; \r\n        int new_col = spraseArray[0][1]; \r\n\r\n        int[][] newArray = new int[new_row][new_col];\r\n\r\n        new_col = 0;\r\n\r\n        new_col = 0;\r\n\r\n        int value= 0 ;\r\n        //创建数组\r\n\r\n		for (int i = 1; i <row ; i++) {\r\n            new_row = spraseArray[i][0];\r\n            new_col = spraseArray[i][1];\r\n            value = spraseArray[i][2];\r\n            newArray[new_row][new_col] = value;\r\n        }\r\n```\r\n\r\n\r\n\r\n打印结果为：\r\n\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	1	0	0	0	0	0	0	0	0	\r\n	0	0	0	2	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n	0	0	0	0	0	0	0	0	0	0	0	\r\n\r\n即大功告成，最后还可以将方法封装起来，这样的话，使用起来就可以更方便且可以解耦。\r\n\r\n最后附上我的源码：\r\n\r\n```java\r\npublic class SparseArray {\r\n    public static void main(String[] args) {\r\n        int[][] OriginArray = new int[11][11];\r\n        OriginArray[1][2] = 1;\r\n        OriginArray[2][3] = 2;\r\n        //遍历数组并打印\r\n        for (int[] ints : OriginArray) {\r\n            for (int anInt : ints) {\r\n                System.out.printf(\"%d\\t\",anInt);\r\n            }\r\n            System.out.println();\r\n        }\r\n\r\n        //遍历数组得到该二维数组总共有多少个有效值\r\n        int sum = 0;\r\n        for (int i = 0; i < 11; i++) {\r\n            for (int j = 0; j < 11; j++) {\r\n                if(OriginArray[i][j]!=0){\r\n                    sum++;\r\n                }\r\n            }\r\n        }\r\n\r\n        //创建稀疏数组 格式为newArray[sum+1][3]\r\n\r\n        int[][] spraseArray = new int[sum+1][3];\r\n\r\n        spraseArray[0][0] = 11;\r\n        spraseArray[0][1] = 11;\r\n        spraseArray[0][2] = sum;\r\n\r\n        //遍历二维数组，讲非0的值存入到稀疏数组中，进行压缩处理\r\n        int row = 1;\r\n        for (int i = 0; i < 11; i++) {\r\n            for (int j = 0; j < 11; j++) {\r\n                if(OriginArray[i][j]!=0){\r\n                    spraseArray[row][0] = i;\r\n                    spraseArray[row][1] = j;\r\n                    spraseArray[row][2] = OriginArray[i][j];\r\n                    row++;\r\n                }\r\n            }\r\n        }\r\n        //System.out.println(\"row=\"+row);\r\n        System.out.println(\"=============================\");\r\n\r\n        for (int[] ints : spraseArray) {\r\n            for (int anInt : ints) {\r\n                System.out.printf(\"%d\\t\",anInt);\r\n\r\n            }\r\n            System.out.println();\r\n        }\r\n\r\n        //稀疏数组转二维数组\r\n        int new_row = spraseArray[0][0]; //11\r\n        int new_col = spraseArray[0][1]; //11\r\n\r\n        int[][] newArray = new int[new_row][new_col];\r\n\r\n        new_col = 0;\r\n\r\n        new_col = 0;\r\n\r\n        int value= 0 ;\r\n        //创建数组\r\n\r\n\r\n\r\n\r\n        for (int i = 1; i <row ; i++) {\r\n            new_row = spraseArray[i][0];\r\n            new_col = spraseArray[i][1];\r\n            value = spraseArray[i][2];\r\n            newArray[new_row][new_col] = value;\r\n        }\r\n\r\n        System.out.println(\"===================================\");\r\n\r\n        for (int[] ints : newArray) {\r\n            for (int anInt : ints) {\r\n                System.out.printf(\"%d\\t\",anInt);\r\n            }\r\n            System.out.println();\r\n        }\r\n	 }\r\n}\r\n```','2021-03-03','2021-05-28','','',0,2,0),
(15,'2021-5-9','2121212121','2021-05-09','2021-05-09','http://127.0.0.1:8000/blog-images/pic/2abe06fbba604767bbfc5bf6c1cf017f.jpg','dgqyushen',1,0,1),
(16,'2021-5-19','','2021-05-19','2021-05-19','','dgqyushen',0,0,1),
(17,'2021-5-21','测试是否修改成功','2021-05-21','2021-05-21','http://127.0.0.1:8000/blog-images/pic/fd2ae0c118e0429aa7d68e2e670957e3.jpg','dgqyushen',0,0,1),
(18,'2021-5-22','今天参加了团日活动\n很开心','2021-05-22','2021-05-22','http://127.0.0.1:8000/blog-images/pic/469a5c9536ee451e98534f8c6febeb04.jpg','',1,0,1);

/*Table structure for table `categories` */

DROP TABLE IF EXISTS `categories`;

CREATE TABLE `categories` (
  `categories_id` int NOT NULL AUTO_INCREMENT,
  `categories_blog_id` int NOT NULL,
  `categories_name` varchar(255) NOT NULL,
  `categories_deleted` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`categories_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

/*Data for the table `categories` */

insert  into `categories`(`categories_id`,`categories_blog_id`,`categories_name`,`categories_deleted`) values 
(2,1,'测试4',0),
(3,2,'测试',0),
(4,3,'测试',1),
(6,17,'程序算法',1),
(7,18,'测试',1);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `category_id` int unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `category_created_date` date NOT NULL,
  `category_deleted` int NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `name` (`category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

/*Data for the table `category` */

insert  into `category`(`category_id`,`category_name`,`category_created_date`,`category_deleted`) values 
(1,'测试','2021-05-23',0),
(4,'侧式2','2021-05-24',0),
(5,'测试3','2021-05-27',1),
(8,'测试4','2021-05-29',0);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `comment_blog_id` int NOT NULL,
  `comment_content` varchar(255) NOT NULL,
  `comment_date` date NOT NULL,
  `comment_author` varchar(255) NOT NULL,
  `comment_avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

/*Data for the table `comment` */

insert  into `comment`(`comment_id`,`comment_blog_id`,`comment_content`,`comment_date`,`comment_author`,`comment_avatar`) values 
(2,1,'123','2021-03-25','123','https://www.static.talkxj.com/avatar/blogger.jpg'),
(3,1,'121212122','2021-03-25','212121','https://www.static.talkxj.com/avatar/blogger.jpg'),
(4,2,'121221212','2021-03-25','121212','https://www.static.talkxj.com/avatar/blogger.jpg'),
(5,1,'121212','2021-03-26','12121','https://www.static.talkxj.com/avatar/blogger.jpg'),
(6,1,'测试评论1','2021-03-27','测试评论姓名1','https://www.static.talkxj.com/avatar/blogger.jpg'),
(7,1,'11111','2021-04-08','测试redis评论','https://www.static.talkxj.com/avatar/blogger.jpg');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_username`,`user_password`) values 
(1,'dgqyushen','A731205b');

/*Table structure for table `visit` */

DROP TABLE IF EXISTS `visit`;

CREATE TABLE `visit` (
  `visit_id` int NOT NULL AUTO_INCREMENT,
  `visit_date` date NOT NULL,
  `visit_num` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`visit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

/*Data for the table `visit` */

insert  into `visit`(`visit_id`,`visit_date`,`visit_num`) values 
(1,'2021-05-01',10),
(2,'2021-05-02',100),
(3,'2021-05-03',1000),
(4,'2021-04-30',10),
(5,'2021-05-04',100),
(6,'2021-05-05',1000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
