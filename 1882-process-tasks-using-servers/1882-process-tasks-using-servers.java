class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        PriorityQueue<Integer> free = new PriorityQueue<>((a,b) -> {
            if(servers[a] != servers[b]){
                return Integer.compare(servers[a], servers[b]);
            }
            return Integer.compare(a,b);
        });

        PriorityQueue<long[]> busy = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]){
                return Long.compare(a[0], b[0]);
            }
            return Long.compare(a[1], b[1]);
        });

        for(int i = 0; i < n; i++){
            free.offer(i);
        }

        long time = 0;

        for(int i = 0; i < m; i++){

            time = Math.max(time, i);

            while(!busy.isEmpty() && busy.peek()[0] <= time){
                free.offer((int)busy.poll()[1]);
            }

            if(free.isEmpty()){
                time = busy.peek()[0];

                while(!busy.isEmpty() && busy.peek()[0] <= time){
                    free.offer((int)busy.poll()[1]);
                }
            }

            int server = free.poll();

            ans[i] = server;

            busy.offer(new long[]{time + tasks[i], server});
        }

        return ans;
    }
}