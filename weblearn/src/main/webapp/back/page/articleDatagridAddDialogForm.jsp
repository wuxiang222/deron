<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<form id="ff_addWenzhang" method="post" enctype="multipart/form-data">
    <!--------------单行文本框-------------->
    <div><label>标&nbsp;&nbsp;题 </label>
        <input class="easyui-textbox" type="text" id="descriptio"
               name="caption" data-options="required:true"></input>
    </div>
    <!--------------文件框-------------->
    <div><label>内&nbsp;&nbsp;容</label>
        <input class="easyui-textbox" style="width:400px;height:300px;" type="text" id="description"
               name="content" data-options="required:true, multiline:true"></input>
    </div>
    <!--------------下拉框-------------->
    <div><label>上&nbsp;&nbsp;师 </label>
        <select class="easyui-combobox" id="status"
                name="manageId" style="width:160px;" data-options="panelHeight:50">
            <option value="659df7759fa14fe5aee2ecd46f1f6a41">111111</option>
            <option value="8e4e2ca882054291b79e6da146614dd6">222222</option>
        </select>
    </div>
</form>

