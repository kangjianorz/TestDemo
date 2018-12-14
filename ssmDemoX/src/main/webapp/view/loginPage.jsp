<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${pageTitle}</title>
</head>
<body>
<form id="loginForm" name="loginForm">
    <div>
        <input type="text" id="userName" name="userName" placeholder="请输入登录名"/>
        <input type="text" id="passWord" name="passWord" placeholder="请输入密码"/>
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
                url:"../login/doLogin",
                type:"POST",
                dateType:"json",
                data:$("#loginForm").serialize(),
                success:function (data) {
                    alert("登录成功，即将跳转！");
                    console.log("登录成功");
                    window.location.href = "../login/indexPage";
                },
                error:function (data) {
                    alert("登录失败，请确认用户名密码是否正确！");
                    console.log("登录出错");
                }
            });
        });
</script>