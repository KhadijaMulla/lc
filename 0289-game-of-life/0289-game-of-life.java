class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] directions = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},           {0,1},
            {1,-1},  {1,0},   {1,1}
        };

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                int count = 0;

                for(int[] d : directions) {
                    int r = i + d[0];
                    int c = j + d[1];

                    if(r >= 0 && r < m && c >= 0 && c < n) {
                        if(board[r][c] == 1 || board[r][c] == 2) {
                            count++;
                        }
                    }
                }

                if(board[i][j] == 1) {
                    if(count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                }
                else {
                    if(count == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}