<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	<link rel="icon" href="../../favicon.ico">
		<title>Admin Home Page</title>
		<!-- Bootstrap core CSS -->
    	<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" />
    	<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'custom.css')}" />

    	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    	<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    	<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    	<!--[if lt IE 9]>
      		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    	<![endif]-->
	</head>
	<body>
		<g:if test="${session.user}">
			<div class="container">
				<br/>
				<h1>
					Welcome ${session.user.firstName} ${session.user.lastName}
					<g:link class="small" action="logout" controller="User">Logout?</g:link>
				</h1>
				<g:form controller="AdminHome" >
					<br/>
					<g:actionSubmit  class="btn btn-primary btn-lg btn-block" value="Upload Document" action="uploadDoc" />
					<br/>
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
