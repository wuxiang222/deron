<%--
  Created by IntelliJ IDEA.
  User: wuxiang
  Date: 2018/5/15
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<form id="noteAddDialogForm" method="post">
    <%--
        id INT(10) primary key AUTO_INCREMENT,
        title VARCHAR(64) null,
        content VARCHAR(2048) null,
        typeid INT UNSIGNED,
        foreign key(typeid) references menus(id)
    --%>
    <%--<div><label for="id">编号</label>--%>
    <%--<input class="easyui-textbox" type="text" id="id"--%>
    <%--name="id" data-options="required:true"></input>--%>
    <%--</div>--%>
    <div><label for="title">笔记标题</label>
        <input class="easyui-textbox" type="text" id="title"
               name="title" data-options="required:true"></input>
    </div>
    <div><label for="content">笔记内容</label>
        <input class="easyui-textbox" type="text" id="content"
               name="content" data-options="multiline:true,width:300,height:200,required:true"></input>
    </div>
    <div><label for="menuId">笔记类别</label>
        <input class="easyui-textbox" type="text" id="menuId"
               name="menuId" data-options=""></input>
    </div>
</form>
