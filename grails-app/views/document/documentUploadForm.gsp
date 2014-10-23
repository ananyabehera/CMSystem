<!DOCTYPE html>
<html lang="en">
	<head>
  		<meta name="layout" content="main" />
  		
  		<title>[APP]::Document Upload</title>
  	</head>
  	
  	<body>
  		<div class="container">
  		
  			<g:if test="${session.user}">
				<g:if test="${session.user.level != 'ADMIN'}">
  		
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
  			
  					<g:uploadForm controller="Document" action="upload_Doc">
  				
  						<!-- Document Upload Row -->
  						<div class="row">
  				
  							<div class="col-md-9">
  					
  								<div class="form-group">
  								 	<!--  <span class="btn btn-default btn-file">
    									Browse <input type="file" required>
									</span>
									<input type="text" id="fileText" name="fileText" class="form-control" placeholder="Document" readonly/> -->
					
							
									<input type="file" id="file" name="file" class="form-control btn-file" required />
									<p class="help-block">For best results, your document should not exceed 16KB.</p>
								</div> <!-- /form-group -->
						
  							</div> <!-- /col-md-9 -->
  				
  						</div> <!-- /row -->	
				
						<!-- Document Title Row -->
						<div class="row">
					
							<div class="col-md-9">
					
  								<div class="form-group">
									<input type="text" id="documentTitle" name="documentTitle" class="form-control" placeholder="Title" required />
								</div> <!-- /form-group -->
						
							</div> <!-- /col-md-9 -->
				
						</div> <!-- /row -->
				
						<!-- Tag Row -->
						<div class="row">
							<div class="col-md-9">
						
								<div class="form-group">
									<select multiple class="form-control">
  										<g:each in="${tagInstanceList}" status="i" var="tag">
  											<option value="${tag.id}">${tag.tagName}</option>
  										</g:each>
									</select>
								</div>
						
							</div> <!-- col-md-9 -->
					
  						</div> <!-- /row -->
				
						<!-- Document Description and Upload Button Row -->
						<div class="row">
							<div class="col-md-9">
						
								<div class="form-group">
									<textarea id="docDesc" name="docDesc" class="form-control" placeholder="Description" rows="5"></textarea>
								</div>
				
								<!-- <label>Date:</label><g:datePicker name="date"/><br/><br/> -->
								<button type="submit" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-cloud-upload"></span> Upload</button>
  				
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