package net.goydazvon.client.connection;

import net.goydazvon.client.Main;

import java.util.Scanner;

public class Account {

    public static String FIRST_NAME = "Tim";
    public static String SECOND_NAME = "Kirsanov";
    public static String NICKNAME = "@kosinak";
    public static String EMAIL_ADDRESS = "kosinak39@gmail.com";

    public static void logIn() {
        Scanner in = new Scanner(System.in);

        Main.LOGGER.INFO.println("Hello it's GoydaZvon");

//        Main.LOGGER.INFO.println("Please write your first name");
//        FIRST_NAME = in.next();
//        Main.LOGGER.INFO.println("Please write your second name");
//        SECOND_NAME = in.next();
//        Main.LOGGER.INFO.println("Please write your nickname");
//        NICKNAME = in.next();
//        Main.LOGGER.INFO.println("Please write your email address");
//        EMAIL_ADDRESS = in.next();
//
//        Main.LOGGER.INFO.println("Please write ГОЙДА to verify you");
//
//        if(in.next().equals("ГОЙДА")) {
//            new ClientConnection();
//        } else {
//            Main.LOGGER.ERROR.println("Your IP address has been added to the Roskomnadzor list. Our investigator will contact you shortly");
//        }
    }
}
