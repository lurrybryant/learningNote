// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
// 不用临时数组 ？ 交换；不改变相对位置；
public class Solution {
    public void reOrderArray(int [] array) {
        int[] newArr = new int[array.length];  
        //newArr的下标计数器  
        int j = 0;  
        for (int i = 0; i < array.length; i++)  
            if ((array[i] & 1) == 1) {  
                newArr[j] = array[i];  
                j++;  
            }  
        for (int i = 0; i < array.length; i++)  
            if ((array[i] & 1) == 0) {  
                newArr[j] = array[i];  
                j++;  
            }  
        for (int i = 0; i < array.length; i++)  
            array[i] = newArr[i];  
    }
}

public class Tiaozheng {
    public static void reOrderArray(int [] array) {
         int j=0;//存放下标
         int m=0;//记录已排好的奇数的下标
         for(int i=0;i<array.length;i++)//遍历
         {    
             if(array[i]%2==1)//找到第一个奇数
             {
                 int temp = array[i];//存放数据
                 int ii=i;
                 j=i;
                 for(;ii>0;ii--)
                 {
                     array[ii]=array[ii-1];//将第一个奇数之前的所有元素往后移一个位置
                 }
                 array[0] = temp;
                 break;
             }
         }
         for(j=j+1;j<array.length;j++)//遍历寻找剩余的奇数
         {
             if(array[j]%2==1)
             {
                 int temp = array[j];
                 int jj = j;
                 for(;jj>m;jj--)
                 {
                     array[jj]=array[jj-1];
                 }
                 array[++m]=temp;//每找到一个奇数，m+1
             }
         }
         System.out.println(Arrays.toString(array));  
     }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int []a=new int [10];
        System.out.println("输入一个长度为10的数组：");
        for(int i=0;i<10;i++) {
            a[i]=s.nextInt();
        }
        reOrderArray(a);
    }

}
