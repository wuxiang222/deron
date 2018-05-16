<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
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
<form id="menusEditForm" method="post">
    <input type="hidden" name="_method" value="put">
    <div><label for="id">编号</label>
        <input class="easyui-textbox" type="text" id="id" readonly
               name="id" data-options="required:true"></input>
    </div>
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

<script type="text/javascript">
    $('#id').val(menus.datagrid.selectedRow.id)
    $('#menuName').val(menus.datagrid.selectedRow.menuName)
    if (menus.datagrid.selectedRow.parent){
        $('#parentId').val(menus.datagrid.selectedRow.parent.id)
    }
    $('#orderId').val(menus.datagrid.selectedRow.orderId)
    $('#authId').val(menus.datagrid.selectedRow.authId)
    $('#imgUrl').val(menus.datagrid.selectedRow.imgUrl)
</script>


