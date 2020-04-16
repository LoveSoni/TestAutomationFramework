package utilities;

/**
 * author Love
 */

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtility {

    private static Logger logger = Logger.getLogger(JsonUtility.class);

    public static JSONObject getFileAsJsonObject(String filePath) {
        FileReader fileReader = null;
        JSONObject jsonObject = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException f) {
            logger.error(f.getMessage());
        }
        JSONParser jsonParser = new JSONParser();
        try {
            jsonObject = (JSONObject) jsonParser.parse(fileReader);
        } catch (ParseException | IOException i) {
            logger.error(i.getMessage());
        }
        return jsonObject;
    }

    public static JSONArray getFileAsJsonArray(String filePath) {
        FileReader fileReader = null;
        JSONArray jsonArray = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException f) {
            logger.error(f.getMessage());
        }
        JSONParser jsonParser = new JSONParser();
        try {
            jsonArray = (JSONArray) jsonParser.parse(fileReader);
        } catch (ParseException | IOException i) {
            logger.error(i.getMessage());
        }
        return jsonArray;
    }

    public static JSONObject getJsonObjectFromString(String jsonString) {
        JSONObject jsonObject = null;
        JSONParser jsonParser = new JSONParser();
        try {
            jsonObject = (JSONObject) jsonParser.parse(jsonString);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        return jsonObject;
    }

    public static void closeFile(FileReader fileReader) {
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
