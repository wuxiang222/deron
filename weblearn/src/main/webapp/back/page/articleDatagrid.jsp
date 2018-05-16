<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    mytool = [{
        iconCls: 'icon-add', // 添加按钮
        handler: function () {
            $("#dd_addWenzhang").dialog("open"); //显示dialog
            //回显数据到子页面的form中：由子页面自己完成
            $("#dd_addWenzhang").dialog("refresh");//强制刷新dialog中的数据
        }
    }, '-', {
        iconCls: 'icon-reload', // 刷新按钮
        handler: function () {
            /* 刷新数据表 */
            $('#dg_Wenzhang').datagrid('reload');
        }
    }];

    /* dialog的底部按钮 */
    var btns_add = [{
        text: "提交",
        handler: function () {
            //验证数据，提交表单，关闭dialog
            $("#ff_addWenzhang").form('submit', {
                url: "${pageContext.request.contextPath}/article/insertArticle",
                onSubmit: function () {
                    console.log($("#ff_addWenzhang").form("validate"));
                    return $("#ff_addWenzhang").form("validate");
                },
                success: function () {
                    $("#ff_addWenzhang").form('clear');
                    $("#dg_Wenzhang").datagrid('reload');
                    $("#dd_addWenzhang").dialog('close');
                }
            });

        }
    }, {
        text: "取消",
        handler: function () {
            //关闭dialog
            $("#dd_addWenzhang").dialog('close');

        }
    }];


    var btns_set = [{
        text: "提交",
        handler: function () {
            //验证数据，提交表单，关闭dialog
            $("#ff_setWenzhang").form('submit', {
                url: "${pageContext.request.contextPath}/trollimage/setWenzhangImage",
                onSubmit: function () {
                    console.log($("#ff_setBanner").form("validate"));
                    return $("#ff_setBanner").form("validate");
                },
                success: function () {
                    $("#ff_setBanner").form('clear');
                    $("#dg_Wenzhang").datagrid('reload');
                    $("#dd_setWenzhang").dialog('close');
                }
            });

        }
    }, {
        text: "取消",
        handler: function () {
            //关闭dialog
            $('#dd_setWenzhang').dialog('close');

        }
    }];


    function setWenzhang(row) {    // 编辑函数
        console.log(row);
        //var aa = $('#dg_Wenzhang').datagrid('getSelected');

        $("#dd_setWenzhang").dialog("open"); //显示dialog

    }

    function delWenzhang(value) {    // 删除函数
        $.post("${pageContext.request.contextPath}/article/removeArticle", "id=" + value, function (data) {
            $('#dg_Wenzhang').datagrid('reload');    // 刷新
        }, "json");
    }

    function formatopra(value, row, index) { // 格式化操作列函数
        return "<a class='edit' onclick='setWenzhang(\"" + row + "\")'>编辑</a>&nbsp&nbsp<a class='remove' onclick='delWenzhang(\"" + value + "\")'>刪除</a>";
    }

    function addCss() { // 将编辑，删除设为linkbutton按钮函数
        $('a.edit').linkbutton(
            {
                plain: true,
                iconCls: 'icon-edit',
            });
        $('a.remove').linkbutton(          // 删除按钮
            {
                plain: true,
                iconCls: 'icon-remove',
            });
    }

    $(function () {
        $('#dg_Wenzhang').datagrid({
            url: '${pageContext.request.contextPath}/article/showAll',
            striped: true,
            toolbar: mytool,
            fitColumns: true,
            fixed: false,
            pagination: true,
            singleSelect: true,
            onLoadSuccess: addCss,
            columns: [[
                {field: 'caption', title: '标题', width: 50},
                {field: 'content', title: '内容', width: 500},
                {field: 'manageId', title: '作者', width: 50},
                {field: 'id', title: '操作', width: 100, align: 'right', formatter: formatopra}
            ]]
        });

        $('#dd_addWenzhang').dialog({
            title: '添加文章',
            modal: true,
            closed: true,
            href: '${pageContext.request.contextPath}/back/page/articleAddDialogForm.jsp',
            buttons: btns_add
        });

        $('#dd_setWenzhang').dialog({
            title: '编辑文章',
            modal: true,
            closed: true,
            href: '${pageContext.request.contextPath}/back/page/articleEditDialogForm.jsp',
            buttons: btns_set
        });
    });
</script>

<!-- 数据表格组件 -->
<table id="dg_Wenzhang"></table>

<!-- 添加对话框 -->
<!-- <div id="dd_addWenzhang" style="width:300px;height:300px;padding:10px"></div> -->
<div id="dd_addWenzhang" style="width:500px;height:400px;padding:10px"></div>


<!-- 编辑对话框 -->
<div id="dd_setWenzhang" style="width:300px;height:300px;padding:10px"></div>
