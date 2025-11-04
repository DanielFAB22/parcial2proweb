<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
</head>
<body>

<div class="login-container">
    <div class="login-card shadow-lg">
        <div class="text-center mb-4">
            <img src="https://cdn-icons-png.flaticon.com/512/3135/3135755.png" class="logo" alt="Logo Colegio">
            <h2 class="fw-bold text-primary mt-2">Portal del colegio</h2>
            <p class="text-muted">Acceso para Rector, Docente y Estudiante</p>
        </div>

        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="mb-3">
                <label class="form-label">Usuario</label>
                <input type="text" name="username" class="form-control form-control-lg rounded-3" placeholder="Ingrese su usuario" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Contraseña</label>
                <input type="password" name="password" class="form-control form-control-lg rounded-3" placeholder="Ingrese su contraseña" required>
            </div>

            <c:if test="${not empty param.error}">
                <div class="alert alert-danger text-center rounded-3 py-2">
                     Usuario o contraseña incorrectos.
                </div>
            </c:if>

            <c:if test="${not empty param.logout}">
                <div class="alert alert-success text-center rounded-3 py-2">
                     Has cerrado sesión correctamente.
                </div>
            </c:if>

            <button type="submit" class="btn btn-primary w-100 py-2 rounded-3 mt-3">
                Ingresar al sistema
            </button>
        </form>


    </div>
</div>

</body>
</html>
