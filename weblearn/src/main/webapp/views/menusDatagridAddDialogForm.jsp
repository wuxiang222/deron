<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<style>
    form>div{
        margin-bottom: 5px;
    }
    form>div>label {
        min-width: 80px;
        float: left;
    }
    form>div>label+input {
        float: left;
    }
</style>
<form id="menusAddForm" method="post">
    <%--
    columns: [[
                {field: 'id', title: '编号', width: 50},
                {field: 'menuName', title: '类别名称', width: 200},
                {field: 'parentId', title: '父级编号', width: 100, align: 'right'},
                {field: 'orderId', title: '排序', width: 50, align: 'right'},
                {field: 'authId', title: '授权编号', width: 100, align: 'right'},
                {field: 'imgUrl', title: '图片地址', width: 100, align: 'right', formatter: menus.formatopra}
            ]]
    --%>
        <%--<div><label for="id">编号</label>--%>
            <%--<input class="easyui-textbox" type="text" id="id"--%>
                   <%--name="id" data-options="required:true"></input>--%>
        <%--</div>--%>
        <div><label for="menuName">类别名称</label>
            <input class="easyui-textbox" type="text" id="menuName"
                   name="menuName" data-options="required:true"></input>
        </div>
        <div><label for="parentId">父级编号</label>
            <input class="easyui-textbox" type="text" id="parentId"
                   name="parent.id" data-options=""></input>
        </div>
        <div><label for="orderId">排序</label>
            <input class="easyui-textbox" type="text" id="orderId"
                   name="orderId" data-options=""></input>
        </div>
        <div><label for="authId">授权编号</label>
            <input class="easyui-textbox" type="text" id="authId"
                   name="authId" data-options=""></input>
        </div>
        <div><label for="imgUrl">图片地址 </label>
            <input class="easyui-textbox" type="text" id="imgUrl"
                   name="imgUrl" data-options=""></input>
        </div>
</form>


