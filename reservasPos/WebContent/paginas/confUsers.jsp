<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Registro Salvo</title>
</head>
<body>
	<div align="center" class="footer">

		<c:if test="${status == 'cadOK'}">
			<h3>Registro incluido com sucesso!</h3>
			<a href="http://localhost:8080/reservasPos/paginas/cadastro.jsp"
				class="btn btn-info" role="button">Novo Cadastro</a>
			<a href="http://localhost:8080/reservasPos/paginas/index.jsp"
				class="btn btn-info" role="button">Acessar</a>
		</c:if>

		<c:if test="${status == 'erroCad'}">
			<h3>Erro! Já existe um usuário com esse mesmo Username!</h3>
			<a href="http://localhost:8080/reservasPos/paginas/cadastro.jsp"
				class="btn btn-info" role="button">Voltar</a>
		</c:if>

		<c:if test="${status == 'erroLogin'}">
			<h3>Erro! Login/senha incorretos ou não possui cadastro!</h3>
			<a href="http://localhost:8080/reservasPos/paginas/index.jsp"
				class="btn btn-info" role="button">Voltar</a>
			<a href="http://localhost:8080/reservasPos/paginas/cadastro.jsp"
				class="btn btn-info" role="button">Cadastrar</a>
		</c:if>

		</br> </br> </br> </br>
		<h5>Projeto Java WEB JSP/Servlet</h5>
	</div>
</body>
</html>