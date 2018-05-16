<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    /* 数据表格的工具条按钮toolba设置 */
    mytool = [{
        iconCls: 'icon-add', // 添加按钮
        handler: function () {
            $("#dd_addLunbotu").dialog("open").dialog("refresh"); //显示dialog
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
                url: "${pageContext.request.contextPath}/trollimage/upload",
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
            $("#dd_addLunbotu").dialog('close');

        }
    }];


    var btns_set = [{
        text: "提交",
        handler: function () {
            //验证数据，提交表单，关闭dialog
            $("#ff_setLunbotu").form('submit', {
                url: "${pageContext.request.contextPath}/trollimage/setTrollImage",
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


    /* 数据表格的id字段，格式化出超链接的单击事件单数 */
    function setTroll(row) {    // 编辑函数
        console.log(row);
        //var aa = $('#dg_Lunbotu').datagrid('getSelected');

        $("#dd_setLunbotu").dialog("open"); //显示dialog

    }
    /* 数据表格的id字段，格式化出超链接的单击事件单数 */
    function delTroll(value) {    // 删除函数
        $.post("${pageContext.request.contextPath}/trollimage/delTrollImage",
            "id=" + value, function (data) {
                $('#dg_Lunbotu').datagrid('reload');    // 刷新
            }, "json");
    }
    /* 将数据表格中的id字段，格式化成两个超链接 */
    function formatopra(value, row, index) { // 格式化操作列函数
        return "<a class='edit' onclick='setTroll(\"" + row + "\")'>编辑</a>&nbsp&nbsp<a class='remove' onclick='delTroll(\"" + value + "\")'>刪除</a>";
    }
    /* 当数据加载成功的时候触发该函数，将数据表格中格式化出的超链接，转换为easyui的按钮  */
    function addCss() { // 将编辑，删除设为linkbutton按钮函数
        $('a.edit').linkbutton(
            {
                plain: true,
                iconCls: 'icon-edit',
            }
        );
        $('a.remove').linkbutton(          // 删除按钮
            {
                plain: true,
                iconCls: 'icon-remove',
            }
        );
    }
    /* 使用js将文档中的table标签创建成为easyui数据表格 */
    $(function () {
        $('#dg_Lunbotu').datagrid({
            url: '${pageContext.request.contextPath}/trollimage/showTrollImage',
            title: '自定义标题栏',
            striped: true,
            toolbar: mytool,
            fitColumns: true,
            fixed: true,
            pagination: true,
            pageList: [10, 20, 50],
            pageSize: 5,
            pageNumber: 1,
            singleSelect: true,
            onLoadSuccess: addCss,
            columns: [[
                {field: 'realname', title: '图片名', width: 50},
                {field: 'imgurl', title: '文件地址', width: 200},
                {field: 'description', title: '描述', width: 100, align: 'right'},
                {field: 'onstatus', title: '上架状态', width: 50, align: 'right'},
                {field: 'uptime', title: '上传时间', width: 100, align: 'right'},
                {field: 'id', title: '操作', width: 100, align: 'right', formatter: formatopra}
            ]]
        });

        $('#dd_addLunbotu').dialog({
            title: '添加轮播图',
            modal: true,
            closed: true,
            href: '${pageContext.request.contextPath}/back/page/trollimageAddDialogForm.jsp',
            buttons: btns_add
        });

        $('#dd_setLunbotu').dialog({
            title: '编辑轮播图',
            modal: true,
            closed: true,
            href: '${pageContext.request.contextPath}/back/page/trollimageEditDialogForm.jsp',
            buttons: btns_set
        });
    });
</script>

<!-- 数据表格组件 -->
<table id="dg_Lunbotu"></table>

<!-- 添加对话框 -->
<div id="dd_addLunbotu" style="width:300px;height:300px;padding:10px"></div>
<!-- 编辑对话框 -->
<div id="dd_setLunbotu" style="width:300px;height:300px;padding:10px"></div>
