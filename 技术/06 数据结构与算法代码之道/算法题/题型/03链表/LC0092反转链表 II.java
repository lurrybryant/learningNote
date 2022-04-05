public ListNode reverseBetween(ListNode head, int m, int n) {
 2    //为了方便处理，先创建一个哑节点，让他指向head
 3    ListNode dummy = new ListNode(0);
 4    dummy.next = head;
 5
 6    //记录开始反转节点的前一个节点
 7    ListNode pre = dummy;
 8    for (int i = 0; i < m - 1; i++) {
 9        pre = pre.next;
10    }
11    //记录开始反转的节点，我们把它后面需要反转的的节点
12    //都移动到前面
13    ListNode cur = pre.next;
14
15    //采用头插法，把后面的节点都插入到前面
16    for (int i = 0; i < n - m; i++) {
17        ListNode next = cur.next;
18        cur.next = next.next;
19        next.next = pre.next;
20        pre.next = next;
21    }
22    return dummy.next;
23}