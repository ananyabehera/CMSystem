<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="layout" content="main" />
		
		<title>[APP]::Login</title>
		
  	</head>

	<body>
	
		<div class="container">
			<div class="login">
				
				<g:if test="${session.login}">
			
					<div class="alert alert-danger" role="alert">${flash.message}</div>
		
				</g:if>
				
				<g:form action="login" class="form-signin" role="form" controller="User"> <!-- send form request to action named "login" -->
					<h2 class="form-signin-heading">Please sign in</h2>
					<input type="text" name="username" class="form-control" placeholder="Username" required autofocus />
					<input type="password" name="password" class="form-control" placeholder="Password" required />
					 <!--<label class="checkbox">
           				<input type="checkbox" value="remember-me"> Remember me
        			</label> -->
        			<button name="login" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
				</g:form>
			</div> <!-- /login -->
		</div> <!-- /container -->
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    	
	</body>
</html>