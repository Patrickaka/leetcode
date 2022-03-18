import java.util.*;

class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>();
        int i = 0, j = 0;
        Map<String, int[]> maps = new HashMap<>();
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>();
        while (i < list1.length || j < list2.length) {
            if (i < list1.length) {
                int[] arr1 = new int[2];
                Arrays.fill(arr1, -1);
                arr1 = maps.getOrDefault(list1[i], arr1);
                arr1[0] = i;
                maps.put(list1[i], arr1);
                if (arr1[1] != -1) {
                    List<String> list = treeMap.getOrDefault(arr1[0] + arr1[1], new ArrayList<>());
                    list.add(list1[i]);
                    treeMap.put(arr1[0] + arr1[1], list);
                }
                i++;
            }
            if (j < list2.length) {
                int[] arr2 = new int[2];
                Arrays.fill(arr2, -1);
                arr2 = maps.getOrDefault(list2[j], arr2);
                arr2[1] = j;
                maps.put(list2[j], arr2);
                if (arr2[0] != -1) {
                    List<String> list = treeMap.getOrDefault(arr2[0] + arr2[1], new ArrayList<>());
                    list.add(list2[j]);
                    treeMap.put(arr2[0] + arr2[1], list);
                }
                j++;
            }
        }
        ans = treeMap.get(treeMap.firstKey());
        return ans.toArray(new String[0]);
    }
}