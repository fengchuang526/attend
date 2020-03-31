/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017-10-14 11:15:59                          */
/*==============================================================*/


drop table if exists T_AUTH;

drop table if exists T_DD_CATE;

drop table if exists T_DD_SUB;

drop table if exists T_EMPLOYEE;

drop table if exists T_EMPL_CONT;

drop table if exists T_EMPL_WORK;

drop table if exists T_MENU;

drop table if exists T_ROLE;

drop table if exists T_USER;

/*==============================================================*/
/* Table: T_AUTH                                                */
/*==============================================================*/
create table T_AUTH
(
   ROLE_ID              int(11) not null,
   MENU_ID              int(11) not null,
   primary key (ROLE_ID, MENU_ID)
);

alter table T_AUTH comment '权限表';

alter table T_AUTH modify column ROLE_ID int(11) comment '角色ID';

alter table T_AUTH modify column MENU_ID int(11) comment '菜单ID';

/*==============================================================*/
/* Table: T_DD_CATE                                             */
/*==============================================================*/
create table T_DD_CATE
(
   ID                   int(11) primary key AUTO_INCREMENT comment '物理主键',
   CATE_CODE            varchar(20),
   CATE_NAME            varchar(20),
   CATE_DESC            varchar(100)
);

alter table T_DD_CATE comment '数据字典大类';

alter table T_DD_CATE modify column CATE_CODE varchar(20) comment '类型编码';

alter table T_DD_CATE modify column CATE_NAME varchar(20) comment '类型名称';

alter table T_DD_CATE modify column CATE_DESC varchar(100) comment '类型描述';

/*==============================================================*/
/* Table: T_DD_SUB                                              */
/*==============================================================*/
create table T_DD_SUB
(
   ID                   int(11) primary key AUTO_INCREMENT comment '物理主键',
   SUB_VALUE            varchar(20),
   SUB_NAME             varchar(50),
   SUB_CODE             varchar(30),
   SUB_DESC             varchar(100),
   CATE_ID              int(11)
);

alter table T_DD_SUB comment '数据字典小类';

alter table T_DD_SUB modify column SUB_VALUE varchar(20) comment '小类值';

alter table T_DD_SUB modify column SUB_NAME varchar(50) comment '小类名称';

alter table T_DD_SUB modify column SUB_CODE varchar(30) comment '小类编码';

alter table T_DD_SUB modify column SUB_DESC varchar(100) comment '小类描述';

alter table T_DD_SUB modify column CATE_ID int(11) comment '类型ID';

/*==============================================================*/
/* Table: T_EMPLOYEE                                            */
/*==============================================================*/
create table T_EMPLOYEE
(
   ID                   int(11) primary key AUTO_INCREMENT comment '物理主键',
   EMPL_NO              varchar(30),
   EMPL_NAME            varchar(50),
   EMPL_ADDRESS         varchar(200),
   EMPL_EMAIL           varchar(50),
   EMPL_PHONE_ONE       varchar(30),
   EMPL_PHONE_TWO       varchar(30),
   EMPL_PHONE_THRE      varchar(30),
   EMPL_BIRTHDAY        date,
   EMPL_ENTRY_DATE      date,
   EMPL_WECHAT          varchar(30),
   EMPL_ALIPAY          varchar(30),
   EMPL_BANKNO          varchar(30),
   EMPL_STATUS          varchar(2),
   DIMI_DATE            date
);

alter table T_EMPLOYEE comment '员工表';

alter table T_EMPLOYEE modify column EMPL_NO varchar(30) comment '员工编号';

alter table T_EMPLOYEE modify column EMPL_NAME varchar(50) comment '员工姓名';

alter table T_EMPLOYEE modify column EMPL_ADDRESS varchar(200) comment '员工地址';

alter table T_EMPLOYEE modify column EMPL_EMAIL varchar(50) comment '员工邮箱';

alter table T_EMPLOYEE modify column EMPL_PHONE_ONE varchar(30) comment '员工电话1';

alter table T_EMPLOYEE modify column EMPL_PHONE_TWO varchar(30) comment '员工电话2';

alter table T_EMPLOYEE modify column EMPL_PHONE_THRE varchar(30) comment '员工电话3';

alter table T_EMPLOYEE modify column EMPL_BIRTHDAY date comment '员工出生日期';

alter table T_EMPLOYEE modify column EMPL_ENTRY_DATE date comment '员工入职时间';

alter table T_EMPLOYEE modify column EMPL_WECHAT varchar(30) comment '员工微信号';

alter table T_EMPLOYEE modify column EMPL_ALIPAY varchar(30) comment '员工支付宝号';

alter table T_EMPLOYEE modify column EMPL_BANKNO varchar(30) comment '员工银行卡号';

alter table T_EMPLOYEE modify column EMPL_STATUS varchar(2) comment '员工状态';

alter table T_EMPLOYEE modify column DIMI_DATE date comment '离职时间';

/*==============================================================*/
/* Table: T_EMPL_CONT                                           */
/*==============================================================*/
create table T_EMPL_CONT
(
   ID                   int(11) primary key AUTO_INCREMENT comment '物理主键',
   EMPL_ID              int(11),
   EMPL_NAME            varchar(50),
   COUN_SALA_WAY        varchar(2),
   UNIT_PRICE           numeric(9,4),
   START_DATE           date,
   END_DATE             date,
   REMARK               text,
   IS_USE               varchar(2)
);

alter table T_EMPL_CONT comment '员工合同表';


alter table T_EMPL_CONT modify column EMPL_ID int(11) comment '员工ID';

alter table T_EMPL_CONT modify column EMPL_NAME varchar(50) comment '员工姓名';

alter table T_EMPL_CONT modify column COUN_SALA_WAY varchar(2) comment '计薪方式';

alter table T_EMPL_CONT modify column UNIT_PRICE numeric(9,4) comment '单价(元)';

alter table T_EMPL_CONT modify column START_DATE date comment '开始时间';

alter table T_EMPL_CONT modify column END_DATE date comment '结束时间';

alter table T_EMPL_CONT modify column REMARK text comment '备注';

alter table T_EMPL_CONT modify column IS_USE varchar(2) comment '是否使用';

/*==============================================================*/
/* Table: T_EMPL_WORK                                           */
/*==============================================================*/
create table T_EMPL_WORK
(
   ID                   int(11) primary key AUTO_INCREMENT comment '物理主键',
   EMPL_ID              int(11),
   EMPL_NAME            varchar(50),
   WORK_DATE            date,
   WORK_WAY             varchar(2),
   WORK_PRICE           numeric(9,4),
   WORK_COUNT           numeric(7,2),
   WORK_ALLOW           numeric(9,4),
   WORK_AMOUNT          numeric(9,4)
);

alter table T_EMPL_WORK comment '员工工作日志表';

alter table T_EMPL_WORK modify column EMPL_ID int(11) comment '员工ID';

alter table T_EMPL_WORK modify column EMPL_NAME varchar(50) comment '员工姓名';

alter table T_EMPL_WORK modify column WORK_DATE date comment '工作日期';

alter table T_EMPL_WORK modify column WORK_WAY varchar(2) comment '计算方式';

alter table T_EMPL_WORK modify column WORK_PRICE numeric(9,4) comment '单价(元)';

alter table T_EMPL_WORK modify column WORK_COUNT numeric(7,2) comment '工作总计';

alter table T_EMPL_WORK modify column WORK_ALLOW numeric(9,4) comment '工作补助(元)';

alter table T_EMPL_WORK modify column WORK_AMOUNT numeric(9,4) comment '总计金额';

