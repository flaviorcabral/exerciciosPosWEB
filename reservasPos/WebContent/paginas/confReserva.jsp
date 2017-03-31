
<%
	if (session.getValue("login") == null) {
		//RequestDispatcher rd = request.getRequestDispatcher("/paginas/index.jsp");	
		response.sendRedirect("/reservasPos/paginas/index.jsp");
	}
%>
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
<title>Status da Reserva</title>
</head>
<body>
	<h2 align="center">Status da reserva</h2>
	</br>
	</br>
	</br>
	<div align="center" class="footer">
		<c:if test="${status == 'ok'}">
			<p>
				Assento <span style="font-weight: bold;">${fila }${poltrona}</span>
				reservado com sucesso!
			</p>
		</c:if>

		<c:if test="${status == 'reservado'}">
			<p>
				Não foi possivel reservar o assento <span style="font-weight: bold;">${fila }${poltrona}</span>.
				Ele já está ocupado. Selecione outro, por favor!
			</p>
		</c:if>

		<c:if test="${status == 'lotado'}">
			<p>
				Overbooking! <span style="font-weight: bold;">Voo lotado!!</span>
			</p>
		</c:if>

		<a href="http://localhost:8080/reservasPos/paginas/check.jsp"
			class="btn btn-info" role="button">Voltar</a></br>
		</br>
		</br>
		</br>
		<h5>Projeto Java WEB JSP/Servlet</h5>
	</div>
</body>
</html>