package review.zhousai.leetcode6126;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FoodRatings {

    static int N = (int) 1e4 * 2 + 1;
    Food[] fs = new Food[N];
    Map<String, Integer> nums = new HashMap<>();
    Map<String, PriorityQueue<Food>> map = new HashMap<>();
    String[] foods, cuisines;
    int[] ratings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        for (int i = 0; i < foods.length; i++) {
            String cu = cuisines[i];
            PriorityQueue<Food> p = map.getOrDefault(cuisines[i], new PriorityQueue<>((a, b) -> {
                if (a.rating != b.rating) {
                    return b.rating - a.rating;
                } else {
                    return a.name.compareTo(b.name);
                }
            }));
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            fs[i] = f;
            p.add(f);
            map.put(cu, p);
            nums.put(foods[i], i);
        }
    }

    public static void main(String[] args) {
        String[] foods = {"biihw"};
        String[] cuisines = {"okxsrcqn"};
        int[] ratings = {13};
        FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
        obj.changeRating("biihw", 9);
        obj.changeRating("biihw", 13);
        String result = Integer.toBinaryString(3);

    }

    public void changeRating(String food, int newRating) {
        int num = nums.get(food);
        Food f = fs[num];
        PriorityQueue<Food> p = map.get(f.cuis);
        p.remove(fs[num]);
        Food newFood = new Food(food, f.cuis, newRating);
        p.add(newFood);
        map.put(f.cuis, p);
        fs[num] = newFood;
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> p = map.get(cuisine);
        if (p.size() > 0) {
            return p.peek().name;
        }
        return null;
    }

    static class Food {
        String name;
        String cuis;
        int rating;

        public Food(String name, String cuis, int rating) {
            this.name = name;
            this.cuis = cuis;
            this.rating = rating;
        }

        public Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */