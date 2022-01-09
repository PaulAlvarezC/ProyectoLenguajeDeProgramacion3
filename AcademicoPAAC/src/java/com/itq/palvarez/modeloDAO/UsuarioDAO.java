/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itq.palvarez.modeloDAO;

import com.itq.palvarez.config.Conexion;
import com.itq.palvarez.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author paul.alvarez
 */
public class UsuarioDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario listarIdCliente(String usuario){
        String sql = "select * from usuario where usuario=" + usuario;
        Usuario c = new Usuario();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setApellidos(rs.getString(4));
                c.setUsuario(rs.getString(5));
                c.setPassword(rs.getString(6));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return c;
    }
}
