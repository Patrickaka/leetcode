package meiri.leetcode1656;


import java.util.ArrayList;
import java.util.List;

class OrderedStream {

    String[] values;
    int idx = 1;

    public OrderedStream(int n) {
        values = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        values[idKey] = value;
        List<String> res = new ArrayList<>();
        if (idKey == idx) {
            for (; idx < values.length && values[idx] != null; idx++) {
                res.add(values[idx]);
            }
        }
        return res;
    }
}