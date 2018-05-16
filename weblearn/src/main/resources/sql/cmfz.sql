/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/8/14 20:41:16                           */
/*==============================================================*/

show tables;
drop table if exists article;

drop table if exists counter;



drop table if exists lesson;

drop table if exists menu;
drop table if exists voice;
drop table if exists special;

drop table if exists trollimage;
drop table if exists clog;


drop table if exists cuser;
drop table if exists cmanager;

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   id                   varchar(64) not null,  # 文章编号*
   manage_id            varchar(64),           # 属主
   primary key (id)
);

/*==============================================================*/
/* Table: cmanager                                               */
/*==============================================================*/
create table cmanager
(
   cmanager_id           varchar(64) not null,  # 管理员编号*
   username             varchar(64) not null,  # 用户名
   password             varchar(64) not null,  # 密码
   salt                  char(6) not null,     # 盐
   isblock              tinyint,               # 锁
   portrait             varchar(64),           # 肖像
   fname                varchar(64),
   primary key (cmanager_id)
);

/*==============================================================*/
/* Table: counter                                               */
/*==============================================================*/
create table counter
(
   counter_id           varchar(64) not null,  # 计数器编号*
   lesson_id            int,                   # 课程编号
   user_id              varchar(64),           # 用户编号
   count                int,                   # 计数
   bg_img               varchar(64),           # 背景图
   primary key (counter_id)
);

/*==============================================================*/
/* Table: cuser                                                 */
/*==============================================================*/
create table cuser
(
   user_id              varchar(64) not null,  # 用户编号
   cmanager_id           varchar(64),           # 管理员编号
   username             varchar(64),           # 用户名
   password             varchar(64),           # 密码
   primary key (user_id)
);

/*==============================================================*/
/* Table: lesson                                                */
/*==============================================================*/
create table lesson
(
   lesson_id            int not null,          # 课程编号
   lesson_name          varchar(64),           # 课程名称
   lesson_type          varchar(64),           # 课程类型
   user_id              varchar(64),           # 用户编号
   primary key (lesson_id)
);

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   menu_id              varchar(64) not null,  # 菜单编号*
   menu_name            varchar(20),           # 菜单名称
   menu_icon            varchar(64),           # 菜单图标
   sup_id               varchar(64),           # 父菜单编号
   href                 varchar(64),           # 连接地址
   primary key (menu_id)
);

/*==============================================================*/
/* Table: special                                               */
/*==============================================================*/
create table special
(
   id                   varchar(128) not null,  # 编号*
   name                 varchar(128),           # 名称
   realname             varchar(128),           # 真实名称
   type                 varchar(128),           # 类别
   author               varchar(128),           # 作者
   image                varchar(128),           # 封面图
   description          varchar(1024),          # 描述
   url                  varchar(128),           # 资源地址
   broadcast            varchar(128),           # 播音
   level                varchar(128),           # 级别
   publish              date,                   # 发布日期
   guru_id              varchar(128),           # 唯一序列号
   content              varchar(128),           # 内容
   children             varchar(128),           # 子集
   status               tinyint,                # 状态
   primary key (id)
);

/*==============================================================*/
/* Table: trollimage                                              */
/*==============================================================*/
create table trollimage
(
   id                   varchar(64) not null,  # 编号*
   realname             varchar(64),           # 轮播图名称
   uuidname             varchar(64),           # uuid
   imgurl               varchar(128),          # 图片地址
   description          varchar(1024),         # 描述
   onstatus             tinyint,               # 轮播状态
   issave               tinyint,               # 是否保存
   uptime               date,                  # 更新日期
   primary key (id)
);

/*==============================================================*/
/* Table: voice                                                 */
/*==============================================================*/
create table voice
(
   id                   varchar(128) not null,  # 编号*
   name                 varchar(128),           # 音频名称
   special_id           varchar(128),           # 专辑编号
   type                 varchar(128),           # 类别
   url                  varchar(128),           # 下载地址
   status               tinyint,                # 状态
   publish              date,                   # 出版日期
   realname             varchar(128),           # 原名
   special              varchar(128),           # 专辑
   primary key (id)
);

create table clog
(
   id                   varchar(64) not null,  # 编号
   username             varchar(256),          # 用户名
   time                 varchar(64),           # 时间
   detail               varchar(64),           # 详情
   type                 varchar(64),           # 类型
   primary key (id)
);

alter table article add constraint FK_Reference_5 foreign key (manage_id)
      references cmanager (cmanager_id) on delete restrict on update restrict;

alter table counter add constraint FK_Reference_4 foreign key (lesson_id)
      references lesson (lesson_id) on delete restrict on update restrict;

alter table counter add constraint FK_Reference_8 foreign key (user_id)
      references cuser (user_id) on delete restrict on update restrict;

alter table cuser add constraint FK_Reference_3 foreign key (cmanager_id)
      references cmanager (cmanager_id) on delete restrict on update restrict;

alter table lesson add constraint FK_Reference_7 foreign key (user_id)
      references cuser (user_id) on delete restrict on update restrict;

alter table menu add constraint FK_Reference_6 foreign key (sup_id)
      references menu (menu_id) on delete restrict on update restrict;

alter table voice add constraint FK_Reference_1 foreign key (special_id)
      references special (id) on delete restrict on update restrict;

