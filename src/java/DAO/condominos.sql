/*
Navicat MySQL Data Transfer

Source Server         : Condominios
Source Server Version : 50548
Source Host           : acesolutions.com.br:3306
Source Database       : aceso538_condominos

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2016-06-25 01:50:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Acrescimo
-- ----------------------------
DROP TABLE IF EXISTS `Acrescimo`;
CREATE TABLE `Acrescimo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` text COLLATE utf8_unicode_ci,
  `valor` double(11,2) DEFAULT NULL,
  `status` char(1) COLLATE utf8_unicode_ci DEFAULT 'A',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Acrescimo
-- ----------------------------
INSERT INTO `Acrescimo` VALUES ('1', 'DetetizaÃ§Ã£o', '50.50', 'A');
INSERT INTO `Acrescimo` VALUES ('2', 'DetetizaÃ§Ã£o', '50.50', 'I');

-- ----------------------------
-- Table structure for AgendamentoArea
-- ----------------------------
DROP TABLE IF EXISTS `AgendamentoArea`;
CREATE TABLE `AgendamentoArea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_morador` int(11) NOT NULL,
  `id_area` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_morador` (`id_morador`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of AgendamentoArea
-- ----------------------------
INSERT INTO `AgendamentoArea` VALUES ('1', '1', '1', '2016-06-22 20:49:49');
INSERT INTO `AgendamentoArea` VALUES ('2', '0', '3', null);
INSERT INTO `AgendamentoArea` VALUES ('3', '0', '3', null);
INSERT INTO `AgendamentoArea` VALUES ('4', '0', '4', null);
INSERT INTO `AgendamentoArea` VALUES ('5', '1', '5', null);
INSERT INTO `AgendamentoArea` VALUES ('6', '2', '3', null);

-- ----------------------------
-- Table structure for Area
-- ----------------------------
DROP TABLE IF EXISTS `Area`;
CREATE TABLE `Area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Area
-- ----------------------------
INSERT INTO `Area` VALUES ('1', 'Parquinho', 'Parque pra Criançada');
INSERT INTO `Area` VALUES ('2', 'Salão de Festas I', 'Salão de Festas I');
INSERT INTO `Area` VALUES ('3', 'Salão de Jogos', 'Salão de Jogos');
INSERT INTO `Area` VALUES ('4', 'Piscina', 'Piscina do Condominio');
INSERT INTO `Area` VALUES ('5', 'Quadra', 'Quadra de Futebol');

-- ----------------------------
-- Table structure for Boletos
-- ----------------------------
DROP TABLE IF EXISTS `Boletos`;
CREATE TABLE `Boletos` (
  `id` int(11) NOT NULL,
  `valor` double(11,2) DEFAULT NULL,
  `id_morador` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mes` int(11) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `status` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Boletos
-- ----------------------------

-- ----------------------------
-- Table structure for Funcionario
-- ----------------------------
DROP TABLE IF EXISTS `Funcionario`;
CREATE TABLE `Funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` text COLLATE utf8_unicode_ci,
  `senha` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` char(1) COLLATE utf8_unicode_ci DEFAULT 'A',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Funcionario
-- ----------------------------
INSERT INTO `Funcionario` VALUES ('1', 'faxineira', 'senha', 'A');

-- ----------------------------
-- Table structure for Informacao
-- ----------------------------
DROP TABLE IF EXISTS `Informacao`;
CREATE TABLE `Informacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(200) NOT NULL,
  `informacao` text NOT NULL,
  `id_morador` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  `status` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Informacao
-- ----------------------------
INSERT INTO `Informacao` VALUES ('1', 'Bem Vindos ao Sistema do Condomínio', 'Sistema do Condominio!', '1', '2016-06-23 13:34:56', 'A');
INSERT INTO `Informacao` VALUES ('2', 'DetetizaÃ§Ã£o', '<p>Ol&aacute; Moradores !<br />Como est&atilde;o ?</p>\r\n<p>Um aviso Importante, no pr&oacute;ximo final de semana o predio ser&aacute; detetizado por uma empresa contratada!</p>\r\n<p><canvas id=\"netbeans_glasspane\" style=\"position: fixed; top: 0px; left: 0px; z-index: 50000; pointer-events: none;\" width=\"499\" height=\"406\"></canvas></p>', '1', null, 'A');

-- ----------------------------
-- Table structure for Mensagem
-- ----------------------------
DROP TABLE IF EXISTS `Mensagem`;
CREATE TABLE `Mensagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tituloMsg` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `textoMsg` text COLLATE utf8_unicode_ci NOT NULL,
  `idSolicitacao` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_solic` (`idSolicitacao`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Mensagem
-- ----------------------------
INSERT INTO `Mensagem` VALUES ('1', 'goguy', '<p>otbglugtvl</p>\r\n<p>&nbsp;</p>', '8');

-- ----------------------------
-- Table structure for Morador
-- ----------------------------
DROP TABLE IF EXISTS `Morador`;
CREATE TABLE `Morador` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Senha` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Apartamento` int(11) DEFAULT NULL,
  `Tipo` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Morador
-- ----------------------------
INSERT INTO `Morador` VALUES ('1', 'tobias', 'senha', '10', 'S');
INSERT INTO `Morador` VALUES ('2', 'prislao', 'senha', '20', 'S');
INSERT INTO `Morador` VALUES ('3', 'morador', 'senha', '30', 'C');
INSERT INTO `Morador` VALUES ('14', 'sindico', 'sindico', '50', 'S');

-- ----------------------------
-- Table structure for Produto
-- ----------------------------
DROP TABLE IF EXISTS `Produto`;
CREATE TABLE `Produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Produto
-- ----------------------------
INSERT INTO `Produto` VALUES ('1', 'sabaaaaaaao', 'Desc', '2');
INSERT INTO `Produto` VALUES ('2', 'teste do sabao em po', 'Desc', '2');
INSERT INTO `Produto` VALUES ('3', 'AAa', 'vvv1', '1');
INSERT INTO `Produto` VALUES ('4', 'AAa', 'vvv1', '1');
INSERT INTO `Produto` VALUES ('5', 'Produto2', 'desc', '5');
INSERT INTO `Produto` VALUES ('6', 'asdasd', '123', '2');
INSERT INTO `Produto` VALUES ('7', 'produto2', 'desc', '1');
INSERT INTO `Produto` VALUES ('8', 'teste', 'teste', '21');
INSERT INTO `Produto` VALUES ('9', 'teste', 'teste', '21');

-- ----------------------------
-- Table structure for Reuniao
-- ----------------------------
DROP TABLE IF EXISTS `Reuniao`;
CREATE TABLE `Reuniao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idMorador` int(11) NOT NULL,
  `assunto` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `pauta` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dataReuniao` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkMorador` (`idMorador`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Reuniao
-- ----------------------------
INSERT INTO `Reuniao` VALUES ('1', '3', 'Dinheiro', 'Cobrar mais dos inquilinos folgados', '2016-06-23');
INSERT INTO `Reuniao` VALUES ('2', '3', 'Financeiro', 'ModificaÃ§Ãµes', '2016-06-23');
INSERT INTO `Reuniao` VALUES ('3', '3', 'Greve de Ã´nibus ', 'Greve', '2016-06-23');
INSERT INTO `Reuniao` VALUES ('4', '3', 'Compra de materiais', 'compras', '2016-06-23');
INSERT INTO `Reuniao` VALUES ('6', '4', 'Bolos', 'Qualquer', '2016-06-23');
INSERT INTO `Reuniao` VALUES ('7', '12', 'daowkdpak', 'aifwapjfpiaw', '2016-06-24');

-- ----------------------------
-- Table structure for Solicitacao
-- ----------------------------
DROP TABLE IF EXISTS `Solicitacao`;
CREATE TABLE `Solicitacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_morador` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `dataAbertura` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dataFechamento` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `id_morador` (`id_morador`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Solicitacao
-- ----------------------------
INSERT INTO `Solicitacao` VALUES ('1', '3', '1', '2016-06-24 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `Solicitacao` VALUES ('2', '3', '1', '2016-06-25 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `Solicitacao` VALUES ('3', '3', '1', '2016-06-25 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `Solicitacao` VALUES ('4', '3', '1', '2016-06-25 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `Solicitacao` VALUES ('5', '3', '1', '2016-06-25 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `Solicitacao` VALUES ('6', '3', '1', '2016-06-25 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `Solicitacao` VALUES ('7', '3', '1', '2016-06-25 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `Solicitacao` VALUES ('8', '3', '1', '2016-06-25 00:00:00', '0000-00-00 00:00:00');
