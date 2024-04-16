/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
}
