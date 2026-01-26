<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>История операций</title>
</head>
<body>
<h2>История операций</h2>

<c:if test="${empty history}">
    <p>История пуста</p>
</c:if>

<c:if test="${not empty history}">
    <c:forEach var="calc" items="${history}">
        <p>${calc.num1} ${calc.operationSymbol} ${calc.num2} = ${calc.result}</p>
    </c:forEach>
</c:if>

<br>
<a href="${pageContext.request.contextPath}/calc">Назад к калькулятору</a>
</body>
</html>