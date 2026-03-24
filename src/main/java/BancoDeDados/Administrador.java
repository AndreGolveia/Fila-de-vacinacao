/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Andre
 */
public class Administrador {

    private String nome;
    private String senha;
    
    public Administrador() {
    }
    
    public Administrador(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    

    public void inserirAdm (){
        
         String sql = "INSERT INTO tb_admin (username, password) VALUES (?, ?) ";
         
         ConnectionFactory factory = new ConnectionFactory();
         
        // rever toda essa parte a partir daqui: 
         try(Connection c = factory.obtemConexao()){
             PreparedStatement pst = c.prepareStatement(sql);
             pst.setString(1, this.nome);
             pst.setString(2, this.senha);;
            
             pst.execute();
         }catch(Exception e){
             e.printStackTrace();
         }
    }  
    
    public void deleteAdm (){
        
         String sql = "DELETE FROM tb_admin WHERE username = ? AND password = ? ";
         
         ConnectionFactory factory = new ConnectionFactory();
         
        // rever toda essa parte a partir daqui: 
         try(Connection c = factory.obtemConexao()){
             PreparedStatement pst = c.prepareStatement(sql);
             pst.setString(1, this.nome);
             pst.setString(2, this.senha);;
            
             pst.execute();
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    
    public String gerarRelatorio (Date SQLdate1, Date SQLdate2){
        
        String sql = "SELECT COUNT(vacinada) FROM tb_candidatos WHERE datavacina BETWEEN ? AND ? AND vacinada = true " ;
        
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()) {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setDate(1, SQLdate1);
            pst.setDate(2, SQLdate2);
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                
                String count  = rs.getString("COUNT(vacinada)");
                
                return count;
            }
            
        }catch(Exception e){
            e.printStackTrace();
            return "Deu erro";
        }
        
        return "saiu do loop";
    }
}    