<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
<div class="container">
    <H1>Add your task!</H1>
    <!-- form:form spring MVC container form tag -->
    <!-- commandName is command obj -->
    <form:form method="POST" modelAttribute="todo" >
        <!-- fieldset used to group elements in a form. Box elements in one box -->
        <fieldset class="form-group">
            <!-- path links the variable in ToDo.java -->
            <form:label path="description">Description:</form:label>
            <!-- required validates nulll -->
            <form:input path="description" type="text" class="form-control" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="form-group">
            <form:label path="targetDate">Target Date</form:label>
            <form:input path="targetDate" type="date" class="form-control" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
 
        </fieldset>
 
        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>
<%@ include file="common/footer.jspf" %>