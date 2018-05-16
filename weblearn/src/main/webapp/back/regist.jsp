<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="icon" href="${pageContext.request.contextPath}/back/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/login.css" type="text/css"></link>
    <script src="${pageContext.request.contextPath}/back/script/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/back/script/common.js"></script>

    <script type="text/javascript">
        $(function () {
            //点击更换验证码：
            $("#captchaImage").click(function () {//点击更换验证码
                $(this).attr('src', '${pageContext.request.contextPath}/cmanager/enCode');
            });

            //  form 表单提交
            $("#registForm").bind("submit", function () {
                /* alert("自己做"); */
                //	return false;
            });

        });
    </script>
</head>

<body class="easyui-layout">
<div class="login">
    <form id="registForm" action="${pageContext.request.contextPath}/cmanager/regist" method="post">

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="${pageContext.request.contextPath}/back/img/header_logo.gif" alt="购物"/>
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input type="text" name="username" class="text" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" name="password" class="text" maxlength="20" autocomplete="off"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage" style="width:100px;height:30px;"
                         src="${pageContext.request.contextPath}/cmanager/enCode" title="点击更换验证码"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="regist();"><input type="submit"
                                                                                                class="loginButton"
                                                                                                value="注册">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="powered">COPYRIGHT © 2005-2013.</div>
        <div class="link">
            <a href="">前台首页</a> |
            <a href="">官方网站</a> |
            <a href="">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>
