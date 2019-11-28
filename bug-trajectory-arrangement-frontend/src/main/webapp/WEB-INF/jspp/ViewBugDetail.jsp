<jsp:include page="header.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug Details</title>
</head>

<body>
<div id="d2" align="center">
<h1>Details Of Bugs</h1>
</div>

<form action="" method="get" style="padding-top: 100px">
<table class="table">
  <thead>
    <tr>
      <th scope="col">Bug Allocated Id</th>
      <th scope="col">Project name</th>
      <th scope="col">Project name</th>
      <th scope="col">Bug Staus</th>
      <th scope="col">Bug Severity</th>
      <th scope="col">Bug Description</th>
      <th scope="col">Bug Assignment</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="i" items="${bugAllocatedList}">
<tr>
<td>${i.bugAllocateId}</td>
<td>${i.projObj.projName }</td>
<td>${i.bugTypeObj.bType}</td>
<td>${i.bugStatusObj.statusName}</td>
<td>${i.severityObj.sType}</td>
<td>${i.desc}</td>
<td><a href="${path}/showBugDetail/${i.bugAllocateId} " id="btn" class="btn btn-success btn-block>Assign Bug">Assign Bug

</a></td>
</tr>
</c:forEach>
  </tbody>
</table>
</form>

</body>
</html>
