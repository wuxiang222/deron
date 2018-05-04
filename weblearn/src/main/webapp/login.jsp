<%--
<%--
  Created by IntelliJ IDEA.
  User: wuxiang
  Date: 2018/4/18
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <style>
        .container{
            width:500px; height:300px;margin:200px auto 0; background-color: #ede;
            padding: 40px 10px;
        }
    </style>
    <script src="js/jquery-1.11.2.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <form id="loginForm" action="${pageContext.request.contextPath}/user/login" method="post" >
            <h2 class="text-center">Please sign in</h2>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" id="name" placeholder="请输入名称">
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" name="password" class="form-control"  placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="rememberMe">请记住我
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-info btn-block">登录</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
