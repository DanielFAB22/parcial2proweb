<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Asignaturas - Rector</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
    <div class="container-fluid">
        <span class="navbar-brand">Panel del Rector</span>
        <div class="d-flex">
            <a href="/logout" class="btn btn-outline-light btn-sm">Cerrar sesión</a>
        </div>
    </div>
</nav>
<div class="container">
    <h2>Como rector usted puede; crear, borrar, editar y visualizar todas las asignaturas</h2>

</div>
<div class="container">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2>Asignaturas</h2>
        <a href="/rector/asignaturas/nueva" class="btn btn-primary">Nueva Asignatura</a>
    </div>

    <table class="table table-hover table-bordered align-middle">
        <thead class="table-dark text-center">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Salón</th>
            <th>Horario</th>
            <th>Docente Encargado</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="asig" items="${asignaturas}">
            <tr>
                <td>${asig.id}</td>
                <td>${asig.nombre}</td>
                <td>${asig.descripcion}</td>
                <td>${asig.salon}</td>
                <td>${asig.horario}</td>
                <td>${asig.docenteEncargado}</td>
                <td class="text-center">
                    <a href="/rector/asignaturas/editar/${asig.id}" class="btn btn-warning btn-sm"> Editar</a>
                    <a href="/rector/asignaturas/eliminar/${asig.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('¿Seguro que quieres eliminar esta asignatura?');"> Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty asignaturas}">
        <div class="alert alert-info text-center">No hay asignaturas registradas.</div>
    </c:if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
