/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.client;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author HUNG
 */
public class client extends javax.swing.JFrame {

    /**
     * Creates new form client
     */
    public client() {
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

        connect = new javax.swing.JButton();
        ip = new javax.swing.JTextField();
        process = new javax.swing.JButton();
        shutdownrestart = new javax.swing.JButton();
        app = new javax.swing.JButton();
        screen = new javax.swing.JButton();
        keylog = new javax.swing.JButton();
        thoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        setBackground(new java.awt.Color(60, 242, 235));

        connect.setBackground(new java.awt.Color(153, 65, 54));
        connect.setText("Kết nối");
        connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }
        });

        ip.setText("Nhập IP");

        process.setText("Process");
        process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processActionPerformed(evt);
            }
        });

        shutdownrestart.setText("Shutdown, Restart");
        shutdownrestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shutdownrestartActionPerformed(evt);
            }
        });

        app.setText("App Running");
        app.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appActionPerformed(evt);
            }
        });

        screen.setText("Chụp màn hình");
        screen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenActionPerformed(evt);
            }
        });

        keylog.setText("Keystroke");
        keylog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keylogActionPerformed(evt);
            }
        });

        thoat.setText("Thoát");
        thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(process, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shutdownrestart, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(app, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(screen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(ip))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(keylog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ip)
                    .addComponent(connect, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(app, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(screen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(keylog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shutdownrestart, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(thoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(process, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed
        String s;
        Boolean test = true;
        program.ip=ip.getText();
        try{          
            SocketAddress socketaddr = new InetSocketAddress(program.ip,2003); //tạo socket address với biến socketaddr cùng vời địa chỉ ip và port
            program.client1 = new Socket();
            program.client1.connect(socketaddr); //connect với server
        } catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Lỗi kết nối đến server");
            test = false;
            program.client1 = null;
        }
        if (test){
            try {
                String st = "Kết nối server thành công";
                JOptionPane.showMessageDialog(null, st);
                program.out=new BufferedWriter(new OutputStreamWriter(program.client1.getOutputStream()));
                program.in=new BufferedReader(new InputStreamReader(program.client1.getInputStream()));
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_connectActionPerformed

    private void screenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenActionPerformed
        try {
            if (program.client1 == null){
                JOptionPane.showMessageDialog(null, "Chưa kết nối đến server");
                return;
            }
            String s="TAKEPIC";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
            pic screen = new pic();
            //screen.lam();
            screen.sent();
            screen.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AWTException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_screenActionPerformed

    private void appActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appActionPerformed
        try {
            if (program.client1 == null){
                JOptionPane.showMessageDialog(null, "Chưa kết nối đến server");
                return;
            }
            String s="APPLICATION";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
            listApp app =new listApp();
            app.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_appActionPerformed

    private void processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processActionPerformed
        try {
            if (program.client1 == null){
                JOptionPane.showMessageDialog(null, "Chưa kết nối đến server");
                return;
            }
            String s="PROCESS";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
            listProcess process =new listProcess();
            process.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_processActionPerformed

    private void keylogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keylogActionPerformed
        try {
            if (program.client1 == null){
                JOptionPane.showMessageDialog(null, "Chưa kết nối đến server");
                return;
            }
            String s="KEYLOG";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
            keylog klog=new keylog();
            klog.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_keylogActionPerformed

    private void shutdownrestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shutdownrestartActionPerformed
        try {
            if (program.client1 == null){
                JOptionPane.showMessageDialog(null, "Chưa kết nối đến server");
                return;
            }
            String s="FEATURE";
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
            feature fea=new feature();
            fea.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_shutdownrestartActionPerformed

    private void thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoatActionPerformed
        if(program.client1 == null)
        {
            JOptionPane.showMessageDialog(rootPane, "Chưa kết nối tới server");
            return;
        }
        String s="QUIT";
        try {
            program.out.write(s);
            program.out.newLine();
            program.out.flush();
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose(); 
    }//GEN-LAST:event_thoatActionPerformed

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
//            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new client().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton app;
    private javax.swing.JButton connect;
    private javax.swing.JTextField ip;
    private javax.swing.JButton keylog;
    private javax.swing.JButton process;
    private javax.swing.JButton screen;
    private javax.swing.JButton shutdownrestart;
    private javax.swing.JButton thoat;
    // End of variables declaration//GEN-END:variables
}
