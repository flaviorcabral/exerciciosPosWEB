<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Tela de cadastro</title>
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
		<h2 align="center">Efetuar Cadastro</h2>
		<form role="form" method="get" action="/reservasPos/usuarioServlet.do"
			style="">
			<div class="form-group">
				<label for="name">Nome:</label> <input type="text"
					class="form-control" id="nome" placeholder="Informe um nome"
					name="nome" required="required">
			</div>
			<div class="form-group">
				<label for="descricao">Username:</label> <input type="text"
					class="form-control" id="username"
					placeholder="Informe nome de usuario" name="username"
					required="required">
			</div>
			<div class="form-group">
				<label for="data">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Informe uma senha"
					name="password" required="required">
			</div>
			<input type="submit" class="btn btn-info" value="Cadastrar">
			<input type="hidden" name="acao" value="salvar"> <a
				href="http://localhost:8080/reservasPos/paginas/index.jsp"
				class="btn btn-info" role="button">Voltar</a>
		</form>
	</div>
	<div align="center" class="footer">
		</br> </br> </br> </br>
		<h5>Projeto Java WEB JSP/Servlet</h5>

	</div>
</body>
</html>

