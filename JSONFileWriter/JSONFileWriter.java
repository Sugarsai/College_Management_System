package JSONFileWriter;

import java.io.*;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileWriter {
    private String filename;
    private LinkedHashMap<String ,Object> LHash;
    public JSONFileWriter(){}
    public JSONFileWriter(String filename,LinkedHashMap<String , Object> LHash) {
        this.filename = filename;
        this.LHash = LHash;
        JSONObject jsonobj = new JSONObject();
    }

    public void AddToJSON(JSONObject jsonobj,String filename) {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray;

        try (FileReader reader = new FileReader(filename)) {
            Object obj = parser.parse(reader);
            if (obj instanceof JSONArray) {
                jsonArray = (JSONArray) obj;
            } else if (obj instanceof JSONObject) {
                jsonArray = new JSONArray();
                jsonArray.add((JSONObject) obj);
            } else {
                jsonArray = new JSONArray();
            }
        } catch (FileNotFoundException e) {
            jsonArray = new JSONArray();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return;
        }
        jsonArray.add(jsonobj);

        try (FileWriter file = new FileWriter(filename)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  JSONObject searchJsonObjectByKey(String fileName, String keyToSearch, String valueToSearch) {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray;

        try (FileReader reader = new FileReader(fileName)) {
            Object obj = parser.parse(reader);
            if (obj instanceof JSONArray) {
                jsonArray = (JSONArray) obj;
                for (Object o : jsonArray) {
                    JSONObject jsonObject = (JSONObject) o;
                    Object value = jsonObject.get(keyToSearch);
                    if (value != null && value.toString().equals(valueToSearch)) {
                        return jsonObject;
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean deleteJsonObjectByKey(String fileName, String keyToDelete, String valueToDelete) {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray;

        try (FileReader reader = new FileReader(fileName)) {
            Object obj = parser.parse(reader);
            if (obj instanceof JSONArray) {
                jsonArray = (JSONArray) obj;

                Iterator<JSONObject> iterator = jsonArray.iterator();
                while (iterator.hasNext()) {
                    JSONObject jsonObject = iterator.next();
                    Object value = jsonObject.get(keyToDelete);
                    if (value != null && value.toString().equals(valueToDelete)) {
                        iterator.remove();
                        writeJsonArrayToFile(fileName, jsonArray);
                        return true;
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void writeJsonArrayToFile(String fileName, JSONArray jsonArray) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillEmptyValues(String filename,JSONArray jsonArray){

    }
}
