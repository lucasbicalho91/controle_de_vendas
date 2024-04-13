/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.WebServiceCep;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Lucas
 */
public class ClientesDAO {
    
    private final Connection conn;
    
    public ClientesDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }
    
    // Método cadastrarCliente
    public void cadastrarCliente(Clientes obj) {
        try {
            
            //primeiro passo: criar o comando SQL
            String sql = "insert into tb_clientes(nome, rg, cpf, email, telefone, "
                         + "celular, cep, endereco, numero, complemento, bairro, cidade, estado) "
                         + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getRg());
                stmt.setString(3, obj.getCpf());
                stmt.setString(4, obj.getEmail());
                stmt.setString(5, obj.getTelefone());
                stmt.setString(6, obj.getCelular());
                stmt.setString(7, obj.getCep());
                stmt.setString(8, obj.getEndereco());
                stmt.setInt(9, obj.getNumero());
                stmt.setString(10, obj.getComplemento());
                stmt.setString(11, obj.getBairro());
                stmt.setString(12, obj.getCidade());
                stmt.setString(13, obj.getUf());
                
                //terceiro passo: Executar o comando SQL
                stmt.execute();
            }
            
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }   
    }
    
    // Método alterarCliente
    public void alterarCliente(Clientes obj) {
                try {
            
            //primeiro passo: criar o comando SQL
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?,"
                    + "endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
       
            
                    try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                        PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, obj.getNome());
                        stmt.setString(2, obj.getRg());
                        stmt.setString(3, obj.getCpf());
                        stmt.setString(4, obj.getEmail());
                        stmt.setString(5, obj.getTelefone());
                        stmt.setString(6, obj.getCelular());
                        stmt.setString(7, obj.getCep());
                        stmt.setString(8, obj.getEndereco());
                        stmt.setInt(9, obj.getNumero());
                        stmt.setString(10, obj.getComplemento());
                        stmt.setString(11, obj.getBairro());
                        stmt.setString(12, obj.getCidade());
                        stmt.setString(13, obj.getUf());
                        stmt.setInt(14, obj.getId());
                        
                        //terceiro passo: Executar o comando SQL
                        stmt.execute();
                    }
            
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }   
    }
    
    // Método excluirCliente
    public void excluirCliente(Clientes obj) {
        
         try {
            
            //primeiro passo: criar o comando SQL
            String sql = "delete from tb_clientes where id = ?";
            
             try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                 stmt.setInt(1, obj.getId());
                 
                 
                 //terceiro passo: Executar o comando SQL
                 stmt.execute();
             }
            
            JOptionPane.showMessageDialog(null, "Excluído com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }   
    }
    
    // Método listarClientes
    public List<Clientes> listarClientes() {
        try {
            
            // primeiro passo: Criar a lista
            List<Clientes> lista = new ArrayList<>();
            
            // segundo passo: Criar o comando SQL, organizar e executar o comando
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Clientes obj = new Clientes();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    } 
    
    // Método consulta cliente por Nome
    public Clientes consultaPorNome(String nome) {
        try {
            
            String sql = "select * from tb_clientes where nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            
            if(rs.next()) {
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }
            
            return obj;
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
    }
    
    // Método buscarClientePorNome
        public List<Clientes> buscaClientesPorNome(String nome) {
        try {
            
            // primeiro passo: Criar a lista
            List<Clientes> lista = new ArrayList<>();
            
            // segundo passo: Criar o comando SQL, organizar e executar o comando
            String sql = "select * from tb_clientes where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Clientes obj = new Clientes();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    } 
        
        public Clientes buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
    
}
