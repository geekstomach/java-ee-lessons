<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Каталог товаров</title>
</head>
<body>
    <h1>Каталог товаров</h1>
    <%@include file="menu.jspf"%>
  <%--  <jsp:useBean id="ProductList" class="com.geekstomach.entity.ProductsList" scope="request"/>--%>
 <ul>
    <c:forEach items="${productsList}" var="product">
<li>${product.toString()}</li>
    </c:forEach>
    </ul>
</body>
</html>
