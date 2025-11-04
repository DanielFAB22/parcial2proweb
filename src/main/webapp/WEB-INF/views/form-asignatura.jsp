<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario Asignatura</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
    <div class="container-fluid">
        <a class="navbar-brand" href="/rector/asignaturas">Volver</a>
    </div>
</nav>

<div class="container">
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">${asignatura.id == null ? 'Nueva Asignatura' : 'Editar Asignatura'}</h5>
        </div>
        <div class="card-body">
            <form action="/rector/asignaturas/guardar" method="post">
                <input type="hidden" name="id" value="${asignatura.id}"/>

                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="${asignatura.nombre}" required>
                </div>

                <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripción</label>
                    <textarea class="form-control" id="descripcion" name="descripcion" rows="2" required>${asignatura.descripcion}</textarea>
                </div>

                <div class="mb-3">
                    <label for="salon" class="form-label">Salón</label>
                    <input type="text" class="form-control" id="salon" name="salon" value="${asignatura.salon}" required>
                </div>

                <div class="mb-3">
                    <label for="horario" class="form-label">Horario</label>
                    <input type="text" class="form-control" id="horario" name="horario" value="${asignatura.horario}" required>
                </div>

                <div class="mb-3">
                    <label for="docenteEncargado" class="form-label">Docente Encargado</label>
                    <input type="text" class="form-control" id="docenteEncargado" name="docenteEncargado" value="${asignatura.docenteEncargado}" required>
                </div>

                <button type="submit" class="btn btn-success"> Guardar</button>
                <a href="/rector/asignaturas" class="btn btn-secondary">Cancelar</a>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
