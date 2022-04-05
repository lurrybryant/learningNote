





// JZ51 构建乘积数组
// 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
// 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。

import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        if (A == null) {
            return null;
        }
        if (A.length == 1) {
            return A;
        }
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        int[] D = new int[A.length];
        C[0] = 1;
        D[0] = 1;
        for (int i = 0; i < A.length; i++) {
            if (i > 0) {
                C[i] = C[i-1] * A[i-1];
                D[i] = D[i-1] * A[A.length - i];
            }
            
        }
        for (int i = 0; i < A.length; i++) {
            B[i] = C[i] * D[A.length - 1 - i];
        }
        return B;

    }
}







