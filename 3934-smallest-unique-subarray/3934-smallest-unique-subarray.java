import java.util.*;

class Solution {
    class State {
        int len, link, occ;
        HashMap<Integer, Integer> next = new HashMap<>();

        State(int len, int link) {
            this.len = len;
            this.link = link;
        }
    }

    State[] st;
    int size, last;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        st = new State[2 * n];
        st[0] = new State(0, -1);
        size = 1;
        last = 0;

        for (int x : nums) {
            add(x);
        }

        // Counting sort states according to len
        int[] cnt = new int[n + 1];

        for (int i = 0; i < size; i++) {
            cnt[st[i].len]++;
        }

        for (int i = 1; i <= n; i++) {
            cnt[i] += cnt[i - 1];
        }

        int[] order = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            order[--cnt[st[i].len]] = i;
        }

        // Propagate occurrence counts from longer states to shorter states
        for (int i = size - 1; i > 0; i--) {
            int v = order[i];
            st[st[v].link].occ += st[v].occ;
        }

        int ans = n;

        for (int i = 1; i < size; i++) {
            if (st[i].occ == 1) {
                ans = Math.min(ans, st[st[i].link].len + 1);
            }
        }

        return ans;
    }

    void add(int x) {
        int cur = size++;
        st[cur] = new State(st[last].len + 1, 0);
        st[cur].occ = 1;

        int p = last;

        while (p != -1 && !st[p].next.containsKey(x)) {
            st[p].next.put(x, cur);
            p = st[p].link;
        }

        if (p == -1) {
            st[cur].link = 0;
        } else {
            int q = st[p].next.get(x);

            if (st[p].len + 1 == st[q].len) {
                st[cur].link = q;
            } else {
                int clone = size++;
                st[clone] = new State(st[p].len + 1, st[q].link);
                st[clone].next.putAll(st[q].next);
                st[clone].occ = 0;

                while (p != -1 && st[p].next.get(x) == q) {
                    st[p].next.put(x, clone);
                    p = st[p].link;
                }

                st[q].link = clone;
                st[cur].link = clone;
            }
        }

        last = cur;
    }
}