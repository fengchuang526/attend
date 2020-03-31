CREATE TABLE `t_rela` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rela_name` varchar(300) NOT NULL COMMENT '相关方姓名',
  `rela_phone` varchar(20) DEFAULT NULL COMMENT '相关方联系方式',
  `rela_address` varchar(300) DEFAULT NULL COMMENT '相关方住址',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `t_warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_code` varchar(60) NOT NULL COMMENT '物品编码',
  `goods_name` varchar(300) NOT NULL COMMENT '商品名称',
  `goods_desc` text COMMENT '商品描述',
  `goods_type` varchar(10) NOT NULL COMMENT '商品类型',
  `goods_price` double(10,4) NOT NULL COMMENT '商品单价（元）',
  `goods_num` int(11) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `t_warehouse_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_code` varchar(60) NOT NULL COMMENT '物品编码',
  `detail_desc` text COMMENT '明细描述',
  `detail_num` int(11) NOT NULL COMMENT '明细数量',
  `detail_type` varchar(10) NOT NULL COMMENT '交易类型',
  `rela_person` varchar(300) NOT NULL COMMENT '相关方',
  `detail_amt` double(24,4) NOT NULL COMMENT '总价（元）',
  `detail_date` date NOT NULL COMMENT '明细日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

