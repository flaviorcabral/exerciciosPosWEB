<!DOCTYPE html>
<html lang="pt-br">
<head>
<title></title>
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
		<h2 align="center">Pagina de Login</h2>
		<form role="form" method="get" action="/reservasPos/usuarioServlet.do">
			<div class="form-group">
				<label for="name">Usuario:</label> <input type="text"
					class="form-control" id="usuario" placeholder="Informe o usuario"
					name="usuario" required="required">
			</div>
			<div class="form-group">
				<label for="descricao">Senha:</label> <input type="password"
					class="form-control" id="senha" placeholder="Informe sua senha"
					name="senha" required="required">
			</div>
			<input type="submit" class="btn btn-info" value="Acessar"> <input
				type="hidden" name="acao" value="logar"> <a
				href="http://localhost:8080/reservasPos/usuarioServlet.do?acao=cadastrar"
				class="btn btn-info" role="button">Cadastra-se</a>
		</form>
	</div>
	<div align="center" class="footer">
		</br> </br> </br> </br>
		<h5>Projeto Java WEB JSP/Servlet</h5>

	</div>
</body>
</html>

