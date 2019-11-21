<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Allocation Page</title>
</head>
<body>
<form action="projectAllocated" method="post">
<c:forEach items="${projectList}" var="pObj">
<tr>
<td>Select Project :</td>
<td>
    <select name="project" >
    <option value="${pObj.projId}">${pObj.projName}</option>
            </select>
</td>
</tr>
</c:forEach>
</form>
</body>
</html>