class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root==null){
            return ans;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer>level=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(leftToRight){
                    level.add(curr.val);
                }
                else{
                    level.add(0,curr.val);
                }
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }
            }
                ans.add(level);
                leftToRight=!leftToRight;
            
        }

        return ans;
        
    }
}