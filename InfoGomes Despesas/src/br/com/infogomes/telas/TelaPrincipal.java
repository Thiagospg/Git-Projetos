/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infogomes.telas;

import java.text.DateFormat;
import java.util.Date;
import br.com.infogomes.dal.ModuloConexao;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Thiago
 */
public class TelaPrincipal extends javax.swing.JFrame {

    
    
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    private static File icone = new File("lib/icones/icon_titulo.png");
    
    Date dataTabela = new Date();
    DateFormat formatadorTabela = DateFormat.getDateInstance(DateFormat.SHORT);
    
    Date dataTela = new Date();
    DateFormat formatadorTela = DateFormat.getDateInstance(DateFormat.LONG);
    
    double totalDebito=0, salario=0;

  
   
    public TelaPrincipal() {
        
        initComponents();
        iconImage();
        conexao = ModuloConexao.conector();
        pesquisarDespesa();
        
    }
    
    private void iconImage(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(("" + icone)));
    }
    private void salario(double sal) {
        double saldo = 0;
        String mes = cbMesMostrar.getSelectedItem().toString();
        try {

            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery("SELECT salario AS saldo FROM " + mes);
            while (rs.next()) {
                saldo = rs.getDouble("salario");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        
        lblSalario.setText(Double.toString(saldo-totalDebito));

    }

    private void calcularSomaValorDebito() {
        double total = 0;
        String mes = cbMesMostrar.getSelectedItem().toString();
        try {

            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery("SELECT sum(valor)AS total FROM " + mes + " WHERE cartao='Débito'");
            while (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        totalDebito = total;
        lblTotalDebito.setText(Double.toString(total));

    }

    private void calcularSomaValorCredito() {
        double total = 0;
        String mes = cbMesMostrar.getSelectedItem().toString();
        try {

            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery("SELECT sum(valor)AS total FROM " + mes + " WHERE cartao='Crédito'");
            while (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        lblTotalCredito.setText(Double.toString(total));

    }
    
   

    private void pesquisarDespesa() {
        String mes = cbMesMostrar.getSelectedItem().toString();
        String sql = "SELECT cartao, descricao, valor, data, id FROM " + mes + " WHERE descricao like ?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, txtConsultar.getText() +"%");
            rs = stmt.executeQuery();
            tblDespesas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void settarCampos(){
        int settar = tblDespesas.getSelectedRow();
        
        txtValor.setText(tblDespesas.getModel().getValueAt(settar, 2).toString());
        txtDescricao.setText(tblDespesas.getModel().getValueAt(settar, 1).toString());
        cbCartao.setSelectedItem(tblDespesas.getModel().getValueAt(settar, 0));
        cbMes.setSelectedItem(cbMesMostrar.getSelectedItem());
        
    }

    private void excluir() {
        String mes = cbMes.getSelectedItem().toString();
        int settar = tblDespesas.getSelectedRow();
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir essa despesa?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM " + mes + " where id=?";

            try {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, tblDespesas.getModel().getValueAt(settar, 4).toString());
                int apagado = stmt.executeUpdate();

                if (apagado > 1) {
                    JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
                    txtValor.setText(null);
                    txtDescricao.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            pesquisarDespesa();
        }

    }

    private void adicionar() {
        String mes = cbMes.getSelectedItem().toString();
        String sql = "INSERT INTO " + mes + "(cartao, descricao, valor, data) values(?, ?, ?, ?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cbCartao.getSelectedItem().toString());
            stmt.setString(2, txtDescricao.getText());
            stmt.setString(3, txtValor.getText());
            stmt.setString(4, formatadorTabela.format(dataTabela));

            if (txtDescricao.getText().isEmpty() || txtValor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos!");
            } else {

                int adicionado = stmt.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
                    txtValor.setText(null);
                    txtDescricao.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        pesquisarDespesa();
        calcularSomaValorDebito();
        calcularSomaValorCredito();

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
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        cbCartao = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDespesas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTotalDebito = new javax.swing.JLabel();
        lblTotalCredito = new javax.swing.JLabel();
        cbMesMostrar = new javax.swing.JComboBox<>();
        txtConsultar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnPerigo = new javax.swing.JButton();
        btnSalario = new javax.swing.JButton();
        lblSalario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Despesas Mensais");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel1.setText("Descrição:");

        jLabel2.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel2.setText("Valor:");

        cbCartao.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        cbCartao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Débito", "Crédito" }));

        cbMes.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro\t" }));

        jLabel3.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel3.setText("Cartão");

        jLabel4.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel4.setText("Mês");

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infogomes/icones/adicionar.png"))); // NOI18N
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infogomes/icones/if_sign-error_299045.png"))); // NOI18N
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExcluir)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addComponent(btnAdicionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCartao, 0, 80, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addGap(36, 36, 36))
        );

        tblDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDespesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDespesasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDespesas);

        jLabel5.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel5.setText("Despesa Débito: ");

        jLabel6.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel6.setText("Despesa Crédito: ");

        lblTotalDebito.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N

        lblTotalCredito.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N

        cbMesMostrar.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        cbMesMostrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro\t" }));
        cbMesMostrar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMesMostrarItemStateChanged(evt);
            }
        });
        cbMesMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesMostrarActionPerformed(evt);
            }
        });

        txtConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultarKeyReleased(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infogomes/icones/if_5_330396.png"))); // NOI18N

        lblData.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Saldo Débito");

        btnPerigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infogomes/icones/if_emblem-danger_24680 (1).png"))); // NOI18N
        btnPerigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPerigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerigoActionPerformed(evt);
            }
        });

        btnSalario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infogomes/icones/if_Money-Increase_379342.png"))); // NOI18N
        btnSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalarioActionPerformed(evt);
            }
        });

        lblSalario.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        lblSalario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cbMesMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(3, 3, 3)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPerigo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSalario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTotalDebito, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(lblTotalCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbMesMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addComponent(lblTotalDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(lblSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTotalCredito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPerigo)
                            .addComponent(btnSalario)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(663, 420));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        calcularSomaValorDebito();
        calcularSomaValorCredito();
        lblData.setText(formatadorTela.format(dataTela));
    }//GEN-LAST:event_formWindowActivated

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtConsultarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultarKeyReleased
        pesquisarDespesa();
    }//GEN-LAST:event_txtConsultarKeyReleased

    private void tblDespesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDespesasMouseClicked
       settarCampos();
    }//GEN-LAST:event_tblDespesasMouseClicked

    private void cbMesMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesMostrarActionPerformed
       
    }//GEN-LAST:event_cbMesMostrarActionPerformed

    private void cbMesMostrarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMesMostrarItemStateChanged
        pesquisarDespesa();
        calcularSomaValorDebito();
        calcularSomaValorCredito();
    }//GEN-LAST:event_cbMesMostrarItemStateChanged

    private void btnPerigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerigoActionPerformed
        String mes = cbMesMostrar.getSelectedItem().toString();
        int perigo = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir TODOS os registros salvos de "+mes+"?", "PERIGO!", JOptionPane.YES_NO_OPTION);
        if (perigo == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM " + mes;

            try {
                stmt = conexao.prepareStatement(sql);
                
                perigo = stmt.executeUpdate();

                if (perigo > 1) {
                    JOptionPane.showMessageDialog(null, "Mês apagado com sucesso!");
                    txtValor.setText(null);
                    txtDescricao.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            pesquisarDespesa();
        }
    }//GEN-LAST:event_btnPerigoActionPerformed

    private void btnSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalarioActionPerformed
        
        salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite seu saldo"));
        lblSalario.setText(Double.toString(salario-totalDebito));
        
    }//GEN-LAST:event_btnSalarioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPerigo;
    private javax.swing.JButton btnSalario;
    private javax.swing.JComboBox<String> cbCartao;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JComboBox<String> cbMesMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblTotalCredito;
    private javax.swing.JLabel lblTotalDebito;
    private javax.swing.JTable tblDespesas;
    private javax.swing.JTextField txtConsultar;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
