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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paul.alvarez
 */
public class NotasDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public List listarNotasPorIdAlumno(String cedula) {
        List<Notas> notas = new ArrayList();
        String sql = "select * from notas where alumno=" + cedula;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Notas c = new Notas();
                c.setId(rs.getInt(1));
                c.setAlumno(rs.getString(2));
                c.setCurso(rs.getInt(3));
                c.setMateria(rs.getString(4));
                c.setNota1(rs.getFloat(5));
                c.setNota2(rs.getFloat(6));
                c.setNota3(rs.getFloat(7));
                c.setPromedio(rs.getFloat(8));
                c.setObservaciones(rs.getString(9));
                notas.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return notas;
    }

    public boolean registrarNota(String alumno, int curso, String materia, float nota1, float nota2, float nota3, float promedio, String observaciones) {
        PreparedStatement pst = null;

        try {
            String sql = "insert into notas (alumno, curso, materia, nota1, nota2, nota3, promedio, observaciones)values(?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, alumno);
            pst.setInt(2, curso);
            pst.setString(3, materia);
            pst.setFloat(4, nota1);
            pst.setFloat(5, nota2);
            pst.setFloat(6, nota3);
            pst.setFloat(7, promedio);
            pst.setString(8, observaciones);

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

    public boolean eliminarNotas(int id) {
        String sql = "delete from notas where idNotas=" + id;

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

    public boolean editarNotas(float n1, float n2, float n3, float prom, String observaciones, int id) {
        PreparedStatement pst = null;

        try {
            String sql = "update notas set nota1=?, nota2=?, nota3=?, promedio=?, observaciones=? WHERE idNotas=?";
            pst = getConnection().prepareStatement(sql);
            pst.setFloat(1, n1);
            pst.setFloat(2, n2);
            pst.setFloat(3, n3);
            pst.setFloat(4, prom);
            pst.setString(5, observaciones);
            pst.setInt(6, id);

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
