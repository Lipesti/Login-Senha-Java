/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.Usuario;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author felip
 */
public class UsuarioDAO {
    public String insertUsuario (Usuario usuario){
        String resp = "";
        
        try {
             Connection conn = ConexaoDAO.getConexao ();
            String sql = "INSERT INTO dados (login, senha) VALUES (?, ?))";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.execute ();
            ps.close();
            conn.close();
            resp = "Ok";
            
        } catch (Exception e) {
            resp = "Erro: " + e.toString();
        }
        
        return resp;
    }
    
    public ArrayList<Usuario> getUsuario(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try {
            Connection conn = ConexaoDAO.getConexao();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM dados ORDER BY nome";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                
                lista.add(usuario);    
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public Usuario consultarUsuario (String login){
        Usuario usuario = new Usuario();
        try{
            
            Connection conn = ConexaoDAO.getConexao();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM dados WHERE login = '" + login + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()){
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                
            }else {
                usuario.setLogin("");
                usuario.setSenha("");
            }
            rs.close();
            stmt.close();
            conn.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return usuario;
    }
}
    
