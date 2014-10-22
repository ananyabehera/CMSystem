<!DOCTYPE html>
<html lang="en">
	<head>
  		<meta name="layout" content="main" />
  		
  		<title>[APP]::Tag Details</title>
  	</head>
  	
  	<body>
  	
  		<div class="container">
  			
  			<!-- Back button and Tag Name Row -->
  			<div class="row">
  				
  				<!-- List Button Col -->
  				<div class="col-md-1 home-button">
  					<g:link class="btn btn-success" controller="Tag" action="renderListing"><span class="glyphicon glyphicon-arrow-left"></span> Back</g:link>
  				</div> <!-- /col-md-1 -->
  				
  				<!-- Page Heading Col -->
  				<div class="col=md-12">
  					<h1>${tagInstance.tagName}</h1>
  				</div> <!-- /col-md-12 -->
  				
  			</div> <!-- /row -->
  			
  			<!-- Tag Date Row -->
			<div class="row">
				<div class="col-md-12">
					<p><strong>Date Created:</strong> <g:formatDate date="${tagInstance.dateCreated}" type="datetime" style="MEDIUM" timeStyle="SHORT"/></p>
           			<p><strong>Date Updated:</strong> <g:formatDate date="${tagInstance.dateUpdated}" type="datetime" style="MEDIUM" timeStyle="SHORT"/></p>
				</div>
			</div> <!-- /row -->
			<g:if test="${session.user.level == Permission.ADMIN}">
				
				<!-- Button Options -->
				<div class="row">
					<div class="col-md-1">
						<g:link id="${tagInstance.id}" class="btn btn-warning" controller="Tag" action="tagEditForm"><span class="glyphicon glyphicon-pencil"></span> Edit</g:link>
					</div> <!-- col-md-1 -->
					
					<div class="col-md-1">
						<g:link id="${tagInstance.id}" class="btn btn-danger" controller="Tag" action="deleteTag"><span class="glyphicon glyphicon-trash"></span> Delete</g:link>
					</div> <!-- col-md-1 -->
					
  				</div> <!-- /row -->
			
			</g:if>
			
			<!-- tag Description -->
			<div class="row">
				<div class="col-md-12">
					<p>${tagInstance.tagDesc}</p>
				</div> <!-- col-md-12 -->
					
  			</div> <!-- /row -->
			
		</div> <!-- /container -->
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
		
	</body>
</html>