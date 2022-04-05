class LRUCache1 {
 2    class DLinkedNode {
 3        int key;
 4        int value;
 5        DLinkedNode pre;
 6        DLinkedNode post;
 7    }
 8
 9    private void addNode(DLinkedNode node) {
10        node.pre = head;
11        node.post = head.post;
12        head.post.pre = node;
13        head.post = node;
14    }
15
16    private void removeNode(DLinkedNode node) {
17        DLinkedNode pre = node.pre;
18        DLinkedNode post = node.post;
19        pre.post = post;
20        post.pre = pre;
21    }
22
23    private void moveToHead(DLinkedNode node) {
24        this.removeNode(node);
25        this.addNode(node);
26    }
27
28    private DLinkedNode popTail() {
29        DLinkedNode res = tail.pre;
30        this.removeNode(res);
31        return res;
32    }
33
34    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
35    private int count;
36    private int capacity;
37    private DLinkedNode head, tail;
38
39    public LRUCache1(int capacity) {
40        this.count = 0;
41        this.capacity = capacity;
42        head = new DLinkedNode();
43        head.pre = null;
44        tail = new DLinkedNode();
45        tail.post = null;
46        head.post = tail;
47        tail.pre = head;
48    }
49
50    public int get(int key) {
51        DLinkedNode node = cache.get(key);
52        if (node == null) {
53            return -1;
54        }
55        this.moveToHead(node);
56        return node.value;
57    }
58
59    public void put(int key, int value) {
60        DLinkedNode node = cache.get(key);
61        if (node == null) {
62            DLinkedNode newNode = new DLinkedNode();
63            newNode.key = key;
64            newNode.value = value;
65            this.cache.put(key, newNode);
66            this.addNode(newNode);
67            ++count;
68            if (count > capacity) {
69                DLinkedNode tail = this.popTail();
70                this.cache.remove(tail.key);
71                --count;
72            }
73        } else {
74            node.value = value;
75            this.moveToHead(node);
76        }
77    }
78}