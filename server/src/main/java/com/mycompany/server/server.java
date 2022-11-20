/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.server;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.sun.jdi.NativeMethodException;
import java.awt.Dimension;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import javax.swing.JOptionPane;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author LEGION
 */

public class server extends javax.swing.JFrame {

    /**
     * Creates new form server
     */
    public server() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openserver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        openserver.setText("Mở server");
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
                .addGap(87, 87, 87)
                .addComponent(openserver, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(openserver, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void receiveSignal()
    {
        try{
           program.signal = program.in.readLine();
        }catch (IOException e) {
           program.signal = "QUIT";
        }
    }
    
    private void openserverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openserverActionPerformed
       ServerSocket server = null;
       JOptionPane.showMessageDialog(null, "Mở server thành công");
       try {
           server = new ServerSocket(2003);
           program.server1 = server.accept();
           program.in = new BufferedReader(new InputStreamReader(program.server1.getInputStream()));
           program.out = new BufferedWriter(new OutputStreamWriter(program.server1.getOutputStream()));
           boolean test = true;
           while (test)
           {
               receiveSignal();
               switch (program.signal)
               {
                    case "TAKEPIC" ->{
                        takepic();
                        break;
                    }
                    case "SHUTDOWN" ->{
                        shutdown();
                        break;
                    }
                    case "RESTART"->{
                        restart();
                        break;
                    }
                    case "HIBERNATE"-> {
                        hibernate();
                        break;
                    }
                    case "APPLICATION" -> {
                        application();
                        break;
                    }
                    case "LOGOFF" -> {
                        logoff();
                        break;
                    }
                    case "PROCESS" -> {
                        process();
                        break;
                    }
                    case "KILL" -> {
                        kill();
                        break;
                    }
                    case "START" -> {
                        start();
                        break;
                    }
                    case "KEYLOG" -> {
                        keylogger();
                        break;
                    }
                    case "THOAT" -> {
                        program.server1.close();
                        server.close();
                        return;
                    }
                    case "QUIT" -> {
                        break;
                    }
               }
           }
       } catch (IOException e) {
           JOptionPane.showMessageDialog(rootPane, "Không thể mở server");
       } 
    }//GEN-LAST:event_openserverActionPerformed
    int a=0;
    int b=1;
    public void hookKey(KeyLogger key){
        a++;
        if(a==1)
        {
            try{
                GlobalScreen.registerNativeHook();
            }catch (NativeHookException evt){
                evt.printStackTrace();
            }

        } else{
            if(a> b){
                GlobalScreen.removeNativeKeyListener(key);
            }

        }
        GlobalScreen.addNativeKeyListener(key);
    }


    public void unhook(KeyLogger key) throws NativeMethodException {
        b++;
        GlobalScreen.removeNativeKeyListener(key);
        key.s = "";
    }
    public void printer(KeyLogger key){
        String s="";
        try {
            if(key == null){
                program.out.write("");
                program.out.newLine();
                program.out.flush();
                
                program.out.write("n2");
                program.out.newLine();
                program.out.flush();
            }
            else{
                s = key.s;
                if(s!= ""){
                    System.out.println(s);
                    program.out.write(s);
                    program.out.newLine();
                    program.out.flush();
                    
                    program.out.write("");
                    program.out.newLine();
                    program.out.flush();
                    key.s = "";
                }
                else {
                    program.out.write("");
                    program.out.newLine();
                    System.out.println("");
                    program.out.flush();
                    
                    program.out.write("");
                    program.out.newLine();
                    program.out.flush();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void keylogger()throws IOException
    {
        KeyLogger key =new KeyLogger();
        boolean test = true;
        while (test)
        {
            receiveSignal();
            switch (program.signal)
            {
                case "HOOK" -> {
                    hookKey(key);
                    break;
                }
                case "UNHOOK" -> {
                    unhook(key);
                    break;
                }
                case "PRINT" -> {
                    printer(key);
                    break;
                }
                case "QUIT"->{
                   test=false;
                   break;
                }
            }
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
    public void restart()
    {
        try{
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec("shutdown -r -t 5");
            System.exit(0);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void logoff()
    {
        try{
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec("shutdown -l");
            System.exit(0);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void hibernate()
    {
        try{
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec("shutdown -h -t 5");
            System.exit(0);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void application() throws IOException{
        boolean test = true;
        while (test)
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
                                    String info[] = {splitRow[0],splitRow[1],splitRow[2]};
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
                case "QUIT":
                {
                      test = false;
                      break;
                }
            }
        }
    }
    public void process() throws IOException{
        boolean test = true;
         while (test)
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
                            for(int i = 0; i < soprocess ;i++) {
                                row = input.readLine();
                                row = row.trim();
                                if (i >= 3)
                                {
                                    for (int j = 0; j < row.length() - 2; j++)
                                    {
                                        if ((row.charAt(j) > 64 && row.charAt(j) <= 122) && (row.charAt(j + 2) > 64 && row.charAt(j + 2) <= 122) && row.charAt(j + 1) == ' ')
                                        {
                                            row = row.substring(0, j + 1) + "_" + row.substring(j + 2, row.length());
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
                case "QUIT":
                {
                      test = false;
                      break;
                }
            }
        }
    }
    
    public void kill() throws IOException
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
                            Runtime.getRuntime().exec("taskkill /F /T /PID " + pid);
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
    
    public void start() throws IOException
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
                            //ProcessBuilder pBuild = new ProcessBuilder();
                            //pBuild.command(exe + ".exe");
                            //pBuild.start();
                            Runtime.getRuntime().exec("powershell " + "start " + exe + ".exe");
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
    
    public void takepic() throws IOException
        {
            boolean test=true;
            while(test){
                switch(program.signal){
                    case "TAKE"->{
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
                            JLabel label = new JLabel();
                            label.setIcon(new ImageIcon(image));
                        }catch(IOException e){
                            e.printStackTrace();
                        } 
                    }
                    case "QUIT"->{
                        test=false;
                        break;
                    }
                }
            }       
        }
    
    ByteArrayOutputStream ous = null;
    ObjectOutputStream output = null;
    BufferedReader input = null;
    OutputStream os = null;
    Process p = null;
    Process p1 = null;
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private Image newimg;
    private Robot robot;
    private static BufferedImage bimg;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton openserver;
    // End of variables declaration//GEN-END:variables
//    private ByteArrayOutputStream ous = new ByteArrayOutputStream();
    void setvisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
