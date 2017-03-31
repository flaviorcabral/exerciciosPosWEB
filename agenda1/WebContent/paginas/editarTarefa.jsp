<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Gerenciador de Tarefas</title>
</head>
<body>
	<div class="container">
  <h2 align="center">Gerenciador de Tarefas</h2>
  <form role="form" method="get" action="/agenda1/tarefaservlet.do">
    <div class="form-group">
      <label for="name">Nome:</label>
      <input type="text" class="form-control" id="nome" name="nome" value="${tarefa.nome}">
    </div>
    <div class="form-group">
      <label for="descricao">Descrição:</label>
      <input type="text" class="form-control" id="descricao" name="descricao" value="${tarefa.descricao}">
    </div>
    <div class="form-group">
      <label for="data">Data:</label>
      <input type="text" class="form-control" id="data" name="data" value="${tarefa.data}">
    </div>
    <button type="submit" class="btn btn-info" role="button">Atualizar</button>
    <input type="hidden" name="acao" value="editar">
    <a href="http://localhost:8080/agenda1/tarefaservlet.do?acao=listar" class="btn btn-info" role="button">Listar</a>
    <a href="http://localhost:8080/agenda1/paginas/index.html" class="btn btn-info" role="button">Voltar</a>
  </form>
</div>
	<div align="center" class="footer">
		<h5>Projeto Nivelamento Java WEB</h5>
		<p>Grupo: Eric, Flávio e Luiz.</p>
		<p>Prof: Rodrigo Fujioka.</p>
  	</div>
</body>
</html>