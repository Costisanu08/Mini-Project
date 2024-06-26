package ex1;

import java.util.HashMap;
import java.util.Map;

public class Blackboard {
    private static Map<String, Object> data = new HashMap<>();

    public static synchronized void writeToBlackboard(String key, Object value) {
        data.put(key, value);
    }

    public static synchronized Object readFromBlackboard(String key) {
        return data.get(key);
    }

    public static synchronized void removeFromBlackboard(String key) {
        data.remove(key);
    }
}
