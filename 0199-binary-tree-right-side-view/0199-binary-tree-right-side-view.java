/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer>ans=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
              ans.clear();
       ak(root,0);
       return ans;
    }
    public void ak(TreeNode root,int level){
       if(root==null){
        return;
       }
       if(level==ans.size()){
        ans.add(root.val);
       }
       
       ak(root.right,level+1);
        ak(root.left,level+1);







    }
}