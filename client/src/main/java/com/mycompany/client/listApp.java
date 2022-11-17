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
public class listApp extends javax.swing.JFrame {

    /**
     * Creates new form listApp
     */
    public listApp() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        killapp = new javax.swing.JButton();
        xemapp = new javax.swing.JButton();
        deleteapp = new javax.swing.JButton();
        startapp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("List Application");

        killapp.setText("Kill");
        killapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                killappActionPerformed(evt);
            }
        });

        xemapp.setText("Xem");
        xemapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemappActionPerformed(evt);
            }
        });

        deleteapp.setText("Xóa");
        deleteapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteappActionPerformed(evt);
            }
        });

        startapp.setText("Start");
        startapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startappActionPerformed(evt);
            }
        });

        jScrollPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jScrollPane1AncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Application", "Name Application", "Count Thread"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(killapp)
                        .addGap(76, 76, 76)
                        .addComponent(xemapp)
                        .addGap(73, 73, 73)
                        .addComponent(deleteapp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(startapp)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(killapp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xemapp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(deleteapp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startapp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>                        

    private void killappActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (program.client1 == null){
                JOptionPane.showMessageDialog(null, "Chưa kết nối đến server");
                return;
        }
        try {
            String s="KILL";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
            kill Kill =new kill();
            Kill.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                       

    private void xemappActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (program.client1 == null){
                JOptionPane.showMessageDialog(null, "Chưa kết nối đến server");
                return;
        }
        try {
            String s = "XEM";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
            String soprocess = program.in.readLine();
            int soprocess1 = 0;
            soprocess1 = Integer.parseInt(soprocess);
            ObjectInputStream oin = new ObjectInputStream(program.client1.getInputStream());
            for (int i = 0; i < soprocess1-4; i++)
            {
                String[] data = (String[]) oin.readObject();
                DefaultTableModel defTable = (DefaultTableModel)jTable1.getModel();
                defTable.addRow(data);
            }
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                      

    private void deleteappActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(program.client1 == null)
        {
            JOptionPane.showMessageDialog(rootPane, "Chưa kết nối tới server");
            return;
        }
        DefaultTableModel defTable = (DefaultTableModel)jTable1.getModel();
        while(defTable.getRowCount() > 0)
        {
            defTable.removeRow(0);
        }
    }                                        

    private void startappActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (program.client1 == null){
                JOptionPane.showMessageDialog(null, "Chưa kết nối đến server");
                return;
        }
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
    }                                        

    private void jScrollPane1AncestorMoved(javax.swing.event.AncestorEvent evt) {                                           
        
    }                                          
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        try {
            String s = "QUIT";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(listApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(listApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(listApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(listApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new listApp().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton deleteapp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton killapp;
    private javax.swing.JButton startapp;
    private javax.swing.JButton xemapp;
    // End of variables declaration                   
}
