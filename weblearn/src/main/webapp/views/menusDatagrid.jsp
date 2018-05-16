<%--
  Created by IntelliJ IDEA.
  User: wuxiang
  Date: 2018/5/12
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    var menus = {
        datagrid : {
            selectedRow : null,
            onSelect : function(index, row){
                menus.datagrid.selectedRow = row;
            },
            init : function(){
                $('#menusDatagrid').datagrid({
                    url: '${pageContext.request.contextPath}/menus',
                    method: 'get',
                    striped: true,
                    toolbar: menus.datagrid.toolbar,
                    fitColumns: true,
                    fit:true,
                    fixed: true,
                    pagination: true,
                    pageList: [10, 20, 50],
                    pageSize: 10,
                    pageNumber: 1,
                    singleSelect: true,
                    onSelect:menus.datagrid.onSelect,
                    onLoadSuccess: menus.datagrid.onLoadSuccess,
                    columns: [[
                        {field: 'id', title: '编号', width: 30, align: 'center', editor:{type:'text',options:{}}},
                        {field: 'menuName', title: '类别名称', width: 50, align: 'center'},
                        {field: 'parent.id', title: '父级编号', width: 50, align: 'center',formatter:function(value,row,index){
                            if(row.parent){
                                return row.parent.id;
                            } else {
                                return '-';
                            }
                        }},
                        {field: 'orderId', title: '排序', width: 50, align: 'center'},
                        {field: 'authId', title: '授权编号', width: 50, align: 'center'},
                        {field: 'imgUrl', title: '图片地址', width: 100, align: 'center', formatter: menus.formatopra},
                        {field: 'do', title: '操作', width: 50, align: 'center', formatter: this.formatopra}
                    ]]
                })
            },
            toolbar: [{
                iconCls: 'icon-add', // 添加按钮
                handler: function () {
                    menus.addDialog.init();
                }
            }, '-', {
                iconCls: 'icon-reload', // 刷新按钮
                handler: function () {
                    /* 刷新数据表 */
                    $('#menusDatagrid').datagrid('reload');
                }
            },{
                text:"新加一行",
                handler: function(){
                    $('#menusDatagrid').datagrid('insertRow',{
                        index:0,
                        row:{
                            id:999,
                            menuName:'sssss',
                            parent:{id:1},
                            orderId:999,
                            authId:999,
                            imgUrl:'kong.com,'
                        },
                        });
                    menus.datagrid.onLoadSuccess();
                    $('#menusDatagrid').datagrid('beginEdit',0)
                }
            }],/* 数据表格的工具条按钮toolbar设置 */
            formatopra : function(value, row, index) { // 格式化操作列函数
                return "<a class='edit' onclick='menus.datagrid.edit()'>编辑</a>&nbsp&nbsp" +
                    "<a class='remove' disabled=true onclick='menus.datagrid.remove(\"" + row.id + "\")'>刪除</a>";
            },/* 将数据表格中的字段，格式化成两个超链接 */
            edit:function (){
                menus.editDialog.init();
            },/* 打开编辑对话框 */
            remove: function (value) {    // 删除函数
                $.ajax({
                    type:'DELETE',
                    url:'${pageContext.request.contextPath}/menus/'+value,
                    success:function (data) {
                        $('#menusDatagrid').datagrid('reload');    // 刷新
                    }
                });
            },/* 删除 */
            onLoadSuccess:function () { // 将编辑，删除设为linkbutton按钮函数
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
            },/* 当数据加载成功的时候触发该函数，将数据表格中格式化出的超链接，转换为easyui的按钮  */
        },

        addDialog: {
            init : function(){
                $('#menusAddDialog').dialog({
                    title: '添加类别',
                    modal: true,
                    href: '${pageContext.request.contextPath}/views/menusDatagridAddDialogForm.jsp',
                    buttons: menus.addDialog.buttons
                });
            },
            buttons: [{
                text: "提交",
                handler: function () {
                    //验证数据，提交表单，关闭dialog
                    $("#menusAddForm").form('submit', {
                        method:"POST",
                        url: "${pageContext.request.contextPath}/menus",
                        onSubmit: function () {
                            return $("#menusAddForm").form("validate");
                        },
                        success: function () {
                            $("#menusAddForm").form('clear');
                            $("#menusDatagrid").datagrid('reload');
                            $("#menusAddDialog").dialog('close');
                        },
                    });

                }
            }, {
                text: "取消",
                handler: function () {
                    //关闭dialog
                    $("#menusAddDialog").dialog('close');
                }
            }],/* dialog的底部按钮 */
        },

        editDialog: {
            init : function(){
                $('#menusEditDialog').dialog({
                    title: '编辑类别',
                    modal: true,
                    href: '${pageContext.request.contextPath}/views/menusDatagridEditDialogForm.jsp?row=',
                    buttons: menus.editDialog.buttons
                });
            },
            buttons: [{
                text: "提交",
                handler: function () {
                    //验证数据，提交表单，关闭dialog
                    $('#menusEditForm').form('submit',{
                        contentType: 'application/json',
                        url: "${pageContext.request.contextPath}/menus",
                        dataType: "json",
                        onSubmit: function () {
                            return $("#menusEditForm").form("validate");
                        },
                        success: function () {
                            $("#menusEditForm").form('clear');
                            $("#menusDatagrid").datagrid('reload');
                            $("#menusEditDialog").dialog('close');
                        }
                    });
                    $('#menusEditDialog').dialog('close');
                }
            }, {
                text: "取消",
                handler: function () {
                    //关闭dialog
                    $('#menusEditDialog').dialog('close');
                }
            }],/* dialog的底部按钮 */
        }
    }


    $(function () {
        menus.datagrid.init();
    });/* 初始化 */
</script>

<!-- 数据表格组件 -->
<table id="menusDatagrid" style="height: 50%;"></table>
<!-- 添加对话框 -->
<div id="menusAddDialog" style="width:300px;height:300px;padding:10px"></div>
<!-- 编辑对话框 -->
<div id="menusEditDialog" style="width:300px;height:300px;padding:10px"></div>
