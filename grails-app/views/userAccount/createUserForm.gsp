<!DOCTYPE html>
<html lang="en">
	<head>
  		<meta name="layout" content="main" />
  		
  		<title>[APP]::Create User</title>
  	</head>
  	
  	<body>
  		<div class="container">
  			<div class="row">
  				
  				<!-- Home Button Col -->
  				<div class="col-md-1 home-button">
  					<g:link class="btn btn-success" controller="LandingPage" action="renderHomePage"><span class="glyphicon glyphicon-arrow-left"></span> Back</g:link>
  				</div> <!-- /col-md-1 -->
  				
  				<!-- Page Heading Col -->
  				<div class="col=md-12">
  					<h1>Create User</h1>
  					
  					<g:if test="${flash.message}">
  						<div class="alert alert-danger" role="alert">${flash.message}</div>
  					</g:if>
  				</div> <!-- /col-md-12 -->
  				
  			</div> <!-- /row -->
  			
  			<g:uploadForm controller="UserAccount" action="createUser">
				
				<!-- First Name Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="text" id="firstName" name="firstName" class="form-control" placeholder="First Name" maxlength="50" required />
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Last Name Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="text" id="lastName" name="lastName" class="form-control" placeholder="Last Name" maxlength="50" required />
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Username Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="text" id="username" name="username" class="form-control" placeholder="Username" maxlength="50" required />
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Password Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="password" id="password" name="password" class="form-control" placeholder="Password" maxlength="50" required />
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Permission's Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
  							<strong>Permissions:</strong>
  							<select class="form-control" id="permission" name="permission" required>
  								<g:each in="${permissionInstanceList}" status="i" var="permission">
  									<option value="${permission.id}">${permission.pType}</option>
  								</g:each>
  							</select>
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Create Button Row -->
				<div class="row">
					<div class="col-md-9">
						<button type="submit" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-plus"></span> Create</button>
  				
					</div> <!-- col-md-9 -->
					
  				</div> <!-- /row -->
			
			</g:uploadForm>
			
		</div> <!-- /container -->
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
		
	</body>
</html>