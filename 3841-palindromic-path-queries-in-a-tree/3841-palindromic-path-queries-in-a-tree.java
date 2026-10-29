
import java.util.*;

class Solution {
    int[] tin, tout, depth;
    int[][] up;
    int[] bit;
    int timer;
    List<Integer>[] adj;
    int LOG;

    void updateBIT(int i, int val, int n) {
        while (i <= n) {
            bit[i] ^= val;
            i += i & -i;
        }
    }

    int queryBIT(int i) {
        int res = 0;
        while (i > 0) {
            res ^= bit[i];
            i -= i & -i;
        }
        return res;
    }

    void rangeUpdate(int l, int r, int val, int n) {
        updateBIT(l, val, n);
        if (r + 1 <= n) {
            updateBIT(r + 1, val, n);
        }
    }

    void dfs(int node, int parent, int n) {
        tin[node] = ++timer;
        up[0][node] = parent;

        for (int j = 1; j < LOG; j++) {
            up[j][node] = up[j - 1][up[j - 1][node]];
        }

        for (int next : adj[node]) {
            if (next == parent) continue;

            depth[next] = depth[node] + 1;
            dfs(next, node, n);
        }

        tout[node] = timer;
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        up = new int[LOG][n];
        bit = new int[n + 2];

        timer = 0;
        dfs(0, 0, n);

        int[] mask = new int[n];
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            mask[i] = 1 << (chars[i] - 'a');
            rangeUpdate(tin[i], tout[i], mask[i], n);
        }

        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int newMask = 1 << (c - 'a');
                int change = mask[u] ^ newMask;

                rangeUpdate(tin[u], tout[u], change, n);

                mask[u] = newMask;
                chars[u] = c;
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int ancestor = lca(u, v);

                int prefixU = queryBIT(tin[u]);
                int prefixV = queryBIT(tin[v]);

                int pathMask =
                        prefixU ^ prefixV ^ mask[ancestor];

                answer.add(
                    (pathMask & (pathMask - 1)) == 0
                );
            }
        }

        return answer;
    }
}
