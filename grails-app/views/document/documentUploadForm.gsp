<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	<link rel="icon" href="../../favicon.ico">

    	<title>Document Upload</title>

    	<!-- Bootstrap core CSS -->
    	<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" />
    	<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'custom.css')}" />

    	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    	<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    	<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    	<!--[if lt IE 9]>
      		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    	<![endif]-->
  	</head>
  	<body>
  		<div class="container">
  			<div class="row">
  				
  				<!-- Button Col -->
  				<div class="col-md-1">
  					<button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-home"></span> Home</button>
  				</div> <!-- /col-md-1 -->
  				
  				<!-- Page Heading Col -->
  				<div class="col=md-1">
  					<h1>Upload Document</h1>
  				</div> <!-- /col-md-1 -->
  				
  			</div> <!-- /row -->
  			
  			<g:uploadForm controller="Document" action="upload_Doc" role="uploadForm">
  				
  				<!-- Document Upload Row -->
  				<div class="row">
  				
  					<div class="col-md-9">
  					
  						<div class="form-group">
  						 	<!--  <span class="btn btn-default btn-file">
    							Browse <input type="file" required>
							</span>
							<input type="text" id="fileText" name="fileText" class="form-control" placeholder="Document" readonly/> -->
					
							<label for="file">Document</label><br/>
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
				
				<!-- Document Description and Upload Button Row -->
				<div class="row">
					<div class="col-md-9">
						
						<div class="form-group">
							<textarea id="documentDesc" name="documentDesc" class="form-control" placeholder="Description" rows="5"></textarea>
						</div>
				
						<!-- <label>Date:</label><g:datePicker name="date"/><br/><br/> -->
						<button type="submit" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-cloud-upload"></span> Upload</button>
  				
					</div> <!-- col-md-9 -->
					
  				</div> <!-- /row -->
			
			</g:uploadForm>
			
		</div> <!-- /container -->
	</body>
</html>

<!--
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title></title>
		<style type="text/css">
			label{
				float:left;
				width:65px;			
			}
		</style>
	</head>
	<body>
		<g:uploadForm controller="Document" action="upload_Doc">
			<div style="width:720px;">
				<label>Name:</label><input type="text" name="userName"/><br/>
				<label>Date:</label><g:datePicker name="date"/><br/><br/>
				<label for="file">Document</label><br/>
			    <input type="file" name="file" id="file" /><br/>
			    <div style="font-size:0.8em; margin: 1.0em;">
			      For best results, your document should not exceed 16KB.
			    </div>
			    <input type="submit" class="buttons" value="Upload" />
			</div>
		</g:uploadForm>
	</body>
</html>
 -->