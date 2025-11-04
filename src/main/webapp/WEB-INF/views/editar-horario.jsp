<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Horario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
    <div class="card mx-auto shadow-sm" style="max-width: 500px;">
        <div class="card-body">
            <h3 class="card-title mb-4 text-center text-success">Editar Horario</h3>
            <form method="post" action="/docente/asignaturas/guardarHorario">
                <input type="hidden" name="id" value="${asignatura.id}">
                <div class="mb-3">
                    <label class="form-label">Nombre:</label>
                    <input type="text" class="form-control" value="${asignatura.nombre}" disabled>
                </div>
                <div class="mb-3">
                    <label class="form-label">Nuevo Horario:</label>
                    <input type="text" class="form-control" name="horario" value="${asignatura.horario}" required>
                </div>
                <button type="submit" class="btn btn-success w-100">Guardar Cambios</button>
                <a href="/docente/asignaturas" class="btn btn-secondary w-100 mt-2">Cancelar</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>
