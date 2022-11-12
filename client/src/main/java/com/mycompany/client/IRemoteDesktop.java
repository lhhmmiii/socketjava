/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 *
 * @author thoanhkhoa2702
 */
public interface IRemoteDesktop extends Remote {
    String getProcessList() throws RemoteException;
    boolean createNewProcess(String name) throws RemoteException;
    boolean killProcess(String name) throws RemoteException;
    String getAppList() throws RemoteException;
}
