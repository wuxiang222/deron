

SELECT * FROM users;
SELECT * FROM carousel;

SELECT * FROM deron.cmanager;

select id, name, password, remark from users where name = 'apple'

SELECT menu_id, menu_name, menu_icon, sup_id, href from menu where sup_id = 100;

select m.id, m.menu_name, m.parent_id, m.order_id, m.auth_id, m.img_url, p.id pid, p.menu_name pmenu_name, p.parent_id pparent_id, p.order_id porder_id, p.auth_id pauth_id, p.img_url pimg_url from menus m INNER JOIN menus p ON m.parent_id = p.id
