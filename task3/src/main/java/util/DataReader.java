package util;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class DataReader {
    public static JsonArray readTestData() {
        try {
            return JsonParser.parseReader(new FileReader("src/test/java/data/testdata.json")).getAsJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
