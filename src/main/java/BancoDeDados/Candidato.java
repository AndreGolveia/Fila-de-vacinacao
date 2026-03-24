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

import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Candidato{
    
    private int codigo;
    private String nome;
    private String idade;
    private boolean areasaude;
    private String endereco;
    private String datavacina;
    private boolean vacinado;
    

      public Candidato(String nome, String idade, boolean areasaude, String datavacina) {
        this.nome = nome;
        this.idade = idade;
        this.areasaude = areasaude;
        this.datavacina = datavacina;
    }

    public Candidato() {
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public boolean isAreasaude() {
        return areasaude;
    }

    public void setAreasaude(boolean areasaude) {
        this.areasaude = areasaude;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getDatavacina() {
        return datavacina;
    }

    public void setDatavacina(String datavacina) {
        this.datavacina = datavacina;
    }
    
    public boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }
    
    public void inserir (){
        
         String sql = "INSERT INTO tb_candidatos (nome, idade, areasaude, endereco) VALUES (?, ?, ?, ?) ";
         
         ConnectionFactory factory = new ConnectionFactory();
         
        // rever toda essa parte a partir daqui: 
         try(Connection c = factory.obtemConexao()){
             PreparedStatement pst = c.prepareStatement(sql);
             pst.setString(1, this.nome);
             pst.setString(2, this.idade);
             pst.setBoolean(3, this.areasaude);
             pst.setString(4, this.endereco);
            
             pst.execute();
         }catch(Exception e){
             e.printStackTrace();
         }
    }  
    
    public void confirmarVacina(String nome){
        
        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);;
        
        String sql = "UPDATE tb_candidatos\n" +
                     "SET vacinada = true, datavacina = ? \n" +
                     "WHERE nome = ?";

        ConnectionFactory factory = new ConnectionFactory();
        
        try (Connection c = factory.obtemConexao()){

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setDate(1, date);
            ps.setString(2, nome); 
            
            ps.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    
}
