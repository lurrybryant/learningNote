// JZ45 扑克牌顺子
// 现在有2副扑克牌，从扑克牌中随机五张扑克牌，我们需要来判断一下是不是顺子。
// 有如下规则：
// 1. A为1，J为11，Q为12，K为13，A不能视为14
// 2. 大、小王为 0，0可以看作任意牌
// 3. 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
// 例如：给出数据[6,0,2,0,4]
// 中间的两个0一个看作3，一个看作5 。即：[6,3,2,5,4]
// 这样这五张牌在[2,6]区间连续，输出true
// 数据保证每组5个数字，每组最多含有4个零，数组的数取值为 [0, 13]
import java.util.Arrays;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        boolean flag = true;
        int c = 0;
        for (int i = 0; i < 5; i++) {
            if (!flag) {
                if (numbers[i-1] == numbers[i]) {
                    return false;
                }
            }
            if (flag && numbers[i] != 0) {
                c = i;
                flag = false;
            }
        }
        if (0 >= numbers[4] - numbers[c] + 1 -5) {
            return true;
        } else {
            return false;
        }
    }
}