/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Andre
 */
public class Atendente {
    
    private String nome;
    private String senha;
    
    public Atendente (String nome, String senha) {
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
    
    public void inserirAtendente (){
        
         String sql = "INSERT INTO tb_atendente (username, password) VALUES (?, ?) ";
         
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
    
    public void deleteAtendente (){
        
         String sql = "DELETE FROM tb_atendente WHERE username = ? AND password = ? ";
         
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
    
}
