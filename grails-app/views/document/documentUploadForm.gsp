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