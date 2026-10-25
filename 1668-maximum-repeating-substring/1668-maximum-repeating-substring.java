
class Solution {
    public int maxRepeating(String sequence, String word) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char ch : sequence.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        for (char ch : word.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for (char ch : map1.keySet()) {
            if (!map2.containsKey(ch) || map2.get(ch) < map1.get(ch)) {
                return 0;
            }
        }

        int count = 0;
        String s = word;

        while (sequence.contains(s)) {
            count++;
            s += word;
        }

        return count;
    }
}
