/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/8/11 22:04:04                           */
/*==============================================================*/
show tables;
/*shiro权限追加表*/
drop table if exists user_role;
drop table if exists role;
drop table if exists clog;

drop table if exists article;

drop table if exists counter;

drop table if exists frequency;

drop table if exists lesson;

drop table if exists menu;

drop table if exists special;

drop table if exists trollimage;

drop table if exists cuser;

drop table if exists cmanager;

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   id                   varchar(64) not null,
   manage_id            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: cmanager                                               */
/*==============================================================*/
create table cmanager
(
   cmanager_id           varchar(64) not null,
   username             varchar(64) not null,
   password             varchar(64) not null,
   salt                 varchar(64) not null,
   isblock              tinyint,
   portrait             varchar(64),
   fname                varchar(64),
   primary key (cmanager_id)
);

/*==============================================================*/
/* Table: counter                                               */
/*==============================================================*/
create table counter
(
   counter_id           varchar(64) not null,
   lesson_id            int,
   user_id              varchar(64),
   count                int,
   bg_img               varchar(64),
   primary key (counter_id)
);

/*==============================================================*/
/* Table: cuser                                                 */
/*==============================================================*/
create table cuser
(
   user_id              varchar(64) not null,
   cmanager_id           varchar(64),
   username             varchar(64),
   password             varchar(64),
   primary key (user_id)
);

/*==============================================================*/
/* Table: frequency                                             */
/*==============================================================*/
create table frequency
(
   id                   varchar(128) not null,
   name                 varchar(128),
   special_id           varchar(128),
   url                  varchar(128),
   primary key (id)
);

/*==============================================================*/
/* Table: lesson                                                */
/*==============================================================*/
create table lesson
(
   lesson_id            int not null,
   lesson_name          varchar(64),
   lesson_type          varchar(64),
   user_id              varchar(64),
   primary key (lesson_id)
);

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   menu_id              varchar(64) not null,
   menu_name            varchar(20),
   menu_icon            varchar(64),
   sup_id               varchar(64),
   href                 varchar(64),
   primary key (menu_id)
);

/*==============================================================*/
/* Table: special                                               */
/*==============================================================*/
create table special
(
   id                   varchar(128) not null,
   name                 varchar(128),
   author               varchar(128),
   image                varchar(128),
   description          varchar(1024),
   primary key (id)
);

/*==============================================================*/
/* Table: trollimage                                            */
/*==============================================================*/
create table trollimage
(
   id                   varchar(64) not null,
   realname             varchar(64),
   uuidname             varchar(64),
   imgurl               varchar(128),
   description          varchar(1024),
   onstatus             tinyint,
   issave               tinyint,
   uptime               date,
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

alter table frequency add constraint FK_Reference_1 foreign key (special_id)
references special (id) on delete restrict on update restrict;

alter table lesson add constraint FK_Reference_7 foreign key (user_id)
references cuser (user_id) on delete restrict on update restrict;

alter table menu add constraint FK_Reference_6 foreign key (sup_id)
references menu (menu_id) on delete restrict on update restrict;



#角色表
create table if not exists role(
   id int unsigned primary key auto_increment, #角色id
   rolename varchar(64) not null unique,#角色名字
   remark varchar(200)#备注
);


#用户角色表
create table if not exists user_role(
   user_id varchar(64),#用户id
   role_id int unsigned,#角色id
   primary key(user_id,role_id),#主键 用户id 角色id
   foreign key(user_id) references cmanager(cmanager_id),#外键用户id 引用用户表用户id
   foreign key(role_id) references role(id)#外键角色id 引用角色表角色id
);

#日志表
create table if not exists clog(
   id varchar(64) primary key,
   username varchar(64),
   time varchar(64),
   detail varchar(64),
   type varchar(64)
);