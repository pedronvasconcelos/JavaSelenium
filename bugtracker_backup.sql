-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.6.5-MariaDB-1:10.6.5+maria~focal - mariadb.org binary distribution
-- OS do Servidor:               debian-linux-gnu
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para bugtracker
DROP DATABASE IF EXISTS `bugtracker`;
CREATE DATABASE IF NOT EXISTS `bugtracker` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `bugtracker`;

-- Copiando estrutura para tabela bugtracker.mantis_api_token_table
CREATE TABLE IF NOT EXISTS `mantis_api_token_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `name` varchar(128) NOT NULL,
  `hash` varchar(128) NOT NULL,
  `date_created` int(10) unsigned NOT NULL DEFAULT 1,
  `date_used` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_id_name` (`user_id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_api_token_table: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_api_token_table` DISABLE KEYS */;
INSERT INTO `mantis_api_token_table` (`id`, `user_id`, `name`, `hash`, `date_created`, `date_used`) VALUES
	(1, 1, 'aa', '368471c3c652a84c53bf686aecf43c1705b414d8b87803494180118ec154909e', 1641511848, 1);
/*!40000 ALTER TABLE `mantis_api_token_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_bugnote_table
CREATE TABLE IF NOT EXISTS `mantis_bugnote_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bug_id` int(10) unsigned NOT NULL DEFAULT 0,
  `reporter_id` int(10) unsigned NOT NULL DEFAULT 0,
  `bugnote_text_id` int(10) unsigned NOT NULL DEFAULT 0,
  `view_state` smallint(6) NOT NULL DEFAULT 10,
  `note_type` int(11) DEFAULT 0,
  `note_attr` varchar(250) DEFAULT '',
  `time_tracking` int(10) unsigned NOT NULL DEFAULT 0,
  `last_modified` int(10) unsigned NOT NULL DEFAULT 1,
  `date_submitted` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_bug` (`bug_id`),
  KEY `idx_last_mod` (`last_modified`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_bugnote_table: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_bugnote_table` DISABLE KEYS */;
INSERT INTO `mantis_bugnote_table` (`id`, `bug_id`, `reporter_id`, `bugnote_text_id`, `view_state`, `note_type`, `note_attr`, `time_tracking`, `last_modified`, `date_submitted`) VALUES
	(1, 5, 1, 1, 10, 0, '', 0, 1641515651, 1641515651);
/*!40000 ALTER TABLE `mantis_bugnote_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_bugnote_text_table
CREATE TABLE IF NOT EXISTS `mantis_bugnote_text_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `note` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_bugnote_text_table: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_bugnote_text_table` DISABLE KEYS */;
INSERT INTO `mantis_bugnote_text_table` (`id`, `note`) VALUES
	(1, '');
/*!40000 ALTER TABLE `mantis_bugnote_text_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_bug_file_table
CREATE TABLE IF NOT EXISTS `mantis_bug_file_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bug_id` int(10) unsigned NOT NULL DEFAULT 0,
  `title` varchar(250) NOT NULL DEFAULT '',
  `description` varchar(250) NOT NULL DEFAULT '',
  `diskfile` varchar(250) NOT NULL DEFAULT '',
  `filename` varchar(250) NOT NULL DEFAULT '',
  `folder` varchar(250) NOT NULL DEFAULT '',
  `filesize` int(11) NOT NULL DEFAULT 0,
  `file_type` varchar(250) NOT NULL DEFAULT '',
  `content` longblob DEFAULT NULL,
  `date_added` int(10) unsigned NOT NULL DEFAULT 1,
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `bugnote_id` int(10) unsigned DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `idx_bug_file_bug_id` (`bug_id`),
  KEY `idx_diskfile` (`diskfile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_bug_file_table: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_bug_file_table` DISABLE KEYS */;
INSERT INTO `mantis_bug_file_table` (`id`, `bug_id`, `title`, `description`, `diskfile`, `filename`, `folder`, `filesize`, `file_type`, `content`, `date_added`, `user_id`, `bugnote_id`) VALUES
	(1, 5, '', '', 'f7ad6930851a9e2a6c6df01a9d86496e', 'error1.png', '', 4941, 'image/jpeg; charset=binary', _binary 0xffd8ffe000104a46494600010100000100010000ffdb0084000a060811100e0f0e10100e0e0e0e110f0e0e0f0e10100e0e100e171f2518171217171a1e2b231a1c351d1717313531352c2e3236331923373e3b313b2b31322e010b0b0b0f0e0f1711111c311f202337312e3b2e31313131362e2e312e3131312e3132312e31312e2e3131312e2e2e2e322e312e2e31342e3131312e312e2e2e2effc000110800b6011403012200021101031101ffc4001b00010001050100000000000000000000000002010304060705ffc40041100002020003030708060905010000000000010203041112052131131541515461d106141722919394d207335373b1b23234425271748192a1232472a2c1f0ffc4001a010101000301010000000000000000000000010203040506ffc40034110002010104050b040203000000000000000102110304215112143171a10513323341528191b1c1d12261e1f01523061662ffda000c03010002110311003f00f1580c1ec9f30000000000000002b9048924014486449449a882d0864144b8a2494414b7a4a692f682ba082859d23497f40d00b42c691a4bda0380250c7c8a692fb814710285968a645e7120e25210c88971a22d021103200000000000000005cab8015700016d80c000000000aa4014489245522490051226a255449c6243222a24d409c624d40952a44140928171449a812a65a259502ba0bea05556432a16340d064e81a0546898da0a38192e051d62a344c57028e0643814712d494315c0838994e042512d4c6863389071321c484a2531a161a22d179c48345216c1268882000000000172ae0055c0005b60300000001226914488df3714b2e2fa492928aab33b3839c94517628b9189871959d7fc3f47323e712fdeff0011f03995ee12c163e5f277cb932de0939609ecad55781e94625c8c4c45462b4ebd32ebfd8d597fc7898d1c55bc149b6f724a29bcfd8631be59ceba38d32a3f461f27dac7a58577fc1ec45176313ccb218a8475bd6a2b7bf560da5d6d231963eefb47ff005f011bd425d1c7cbe4c6176d3558ca2f73a9efc605c8c0d7b9c2efb47fdb1f02b1da17efcac93c966f250792ebe1c073f1c8cf53966b8fc1b128125035c7b4310b8ce6b7e5be115bf8e5c38e4539cf11f6affb63e04e7d17549668d97415e4cd6e5b4b10b2cec9ad494a39c22b38f5addbd6e6479ceffb597f6c7c073c86a92cd1b2e822e06b9ce97fdabfed8f80e72bfed65fdb1f01cf21aa4b346c2e042503c0e72bfed5ff006c3c0738ddf68fd90f02f3f1c86a92cd7ef81edca05b944f1fcfeefb47ec87814f3eb7ed1ff8f02f3e8c753966b8fc1eaca25b944f37cf2dfdf7fe3c0a79dd9fbeff00ebe05d623913519e6b8fc19f2896e48c3f389fef7f88f814f389fef7e1e05d6639331d4679ae3f0653441a2c72d2ebfc0c88bcd27d6b33659dac6782345b5de564936d3ae4441568a1b4e700000b957002ae0002db0180012445134008a2d637a3fa991147afe4ef93af68cec82b953c928cf375f29ab53cb2e2b2e069b774b37fbda755d17f747c7d19e13cdbdc9bcdbd2530f38abe1297e829c5cbfa749bc7a34976d5ee1fce53d1a4bb647e1dfce78763758d9b7f556aa99607d7df79525798463a14a3aedae2bc36639e5963879acb3cd659679e7bb2ebccd6e8babf3c73dcab739687d1a9e794bdbf89b97a379e5a7cfbd5fdde425a7d9ac8fa34976c8fc3bf9cd777b92b2534e55d254d94c3e4e2be5b6b367a0d5163db9aa1e7592514e5279463bdb7b9248d46c6b3792c966f25d4ba11d05fd1c4da5178ece2b8274bc97f05ac8fa34976c8fc3bf9cdd76bbf33a58d6be079574b9eafa58d6b4eca6cf3c4e7e7a3e4e62eba310a576a74595db45ea0b549d5645c5e4ba77e97fd0dbfd1a4bb647e1dfce3d1a4bb647e1dfce74d51db430a7e50606eba165f5ca5192e5af84a9aedae78992aea96e69e59554c726b2dedef479f87da7818382f37a251857828e7661a164a53562f38949be2dd49e4fadf5bccf77d1a4bb647e1dfce3d1a4bb647e1dfce30189e457b5367ae4e32a55908c69a5bb6856ca354795d5a5b79a79ceadfdddc5bdacf091c2e0e7085119bbf0d39d708d32b961e35ae51592849b9e7666fd6c9efcb2f54f6fd1a4bb647e1dfce3d1a4bb647e1dfce2a8627932da9b364d6ac2d7a1591965561e154dc15d269669addc8b866ba5ade42dc7ece7ca7fa5527cad1283587594a11d3ad4964b441e53cd434bcfad3c97b3e8d25db23f0efe71e8d25db23f0efe71540f2a38cd96f948f24ece531154e0a5451438d6a706e31b20a3a20e2ac5bda5bd6696f664e3713b3699b84eac3db374c7374534aab5ebb338355ea509e975ef4f35a78a333d1a4bb647e1dfce3d1a4bb647e1dfce30073f40e81e8d25db23f0efe71e8d25db23f0efe72d512873f0740f4692ed91f877f38f4692ed91f877f38aa1439f83a07a34976c8fc3bf9c7a34976c8fc3bf9c550a1cfccda97a91fe08dcfd1a4bb647e1dfce6ad8ec27216db46ad7c8ce556acb4ead2f2cf2e8e074dd5fd4f77ba38affd08eff6662b441972488b3b4f24880002e55c00ab8000b6c0600248ac422b101138a376fa2bfaec57dd55f8b34b89ba7d16fd6e2beeebfcccd178eadf87aa3aee7d747c7d19bf800f34f6c00616d5c4688694fd69ee5dcba4d378b78d859cad27b17ea5bdbc0b18b934919709279e5d1c77a791235ec1dfc9cd4ba3f6975a3608b4d26b7a7bd3ee39393b94237b8374a496d5b773fd58791b2d6cb9b7f62a003d135000000000000000000000000000000000e39e527ebb8afe62efcccec871cf28d7fbdc57f3177e6674dd7a4f77ba382febfad6ff006679524459391067a07924006010b957002ae0002db018009a251228944045d89ba7d16fd7627eeeafcccd2e26e9f45bf5d89fbbabf33345e3ab9787aa3b2e9d747c7d19bf000f34f688ce4a29c9ee496f7dc6a7b6b13772b5dca505429a85f5cab94a5c9c9a8f2919c5faba73cdee69ad59e5c4f6b6d5f9ae4a2da6d7ace3966bab8eeeff0061a553b52996031f1b7173947092c4612ebdd4abc447a22dc32ca53f5924d24a4d705c0f96e59bd3b5b5e6218c62d569de7865d9b176e93c156275d84345693dafd0f636ad96c6b50a728dd6ce35572b2b9d91874cec6a3c728a9359b49bc966b33dfd8b7bd3c9c9e728adcf2cb3ebddd0713fa36da115b4b2b7158acedd75d31b7d6aef9cb872adca5a67c32cba565a9f07d13636d1e571d8a70be72583942874c6b8aa14da52949d996739e7a964a4924b86fcce78c67c9b7a58b94524e4f45aac64e9dabb30a55f4aab06e866dab587a6f46f408516294549706bd8c99f6119292524ea99c20d2ecfa4fd911728bbedce0dc65961af6935c567a4dd11c6fe8a1ed5d18a582ab674f07ce36f2f2c572be70a59475a869925968cb2cfa73283b20399e3edda38cf28b686cca368d982c3430d55d9c60a72af757f57bd64dca5bde7c33eb2381b76963b6eed4c157b42cc3613076513ca30564df5550deb4c5bd4e4f3cfd54ba58074e072dd996ed0db16ed6be3b4aed9f5e06eb28c2d14a8c631704f29ddd2d6e59f7eae092479d8cf2c3685db0b65626bb5d58cb768799d9628a8c2f493c9c92e87eae7965bd3e001d3f6eeddc3e09d0b113941e2ad5453a6129eab1f08bc96ee27a8739f2b3c9bc6f21b2eb95d7ed4baadad4622eb9d4a0eba1af59e94da8c135fe4e8cc0000000000000001c7bca2fd7715fcc5df999d84e3de517eb98afbfbbf333a6ebd27bbdd1c37fead6ff66798cb4cbb22d48f40f24a32249910625cab8015700016d80c004d1589144a2022f44dd3e8b7ebb13f7557e2cd2626ebf45bf5d8afbbabf1668bc7572f0f5475dd3ae8f8fa337f2de26e55c1cdf4705d7d45c3c6dad7ea9685c23fe5f4ff00f7f13e7f946f6aeb60e7dbb16ffc6de1da7bf650d3953b0f1f6bed5ae9f5acd765b3539429a97297d9a5394b4c38b4927fe171691a1fd216d483aa9b2bc1baacc549abfcf70b3aa76d7524e0a4934a7be5d39b592cb23a27271d5af4c75e5a14f4ad7a38e9cf8e59f41cf3cb486276960a38d861a75d587bad555528cde2e587fd19dd28f47ad05eae59e49bccf94e4dd077984ad365716df6b4e9c71dbd8dbc11db6b551c3d32351bb14a8586b6bc361a164eaf38d4de2a7a66ad9c22e1aad7a7755179f1cdbc9a3a8e0b6de170f0aea8e1b1587aa7077bb2183b2ac1c569e527394da5bb24db7bf8749cf369eccb7111d8f4d1073b6fc057c136a29d936e727d115ab7b3a76c2da32775db3eca6555b82855a671ce745d857ead7352cbd57eabce2fa9e59e4cece54942767078b759b7f53aa4a7a316eb5d9b176bc7374d7629a6d6e365d8b8a5ba2a4a519e5284934e2fbd3ea68f64d570d542a8c615c215421eac215c5575c63d492dc8d8b037f29052fda5fa4767215f54a0eef2db1c56ecbc3d371aef3674faff006a641a2afa2fc0c5cdc311b4eae52529c9558a55c5ca5c5e4a191bd03e84e63c6c1793b455b46fda7076bc4622a8d16294a2ead11d3964b2cd3f5174f4b2bb2fc9ea30d8dc663ab76bbb1ee0ee53945d6b4f0d2924d71eb67b0010d3f6bfd1f60b1188b7111b31b849625e78baf077f234e25be3ca45c5e79efcf2cb8b7c59998df23305661707838c2ca68c05d1c4510aa693e5239bce6e49b966e4dbe9de6c8014f17ca7f2769da0f0aee9e221e677c71357236f27aac8f44b73ddbb8ac9ae86b367b4000014cd75af68d4bad7b5021505352eb5ed4352eb5ed401505352eb5ed4135d6bda01538f7945fae62befeefcccec471cf28ff5dc57f3177e6674dd7a4f77ba38affd5adfeccf3645b64a4419e81e4328c886010b957002ae0002db01800922a8813401762cdd7e8abebb17f7557e2cd1e2cddfe8a7ebb15f774fe2cd178eae5e1ea8eaba75d1f1f466fb626d351dd269e4fa99e179adab76897b3ff4d801f3b7ee4eb3be38b9c9ad1aeca76d334f23e86cad5d9d688d631bb3657572aa4af8467ba4ea94aa9e9e94a4b7acff00f49c70338c157084eb8c62a1055acb4452c928f564b87f03640707fafd8d29a72e1f06cd6a592e26af0d94e2ea71a651e460e9ad4564954f2f53f87a91f611c5eca9d96536ff00af5ce972d2eb7929c2596aae69a69c5e98f7e7159346d402ff001fb158e9cb87c6f1acbc91aff9ad9f673f619bb2299c5c9c9694fa1f4ff43d306fbb722d95ded636b1949b5bb2a64633bc4a5171a6d0003d83400000000002a50a806b372f5e5ff297e2635d64b948550842529c6763739382518b8add926dbce6bb97b33f4ecc0dae526a1b9b6d7ad1e1ed2cddb2a73cb5d119e979c75f252d2f836b37b8efd354c1af33cbe6e55e8bf23ca8ed4a9cf4454e4f39e6e2ab945423a339e6a5938ffab0e19be3bb714bb6a42308c9426f9483b2add1ca506bd49ee6da8bcd7466b7b692599e9d7b15c5b71c35716f3cdc5569bcf2cff243fb5750e657d9aafdae8abf6bf4ba7a725ec269ff00d22f36fbafc9fc16aa79c632c97ac93f6ef2fe117fab5ffce3ff0085d5b3ed5b957925b92d50e1ed27460ad538370c929c5b7aa3c13cdf495da469b579923672aafa5f91ed1c6fca37fef715fcc5df999d90e33e52bff7b8bfe62efcccd375e93ddee8db7fead6ff006679d2645956c8b3d03c8644000172ae0055c0005b6030002a994001713368fa3ddab561b116aba4a11ba1182b1fe8467179a527d09e6f7f71aaa64a2cc270538b8b36595a384d49761da79e709dab0defaaf11cf384ed586f7d5f89c662cbb191cdaa2ef703bff907dde3f83b0f3c613b561bdf57e2579e70bdab0defabf1390c645d8b31d5567c0baf3eef1fc1d679e30bda70befabf11cf185ed387f7d5f89cae322ec6435559f032d75f7789d439df0dda70fef6bf11ced86ed187f7b5f89cce332e46c26aeb3e05d71f7789d239db0dda30fef21e2579d70dda28f790f139d299256135759975bfb713a1f3ae1bb451ef21e239d70dda28f790f139ef2857941abfdc6b7f6e2741e75c3768a3de43c4a73b61bb451ef21e273e7611731abfdc6b7f6e2743e76c3768c3fbc8788e77c3769c3fbdafc4e72ec2dcac1abacc9ae7db89d2b9df0bda70defabf129cef85ed387f7d0f1398ca65b948c95d967c09aebeef13a973c617b4e1bded7e239e30bdab0defabf13944a45b948bab2cf818ebcfbbc4eb5cf384ed586f7d5f88e79c276ac2fbeabc4e43265a932ea8bbdc09fc83eef1fc1d82edbb84845ce589c3e5159bd36c272fe918b6d9c8f6ae255d88bae49c55b6cec8a7c545b6d67df918f2641b36d958ab3abad4e7bc5e5db24a94a7efd8a3644ab650de72000005cab8015700016d80c00000004493221005c8b2e45965324982991191723231d3251910c9332a322e46462c644948c6865532e3226a662299352250c9332d58494cc45324a44a16a656b1acc5e507284a1748c9d651ccb0e645ccb41a45f7616dccb4e445c8a918d4bb2996e522db99173142365652212911948b7291950c2a49c8836465222d9910ab641b0d940620000000005cab8015700016d80c000000000000aa650005c4caa9104c26054bca44948b299552064642992533194892910b53254c2998ea65759285a991acaeb31f58d6282a646b22e659d65358a0a979cc8b9969c88b90a12a5d7320e441c88b91484dc883651b28d94950d946ca00400000000000000b957002ae00022e0fb8a687dc000343ee1a1f70000d0fb8687dc000343ee1a1f70000d0fb8687dc0004b4bee0a2fb80028574bee2b93ee0014ae4fb8ae4fb8005193ee000141bca64fb800064fb8a64fb8000a38bee2993ee0010a697dc5343ee0010687dc343ee0001a1f70d0fb8000687dc343ee0001a1f70d0fb80009c20f2e80002d0ffd9, 1641515651, 1, 1);
/*!40000 ALTER TABLE `mantis_bug_file_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_bug_history_table
CREATE TABLE IF NOT EXISTS `mantis_bug_history_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `bug_id` int(10) unsigned NOT NULL DEFAULT 0,
  `field_name` varchar(64) NOT NULL,
  `old_value` varchar(255) NOT NULL,
  `new_value` varchar(255) NOT NULL,
  `type` smallint(6) NOT NULL DEFAULT 0,
  `date_modified` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_bug_history_bug_id` (`bug_id`),
  KEY `idx_history_user_id` (`user_id`),
  KEY `idx_bug_history_date_modified` (`date_modified`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_bug_history_table: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_bug_history_table` DISABLE KEYS */;
INSERT INTO `mantis_bug_history_table` (`id`, `user_id`, `bug_id`, `field_name`, `old_value`, `new_value`, `type`, `date_modified`) VALUES
	(1, 1, 1, '', '', '', 1, 1641508909),
	(11, 1, 5, '', '', '', 1, 1641511435),
	(12, 1, 5, '', '0000001', '', 2, 1641515651),
	(13, 1, 5, '', 'error1.png', '1', 9, 1641515652),
	(14, 1, 6, '', '', '', 1, 1641515767);
/*!40000 ALTER TABLE `mantis_bug_history_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_bug_monitor_table
CREATE TABLE IF NOT EXISTS `mantis_bug_monitor_table` (
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `bug_id` int(10) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`,`bug_id`),
  KEY `idx_bug_id` (`bug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_bug_monitor_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_bug_monitor_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_bug_monitor_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_bug_relationship_table
CREATE TABLE IF NOT EXISTS `mantis_bug_relationship_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `source_bug_id` int(10) unsigned NOT NULL DEFAULT 0,
  `destination_bug_id` int(10) unsigned NOT NULL DEFAULT 0,
  `relationship_type` smallint(6) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `idx_relationship_source` (`source_bug_id`),
  KEY `idx_relationship_destination` (`destination_bug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_bug_relationship_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_bug_relationship_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_bug_relationship_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_bug_revision_table
CREATE TABLE IF NOT EXISTS `mantis_bug_revision_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bug_id` int(10) unsigned NOT NULL,
  `bugnote_id` int(10) unsigned NOT NULL DEFAULT 0,
  `user_id` int(10) unsigned NOT NULL,
  `type` int(10) unsigned NOT NULL,
  `value` longtext NOT NULL,
  `timestamp` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_bug_rev_type` (`type`),
  KEY `idx_bug_rev_id_time` (`bug_id`,`timestamp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_bug_revision_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_bug_revision_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_bug_revision_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_bug_table
CREATE TABLE IF NOT EXISTS `mantis_bug_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `project_id` int(10) unsigned NOT NULL DEFAULT 0,
  `reporter_id` int(10) unsigned NOT NULL DEFAULT 0,
  `handler_id` int(10) unsigned NOT NULL DEFAULT 0,
  `duplicate_id` int(10) unsigned NOT NULL DEFAULT 0,
  `priority` smallint(6) NOT NULL DEFAULT 30,
  `severity` smallint(6) NOT NULL DEFAULT 50,
  `reproducibility` smallint(6) NOT NULL DEFAULT 10,
  `status` smallint(6) NOT NULL DEFAULT 10,
  `resolution` smallint(6) NOT NULL DEFAULT 10,
  `projection` smallint(6) NOT NULL DEFAULT 10,
  `eta` smallint(6) NOT NULL DEFAULT 10,
  `bug_text_id` int(10) unsigned NOT NULL DEFAULT 0,
  `os` varchar(32) NOT NULL DEFAULT '',
  `os_build` varchar(32) NOT NULL DEFAULT '',
  `platform` varchar(32) NOT NULL DEFAULT '',
  `version` varchar(64) NOT NULL DEFAULT '',
  `fixed_in_version` varchar(64) NOT NULL DEFAULT '',
  `build` varchar(32) NOT NULL DEFAULT '',
  `profile_id` int(10) unsigned NOT NULL DEFAULT 0,
  `view_state` smallint(6) NOT NULL DEFAULT 10,
  `summary` varchar(128) NOT NULL DEFAULT '',
  `sponsorship_total` int(11) NOT NULL DEFAULT 0,
  `sticky` tinyint(4) NOT NULL DEFAULT 0,
  `target_version` varchar(64) NOT NULL DEFAULT '',
  `category_id` int(10) unsigned NOT NULL DEFAULT 1,
  `date_submitted` int(10) unsigned NOT NULL DEFAULT 1,
  `due_date` int(10) unsigned NOT NULL DEFAULT 1,
  `last_updated` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_bug_sponsorship_total` (`sponsorship_total`),
  KEY `idx_bug_fixed_in_version` (`fixed_in_version`),
  KEY `idx_bug_status` (`status`),
  KEY `idx_project` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_bug_table: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_bug_table` DISABLE KEYS */;
INSERT INTO `mantis_bug_table` (`id`, `project_id`, `reporter_id`, `handler_id`, `duplicate_id`, `priority`, `severity`, `reproducibility`, `status`, `resolution`, `projection`, `eta`, `bug_text_id`, `os`, `os_build`, `platform`, `version`, `fixed_in_version`, `build`, `profile_id`, `view_state`, `summary`, `sponsorship_total`, `sticky`, `target_version`, `category_id`, `date_submitted`, `due_date`, `last_updated`) VALUES
	(1, 1, 1, 0, 0, 30, 50, 70, 10, 10, 10, 10, 1, '', '', '', '', '', '', 0, 10, 'Upar Evidencia', 0, 0, '', 2, 1641508909, 1, 1641508909),
	(5, 1, 1, 0, 0, 30, 50, 70, 10, 10, 10, 10, 5, '', '', '', '', '', '', 0, 10, 'Delete This Issue', 0, 0, '', 2, 1641511435, 1, 1641515652),
	(6, 1, 1, 0, 0, 30, 50, 70, 10, 10, 10, 10, 6, '', '', '', '', '', '', 0, 10, 'Issue com arquivo upado acima do tamanho maximo', 0, 0, '', 2, 1641515767, 1, 1641515767);
/*!40000 ALTER TABLE `mantis_bug_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_bug_tag_table
CREATE TABLE IF NOT EXISTS `mantis_bug_tag_table` (
  `bug_id` int(10) unsigned NOT NULL DEFAULT 0,
  `tag_id` int(10) unsigned NOT NULL DEFAULT 0,
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `date_attached` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`bug_id`,`tag_id`),
  KEY `idx_bug_tag_tag_id` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_bug_tag_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_bug_tag_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_bug_tag_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_bug_text_table
CREATE TABLE IF NOT EXISTS `mantis_bug_text_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` longtext NOT NULL,
  `steps_to_reproduce` longtext NOT NULL,
  `additional_information` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_bug_text_table: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_bug_text_table` DISABLE KEYS */;
INSERT INTO `mantis_bug_text_table` (`id`, `description`, `steps_to_reproduce`, `additional_information`) VALUES
	(1, 'Upar Evidencia', '', ''),
	(5, 'delete this issue', '', ''),
	(6, 'Descrição arquivo upado acima do tamanho maximo', '', '');
/*!40000 ALTER TABLE `mantis_bug_text_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_category_table
CREATE TABLE IF NOT EXISTS `mantis_category_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `project_id` int(10) unsigned NOT NULL DEFAULT 0,
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `name` varchar(128) NOT NULL DEFAULT '',
  `status` int(10) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_category_project_name` (`project_id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_category_table: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_category_table` DISABLE KEYS */;
INSERT INTO `mantis_category_table` (`id`, `project_id`, `user_id`, `name`, `status`) VALUES
	(1, 0, 0, 'General', 0),
	(2, 0, 0, 'Automacao', 0);
/*!40000 ALTER TABLE `mantis_category_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_config_table
CREATE TABLE IF NOT EXISTS `mantis_config_table` (
  `config_id` varchar(64) NOT NULL,
  `project_id` int(11) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `access_reqd` int(11) DEFAULT 0,
  `type` int(11) DEFAULT 90,
  `value` longtext NOT NULL,
  PRIMARY KEY (`config_id`,`project_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_config_table: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_config_table` DISABLE KEYS */;
INSERT INTO `mantis_config_table` (`config_id`, `project_id`, `user_id`, `access_reqd`, `type`, `value`) VALUES
	('database_version', 0, 0, 90, 1, '211');
/*!40000 ALTER TABLE `mantis_config_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_custom_field_project_table
CREATE TABLE IF NOT EXISTS `mantis_custom_field_project_table` (
  `field_id` int(11) NOT NULL DEFAULT 0,
  `project_id` int(10) unsigned NOT NULL DEFAULT 0,
  `sequence` smallint(6) NOT NULL DEFAULT 0,
  PRIMARY KEY (`field_id`,`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_custom_field_project_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_custom_field_project_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_custom_field_project_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_custom_field_string_table
CREATE TABLE IF NOT EXISTS `mantis_custom_field_string_table` (
  `field_id` int(11) NOT NULL DEFAULT 0,
  `bug_id` int(11) NOT NULL DEFAULT 0,
  `value` varchar(255) NOT NULL DEFAULT '',
  `text` longtext DEFAULT NULL,
  PRIMARY KEY (`field_id`,`bug_id`),
  KEY `idx_custom_field_bug` (`bug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_custom_field_string_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_custom_field_string_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_custom_field_string_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_custom_field_table
CREATE TABLE IF NOT EXISTS `mantis_custom_field_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  `type` smallint(6) NOT NULL DEFAULT 0,
  `possible_values` text DEFAULT NULL,
  `default_value` varchar(255) NOT NULL DEFAULT '',
  `valid_regexp` varchar(255) NOT NULL DEFAULT '',
  `access_level_r` smallint(6) NOT NULL DEFAULT 0,
  `access_level_rw` smallint(6) NOT NULL DEFAULT 0,
  `length_min` int(11) NOT NULL DEFAULT 0,
  `length_max` int(11) NOT NULL DEFAULT 0,
  `require_report` tinyint(4) NOT NULL DEFAULT 0,
  `require_update` tinyint(4) NOT NULL DEFAULT 0,
  `display_report` tinyint(4) NOT NULL DEFAULT 0,
  `display_update` tinyint(4) NOT NULL DEFAULT 1,
  `require_resolved` tinyint(4) NOT NULL DEFAULT 0,
  `display_resolved` tinyint(4) NOT NULL DEFAULT 0,
  `display_closed` tinyint(4) NOT NULL DEFAULT 0,
  `require_closed` tinyint(4) NOT NULL DEFAULT 0,
  `filter_by` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_custom_field_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_custom_field_table: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_custom_field_table` DISABLE KEYS */;
INSERT INTO `mantis_custom_field_table` (`id`, `name`, `type`, `possible_values`, `default_value`, `valid_regexp`, `access_level_r`, `access_level_rw`, `length_min`, `length_max`, `require_report`, `require_update`, `display_report`, `display_update`, `require_resolved`, `display_resolved`, `display_closed`, `require_closed`, `filter_by`) VALUES
	(1, 'Editar', 0, '', '', '', 10, 10, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1),
	(2, 'delete this field', 0, '', '', '', 10, 10, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
/*!40000 ALTER TABLE `mantis_custom_field_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_email_table
CREATE TABLE IF NOT EXISTS `mantis_email_table` (
  `email_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(191) NOT NULL DEFAULT '',
  `subject` varchar(250) NOT NULL DEFAULT '',
  `metadata` longtext NOT NULL,
  `body` longtext NOT NULL,
  `submitted` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_email_table: ~12 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_email_table` DISABLE KEYS */;
INSERT INTO `mantis_email_table` (`email_id`, `email`, `subject`, `metadata`, `body`, `submitted`) VALUES
	(1, 'delete@user.com.br', '[MantisBT] Account registration', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'The user administrator has created an account for you with username "deleted". In order to complete your registration, visit the following URL (make sure it is entered as the single line) and set your own access password:\n\nhttp://localhost:8989/verify.php?id=2&confirm_hash=ZZV6OFF952DFxRKfkQNYE7IIItdsyKmw_YA8uc1CKjUQLmvMFE3rPKY8d-eAwd6kI-6oGJlBmxxGRC8McSQh\n\nIf you did not request any registration, ignore this message and nothing will happen.\n\nDo not reply to this message', 1641509712),
	(2, 'oldemail@user.com.br', '[MantisBT] Account registration', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'The user administrator has created an account for you with username "updateEmail". In order to complete your registration, visit the following URL (make sure it is entered as the single line) and set your own access password:\n\nhttp://localhost:8989/verify.php?id=3&confirm_hash=l8ddJuhCTO06eQXeSUqey8zp_uKBfsnHkCussnSBV16ghjOyzU4MtYpjdcgkUqLpeYcmTVPkAUwDzRJUklgI\n\nIf you did not request any registration, ignore this message and nothing will happen.\n\nDo not reply to this message', 1641509737),
	(3, 'filter@user.com.br', '[MantisBT] Account registration', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'The user administrator has created an account for you with username "filterUser". In order to complete your registration, visit the following URL (make sure it is entered as the single line) and set your own access password:\n\nhttp://localhost:8989/verify.php?id=4&confirm_hash=YdXsfYPMMJDF9jzpAKnB6PJuqrDtwSMC1MOb_JUG6yWXfB-cc5cus7hUOY0vrfkt66NmduS35_qRorHGfemN\n\nIf you did not request any registration, ignore this message and nothing will happen.\n\nDo not reply to this message', 1641509754),
	(4, 'duplicateuser@email.com.br', '[MantisBT] Account registration', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'The user administrator has created an account for you with username "duplicate". In order to complete your registration, visit the following URL (make sure it is entered as the single line) and set your own access password:\n\nhttp://localhost:8989/verify.php?id=5&confirm_hash=NNHEUGMLr_rS8bXnFxmZYC5hgFTetmbyD50LofmvX3XFQ_xOrbbPh-XXi-mnHJllK8Ilm1jz5JhzlLDUIbro\n\nIf you did not request any registration, ignore this message and nothing will happen.\n\nDo not reply to this message', 1641510806),
	(5, 'duplicated@email.com.br', '[MantisBT] Account registration', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'The user administrator has created an account for you with username "duplicated2". In order to complete your registration, visit the following URL (make sure it is entered as the single line) and set your own access password:\n\nhttp://localhost:8989/verify.php?id=6&confirm_hash=5urXub80L85MZ03ezBcvWwJEiioS4CMta43tmznJPsudaLh8JBBlSHvOxSCOnP5kdVYBD4RYSCBJus_80vkV\n\nIf you did not request any registration, ignore this message and nothing will happen.\n\nDo not reply to this message', 1641510825),
	(6, 'newEmail@user.com.br', '[MantisBT] Account updated', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'Your account has been updated by an administrator. A list of these changes is provided below. You can update your account details and preferences at any time by visiting the following URL:\n\nhttp://localhost:8989/account_page.php\n\nE-mail oldemail@user.com.br => newEmail@user.com.br', 1641510935),
	(7, 'oldemail@user.com.br', '[MantisBT] Account updated', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'Your account has been updated by an administrator. A list of these changes is provided below. You can update your account details and preferences at any time by visiting the following URL:\n\nhttp://localhost:8989/account_page.php\n\nE-mail newEmail@user.com.br => oldemail@user.com.br', 1641510949),
	(8, 'recovery@user.com.br', '[MantisBT] Account registration', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'The user administrator has created an account for you with username "recoverypw". In order to complete your registration, visit the following URL (make sure it is entered as the single line) and set your own access password:\n\nhttp://localhost:8989/verify.php?id=7&confirm_hash=toh4MvCyhROEaMA7Kgekvz-r_yggd5eSQRyuazFC3CgyLKSnzJT-Ntdqk-aG2h4b_i1ts2VIreKU3ALY4LVx\n\nIf you did not request any registration, ignore this message and nothing will happen.\n\nDo not reply to this message', 1641511512),
	(9, 'recovery@user.com.br', '[MantisBT] Password Reset', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'Someone (presumably you) requested a password change through e-mail verification. If this was not you, ignore this message and nothing will happen.\n\nIf you requested this verification, visit the following URL to change your password:\n\nhttp://localhost:8989/verify.php?id=7&confirm_hash=toh4MvCyhROEaMA7Kgekvz-r_yggd5eSQRyuazFC3CgyLKSnzJT-Ntdqk-aG2h4b_i1ts2VIreKU3ALY4LVx\n\nUsername: recoverypw\nRemote IP address: 172.17.0.1\n\nDo not reply to this message', 1641511520),
	(10, 'recovery@user.com.br', '[MantisBT] Password Reset', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'Someone (presumably you) requested a password change through e-mail verification. If this was not you, ignore this message and nothing will happen.\n\nIf you requested this verification, visit the following URL to change your password:\n\nhttp://localhost:8989/verify.php?id=7&confirm_hash=toh4MvCyhROEaMA7Kgekvz-r_yggd5eSQRyuazFC3CgyLKSnzJT-Ntdqk-aG2h4b_i1ts2VIreKU3ALY4LVx\n\nUsername: recoverypw\nRemote IP address: 172.17.0.1\n\nDo not reply to this message', 1641511567),
	(11, 'recovery@user.com.br', '[MantisBT] Password Reset', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'Someone (presumably you) requested a password change through e-mail verification. If this was not you, ignore this message and nothing will happen.\n\nIf you requested this verification, visit the following URL to change your password:\n\nhttp://localhost:8989/verify.php?id=7&confirm_hash=toh4MvCyhROEaMA7Kgekvz-r_yggd5eSQRyuazFC3CgyLKSnzJT-Ntdqk-aG2h4b_i1ts2VIreKU3ALY4LVx\n\nUsername: recoverypw\nRemote IP address: 172.17.0.1\n\nDo not reply to this message', 1641511587),
	(12, 'recovery@user.com.br', '[MantisBT] Password Reset', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'Someone (presumably you) requested a password change through e-mail verification. If this was not you, ignore this message and nothing will happen.\n\nIf you requested this verification, visit the following URL to change your password:\n\nhttp://localhost:8989/verify.php?id=7&confirm_hash=toh4MvCyhROEaMA7Kgekvz-r_yggd5eSQRyuazFC3CgyLKSnzJT-Ntdqk-aG2h4b_i1ts2VIreKU3ALY4LVx\n\nUsername: recoverypw\nRemote IP address: 172.17.0.1\n\nDo not reply to this message', 1641511907),
	(13, 'dev@user.com.br', '[MantisBT] Account registration', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'The user administrator has created an account for you with username "developer". In order to complete your registration, visit the following URL (make sure it is entered as the single line) and set your own access password:\n\nhttp://localhost:8989/verify.php?id=8&confirm_hash=d2TRRbRwj0iMlwq3s0-2WM0dWk0P2fPqehRu7_uNyGT2E4W1pMOx2-kJs9aUpVW7MawHgeq1a8mM8CBo-Mmd\n\nIf you did not request any registration, ignore this message and nothing will happen.\n\nDo not reply to this message', 1641516672),
	(14, 'dev@user.com.br', '[MantisBT] Account updated', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'Your account has been updated by an administrator. A list of these changes is provided below. You can update your account details and preferences at any time by visiting the following URL:\n\nhttp://localhost:8989/account_page.php\n\nAccess Level reporter => developer', 1641516675),
	(15, 'viewer@user.com.br', '[MantisBT] Account registration', 'a:3:{s:7:"headers";a:0:{}s:7:"charset";s:5:"utf-8";s:8:"hostname";s:9:"localhost";}', 'The user administrator has created an account for you with username "viewer". In order to complete your registration, visit the following URL (make sure it is entered as the single line) and set your own access password:\n\nhttp://localhost:8989/verify.php?id=9&confirm_hash=z3weQB63V9rVaq7belBoig8xK_KQ9fZJ5nwTxQfUznTkEyJui_7REjFgKsjJUco-PQHdTEJkTm1l-7g0_bCs\n\nIf you did not request any registration, ignore this message and nothing will happen.\n\nDo not reply to this message', 1641516689);
/*!40000 ALTER TABLE `mantis_email_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_filters_table
CREATE TABLE IF NOT EXISTS `mantis_filters_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `project_id` int(11) NOT NULL DEFAULT 0,
  `is_public` tinyint(4) DEFAULT NULL,
  `name` varchar(64) NOT NULL DEFAULT '',
  `filter_string` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_filters_table: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_filters_table` DISABLE KEYS */;
INSERT INTO `mantis_filters_table` (`id`, `user_id`, `project_id`, `is_public`, `name`, `filter_string`) VALUES
	(1, 1, -1, 0, '', 'v9#{"_version":"v9","_view_type":"simple","category_id":["0"],"severity":[0],"status":[0],"per_page":50,"highlight_changed":6,"reporter_id":[0],"handler_id":[0],"project_id":[-3],"sort":"last_updated","dir":"DESC","filter_by_date":false,"start_month":1,"start_day":1,"start_year":2022,"end_month":1,"end_day":6,"end_year":2022,"filter_by_last_updated_date":false,"last_updated_start_month":1,"last_updated_start_day":1,"last_updated_start_year":2022,"last_updated_end_month":1,"last_updated_end_day":6,"last_updated_end_year":2022,"search":"Upar","hide_status":[90],"resolution":[0],"build":["0"],"version":["0"],"fixed_in_version":["0"],"target_version":["0"],"priority":[0],"monitor_user_id":[0],"view_state":0,"custom_fields":{"1":["0"],"2":["0"]},"sticky":true,"relationship_type":-1,"relationship_bug":0,"profile_id":[0],"platform":["0"],"os":["0"],"os_build":["0"],"tag_string":"","tag_select":0,"note_user_id":[0],"match_type":0}');
/*!40000 ALTER TABLE `mantis_filters_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_news_table
CREATE TABLE IF NOT EXISTS `mantis_news_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `project_id` int(10) unsigned NOT NULL DEFAULT 0,
  `poster_id` int(10) unsigned NOT NULL DEFAULT 0,
  `view_state` smallint(6) NOT NULL DEFAULT 10,
  `announcement` tinyint(4) NOT NULL DEFAULT 0,
  `headline` varchar(64) NOT NULL DEFAULT '',
  `body` longtext NOT NULL,
  `last_modified` int(10) unsigned NOT NULL DEFAULT 1,
  `date_posted` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_news_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_news_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_news_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_plugin_table
CREATE TABLE IF NOT EXISTS `mantis_plugin_table` (
  `basename` varchar(40) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT 0,
  `protected` tinyint(4) NOT NULL DEFAULT 0,
  `priority` int(10) unsigned NOT NULL DEFAULT 3,
  PRIMARY KEY (`basename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_plugin_table: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_plugin_table` DISABLE KEYS */;
INSERT INTO `mantis_plugin_table` (`basename`, `enabled`, `protected`, `priority`) VALUES
	('MantisCoreFormatting', 1, 0, 3);
/*!40000 ALTER TABLE `mantis_plugin_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_project_file_table
CREATE TABLE IF NOT EXISTS `mantis_project_file_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `project_id` int(10) unsigned NOT NULL DEFAULT 0,
  `title` varchar(250) NOT NULL DEFAULT '',
  `description` varchar(250) NOT NULL DEFAULT '',
  `diskfile` varchar(250) NOT NULL DEFAULT '',
  `filename` varchar(250) NOT NULL DEFAULT '',
  `folder` varchar(250) NOT NULL DEFAULT '',
  `filesize` int(11) NOT NULL DEFAULT 0,
  `file_type` varchar(250) NOT NULL DEFAULT '',
  `content` longblob DEFAULT NULL,
  `date_added` int(10) unsigned NOT NULL DEFAULT 1,
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_project_file_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_project_file_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_project_file_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_project_hierarchy_table
CREATE TABLE IF NOT EXISTS `mantis_project_hierarchy_table` (
  `child_id` int(10) unsigned NOT NULL,
  `parent_id` int(10) unsigned NOT NULL,
  `inherit_parent` tinyint(4) NOT NULL DEFAULT 0,
  UNIQUE KEY `idx_project_hierarchy` (`child_id`,`parent_id`),
  KEY `idx_project_hierarchy_child_id` (`child_id`),
  KEY `idx_project_hierarchy_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_project_hierarchy_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_project_hierarchy_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_project_hierarchy_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_project_table
CREATE TABLE IF NOT EXISTS `mantis_project_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '',
  `status` smallint(6) NOT NULL DEFAULT 10,
  `enabled` tinyint(4) NOT NULL DEFAULT 1,
  `view_state` smallint(6) NOT NULL DEFAULT 10,
  `access_min` smallint(6) NOT NULL DEFAULT 10,
  `file_path` varchar(250) NOT NULL DEFAULT '',
  `description` longtext NOT NULL,
  `category_id` int(10) unsigned NOT NULL DEFAULT 1,
  `inherit_global` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_project_name` (`name`),
  KEY `idx_project_view` (`view_state`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_project_table: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_project_table` DISABLE KEYS */;
INSERT INTO `mantis_project_table` (`id`, `name`, `status`, `enabled`, `view_state`, `access_min`, `file_path`, `description`, `category_id`, `inherit_global`) VALUES
	(1, 'Automação', 10, 1, 10, 10, '', '', 1, 1),
	(2, 'delete', 10, 1, 10, 10, '', '', 1, 1),
	(3, 'updateThisProject', 10, 1, 10, 10, '', '', 1, 1),
	(4, 'Main Project', 10, 1, 10, 10, '', '', 1, 1),
	(5, 'Project Version', 10, 1, 10, 10, '', '', 1, 1);
/*!40000 ALTER TABLE `mantis_project_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_project_user_list_table
CREATE TABLE IF NOT EXISTS `mantis_project_user_list_table` (
  `project_id` int(10) unsigned NOT NULL DEFAULT 0,
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `access_level` smallint(6) NOT NULL DEFAULT 10,
  PRIMARY KEY (`project_id`,`user_id`),
  KEY `idx_project_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_project_user_list_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_project_user_list_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_project_user_list_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_project_version_table
CREATE TABLE IF NOT EXISTS `mantis_project_version_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(10) unsigned NOT NULL DEFAULT 0,
  `version` varchar(64) NOT NULL DEFAULT '',
  `description` longtext NOT NULL,
  `released` tinyint(4) NOT NULL DEFAULT 1,
  `obsolete` tinyint(4) NOT NULL DEFAULT 0,
  `date_order` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_project_version` (`project_id`,`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_project_version_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_project_version_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_project_version_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_sponsorship_table
CREATE TABLE IF NOT EXISTS `mantis_sponsorship_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bug_id` int(11) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `amount` int(11) NOT NULL DEFAULT 0,
  `logo` varchar(128) NOT NULL DEFAULT '',
  `url` varchar(128) NOT NULL DEFAULT '',
  `paid` tinyint(4) NOT NULL DEFAULT 0,
  `date_submitted` int(10) unsigned NOT NULL DEFAULT 1,
  `last_updated` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_sponsorship_bug_id` (`bug_id`),
  KEY `idx_sponsorship_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_sponsorship_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_sponsorship_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_sponsorship_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_tag_table
CREATE TABLE IF NOT EXISTS `mantis_tag_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `name` varchar(100) NOT NULL DEFAULT '',
  `description` longtext NOT NULL,
  `date_created` int(10) unsigned NOT NULL DEFAULT 1,
  `date_updated` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`,`name`),
  KEY `idx_tag_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_tag_table: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_tag_table` DISABLE KEYS */;
INSERT INTO `mantis_tag_table` (`id`, `user_id`, `name`, `description`, `date_created`, `date_updated`) VALUES
	(1, 1, 'OldTag', '', 1641509681, 1641509681),
	(2, 1, 'delete', '', 1641509686, 1641509686);
/*!40000 ALTER TABLE `mantis_tag_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_tokens_table
CREATE TABLE IF NOT EXISTS `mantis_tokens_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `value` longtext NOT NULL,
  `timestamp` int(10) unsigned NOT NULL DEFAULT 1,
  `expiry` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_typeowner` (`type`,`owner`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_tokens_table: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_tokens_table` DISABLE KEYS */;
INSERT INTO `mantis_tokens_table` (`id`, `owner`, `type`, `value`, `timestamp`, `expiry`) VALUES
	(2, 1, 3, '1,6,5,4,3', 1641508909, 1641602171),
	(3, 2, 7, 'ZZV6OFF952DFxRKfkQNYE7IIItdsyKmw_YA8uc1CKjUQLmvMFE3rPKY8d-eAwd6kI-6oGJlBmxxGRC8McSQh', 1641509712, 1642114512),
	(4, 3, 7, 'l8ddJuhCTO06eQXeSUqey8zp_uKBfsnHkCussnSBV16ghjOyzU4MtYpjdcgkUqLpeYcmTVPkAUwDzRJUklgI', 1641509737, 1642114537),
	(5, 4, 7, 'YdXsfYPMMJDF9jzpAKnB6PJuqrDtwSMC1MOb_JUG6yWXfB-cc5cus7hUOY0vrfkt66NmduS35_qRorHGfemN', 1641509754, 1642114554),
	(7, 5, 7, 'NNHEUGMLr_rS8bXnFxmZYC5hgFTetmbyD50LofmvX3XFQ_xOrbbPh-XXi-mnHJllK8Ilm1jz5JhzlLDUIbro', 1641510806, 1642115606),
	(8, 6, 7, '5urXub80L85MZ03ezBcvWwJEiioS4CMta43tmznJPsudaLh8JBBlSHvOxSCOnP5kdVYBD4RYSCBJus_80vkV', 1641510825, 1642115625),
	(9, 7, 7, 'toh4MvCyhROEaMA7Kgekvz-r_yggd5eSQRyuazFC3CgyLKSnzJT-Ntdqk-aG2h4b_i1ts2VIreKU3ALY4LVx', 1641511512, 1642116707),
	(11, 1, 4, '1', 1641516662, 1641516992),
	(12, 8, 7, 'd2TRRbRwj0iMlwq3s0-2WM0dWk0P2fPqehRu7_uNyGT2E4W1pMOx2-kJs9aUpVW7MawHgeq1a8mM8CBo-Mmd', 1641516671, 1642121471),
	(13, 9, 7, 'z3weQB63V9rVaq7belBoig8xK_KQ9fZJ5nwTxQfUznTkEyJui_7REjFgKsjJUco-PQHdTEJkTm1l-7g0_bCs', 1641516689, 1642121489);
/*!40000 ALTER TABLE `mantis_tokens_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_user_pref_table
CREATE TABLE IF NOT EXISTS `mantis_user_pref_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `project_id` int(10) unsigned NOT NULL DEFAULT 0,
  `default_profile` int(10) unsigned NOT NULL DEFAULT 0,
  `default_project` int(10) unsigned NOT NULL DEFAULT 0,
  `refresh_delay` int(11) NOT NULL DEFAULT 0,
  `redirect_delay` int(11) NOT NULL DEFAULT 0,
  `bugnote_order` varchar(4) NOT NULL DEFAULT 'ASC',
  `email_on_new` tinyint(4) NOT NULL DEFAULT 0,
  `email_on_assigned` tinyint(4) NOT NULL DEFAULT 0,
  `email_on_feedback` tinyint(4) NOT NULL DEFAULT 0,
  `email_on_resolved` tinyint(4) NOT NULL DEFAULT 0,
  `email_on_closed` tinyint(4) NOT NULL DEFAULT 0,
  `email_on_reopened` tinyint(4) NOT NULL DEFAULT 0,
  `email_on_bugnote` tinyint(4) NOT NULL DEFAULT 0,
  `email_on_status` tinyint(4) NOT NULL DEFAULT 0,
  `email_on_priority` tinyint(4) NOT NULL DEFAULT 0,
  `email_on_priority_min_severity` smallint(6) NOT NULL DEFAULT 10,
  `email_on_status_min_severity` smallint(6) NOT NULL DEFAULT 10,
  `email_on_bugnote_min_severity` smallint(6) NOT NULL DEFAULT 10,
  `email_on_reopened_min_severity` smallint(6) NOT NULL DEFAULT 10,
  `email_on_closed_min_severity` smallint(6) NOT NULL DEFAULT 10,
  `email_on_resolved_min_severity` smallint(6) NOT NULL DEFAULT 10,
  `email_on_feedback_min_severity` smallint(6) NOT NULL DEFAULT 10,
  `email_on_assigned_min_severity` smallint(6) NOT NULL DEFAULT 10,
  `email_on_new_min_severity` smallint(6) NOT NULL DEFAULT 10,
  `email_bugnote_limit` smallint(6) NOT NULL DEFAULT 0,
  `language` varchar(32) NOT NULL DEFAULT 'english',
  `timezone` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_user_pref_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_user_pref_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_user_pref_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_user_print_pref_table
CREATE TABLE IF NOT EXISTS `mantis_user_print_pref_table` (
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `print_pref` varchar(64) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_user_print_pref_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_user_print_pref_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_user_print_pref_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_user_profile_table
CREATE TABLE IF NOT EXISTS `mantis_user_profile_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `platform` varchar(32) NOT NULL DEFAULT '',
  `os` varchar(32) NOT NULL DEFAULT '',
  `os_build` varchar(32) NOT NULL DEFAULT '',
  `description` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_user_profile_table: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_user_profile_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantis_user_profile_table` ENABLE KEYS */;

-- Copiando estrutura para tabela bugtracker.mantis_user_table
CREATE TABLE IF NOT EXISTS `mantis_user_table` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(191) NOT NULL DEFAULT '',
  `realname` varchar(191) NOT NULL DEFAULT '',
  `email` varchar(191) NOT NULL DEFAULT '',
  `password` varchar(64) NOT NULL DEFAULT '',
  `enabled` tinyint(4) NOT NULL DEFAULT 1,
  `protected` tinyint(4) NOT NULL DEFAULT 0,
  `access_level` smallint(6) NOT NULL DEFAULT 10,
  `login_count` int(11) NOT NULL DEFAULT 0,
  `lost_password_request_count` smallint(6) NOT NULL DEFAULT 0,
  `failed_login_count` smallint(6) NOT NULL DEFAULT 0,
  `cookie_string` varchar(64) NOT NULL DEFAULT '',
  `last_visit` int(10) unsigned NOT NULL DEFAULT 1,
  `date_created` int(10) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_cookie_string` (`cookie_string`),
  UNIQUE KEY `idx_user_username` (`username`),
  KEY `idx_enable` (`enabled`),
  KEY `idx_access` (`access_level`),
  KEY `idx_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bugtracker.mantis_user_table: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `mantis_user_table` DISABLE KEYS */;
INSERT INTO `mantis_user_table` (`id`, `username`, `realname`, `email`, `password`, `enabled`, `protected`, `access_level`, `login_count`, `lost_password_request_count`, `failed_login_count`, `cookie_string`, `last_visit`, `date_created`) VALUES
	(1, 'administrator', '', 'root@localhost', 'b09c600fddc573f117449b3723f23d64', 1, 0, 90, 29, 0, 0, 'TMytN1kOyRGCyxuHmHk4xt_GBPqVCxP8cFkp_hIq0Hd4ungR1NDMTicXBVrCLDKt', 1641516692, 1641508213),
	(2, 'deleted', 'Delete This User', 'delete@user.com.br', '87b06ddb47a617f7d13c1e2192e2a184', 1, 0, 25, 0, 0, 0, 'w-ur9QsWV5TkBFOtcjL5fJCklDHGWET-WtBjRAahM5akMud6yxsm7NZyqfq-J-2W', 1641509712, 1641509712),
	(3, 'updateEmail', 'Update Email', 'oldemail@user.com.br', '1e22b2d3d0a68e98b74648198ed2aebc', 1, 0, 25, 0, 0, 0, 'Uw9L5xMqa4HQeIniHIcb0xYNE8l51AqDGhHj6tXHy___l1HVIgFw1ZK3NY13UGRx', 1641509737, 1641509737),
	(4, 'filterUser', 'Filter This User', 'filter@user.com.br', '28eec2dd617150d00bbb93b9b71e8fad', 1, 0, 25, 0, 0, 0, 'IlRShGlsfcYc9OzsYAmMOx2v-C7MvMPmcOfOZRTi1iocU-Alh-saHaySJcbPc5DF', 1641509754, 1641509754),
	(5, 'duplicate', 'Duplicate User', 'duplicateuser@email.com.br', '325861c0671c9cfe0233d992d2a954e0', 1, 0, 25, 0, 0, 0, '6FYzpj0-3sOP16kzCZ7eQpCuHK67Kaed2Vcf4oIBjG8JmhcL-M96w6xdDg2hmSON', 1641510806, 1641510806),
	(6, 'duplicated2', 'Dupli user', 'duplicated@email.com.br', '1891849ab84530b25291caacaaca1529', 1, 0, 25, 0, 0, 0, 'XC2Cy9nX9UGuWX56R2RSD8C5zdc-OSnOkW4xJAIxnHMBPhR-gGDvmVX1-XCOXeT-', 1641510825, 1641510825),
	(7, 'recoverypw', 'recovery password', 'recovery@user.com.br', '2e9fd9d054d2733290f4238589a622bd', 1, 0, 25, 0, 1, 0, 's44KtLZUXjQ131ecrnSdSSDHy7AMvqnxWBrtU3TZdjHurqIeK0j4t_VnqHIgBC-u', 1641511512, 1641511512),
	(8, 'developer', 'Developer User', 'dev@user.com.br', 'b09c600fddc573f117449b3723f23d64', 1, 0, 55, 0, 0, 0, 'L9-vz_8jokrFsIJd3wLgQNtkNxouQmO3sD7M_jx7plyd3eL0KRl0EQ_nlNvLQQRW', 1641516671, 1641516671),
	(9, 'viewer', 'Viewer User', 'viewer@user.com.br', 'b09c600fddc573f117449b3723f23d64', 1, 0, 10, 0, 0, 0, 'hfWbvSe1wiyN7BDN_TXvZ_Vow8IPIsJw7KMZla7L2SfUo2VQoUu5HYMvOHiABvyA', 1641516689, 1641516689);
/*!40000 ALTER TABLE `mantis_user_table` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
