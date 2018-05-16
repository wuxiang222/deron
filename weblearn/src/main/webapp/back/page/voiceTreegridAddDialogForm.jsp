<%@page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<style type="text/css">
    textarea {
        width: 300px;
        height: 50px;
        resize: none;
    }
</style>
<div>
    <form id="addVoiceForm" method="post" enctype="multipart/form-data">
        <input name="specialID" value="${param.specialID}" hidden/>
        <table>
            <tr>
                <td>专辑名称:</td>
                <td>
                    <input value="${param.name}"/>
                </td>
            </tr>
            <tr>
                <td>音频名称:</td>
                <td>
                    <input name="name"/>
                </td>
            </tr>
            <tr>
                <td>音频上传:</td>
                <td>
                    <input name="file" type="file" accept="vedio/*" multiple/>
                </td>
            </tr>
        </table>
    </form>
</div>
