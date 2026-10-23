import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        int n = words.length, len = words[0].length();
        Map<String, Integer> need = new HashMap<>();
        for (String w : words) need.put(w, need.getOrDefault(w, 0) + 1);
        int total = n * len;
        for (int i = 0; i < len; i++) {
            Map<String, Integer> window = new HashMap<>();
            int left = i, count = 0;
            for (int j = i; j + len <= s.length(); j += len) {
                String w = s.substring(j, j + len);
                if (!need.containsKey(w)) {
                    window.clear();
                    count = 0;
                    left = j + len;
                    continue;
                }
                window.put(w, window.getOrDefault(w, 0) + 1);
                count++;
                while (window.get(w) > need.get(w)) {
                    String lw = s.substring(left, left + len);
                    window.put(lw, window.get(lw) - 1);
                    count--;
                    left += len;
                }
                if (count == n) {
                    res.add(left);
                    String lw = s.substring(left, left + len);
                    window.put(lw, window.get(lw) - 1);
                    count--;
                    left += len;
                }
            }
        }
        return res;
    }
}