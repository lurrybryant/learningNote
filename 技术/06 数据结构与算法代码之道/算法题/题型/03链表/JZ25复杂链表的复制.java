

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














