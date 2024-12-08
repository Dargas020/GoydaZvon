package net.goydazvon.client.connection;

import net.goydazvon.client.Main;
import net.kosinak.network.Package;
import net.kosinak.network.Types;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnection extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static int counter = 0;
    private int id = counter++;
    private static int threadcount = 0;

    public static int threadCount() {
        return threadcount;
    }

    public ClientConnection(InetAddress addr) {
        Main.LOGGER.INFO.println("Making client " + id);
        threadcount++;
        try {
            socket = new Socket(addr, 7450);
        }
        catch (IOException e) {
            Main.LOGGER.ERROR.println("Socket failed");
            // Если создание сокета провалилось,
            // ничего ненужно чистить.
        }
        try {
            in = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            // Включаем автоматическое выталкивание:
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream())), true);
            start();
        }
        catch (IOException e) {
            // Сокет должен быть закрыт при любой
            // ошибке, кроме ошибки конструктора сокета:
            try {
                socket.close();
            }
            catch (IOException e2) {
                Main.LOGGER.ERROR.println("Socket not closed");
            }
        }
        // В противном случае сокет будет закрыт
        // в методе run() нити.
    }

    public void run() {
        try {
            Scanner inS = new Scanner(System.in);
            String message = inS.next();
            Package pack = new Package(Types.TEXT_SEND, Main.accountData.NICKNAME, "chat", Main.crypto.encrypt(message), Main.key);
            out.println(pack);
            String str = in.readLine();
            Main.LOGGER.INFO.println("PACKAGE FROM SERVER: " + str);
            out.println("END");
        }
        catch (IOException e) {
            Main.LOGGER.ERROR.println("IO Exception");
        }
        finally {
            // Всегда закрывает:
            try {
                socket.close();
            }
            catch (IOException e) {
                Main.LOGGER.ERROR.println("Socket not closed");
            }
            threadcount--; // Завершаем эту нить
        }
    }
}