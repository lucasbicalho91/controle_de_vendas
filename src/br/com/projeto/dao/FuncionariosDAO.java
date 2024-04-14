/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.view.FrmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class FuncionariosDAO {
    
    //Conexão
    private final Connection conn;
    
    public FuncionariosDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }
    
    //Método cadastrarFuncionário
    public void cadastrarFuncionarios(Funcionarios obj) {
        try {

            //primeiro passo: criar o comando SQL
            String sql = "insert into tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, "
                    + "telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getRg());
                stmt.setString(3, obj.getCpf());
                stmt.setString(4, obj.getEmail());
                stmt.setString(5, obj.getSenha());
                stmt.setString(6, obj.getCargo());
                stmt.setString(7, obj.getNivel_acesso());
                stmt.setString(8, obj.getTelefone());
                stmt.setString(9, obj.getCelular());
                stmt.setString(10, obj.getCep());
                stmt.setString(11, obj.getEndereco());
                stmt.setInt(12, obj.getNumero());
                stmt.setString(13, obj.getComplemento());
                stmt.setString(14, obj.getBairro());
                stmt.setString(15, obj.getCidade());
                stmt.setString(16, obj.getUf());

                //terceiro passo: Executar o comando SQL
                stmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
        // Método Alterar Funcionario
    public void alterarFuncionario(Funcionarios obj) {
                try {
            
            //primeiro passo: criar o comando SQL
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, senha=?, "
                    + "cargo=?, nivel_acesso=?, telefone=?, celular=?, cep=?, endereco=?, "
                    + "numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
       
            
                    try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                        PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, obj.getNome());
                        stmt.setString(2, obj.getRg());
                        stmt.setString(3, obj.getCpf());
                        stmt.setString(4, obj.getEmail());
                        stmt.setString(5, obj.getSenha());
                        stmt.setString(6, obj.getCargo());
                        stmt.setString(7, obj.getNivel_acesso());
                        stmt.setString(8, obj.getTelefone());
                        stmt.setString(9, obj.getCelular());
                        stmt.setString(10, obj.getCep());
                        stmt.setString(11, obj.getEndereco());
                        stmt.setInt(12, obj.getNumero());
                        stmt.setString(13, obj.getComplemento());
                        stmt.setString(14, obj.getBairro());
                        stmt.setString(15, obj.getCidade());
                        stmt.setString(16, obj.getUf());
                        stmt.setInt(17, obj.getId());
                        
                        //terceiro passo: Executar o comando SQL
                        stmt.execute();
                        stmt.close();
                    }
            
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }   
    }
    
    // Método excluirCliente
    public void excluirFuncionario(Funcionarios obj) {
        
         try {
            
            //primeiro passo: criar o comando SQL
            String sql = "delete from tb_funcionarios where id = ?";
            
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
    
    //Método listarFuncionarios
    
        public List<Funcionarios> listarFuncionarios() {
        try {
            
            // primeiro passo: Criar a lista
            List<Funcionarios> lista = new ArrayList<>();
            
            // segundo passo: Criar o comando SQL, organizar e executar o comando
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Funcionarios obj = new Funcionarios();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
        
        //Método consultar Funcionáro por nome
    
        public Funcionarios consultaPorNome(String nome) {
        try {
            
            String sql = "select * from tb_funcionarios where nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Funcionarios obj = new Funcionarios();
            
            if(rs.next()) {
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
            return null;
        }
    }
    
    // Método listaFuncionarioPorNome
        public List<Funcionarios> listaFuncionarioPorNome(String nome) {
        try {
            
            // primeiro passo: Criar a lista
            List<Funcionarios> lista = new ArrayList<>();
            
            // segundo passo: Criar o comando SQL, organizar e executar o comando
            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Funcionarios obj = new Funcionarios();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
        
    // Método efetuaLogin
    public void efetuaLogin(String email, String senha) {
        
        try {
            
            //Primeiro passo: SQL
            String sql = "select * from tb_funcionarios where email =? and senha =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString (1, email);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                //Usuário logou
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema");
                FrmMenu tela = new FrmMenu();
                tela.setVisible(true);
                
            } else {
                //Dados incorretos
                JOptionPane.showMessageDialog(null, "Dados incorretos");
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }
    
    
    
}
