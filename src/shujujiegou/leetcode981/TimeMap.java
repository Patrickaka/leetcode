package shujujiegou.leetcode981;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tr = map.getOrDefault(key, new TreeMap<>());
        tr.put(timestamp, value);
        map.put(key, tr);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tr = map.get(key);
        if (tr == null) {
            return "";
        }
        Map.Entry<Integer, String> lower = tr.floorEntry(timestamp);
        if (lower == null) {
            return "";
        } else {
            return lower.getValue();
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */