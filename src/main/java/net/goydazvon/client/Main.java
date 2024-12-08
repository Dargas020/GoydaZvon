package net.goydazvon.client;

import net.goydazvon.client.utils.AccountData;
import net.goydazvon.client.utils.Settings;
import net.kosinak.network.Crypto;
import net.goydazvon.client.connection.Account;
import net.goydazvon.client.connection.ClientConnection;
import net.goydazvon.client.utils.Logger;

import java.io.IOException;
import java.net.InetAddress;

public class Main {

    public static Logger LOGGER = new Logger();
    public static String key = "HTds4#a^k!jCQuVU";
    public static String initVector = "by@%CbTWnVcsx6s9";
    public static Crypto crypto = new Crypto(key, initVector);
    public static AccountData accountData;

    public static void main(String[] args) throws IOException {
        Account.logIn();
        accountData = Settings.read();

        try {
            InetAddress addr = InetAddress.getByName(null);
            new ClientConnection(addr);
        } catch (Exception e) {
            LOGGER.ERROR.println(e);
            e.printStackTrace();
        }
    }
}