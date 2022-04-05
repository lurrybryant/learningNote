public int numIslands(char[][] grid) {
 2    //边界条件判断
 3    if (grid == null || grid.length == 0)
 4        return 0;
 5    //统计岛屿的个数
 6    int count = 0;
 7    //两个for循环遍历每一个格子
 8    for (int i = 0; i < grid.length; i++)
 9        for (int j = 0; j < grid[0].length; j++) {
10            //只有当前格子是1才开始计算
11            if (grid[i][j] == '1') {
12                //如果当前格子是1，岛屿的数量加1
13                count++;
14                //然后通过dfs把当前格子的上下左右4
15                //个位置为1的都要置为0，因为他们是连着
16                //一起的算一个岛屿，
17                dfs(grid, i, j);
18            }
19        }
20    //最后返回岛屿的数量
21    return count;
22}
23
24//这个方法会把当前格子以及他邻近的为1的格子都会置为1
25public void dfs(char[][] grid, int i, int j) {
26    //边界条件判断，不能越界
27    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
28        return;
29    //把当前格子置为0，然后再从他的上下左右4个方向继续遍历
30    grid[i][j] = '0';
31    dfs(grid, i - 1, j);//上
32    dfs(grid, i + 1, j);//下
33    dfs(grid, i, j + 1);//左
34    dfs(grid, i, j - 1);//右
35}

