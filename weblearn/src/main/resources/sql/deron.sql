#创建表使用的数据库
#use springmvc;
drop table if exists userRole cascade;
drop table if exists roleAuthority cascade;
drop table if exists users cascade;
drop table if exists roles cascade;
drop table if exists authoritys cascade;
drop table if exists menus cascade;
#权限表
create table if not exists authoritys(
    id int unsigned primary key auto_increment,#权限id
    name varchar(24) not null unique,#权限名字
    remark varchar(200) #备注
);
#角色表
create table if not exists roles(
    id int unsigned primary key auto_increment, #角色id
    name varchar(24) not null unique,#角色名字
    remark varchar(200)#备注
);
#角色权限表
create table if not exists roleAuthority(
    role_id int unsigned,#角色id
    authority_id int unsigned,#权限id
    primary key(role_id,authority_id),#主键
    foreign key(role_id) references roles(id),#外键角色id 引用角色表角色id
    foreign key(authority_id) references authoritys(id)#外键权限id 引用权限表权限id
);
#用户表
create table if not exists users(
    id int unsigned primary key auto_increment,#用户id
    name varchar(24) not null unique,#用户名称
    password char(20) not null,#密码
    remark varchar(200)#备注
);
#用户角色表
create table if not exists userRole(
    user_id int unsigned,#用户id
    role_id int unsigned,#角色id
    primary key(user_id,role_id),#主键 用户id 角色id
    foreign key(user_id) references users(id),#外键用户id 引用用户表用户id
    foreign key(role_id) references roles(id)#外键角色id 引用角色表角色id
);
#菜单表
create table if not exists menus(
    id int unsigned primary key auto_increment,#菜单id
    name_ch varchar(100),#中文名字
    name_en varchar(200),#英文名字
    parent_id int unsigned,#父节点id
    order_id int unsigned,#同一父节点下的排序
    menu_auth varchar(200),#菜单对应的权限
    auth_id int unsigned,#权限对应id
    img_url varchar(200)#菜单图片对应的链接
);

#轮播图
drop table if exists carousel cascade;
create table if not exists carousel(
    id int unsigned primary key auto_increment,#轮播图id
    realname VARCHAR(100),#图片名称
    imgurl varchar(200),#图片对应的链接
    description varchar(1024),#描述
    onstatus tinyint #轮播状态
);