public boolean exist(char[][] board, String word) {
 2    char[] wordArray = word.toCharArray();
 3    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
 4    for (int i = 0; i < board.length; i++) {
 5        for (int j = 0; j < board[0].length; j++) {
 6            if (dfs(board, dirs, i, j, wordArray, 0))
 7                return true;
 8        }
 9    }
10    return false;
11}
12
13public boolean dfs(char[][] board, int[][] dirs, int i, int j, char[] word, int start) {
14    if (start == word.length)
15        return true;
16    if (i < 0 || j < 0 || i == board.length || j == board[0].length)
17        return false;
18    if (board[i][j] == '#' || board[i][j] != word[start])
19        return false;
20    boolean res = false;
21    char c = board[i][j];
22    board[i][j] = '#';
23    for (int[] dir : dirs) {
24        int newRow = i + dir[0], newCol = j + dir[1];
25        res |= dfs(board, dirs, newRow, newCol, word, start + 1);
26        if (res)
27            return true;
28    }
29    board[i][j] = c;            
30    return false;
31}