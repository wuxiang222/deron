<%@page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<style>
    input {
        margin: 3px;
    }
</style>
<script type="text/javascript">
    $(function () {
        //信息加载
        $("#modifyVoiceForm").form("load", "${pageContext.request.contextPath}/voice/queryById?id=" + id);
    });
</script>
<div style="padding: 10px">
    <form id="modifyVoiceForm" method="post">
        <input name="id" hidden/>
        <table>
            <tr>
                <td>原文件名:</td>
                <td>
                    <input name="name"/>
                </td>
            </tr>
        </table>
    </form>
</div>
 