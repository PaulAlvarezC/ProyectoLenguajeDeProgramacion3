/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itq.palvarez.controlador;

import com.itq.palvarez.modelo.Alumno;
import com.itq.palvarez.modelo.Materia;
import com.itq.palvarez.modelo.Notas;
import com.itq.palvarez.modeloDAO.AlumnoDAO;
import com.itq.palvarez.modeloDAO.MateriaDAO;
import com.itq.palvarez.modeloDAO.NotasDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paul.alvarez
 */
public class Controlador extends HttpServlet {

    String cedula = null;
    String nombres = null;
    String apellidos = null;
    String direccion = null;
    String id = null;
    String curso = null;
    float n1;
    float n2;
    float n3;
    float promedio;
    String observaciones = null;

    AlumnoDAO alumnoDao;
    MateriaDAO materiaDao;
    NotasDAO notasDao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        //productos = pdao.listar();
        switch (accion) {

            case "Login":
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case "Register":
                request.getRequestDispatcher("register.jsp").forward(request, response);
                break;
            case "AgregarUsuario":
                request.getRequestDispatcher("usuario.jsp").forward(request, response);
                break;

            //CURSOS
            case "AgregarCurso":
                request.getRequestDispatcher("curso.jsp").forward(request, response);
                break;

            //MATERIAS
            case "AgregarMateria":
                request.getRequestDispatcher("materia.jsp").forward(request, response);
                break;
            case "ListaMateriasPorCurso":
                curso = request.getParameter("curso");
                System.out.println("SALIDA: " + curso);
                List<Materia> materias = new ArrayList<>();
                materiaDao = new MateriaDAO();
                materias = materiaDao.listarMateriasPorCurso(curso);
                request.setAttribute("materiasPorCurso", materias);
                request.getRequestDispatcher("listaMaterias.jsp").forward(request, response);
                break;
            case "EditarMateria":
                id = request.getParameter("id");
                System.out.println("SALIDA: " + id);

                break;
            case "EliminarMateria":
                id = request.getParameter("id");
                System.out.println("SALIDA: " + id);
                materiaDao = new MateriaDAO();
                if (materiaDao.eliminarMateria(id)) {
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                break;
            case "ListaMaterias":
                request.getRequestDispatcher("listaMaterias.jsp").forward(request, response);
                break;

            //NOTAS
            case "RegistrarNota":
                cedula = request.getParameter("id");
                System.out.println("SALIDA: " + cedula);
                nombres = request.getParameter("nombres");
                System.out.println("SALIDA: " + nombres);
                apellidos = request.getParameter("apellidos");
                System.out.println("SALIDA: " + apellidos);
                curso = request.getParameter("curso");
                System.out.println("SALIDA: " + curso);
                request.setAttribute("cedulaAtt", cedula);
                request.setAttribute("nombresAtt", nombres);
                request.setAttribute("apellidosAtt", apellidos);
                request.setAttribute("cursoAtt", curso);

                List<Materia> materiasLista = new ArrayList<>();
                materiaDao = new MateriaDAO();
                materiasLista = materiaDao.listarMateriasPorCurso(curso);
                request.setAttribute("materiasLista", materiasLista);
                request.getRequestDispatcher("registrarNotas.jsp").forward(request, response);
                break;
            case "ListaNotas":
                List<Alumno> alumnosLista = new ArrayList<>();
                alumnoDao = new AlumnoDAO();
                alumnosLista = alumnoDao.listarAlumnos();
                request.setAttribute("alumnosLista", alumnosLista);
                request.getRequestDispatcher("listaNotas.jsp").forward(request, response);
                break;
            case "ListaNotasPorAlumno":
                cedula = request.getParameter("alumno");
                System.out.println("SALIDA: " + cedula);

                List<Notas> notas = new ArrayList<>();
                notasDao = new NotasDAO();
                notas = notasDao.listarNotasPorIdAlumno(cedula);
                request.setAttribute("notasPorAlumno", notas);
                request.getRequestDispatcher("listaNotas.jsp").forward(request, response);
                break;
            case "EditarNotas":
                id = request.getParameter("id");
                n1 = Float.parseFloat(request.getParameter("nota1"));
                n2 = Float.parseFloat(request.getParameter("nota2"));
                n3 = Float.parseFloat(request.getParameter("nota3"));
                observaciones = request.getParameter("observaciones");

                System.out.println("SALIDA: " + id);
                request.setAttribute("idNotas", Integer.parseInt(id));
                request.setAttribute("n1", n1);
                request.setAttribute("n2", n2);
                request.setAttribute("n3", n3);
                request.setAttribute("observaciones", observaciones);
                request.getRequestDispatcher("editarNotas.jsp").forward(request, response);
                break;
            case "EliminarNotas":
                id = request.getParameter("id");
                System.out.println("SALIDA: " + id);
                notasDao = new NotasDAO();
                if (notasDao.eliminarNotas(Integer.parseInt(id))) {
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                break;

            //ALUMNOS
            case "AgregarAlumno":
                request.getRequestDispatcher("alumno.jsp").forward(request, response);
                break;
            case "ListaAlumnos":
                request.getRequestDispatcher("listaAlumnos.jsp").forward(request, response);
                break;
            case "ListaAlumnosPorCurso":
                curso = request.getParameter("curso");
                System.out.println("SALIDA: " + curso);
                List<Alumno> alumnos = new ArrayList<>();
                alumnoDao = new AlumnoDAO();
                alumnos = alumnoDao.listarAlumnosPorCurso(curso);
                request.setAttribute("alumnosPorCurso", alumnos);
                request.getRequestDispatcher("listaAlumnos.jsp").forward(request, response);
                break;
            case "EditarAlumno":
                id = request.getParameter("id");
                nombres = request.getParameter("nombres");
                apellidos = request.getParameter("apellidos");
                direccion = request.getParameter("direccion");
                curso = request.getParameter("curso");

                System.out.println("SALIDA: " + id);
                request.setAttribute("idAlumno", Integer.parseInt(id));
                request.setAttribute("nombresAlumno", nombres);
                request.setAttribute("apellidosAlumno", apellidos);
                request.setAttribute("direccionAlumno", direccion);
                request.setAttribute("cursoAlumno", curso);
                request.getRequestDispatcher("editarAlumno.jsp").forward(request, response);
                break;
            case "EliminarAlumno":
                cedula = request.getParameter("id");
                System.out.println("SALIDA: " + cedula);
                alumnoDao = new AlumnoDAO();
                if (alumnoDao.eliminarAlumno(cedula)) {
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                break;

            case "Perfil":
                request.getRequestDispatcher("perfil.jsp").forward(request, response);
                break;
            case "Success":
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case "Error":
                request.getRequestDispatcher("error.jsp").forward(request, response);
                break;
            case "CerrarSesion":
                HttpSession objsesion = request.getSession(true);
                objsesion.setAttribute("usuario", "");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
