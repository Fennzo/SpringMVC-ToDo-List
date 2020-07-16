<%@ include file = "common/header.jspf" %>
	
	<%@ include file = "common/nav.jspf" %>
<body>

	<div class="container">
	<div>
		Today's date is
		<fmt:formatDate pattern="MM/dd/yyy" value="${date}" />
		</div>
	Welcome ${name} you've successfully logged in!
	<div><a href="/list-todo?name">Manage to do list</a>
</div>
       </div>


<%@ include file = "common/footer.jspf" %>