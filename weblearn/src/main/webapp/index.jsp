<%--
  Created by IntelliJ IDEA.
  User: wuxiang
  Date: 2018/4/18
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.2.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <%@include file="views/navigation.jsp" %>

    <h1>这是主界面</h1>
    <div class="row clearfix" style="border: thin solid sandybrown">
        <div class="col-md-2 column">
            <a class="btn btn-info" href="views/fileupAnddownload.jsp">上传下载</a>
        </div>

        <div class="col-md-2 column">
            <a class="btn btn-primary" href="views/carousel.jsp">轮播图</a>
        </div>

        <div class="col-md-2 column">
            <a class="btn btn-primary" href="views/mainTabs.jsp">类别</a>
        </div>
        <div class="col-md-2 column">
            <div class="col-md-2 column">
                <a class="btn btn-primary" href="views/notelist.jsp">Notes</a>
            </div>
        </div>

    </div>
</body>
</html>