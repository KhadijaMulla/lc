class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String folder : parts) {

            if (folder.equals("") || folder.equals(".")) {
                continue;
            }

            else if (folder.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            else {
                stack.push(folder);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (String folder : stack) {
            ans.append("/").append(folder);
        }

        if (ans.length() == 0) {
            return "/";
        }

        return ans.toString();
    }
}