<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<form id="ff_addLunbotu" method="post" enctype="multipart/form-data">
    <!--------------单行文本框-------------->
    <div><label>描&nbsp;&nbsp;述 </label>
        <input class="easyui-textbox" type="text" id="description"
               name="description" data-options="required:true"></input>
    </div>
    <!--------------文件框-------------->
    <div><label>上传文件</label>
        <input class="easyui-filebox" data-options="buttonText:'选择文件', buttonAlign:'left', required:true">
    </div>
    <!--------------下拉框-------------->
    <div><label>是否展示 </label>
        <select class="easyui-combobox" id="status"
                name="onstatus" style="width:160px;" data-options="panelHeight:50">
            <option value="true">true</option>
            <option value="false">false</option>
        </select>
    </div>
</form>

