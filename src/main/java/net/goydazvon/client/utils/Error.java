package net.goydazvon.client.utils;

import java.text.SimpleDateFormat;

public class Error {

    public void println(Object x) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String current = formatter.format(date);

        System.err.println(String.format("[%s ERROR]: %s", current, x));
        Log.log(String.format("[%s ERROR]: %s", current, x));
    }
}
