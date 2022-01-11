/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itq.palvarez.modeloDAO;

import com.itq.palvarez.config.Conexion;
import static com.itq.palvarez.config.Conexion.getConnection;
import com.itq.palvarez.modelo.Alumno;
import com.itq.palvarez.modelo.Materia;
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
public class MateriaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarMaterias() {
        List<Materia> materias = new ArrayList();
        String sql = "select * from materia";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Materia p = new Materia();
                p.setId(rs.getInt(1));
                p.setValor(rs.getString(2));
                p.setDescripcion(rs.getString(2));
                p.setCurso(rs.getInt(3));
                materias.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return materias;
    }
    
    public boolean crearMateria(String valor, String descripcion, int curso) {
        PreparedStatement pst = null;
        
        try {
            String sql = "insert into materia (valor, descripcion, curso)values(?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, valor);
            pst.setString(2, descripcion);
            pst.setInt(3, curso);
            
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

    public List listarMateriasPorCurso(String curso) {
        List<Materia> materias = new ArrayList();
        String sql = "select * from materia where curso=" + curso;
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Materia c = new Materia();
                c.setId(rs.getInt(1));
                c.setValor(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setCurso(rs.getInt(4));
                materias.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return materias;
    }

    public boolean eliminarMateria(String id) {
        String sql = "delete from materia where idMateria=" + id;
        
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
