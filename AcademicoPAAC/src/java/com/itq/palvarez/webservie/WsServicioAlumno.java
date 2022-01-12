/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.itq.palvarez.webservie;

import com.itq.palvarez.modelo.Alumno;
import com.itq.palvarez.modeloDAO.AlumnoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author paul.alvarez
 */
@WebService(serviceName = "WsServicioAlumno")
public class WsServicioAlumno {

    /**
     * ServicioWeb para Datos de Alumno por Cédula
     */
    @WebMethod(operationName = "ObtenerAlumno")
    public Alumno ObtenerAlumno(@WebParam(name = "cedula") String cedula) {
        AlumnoDAO alumno = new AlumnoDAO();
        Alumno al = alumno.listarIdAlumno(cedula);
        return al;
    }

    /**
     * ServicioWeb para Crear Alumno
     */
    @WebMethod(operationName = "RegistrarAlumno")
    public boolean RegistrarAlumno(@WebParam(name = "cedula") String cedula, @WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "direccion") String direccion, @WebParam(name = "curso") int curso) {
        AlumnoDAO alumno = new AlumnoDAO();
        if (alumno.crearAlumno(cedula, nombres, apellidos, direccion, curso)) {
            return true;
        }
        return false;
    }

    /**
     * ServicioWeb para Crear Alumno
     */
    @WebMethod(operationName = "ActualizarAlumno")
    public boolean ActualizarAlumno(@WebParam(name = "id") int id, @WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "direccion") String direccion) {
        AlumnoDAO alumno = new AlumnoDAO();
        if (alumno.editarAlumno(nombres, apellidos, direccion, id)) {
            return true;
        }
        return false;
    }

    /**
     * ServicioWeb para Listar todos los Alumnos
     */
    @WebMethod(operationName = "ListarAlumnos")
    public List ListarAlumnos() {
        AlumnoDAO alumnoDao;
        List<Alumno> alumnos = new ArrayList<>();
        alumnoDao = new AlumnoDAO();
        alumnos = alumnoDao.listarAlumnos();
        return alumnos;
    }

    /**
     * ServicioWeb para Eliminar Alumno por Cédula
     */
    @WebMethod(operationName = "EliminarAlumno")
    public boolean EliminarAlumno(@WebParam(name = "cedula") String cedula) {
        AlumnoDAO alumno = new AlumnoDAO();
        if (alumno.eliminarAlumno(cedula)) {
            return true;
        }
        return false;
    }
}
