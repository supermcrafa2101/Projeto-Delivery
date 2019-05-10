/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Pedido;
import model.bean.Pessoa;
import model.bean.Produto;
import model.dao.PedidoDAO;
import model.dao.PessoaDAO;
import model.dao.ProdutoDAO;

/**
 *
 * @author rafael
 */
public class ViewPedido extends javax.swing.JFrame {

    /**
     * Creates new form ViewPedidos
     */
    public ViewPedido() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tbPedido.getModel();
        tbPedido.setRowSorter(new TableRowSorter(modelo));

        Pessoa pessoabean = new Pessoa();
        Produto produtobean = new Produto();

        Pedido objpedido = new Pedido();

        PessoaDAO pessoadao = new PessoaDAO();
        ProdutoDAO produtodao = new ProdutoDAO();

        for (Pessoa people : pessoadao.read()) {
            cbCPFCliente.addItem(people.toString());
        }

        for (Produto product : produtodao.read()) {
            cbIDItem.addItem(product.getID());
        }

        readJTable();
    }

    public void readJTable() {
        // Este metodo serve para atualizar a tabela

        // Cria o modelo da tabela da forma padrao
        DefaultTableModel modelo = (DefaultTableModel) tbPedido.getModel();
        modelo.setNumRows(0);
        PedidoDAO usudao = new PedidoDAO();

        // Lê cada item do 'objpedido' e adiciona na lista 'tbRegistros'
        usudao.read().forEach((objpedido) -> {
            modelo.addRow(new Object[]{
                objpedido.getID(),
                objpedido.getIDItem(),
                objpedido.getNomeCliente(),
                objpedido.getCPFCliente(),
                objpedido.getNomeItem(),
                ("R$" + objpedido.getValor())});
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCampos = new javax.swing.JPanel();
        lblVisualCPFCliente = new javax.swing.JLabel();
        lblVISUALITEM = new javax.swing.JLabel();
        cbCPFCliente = new javax.swing.JComboBox<>();
        cbIDItem = new javax.swing.JComboBox<>();
        lblNomeCliente = new javax.swing.JLabel();
        lblVISUALNOMECLIENTE = new javax.swing.JLabel();
        lblVISUALNOMEITEM = new javax.swing.JLabel();
        lblNomeItem = new javax.swing.JLabel();
        lblVISUALVALOR = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        btnProcurarCliente = new javax.swing.JButton();
        btnProcurarItem = new javax.swing.JButton();
        panelBotoes = new javax.swing.JPanel();
        btnRemoverPedido = new javax.swing.JButton();
        btnSairCadastro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedido = new javax.swing.JTable();
        btnAdicionarPedido = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCampos.setBorder(javax.swing.BorderFactory.createTitledBorder("Gerenciar Pedidos"));

        lblVisualCPFCliente.setText("CPF Cliente");

        lblVISUALITEM.setText("Item");

        cbCPFCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCPFClienteActionPerformed(evt);
            }
        });

        cbIDItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIDItemActionPerformed(evt);
            }
        });

        lblNomeCliente.setText("...");

        lblVISUALNOMECLIENTE.setText("Nome:");

        lblVISUALNOMEITEM.setText("Nome:");

        lblNomeItem.setText("...");

        lblVISUALVALOR.setText("Valor");

        lblValor.setText("...");

        btnProcurarCliente.setText("Procurar");
        btnProcurarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarClienteActionPerformed(evt);
            }
        });

        btnProcurarItem.setText("Procurar");
        btnProcurarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCamposLayout = new javax.swing.GroupLayout(panelCampos);
        panelCampos.setLayout(panelCamposLayout);
        panelCamposLayout.setHorizontalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblVisualCPFCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVISUALITEM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addComponent(cbIDItem, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcurarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(lblVISUALNOMEITEM, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNomeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(lblVISUALVALOR)
                        .addGap(18, 18, 18)
                        .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(cbCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcurarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(lblVISUALNOMECLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))
                .addGap(66, 66, 66))
        );
        panelCamposLayout.setVerticalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVisualCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVISUALNOMECLIENTE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProcurarCliente))
                .addGap(28, 28, 28)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVISUALVALOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblVISUALNOMEITEM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblVISUALITEM)
                        .addComponent(cbIDItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProcurarItem)))
                .addGap(170, 170, 170))
        );

        btnRemoverPedido.setText("Remover Pedido");
        btnRemoverPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedidoActionPerformed(evt);
            }
        });

        btnSairCadastro.setText("Sair");
        btnSairCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairCadastroActionPerformed(evt);
            }
        });

        tbPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pedido", "IDItem", "NomeCliente", "CPFCliente", "NomeItem", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPedido.getTableHeader().setReorderingAllowed(false);
        tbPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPedidoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbPedidoMouseReleased(evt);
            }
        });
        tbPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbPedidoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbPedido);
        if (tbPedido.getColumnModel().getColumnCount() > 0) {
            tbPedido.getColumnModel().getColumn(0).setMinWidth(90);
            tbPedido.getColumnModel().getColumn(0).setPreferredWidth(90);
            tbPedido.getColumnModel().getColumn(0).setMaxWidth(90);
            tbPedido.getColumnModel().getColumn(1).setMinWidth(60);
            tbPedido.getColumnModel().getColumn(1).setPreferredWidth(60);
            tbPedido.getColumnModel().getColumn(1).setMaxWidth(60);
            tbPedido.getColumnModel().getColumn(3).setMinWidth(130);
            tbPedido.getColumnModel().getColumn(3).setPreferredWidth(130);
            tbPedido.getColumnModel().getColumn(3).setMaxWidth(130);
            tbPedido.getColumnModel().getColumn(5).setMinWidth(90);
            tbPedido.getColumnModel().getColumn(5).setPreferredWidth(90);
            tbPedido.getColumnModel().getColumn(5).setMaxWidth(90);
        }

        btnAdicionarPedido.setText("Adicionar Pedido");
        btnAdicionarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPedidoActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btnAdicionarPedido)
                .addGap(18, 18, 18)
                .addComponent(btnRemoverPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSairCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSairCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoverPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedidoActionPerformed
        // Remove a pedido indicada ao pressionar o botao Remover Pedido.
        if (tbPedido.getSelectedRow() != -1) {
            // Criando uma modificação para o MessageDIalog de aviso
            JFrame frame = new JFrame();
            String[] opcoesSMD = new String[2];
            opcoesSMD[0] = new String("Sim");
            opcoesSMD[1] = new String("Não");
            // Exibe o aviso e captura a resposta na variavel 'escolha'
            int escolha = JOptionPane.showOptionDialog(
                    frame.getContentPane(),
                    "O pedido selecionada sera removido!!!",
                    "AVISO",
                    0,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    opcoesSMD,
                    null);

            // Caso escolher opção "Sim", removerá a pedido selecionado da tabela
            if (escolha == JOptionPane.YES_OPTION) {

                // instanciando 'Pedido' e 'PedidoDAO'
                Pedido objpedido = new Pedido();
                PedidoDAO dao = new PedidoDAO();

                objpedido.setID((int) tbPedido.getValueAt(tbPedido.getSelectedRow(), 0));

                // Remove a pedido selecionado
                dao.delete(objpedido);
                readJTable();
                // Caso escolhar opçao "Não", nada sera alterado
            } else if (escolha == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Nada foi alterado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma pedido para remover");
        }
    }//GEN-LAST:event_btnRemoverPedidoActionPerformed

    private void btnSairCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairCadastroActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairCadastroActionPerformed

    private void tbPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidoMouseClicked

    }//GEN-LAST:event_tbPedidoMouseClicked

    private void tbPedidoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidoMouseReleased
        btnAdicionarPedido.setEnabled(false);
        btnRemoverPedido.setEnabled(true);
    }//GEN-LAST:event_tbPedidoMouseReleased

    private void tbPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPedidoKeyReleased
    }//GEN-LAST:event_tbPedidoKeyReleased

    private void btnAdicionarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPedidoActionPerformed

        PedidoDAO pedidodao = new PedidoDAO();
        Pedido objpedido = new Pedido();

        if (!"".equals(lblValor.getText())
                || !"".equals(lblNomeCliente.getText())
                || !"".equals(lblNomeItem.getText())) {

            objpedido.setIDItem((int) cbIDItem.getSelectedItem());
            objpedido.setNomeCliente(lblNomeCliente.getText());
            objpedido.setCPFCliente((String) cbCPFCliente.getSelectedItem());
            objpedido.setNomeItem(lblNomeItem.getText());
            objpedido.setValor(Integer.parseInt(lblValor.getText()));

            pedidodao.create(objpedido);
            readJTable();
        } else {
            JOptionPane.showMessageDialog(null, "Algum dado não foi informado!");
        }

    }//GEN-LAST:event_btnAdicionarPedidoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
        ViewPaginaInicial inicio = new ViewPaginaInicial();
        inicio.setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnProcurarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarClienteActionPerformed
        btnAdicionarPedido.setEnabled(true);
        btnRemoverPedido.setEnabled(false);
        tbPedido.clearSelection();
        PedidoDAO pedidodao = new PedidoDAO();
        Pedido objpedido = new Pedido();

        objpedido.setCPFCliente((String) cbCPFCliente.getSelectedItem());

        objpedido.setNomeCliente(objpedido.getNomeCliente());
        objpedido.setCPFCliente(objpedido.getCPFCliente());

        pedidodao.searchPessoaNome(objpedido);

        lblNomeCliente.setText(objpedido.getNomeCliente());

    }//GEN-LAST:event_btnProcurarClienteActionPerformed

    private void btnProcurarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarItemActionPerformed
        btnAdicionarPedido.setEnabled(true);
        btnRemoverPedido.setEnabled(false);
        tbPedido.clearSelection();
        PedidoDAO pedidodao = new PedidoDAO();
        Pedido objpedido = new Pedido();

        objpedido.setIDItem((int) cbIDItem.getSelectedItem());

        objpedido.setNomeItem(objpedido.getNomeItem());
        objpedido.setValor(objpedido.getValor());

        pedidodao.searchProdutoNome(objpedido);
        pedidodao.searchValorProduto(objpedido);

        lblNomeItem.setText(objpedido.getNomeItem());
        lblValor.setText(String.valueOf(objpedido.getValor()));
    }//GEN-LAST:event_btnProcurarItemActionPerformed

    private void cbIDItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIDItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIDItemActionPerformed

    private void cbCPFClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCPFClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCPFClienteActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarPedido;
    private javax.swing.JButton btnProcurarCliente;
    private javax.swing.JButton btnProcurarItem;
    private javax.swing.JButton btnRemoverPedido;
    private javax.swing.JButton btnSairCadastro;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<Object> cbCPFCliente;
    private javax.swing.JComboBox<Object> cbIDItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNomeItem;
    private javax.swing.JLabel lblVISUALITEM;
    private javax.swing.JLabel lblVISUALNOMECLIENTE;
    private javax.swing.JLabel lblVISUALNOMEITEM;
    private javax.swing.JLabel lblVISUALVALOR;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblVisualCPFCliente;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JTable tbPedido;
    // End of variables declaration//GEN-END:variables
}
