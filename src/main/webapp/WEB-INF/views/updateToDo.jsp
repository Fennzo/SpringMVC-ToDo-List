<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file = "common/header.jspf" %>
<%@ include file = "common/nav.jspf" %>
	<div class="container">
		<H1>Update your task!</H1>
	
		<form:form method="POST" modelAttribute="todo">
			<!-- Carry on the id value  -->
			<form:hidden path = "id"/>
	<form:hidden path = "user"/>
			<fieldset class="form-group">
				<form:label path="description">Description:</form:label>
		
				<form:input path="description" type="text" class="form-control"
					required="required" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="targetDate">Target Date</form:label>
				<form:input path="targetDate" type="date" class="form-control"
					required="required" />	
				<form:errors path="targetDate" cssClass="text-warning" />

			</fieldset>
			<fieldset class="form-group"> 
				<form:radiobutton path="completion" value="true" label="True"/>
				<form:radiobutton path="completion" value="false" label="False"/>
			</fieldset>

			<button type="submit" class="btn btn-success" >Submit Update</button>
		</form:form>

	</div>
<%@ include file = "common/footer.jspf" %>
