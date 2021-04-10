// 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        List<Integer> array = new ArrayList<Integer>();
        print(array, listNode);
        return (ArrayList<Integer>)array;
    }
    
    public void print(List<Integer> arr, ListNode listNode) {
        if (listNode == null) {
            return;
        } else if (listNode.next == null) {
            arr.add(listNode.val) ;
        } else {
            print(arr, listNode.next);
            arr.add(listNode.val);
        }
    }
}
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.*;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}


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

// 输入一个链表，反转链表后，输出新链表的表头。
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}


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

// 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
    if (pHead == null)  
        return null;  
    RandomListNode pCur = pHead;  
    // 复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'  
    while (pCur != null) {  
        RandomListNode node = new RandomListNode(pCur.label);  
        node.next = pCur.next;  
        pCur.next = node;  
        pCur = node.next;  
    }  
    pCur = pHead;  
    // 复制random pCur是原来链表的结点 pCur.next是复制pCur的结点  
    while (pCur != null) {  
        if (pCur.random != null)  
            pCur.next.random = pCur.random.next;  
        pCur = pCur.next.next;  
    }  
    RandomListNode pCloneHead = null;  
    RandomListNode pCloneNode = null;  
    pCur = pHead;  
    // 初始化，让pcur指向pCloneNode的下一个结点,避免空指针  
    if (pCur != null) {  
        pCloneHead = pCloneNode = pCur.next;  
        pCur.next = pCloneNode.next;  
        pCur = pCur.next;  
        // pCur = pCloneNode.next;  
    }  
    while (pCur != null) {  
        pCloneNode.next = pCur.next;  
        pCloneNode = pCloneNode.next;  
        pCur.next = pCloneNode.next;  
        pCur = pCur.next;  
    }  
    return pCloneHead;  
    }  
}










