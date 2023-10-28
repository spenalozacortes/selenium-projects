package util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class ConfigReader {
    private JsonObject config;

    public ConfigReader() {
        try {
            FileReader reader = new FileReader("src/main/java/resources/config.json");
            config = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return config.getAsJsonObject("webdriver").get("browser").getAsString();
    }

    public String getBaseUrl() {
        return config.get("url").getAsString();
    }

    public int getTimeoutInSeconds() {
        return config.get("timeout").getAsInt();
    }

}
