/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itq.palvarez.config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itq.palvarez.modelo.Usuario;

/**
 *
 * @author paul.alvarez
 */
public class Autenticacion extends Conexion{
    
    public boolean autenticacion(String user, String password){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario c = new Usuario();
        
        try {
            String sql = "select * from usuario where usuario = ? and password = ?";
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        } finally {
            try {
                if(getConnection() != null) getConnection().close();
                if(ps != null) ps.close();
                if(rs != null) rs.close();
            } catch (Exception e) {
                System.err.println("FINALLY ERROR: " + e);
            }
        }      
        return false;
    }
    
    
    public boolean registrar(String cedula, String nombres, String apellidos, String usuario, String password){
        PreparedStatement ps = null;
        
        try {
            String sql = "insert into usuario (cedula, nombres, apellidos, usuario, password)values(?,?,?,?,?)";
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setString(4, usuario);
            ps.setString(5, password);
            
            if(ps.executeUpdate() == 1){
                return true;
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        } finally {
            try {
                if(getConnection() != null) getConnection().close();
                if(ps != null) ps.close();
            } catch (Exception e) {
                System.err.println("FINALLY ERROR: " + e);
            }
        } 
        return false;
    }
}
