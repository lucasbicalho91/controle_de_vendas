/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
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
public class FornecedoresDAO {

    private final Connection conn;

    public FornecedoresDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    public void cadastrarFornecedores(Fornecedores obj) {
        try {

            //primeiro passo: criar o comando SQL
            String sql = "insert into tb_fornecedores(nome, cnpj, email, telefone, "
                    + "celular, cep, endereco, numero, complemento, bairro, cidade, estado) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                    PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getCnpj());
                stmt.setString(3, obj.getEmail());
                stmt.setString(4, obj.getTelefone());
                stmt.setString(5, obj.getCelular());
                stmt.setString(6, obj.getCep());
                stmt.setString(7, obj.getEndereco());
                stmt.setInt(8, obj.getNumero());
                stmt.setString(9, obj.getComplemento());
                stmt.setString(10, obj.getBairro());
                stmt.setString(11, obj.getCidade());
                stmt.setString(12, obj.getUf());

                //terceiro passo: Executar o comando SQL
                stmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    // Método alterarCliente
    public void alterarFornecedor(Fornecedores obj) {
        try {

            //primeiro passo: criar o comando SQL
            String sql = "update tb_fornecedores set nome=?, cnpj=?, email=?, telefone=?, celular=?, cep=?,"
                    + "endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";

            try ( //segundo passo: conectar o Banco de Dados e organizar o comando SQL
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getCnpj());
                stmt.setString(3, obj.getEmail());
                stmt.setString(4, obj.getTelefone());
                stmt.setString(5, obj.getCelular());
                stmt.setString(6, obj.getCep());
                stmt.setString(7, obj.getEndereco());
                stmt.setInt(8, obj.getNumero());
                stmt.setString(9, obj.getComplemento());
                stmt.setString(10, obj.getBairro());
                stmt.setString(11, obj.getCidade());
                stmt.setString(12, obj.getUf());
                stmt.setInt(13, obj.getId());

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
    public void excluirFornecedor(Fornecedores obj) {

        try {

            //primeiro passo: criar o comando SQL
            String sql = "delete from tb_fornecedores where id = ?";

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

    public List<Fornecedores> listarFornecedores() {
        try {

            // primeiro passo: Criar a lista
            List<Fornecedores> lista = new ArrayList<>();

            // segundo passo: Criar o comando SQL, organizar e executar o comando
            String sql = "select * from tb_fornecedores";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores obj = new Fornecedores();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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

    public Fornecedores consultaFornecedoresPorNome(String nome) {
        try {

            String sql = "select * from tb_fornecedores where nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Fornecedores obj = new Fornecedores();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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
            JOptionPane.showMessageDialog(null, "Fornecedor não encontrado");
            return null;
        }
    }

    public List<Fornecedores> listarFornecedoresPorNome(String nome) {
        try {

            // primeiro passo: Criar a lista
            List<Fornecedores> lista = new ArrayList<>();

            // segundo passo: Criar o comando SQL, organizar e executar o comando
            String sql = "select * from tb_fornecedores where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores obj = new Fornecedores();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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

}
