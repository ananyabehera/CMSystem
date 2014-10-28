<!DOCTYPE html>
<html lang="en">
	<head>
  		<meta name="layout" content="main" />
  		
  		<title>[APP]::Create Tag Category</title>
  	</head>
  	
  	<body>
  		<div class="container">
  			<g:if test="${session.user}">
				<g:if test="${session.user.permissionId == 1}">
  				
  					<div class="row">
  				
  						<!-- Home Button Col -->
  						<div class="col-md-1 home-button">
  							<g:link class="btn btn-success" controller="landingPage" action="renderHomePage"><span class="glyphicon glyphicon-home"></span> Home</g:link>
  						</div> <!-- /col-md-1 -->
  				
  						<!-- Page Heading Col -->
  						<div class="col=md-12">
  							<h1>Create Tag Category</h1>
  						</div> <!-- /col-md-12 -->
  				
  					</div> <!-- /row -->
  			
  					<g:uploadForm controller="Tag" action="createCategory">
				
						<!-- Category Name Row -->
						<div class="row">
					
							<div class="col-md-9">
						
  								<div class="form-group">
									<input type="text" id="catgName" name="catgName" class="form-control" placeholder="Category Name" maxlength="50" required />
								</div> <!-- /form-group -->
						
							</div> <!-- /col-md-9 -->
				
						</div> <!-- /row -->
				
						<!-- Category Description and Create Button Row -->
						<div class="row">
							<div class="col-md-9">
						
								<div class="form-group">
									<textarea id="catgDesc" name="catgDesc" class="form-control" placeholder="Description" rows="5" maxlength="1000" required></textarea>
								</div>
				
								<!-- <label>Date:</label><g:datePicker name="date"/><br/><br/> -->
								<button type="submit" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-plus"></span> Create</button>
  				
							</div> <!-- col-md-9 -->
					
  						</div> <!-- /row -->
			
					</g:uploadForm>
		
				</g:if>
				<g:else>
					<p>You do not have permission to view this page.</p>
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