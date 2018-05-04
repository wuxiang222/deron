
insert into menu values('100', '100', '100', null, null);
insert into menu values('101', '轮播图', 'icon-ok', '100', null);
insert into menu values('102', '吉祥妙音', 'icon-ok', '100', null);
insert into menu values('103', '甘露妙宝', 'icon-ok', '100', null);
insert into menu values('104', '功课记录', 'icon-ok', '100', null);
insert into menu values('105', '计数器模块', 'icon-ok', '100', null);
insert into menu values('106', '日志模块', 'icon-ok', '100', null);

insert into menu values('1011', '轮播图', 'icon-ok', '101', 'lunbotu.jsp');
insert into menu values('1021', '专辑管理', 'icon-ok', '102', 'zhuanji.jsp');
insert into menu values('1031', '上师展示', 'icon-ok', '103', 'shangshi.jsp');
insert into menu values('1041', '展示功课', 'icon-ok', '104', 'gongke.jsp');
insert into menu values('1042', '用户管理', 'icon-ok', '104', 'yonghu.jsp');
insert into menu values('1051', '计数器', 'icon-ok', '105', 'jishuqi.jsp');
insert into menu values('1061', '日志管理', 'icon-ok', '106', 'rizhi.jsp');
select * from menu;

select m.menu_id menu_id, m.menu_name menu_name, m.menu_icon menu_icon, m.href href, s.menu_id smenu_id, s.menu_name smenu_name, s.menu_icon smenu_icon, s.href href
			from menu m inner join menu s on m.menu_id = s.sup_id
			where m.sup_id = 100;

	
select * from trolling where issave=true;
update trolling set issave=true where id='112';
select id, realname, uuidname, imgurl, description, onstatus, issave, uptime
		from trolling 
		where issave=true
		limit 0,3;

desc special;
desc voice;
	
select * from special;
select * from voice;
select * from manager;
select * from user;
select * from clog;

desc user;

insert into user values('xxxxx','dc41f5f0-2e03-4d75-a5a3-c0abd863ed4b','111111','111111');
	select user_id,
		manager_id,
		username, password
		from user
		limit 0, 3;

select user_id,
		manager_id,
		username, password
		from user
		where username='wusdine' and password='111111';	
