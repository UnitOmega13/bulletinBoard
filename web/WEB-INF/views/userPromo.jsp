<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Promos</title>
</head>
<body>
<header onclick="return false"><a href="${pageContext.request.contextPath}/userPromo">Home</a></header>
<header><a href="${pageContext.request.contextPath}/userInfo">Cabinet</a></header>
<table border="1" cellpadding="5" cellspacing="5" align="center">
    <c:forEach var="promo" items="${promoList}" begin="${(currentPage - 1) * 10}" end="${currentPage * 10}">
        <tbody>
        <tr>
            <td rowspan="4"><img alt="" src="<c:out value="${(promo.imageData)}"></c:out>"
                                 style="float:left; height:100px; margin-right:10px; width:100px"></td>
        </tr>
        <tr>
            <td>Title</td>
            <td><c:out value="${promo.title}"></c:out></td>
        </tr>
        <tr>
            <td>Description</td>
            <td width="100"><c:out value="${promo.promoInfo}"></c:out></td>
        </tr>
        </tr>
        <tr>
            <td>Author</td>
            <td width="100"><c:out value="${promo.lastName}"></c:out></td>
        </tr>
        </tbody>
    </c:forEach>
</table>

<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="${pageContext.request.contextPath}/userPromo?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>
</body>
</html>

