/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Andre
 */
public class DAO {
    
    public boolean existeAdm ( Administrador admin) throws Exception{
        
        String sql = "SELECT * FROM tb_admin WHERE username = ? AND password = ?";
        
        ConnectionFactory factory = new ConnectionFactory();
        
        try (Connection conn = factory.obtemConexao()){
                    
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, admin.getNome());
            ps.setString(2, admin.getSenha());
            try (ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
     
    }
    
    public boolean existeAtendente ( Atendente atd) throws Exception{
        
        String sql = "SELECT * FROM tb_atendente WHERE username = ? AND password = ?";
        
        ConnectionFactory factory = new ConnectionFactory();
        
        try (Connection conn = factory.obtemConexao()){
                    
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, atd.getNome());
            ps.setString(2, atd.getSenha());
            try (ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
     
    }
}
