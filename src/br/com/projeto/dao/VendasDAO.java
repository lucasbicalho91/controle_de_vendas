/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    //Retorna a última venda
    public int retornaUltimaVenda() {
        try {
            int idVenda = 0;

            String sql = "select max(id) id from tb_vendas;";
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
    
    //Método que filtra vendas por datas
    public List<Vendas> listarVendasPorPeriodo(LocalDate data_inicio, LocalDate data_fim) {
        try {

            // primeiro passo: Criar a lista
            List<Vendas> lista = new ArrayList<>();

            // segundo passo: Criar o comando SQL, organizar e executar o comando
            String sql = "select v.id, date_format(v.data_venda,'%d/%m/%Y') as data_formatada , c.nome, v.total_venda, v.observacoes from "
                        + "tb_vendas as v inner join tb_clientes as c on (v.cliente_id = c.id)"
                        + "where v.data_venda between ? and ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, data_inicio.toString());
            stmt.setString(2, data_fim.toString());
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendas obj = new Vendas();
                Clientes c = new Clientes();
                
                obj.setId(rs.getInt("v.id"));
                obj.setData_venda(rs.getString("data_formatada"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotal_venda(rs.getDouble("v.total_venda"));
                obj.setObs(rs.getString("v.observacoes"));
                
                obj.setCliente(c);
                
                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }
}
