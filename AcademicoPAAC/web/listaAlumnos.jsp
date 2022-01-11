<%-- 
    Document   : alumno
    Created on : 05/01/2022, 17:30:30
    Author     : paul.alvarez
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsesion = request.getSession(false);
    String usuario = (String) objsesion.getAttribute("usuario");
    if (usuario.equals("")) {
        usuario = "usuario";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Académico PAAC</title>
        <link rel="stylesheet" href="//use.fontawesome.com/releases/v5.0.7/css/all.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg" style="background-color: deepskyblue;">
            <div class="container-fluid">
                <a class="navbar-brand" href="Controlador?accion=home"  style="color: white;">Sistema Académico PAAC</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="Controlador?accion=home"  style="color: white;">Inicio</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?accion=Perfil"  style="color: white;">Bienvenido <% out.println(usuario);%></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"  style="color: white;">
                                Configuraciones
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="Controlador?accion=Perfil"  style="color: black;">Mi Perfil</a></li>
                                <li><hr class="dropdown-divider"></li>                                
                                <li><a class="dropdown-item" href="Controlador?accion=CerrarSesion"  style="color: black;">Cerrar Sesión</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container mt-2">
            <div class="row">
                <center>
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-header">
                                Lista Alumnos
                            </div>
                            <form action="Controlador?accion=ListaAlumnosPorCurso" method="post">
                                <div class="card-body">
                                    <select name="curso" class="form-select" aria-label="Default select example">
                                        <option selected>Seleccione el curso</option>
                                        <option value="1">1ero Básica</option>
                                        <option value="2">2do Básica</option>
                                        <option value="3">3ero Básica</option>
                                        <option value="4">4to Básica</option>
                                        <option value="5">5to Básica</option>
                                        <option value="6">6to Básica</option>
                                        <option value="7">7mo Básica</option>
                                        <option value="8">8vo Básica</option>
                                        <option value="9">1ero Bachillerato</option>
                                        <option value="10">2do Bachillerato</option>
                                        <option value="11">3ero Bachillerato</option>
                                    </select>
                                    <input type="submit" class="btn btn-info" value="Buscar" style="margin-top: 10px; color: white;"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </center>
            </div>
        </div>

        <div class="container mt-2">
            <div class="row">
                <div class="card-header">
                    Resultado Alumnos:
                </div>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Cedula</th>
                            <th scope="col">Alumno</th>
                            <th scope="col">Direccion</th>
                            <th scope="col">Curso</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${alumnosPorCurso}">
                            <tr>
                                <td>${p.getCedula()}</td>
                                <td>${p.getNombres()}  ${p.getApellidos()}</td>
                                <td>${p.getDireccion()}</td>
                                <td>${p.getCurso()}</td>
                                <td>
                                    <a href="Controlador?accion=RegistrarNota&id=${p.getCedula()}&curso=${p.getCurso()}&nombres=${p.getNombres()}&apellidos=${p.getApellidos()}" class="btn btn-outline-success"><i class="fas fa-check"> Notas</i></a>
                                    <a href="Controlador?accion=EditarAlumno&id=${p.getCedula()}&nombres=${p.getNombres()}&apellidos=${p.getApellidos()}&direccion=${p.getDireccion()}&curso=${p.getCurso()}" class="btn btn-outline-info"><i class="fas fa-edit"></i></a>
                                    <a href="Controlador?accion=EliminarAlumno&id=${p.getCedula()}" class="btn btn-danger"><i class="fas fa-trash"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    </body>
</html>
