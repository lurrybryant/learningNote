/*
基础知识扎实；鲁棒性的代码；思路清晰（画图举例分解）；优化（分析数据结构优缺点各种算法熟悉）；
沟通需求请求提示迁移能力抽象建模发散思维；
边界条件；特殊输入；空指针；错误输入处理；
先自己心里默默运行；
是否允许或者必须在输入数据上修改
递归栈溢出，因此显示栈更鲁邦；
使用全局变量作为成员变量
各种算法平均时间复杂度和最差时间复杂度分析；和空间复杂度；
功能测试 边界测试 负面测试
返回值；全局变量；异常：与面试官沟通哪种错误返回。
float，double判断相等；
考虑是不是大数问题

一、常用算法

迭代：
递归：直接或间接调用自身
动态规划：将待求解问题分解为若干子问题，先求解子问题，然后从这些子问题的解得到原问题的解。这些子问题不独立，需要保存已解
   决的子问题的答案，在需要时再找出来，从而避免大量重复计算，得到了多项式时间算法。动态规划用于求解最优问题
   最优子结构性质：
   子问题重叠性质：
   备忘录方法：
回溯：深度优先方式系统搜索问题解，搜索过程用剪枝函数避免无效搜索。搜索整个解空间。
贪心：最优子结构性质：当一个问题的最优解包含其子问题的最优解时。
   自顶向下，以迭代的方式做出相继的贪心选择。贪心选择性质：所求问题的最优解可以通过一系列
   局部最优选择达到。
分治：将难以解决的大问题分割成较小规模的问题，这些问题相互独立且与原问题相同。然后各个击破，分而治之，并将子问题的解合并
   得到原问题的解
分支限界：以广度优先方式搜索解空间树。解决离散化最优问题
查找：
排序：

二、算法题重要代码段
*/
package com.suanFa.oj;

import java.util.Scanner;  
import java.util.TreeSet;  
  
public class Lcs {  
      
    public StringBuffer X;  
    public StringBuffer Y;  
    public static int m;  
    public static int n;  
    public int len;  
    public static int[][] b;  
    public int[][] c;  
    public String[] Log;  
    public char[] lcs;  
    public final int MAX = 100;  
    public int CurLen;  
      
    public static void main(String[] args) {  
        Lcs lcs = new Lcs();  
        lcs.search();  
          
    }  
    public void search() {  
        while(true) {  
            System.out.println("\n" + "请选择功能:");  
            System.out.println("\n" + "1.寻找最长公共子序列");  
            System.out.println("\n" + "2.结束");  
            Scanner in = new Scanner(System.in);  
            int choose = in.nextInt();  
            switch(choose) {  
              
            case 1:  
                System.out.println("请输入序列X:");  
                X = new StringBuffer(in.next());  
                System.out.println("请输入序列Y:");  
                Y = new StringBuffer(in.next());  
                lcs_length();  
                System.out.println("两序列的最长公共子序列为:");  
                storeLCS(m,n,len);  
                PrintLCS();  
                X.setLength(0);  
                Y.setLength(0);  
                break;  
            case 2:  
                in.close();  
                System.exit(0);  
                break;  
            default:  
                in.close();  
                System.exit(-1);  
            }  
              
              
        }  
    }  
    public void lcs_length() {  
        m = X.length();  
        n = Y.length();  
        c = new int[m+1][n+1];  
        b = new int[m+1][n+1];  
        for(int i = 1; i <= m; i++) c[i][0] = 0;  
        for(int j = 0; j <= n; j++) c[0][j] = 0;  
        for(int i = 1; i <= m; i++)  
            for(int j = 1; j <= n; j++) {  
                if(X.charAt(i-1) == Y.charAt(j-1)){  
                    c[i][j] = c[i-1][j-1] + 1;  
                    b[i][j] = 0;  
                } else if(c[i-1][j] > c[i][j-1]) {  
                    c[i][j] = c[i-1][j];  
                    b[i][j] = 1;  
                } else if(c[i-1][j] == c[i][j-1]){  
                    c[i][j] = c[i-1][j];  
                    b[i][j] = 2;  
                }else {  
                    c[i][j] = c[i][j-1];  
                    b[i][j] = 3;  
                }  
            }  
        lcs = new char[m+1];  
        len = c[m][n];  
        Log = new String[MAX];  
        CurLen = 0;  
    }  
    public void storeLCS(int m,int n,int Len) {  
        if(m == 0 || n == 0) {  
            Log[CurLen] = new String(lcs);    
            CurLen++;  
        } else {  
            if(b[m][n] == 0) {  
                lcs[Len] = X.charAt(m-1);  
                Len--;  
                storeLCS(m-1,n-1,Len);  
            } else if(b[m][n] == 3) {  
                storeLCS(m,n-1,Len);  
            } else if(b[m][n] == 1) {  
                storeLCS(m-1,n,Len);  
            } else {  
                storeLCS(m,n-1,Len);  
                storeLCS(m-1,n,Len);  
            }  
        }  
          
    }  
    public void PrintLCS() {  
        TreeSet<String> tr = new TreeSet<String>();  
        for(int i = 0; i < CurLen; i++) {  
            tr.add(Log[i]);  
        }  
        String[] s2= new String[tr.size()];  
        for(int i = 0; i < s2.length; i++) {  
             s2[i]=tr.pollFirst();//从TreeSet中取出元素重新赋给数组  
             System.out.println(s2[i]);  
        }  
    }  
}  


public class Solution {

	
}