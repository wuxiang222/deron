<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<form id="ff_addLunbotu" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>描述:</td>
            <td>
                <input class="easyui-textbox" type="text" id="description" name="description"
                       data-options="required:true"></input>
            </td>
        </tr>
        <tr>
            <td>上传图片:</td>
            <td>
                <input class="easyui-filebox" type="text" id="image_name" name="source" style="width:200px"
                       data-options="required:true,
					   				 buttonText:'上传文件',
					   				 buttonAlign:'right'"></input>
            </td>
        </tr>
        <tr>
            <td>状态:</td>
            <td>
                <select class="easyui-combobox" id="status" name="onstatus" style="width:100px;"
                        data-options="panelHeight:50">
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
            </td>
        </tr>
    </table>
</form>

