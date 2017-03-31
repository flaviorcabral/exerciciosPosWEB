<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sorteio de Numeros</title>
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
		<h2 align="center">Adivinhe o numero</h2>
		<form role="form" method="get" action="/exercicio02/tarefaservlet.do">
			<div class="form-group">
				<label for="name">Informe um numero:</label></br> <input type="text"
					class="form-control" id="numero" name="numero" style="width: 150px">
			</div>
			</br> <input type="submit" class="btn btn-info" value="Submeter">
		</form>
		</br>
		<c:if test="${not empty teste }">
			<p style="font-weight: bold">${teste}</p>
		</c:if>
	</div>
	</br>
	</br>
	</br>
	</br>
	<div align="center" class="footer">
		<h5>Projeto Java WEB JSP/Servlet</h5>
	</div>
</body>
</html>