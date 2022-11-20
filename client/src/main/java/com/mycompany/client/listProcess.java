/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HUNG
 */
public class listProcess extends javax.swing.JFrame {

    /**
     * Creates new form ListProcess
     */
    public listProcess() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        killprocess = new javax.swing.JButton();
        xemprocess = new javax.swing.JButton();
        xoaprocess = new javax.swing.JButton();
        startprocess = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        killprocess.setText("Kill");
        killprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                killprocessActionPerformed(evt);
            }
        });

        xemprocess.setText("Xem");
        xemprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemprocessActionPerformed(evt);
            }
        });

        xoaprocess.setText("Xóa");
        xoaprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaprocessActionPerformed(evt);
            }
        });

        startprocess.setText("Start");
        startprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startprocessActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name Process", "ID Process", "Count Thread"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(killprocess)
                        .addGap(80, 80, 80)
                        .addComponent(xemprocess)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xoaprocess)
                        .addGap(74, 74, 74)
                        .addComponent(startprocess)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(killprocess, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xemprocess, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoaprocess, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startprocess, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xemprocessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemprocessActionPerformed
        try {
            String s = "XEM";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
            String soprocess = program.in.readLine();
            int soprocess1 = 0;
            DefaultTableModel table = (DefaultTableModel)jTable1.getModel();
            while(table.getRowCount() > 0)
            {
                table.removeRow(0);
            }
            soprocess1 = Integer.parseInt(soprocess);
            ObjectInputStream oin = new ObjectInputStream(program.client1.getInputStream());
            for (int i = 0; i < soprocess1 - 3; i++)
            {
                String[] data = (String[]) oin.readObject();
                DefaultTableModel defTable = (DefaultTableModel)jTable1.getModel();
                defTable.addRow(data);
            }
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xemprocessActionPerformed

    private void killprocessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_killprocessActionPerformed
        try {
            String s="KILL";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
            kill Kill =new kill();
            Kill.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(listProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_killprocessActionPerformed

    private void startprocessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startprocessActionPerformed
        try {
            String s="START";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
            start Start =new start();
            Start.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_startprocessActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            String s = "QUIT";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void xoaprocessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaprocessActionPerformed
        DefaultTableModel defTable = (DefaultTableModel)jTable1.getModel();
        while(defTable.getRowCount() > 0)
        {
            defTable.removeRow(0);
        }       
    }//GEN-LAST:event_xoaprocessActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton killprocess;
    private javax.swing.JButton startprocess;
    private javax.swing.JButton xemprocess;
    private javax.swing.JButton xoaprocess;
    // End of variables declaration//GEN-END:variables
}
