<!DOCTYPE html>
<%@ page import="storage.CurrentUser" %>
<%
    session.setAttribute("logUser", CurrentUser.isExist());
    session.setAttribute("userId", CurrentUser.getId());
    session.setAttribute("userFirstName", CurrentUser.getFirstName());
    session.setAttribute("userLastName", CurrentUser.getLastName());
    session.setAttribute("userEmail", CurrentUser.getEmail());
    session.setAttribute("userPassword", CurrentUser.getPassword());
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>
<header>
    <a href="${pageContext.request.contextPath}/userPromo">Home</a>
    <a onclick="return false" href="${pageContext.request.contextPath}/userInfo">Cabinet</a>
</header>

    <form action="${pageContext.request.contextPath}/userInfo" method="post">
        <table border="1" cellpadding="5" align="center">
            <tr>
                <th>User First Name:</th>
                <td>
                    <input type="text" name="firstName"
                           value='${userFirstName}'
                    />
                </td>
            </tr>
            <tr>
                <th>User Last Name:</th>
                <td>
                    <input type="text" name="lastName"
                           value='${userLastName}'
                    />
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="email" name="email" size="45"
                           value='${userEmail}'
                    />
                </td>
            </tr>
            <tr>
                <th>User Password:</th>
                <td>
                    <input type="text" name="password"
                           value='${userPassword}'
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>

<tr>
    <td colspan="2" align="center">
        <a href="${pageContext.request.contextPath}/addPromo">
            Add new Promo
        </a>
    </td>
</tr>
</body>
</html>
