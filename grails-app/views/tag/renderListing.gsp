<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta name="layout" content="main" />
  	
  	<title>[APP]::Tag Library</title>
  </head>
  
  <body>
  	<div class="container">
  		
  		<div class="row">
  			
  			<!-- Home Button Col -->
  			<div class="col-md-1 home-button">
  			
  				<g:if test="${session.user.level = 'ADMIN'}">
  					<g:link class="btn btn-success" controller="adminHome" action="renderHomePage"><span class="glyphicon glyphicon-home"></span> Home</g:link>
  				</g:if>
  				<g:else>
  					<g:link class="btn btn-success" controller="generalHome" action="renderHomePage"><span class="glyphicon glyphicon-home"></span> Home</g:link>
  				</g:else>
  				
  			</div> <!-- /col-md-1 -->
  				
  			<!-- Page Heading Col -->
  			<div class="col=md-12">
  				<h1>Tag Library</h1>
  			</div> <!-- /col-md-12 -->
  			
  		</div> <!-- /row -->
  		
  		<!-- Searchbar Row -->
  		<div class="row">
  			
  			<div class="col-md-8"></div> <!-- /col-md-8 -->
  			
  			<div class="col-md-4">
  				<input type="text" id="search" name="search" class="form-control" placeholder="Search" />
  			</div> <!-- /col-md-4 -->
  			
  		</div> <!-- /row -->
  		
  		<!-- Tag Table Row -->
  		<div class="row">
  		
  			<div class="col-md-12">
  			
  				<div class="table-list">
  					<table class="table table-hover">
  						<thead>
  							<th><input type="checkbox" id="selectAll" name="selectAll" /></th>
  							<th>Tag Name</th>
  							<th>Date Created</th>
  							<th>Date Updated</th>
  							<th>Options</th>
  						</thead>
  					
    					<g:each in="${tagInstanceList}" status="i" var="tag">
       	 					<tbody>
       	 						<tr>
       	 							<td><input type="checkbox" id="selectAll" name="selectAll" /></td>
            						<td>${tag.tagName}</td>
            						<td><g:formatDate date="${tag.dateCreated}" type="datetime" style="MEDIUM" timeStyle="SHORT"/></td>
            						<td><g:formatDate date="${tag.dateUpdated}" type="datetime" style="MEDIUM" timeStyle="SHORT"/></td>
            						<td>
            							<g:link controller="Tag" action="tagDetails" id="${tag.id}">View</g:link>
            							<g:if test="${session.user.level == 1}"> 
            								| <g:link controller="Tag" action="tagEditForm" id="${tag.id}">Edit</g:link>
            								| <g:link controller="Tag" action="deleteTag" id="${tag.id}">Delete</g:link>
            							</g:if>
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