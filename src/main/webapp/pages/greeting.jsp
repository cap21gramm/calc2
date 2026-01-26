<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/greeting" method="post">
    <input type="text" name="name" placeholder="Name">
    <button>Submit</button>>
</form>
<span>${message}</span>
</body>
</html>
