/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.client;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

/**
 *
 * @author HUNG
 */
public class program {
    static public Socket client1;
    static public BufferedReader in;
    static public BufferedWriter out;
    public static String ip;
    public static void main(String args[]) {
           client client = new client();
           client.setVisible(true);
        }
}
