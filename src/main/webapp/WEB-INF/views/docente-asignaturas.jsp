<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mis Asignaturas - Docente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1 class="text-success">Asignaturas Asignadas</h1>
        <a href="/logout" class="btn btn-outline-danger">Cerrar sesión</a>
    </div>
    <div class="container">
        <h2>Como docente usted puede;  editar SOLO el horario de la asignatura que tenga asignada y visualizar todas las asignaturas asignadas</h2>

    </div>
    <div class="card shadow-sm">
        <div class="card-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="a" items="${asignaturas}">
                    <tr>
                        <td>${a.id}</td>
                        <td>${a.nombre}</td>
                        <td>
                            <a href="/docente/asignaturas/editar/${a.id}" class="btn btn-sm btn-outline-success">
                                Editar horario
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
