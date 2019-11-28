<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome </title>
</head>
<body>
<h1>Welcome to bug Trajectory System</h1>

  <form action="projectAllocation" method="post">
<input type="submit" value="Project Allocation">
</form>

<!--<c:forEach items="${projectList}" var="pObj">
<tr>
<td>Select Project :</td>
<td>
    <select name="project" >
    <option value="${pObj.projId}">${pObj.projName}</option>
            </select>
            </td>         
</tr>
</c:forEach>
--->
 <tr>
 	<td> Status : </td>
  <td><select name="status">
    <option value="0">=======Select===========</option>
   <c:forEach items="${statusList}" var="statusObj">
    	<option value="${statusObj.statusId}">${statusObj.statusName}</option>
           </c:forEach>    
     </select> 
    </td>
 </tr>

</body>
</html>