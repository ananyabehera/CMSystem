<!DOCTYPE html>
<html lang="en">
	<head>
  		<meta name="layout" content="main" />
  		
  		<title>[APP]::Create Tag</title>
  	</head>
  	
  	<body>
  		<div class="container">
  			<div class="row">
  				
  				<!-- Home Button Col -->
  				<div class="col-md-1 home-button">
  					<g:link class="btn btn-success" controller="adminHome" action="renderHomePage"><span class="glyphicon glyphicon-home"></span> Home</g:link>
  				</div> <!-- /col-md-1 -->
  				
  				<!-- Page Heading Col -->
  				<div class="col=md-12">
  					<h1>Create Tag</h1>
  				</div> <!-- /col-md-12 -->
  				
  			</div> <!-- /row -->
  			
  			<g:uploadForm controller="Tag" action="createTag">
				
				<!-- Tag Name Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="text" id="tagName" name="tagName" class="form-control" placeholder="Tag Name" required />
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Tag Description and Create Button Row -->
				<div class="row">
					<div class="col-md-9">
						
						<div class="form-group">
							<textarea id="tagDesc" name="tagDesc" class="form-control" placeholder="Description" rows="5" required></textarea>
						</div>
				
						<!-- <label>Date:</label><g:datePicker name="date"/><br/><br/> -->
						<button type="submit" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-plus"></span> Create</button>
  				
					</div> <!-- col-md-9 -->
					
  				</div> <!-- /row -->
			
			</g:uploadForm>
			
		</div> <!-- /container -->
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
		
	</body>
</html>