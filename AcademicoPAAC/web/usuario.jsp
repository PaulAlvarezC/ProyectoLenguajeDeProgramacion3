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
                <center>
                <div class="col-sm-6">
                    <div class="card">
                        <div class="card-header">
                            Agregar Usuario
                        </div>
                        <form action="RegistrarUsuario" method="post">
                            <div class="card-body">
                                <div class="input-group mb-3">                        
                                    <input type="text" class="form-control" name="cedula" placeholder="Cédula" aria-label="Cédula" aria-describedby="basic-addon1" required>
                                </div>
                                <div class="input-group mb-3">                        
                                    <input type="text" class="form-control" name="nombres" placeholder="Nombres" aria-label="Nombres" aria-describedby="basic-addon1" required>
                                </div>
                                <div class="input-group mb-3">                        
                                    <input type="text" class="form-control" name="apellidos" placeholder="Apellidos" aria-label="Apellidos" aria-describedby="basic-addon1" required>
                                </div>
                                <div class="input-group mb-3">                        
                                    <input type="text" class="form-control" name="usuario" placeholder="Usuario" aria-label="Usuario" aria-describedby="basic-addon1" required>
                                </div>
                                <div class="input-group mb-3">                        
                                    <input type="password" class="form-control" name="password" placeholder="Password" aria-label="Password" aria-describedby="basic-addon1" required>
                                </div>
                                <input type="submit" class="btn btn-primary" value="Agregar"/>
                            </div>
                        </form>
                    </div>
                </div>
            </center>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    </body>
</html>
