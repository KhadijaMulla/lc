class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the original tree
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        int[] newParent = parent.clone();

        // Find the closest ancestor having the same character
        int[][] last = new int[n][26];

        for (int i = 0; i < n; i++) {
            Arrays.fill(last[i], -1);
        }

        dfs(0, -1, adj, s, newParent, last);

        // Build the modified tree
        List<List<Integer>> newAdj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            newAdj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            newAdj.get(newParent[i]).add(i);
        }

        // Calculate subtree sizes
        int[] answer = new int[n];
        calculateSize(0, newAdj, answer);

        return answer;
    }

    void dfs(int node, int p, List<List<Integer>> adj,
             String s, int[] newParent, int[][] last) {

        int ch = s.charAt(node) - 'a';

        int previous = last[node][ch];

        if (previous != -1) {
            newParent[node] = previous;
        }

        for (int child : adj.get(node)) {
            last[child] = last[node].clone();
            last[child][ch] = node;

            dfs(child, node, adj, s, newParent, last);
        }
    }

    int calculateSize(int node, List<List<Integer>> adj, int[] answer) {
        int size = 1;

        for (int child : adj.get(node)) {
            size += calculateSize(child, adj, answer);
        }

        answer[node] = size;
        return size;
    }
}