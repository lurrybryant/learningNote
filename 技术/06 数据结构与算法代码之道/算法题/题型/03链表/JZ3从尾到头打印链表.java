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




