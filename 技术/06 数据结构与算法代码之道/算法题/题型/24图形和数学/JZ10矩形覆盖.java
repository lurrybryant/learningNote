// 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
public class Solution {
    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        int ret = 0;
        for (int i = 3; i <= target; i++) {
            ret = f1 + f2;
            f1 = f2;
            f2 = ret;
        }
        return ret;
    }
}
