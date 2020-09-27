<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>

<header>
    <a href="${pageContext.request.contextPath}/login" class="disabled">Login</a>
    <a onclick="return false" href="${pageContext.request.contextPath}/registration">Registration</a>
</header>

<form method="POST" action="${pageContext.request.contextPath}/registration">
    <input type="hidden" name="redirectId" value="${param.redirectId}"/>
    <table border="1" cellpadding="5" align="center">
        <tr>
            <td>email</td>
            <td><input required="required" type="email" name="email" value="${user.email}"/></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><input required="required" type="text" name="firstName" value="${user.firstName}"/></td>
        </tr>
        <tr>
            <td>Lst Name</td>
            <td><input required="required" type="text" name="lastName" value="${user.lastName}"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input required="required" type="password" name="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Sing up"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>