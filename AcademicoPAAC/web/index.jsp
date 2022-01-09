<%-- 
    Document   : index
    Created on : 02/01/2021, 17:30:30
    Author     : paul.alvarez
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    HttpSession objsesion = request.getSession(false);
    String usuario = (String) objsesion.getAttribute("usuario");
    if(usuario.equals("")){
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
                            <a class="nav-link" href="Controlador?accion=Perfil"  style="color: white;">Bienvenido <% out.println(usuario); %></a>
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
                <div class="card" style="width: 30%; margin: 10px;">
                    <div class="card-body">
                        <h5 class="card-title">Agregar Alumno</h5>
                        <p class="card-text">Aquí puedes agregar o registrar Usuarios Estudiantes.</p>
                        <a href="Controlador?accion=AgregarAlumno" class="btn btn-primary">Ir</a>
                    </div>
                </div>
                <div class="card" style="width: 30%; margin: 10px;">
                    <div class="card-body">
                        <h5 class="card-title">Agregar Curso</h5>
                        <p class="card-text">Aquí puedes agregar o crear Cursos.</p>
                        <a href="Controlador?accion=AgregarCurso" class="btn btn-primary">Ir</a>
                    </div>
                </div>
                <div class="card" style="width: 30%; margin: 10px;">
                    <div class="card-body">
                        <h5 class="card-title">Agregar Materia</h5>
                        <p class="card-text">Aquí puedes agregar o registrar Materias.</p>
                        <a href="Controlador?accion=AgregarMateria" class="btn btn-primary">Ir</a>
                    </div>
                </div>
                <div class="card" style="width: 30%; margin: 10px;">
                    <div class="card-body">
                        <h5 class="card-title">Lista Alumnos</h5>
                        <p class="card-text">Aquí podras ver la lista de todos los Usuarios Estudiantes.</p>
                        <a href="Controlador?accion=ListaAlumnos" class="btn btn-primary">Ir</a>
                    </div>
                </div>
                
                <div class="card" style="width: 30%; margin: 10px;">
                    <div class="card-body">
                        <h5 class="card-title">Lista Cursos</h5>
                        <p class="card-text">Aquí podras ver la lista de todos los Cursos.</p>
                        <a href="Controlador?accion=ListaCursos" class="btn btn-primary">Ir</a>
                    </div>
                </div>
                <div class="card" style="width: 30%; margin: 10px;">
                    <div class="card-body">
                        <h5 class="card-title">Lista Materias</h5>
                        <p class="card-text">Aquí podras ver la lista de todos las Materias.</p>
                        <a href="Controlador?accion=ListaMaterias" class="btn btn-primary">Ir</a>
                    </div>
                </div>
                <div class="card" style="width: 30%; margin: 10px;">
                    <div class="card-body">
                        <h5 class="card-title">Registrar Notas</h5>
                        <p class="card-text">Aquí podras registrar las notas de los Estudiantes.</p>
                        <a href="Controlador?accion=AgregarNota" class="btn btn-primary">Ir</a>
                    </div>
                </div>

                <div class="card" style="width: 30%; margin: 10px;">
                    <div class="card-body">
                        <h5 class="card-title">Lista de Notas</h5>
                        <p class="card-text">Aquí podras ver la lista de Notas por Alumno.</p>
                        <a href="Controlador?accion=ListaNotas" class="btn btn-primary">Ir</a>
                    </div>
                </div>
                <div class="card" style="width: 30%; margin: 10px;">
                    <div class="card-body">
                        <h5 class="card-title">Agregar Usuario Sistema</h5>
                        <p class="card-text">Aquí podras ver registrar usuarios tipo Docentes al Sistema.</p>
                        <a href="Controlador?accion=AgregarUsuario" class="btn btn-primary">Ir</a>
                    </div>
                </div>
            </div>
            <a></a>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    </body>
</html>
