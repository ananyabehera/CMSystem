<!DOCTYPE html>
<html lang="en">
	<head>
  		<meta name="layout" content="main" />
  		
  		<title>[APP]::Create Biography</title>
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
  					<h1>Create Biography</h1>
  					
  					<g:if test="${flash.message}">
  						<div class="alert alert-danger" role="alert">${flash.message}</div>
  					</g:if>
  				</div> <!-- /col-md-12 -->
  				
  			</div> <!-- /row -->
  			
  			<g:uploadForm controller="Nav" action="createBiography">
				
				<!-- Biography Icon Upload Row -->
  				<div class="row">
  				
  					<div class="col-md-9">
  					
  						<div class="form-group">
							<input type="file" id="file" name="file" class="form-control btn-file" required />
							<p class="help-block">Please upload an image for your biography.</p>
						</div> <!-- /form-group -->
						
  					</div> <!-- /col-md-9 -->
  				
 				</div> <!-- /row -->	
				
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
				
				<!-- Title Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="text" id="title" name="title" class="form-control" placeholder="Title" maxlength="100" required />
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Team Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="text" id="team" name="team" class="form-control" placeholder="Team" maxlength="100" required />
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Bio Description Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<textarea id="bioDesc" name="bioDesc" class="form-control" placeholder="Biography Description" maxlength="1000" required></textarea>
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- One Liner Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="text" id="oneLiner" name="oneLiner" class="form-control" placeholder="One Liner" maxlength="1000" required />
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Love Sentance Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="text" id="loveSentance" name="loveSentance" class="form-control" placeholder="What do you love about ---?" maxlength="1000" required />
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