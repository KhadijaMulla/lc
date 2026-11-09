
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        boolean[] used = new boolean[strs.length];
        String[] sorted = new String[strs.length];

        for(int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            sorted[i] = new String(arr);
        }

        for(int i = 0; i < strs.length; i++) {

            if(used[i]) {
                continue;
            }

            List<String> group = new ArrayList<>();

            for(int j = i; j < strs.length; j++) {

                if(!used[j] && sorted[i].equals(sorted[j])) {
                    group.add(strs[j]);
                    used[j] = true;
                }
            }

            result.add(group);
        }

        return result;
    }
}
