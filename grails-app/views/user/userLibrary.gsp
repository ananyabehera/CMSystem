<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta name="layout" content="main" />
  	
  	<title>[APP]::User Library</title>
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
  				<h1>User Library</h1>
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
  							<th>First Name</th>
  							<th>Last Name</th>
  							<th>Username</th>
  							<th>Authority Level</th>
  							<th>Options</th>
  						</thead>
  					
    					<g:each in="${userInstanceList}" status="i" var="user">
       	 					<tbody>
       	 						<tr>
       	 							<td><input type="checkbox" id="selectAll" name="selectAll" /></td>
            						<td>${user.firstName}</td>
            						<td>${user.lastName}</td>
            						<td>${user.username}</td>
            						<td>${user.permission.pType}</td>
            						<td><g:link controller="User" action="deleteUser" id="${user.id}">Delete</g:link></td>
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