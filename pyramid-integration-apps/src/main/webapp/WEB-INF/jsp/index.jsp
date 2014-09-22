<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>Welcome !</h1>
  <p>
   categories :<br />
    <c:forEach var="item" items="${it.categories}">
        ${item.name}<br />
    </c:forEach>
  </p>
  <c:url var="logoutUrl" value="/j_spring_security_logout"></c:url>
  <a href="${logoutUrl}">log out</a>
</body>
</html>