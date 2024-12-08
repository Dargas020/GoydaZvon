package net.goydazvon.client.utils;

import java.text.SimpleDateFormat;

public class Warn {

    public void println(Object x){
        String yellowColor = "\u001B[33m";

        String resetColor = "\u001B[0m";

        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String current = formatter.format(date);

        System.out.println(yellowColor + String.format("[%s WARN]: %s", current, x) + resetColor);
        Log.log(String.format("[%s WARN]: %s", current, x));
    }
}
