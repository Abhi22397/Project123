<jsp:include page="TesterHeader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body> 
<div id="d1" align="center">
<h1 align="center">Project Allocated </h1>
</div>
<div id="d2" align="center">
<table border="1" align="center" width="100%">
<tr align="center">
      <th scope="col" >Project List</th>
      <th scope="col">Allocate</th>
      </tr>
	
	<tbody>
  <c:forEach var="pObj" items="${projectList}">
   <tr align="center">
      <td>${ pObj.projName}</td>
      <td><a href="BugAllocated/${pObj.projId}">Allocate Bug</a></td>
   </tr>
 </c:forEach>
 </tbody>
</table>
</div>
</body>
