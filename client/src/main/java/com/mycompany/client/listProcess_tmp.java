/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.client;

import com.mycompany.client.IRemoteDesktop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author thoanhkhoa2702
 */
public class listProcess extends JDialog implements Runnable {
    public final static int WIDTH_DIALOG = 470;
  public final static int HEIGHT_DIALOG = 430;

  private JScrollPane process_scroll;

  private IRemoteDesktop remote_obj;
  private Thread update_thread;

  private String nameProcess;
  private String process;

  public listProcess(JFrame owner, IRemoteDesktop remote_obj) throws RemoteException {
    super(owner);
    this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    this.setTitle("PROCESS INFORMATION");
    this.setResizable(true);
    this.getContentPane().setPreferredSize(new Dimension(listProcess.WIDTH_DIALOG, listProcess.HEIGHT_DIALOG));
    this.setLayout(null);
    this.pack();

    this.remote_obj = remote_obj;
//    this.process = this.remote_obj.getProcessList();
    this.initComponents();

    // TODO: start graph
    this.update_thread = new Thread(this);
    this.update_thread.setDaemon(true);
    this.update_thread.start();
  }
  private void initComponents() throws RemoteException {
    this.process = this.remote_obj.getProcessList();
    // TODO: label
    JLabel label = new JLabel();
    label.setText("PROCESS INFORMATION");
    label.setFont(new Font("segoe ui", Font.BOLD, 14));
    label.setBounds(150, 20, 500, 30);
    this.add(label);

    // TODO: list process
    System.out.println("PROCESS");
    System.out.println(this.process);

    String rows[] = this.process.split("\n");


    Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
    for (String row : rows) {
      row = row.trim();  //UPDATE
      Vector<String> data = new Vector<String>();
      data.addAll(Arrays.asList(row.split("\\s+")));
      dataVector.add(data);
    }

    //remove redundant
    dataVector.remove(0);
    dataVector.remove(0);
    dataVector.remove(0);


    Vector<String> header = new Vector<String>(2);
    header.add("Image Name");
    header.add("PID");
    header.add("Session Name");
    header.add("Session#");
    header.add("Mem Usage");

    TableModel model = new DefaultTableModel(dataVector, header);
    JTable table = new JTable(model);
//    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    this.process_scroll =  new JScrollPane(table);
    this.process_scroll.setBounds(20, 80, 430, 240);
    this.add(process_scroll);

    // TODO: Button refresh
    Button refreshBtn = new Button("Refresh");
    refreshBtn.setBounds(340, 50, 110, 25);
    refreshBtn.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        initListProcess();
      }
    });
    this.add(refreshBtn);

    // TODO: Button add new process
    TextField textField = new TextField("Enter name");
    textField.setBounds(20, 340, 320, 30);
    textField.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textField.setText("");
        System.out.println("Hello");
      }
    });
    this.add(textField);

    Button addBtn = new Button("Add new");
    addBtn.setBounds(340, 340, 110, 30);
    addBtn.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        String name = textField.getText();
        newProcessMousePressed(e, name);
      }
    });
    this.add(addBtn);


    // TODO: Button delete process
    Button delBtn = new Button("Enter PID then press delete");
    delBtn.setBounds(20, 380, 430, 30);
    delBtn.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        String PID = textField.getText();
        killProcessMousePressed(e, PID);
      }
    });
    this.add(delBtn);
  }

  @Override
  public void run() {

  }

  @Override
  public void dispose() {
    super.setVisible(false);
    super.dispose();
    if(!this.update_thread.isInterrupted())
      this.update_thread.interrupt();
  }

  private void initListProcess() {
    try {
      this.process = this.remote_obj.getProcessList();
    } catch (RemoteException ex) {
      ex.printStackTrace();
    }

//    System.out.println(this.app);
    String rows[] = this.process.split("\n");


    Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
    for (String row : rows) {
      row = row.trim();  //UPDATE
      Vector<String> data = new Vector<String>();
      data.addAll(Arrays.asList(row.split("\\s+")));
      dataVector.add(data);
    }

    //remove redundant
    dataVector.remove(0);
    dataVector.remove(0);
    dataVector.remove(0);


    Vector<String> header = new Vector<String>(2);
    header.add("Image Name");
    header.add("PID");
    header.add("Session Name");
    header.add("Session#");
    header.add("Mem Usage");


    this.remove(process_scroll);
    DefaultTableModel model = new DefaultTableModel(dataVector, header);
    JTable table = new JTable(model);
//    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    this.process_scroll =  new JScrollPane(table);
    this.process_scroll.setBounds(20, 80, 430, 240);
    this.add(process_scroll);

  }

  private void newProcessMousePressed(MouseEvent e, String name) {
      System.out.println(name);
      try {
        boolean createProcess = this.remote_obj.createNewProcess(name);
        if (createProcess == true) {
          JOptionPane.showMessageDialog(this,"Create process successfully");
        }
        else {
          JOptionPane.showMessageDialog(this,"Create process fail.","Alert",JOptionPane.WARNING_MESSAGE);
        }
      } catch (RemoteException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,"Create process error.","Alert",JOptionPane.WARNING_MESSAGE);
      }
  }

  private void killProcessMousePressed(MouseEvent e, String PID) {
    System.out.println(PID);
    try {
      boolean delProcess = this.remote_obj.killProcess(PID);
      if (delProcess == true) {
        JOptionPane.showMessageDialog(this,"Delete process successfully");
      }
      else {
        JOptionPane.showMessageDialog(this,"Delete process fail.","Alert",JOptionPane.WARNING_MESSAGE);
      }
    } catch (RemoteException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(this,"Delete process error.","Alert",JOptionPane.WARNING_MESSAGE);
    }
  }
}
