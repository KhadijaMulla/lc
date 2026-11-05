import java.util.HashSet;

class Solution {
    public int strStr(String haystack, String needle) {

        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for (int i = 0; i < haystack.length(); i++) {
            set1.add(haystack.charAt(i));
        }

        for (int i = 0; i < needle.length(); i++) {
            set2.add(needle.charAt(i));
        }

        if (!set1.containsAll(set2)) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            int j = 0;

            while (j < needle.length()) {

                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }

                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}