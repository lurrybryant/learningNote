

// JZ55 链表中环的入口结点
// 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode p = pHead;
        ListNode q = pHead;
        do {
            p = p.next;
            if (q.next == null) {
                return null;
            }
            q = q.next.next;
            if (q == null) {
                return null;
            }
        } while (p != q);
        int number = 0;
        do {
            p = p.next;
            number++;
        } while (p != q);
        p = pHead;
        q = pHead;
        for (int i = 0; i < number; i++) {
            q = q.next;
        }
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}