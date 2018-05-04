<%--
  Created by IntelliJ IDEA.
  User: wuxiang
  Date: 2018/4/20
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>轮播图</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap-table.min.css">
    <script src="../assets/js/jquery-1.11.2.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    <script src="../bootstrap/js/bootstrap-table.min.js"></script>
    <script src="../bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
    <script>
        $(function(){
            $("#table").bootstrapTable({        // 对应table标签的id
                url: '../carousel/findAll',     // （*）数据地址， 类型text/json == date:[{},{},{}]
                method: 'get',                  // （*）请求方式
                /*queryParams:"id=3", */            // 参数
                toolbar:"#toolbar",             // （*）关联已定义的工具条
                striped: true,                  // （*）显示条纹显示，默认为false
                pagination: true,               // （*）在表格底部显示分页组件，默认false
                pageNumber:1,                    // 初始化加载第一页，默认第一页
                pageSize:"5",                    // （*）页面数据条数
                pageList: [5, 10, 20, 50],      // （*）设置页面可以显示的数据条数
                search:true,                    // （*）搜索框
                showRefresh:true,               // （*）刷新按钮
                showToggle:true,                // （*）切换视图按钮
                showColumns:true,               // 是否显示内容列下拉框
                showPaginationSwitch:true,      // 分页/不分页按钮
                columns: [
                    {
                        checkbox: true, // 显示一个勾选框
                        align: 'center', // 居中显示
                    }, {
                        field: 'id', // 返回json数据中的name
                        title: '编号', // 表格表头显示文字
                        align: 'center', // 左右居中
                        valign: 'middle' // 上下居中
                    }, {
                        field: 'realname',
                        title: '名称',
                        align: 'center',
                        valign: 'middle'
                    }, {
                        field: 'imgurl',
                        title: 'URL',
                        align: 'center',
                        valign: 'middle',
                    }, {
                        field: 'description',
                        title: '描述',
                        align: 'center',
                        valign: 'middle',
                    }, {
                        field: 'onstatus',
                        title: '状态',
                        align: 'center',
                        valign: 'middle',
                    }, {
                        title: "操作",
                        align: 'center',
                        valign: 'middle',
                        width: 160, // 定义列的宽度，单位为像素px
                        formatter: function (value, row, index) {
                            return '<button class="btn btn-primary btn-sm" onclick="set(\'' + row.stdId + '\')">修改</button>' +
                                    '&nbsp;&nbsp;&nbsp;&nbsp;' +
                                    '<button class="btn btn-danger btn-sm" onclick="del(\'' + row.stdId + '\')">删除</button>';
                        }
                    }
                ],
                onLoadSuccess: function(){  //加载成功时执行
                    console.info("加载成功");
                },
                onLoadError: function(){  //加载失败时执行
                    console.info("加载数据失败");
                }

            })
        });

    </script>
</head>
<body>
<%@include file="navigation.jsp"%>
<%@include file="toolbar.jsp"%>
<table id="table"></table>
</body>
</html>
