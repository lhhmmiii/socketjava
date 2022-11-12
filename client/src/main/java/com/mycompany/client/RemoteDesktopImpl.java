/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.client;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import java.util.Date;
import java.util.Optional;
/**
 *
 * @author thoanhkhoa2702
 */
public class RemoteDesktopImpl extends UnicastRemoteObject implements IRemoteDesktop {
  @Override
  public String getProcessList() throws RemoteException {
    String str = "";
    try {
      Process p = Runtime.getRuntime().exec("tasklist");
      BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

      String line;
      StringBuilder stringBuilder = new StringBuilder();

      while ((line = input.readLine()) != null) {
        stringBuilder.append(line);
        stringBuilder.append("\n");
      }

      str = stringBuilder.toString();

      System.out.println(str);
    } catch (Exception err) {
      err.printStackTrace();
    }
    return str;
  }
  
  @Override
  public boolean createNewProcess(String name) throws RemoteException {
    try {
      Runtime.getRuntime().exec("powershell " + "start " + name + ".exe");
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  @Override
  public boolean killProcess(String name) throws RemoteException {
    try {
      Runtime.getRuntime().exec("taskkill /F /PID " + name);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  @Override
  public String getAppList() throws RemoteException {
    String str = "";
    try {
      Process p = Runtime.getRuntime().exec("powershell \"gps | where {$_.MainWindowTitle } | select id, name");
      BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

      String line;
      StringBuilder stringBuilder = new StringBuilder();

      while ((line = input.readLine()) != null) {
        stringBuilder.append(line);
        stringBuilder.append("\n");
      }

      str = stringBuilder.toString();

      System.out.println(str);
    } catch (Exception err) {
      err.printStackTrace();
    }
    return str;
  }
}
