// 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int[] array = new int[index];
        int begin = 0;
        int begin2 = 0;
        int begin3 = 0;
        int begin5 = 0;
        int min = 0;
        array[begin] = 1;
        while (begin < index - 1) {
            min = 2 * array[begin2];
            if (3 * array[begin3] < min) {
                min = 3 * array[begin3];
            }
            if (5 * array[begin5] < min) {
                min = 5 * array[begin5];
            }
            begin++;
            array[begin] = min;
            while (2 * array[begin2] <= min) {
                begin2++;
            }
             while (3 * array[begin3] <= min) {
                begin3++;
            }
             while (5 * array[begin5] <= min) {
                begin5++;
            }
        }
        return array[index - 1];
    }
}

