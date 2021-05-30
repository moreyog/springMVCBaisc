<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Employee</h1>
<form:form method="POST" action="/SpringMVCCRUD/editsave">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="id" /></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Salary :</td>
			<td><form:input path="salary" /></td>
		</tr>
		<tr>
			<td>Designation :</td>
			<td><form:input path="designation" /></td>
		</tr>
		<tr>
			<td>Gender :</td>
			<td>Male<form:radiobutton path="Gender" value="Male" /> Female<form:radiobutton
					path="Gender" value="Female" /></td>
		</tr>
		<tr>
			<td>Shift :</td>
			<td><form:select path="shift">
					<form:option value="Morning" label="Morning" />
					<form:option value="Evening" label="Evening" />
					<form:option value="Night" label="Night" />
				</form:select></td>
		</tr>
		<tr>
               <td><form:label path = "food">Food</form:label></td>
               <td>
               		<c:forEach var="item" items="${foodList}"> <form:checkbox value="${item}" path = "food" />${item}</c:forEach>
               	</td>       
         </tr> 
		<tr>
			<td></td>
			<td><input type="submit" value="Edit Save" /></td>
		</tr>
	</table>
</form:form>
