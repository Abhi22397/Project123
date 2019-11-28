<jsp:include page="header.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<body marginheight="0px">
<div align="center" id="d1">
<h1>Allocate Project </h1>
</div>
<div align="center" id="d2">
<form action="${path}/projectAllocated" method="post">
<c:if test="${not empty message}">
       ${message}
</c:if>

<table>
	<tr>
	<td>Select Project :</td>
	<td>
    	<select name="project" required>
    	<option value="0">-----Select Project----------</option>
    	<c:forEach items="${projectList}" var="pObj">
    	<option value="${pObj.projId}">${pObj.projName}</option>
           </c:forEach>
       </select>
	</td>
	</tr>
	
	<tr>
	<td>Select Developer :</td>
	<td>
    	<select name="developer" multiple="multiple" required>
    	<option value="0">-----Select Developer---------</option>
    	<c:forEach items="${developerList}" var="dObj">
    	<option value="${dObj.id}">${dObj.name}</option>
           </c:forEach>
       </select>
	</td>
	</tr>
	
	<tr>
	<td>Select Tester :</td>
	<td>
    	<select name="tester" multiple="multiple" required>
    	<option value="0">-----Select Tester---------</option>
    	<c:forEach items="${testerList}" var="tObj">
    	<option value="${tObj.id}">${tObj.name}</option>
           </c:forEach>
       </select>
	</td>
	</tr>
	
	<tr>
		<td></td>
		<td>
			<input type="submit" value="Allocate">
		</td>
	</tr>
</table>
</form>
</div>
</body>
