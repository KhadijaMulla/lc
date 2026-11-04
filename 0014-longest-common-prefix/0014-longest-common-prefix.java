class Solution {
    public String longestCommonPrefix(String[] strs) {

      HashSet<String>set=new HashSet<>();
      for(String ch:strs){
        set.add(ch);
      }
        String ans = "";

        for(int i=0; i<strs[0].length(); i++){

            char ch = strs[0].charAt(i);

            for(String s : set){

                if(i >= s.length() || s.charAt(i) != ch){
                    return ans;
                }
            }

            ans += ch;
        }

        return ans;
    }
}