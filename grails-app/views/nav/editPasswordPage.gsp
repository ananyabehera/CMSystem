<!DOCTYPE html>
<html lang="en">
	<head>
  		<meta name="layout" content="main" />
  		
  		<title>[APP]::Change User Password</title>
  	</head>
  	
  	<body>
  		<div class="container">
  			<div class="row">
  				
  				<!-- Home Button Col -->
  				<div class="col-md-1 home-button">
  					<g:link class="btn btn-success" controller="Nav" action="landingPage"><span class="glyphicon glyphicon-home"></span> Home</g:link>
  				</div> <!-- /col-md-1 -->
  				
  				<!-- Page Heading Col -->
  				<div class="col=md-12">
  					<h1>Change User Password</h1>
  					
  					<g:if test="${flash.message}">
  						<div class="alert alert-danger" role="alert">${flash.message}</div>
  					</g:if>
  				</div> <!-- /col-md-12 -->
  				
  			</div> <!-- /row -->
  			
  			<g:uploadForm controller="Nav" action="updatePassword">
				<g:hiddenField name="id" value="${userInstance.id}" />
				
				<!-- Password Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="password" id="password" name="password" class="form-control" placeholder="New Password" maxlength="50" required />
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Password Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="password" id="passwordConfirmation" name="passwordConfirmation" class="form-control" placeholder="Confirm Password" maxlength="50" required />
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Create Button Row -->
				<div class="row">
					<div class="col-md-9">
						<button type="submit" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-ok"></span> Change</button>
					</div> <!-- col-md-9 -->
					
  				</div> <!-- /row -->
			
			</g:uploadForm>
			
		</div> <!-- /container -->
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
		
	</body>
</html>