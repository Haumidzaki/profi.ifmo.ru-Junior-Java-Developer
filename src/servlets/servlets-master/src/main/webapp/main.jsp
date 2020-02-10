 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>

    <%@ page contentType="text/html;charset=utf-8"%>
    <title>Title</title>
</head>

<body>
    <a href="addNews">Добавить новость</a>

    <c:forEach items="${allnews}" var="item">
        <h3>${item.title}</h3>
        <p>${item.newsText}</p>
        <p>${item.newsDate}</p>
        <a href="<c:url value = "readnews?id=${item.id}"/>">Подробнее</a>
    </c:forEach>

</body>

</html>