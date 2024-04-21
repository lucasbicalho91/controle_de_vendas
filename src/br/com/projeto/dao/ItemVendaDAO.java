/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ItemVendaDAO {
    
     private final Connection conn;
    
    public ItemVendaDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }
    
    //Método que cadastra Itens
    public void cadastraItem(ItemVenda obj) {
        try {
            
            //primeiro passo: criar o comando SQL
            String sql = "insert into tb_itensvendas(venda_id, produto_id, qtd, subtotal)"
                         + "values (?, ?, ?, ?)";
            
            try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                
                stmt.setInt(1, obj.getVenda().getId());
                stmt.setInt(2, obj.getProduto().getId());
                stmt.setInt(3, obj.getQtd());
                stmt.setDouble(4, obj.getSubtotal());
                
                //terceiro passo: Executar o comando SQL
                stmt.execute();
                stmt.close();
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }       
    }
    
}
