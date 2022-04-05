
// JZ56 删除链表中重复的结点
// 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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
    public ListNode deleteDuplication(ListNode pHead)
    {   if (pHead == null) {
        return null;
    }
     int headValue = -1;
     if (headValue == pHead.val) {
         headValue = -2;
     }
     ListNode head = new ListNode(headValue);
     head.next = pHead;
     ListNode p = head;
     ListNode q = pHead;
     while (q != null) {
         while (q.next != null && q.val == q.next.val) {
             q = q.next;
         }
         if (p.next != q) {
             q = q.next;
             p.next = q;
         } else {
             p = q;
             q = q.next;
         }
         
     }
     return head.next;

    }
}
