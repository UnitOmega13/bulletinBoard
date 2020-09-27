<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<header>
    <a onclick="return false" href="${pageContext.request.contextPath}/login" class="disabled">Login</a>
    <a href="${pageContext.request.contextPath}/registration">Registration</a>
</header>

<form method="POST" action="${pageContext.request.contextPath}/login">
    <input type="hidden" name="redirectId" value="${param.redirectId}"/>
    <table border="1" cellpadding="5" align="center">
        <tr>
            <td>EMail</td>
            <td><input required="required" type="text" name="email" value="${user.email}"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input required="required" type="password" name="password" value="${user.password}"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Login"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
