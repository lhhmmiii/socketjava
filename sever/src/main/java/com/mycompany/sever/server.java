/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sever;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
                    @Override
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

    /**
     *
     * @param k
     */
    public void hookKey(Keylogger key){
//        try {
//            GlobalScreen.registerNativeHook();
//        } catch (NativeHookException ex) {
//            System.err.println("There was a problem registering the native hook.");
//            System.err.println(ex.getMessage());
//            System.exit(1);
//        }
//        GlobalScreen.addNativeKeyListener(k);


        a++;
        if(a==1)
        {
            try{
                GlobalScreen.registerNativeHook();
            }catch (NativeHookException evt){
                evt.printStackTrace();
            }
            GlobalScreen.addNativeKeyListener(key);

        } else{
            if(a> b){
                GlobalScreen.removeNativeKeyListener(key);
            }

            GlobalScreen.addNativeKeyListener(key);

        }
        }
    }

    public void unhook(Keylogger key) throws NativeMethodException {
        b++;
        GlobalScreen.removeNativeKeyListener(key);
        k.store = "";
    }
    public void printkey(Keylogger key){
        String s="";
        try {
            if(key == null){
                program.ow.write("");
                program.ow.newLine();
                program.ow.flush();
            }
            else{
                res = key.store;
                if(res!= ""){
                    program.ow.write(res);
                    program.ow.newLine();
                    program.ow.flush();
                    key.store = "";
                }
                else {
                    program.ow.write("");
                    program.ow.newLine();
                    program.ow.flush();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void keylog()throws IOException
    {
        keylogger key =new keylogger();
        boolean flag = true;
        while (flag)
        {
            receiveSignal();
            switch (program.signal)
            {
                case "HOOK"->hookKey(key);break;
                case "UNHOOK"->unhook(key);break;
                case "PRINT"->printkey(key);break;
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
                case "XEM":
                {
                    try {
                        String row = null;
                        Process proc = Runtime.getRuntime().exec("powershell.exe Get-Process | Where-Object { $_.MainWindowTitle } | Format-Table ID,Name,Mainwindowtitle –AutoSize");
                        BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));                  
                        int soprocess = 0;
                        while(input.readLine() != null){
                            soprocess++;
                        }
                        String soprocess1 = Integer.toString(soprocess);
                        program.out.write(soprocess1);
                        program.out.newLine();
                        program.out.flush();
                        Process proc1 = Runtime.getRuntime().exec("powershell.exe Get-Process | Where-Object { $_.MainWindowTitle } | Format-Table ID,Name,Mainwindowtitle –AutoSize");
                        input = new BufferedReader(new InputStreamReader(proc1.getInputStream()));
                        ObjectOutputStream output = new ObjectOutputStream(program.server1.getOutputStream());
                        try {
                            for(int i = 0; i < soprocess ;i++) {
                                row = input.readLine();
                                row = row.trim();
                                if (i >= 3) 
                                {
                                    if (i == soprocess - 2)
                                    {
                                        break;
                                    }
                                    row = row.replaceAll("\\s{1,100}", " ");
                                    String[] splitRow = row.split(" ",3);
                                    String info[] = {split[0],split[1],split[2]};
                                    output.writeObject(info);
                                    output.flush();
                                }
                            }
                        }
                        catch(IOException e)
                        {
                        JOptionPane.showMessageDialog(null,e);
                        }
                    }catch(IOException e)
                    {
                      JOptionPane.showMessageDialog(null,e);
                    }
                    break;
                }
                 case "START":
                 {
                    boolean test = true;
                    while(test)
                    {
                        receiveSignal();
                        switch(program.signal)
                        {
                            case "STARTEXE" -> {
                                String exe = program.in.readLine();
                                if (exe != "ERROR")
                                {
                                    try {
                                        ProcessBuilder procBuild = new ProcessBuilder();
                                        procBuild.command(exe + ".exe");
                                        procBuild.start();
                                        program.out.write("Run program successfully!");
                                        program.out.newLine();
                                        program.out.flush();
                                    } catch (IOException ex) {
                                        program.out.write("Run program fail!");
                                        program.out.newLine();
                                        program.out.flush();
                                    }
                                } else {
                                    program.out.write("Run program fail!");
                                    program.out.newLine();
                                    program.out.flush();
                                    break;
                                }
                            }
                            case "QUIT" -> {
                                test = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                  case "KILL":
                  {
                    boolean test = true;
                    while(test)
                    {
                        receiveSignal();
                        switch(program.signal)
                        {
                            case "KILLID" -> {
                                String pid = program.in.readLine();
                                if (pid != "ERROR")
                                {
                                    try {
                                        String[] cmd = {"taskkill", "/F", "/T", "/PID", pid};
                                        ProcessBuilder procBuild = new ProcessBuilder();
                                        procBuild.command(cmd);
                                        procBuild.start();
                                        program.out.write("Kill program successfully!");
                                        program.out.newLine();
                                        program.out.flush();
                                    } catch (IOException ex) {
                                        program.out.write("Kill program fail!");
                                        program.out.newLine();
                                        program.out.flush();
                                    }
                                } else {
                                    program.out.write("Kill program fail!");
                                    program.out.newLine();
                                    program.out.flush();
                                    break;
                                }
                            }
                            case "QUIT" -> {
                                test = false;
                                break;
                            }
                        }
                    }
                    break;
                  }
                  case "QUIT":
                  {
                      break;
                }
            }
        }
    }
     public void process() throws IOException
    {
        while (true)
        {
            receiveSignal();
            switch(program.signal)
            {
                case "XEM":
                {
                    try {
                        String row = null;
                        Process proc = Runtime.getRuntime().exec("tasklist");
                        BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));                  
                        int soprocess = 0;
                        while(input.readLine() != null){
                            soprocess++;
                        }
                        String soprocess1 = Integer.toString(soprocess);
                        program.out.write(soprocess1);
                        program.out.newLine();
                        program.out.flush();
                        Process proc1 = Runtime.getRuntime().exec("tasklist");
                        input = new BufferedReader(new InputStreamReader(proc1.getInputStream()));
                        ObjectOutputStream output = new ObjectOutputStream(program.server1.getOutputStream());
                        try {
                            for(int i = 0; i < soprocess ; i++) {
                                row = input.readLine();
                                row = line.trim();
                                if (i >= 3)
                                {
                                    for (int j = 0; j < row.length()-2; j++)
                                    {
                                        if ((row.charAt(j) > 64 && row.charAt(j) <= 122) && (row.charAt(j + 2) > 64 && row.charAt(j + 2) <= 122) && row.charAt(j + 1) == ' ')
                                        {
                                            row = line.substring(0,j + 1) + "_" + row.substring(j + 2, row.length());
                                        }
                                    }
                                    String[] splitRow = row.split("\\s{1,100}");
                                    String info[] = {splitRow[0],splitRow[1],splitRow[2],splitRow[3],splitRow[4]+splitRow[5]};
                                    output.writeObject(info);
                                    output.flush();
                                }
                            }
                        }catch(IOException e)
                        {
                          JOptionPane.showMessageDialog(null,e);
                        }
                    }
                    catch(IOException e)
                    {
                      JOptionPane.showMessageDialog(null,e);
                    }
                }
                 case "START":
                 {
                    boolean test = true;
                    while(test)
                    {
                        receiveSignal();
                        switch(program.signal)
                        {
                            case "STARTEXE" -> {
                                String exe = program.in.readLine();
                                if (exe != "ERROR")
                                {
                                    try {
                                        ProcessBuilder pBuild = new ProcessBuilder();
                                        pBuild.command(exe + ".exe");
                                        pBuild.start();
                                        program.out.write("Run program successfully!");
                                        program.out.newLine();
                                        program.out.flush();
                                    } catch (IOException ex) {
                                        program.out.write("Run program fail!");
                                        program.out.newLine();
                                        program.out.flush();
                                    }
                                } else {
                                    program.out.write("Run program fail!");
                                    program.out.newLine();
                                    program.out.flush();
                                    break;
                                }
                            }
                            case "QUIT" -> {
                                test = false;
                                break;
                            }
                        }
                    }
                }
                  case "KILL":
                  {
                    boolean test = true;
                    while(test)
                    {
                        receiveSignal();
                        switch(program.signal)
                        {
                            case "KILLID" -> {
                                String pid = program.in.readLine();
                                if (pid != "ERROR")
                                {
                                    try {
                                        String[] cmd = {"taskkill", "/F", "/T", "/PID", pid};
                                        ProcessBuilder pBuild = new ProcessBuilder();
                                        pBuild.command(cmd);
                                        pBuild.start();
                                        program.out.write("Kill program successfully!");
                                        program.out.newLine();
                                        program.out.flush();
                                    } catch (IOException ex) {
                                        program.out.write("Kill program fail!");
                                        program.out.newLine();
                                        program.out.flush();
                                    }
                                } else {
                                    program.out.write("Kill program fail!");
                                    program.out.newLine();
                                    program.out.flush();
                                    break;
                                }
                            }
                            case "QUIT" -> {
                                test = false;
                                break;
                            }
                        }
                    }
                  }
                  case "QUIT":
                  {
                      break;
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
                    case "KEYLOG"->keylog();
                    case "PROCESS"-> process();
                    case "APPLICATION"-> application();
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
