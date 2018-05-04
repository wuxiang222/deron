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
    <%@include file="views/navigation.jsp"%>
    <h1>这是主界面</h1>
    <div class="row clearfix">
        <div class="col-md-2 column">
            <div class="panel-group" id="panel-237454">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title" data-toggle="collapse" data-parent="#panel-237454" href="#panel-element-204792">Collapsible Group Item #1</a>
                    </div>
                    <div id="panel-element-204792" class="panel-collapse collapse in">
                        <div class="panel-body">
                            Anim pariatur cliche...
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title" data-toggle="collapse" data-parent="#panel-237454" href="#panel-element-490906">Collapsible Group Item #2</a>
                    </div>
                    <div id="panel-element-490906" class="panel-collapse collapse">
                        <div class="panel-body">
                            Anim pariatur cliche...
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-10 column">
            <a class="btn btn-primary" href="views/carousel.jsp">轮播图</a>
        </div>
    </div>


</body>
</html>