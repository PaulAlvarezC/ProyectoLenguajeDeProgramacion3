/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itq.palvarez.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paul.alvarez
 */
public class RegistrarNotas extends HttpServlet {

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
        String alumno = request.getParameter("alumno");
        String curso = request.getParameter("curso");
        String materia = request.getParameter("materia");
        String nota1 = request.getParameter("nota1");
        String nota2 = request.getParameter("nota2");
        String nota3 = request.getParameter("nota3");
        String promedio = request.getParameter("promedio");
        String observaciones = request.getParameter("observaciones");
        
        System.out.println("SALIDA: " + alumno + " " + curso + " " + materia + " " + nota1 + " " + nota2 + " " + nota3 + " " + promedio + " " + observaciones);
        
        /*Autenticacion login = new Autenticacion();
        if(login.registrar(cedula, nombres, apellidos, usuario, password)){
            HttpSession objsesion = request.getSession(true);
            objsesion.setAttribute("usuario", usuario);
            response.sendRedirect("Controlador?accion=home");
        }else {
            response.sendRedirect("vistas/error.jsp");
        }*/
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
