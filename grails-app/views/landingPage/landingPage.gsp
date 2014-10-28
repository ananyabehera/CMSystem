<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main" />
		
		<title>[APP]::Admin Home</title>
	</head>
	<body>
		
		<div class="container">
			<g:if test="${session.user}">
				<h1>
					Welcome ${session.user.firstName} ${session.user.lastName}
					<g:link class="small" controller="UserAccount" action="logout">Logout?</g:link>
				</h1>
				<g:if test="${session.user.permissionId == 1}">
					
					<h2>Document Options:</h2>
					<g:link class="btn btn-success btn-lg btn-block" action="uploadDoc"><span class="glyphicon glyphicon-cloud-upload"></span> Upload Document</g:link>
					<g:link class="btn btn-primary btn-lg btn-block" action="listDocs"><span class="glyphicon glyphicon-list-alt"></span> Document Library</g:link>
				
					<h2>Tag Options:</h2>
					<g:link class="btn btn-success btn-lg btn-block" action="createCategory"><span class="glyphicon glyphicon-plus"></span> Create Tag Category</g:link>
					<g:link class="btn btn-primary btn-lg btn-block" action="listCategories"><span class="glyphicon glyphicon-list-alt"></span> Category Library</g:link>
					<g:link class="btn btn-success btn-lg btn-block" action="createTag"><span class="glyphicon glyphicon-plus"></span> Create Tag</g:link>
					<g:link class="btn btn-primary btn-lg btn-block" action="listTags"><span class="glyphicon glyphicon-list-alt"></span> Tag Library</g:link>
					
					<h2>User Options:</h2>
					<g:link class="btn btn-success btn-lg btn-block" action="createUser"><span class="glyphicon glyphicon-plus"></span> Create User</g:link>
					<g:link class="btn btn-primary btn-lg btn-block" action="listUsers"><span class="glyphicon glyphicon-list-alt"></span> User Library</g:link>
				</g:if>
				<g:else>
					<h2>Document Options:</h2>
					<g:link class="btn btn-primary btn-lg btn-block" action="listDocs"><span class="glyphicon glyphicon-list-alt"></span> Document Library</g:link>
					
					<h2>Tag Options:</h2>
					<g:link class="btn btn-primary btn-lg btn-block" action="listTags"><span class="glyphicon glyphicon-list-alt"></span> Tag Library</g:link>
				</g:else>
			</g:if>
			<g:else>
				<p>You are not Logged In! <g:link controller="User" action="index"> Login Page</g:link></p>
			</g:else>
				
		</div> <!-- /container -->
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	</body>
</html>