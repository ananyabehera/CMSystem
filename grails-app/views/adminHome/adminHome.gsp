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
				<h2>Document Options:</h2>
				<g:link class="btn btn-success btn-lg btn-block" action="uploadDoc"><span class="glyphicon glyphicon-cloud-upload"></span> Upload Document</g:link>
				<g:link class="btn btn-primary btn-lg btn-block" action="listDocs"><span class="glyphicon glyphicon-list-alt"></span> Document Library</g:link>

				<!--Added the remainder buttons just incase.  Will update them as soon as we finish development on that part.-->
				
				<h2>Tag Options:</h2>
				<g:link class="btn btn-success btn-lg btn-block" action="createTag"><span class="glyphicon glyphicon-plus"></span> Create Tag(s)</g:link>
				<g:link class="btn btn-primary btn-lg btn-block" action="listTags"><span class="glyphicon glyphicon-list-alt"></span> Tag Library</g:link>
				
			</div> <!-- /container -->
		</g:if>
		<g:else>
			You are not Logged In! <g:link controller="User" action="index"> Login Page</g:link>
		</g:else>

		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	</body>
</html>
