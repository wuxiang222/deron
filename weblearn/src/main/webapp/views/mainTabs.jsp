<%--
  Created by IntelliJ IDEA.
  User: wuxiang
  Date: 2018/5/12
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Menus</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        function showTab(title, iconCls, href) {
            var isexists = $('#tt_tabs').tabs('exists', title);
            if (isexists) {
                $('#tt_tabs').tabs('select', title);
                /* tabs选择存在面板 */
            } else {
                $('#tt_tabs').tabs('add', {
                    title: title,
                    iconCls: iconCls,
                    href: href,
                    selected: true,
                    closable: true
                });/* tabs增加新面板 */
            }
        }/* 定义accordion内部linkbutton的单击事件函数，显示对应选项卡面板 */

        $(function(){
            showTab("menus","icon-ok","menusDatagrid.jsp")
        });
    </script>
</head>
<body>
<div id="tt_tabs" class="easyui-tabs"
     data-options="fit:true,narrow:true,pill:true">

</div>
</body>
</html>
