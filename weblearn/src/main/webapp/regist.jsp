<%--
  Created by IntelliJ IDEA.
  User: wuxiang
  Date: 2018/4/18
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <style>
        #container {
            width: 500px;
            height: 300px;
            margin: 100px auto 0;
            background-color: #ede;
            padding: 40px 10px;
        }
    </style>
    <script src="assets/js/jquery-1.11.2.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="views/navigation.jsp"%>
<div id="container">
    <form id="loginForm" action="${pageContext.request.contextPath}/user/regist" method="post">
        <h2 class="text-center">注册</h2>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="name" placeholder="请输入名称">
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" placeholder="请输入密码">
            </div>
        </div>

        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">验证码</label>
            <div class="col-sm-5">
                <input type="text" name="captcha" class="form-control" placeholder="请输入验证码" maxlength="4"
                       autocomplete="off">
            </div>
            <div class="col-sm-4">
                <img id="captchaImage" class="captchaImage" style="width: 100%;"
                     src="${pageContext.request.contextPath}/captcha"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-info btn-block">提交</button>
            </div>
        </div>
    </form>
</div>
<script>
    $(function () {
        //点击更换验证码：
        $("#captchaImage").click(function () {//点击更换验证码
            $(this).attr('src', '${pageContext.request.contextPath}/cmanager/enCode');
        });
    })
</script>
</body>
</html>
