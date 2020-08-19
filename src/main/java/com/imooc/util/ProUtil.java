package com.imooc.util;

import java.awt.*;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProUtil {

    public static ResourceBundle GetProperties(String name){

        ResourceBundle bundle = ResourceBundle.getBundle(name,Locale.CHINA);
        return bundle;
    }

    public static String GetValue(String name,String key){

        if(GetProperties(name).containsKey(key)) {
            String value = GetProperties(name).getString(key);
            return value;
        }else
        return "没有对应的key";
    }

    public void GetLines(){
        for(int i=0;i<3;i++){
            String name = GetValue("user",("user"+i));
            System.out.println(name);
        }
    }

    public static void main(String[] args){
        ProUtil pro = new ProUtil();
        System.out.println(pro.GetValue("element","user10"));
        pro.GetLines();
    }
}
