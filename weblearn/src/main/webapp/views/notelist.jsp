<%--
  Created by IntelliJ IDEA.
  User: wuxiang
  Date: 2018/5/14
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Note</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/ulist-wx.js"></script>
</head>
<body>



<div id="layout" class="easyui-layout" style="width: 600px; height: 400px" data-options="fit:true">
    <div data-options="region:'east'" style="width:40%;border:1px solid black">

    </div>
    <div data-options="region:'center'" style="border:1px solid black;">

        <div id="box" style="display: flex; flex-direction: column;flex-wrap: wrap; height:550px;" >
            <!-- js添加<ul><li> -->
        </div>
        <a id="addButton" class="easyui-linkbutton" style="display: block;">增加</a>
    </div>
</div>

<div id="noteAddDialog" style="width: 400px; height: 400px;" ></div>
<script>
    var noteAddDialog = {
        init : function(){
            $('#noteAddDialog').dialog({
                title: '添加笔记',
                modal: true,
                href: '${pageContext.request.contextPath}/views/noteAddDialogForm.jsp',
                buttons: noteAddDialog.buttons
            });
        },
        buttons: [{
            text: "提交",
            handler: function () {
                //验证数据，提交表单，关闭dialog
                $("#noteAddDialogForm").form('submit', {
                    method:"POST",
                    url: "${pageContext.request.contextPath}/note",
                    onSubmit: function () {
                        return $("#noteAddDialogForm").form("validate");
                    },
                    success: function () {
                        $("#noteAddDialogForm").form('clear');
                        $('#box').ulist({
                            url:'${pageContext.request.contextPath}/allNote'
                        });
                        $("#noteAddDialog").dialog('close');
                    },
                });

            }
        }, {
            text: "取消",
            handler: function () {
                //关闭dialog
                $("#noteAddDialog").dialog('close');
            }
        }],/* dialog的底部按钮 */
    }
    $('#addButton').click(function () {
        noteAddDialog.init();
    })
    $('#box').ulist({
        url:'${pageContext.request.contextPath}/allNote'
    })
</script>
</body>
</html>
