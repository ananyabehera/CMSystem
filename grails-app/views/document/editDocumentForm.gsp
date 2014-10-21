<!DOCTYPE html>
<html lang="en">
	<head>
  		<meta name="layout" content="main" />
  		
  		<title>[APP]:: Edit Document</title>
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
  					<h1>Upload Document</h1>
  				</div> <!-- /col-md-12 -->
  				
  			</div> <!-- /row -->
  			
  			<g:uploadForm controller="Document" action="edit_Doc">
  			<g:hiddenField name="id" value="${documentInstance.id}"/>
				
				<!-- Document Title Row -->
				<div class="row">
					
					<div class="col-md-9">
					
  						<div class="form-group">
							<input type="text" id="documentTitle" name="documentTitle" class="form-control" placeholder="Title" value="${documentInstance.name}" required />
						</div> <!-- /form-group -->
						
					</div> <!-- /col-md-9 -->
				
				</div> <!-- /row -->
				
				<!-- Tag Row -->
				<div class="row">
					<div class="col-md-9">
						
						<div class="form-group">
							<select multiple class="form-control">
  								<g:each in="${tagInstanceList}" status="i" var="tag">
  									<option value="${tag.tagName}">${tag.tagName}</option>
  								</g:each>
							</select>
						</div>
						
					</div> <!-- col-md-9 -->
					
  				</div> <!-- /row -->
				
				<!-- Document Description and Upload Button Row -->
				<div class="row">
					<div class="col-md-9">
						
						<div class="form-group">
							<textarea id="documentDesc" name="documentDesc" class="form-control" placeholder="Description" rows="5">${documentInstance.desc}</textarea>
						</div>
				
						<!-- <label>Date:</label><g:datePicker name="date"/><br/><br/> -->
						<button type="submit" class="btn btn-primary pull-right" id="${documentInstance.id}"><span class="glyphicon glyphicon-cloud-upload"></span> Upload</button>
  				
					</div> <!-- col-md-9 -->
					
  				</div> <!-- /row -->
			
			</g:uploadForm>
			
		</div> <!-- /container -->
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
		
	</body>
</html>