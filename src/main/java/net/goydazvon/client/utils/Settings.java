package net.goydazvon.client.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Settings {

    public static AccountData read() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("settings.json"));
        return new Gson().fromJson(br, AccountData.class);
    }

    public static void save(AccountData data) {
        try(FileWriter writer = new FileWriter("settings.json",true)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            writer.write(gson.toJson(data));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
