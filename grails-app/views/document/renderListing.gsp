<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta name="layout" content="main" />
  	
  	<title>[APP]::Document Library</title>
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
  				<h1>Document Library</h1>
  			</div> <!-- /col-md-12 -->
  			
  		</div> <!-- /row -->
  		
  		<!-- Searchbar Row -->
  		<div class="row">
  			
  			<div class="col-md-8"></div> <!-- /col-md-8 -->
  			
  			<div class="col-md-4">
  				<input type="text" id="search" name="search" class="form-control" placeholder="Search" />
  			</div> <!-- /col-md-4 -->
  			
  		</div> <!-- /row -->
  		
  		<!-- Document Table Row -->
  		<div class="row">
  		
  			<div class="col-md-12">
  			
  				<div class="table-list">
  					<table class="table table-hover">
  						<thead>
  							<th><input type="checkbox" id="selectAll" name="selectAll" /></th>
  							<th>Name</th>
  							<th>Date Uploaded</th>
  							<th>Type</th>
  							<th>Options</th>
  						</thead>
  					
    					<g:each in="${documentInstanceList}" status="i" var="doc">
       	 					<tbody>
       	 						<tr>
       	 							<td><input type="checkbox" id="selectAll" name="selectAll" /></td>
            						<td>${doc.name}</td>
            						<td><g:formatDate date="${doc.uploadDate}" type="datetime" style="MEDIUM" timeStyle="SHORT"/></td>
            						<td>${doc.type}</td>
            						<td>
            							<g:if test="${session.level == 'USER'}">
            								<g:link controller="Document" action="download_Doc" id="${doc.id}">Download</g:link> |
                          					<g:link controller="Document" action="documentDetails" id="${doc.id}">View</g:link>
            							</g:if>
            							<g:else>
                          					<g:link controller="Document" action="download_Doc" id="${doc.id}">Download</g:link> |
                          					<g:link controller="Document" action="documentDetails" id="${doc.id}">View</g:link> | 
                          					<g:link controller="Document" action="editDocumentForm" id="${doc.id}">Edit</g:link> |
                          					<g:link controller="Document" action="deleteDocument" id="${doc.id}">Delete</g:link>
                        				</g:else>
                        			</td>
        						</tr>
        					</tbody>
   						</g:each>
					</table>
  				</div> <!-- /table-list -->
  				
  			</div> <!-- /col-md-12 -->
  			
  		</div>	<!-- /row -->
		
  	</div> <!-- /container -->
  	
  	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  	
  </body>
</html>