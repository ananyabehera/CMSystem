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
  					<g:link class="btn btn-success" controller="Document" action="documentLibrary"><span class="glyphicon glyphicon-arrow-left"></span> Back</g:link>
  				</div> <!-- /col-md-1 -->
  				
  				<!-- Page Heading Col -->
  				<div class="col=md-12">
  					<h1>${documentInstance.docName}</h1>
  				</div> <!-- /col-md-12 -->
  				
  			</div> <!-- /row -->
  			
  			<!-- Document Date Row -->
			<div class="row">
				<div class="col-md-12">
					<p><strong>Uploaded By</strong> ${documentInstance.userAccount.firstName} ${documentInstance.userAccount.lastName}</p>
					<p><strong>Date Uploaded:</strong> <g:formatDate date="${documentInstance.dateUploaded}" type="datetime" style="MEDIUM" timeStyle="SHORT"/></p>
					<p><strong>Type:</strong> ${documentInstance.fileType}</p>
					<p><strong>Tags:</strong> [TAG LIST GOES HERE SEPERATED WITH A ',' PER ITEM]</p>
				</div>
			</div> <!-- /row -->
				
			<!-- Button Options -->
			<div class="row">
				
				<div class="col-md-12">
					<g:link id="${documentInstance.id}" class="btn btn-success" controller="Document" action="download_Doc"><span class="glyphicon glyphicon-cloud-download"></span> Download</g:link>
				
				<g:if test="${session.user.permissionId == 1}">
					<g:link id="${documentInstance.id}" class="btn btn-warning" controller="Document" action="editDocumentForm"><span class="glyphicon glyphicon-pencil"></span> Edit</g:link>
					<g:link id="${documentInstance.id}" class="btn btn-danger" controller="Document" action="deleteDocument"><span class="glyphicon glyphicon-trash"></span> Delete</g:link>
				</g:if>
  				<g:else>
  					</div> <!-- col-md-12 -->
  				</g:else>
  			</div> <!-- /row -->
				
			<!-- Document Description -->
			<div class="row">
				<div class="col-md-12">
					<p>${documentInstance.docDesc}</p>
				</div> <!-- col-md-12 -->
					
  			</div> <!-- /row -->
			
		</div> <!-- /container -->
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
		
	</body>
</html>