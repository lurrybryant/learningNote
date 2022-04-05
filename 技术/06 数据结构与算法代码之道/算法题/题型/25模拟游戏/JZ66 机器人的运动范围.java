


JZ66 机器人的运动范围
import java.util.Stack;  

public class Solution {  

     public int movingCount(int threshold, int rows, int cols) {

        // 创建一个数组记录一个格子是否被访问

        boolean[][] visited = new boolean[rows][cols];

        return movingCountCore(threshold, rows, cols, 0, 0, visited);

    }
    private int movingCountCore(int threshold, int rows, int cols, int i,int j, boolean[][] visited) {

        int count = 0;

        // 异常处理

        if (i < 0 || i >= rows || j < 0 || j >= cols

                || numberIndexCount(i) + numberIndexCount(j) > threshold

                || visited[i][j])

            return 0;

        visited[i][j] = true;

        count = 1 + movingCountCore(threshold, rows, cols, i - 1, j, visited)

                  + movingCountCore(threshold, rows, cols, i + 1, j, visited)

                  + movingCountCore(threshold, rows, cols, i, j - 1, visited)

                  + movingCountCore(threshold, rows, cols, i, j + 1, visited);

        return count;

    }

    // 用于计算每个坐标的数位之和

    private int numberIndexCount(int number) {

        int sum = 0;

        while (number > 0) {

            sum += number % 10;

            number /= 10;

        }

        return sum;

    }

}

    
