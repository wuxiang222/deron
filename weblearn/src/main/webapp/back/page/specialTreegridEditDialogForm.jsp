<%@page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<style>
    input {
        margin: 3px;
    }

    textarea {
        width: 300px;
        height: 50px;
        resize: none;
    }
</style>
<script type="text/javascript">
    $(function () {
        //信息加载
        $("#modifySpecialForm").form("load", "${pageContext.request.contextPath}/special/queryOne/" + id);
    });
</script>
<div style="padding: 10px">
    <form id="modifySpecialForm" method="post">
        <input name="id" hidden/>
        <table>
            <tr>
                <td>原文件名:</td>
                <td><input name="name"/></td>
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
                <td>描&nbsp;&nbsp;述:</td>
                <td>
                    <textarea name="content"></textarea>
                </td>
            </tr>
        </table>
    </form>
</div>