/*==============================================================*/
/* Table: T_MENU                                                */
/*==============================================================*/
create table T_MENU
(
   ID                   int(11) primary key AUTO_INCREMENT comment '物理主键',
   MENU_CODE            varchar(30),
   MENU_NAME            varchar(50),
   MENU_URL             varchar(50),
   IS_USE               varchar(2)
);

alter table T_MENU comment '菜单表';

alter table T_MENU modify column MENU_CODE varchar(30) comment '菜单编码';

alter table T_MENU modify column MENU_NAME varchar(50) comment '菜单名称';

alter table T_MENU modify column MENU_URL varchar(50) comment '菜单地址';

alter table T_MENU modify column IS_USE varchar(2) comment '是否启用';

/*==============================================================*/
/* Table: T_ROLE                                                */
/*==============================================================*/
create table T_ROLE
(
   ID                   int(11) primary key AUTO_INCREMENT comment '物理主键',
   ROLE_CODE            varchar(20),
   ROLE_NAME            varchar(30),
   IS_USE               varchar(2)
);

alter table T_ROLE comment '角色表';

alter table T_ROLE modify column ROLE_CODE varchar(20) comment '角色编码';

alter table T_ROLE modify column ROLE_NAME varchar(30) comment '角色名称';

alter table T_ROLE modify column IS_USE varchar(2) comment '是否启用';

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER
(
   ID                   int(11) primary key AUTO_INCREMENT comment '物理主键',
   USER_ACCOUNT         varchar(50),
   USER_NAME            varchar(50),
   USER_PWD             varchar(50),
   USER_EMAIL           varchar(50),
   USER_LOGIN_IP        varchar(50),
   LOGIN_TIME           timestamp,
   USER_ADDRESS         varchar(100),
   USER_PHONE_ONE       varchar(50),
   USER_PHONE_TWO       varchar(50),
   USER_PHONE_THRE      varchar(50),
   USER_STATUS          varchar(2),
   ROLE_ID              int(11)
);

alter table T_USER comment '用户表';

alter table T_USER modify column USER_ACCOUNT varchar(50) comment '用户账号';

alter table T_USER modify column USER_NAME varchar(50) comment '用户名称';

alter table T_USER modify column USER_PWD varchar(50) comment '账号密码';

alter table T_USER modify column USER_EMAIL varchar(50) comment '邮箱';

alter table T_USER modify column USER_LOGIN_IP varchar(50) comment '登录IP';

alter table T_USER modify column LOGIN_TIME timestamp comment '最后一次登录时间';

alter table T_USER modify column USER_ADDRESS varchar(100) comment '住址';

alter table T_USER modify column USER_PHONE_ONE varchar(50) comment '电话1';

alter table T_USER modify column USER_PHONE_TWO varchar(50) comment '电话2';

alter table T_USER modify column USER_PHONE_THRE varchar(50) comment '电话3';

alter table T_USER modify column USER_STATUS varchar(2) comment '状态';

alter table T_USER modify column ROLE_ID int(11) comment '角色ID';

alter table T_AUTH add constraint FK_MENU_AUTH foreign key (MENU_ID)
      references T_MENU (ID) on delete restrict on update restrict;

alter table T_AUTH add constraint FK_ROLE_AUTH foreign key (ROLE_ID)
      references T_ROLE (ID) on delete restrict on update restrict;

alter table T_DD_SUB add constraint FK_CATE_SUB foreign key (CATE_ID)
      references T_DD_CATE (ID) on delete restrict on update restrict;

alter table T_EMPL_CONT add constraint FK_USER_CONT foreign key (EMPL_ID)
      references T_EMPLOYEE (ID) on delete restrict on update restrict;

alter table T_EMPL_WORK add constraint FK_EMPL_WORK foreign key (EMPL_ID)
      references T_EMPLOYEE (ID) on delete restrict on update restrict;

alter table T_USER add constraint FK_ROLE_USER foreign key (ROLE_ID)
      references T_ROLE (ID) on delete restrict on update restrict;

