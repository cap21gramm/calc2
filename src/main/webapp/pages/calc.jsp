<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">
    Num 1: <input type="text" name="num1" value="${param.num1}"><br>
    Num 2: <input type="text" name="num2" value="${param.num2}"><br>

    Операция:
    <select name="operation">
        <option value="sum">+</option>
        <option value="minus">–</option>
        <option value="umnoj">×</option>
        <option value="delenie">÷</option>
    </select><br>

    <input type="submit" value="=">
</form>

<c:if test="${not empty result}">
    <p>Результат: ${result}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<a href="${pageContext.request.contextPath}/history">history</a>
</body>
</html>