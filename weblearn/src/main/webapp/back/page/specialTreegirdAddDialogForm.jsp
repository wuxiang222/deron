<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<style type="text/css">
    textarea {
        width: 300px;
        height: 50px;
        resize: none;
    }
</style>
<div>
    <form id="addSpecialForm" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>专辑名称:</td>
                <td>
                    <input class="easyui-text" name="name"/>
                </td>
            </tr>
            <tr>
                <td>作&nbsp;&nbsp;者:</td>
                <td>
                    <input name="author"/>
                </td>
            </tr>
            <tr>
                <td>播&nbsp;&nbsp;音:</td>
                <td>
                    <input name="broadcast"/>
                </td>
            </tr>
            <tr>
                <td>专辑封面:</td>
                <td>
                    <input name="file" type="file" accept="image/*" multiple/>
                </td>
            </tr>
            <tr>
                <td>专辑介绍:</td>
                <td>
                    <textarea name="content"></textarea>
                </td>
            </tr>
        </table>
    </form>
</div>
