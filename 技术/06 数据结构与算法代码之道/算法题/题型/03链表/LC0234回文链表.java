public boolean isPalindrome(ListNode head) {
 2    ListNode temp = head;
 3    Stack<Integer> stack = new Stack();
 4    //把链表节点的值存放到栈中
 5    while (temp != null) {
 6        stack.push(temp.val);
 7        temp = temp.next;
 8    }
 9
10    //然后再出栈
11    while (head != null) {
12        if (head.val != stack.pop()) {
13            return false;
14        }
15        head = head.next;
16    }
17    return true;
18}