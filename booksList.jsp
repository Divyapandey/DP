<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H1> List of Books</H1>
	<!--  use JSTL tags -->
	<!--  iterate list of objects -->
	<!--  For each book b in books -->
	<table>
		<tr>
			<th>ISBN</th>
			<th>TITLE</th>
		</tr>
		<!--  for Each book b in books -->
		<c:forEach items="${books}" var="b">
		<tr>
		 <td><a href="getBookByIsbn/${b.isbn}">${b.isbn}</a></td><td>${b.title }</td>
		 <td><a href="delete/${b.isbn }"><span class="glyphicon glyphicon-trash">del</span></a></td>
		</tr>
		<c:out value="${b.title}"/>
		</c:forEach>
	</table>


</body>
</html>
