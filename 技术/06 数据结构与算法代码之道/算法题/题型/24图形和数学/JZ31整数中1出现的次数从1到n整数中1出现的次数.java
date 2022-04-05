
// 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        if (n > 0 && n < 10) {
            return 1;
        }
        int num = n;
        int base = 1;
        int digit = 0;
        do {
            num /= 10; 
            base *= 10;
            digit++;
        } while (num > 9);
        int other = n - num * base;
        int numFirstDigit = 0;
        if (num > 1) {
            numFirstDigit = base;
        } else {
            numFirstDigit = other + 1;
        }
        int numOtherDigits = num * digit * base / 10;
        int recursiveDigit = NumberOf1Between1AndN_Solution(other);
        return numOtherDigits + numFirstDigit + recursiveDigit;
    }
}
