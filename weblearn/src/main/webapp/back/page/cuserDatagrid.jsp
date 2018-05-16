<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    mytool = [{
        iconCls: 'icon-add', // 添加按钮
        handler: function () {
            $("#dd_addLunbotu").dialog("open"); //显示dialog
            //回显数据到子页面的form中：由子页面自己完成
            $("#dd_addLunbotu").dialog("refresh");//强制刷新dialog中的数据
        }
    }, '-', {
        iconCls: 'icon-reload', // 刷新按钮
        handler: function () {
            /* 刷新数据表 */
            $('#dg_Lunbotu').datagrid('reload');
        }
    }];

    //dialog的底部按钮
    var btns_add = [{
        text: "提交",
        handler: function () {
            //验证数据，提交表单，关闭dialog
            $("#ff_addLunbotu").form('submit', {
                url: "${pageContext.request.contextPath}/cuser/show",
                onSubmit: function () {
                    console.log($("#ff_addBanner").form("validate"));
                    return $("#ff_addBanner").form("validate");
                },
                success: function () {
                    $("#ff_addBanner").form('clear');
                    $("#dg_Lunbotu").datagrid('reload');
                    $("#dd_addLunbotu").dialog('close');
                }
            });

        }
    }, {
        text: "取消",
        handler: function () {
            //关闭dialog
            $('#dia').dialog('close');

        }
    }];


    var btns_set = [{
        text: "提交",
        handler: function () {
            //验证数据，提交表单，关闭dialog
            $("#ff_setLunbotu").form('submit', {
                url: "${pageContext.request.contextPath}/cuser/show",
                onSubmit: function () {
                    console.log($("#ff_setBanner").form("validate"));
                    return $("#ff_setBanner").form("validate");
                },
                success: function () {
                    $("#ff_setBanner").form('clear');
                    $("#dg_Lunbotu").datagrid('reload');
                    $("#dd_setLunbotu").dialog('close');
                }
            });

        }
    }, {
        text: "取消",
        handler: function () {
            //关闭dialog
            $('#dd_setLunbotu').dialog('close');

        }
    }];


    function setTroll(row) {    // 编辑函数
        console.log(row);
        //var aa = $('#dg_Lunbotu').datagrid('getSelected');

        $("#dd_setLunbotu").dialog("open"); //显示dialog

    }

    function delTroll(value) {    // 删除函数
        $.post("${pageContext.request.contextPath}/cuser/remove",
            "id=" + value, function (data) {
                $('#dg_Lunbotu').datagrid('reload');    // 刷新
            }, "json");
    }

    function formatopra(value, row, index) { // 格式化操作列函数
        return "<a class='edit' onclick='setTroll(\"" + row + "\")'>编辑</a>&nbsp&nbsp<a class='remove' onclick='delTroll(\"" + value + "\")'>刪除</a>";
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
        $('#dg_cuser').datagrid({
            url: '${pageContext.request.contextPath}/cuser/show',
            striped: true,
            toolbar: mytool,
            fitColumns: true,
            fixed: true,
            pagination: true,
            singleSelect: true,
            onLoadSuccess: addCss,
            columns: [[
                {field: 'user_id', title: '用户id', width: 50},
                {field: 'cmanage_id', title: '上师id', width: 200},
                {field: 'username', title: '用户名', width: 100, align: 'right'},
                {field: 'onstatus', title: 'xxxx', width: 50, align: 'right'},
                {field: 'uptime', title: '上传时间', width: 100, align: 'right'},
                {field: 'id', title: '操作', width: 100, align: 'right', formatter: formatopra}
            ]]
        });

        $('#dd_addCuser').dialog({
            title: '添加用户',
            modal: true,
            closed: true,
            href: '${pageContext.request.contextPath}/back/page/cuserAddDialog.jsp',
            buttons: btns_add
        });

        $('#dd_setCuser').dialog({
            title: '编辑用户',
            modal: true,
            closed: true,
            href: '${pageContext.request.contextPath}/back/page/cuserEditDialogForm.jsp',
            buttons: btns_set
        });
    });
</script>

<!-- 数据表格组件 -->
<table id="dg_cuser"></table>

<!-- 添加对话框 -->
<div id="dd_addCuser" style="width:300px;height:300px;padding:10px"></div>
<!-- 编辑对话框 -->
<div id="dd_setCuser" style="width:300px;height:300px;padding:10px"></div>
