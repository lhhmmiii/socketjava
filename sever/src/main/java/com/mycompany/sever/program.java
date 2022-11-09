/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sever;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author HUNG
 */
public class program {
    static public Socket server1;
    static public BufferedReader in;
    static public BufferedWriter out;
    static public String signal;
        public static void main(String args[]) {
            server server = new server();
            server.setVisible(true);
        }
}   
