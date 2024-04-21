/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Lucas
 */
public class VendasDAO {
    
        
    private final Connection conn;
    
    public VendasDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }
    
    //Cadastrar venda
    public void cadastrarVenda(Vendas obj) {
        try {
            
            //primeiro passo: criar o comando SQL
            String sql = "insert into tb_vendas(cliente_id, data_venda, total_venda, observacoes)"
                         + "values (?, ?, ?, ?)";
            
            try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                
                stmt.setInt(1, obj.getCliente().getId());
                stmt.setString(2, obj.getData_venda());
                stmt.setDouble(3, obj.getTotal_venda());
                stmt.setString(4, obj.getObs());
                
                //terceiro passo: Executar o comando SQL
                stmt.execute();
                stmt.close();
            }
            
            JOptionPane.showMessageDialog(null, "Venda Registrada com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }       
    }
    
    //Retorna a última venda
    public int retornaUltimaVenda() {
            try {
                int idVenda = 0;
                
                String sql = "select max(id) id from venda;";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) {
                    Vendas p = new Vendas();
                    p.setId(rs.getInt("id"));
                    idVenda = p.getId();
                }
                
                return idVenda;
                
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}
