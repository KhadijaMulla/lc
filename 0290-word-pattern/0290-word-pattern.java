class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if(pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String w = words[i];
// it checkes where any char is mapped with any word
            if(map1.containsKey(c) && !map1.get(c).equals(w)) {
                return false;
            }
// it checks where any word is mapped with any char
            if(map2.containsKey(w) && map2.get(w) != c) {
                return false;
            }

            map1.put(c, w);
            map2.put(w, c);
        }

        return true;
    }
}