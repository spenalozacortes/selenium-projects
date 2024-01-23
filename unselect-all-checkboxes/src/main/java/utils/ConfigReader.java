package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class ConfigReader {
    private JsonObject config;

    public ConfigReader() {
        try {
            FileReader reader = new FileReader("src/main/resources/config.json");
            config = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return config.get("browser").getAsString();
    }

    public String getBaseUrl() {
        return config.get("url").getAsString();
    }

    public int getWait() {
        return config.get("waitSeconds").getAsInt();
    }
}