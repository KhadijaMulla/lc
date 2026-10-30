class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>>ans=new ArrayList<>();
       if(root==null){
        return ans;
       }
       Queue<TreeNode>q=new LinkedList<>();
       q.offer(root);
       while(!q.isEmpty()){
        int size=q.size();
        List<Integer>level=new ArrayList<>();
        for(int i=0;i<size;i++){
            TreeNode curr=q.poll();
            level.add(curr.val);
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
        }
        ans.add(level);
       }
       return ans;
    }
}