/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.bean.Cliente;
import model.dao.ClienteDAO;

/**
 *
 * @author Rodrigo
 */
public class ClienteController {
    
    public void create (String nome,String email,String cpf,String telefone,String dataaniversario ){
        Cliente cliente = new Cliente();
        
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        cliente.setDataaniversario(dataaniversario);
        
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.create(cliente);
        
    }
      public void update (int idcliente, String nome, String email, String cpf, String telefone,String dataaniversario){
        Cliente cliente = new Cliente();
        cliente.setIdcliente(idcliente);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        cliente.setDataaniversario(dataaniversario);
        
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.update(cliente);
        
    }
    
    public void delete (int id){
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();
             
        cliente.setIdcliente(id);
        clienteDAO.delete(cliente);
        
    }
    
    public ArrayList<Cliente> getListaClientesNome(String nome){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.getListaClientesNome(nome);
    }
    
    public ArrayList<Cliente> read(){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.read();
    }
    
}
