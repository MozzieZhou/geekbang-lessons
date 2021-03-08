<head>
    <jsp:directive.include
            file="/WEB-INF/jsp/prelude/include-head-meta.jspf"/>
    <title>My Home Page</title>

    <%
        String path = request.getContextPath();
    %>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!-- 表单验证 -->
    <script type="text/javascript">
        function isValid(form) {
            if (form.name.value == "") {
                alert("用户名不能为空！");
                return false;
            }
            if (form.password.value != form.password1.value) {
                alert("两次输入的密码不同！");
                return false;
            }
            if (form.password.value == "") {
                alert("密码不能为空！");
                return false;
            }
            if (form.password.value == "") {
                alert("请再次输入密码！");
                return false;
            }
            if (form.email.value == "") {
                alert("邮箱不能为空！");
                return false;
            }
            if (form.phoneNumber.value == "") {
                alert("手机号不能为空！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="container-lg">
    <center>
        <form method="post" action="<%=path%>/register/userRegister"
              onSubmit="return isValid(this);">
            <table>
                <caption>用户注册</caption>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="name" size="21"></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input type="password" name="password" size="21"></td>
                </tr>
                <tr>
                    <td>确认密码:</td>
                    <td><input type="password" name="password1" size="21"></td>
                </tr>
                <tr>
                    <td>邮箱:</td>
                    <td><input type="text" name="email" size="21"></td>
                </tr>
                <tr>
                    <td>手机号:</td>
                    <td><input type="number" name="phoneNumber" size="21"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="注册"/></td>
                    <td><input type="reset" value="重置"></td>
                </tr>
            </table>
        </form>
    </center>

</div>
</body>