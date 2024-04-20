/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Produtos;
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
public class ProdutosDAO {
    
    private final Connection conn;

    public ProdutosDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }
    
    // Método cadastrarCliente
    public void cadastrarProduto(Produtos obj) {
        try {
            
            //primeiro passo: criar o comando SQL
            String sql = "insert into tb_produtos(descricao, preco, qtd_estoque, for_id)"
                         + "values (?, ?, ?, ?)";
            
            try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                
                stmt.setString(1, obj.getDescricao());
                stmt.setDouble(2, obj.getPreco());
                stmt.setInt(3, obj.getQtd_estoque());
                stmt.setInt(4, obj.getFornecedor().getId());
                
                //terceiro passo: Executar o comando SQL
                stmt.execute();
                stmt.close();
            }
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }   
    }
    
        public void alterarProduto(Produtos obj) {
                try {
            
            //primeiro passo: criar o comando SQL
            String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=? where id=?";
       
            
                    try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                        PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, obj.getDescricao());
                        stmt.setDouble(2, obj.getPreco());
                        stmt.setInt(3, obj.getQtd_estoque());
                        
                        stmt.setInt(4, obj.getFornecedor().getId());
                        
                        stmt.setInt(5, obj.getId());
                        
                        //terceiro passo: Executar o comando SQL
                        stmt.execute();
                        stmt.close();
                    }
            
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }   
    }
    
    // Método excluirCliente
    public void excluirProduto(Produtos obj) {
        
         try {
            
            //primeiro passo: criar o comando SQL
            String sql = "delete from tb_produtos where id = ?";
            
             try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                 stmt.setInt(1, obj.getId());
                 
                 
                 //terceiro passo: Executar o comando SQL
                 stmt.execute();
                 stmt.close();
             }
            
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }   
    }
    
        
        public List<Produtos> listarProdutos() {
        try {
            
            // primeiro passo: Criar a lista
            List<Produtos> lista = new ArrayList<>();
            
            // segundo passo: Criar o comando SQL, organizar e executar o comando
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from "
                    + "tb_produtos as p inner join tb_fornecedores as f on (p.for_id = f.id)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }
    
        public Produtos consultarProdutosPorNome(String nome) {
        try {
            
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from "
                    + "tb_produtos as p inner join tb_fornecedores as f on (p.for_id = f.id) "
                    + "where p.descricao = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();
            
            if(rs.next()) {
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);

            }
            
            return obj;
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
    }
        
        public List<Produtos> listarProdutosPorNome(String nome) {
        try {
            
            // primeiro passo: Criar a lista
            List<Produtos> lista = new ArrayList<>();
            
            // segundo passo: Criar o comando SQL, organizar e executar o comando
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from "
                    + "tb_produtos as p inner join tb_fornecedores as f on (p.for_id = f.id)"
                    + " where p.descricao like ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
                
                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    } 
        
        
}
