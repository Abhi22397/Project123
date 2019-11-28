<jsp:include page="TesterHeader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<div align="center">
<h1 >Assign Bug To Developer</h1>
<form action="" method="get">
<table  border="1">
  <thead>
    <tr>
      <th scope="col">Bug Allocated Id</th>
      <th scope="col">Project name</th>
      <th scope="col">Bug Type</th>
      <th scope="col">Bug Staus</th>
      <th scope="col">Bug Severity</th>
      <th scope="col">Assigned date</th>
      <th scope="col">Planned End date</th>
      <th scope="col">Description</th>
      <th scope="col">Fix Bug</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="i" items="${AssignedBugDetail}">
<tr>
<td>${i.bugAllocateId}</td>
<td>${i.projObj.projName }</td>
<td>${i.bugTypeObj.bType}</td>
<td>${i.bugStatusObj.statusName}</td>
<td>${i.severityObj.sType}</td>
<td>${i.plannedStartdate}</td>
<td>${i.plannedEndDate}</td>
<td>${i.desc}</td>
<td><a href="${path}/updateStatus/${i.bugAllocateId}" id="btn" class="btn btn-success btn-block>">Fix Bug</a></td>
</tr>
</c:forEach>
  </tbody>
</table>
</form>
</div>
</body>
</html>