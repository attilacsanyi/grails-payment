<!DOCTYPE html>
<html>
<head>
<title>See transactions</title>
<meta name="layout" content="main" />
</head>
<body>
	<br />
	<p style="color: red">${error}</p>
	<br />
	<div>
		<h2>Transactions</h2>
		<br />
		<g:form action="doSelect">
		    <label for="origin"><b>Person:</b></label><g:select name="origin" from="${accounts}" optionKey="name" optionValue="name" noSelection="['':'']"/><br />	
		    <g:submitButton name="Show transactions"/>
		</g:form>
		<g:if test="${origin}">
			<br />
			<div><h3>${origin?.name}'s balance: ${origin?.balance}</h3></div>
			<br />
			<div>
				<div><h3>Incomes</h3></div>
				<table>
					<tr>
						<td>From</td>
						<td>Amount</td>
					</tr>
					<g:each in="${transactions[0]}" var="trans">
						<tr>
							<td>${trans.origin}</td>
							<td>${trans.amount}</td>
						</tr>
					</g:each>
				</table>
				<br />
				<div><h3>Expenses</h3></div>
				<table>
					<tr>
						<td>To</td>
						<td>Amount</td>
					</tr>
					<g:each in="${transactions[1]}" var="trans">
						<tr>
							<td>${trans.target}</td>
							<td>-${trans.amount}</td>
						</tr>
					</g:each>
				</table>
			</div>
		</g:if>
	</div>
</body>
</html>