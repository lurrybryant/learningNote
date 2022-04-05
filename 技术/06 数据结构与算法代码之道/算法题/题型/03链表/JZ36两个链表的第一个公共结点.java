

// JZ36 两个链表的第一个公共结点
// 输入两个无环的单链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        int pNum1 = 0;
        ListNode p2 = pHead2;
        int pNum2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            pNum1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            pNum2++;
        }
        p1 = pHead1;
        p2 = pHead2;
        if (pNum1 > pNum2) {
            for (int i = 0; i < pNum1 - pNum2; i++) {
                p1 = p1.next;
            }
        } else if (pNum1 < pNum2) {
            for (int i = 0; i < pNum2 - pNum1; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
