public boolean hasCycle(ListNode head) {
 2    if (head == null)
 3        return false;
 4    //快慢两个指针
 5    ListNode slow = head;
 6    ListNode fast = head;
 7    while (fast != null && fast.next != null) {
 8        //慢指针每次走一步
 9        slow = slow.next;
10        //快指针每次走两步
11        fast = fast.next.next;
12        //如果相遇，说明有环，直接返回true
13        if (slow == fast)
14            return true;
15    }
16    //否则就是没环
17    return false;
18}
