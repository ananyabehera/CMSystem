<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main" />
		
		<title>[APP]::Admin Home</title>
	</head>
	<body>
		
		<div class="container">
			<g:if test="${session.user}">
				<h1>
					Welcome ${session.user.firstName} ${session.user.lastName}
					<g:link class="small" controller="Nav" action="loginPage">Logout?</g:link>
				</h1>
				<g:if test="${session.user.permissionId == 1}">
					
					<!-- Document and Sorting Row -->
					<div class="row">
						
						<!-- Document Options Col -->
						<div class="col-md-6">
							<h2>Document Options:</h2>
							<g:link class="btn btn-success btn-default btn-block" controller="Nav" action="documentUploadPage"><span class="glyphicon glyphicon-cloud-upload"></span> Upload Document</g:link>
							<g:link class="btn btn-primary btn-default btn-block" controller="Nav" action="documentLibraryPage"><span class="glyphicon glyphicon-list-alt"></span> Document Library</g:link>
						
							<g:uploadForm class="form-inline" controller="Nav" action="documentSearch">
								<div class="form-group search">
									<input type="text" id="search" name="search" class="form-control" placeholder="Search" maxlength="100" required />
									<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Search Document</button>
								</div>
							</g:uploadForm>
						</div> <!-- /col-md-6 -->
						
						<!-- Sorting Options Col -->
						<div class="col-md-6">
							<h2>Sorting Options:</h2>
							<g:link class="btn btn-success btn-default btn-block" controller="Nav" action="createCategoryPage"><span class="glyphicon glyphicon-plus"></span> Create Category</g:link>
							<g:link class="btn btn-primary btn-default btn-block" controller="Nav" action="categoryLibraryPage"><span class="glyphicon glyphicon-list-alt"></span> Category Library</g:link>
							
							<g:uploadForm class="form-inline" controller="Nav" action="categorySearch">
								<div class="form-group search">
									<input type="text" id="search" name="search" class="form-control" placeholder="Search" maxlength="100" required />
									<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Search Category</button>
								</div>
							</g:uploadForm>
							
							<g:link class="btn btn-success btn-default btn-block" controller="Nav" action="createTagPage"><span class="glyphicon glyphicon-plus"></span> Create Tag</g:link>
							<g:link class="btn btn-primary btn-default btn-block" controller="Nav" action="tagLibraryPage"><span class="glyphicon glyphicon-list-alt"></span> Tag Library</g:link>
							
							<g:uploadForm class="form-inline" controller="Nav" action="tagSearch">
								<div class="form-group search">
									<input type="text" id="search" name="search" class="form-control" placeholder="Search" maxlength="100" required />
									<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Search Tag</button>
								</div>
							</g:uploadForm>
						</div> <!-- /col-md-6 -->
						
					</div> <!-- /row -->
					
					<!-- User Options Row -->
					<div class="row">
						
						<!-- User Options Col -->
						<div class="col-md-6">
							<h2>User Options:</h2>
							<g:link class="btn btn-success btn-default btn-block" controller="Nav" action="createUserPage"><span class="glyphicon glyphicon-plus"></span> Create User</g:link>
							<g:link class="btn btn-primary btn-default btn-block" controller="Nav" action="userLibraryPage"><span class="glyphicon glyphicon-list-alt"></span> User Library</g:link>
							
							<g:uploadForm class="form-inline" controller="Nav" action="userSearch">
								<div class="form-group search">
									<input type="text" id="search" name="search" class="form-control" placeholder="Search" maxlength="100" required />
									<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Search User</button>
								</div>
							</g:uploadForm>
							
						</div> <!-- /col-md-6 -->
						
					</div> <!-- /row -->
				</g:if>
				<g:else>
					<!-- Document and Sorting Row -->
					<div class="row">
						
						<!-- Document Options Col -->
						<div class="col-md-6">
							<h2>Document Options:</h2>
							<g:link class="btn btn-primary btn-default btn-block" controller="Nav" action="documentLibraryPage"><span class="glyphicon glyphicon-list-alt"></span> Document Library</g:link>
						
							<g:uploadForm class="form-inline" controller="Nav" action="documentSearch">
								<div class="form-group search">
									<input type="text" id="search" name="search" class="form-control" placeholder="Search" maxlength="100" required />
									<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Search Document</button>
								</div>
							</g:uploadForm>
						
						</div> <!-- /col-md-6 -->
						
						<!-- Sorting Options Col -->
						<div class="col-md-6">
							<h2>Sorting Options:</h2>
							<g:link class="btn btn-primary btn-default btn-block" controller="Nav" action="categoryLibraryPage"><span class="glyphicon glyphicon-list-alt"></span> Category Library</g:link>
							
							<g:uploadForm class="form-inline" controller="Nav" action="categorySearch">
								<div class="form-group search">
									<input type="text" id="search" name="search" class="form-control" placeholder="Search" maxlength="100" required />
									<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Search Category</button>
								</div>
							</g:uploadForm>
							
							<g:link class="btn btn-primary btn-default btn-block" controller="Nav" action="tagLibraryPage"><span class="glyphicon glyphicon-list-alt"></span> Tag Library</g:link>						
						
							<g:uploadForm class="form-inline" controller="Nav" action="tagSearch">
								<div class="form-group search">
									<input type="text" id="search" name="search" class="form-control" placeholder="Search" maxlength="100" required />
									<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Search Tag</button>
								</div>
							</g:uploadForm>
						
						</div> <!-- /col-md-6 -->
						
					</div> <!-- /row -->
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
