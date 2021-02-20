package q76;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String minWindow(String s, String t) {


        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();


        int tLength = t.length();
        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = -1;

        int maxLength = Integer.MAX_VALUE;
        int ansL = -1, ansR = -1;
        while (right < maxLength) {






        }
return null;
    }

}
