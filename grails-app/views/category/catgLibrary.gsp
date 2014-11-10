<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta name="layout" content="main" />
  	
  	<title>[APP]::Category Library</title>
  </head>
  
  <body>
  	<div class="container">
  		
  		<div class="row">
  			
  			<!-- Home Button Col -->
  			<div class="col-md-1 home-button">
  				<g:link class="btn btn-success" controller="landingPage" action="renderHomePage"><span class="glyphicon glyphicon-home"></span> Home</g:link>
  			</div> <!-- /col-md-1 -->
  				
  			<!-- Page Heading Col -->
  			<div class="col=md-12">
  				<h1>Category Library</h1>
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
  							<th>Category Name</th>
  							<th>Date Created</th>
  							<th>Date Updated</th>
  							<th>Options</th>
  						</thead>
  					
    					<g:each in="${catgInstanceList}" status="i" var="catg">
       	 					<tbody>
       	 						<tr>
       	 							<td><input type="checkbox" id="selectAll" name="selectAll" /></td>
            						<td>${catg.catgName}</td>
            						<td><g:formatDate date="${catg.dateCreated}" type="datetime" style="MEDIUM" timeStyle="SHORT"/></td>
            						<td><g:formatDate date="${catg.dateUpdated}" type="datetime" style="MEDIUM" timeStyle="SHORT"/></td>
            						<td>
            							<g:link controller="Category" action="catgDetails" id="${catg.id}">View</g:link>
            							<g:if test="${session.user.permissionId == 1}"> 
            								| <g:link controller="Category" action="catgEditForm" id="${catg.id}">Edit</g:link>
            								| <g:link controller="Category" action="delete" id="${catg.id}">Delete</g:link>
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