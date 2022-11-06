/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sever;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author HUNG
 */
public class program {
    static public Socket server1;
    static public InputStreamReader ir;
    static public OutputStreamWriter ow;
    static public DataInputStream dis;
    static public DataInputStream dos;
    static public BufferedReader br2;
        public static void main(String args[]) {
            server server = new server();
            server.setVisible(true);
        }
}   
