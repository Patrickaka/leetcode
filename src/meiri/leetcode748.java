package meiri;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

class Solution748 {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        String result = "";
        String lowerLicensePlate = licensePlate.toLowerCase();
        char[] licensePlates = lowerLicensePlate.toCharArray();
        Map<Character, Integer> letters = getLetterMap(licensePlates);
        String tempWord;
        char[] tempChar;
        for (String word : words) {
            System.out.println("word : " + word);
            tempWord = word.toLowerCase();
            tempChar = tempWord.toCharArray();
            Map<Character, Integer> tempMap = getLetterMap(tempChar);
            AtomicInteger flag = new AtomicInteger();
            letters.forEach((k, v) -> {
                System.out.println("Item : " + k + " Count : " + v + " temp : " + tempMap.get(k));
                if (tempMap.get(k) == null || tempMap.get(k) < v) {
                    flag.set(1);
                }
            });
            if (flag.get() == 0 && result.equals("")) {
                result = word;
            } else if (flag.get() == 0 && word.length() < result.length()) {
                result = word;
            }
        }
        return result;
    }

    private static Map<Character, Integer> getLetterMap(char[] tempChar) {
        Map<Character, Integer> tempMap = new HashMap<>();
        for (char c : tempChar) {
            if (c >= 'a' && c <= 'z') {
                int num = Optional.ofNullable(tempMap.get(c)).orElse(0);
                tempMap.put(c, num + 1);
            }
        }
        return tempMap;
    }

    public static void main(String[] args) {
        String licensePlate = "Ah71752";
        String[] words = {"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"};
        String result = shortestCompletingWord(licensePlate, words);
        System.out.println(result);

    }
}