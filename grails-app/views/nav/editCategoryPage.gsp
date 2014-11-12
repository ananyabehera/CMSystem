<!DOCTYPE html>
<html lang="en">
	<head>
  		<meta name="layout" content="main" />
  		
  		<title>[APP]::Edit Category</title>
  	</head>
  	
  	<body>
  		<div class="container">
  			
  			<g:if test="${session.user}">
				<g:if test="${session.user.permissionId == 1}">
  			
  					<div class="row">
  				
  						<!-- List Button Col -->
  						<div class="col-md-1 home-button">
  							<g:link class="btn btn-success" controller="Nav" action="landingPage"><span class="glyphicon glyphicon-arrow-left"></span> Back</g:link>
  						</div> <!-- /col-md-1 -->
  				
  						<!-- Page Heading Col -->
  						<div class="col=md-12">
  							<h1>Edit Category</h1>
  						</div> <!-- /col-md-12 -->
  				
  					</div> <!-- /row -->
  			
  					<g:uploadForm controller="Nav" action="updateCategory">
						<g:hiddenField name="id" value="${catgInstance.id}" />
					
						<!-- Tag Name Row -->
						<div class="row">
					
							<div class="col-md-9">
					
  								<div class="form-group">
									<input type="text" id="catgName" name="catgName" class="form-control" placeholder="Category Name" maxlength="50" value="${catgInstance.catgName}" required />
								</div> <!-- /form-group -->
						
							</div> <!-- /col-md-9 -->
				
						</div> <!-- /row -->
				
						<!-- Tag Description and Create Button Row -->
						<div class="row">
							<div class="col-md-9">
						
								<div class="form-group">
									<textarea id="catgDesc" name="catgDesc" class="form-control" placeholder="Description" rows="5" maxlength="1000" required>${catgInstance.catgDesc}</textarea>
								</div>
				
								<button type="submit" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-ok"></span> Update</button>
  				
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