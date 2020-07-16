<%@ include file = "common/header.jspf" %>
	
	<%@ include file = "common/nav.jspf" %>
	
	<center>
		<h1 style="color: green;">To do list for ${name}</h1>
	</center>
	<p style="text-align: center;">
		Today's date is
		<fmt:formatDate pattern="MM/dd/yyy" value="${date}" />
	</p>

	<!-- create border for table -->
	<div class="container">
		<!-- Make it striped table class ="(class1) (class2)" -->
		<table class="table table-striped">

	
			<!-- Define table column head -->
			<thead>
				<!-- Tr = table row -->
				<tr>

					<th scope="col">Description</th>
					<th scope="col">Date to complete</th>
					<th scope="col">Completed</th>

				</tr>
			</thead>

			<tbody>

				<!-- Loop -->
				<c:forEach items="${todos}" var="todo">
					<tr>
						<!-- Call ToDo methods  -->
						<td>${todo.description}</td>
						<td><fmt:formatDate pattern="MM/dd/yyy"
								value="${todo.targetDate}" /></td>
						<td>${todo.completion}</td>
						
						<!-- id=${todo.id} selects the id of the task to be deleted -->
						<td><a type="button" class="btn btn-primary"
							href="/update-todo?id=${todo.id}">Edit</a> <a type="button"
							
							class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>


			</tbody>

		</table>



		<div>
			<!-- btn-success make it look better -->
			<a type="button" a class="btn btn-success" href="/add-todo">Add
				task</a>
		</div>
	</div>

	<!-- Adding of bootstrap and jquery javascript files
	Adding JS files at the end if faster for page to load -->
<%@ include file = "common/footer.jspf" %>