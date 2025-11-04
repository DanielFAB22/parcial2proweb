<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mis Asignaturas - Estudiante</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1 class="text-info">Mis Asignaturas</h1>
        <a href="/logout" class="btn btn-outline-danger">Cerrar sesión</a>
    </div>
    <div class="container">
        <h2>Como estudiante usted puede; SOLO visualizar todas las asignaturas</h2>

    </div>
    <div class="card shadow-sm">
        <div class="card-body">
            <table class="table table-bordered table-striped">
                <thead class="table-light">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Docente</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="a" items="${asignaturas}">
                    <tr>
                        <td>${a.id}</td>
                        <td>${a.nombre}</td>
                        <td>${a.docenteEncargado}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

