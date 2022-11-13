/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sever;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author HUNG
 */
public class server extends javax.swing.JFrame {
    /**
     * Creates new form sever
     */
    public server() {
        initComponents();
    }
    public void receiveSignal(){
         try
            {
                program.signal=program.in.readLine();
            }
            catch (IOException ex)
            {
                program.signal = "QUIT";
            }
    }
     public void shutdown()
    {
        try{
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec("shutdown -s -t 5");
            System.exit(0);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
     public void restart(){
         try{
            Runtime runtime = Runtime.getRuntime();
            Process proc1 = runtime.exec("shutdown -r -t 5");
            System.exit(0);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
     }
     public void logoff(){
         try{
            Runtime runtime = Runtime.getRuntime();
            Process proc2 = runtime.exec("shutdown -l 5");
            System.exit(0);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
     }
        public void hibernate(){
         try{
            Runtime runtime = Runtime.getRuntime();
            Process proc3 = runtime.exec("shutdown -h  5");
            System.exit(0);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openserver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sever");

        openserver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        openserver.setText("Mở Sever");
        openserver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openserverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(openserver, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(openserver, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void takepic(){
        while(true){
            receiveSignal();
            switch(program.signal){
                case "TAKE":
                {
                    final JFrame frame = new JFrame();
                    frame.setSize(500, 500);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    Thread t = new Thread(){
                    public void run(){
                        try{
                            DataInputStream in = new DataInputStream(program.server1.getInputStream());
                            DataOutputStream out = new DataOutputStream(program.server1.getOutputStream());
                            byte[] sizeAr = new byte[4];
                            in.read(sizeAr);
                            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
                            byte[] imageAr = new byte[size];
                            in.read(imageAr);
                            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
                            ImageIO.write(image, "jpg", new File("screen.jpg"));
                            program.server1.close();
                            JLabel label = new JLabel();
                            label.setIcon(new ImageIcon(image));
                            frame.getContentPane().add(label);
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                };
             t.start();
             frame.setVisible(true);
            }
                case "QUIT":
                {
                    break;
                }
        }
    }
}
    public void application() throws IOException
    {
        while (true)
        {
            receiveSignal();
            switch(program.signal)
            {
                case "XEM" ->                 {
                    try {
                        String line = null;
                        Process p = Runtime.getRuntime().exec("powershell.exe Get-Process | Where-Object { $_.MainWindowTitle } | Format-Table ID,Name,Mainwindowtitle –AutoSize");
                        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));                  
                        int soprocess = 0;
                        while(input.readLine() != null){
                            soprocess++;
                        }
                        String soprocess1 = Integer.toString(soprocess);
                        program.os = new BufferedWriter(new OutputStreamWriter(program.server1.getOutputStream()));
                        program.os.write(soprocess1);
                        program.os.newLine();
                        program.os.flush();
                        Process p1 = Runtime.getRuntime().exec("powershell.exe Get-Process | Where-Object { $_.MainWindowTitle } | Format-Table ID,Name,Mainwindowtitle –AutoSize");
                        BufferedReader input1 = new BufferedReader(new InputStreamReader(p1.getInputStream())); 
                        try (ObjectOutputStream out = new ObjectOutputStream(program.server1.getOutputStream())) {
                            for(int i = 0; (i<soprocess) ;i++) {
                                line = input1.readLine();
                                line = line.trim();
                                if (i>=3) 
                                {
                                    if (i == soprocess-1)
                                    {
                                        break;
                                    }
                                    line = line.replaceAll("\\s{1,100}", " ");
                                    String[] splitline = line.split(" ",3);
                                    String data[] = {splitline[0],splitline[1],splitline[2]};
                                    out.writeObject(data);
                                    out.flush();
                                }
                            }
                        }
                    }
                    catch(IOException e)
                    {
                      JOptionPane.showMessageDialog(null,e);
                    }
                }
                  case "START" ->{
                      String exe = program.is.readLine();
                      if (exe != "ERROR")
                      {
                        try {
                            Runtime.getRuntime().exec("powershell " + "start " + name + ".exe");
                            program.os.write("Run program successfully!");
                            program.os.newLine();
                            program.os.flush();
                        } catch (IOException ex) {
                            program.os.write("Run program fail!");
                            program.os.newLine();
                            program.os.flush();
                        }
                      } else {
                        program.os.write("Run program fail!");
                        program.os.newLine();
                        program.os.flush();
                        break;
                      }
                  }
                  case "KILL" ->{
                      String pid = program.is.readLine();
                      if (pid != null)
                      {
                        try {
                            Runtime.getRuntime().exec("taskkill /F /PID " + pid);
                            program.os.write("Kill program successfully!");
                            program.os.newLine();
                            program.os.flush();
                        } catch (IOException ex) {
                            program.os.write("Kill program fail!");
                            program.os.newLine();
                            program.os.flush();
                            break;
                        }
                      } else {
                            program.os.write("Kill program fail!");
                            program.os.newLine();
                            program.os.flush();
                            break;
                        }
                  }
                  case "QUIT" -> {
                      break;
                }
            }
        }
    }
    public void process()
    {
        while (true)
        {
            receiveSignal();
            switch(program.signal)
            {
                case "XEM" ->                 {
                    try {
                        String line = null;
                        Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
                        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));                  
                        int soprocess = 0;
                        while(input.readLine() != null){
                            soprocess++;
                        }
                        String soprocess1 = Integer.toString(soprocess);
                        program.os = new BufferedWriter(new OutputStreamWriter(program.server1.getOutputStream()));
                        program.os.write(soprocess1);
                        program.os.newLine();
                        program.os.flush();
                        Process p1 = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
                        BufferedReader input1 = new BufferedReader(new InputStreamReader(p1.getInputStream())); 
                        try (ObjectOutputStream out = new ObjectOutputStream(program.server1.getOutputStream())) {
                            for(int i = 0; (i<soprocess) ;i++) {
                                line = input1.readLine();
                                if (i>=3)
                                {
                                    for (int u =0; u < line.length()-2;u++)
                                    {
                                        if ((line.charAt(u)>64 && line.charAt(u)<=122)&&(line.charAt(u+2)>64 && line.charAt(u+2)<=122) && line.charAt(u+1)==' ')
                                        {
                                            line = line.substring(0,u+1)+"_"+line.substring(u+2,line.length());
                                        }
                                    }
                                    String[] splitline = line.trim().split("\\s{1,100}");
                                    String data[] = {splitline[0],splitline[1],splitline[2],splitline[3],splitline[4]+splitline[5]};
                                    out.writeObject(data);
                                    out.flush();
                                }
                            }
                        }
                    }
                    catch(IOException e)
                    {
                      JOptionPane.showMessageDialog(null,e);
                    }
                }
                   case "START" ->{
                      String exe = program.is.readLine();
                      if (exe != "ERROR")
                      {
                        try {
                            Runtime.getRuntime().exec("powershell " + "start " + name + ".exe");
                            program.os.write("Create proccess successfully!");
                            program.os.newLine();
                            program.os.flush();
                        } catch (IOException ex) {
                            program.os.write("Create proccess fail!");
                            program.os.newLine();
                            program.os.flush();
                        }
                      } else {
                        program.os.write("Create proccess fail!");
                        program.os.newLine();
                        program.os.flush();
                        break;
                      }
                  }
                  case "KILL" ->{
                      String pid = program.is.readLine();
                      if (pid != null)
                      {
                        try {
                            Runtime.getRuntime().exec("taskkill /F /PID " + pid);
                            program.os.write("Kill proccess successfully!");
                            program.os.newLine();
                            program.os.flush();
                        } catch (IOException ex) {
                            program.os.write("Kill proccess fail!");
                            program.os.newLine();
                            program.os.flush();
                            break;
                        }
                      } else {
                            program.os.write("Kill proccess fail!");
                            program.os.newLine();
                            program.os.flush();
                            break;
                        }
                  }
                  case "QUIT" -> {
                      break;
                }
            }
        }
    }
}
    private void openserverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openserverActionPerformed
        JOptionPane.showMessageDialog(null, "Mở server thành công.");
        try {
            ServerSocket server =new ServerSocket(2003);
            System.out.println("Server is running ...");
            program.server1 = server.accept();
            program.out=new BufferedWriter(new OutputStreamWriter(program.server1.getOutputStream()));
            program.in=new BufferedReader(new InputStreamReader(program.server1.getInputStream()));
            boolean test = true;
            while(test){
                receiveSignal();
                switch (program.signal)
                {
                    case "SHUTDOWN" -> shutdown();
                    case "RESTART"->restart();
                    case "LOGOFF"->logoff();
                    case "HIBERNATE"->hibernate();
                    case "TAKEPIC" -> takepic();
                    //case "PROCESS": process(); break;
                    //case "APPLICATION": application(); break;
                    case "QUIT"->{
                        program.server1.close();
                        server.close();
                        return;
                    }
                }
                            }
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_openserverActionPerformed

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
//            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new server().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton openserver;
    // End of variables declaration//GEN-END:variables
}
