/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infogomes.telas;

import java.sql.*;
import br.com.infogomes.dal.ModuloConexao;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.Image;
import static br.com.infogomes.telas.TelaPrincipal.tblClientes;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ASUS
 */
public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
     private static File icone = new File("");


    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {

        initComponents();
        conexao = ModuloConexao.conector();
    }

    
    private void adicionar() {
        String sql = "insert into clientes(nomecliente,endcliente,fonecliente,emailcliente) values(?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, txtCliNome.getText());
            stmt.setString(2, txtCliEnd.getText());
            stmt.setString(3, txtCliTel.getText());
            stmt.setString(4, txtCliEmail.getText());

//validando os campos obrigatorios            
            if (txtCliNome.getText().isEmpty() || txtCliTel.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

            } else {

//a estrutura abaixo é usada para confirmar a inserção na tabela
//a linha abaixo atualiza/insere a tabela cliente com os dados do form
                int adicionado = stmt.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");

                    txtCliNome.setText(null);
                    txtCliEnd.setText(null);
                    txtCliTel.setText(null);
                    txtCliEmail.setText(null);

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void editar() {
        String sql = "update clientes set nomecliente=?,endcliente=?,fonecliente=?, emailcliente=? where idcliente=?";

        try {
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, txtCliNome.getText());
            stmt.setString(2, txtCliEnd.getText());
            stmt.setString(3, txtCliTel.getText());
            stmt.setString(4, txtCliEmail.getText());
            stmt.setString(5, txtCliId.getText());

            if (txtCliNome.getText().isEmpty() || txtCliTel.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

            } else {

//a estrutura abaixo é usada para confirmar a alteração na tabela
//a linha abaixo atualiza/insere a tabela usuario com os dados do form
                int adicionado = stmt.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário alterados com sucesso");
                    txtCliNome.setText(null);
                    txtCliEnd.setText(null);
                    txtCliTel.setText(null);
                    txtCliEmail.setText(null);
                    TelaCliente.btnCliCreate.setEnabled(true);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void remover() {
//confirma a remoçao

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este cliente?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from clientes where idcliente=?";
            try {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, txtCliId.getText());
                int apagado = stmt.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
                    txtCliNome.setText(null);
                    txtCliEnd.setText(null);
                    txtCliTel.setText(null);
                    txtCliEmail.setText(null);
                    TelaCliente.btnCliCreate.setEnabled(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCliNome = new javax.swing.JTextField();
        txtCliEnd = new javax.swing.JTextField();
        txtCliTel = new javax.swing.JTextField();
        txtCliEmail = new javax.swing.JTextField();
        btnCliCreate = new javax.swing.JButton();
        btnCliUpdate = new javax.swing.JButton();
        btnCliDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCliId = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Clientes");
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(124, 34));
        setNormalBounds(new java.awt.Rectangle(0, 0, 124, 0));
        setPreferredSize(new java.awt.Dimension(530, 515));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("*Nome");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Endereço");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("*Tel");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("*Campos Obrigatórios");

        txtCliNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtCliEnd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtCliTel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtCliEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnCliCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infogomes/icones/create.png"))); // NOI18N
        btnCliCreate.setToolTipText("Adicionar");
        btnCliCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliCreateActionPerformed(evt);
            }
        });

        btnCliUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infogomes/icones/edit.png"))); // NOI18N
        btnCliUpdate.setToolTipText("Editar");
        btnCliUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliUpdateActionPerformed(evt);
            }
        });

        btnCliDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infogomes/icones/delete.png"))); // NOI18N
        btnCliDelete.setToolTipText("Deletar");
        btnCliDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliDeleteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Id Cliente");

        txtCliId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCliId.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6))
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCliNome)
                                .addComponent(txtCliEmail)
                                .addComponent(txtCliEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCliTel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCliCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnCliUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnCliDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCliEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCliTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCliCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCliUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCliDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        setBounds(0, 0, 530, 515);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCliCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliCreateActionPerformed
        // chamando o metodo adicionar

        adicionar();

//ADICIONAR EM TEMPO REAL
        String sql = "select * from clientes where nomecliente like ?";
        try {
            stmt = conexao.prepareStatement(sql);
//passando o conteudo da caixa de pesquisa "txtCliPesquisar" para o ?
//atençao ao "%" que é a continuação da string "sql"
            stmt.setString(1, TelaPrincipal.txtCliPesquisar.getText() + "%");
            rs = stmt.executeQuery();
//a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela

            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnCliCreateActionPerformed

    private void btnCliUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliUpdateActionPerformed
        // chamando o metodo editar

        editar();

//ATUALIZAR EM TEMPO REAL
        String sql = "select * from clientes where nomecliente like ?";

        try {
            stmt = conexao.prepareStatement(sql);
//passando o conteudo da caixa de pesquisa "txtCliPesquisar" para o ?
//atençao ao "%" que é a continuação da string "sql"
            stmt.setString(1, TelaPrincipal.txtCliPesquisar.getText() + "%");
            rs = stmt.executeQuery();
//a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela

            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnCliUpdateActionPerformed

    private void btnCliDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliDeleteActionPerformed
        // chamando o metodo remover
        remover();

//REMOVER EM TEMPO REAL
        String sql = "select * from clientes where nomecliente like ?";

        try {
            stmt = conexao.prepareStatement(sql);
//passando o conteudo da caixa de pesquisa "txtCliPesquisar" para o ?
//atençao ao "%" que é a continuação da string "sql"
            stmt.setString(1, TelaPrincipal.txtCliPesquisar.getText() + "%");
            rs = stmt.executeQuery();
//a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela

            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnCliDeleteActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // ATIVAR O BOTAO DE ADICIONAR NOVAMENTE

        txtCliNome.setText(null);
        txtCliEnd.setText(null);
        txtCliTel.setText(null);
        txtCliEmail.setText(null);
        TelaCliente.btnCliCreate.setEnabled(true);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCliCreate;
    public static javax.swing.JButton btnCliDelete;
    public static javax.swing.JButton btnCliUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JTextField txtCliEmail;
    public static javax.swing.JTextField txtCliEnd;
    public static javax.swing.JTextField txtCliId;
    public static javax.swing.JTextField txtCliNome;
    public static javax.swing.JTextField txtCliTel;
    // End of variables declaration//GEN-END:variables

 }
