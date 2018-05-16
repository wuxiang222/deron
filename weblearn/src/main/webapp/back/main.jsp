<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>佛坛主页</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript">
        function showTab(title, iconCls, href) {
            console.log(href);
            var isexists = $('#tt_tabs').tabs('exists', title);
            if (isexists) {
                $('#tt_tabs').tabs('select', title);
                /* tabs选择存在面板 */
            } else {
                $('#tt_tabs').tabs('add', {
                    title: title,
                    iconCls: iconCls,
                    href: '${pageContext.request.contextPath}/back/page/' + href,
                    selected: true,
                    closable: true
                });/* tabs增加新面板 */
            }
        }/* 定义accordion内部linkbutton的单击事件函数，显示对应选项卡面板 */

        $(function () {
            $.post("${pageContext.request.contextPath}/menu/showMenu", "menuId=100",
                function (data) {
                    /* 遍历菜单集合,将子菜单封装成linkbutton,再放入accordion内部新面板 */
                    $.each(data, function (index, obj) {
                        var content = "";
                        /* 遍历子菜单 */
                        $.each(obj.children, function (i, o) {
                            content += "<a onclick='showTab(\"" + o.menu_name + "\",\"" + o.menu_icon + "\",\"" + o.href + "\")' class='easyui-linkbutton' style='width:100%' data-options='iconCls:\"" + o.menu_icon + "\"'>" + o.menu_name + "</a>";
                        });
                        /* 构件linkbutton元素 */
                        $('#accordion').accordion('add', {
                            title: obj.menu_name,
                            iconCls: obj.menu_icon,
                            content: content,
                            selected: false
                        });/* accordion增加新面板，面板主体内容是linkbutton */
                    });
                }, "json");
        });/* 初始化左侧导航,获取menu数据，增加面板 */
    </script><%-- 初始化左侧导航accordion --%>
</head>

<body class="easyui-layout">
<div data-options="region:'north',split:true"
     style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        <shiro:hasRole name="superAdmin">佛坛后台管理系统</shiro:hasRole>
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: auto;float:right;padding-top:15px">
        欢迎您:<shiro:principal/>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>
        <a href="${pageContext.request.contextPath}/user/logout" class="easyui-linkbutton"
           data-options="iconCls:'icon-01'">退出系统</a>
    </div>
</div><%-- 头部linkbutton --%>

<div style="width:220px;" data-options="region:'west',title:'导航菜单',split:true">
    <div id="accordion" class="easyui-accordion" data-options="fit:true">
    </div>
</div><%-- 左侧导航accordion --%>

<div data-options="region:'center'">
    <div id="tt_tabs" class="easyui-tabs"
         data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526367533&di=b8cd9e89afc0ae760d0180207a966743&imgtype=jpg&er=1&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fd1160924ab18972be72d96eeeccd7b899e510afa.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div><%-- 中部tabs --%>


<div data-options="region:'south',split:true"
     style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;baizhi
    </div>
</div><%-- 底部 --%>

</body><%-- 布局，定义区块内容--%>
</html>
