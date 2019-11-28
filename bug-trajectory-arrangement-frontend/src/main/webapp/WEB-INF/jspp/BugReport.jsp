<jsp:include page="TesterHeader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<div id="d1" align="right">
<h1></h1>
${msg}
</div>
<div id="d2" align="center">
<form action="${path}/BugSuccessfullyAllocated" method="get">
<table>
 <tr>
 <td> Tester Name: </td>
 <td> <input type="text" value="${userObj.name}" readonly="readonly"></td>
 </tr>
 <tr>
 <td> Project Name: </td>
 <td> 
 <input type="text" value="${projectObj.projName}" readonly="readonly">
 
 </td>
 </tr>
 <tr>
 	<td> Buy Type: </td>
  <td><select name="bug">
    <option value="0">=======Select===========</option>
   <c:forEach items="${bugListObj}" var="bObj">
    	<option value="${bObj.bId}">${bObj.bType}</option>
           </c:forEach>    
     </select> 
    </td>
 </tr>
 <tr>
 	<td> Severity : </td>
  <td><select name="severity">
    <option value="0">=======Select===========</option>
   <c:forEach items="${severityList}" var="sObj">
    	<option value="${sObj.sId}">${sObj.sType}</option>
           </c:forEach>    
     </select> 
    </td>
 </tr>
  <tr>
 <td> Description: </td>
 <td> <textarea cols="40" rows="10" name="description"></textarea></td>
 </tr>
 <tr>
	<td></td>
		<td>
			<input type="submit" value="Report">
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>