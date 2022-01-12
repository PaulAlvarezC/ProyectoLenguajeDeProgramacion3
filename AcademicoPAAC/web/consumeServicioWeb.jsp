<%-- 
    Document   : consumeServicioWeb
    Created on : 11-ene-2022, 17:22:27
    Author     : paul.alvarez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Servicio Web para Alumnos</h1>
        <form action="sObtenAlumno" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th>Cédula Alumno: </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <input type="text" name="cedula" value="" />
                        </td>
                        <td>
                            <input type="submit" value="Buscar Alumno" name="btnBuscar"/>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
