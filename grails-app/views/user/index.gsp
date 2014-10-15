<!DOCTYPE html>
<htm lang="en">
	<head>
    	<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	<link rel="icon" href="../../favicon.ico">

    	<title>Index</title>

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
				<h1>
					Welcome ${session.user.firstName} ${session.user.lastName}
					<g:link class="small" action="logout" controller="User">Logout?</g:link>
				</h1>
				
				<button type="button" class="btn btn-primary btn-lg btn-block">
					<span class="glyphicon glyphicon-eye-open"></span> View Project(s)
				</button>
				
				<button type="button" class="btn btn-success btn-lg btn-block">
					<span class="glyphicon glyphicon-plus"></span> Create Project(s)
				</button>
				
				<button type="button" class="btn btn btn-warning btn-lg btn-block">
					<span class="glyphicon glyphicon-pencil"></span> Edit Project(s)
				</button>
				
				<button type="button" class="btn btn-danger btn-lg btn-block">
					<span class="glyphicon glyphicon-trash"></span> Delete Project(s)
				</button>
				
			</div> <!-- /container -->
		
		</g:if>
		<g:else>
		
			<div class="container">
				<div class="login">
				
					<g:if test="${session.login}">
			
						<div class="alert alert-danger" role="alert">${flash.message}</div>
		
					</g:if>
				
					<g:form action="login" class="form-signin" role="form" controller="User"> <!-- send form request to action named "login" -->
						<h2 class="form-signin-heading">Please sign in</h2>
						<input type="text" name="userName" class="form-control" placeholder="Username" required autofocus>
						<input type="password" name="password" class="form-control" placeholder="Password" required>
						 <!--<label class="checkbox">
           					<input type="checkbox" value="remember-me"> Remember me
        				</label> -->
        				<button name="login" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
					</g:form>
				</div> <!-- /login -->
			</div> <!-- /container -->
		
		</g:else>
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    	
	</body>
</html>
