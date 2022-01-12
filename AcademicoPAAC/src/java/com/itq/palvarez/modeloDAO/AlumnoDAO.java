/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itq.palvarez.modeloDAO;

import com.itq.palvarez.config.Conexion;
import static com.itq.palvarez.config.Conexion.getConnection;
import com.itq.palvarez.modelo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paul.alvarez
 */
public class AlumnoDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Alumno listarIdAlumno(String cedula) {
        String sql = "select * from alumno where cedula=" + cedula;
        Alumno c = new Alumno();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setApellidos(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCurso(rs.getInt(6));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return c;
    }
    
    public List listarAlumnos() {
        List<Alumno> alumnos = new ArrayList();
        String sql = "select * from alumno";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno p = new Alumno();
                p.setId(rs.getInt(1));
                p.setCedula(rs.getString(2));
                p.setNombres(rs.getString(3));
                p.setApellidos(rs.getString(4));
                p.setDireccion(rs.getString(5));
                p.setCurso(rs.getInt(6));
                alumnos.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return alumnos;
    }
    
    public boolean crearAlumno(String cedula, String nombres, String apellidos, String direccion, int curso) {
        PreparedStatement pst = null;
        
        try {
            String sql = "insert into alumno (cedula, nombres, apellidos, direccion, curso)values(?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, cedula);
            pst.setString(2, nombres);
            pst.setString(3, apellidos);
            pst.setString(4, direccion);
            pst.setInt(5, curso);
            
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                System.err.println("FINALLY ERROR: " + e);
            }
        }        
        return false;
    }

    public boolean editarAlumno(String nombres, String apellidos, String direccion, int id) {
        PreparedStatement pst = null;
        
        try {
            String sql = "update alumno set nombres = ?, apellidos=?, direccion=? WHERE idAlumno=?";
            pst = getConnection().prepareStatement(sql);            
            pst.setString(1, nombres);            
            pst.setString(2, apellidos);
            pst.setString(3, direccion);
            pst.setInt(4, id);
            
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                System.err.println("FINALLY ERROR: " + e);
            }
        }        
        return false;
    }

    public List listarAlumnosPorCurso(String curso) {
        List<Alumno> alumnos = new ArrayList();
        String sql = "select * from alumno where curso=" + curso;
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno c = new Alumno();
                c.setId(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setApellidos(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCurso(rs.getInt(6));
                alumnos.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return alumnos;
    }

    public boolean eliminarAlumno(String cedula) {
        String sql = "delete from alumno where cedula=" + cedula;
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return false;
    }
}
