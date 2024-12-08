package net.goydazvon.client.utils;

import java.text.SimpleDateFormat;

public class Info {

    public void println(Object x) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String current = formatter.format(date);

        System.out.println(String.format("[%s INFO]: %s", current, x));
//        Log.log(String.format("[%s INFO]: %s", current, x));
    }
}
