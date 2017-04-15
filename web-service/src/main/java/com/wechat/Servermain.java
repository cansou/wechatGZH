package com.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by chengen.gu on 2017/3/29.
 */
public class Servermain extends Thread{



    int x = 4;
    private static Logger logger = LoggerFactory.getLogger(Servermain.class);

    public static void main(String[] args) {

        int x =-1;
        System.out.println(x>>>1);
       x =-1;
        System.out.println(x>>1);
         x =-1;
        System.out.println(x>>>32);
        x =-1;
        System.out.println(x>>>0);
         x =-1;
        System.out.println(x>>32);
    }

    static char[] get(byte []arr){
        char[] c = new char[4];
        int i = 0 ;
        for(byte b : arr){
            c[i++] = (char)b++;
        }
        return c;
    }

    public void start(){
        System.out.println("start");
    }
}



