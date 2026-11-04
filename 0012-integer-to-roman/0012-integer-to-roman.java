
import java.util.*;

class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');

        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        StringBuilder ans = new StringBuilder();

        for (int value : values) {
            while (num >= value) {
                // Handle subtractive cases
                if (value == 1000 && num >= 1000) {
                    ans.append(map.get(1000));
                    num -= 1000;
                } else if (value == 500 && num >= 900) {
                    ans.append("CM");
                    num -= 900;
                } else if (value == 500 && num >= 500) {
                    ans.append(map.get(500));
                    num -= 500;
                } else if (value == 100 && num >= 400) {
                    ans.append("CD");
                    num -= 400;
                } else if (value == 100 && num >= 100) {
                    ans.append(map.get(100));
                    num -= 100;
                } else if (value == 50 && num >= 90) {
                    ans.append("XC");
                    num -= 90;
                } else if (value == 50 && num >= 50) {
                    ans.append(map.get(50));
                    num -= 50;
                } else if (value == 10 && num >= 40) {
                    ans.append("XL");
                    num -= 40;
                } else if (value == 10 && num >= 10) {
                    ans.append(map.get(10));
                    num -= 10;
                } else if (value == 5 && num >= 9) {
                    ans.append("IX");
                    num -= 9;
                } else if (value == 5 && num >= 5) {
                    ans.append(map.get(5));
                    num -= 5;
                } else if (value == 1 && num >= 4) {
                    ans.append("IV");
                    num -= 4;
                } else {
                    ans.append(map.get(1));
                    num--;
                }
            }
        }

        return ans.toString();
    }
}
