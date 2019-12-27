package com.appdevelapp.challenges.gfg;

import com.sun.org.apache.xml.internal.resolver.readers.SAXCatalogParser;
import javafx.beans.binding.StringBinding;
import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class TheManipulator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        String[] output = new String[T];
        for (int i = 0; i < T; i++) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();

            str1 = decodeString(str1);
            str2 = decodeString(str2);
            if(str1.equals(str2)){
                output[i] = "Yes";
            }
            else{
                output[i] = "No";
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(output[i]);
        }
    }

    private static String decodeString(String str){
        StringBuilder builder = new StringBuilder();
        char ch = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if(currentChar == '#'){
                ch = (char)((int)ch + 1);
                if(ch > 'Z'){
                    ch = 'A';
                }
            }
            else{
                builder.append(ch);
                ch = currentChar;
            }
        }

        builder.append(ch);
//        if(str.charAt(str.length()-1) != '#'){
//            builder.append(str.charAt(str.length()-1));
//        }
        str = builder.toString();
        return str;
    }
}
