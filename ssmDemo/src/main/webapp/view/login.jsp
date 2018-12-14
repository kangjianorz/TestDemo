<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/14
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form id="loginForm" name="loginForm">
    <div>
        <input type="text" id="loginName" name="loginName" placeholder="请输入登录名"/>
        <input type="text" id="password" name="password" placeholder="请输入密码"/>
        <button type="button" id="login" name="login">登陆</button>
    </div>
</form>
</body>
</html>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
        $("#login").click(function(){
            $.ajax({
                url:"../test/doLogin",
                type:"POST",
                dateType:"json",
                data:$("#loginForm").serialize(),
                success:function (data) {
                    alert("登陆成功，即将跳转！");
                    console.log("啊哈")
                    window.location.href = "../test/indexPage";
                },
                error:function (data) {
                    alert("登陆失败，请确认用户名密码是否正确！");
                    console.log()
                }
            });
        });
</script>