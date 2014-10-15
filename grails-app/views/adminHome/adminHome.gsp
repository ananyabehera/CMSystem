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
		<g:if test="${session.user}">
			<br/>
			Welcome to your HomePage: ${session.user.userName} | <g:link action="logout" controller="User">Logout</g:link>
			<g:form style="padding-left:200px" controller="AdminHome" >
				<br/>
				<g:actionSubmit value="Upload Document" action="uploadDoc"/>
			</g:form>
		</g:if>
		<g:else>
			You are not Logged In! <g:link href="/index"> Login Page</g:link>
		</g:else>
	</body>
</html>
