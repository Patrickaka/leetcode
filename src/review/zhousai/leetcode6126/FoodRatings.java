package review.zhousai.leetcode6126;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class FoodRatings extends HashMap<String, TreeSet<String>> {

    Map<String, Map.Entry<String, Integer>> map = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            map.put(foods[i], Map.entry(cuisines[i], ratings[i]));
            computeIfAbsent(cuisines[i],
                    t -> new TreeSet<>((o, p) -> map.get(o).getValue().equals(map.get(p).getValue()) ? o.compareTo(p)
                            : map.get(p).getValue() - map.get(o).getValue()))
                    .add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        get(map.get(food).getKey()).remove(food);
        map.put(food, Map.entry(map.get(food).getKey(), newRating));
        get(map.get(food).getKey()).add(food);
    }

    public String highestRated(String cuisine) {
        return get(cuisine).first();
    }
}
