<%--
  Created by IntelliJ IDEA.
  User: wuxiang
  Date: 2018/5/11
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传下载</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.2.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <%@include file="navigation.jsp"%>
    <form action="../fileup/project" enctype="multipart/form-data" method="post">
        <input type="file" name="source">
        <input type="submit" value="上传服务器">
    </form>

    <div>
        <label>下载：</label>
        <a href="../download/Shiro笔记.txt">Shiro笔记.txt</a>
        <a href="../download/TCPIP之大明王朝邮差_20180324.txt">TCPIP之大明王朝邮差_20180324.txt</a>
        <a href="../download/DHTML.gif">DHTML.gif</a>
    </div>
    
    <div>
        <label>验证码:</label>
        <img class="captcha" src="../captcha" style="width: 100px" alt="验证码">
    </div>

    <script>

        document.querySelector(".captcha").onclick = function () {
            this.src="../captcha";
        }/* 单击更新验证码 */
    </script>
</body>
</html>
