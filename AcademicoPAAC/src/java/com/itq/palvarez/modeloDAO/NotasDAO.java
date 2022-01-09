/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itq.palvarez.modeloDAO;

import com.itq.palvarez.config.Conexion;
import static com.itq.palvarez.config.Conexion.getConnection;
import com.itq.palvarez.modelo.Notas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author paul.alvarez
 */
public class NotasDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Notas listarNotasPorIdAlumno(String cedula) {
        String sql = "select * from notas where cedula=" + cedula;
        Notas c = new Notas();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setAlumno(rs.getString(2));
                c.setCurso(rs.getInt(3));
                c.setMateria(rs.getString(4));
                c.setNota1(rs.getFloat(5));
                c.setNota2(rs.getFloat(6));
                c.setNota3(rs.getFloat(7));
                c.setPromedio(rs.getFloat(8));
                c.setObservaciones(rs.getString(9));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return c;
    }
    
    public boolean registrarNota(Notas p) {
        PreparedStatement pst = null;
        
        try {
            String sql = "insert into notas (alumno, curso, materia, nota1, nota2, nota3, promedio, observaciones)values(?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, p.getAlumno());
            pst.setInt(2, p.getCurso());
            pst.setString(3, p.getMateria());
            pst.setFloat(4, p.getNota1());
            pst.setFloat(5, p.getNota2());
            pst.setFloat(6, p.getNota3());
            pst.setFloat(7, p.getPromedio());
            pst.setString(8, p.getObservaciones());
            
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
}
