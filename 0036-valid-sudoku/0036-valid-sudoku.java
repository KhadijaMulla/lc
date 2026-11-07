class Solution {
    public boolean isValidSudoku(char[][] board) {

        // For rows
        for(int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();

            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }

                if(set.contains(board[i][j])) {
                    return false;
                }

                set.add(board[i][j]);
            }
        }

        // For columns
        for(int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();

            for(int j = 0; j < 9; j++) {
                if(board[j][i] == '.') {
                    continue;
                }

                if(set.contains(board[j][i])) {
                    return false;
                }

                set.add(board[j][i]);
            }
        }

        // For 3x3 boxes
        for(int row = 0; row < 9; row += 3) {
            for(int col = 0; col < 9; col += 3) {

                HashSet<Character> set = new HashSet<>();

                for(int i = row; i < row + 3; i++) {
                    for(int j = col; j < col + 3; j++) {

                        if(board[i][j] == '.') {
                            continue;
                        }

                        if(set.contains(board[i][j])) {
                            return false;
                        }

                        set.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }
}