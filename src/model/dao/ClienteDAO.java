/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import model.bean.Cliente;


/**
 *
 * @author Rodrigo
 */
public class ClienteDAO {
    
    public void create(Cliente cliente){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO cliente (nome, email, cpf, telefone, dataaniversario) VALUES (?,?,?,?,?) ");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getDataaniversario());
            
            con.setAutoCommit(false);
            
             if(true){
                throw new SQLException();
            }
            
            stmt.executeUpdate();
            con.commit();     
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            java.util.logging.Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
             try{
                con.rollback();
            }catch (SQLException ex1){
                System.out.println("Erro Ao Salvar!!!");
                //System.out.println("Comentário realizado no repositório remoto git!!!");
            }
        }finally{
         ConnectionFactory.closeConnection(con,stmt);
        }
    }
    
     public ArrayList<Cliente> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try {    
            stmt = con.prepareStatement("SELECT * FROM cliente ORDER by idcliente");
            rs = stmt.executeQuery();
        
            while(rs.next()) {
                
                Cliente cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setDataaniversario(rs.getString("dataaniversario"));
                listaClientes.add(cliente);
            
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao ler os Clientes!", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return listaClientes;
    }
    
    public void update(Cliente cliente){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE cliente set nome = ? , email = ? , cpf = ? , telefone = ? , dataaniversario = ? WHERE idcliente = ?");      
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getDataaniversario());
            stmt.setInt(6, cliente.getIdcliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
                       
        }finally{
         ConnectionFactory.closeConnection(con,stmt);
        }
    }
     
    public void delete(Cliente cliente){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM cliente WHERE idcliente = ?");
            stmt.setInt(1, cliente.getIdcliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + ex);
                       
        }finally{
         ConnectionFactory.closeConnection(con,stmt);
        }
    }
       
     public ArrayList<Cliente> getListaClientesNome(String nome){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try {    
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ? ORDER BY idcliente");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();
                   
            while(rs.next()) {
                
                Cliente cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setDataaniversario(rs.getString("dataaniversario"));
                listaClientes.add(cliente);
                
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao ler os Clientes!", "Erro", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaClientes;
    }
     
    
}
