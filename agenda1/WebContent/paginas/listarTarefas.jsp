<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Lista de Tarefas</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2 align="center">Lista de Tarefas</h2>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Data</th>
        <th>Opções</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="tarefa" items="${lista}" >
      <tr>
        <td>${tarefa.nome}</td>
        <td>${tarefa.descricao}</td>
        <td>${tarefa.data}</td>
        <td>
        	<a href="http://localhost:8080/agenda1/tarefaservlet.do?acao=excluir&nome=${tarefa.nome}">Excluir</a>
        	<a href="http://localhost:8080/agenda1/tarefaservlet.do?acao=buscaTarefa&nome=${tarefa.nome }">Editar</a>
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="http://localhost:8080/agenda1/paginas/index.html" class="btn btn-info" role="button">Voltar</a>
</div>
	<div align="center" class="footer">
		<h5>Projeto Nivelamento Java WEB</h5>
		<p>Grupo: Eric, Flávio e Luiz.</p>
		<p>Prof: Rodrigo Fujioka.</p>
  	</div>
</body>
</html>
