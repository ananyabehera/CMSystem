<!DOCTYPE html>
'<html>
  <head></head>
  <body>
  	<table border="1">
    	<g:each in="${documentInstanceList}" status="i" var="doc">
       	 	<tr>
            	<td>${doc.name}</td>
            	<td>${doc.uploadDate}</td>
        	</tr>
   		</g:each>
	</table>
  </body>
</html>