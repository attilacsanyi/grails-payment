<!DOCTYPE html>
<%@page import="paymenttracking.Account"%>
<html>
<head>
<title>Pay Some Person</title>
<meta name="layout" content="main" />
</head>
<body>
	<br />	
	<p style="color: red">${error}</p>
	<br />	
	<div>
		<h2>Pay</h2>
		<br />
		<g:form action="doTrans">
		    <label for="origin"><b>From:</b></label><g:select name="origin" from="${accounts}" optionKey="name" optionValue="name" noSelection="['':'']"/><br />	
		    <label for="target"><b>To:</b></label><g:select name="target" from="${accounts}" optionKey="name" optionValue="name" noSelection="['':'']"/><br />	
		    <label for="amount"><b>Amount:</b></label><g:textField name="amount" value="0"/><br />	
		    <g:submitButton name="Submit"/>
		</g:form>
	</div>
	<br/>
	<p style="color: blue">${info}</p>
</body>
</html>

