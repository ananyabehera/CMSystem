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
		${flash.message}
		<g:if test="${session.user}">
			<br/>
			Logged In as: ${session.user} | <g:link action="logout" controller="User">Logout</g:link> 
		</g:if>
		<g:else>
			<g:form action="login" style="padding-left:200px" controller="User"> <!-- send form request to action named "login" -->
				<div style="width:220px;">
					<label>Name:</label><input type="text" name="userName"/>
					<label>Password:</label><input type="password" name="password"\>
					<label>&nbsp;</label><input type="submit" name="login"/>
				</div>
			</g:form>
		</g:else>
	</body>
</html>
