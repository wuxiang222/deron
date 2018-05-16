<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>


<script type="text/javascript">
    mytool = [{
        iconCls: 'icon-add',
        handler: function () {
            console.log('新增按钮');
            //显示dialog
            $("#dia").dialog("open");
            //回显数据到子页面的form中：由子页面自己完成
            $("#dia").dialog("refresh");//强制刷新dialog中的数据
        }
    }, '-', {
        iconCls: 'icon-reload',
        handler: function () {
            /* 刷新数据表 */
            $('#dg').datagrid('reload');
        }
    }];

    //dialog的底部按钮
    var btns = [{
        text: "提交",
        handler: function () {
            //验证数据，提交表单，关闭dialog
            $('#ff').form({
                url: '${pageContext.request.contextPath}/trollimage/upload',
                onSubmit: function (data) {
                    return true;
                },
                success: function (data) {
                    $('#table').datagrid('reload');
                }
            });
            $('#ff').submit();
            $('#dia').dialog('close');

        }
    }, {
        text: "取消",
        handler: function () {
            //关闭dialog
            $('#dia').dialog('close');

        }
    }];

    function formatopra() {
        return "<a class='edit' id='settroll'>修改</a>&nbsp&nbsp<a class='remove' id='deltroll'>刪除</a>";
    }


    $(function () {
        $('#settroll').linkbutton({
            iconCls: 'icon-edit',
            onclick: function () {
                alert("aaa");
            }

        });
    });
</script>
</head>
<table id="tt_user"></table>
<table class="easyui-datagrid" id="table"
       data-options="fitColumns:true, striped:true, toolbar:mytool, fixed:true,
						url:'${pageContext.request.contextPath}/trollimage/showTrollImage',
						pagination:true, singleSelect:true">
    <thead>
    <tr>
        <th data-options="field:'realname'">图片名</th>
        <th data-options="field:'imgurl'">文件地址</th>
        <th style="width:100px" data-options="field:'represent'">描述</th>
        <th style="width:100px" data-options="field:'onstatus'">上架状态</th>
        <th style="width:100px" data-options="field:'uptime'">上传时间</th>
        <th style="width:100px" data-options="field:'oper'"
            formatter="formatopra">操作
        </th>
    </tr>
    </thead>
</table>
<div class="easyui-dialog" style="width:300px;height:300px;padding:10px"
     id="dia"
     data-options="title:'修改产品',
  	                   modal:true,
  	                   closed:true,
  	                   href:'${pageContext.request.contextPath}/back/page/sub_dialog_insertTroll.jsp',
  	                   buttons:btns">
</div>
