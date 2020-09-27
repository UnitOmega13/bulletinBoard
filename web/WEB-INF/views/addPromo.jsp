<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Promo</title>
</head>
<body>

<header>
    <a href="${pageContext.request.contextPath}/userPromo">Home</a>
    <a href="${pageContext.request.contextPath}/userInfo">Cabinet</a>
</header>

<form enctype='multipart/form-data' method="POST" action="${pageContext.request.contextPath}/addPromo">
    <input type="hidden" name="redirectId" value="${param.redirectId}"/>
    <table border="1" cellpadding="5" align="center">
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" /></td>
        </tr>
        <td>
            Select file: <input name="file" type="file" id="file">
        </td>
        <tr>
            <td>Info</td>
            <td><input type="text" name="promoInfo" /></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
                <a href="${pageContext.request.contextPath}/userPromo">Cancel</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
