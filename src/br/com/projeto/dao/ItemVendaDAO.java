/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.ItemVenda;
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
    
    //Método que lista itens de uma venda por id
    public List<ItemVenda> listaItensPorVenda(int venda_id) {
     
        // primeiro passo: Criar a lista
        List<ItemVenda> lista = new ArrayList<>();
        
        try {

            // segundo passo: Criar o comando SQL, organizar e executar o comando
            String sql = "select i.id, p.descricao, i.qtd, p.preco, i.subtotal from "
                        + "tb_itensvendas as i inner join tb_produtos as p on (i.produto_id = p.id)"
                        + "where i.venda_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, venda_id);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ItemVenda item = new ItemVenda();
                Produtos produto = new Produtos();
                
                item.setId(rs.getInt("i.id"));
                produto.setDescricao(rs.getString("p.descricao"));
                item.setQtd(rs.getInt("i.qtd"));
                produto.setPreco(rs.getDouble("p.preco"));
                item.setSubtotal(rs.getDouble("i.subtotal"));
                
                item.setProduto(produto);
                
                lista.add(item);

            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }

}
