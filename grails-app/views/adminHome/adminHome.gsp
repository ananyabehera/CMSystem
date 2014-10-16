<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main" />
		
		<title>[APP]::Admin Home</title>
	</head>
	<body>
		<g:if test="${session.user}">
			<div class="container">
				<h1>
					Welcome ${session.user.firstName} ${session.user.lastName}
					<g:link class="small" action="logout" controller="User">Logout?</g:link>
				</h1>
				<g:form controller="AdminHome">
					<g:actionSubmit  class="btn btn-primary btn-lg btn-block" value="Upload Document" action="uploadDoc" />
<<<<<<< Updated upstream
=======
					<br/>
					<g:actionSubmit  class="btn btn-success btn-lg btn-block" value="List all Documents" action="listDocs" />
					<br/>
>>>>>>> Stashed changes
				</g:form>

				<!--Added the remainder buttons just incase.  Will update them as soon as we finish development on that part.-->

				<button type="button" class="btn btn-success btn-lg btn-block">
					<span class="glyphicon glyphicon-plus"></span> Create Project(s)
				</button>
				
				<button type="button" class="btn btn btn-warning btn-lg btn-block">
					<span class="glyphicon glyphicon-pencil"></span> Edit Project(s)
				</button>
				
				<button type="button" class="btn btn-danger btn-lg btn-block">
					<span class="glyphicon glyphicon-trash"></span> Delete Project(s)
				</button>
			</div>
		</g:if>
		<g:else>
			You are not Logged In! <g:link href="/index"> Login Page</g:link>
		</g:else>

		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	</body>
</html>
