<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container-fluid container">
        <%-- 响应式 --%>
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Deron</a>
        </div>


        <div class="collapse navbar-collapse" id="example-navbar-collapse">


            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Java<b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
                    </ul>
                </li>
                <li class="active"><a href="#">HTML</a></li>
                <li><a href="#">CSS</a></li>
                <li><a href="#">JavaScript</a></li>
                <li><a href="${pageContext.request.contextPath}/back/main.jsp">Project</a></li>
            </ul>


            <ul class="nav navbar-nav navbar-right">
                <li><a>WELCOME <shiro:principal/></a></li>
                <li><a href="${pageContext.request.contextPath}/user/logout" class="btn  btn-link">注销</a></li>
            </ul>


            <shiro:notAuthenticated>
                <form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/user/login">
                    <div class="form-group">
                        <input type="text" class="form-control" name="name" placeholder="账号">
                        <input type="password" class="form-control" name="password" placeholder="密码">
                    </div>
                    <button type="submit" class="btn btn-default">登录</button>
                    <a class="btn" href="${pageContext.request.contextPath}/regist.jsp">注册</a>
                </form>
            </shiro:notAuthenticated>


        </div>
    </div>
</nav>