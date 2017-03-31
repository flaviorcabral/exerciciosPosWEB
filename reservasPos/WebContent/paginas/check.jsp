
<%
	if (session.getValue("login") == null) {
		//RequestDispatcher rd = request.getRequestDispatcher("/paginas/index.jsp");	
		response.sendRedirect("/reservasPos/paginas/index.jsp");
	}
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Painel de reservas</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 align="center">Bem vindo ao check in</h2>
		<form method="get" action="/reservasPos/reservaServlet.do">
			<div class="form-group">
				<label for="name">Escolha sua fila:</label> <select name="fila">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
			</div>
			<div class="form-group">
				<label for="descricao">Escolha sua poltrona:</label> <select
					name="poltrona">
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
				</select>
			</div>
			<input type="submit" class="btn btn-info" value="Reservar"> <input
				type="hidden" name="acao" value="reservar"> <a
				href="http://localhost:8080/reservasPos/usuarioServlet.do?acao=sair"
				class="btn btn-info" role="button">Sair</a>
		</form>
	</div>
	<div align="center" class="footer">
		</br> </br> </br> </br>
		<h5>Projeto Java WEB JSP/Servlet</h5>

	</div>
</body>
</html>

