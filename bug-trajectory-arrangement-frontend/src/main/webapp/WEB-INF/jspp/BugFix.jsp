<jsp:include page="TesterHeader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
   <div align="center" id="d2">
     <h1>Bug Fixing Report</h1>
       </div><hr>
       
       <div align="center" class="container">
       <form action="${path}/fixbug",method>
       <table>
              <tr >
              <td class="form-control">Project Name:-</td>
              <td>
               <input type="hidden" value="${bugDetail.bugAllocateId }"  name="bugAllocateId">
               <input type="hidden" value="${bugDetail.projObj.projId }"  name="projectId" readonly="readonly" >
                 ${bugDetail.projObj.projName }</td>
              </tr>
              <tr><td><br></td></tr>
              <tr>
                           <td class="form-control">Bug Status:-</td>
                           <td>
                           <select name="status" class="form-control">
                                         <option value="0">----Select BugStatus----</option>
                                                <c:forEach items="${statusList}" var="bgStatusValue">
                                         <option value="${bgStatusValue.statusId}">
                                                ${bgStatusValue.statusName}
                                         </option>
                                                </c:forEach>
                                  </select>
                           </td>
                     </tr>
                     <tr><td><br></td></tr>
                     <tr >
                           <td class="form-control">Severity:-</td>
                           <td><input type="text" class="form-control" value="${bugDetail.severityObj.sType}" ></td>
                     </tr>
                     <tr><td><br></td></tr>
                     <tr>
                           <td class="form-control">Bug Type:-</td>
                           <td><input type="text" size="40" class="form-control" value="${bugDetail.bugTypeObj.bType}"></td>
                     </tr>
                     <tr>
                      <td>Assigned Date</td>
                      <td><input type="date" name="actualAssignedDate" required><td>
                   </tr>
                   <tr>
                     <td> End Date</td>
                     <td><input type="date" name="actualEndDate" required><td>
                   </tr>
                   <tr>
                   <td>Description</td> 
                   <td><textarea  cols="30" rows="10" readonly="readonly">${bugDetail.desc}</textarea><td>
                   </tr>
                     <tr><td><br></td></tr>
                     <tr>
                           <td></td>
                           <td><input type="submit" value="Fix" class="btn btn-info" role="button"></td>
                     </tr>
       </table>
       </form>
       </div>


</body>
</html>