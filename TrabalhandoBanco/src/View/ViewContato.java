package View;

import Controle.Contato;
import Dao.ContatoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ViewContato extends javax.swing.JFrame {

    public ViewContato() throws SQLException {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tabela_contato.getModel();
        tabela_contato.setRowSorter(new TableRowSorter(modelo));
        readJTable();
    }

    public void readJTable() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tabela_contato.getModel();
        modelo.setNumRows(0);
        ContatoDAO pdao = new ContatoDAO();
        for (Contato p : pdao.read()) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getDdd(),
                p.getTel()

            });
        }
    }

    public void readJTableForDesc(String desc) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tabela_contato.getModel();
        modelo.setNumRows(0);
        ContatoDAO pdao = new ContatoDAO();
        for (Contato p : pdao.readForDesc(desc)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getDdd(),
                p.getTel()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JLabel();
        ddd = new javax.swing.JLabel();
        telefone = new javax.swing.JLabel();
        nome_pesquisa = new javax.swing.JLabel();
        campo_nome = new javax.swing.JTextField();
        campo_ddd = new javax.swing.JTextField();
        campo_telefone = new javax.swing.JTextField();
        campo_pesquisa = new javax.swing.JTextField();
        cadastrar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_contato = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nome.setText("Nome");

        ddd.setText("DDD");

        telefone.setText("Telefone");

        nome_pesquisa.setText("Nome para Pesquisar");

        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        tabela_contato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "DDD", "TELEFONE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_contato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_contatoMouseClicked(evt);
            }
        });
        tabela_contato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabela_contatoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_contato);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(nome_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campo_pesquisa)
                                .addGap(40, 40, 40)
                                .addComponent(buscar)))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(cadastrar)
                                    .addGap(18, 18, 18)
                                    .addComponent(excluir)
                                    .addGap(18, 18, 18)
                                    .addComponent(atualizar))
                                .addComponent(campo_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ddd)
                            .addComponent(campo_ddd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefone))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(ddd)
                    .addComponent(telefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ddd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(excluir)
                    .addComponent(cadastrar)
                    .addComponent(atualizar))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar)
                    .addComponent(nome_pesquisa)
                    .addComponent(campo_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        Contato p = new Contato();
        ContatoDAO dao = new ContatoDAO();
        p.setNome(campo_nome.getText());
        p.setDdd(campo_ddd.getText());
        p.setTel(campo_telefone.getText());
        dao.create(p);
        campo_nome.setText("");
        campo_ddd.setText("");
        campo_telefone.setText("");
        try {
            readJTable();
        } catch (SQLException err) {
            Logger.getLogger(ViewContato.class.getName()).log(Level.SEVERE, null, err);
        }
    }//GEN-LAST:event_cadastrarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        if (tabela_contato.getSelectedRow() != -1) {
            Contato p = new Contato();
            ContatoDAO dao = new ContatoDAO();
            p.setNome(campo_nome.getText());
            p.setDdd(campo_ddd.getText());
            p.setTel(campo_telefone.getText());
            p.setId((int) tabela_contato.getValueAt(tabela_contato.getSelectedRow(), 0));
            dao.update(p);
            campo_nome.setText("");
            campo_ddd.setText("");
            campo_telefone.setText("");
            try {
                readJTable();
            } catch (SQLException err) {
                Logger.getLogger(ViewContato.class.getName()).log(Level.SEVERE, null, err);
            }
        }
    }//GEN-LAST:event_atualizarActionPerformed

    private void tabela_contatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabela_contatoKeyReleased
        if (tabela_contato.getSelectedRow() != -1) {
            campo_nome.setText(tabela_contato.getValueAt(tabela_contato.getSelectedRow(), 1).toString());
            campo_ddd.setText(tabela_contato.getValueAt(tabela_contato.getSelectedRow(), 2).toString());
            campo_telefone.setText(tabela_contato.getValueAt(tabela_contato.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_tabela_contatoKeyReleased

    private void tabela_contatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_contatoMouseClicked
        if (tabela_contato.getSelectedRow() != -1) {
            campo_nome.setText(tabela_contato.getValueAt(tabela_contato.getSelectedRow(), 1).toString());
            campo_ddd.setText(tabela_contato.getValueAt(tabela_contato.getSelectedRow(), 2).toString());
            campo_telefone.setText(tabela_contato.getValueAt(tabela_contato.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_tabela_contatoMouseClicked

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        if(tabela_contato.getSelectedRow() != -1){
            Contato p = new Contato();
            ContatoDAO dao = new ContatoDAO();
            p.setId((int) tabela_contato.getValueAt(tabela_contato.getSelectedRow(), 0));
            dao.delete(p);
            campo_nome.setText("");
            campo_ddd.setText("");
            campo_telefone.setText("");
            try{
                readJTable();
            }catch(SQLException err){
                Logger.getLogger(ViewContato.class.getName()).log(Level.SEVERE, null, err);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um contato para excluir.");
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try{
            readJTableForDesc(buscar.getText());
        }catch(SQLException err){
            Logger.getLogger(ViewContato.class.getName()).log(Level.SEVERE, null, err);
        }
    }//GEN-LAST:event_buscarActionPerformed
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
            java.util.logging.Logger.getLogger(ViewContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewContato().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewContato.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JTextField campo_ddd;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JTextField campo_pesquisa;
    private javax.swing.JTextField campo_telefone;
    private javax.swing.JLabel ddd;
    private javax.swing.JButton excluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel nome_pesquisa;
    private javax.swing.JTable tabela_contato;
    private javax.swing.JLabel telefone;
    // End of variables declaration//GEN-END:variables

}
