# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.42)
# Database: sq-supplier-poc
# Generation Time: 2016-04-28 13:21:44 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table supplier
# ------------------------------------------------------------

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;

INSERT INTO `supplier` (`id`, `country_of_origin`, `dba`, `legal_structure`, `other_names`, `supplier_name`, `supplier_number`, `tax_id_number`, `tax_id_type`, `third_party_number`, `vat_registration_number`)
VALUES
	(1,'US','Verizon Wireless','C Corporation','Verizon, Inc','Verizon','VZ-30202','47-83204982','Federal ID','090909','0892309'),
	(2,'US','Wally World','C Corporation','Walmart','Walmart Stores, Inc','WM-3984','47-3829193','Federal ID','938291','209320392039'),
	(3,'CN','Sinopec, Inc','S Corporation','Sinopec','Sinopec Group','SP-23892309','47-2839201','Federal ID','230984092384','0923840238'),
	(4,'SK','Samsung Computers','Partnership','Samsung, Inc','Samsung','SS-20348','47-282829','Federal ID','2093840423','92748274950'),
	(5,'UK','RDS','Other','Royal Dutch Shell, Inc','Royal Dutch Shell','RS-23804','47-292932','Federal ID','2309840238','1627389'),
	(6,'DE','Volkswagen','Individual/Sole Proprietor','Volkswagen','Volkswagen','VW-9234893','47-23098490238','Federal ID','893479873298','56564747'),
	(7,'US','Apple Computers','Individual/Sole Proprietor','Apple, Inc','Apple','AP-23940823','47-038409238','Federal ID','929297229','2687344783'),
	(8,'SZ','Glencore Commodities','Other','Glencore, Inc','Glencore','GL-03984','123-45-6789','SSN','29837498327','10928475'),
	(9,'US','Berkshire Hathaway','Partnership','Berkshire Hathaway, Inc','Berkshire','BH-239048','47-38389','Federal ID','293874','57329829'),
	(10,'US','General Electric, Inc','Other','GE','General Electric','GE-239847','47-209384923','Federal ID','923892384','3768382'),
	(11,'JP','Honda Motors','S Corporation','Honda Industries','Honda','HO-23084','47-2398433','Federal ID','02398402','050594'),
	(12,'DE','Daimler Benz','S Corporation','Daimler','Daimler Chrysler','DM-32804','123-23-9087','SSN','209383208','050594');

/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
