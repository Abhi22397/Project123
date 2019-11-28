<jsp:include page="DeveloperHeader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<div align="center">
<h1></h1>
<form action="assigned" method="post">
<table border="1" style="align-content: center;">
		<tr align="center">
      <th scope="col" >Project Alloted List</th>
      </tr>
	<c:forEach items="${projectList}" var="pObj">
		<tbody>
		<tr>
			<td>
				${ pObj.projName}
			</td>
		</tr>
	</c:forEach>
		</tbody>
	<tr>
	   <td align="center"><input type="submit" value="Assigned Bugs"/> </td>
	</tr>
</table>
</form>
</div>
</body>
</html>