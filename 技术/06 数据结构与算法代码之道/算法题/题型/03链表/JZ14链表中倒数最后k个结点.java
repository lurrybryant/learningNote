
// 输入一个链表，输出该链表中倒数第k个结点。
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode front = head;
        int i = 0;
        for ( ; front != null && i < k; i++) {
            front = front.next;
        }
        if (i != k) {
            return null;
        }
        ListNode behind = head;
        while (front != null) {
            behind = behind.next;
            front = front.next; 
        }
        return behind;
    }
}