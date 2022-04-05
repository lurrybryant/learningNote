// 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
                
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}



/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode lists1 = list1;
        ListNode lists2 = list2;
        ListNode list = null;
        ListNode current = null;
        int min;
        if (list1 != null && list2 == null) {
            return list1;
        } 
        if (list1 == null && list2 != null) {
            return list2;
        }
        while (lists1 != null && lists2 != null) {
            if (lists1.val < lists2.val) {
                min = lists1.val;
                lists1 = lists1.next;
            } else {
                min = lists2.val;
                lists2 = lists2.next;
            }
            ListNode node = new ListNode(min);
            if (list == null) {
                list = node;      
            } else {
                current.next = node;
            } 
            current = node;
               
        }
        if (lists1 != null) {
            current.next = lists1;
        }
        if (lists2 != null) {
            current.next = lists2;
        }
        return list;
    }
}