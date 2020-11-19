/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Rodrigo
 */
public class Cliente {
    
    private int idcliente;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String dataaniversario;
    
    public Cliente (){
        
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataaniversario() {
        return dataaniversario;
    }

    public void setDataaniversario(String dataaniversario) {
        this.dataaniversario = dataaniversario;
    }
    
    
    
}
