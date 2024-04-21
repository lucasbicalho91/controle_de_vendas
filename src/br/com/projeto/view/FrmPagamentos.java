/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.projeto.view;

import br.com.projeto.dao.ItemVendaDAO;
import br.com.projeto.dao.VendasDAO;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.ItemVenda;
import br.com.projeto.model.Produtos;
import br.com.projeto.model.Vendas;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class FrmPagamentos extends javax.swing.JFrame {
    
    Clientes cliente = new Clientes();
    DefaultTableModel carrinho;

    public FrmPagamentos() {
        initComponents();
        
        txtcartao.setText("0");
        txtdinheiro.setText("0");
        txtpix.setText("0");
        txttroco.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtdinheiro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtcartao = new javax.swing.JTextField();
        txtpix = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txttroco = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        btnfinalizar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtobs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Pagamentos");

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pagamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Obs:");

        txtdinheiro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtdinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdinheiroActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("CARTÃO:");

        txtcartao.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtcartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcartaoActionPerformed(evt);
            }
        });

        txtpix.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtpix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpixActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("PIX:");

        txttroco.setEditable(false);
        txttroco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txttroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttrocoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("TROCO:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setText("TOTAL:");

        txttotal.setEditable(false);
        txttotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        btnfinalizar.setBackground(new java.awt.Color(240, 240, 240));
        btnfinalizar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnfinalizar.setText("Finalizar venda");
        btnfinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinalizarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setText("DINHEIRO:");

        txtobs.setColumns(20);
        txtobs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtobs.setRows(5);
        jScrollPane1.setViewportView(txtobs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(125, 125, 125)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtpix, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtdinheiro, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(txtcartao))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttotal, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(txttroco)))
                            .addComponent(btnfinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(jLabel15)
                    .addContainerGap(592, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtdinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtcartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtpix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txttroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(btnfinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(148, 148, 148)
                    .addComponent(jLabel15)
                    .addContainerGap(440, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtdinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdinheiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdinheiroActionPerformed

    private void txtcartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcartaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcartaoActionPerformed

    private void txtpixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpixActionPerformed

    private void txttrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttrocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrocoActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void btnfinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinalizarActionPerformed
        
        double pcartao, ppix, pdinheiro, totalpago, totalvenda, troco;
        
        pcartao = Double.parseDouble(txtcartao.getText());
        ppix = Double.parseDouble(txtpix.getText());
        pdinheiro = Double.parseDouble(txtdinheiro.getText());
        
        totalvenda = Double.parseDouble(txttotal.getText());
        
        //Calcular o troco
        totalpago = pcartao + ppix + pdinheiro;
        
        troco = totalpago - totalvenda;
        
        txttroco.setText(String.valueOf(troco));
        
        Vendas objV = new Vendas();
        
        //Dados do cliente (cliente_id)
        objV.setCliente(cliente);
        
        //Pega a data da venda
        Date agora = new Date();
        SimpleDateFormat dataEUA = new SimpleDateFormat("yyyy-MM-dd");
        String dataMySql = dataEUA.format(agora);
        
        objV.setData_venda(dataMySql);
        
        //Total da venda
        objV.setTotal_venda(totalvenda);
        objV.setObs(txtobs.getText());
        
        VendasDAO dao_v = new VendasDAO();
        dao_v.cadastrarVenda(objV);
        
        //Retorna o id da última venda realizada
        objV.setId(dao_v.retornaUltimaVenda());
        
        //Cadastrando os produtos na tabela ItensVendas
        for(int i = 0; i < carrinho.getRowCount(); i++) {
            
            Produtos objP = new Produtos();
            ItemVenda item = new ItemVenda();
            item.setVenda(objV);
            
            objP.setId(Integer.parseInt(carrinho.getValueAt(i, 0).toString()));
            item.setProduto(objP);
            item.setQtd(Integer.parseInt(carrinho.getValueAt(i, 2).toString()));
            item.setSubtotal(Double.parseDouble(carrinho.getValueAt(i, 4).toString()));
            
            ItemVendaDAO daoItem = new ItemVendaDAO();
            daoItem.cadastraItem(item);
            
        }
        
         JOptionPane.showMessageDialog(null, "Venda Registrada com Sucesso!");
        
    }//GEN-LAST:event_btnfinalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPagamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcartao;
    private javax.swing.JTextField txtdinheiro;
    private javax.swing.JTextArea txtobs;
    private javax.swing.JTextField txtpix;
    public javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttroco;
    // End of variables declaration//GEN-END:variables
}