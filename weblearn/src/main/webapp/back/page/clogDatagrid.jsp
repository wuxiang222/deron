<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    mytool = [{
        iconCls: 'icon-add', // 添加按钮
        handler: function () {
            $("#dd_addClog").dialog("open").dialog("refresh"); //显示dialog
        }
    }, '-', {
        iconCls: 'icon-reload', // 刷新按钮
        handler: function () {
            /* 刷新数据表 */
            $('#dg_Clog').datagrid('reload');
        }
    }];

    //dialog的底部按钮
    var btns_add = [{
        text: "提交",
        handler: function () {
            //验证数据，提交表单，关闭dialog
            $("#ff_addClog").form('submit', {
                url: "${pageContext.request.contextPath}/trollimage/upload",
                onSubmit: function () {
                    return $("#ff_addBanner").form("validate");
                },
                success: function () {
                    $("#ff_addBanner").form('clear');
                    $("#dg_Clog").datagrid('reload');
                    $("#dd_addClog").dialog('close');
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
            $("#ff_setClog").form('submit', {
                url: "${pageContext.request.contextPath}/trollimage/setTrollImage",
                onSubmit: function () {
                    return $("#ff_setBanner").form("validate");
                },
                success: function () {
                    $("#ff_setBanner").form('clear');
                    $("#dg_Clog").datagrid('reload');
                    $("#dd_setClog").dialog('close');
                }
            });

        }
    }, {
        text: "取消",
        handler: function () {
            //关闭dialog
            $('#dd_setClog').dialog('close');

        }
    }];

    function addCss() { // 将编辑，删除设为linkbutton按钮函数
        $('a.edit').linkbutton(
            {
                plain: true,
                iconCls: 'icon-edit'
            });
        $('a.remove').linkbutton(          // 删除按钮
            {
                plain: true,
                iconCls: 'icon-remove'
            });
    }

    $(function () {
        $('#dg_Clog').datagrid({
            url: '${pageContext.request.contextPath}/clog/show',
            striped: true,
            toolbar: mytool,
            fitColumns: true,
            pagination: true,
            singleSelect: true,
            onLoadSuccess: addCss,
            columns: [[
                {field: 'id', title: '编号', width: 50},
                {field: 'username', title: '用户名', width: 200},
                {field: 'detail', title: '时间', width: 100, align: 'right'},
                {field: 'type', title: '类型', width: 50, align: 'right'}
            ]]
        });

        $('#dd_addClog').dialog({
            title: '',
            modal: true,
            closed: true,
            //href:'${pageContext.request.contextPath}/back/page/dialogAddClog.jsp',
            buttons: btns_add
        });

        $('#dd_setClog').dialog({
            title: '编辑轮播图',
            modal: true,
            closed: true,
            //href:'${pageContext.request.contextPath}/back/page/dialogSetClog.jsp',
            buttons: btns_set
        });
    });
</script>

<!-- 数据表格组件 -->
<table id="dg_Clog"></table>

<!-- 添加对话框 -->
<div id="dd_addClog" style="width:300px;height:300px;padding:10px"></div>
<!-- 编辑对话框 -->
<div id="dd_setClog" style="width:300px;height:300px;padding:10px"></div>
