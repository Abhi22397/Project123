<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <jsp:include page="header.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug Assignment</title>
</head>
<body>
<form action="${path}/assigned" method="get">

<table align="center">
<tr>
<td>Project Name:</td>
<td>
<input type="hidden" value="${bugAlloactionDetails.bugAllocateId }"  name="bugAllocateId">
<input type="hidden" value="${bugAlloactionDetails.projObj.projId }"  name="projectId" readonly="readonly" >
${bugAlloactionDetails.projObj.projName }</td>
</tr>
<tr>
<td> Developer List:</td>
<td><select name="developer" required>
    <option value="0">-----------Select Developer---------------</option>
   <c:forEach items="${uList}" var="dObj">
    	<option value="${dObj.id}">${dObj.name}</option>
           </c:forEach>    
     </select> 
</tr>
<tr>
 	<td> Buy Status: </td>
  <td><select name="status" required>
    <option value="0">-----------Select Bug Status---------------</option>
          <c:forEach items="${statusList}" var="sObj">
    	    <option value="${sObj.statusId}">${sObj.statusName}</option>
           </c:forEach>    
     </select> 
    </td>
 </tr>
<tr>
   <td>Bug Type:</td>
       <td><input type="text" value="${bugAlloactionDetails.bugTypeObj.bType}" readonly="readonly" > </td><td>
</tr>
<tr>
   <td>Assigned Date</td>
   <td><input type="date" name="assignedDate" required><td>
</tr>
<tr>
<td>Planned End Date</td>
<td><input type="date" name="endDate" required><td>
</tr>
<tr>
<td>Description</td>
<td><textarea  cols="30" rows="10" readonly="readonly">${bugAlloactionDetails.desc}</textarea><td>
</tr>
<tr>
<td> </td>
<td><input type="submit",value="Assign"></td>
</tr>
</table>
</form>
</body>
</html>