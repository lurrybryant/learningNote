public class SuanFa {
	/*
一、数据结构：

    位运算：n = (n - 1) & n:最后一位1变为0
            右移运算符代替除以2；
            用位与代替判断奇偶数；

	数组：顺序存储 随机存取 堆内存上创建数组
	      栈内存中保存了引用地址；堆内存中保存了具体内容；
	      三对角矩阵

	字符串：BF算法（普通匹配算法）：时间复杂度O(m*n)；空间复杂度O(1)
            KMP算法：时间复杂度O(m+n)；空间复杂度O(n)；next数组是什么？
            字符串从后往前复制；

	链表：链式存储 顺序存取 
	      单向 双向 循环 复杂链表；
	      链表双指针
	      链表头指针前弄一个指针
	
	队列：广度优先
	      双端队列、优先队列：

	栈：递归问题

	哈希表，字典：散列存取; 散列技术：如何存储和查找；
		（1）选择一个Hash函数，使得每个键字能有一个唯一的地址（散列地址，存储位置）；要求计算简单；分布均匀
			0直接定址法
			①数字分析法                                      
			②平方取中法                                      
			③分段叠加法                                       
			④除留取余法
          要考虑：
	         关键字的分布；
	         关键字的长度；
	         散列表的大小；
	         哈希函数计算量；

        （2）当不同键字具有相同的地址，此时选择一种冲突处理方法至关重要：
			①开放地址法（包括线性探测法、平方探测法、随机探测法）
			②再散列法
			③链地址法 
			④公共溢出区

	迭代器：

	树（二叉树，平衡查找树，二叉查找树，trie树，哈希树，2-3树，2-4树，红黑树，B树，B+树, B*树，B-树）；
	    森林 普通树 二叉树转换过程；
		查找树中序遍历是排序的；
		树的路径长度是从树根到树中每一结点的路径长度之和
		哈夫曼树的路径长度

	堆（最大，最小）：堆排序的时间复杂度为nlogn,构建堆的时间复杂度为o(n),重建堆的时间复杂度为nlogn；
	    初始堆的建立，reheap()过程；

	图：两个存储：邻接矩阵（无向图，有向图，网），邻接表存储（无向图，有向图，网），
	      补：十字链表，邻接多重表，边集数组
	    深度优先， 
	    无权图最短路径（广度优先），
	    带权最短路径（dijkstra, floyd）
	    ******************************
	    关键路径，
	    最小生成树（prim kruscal），
	    拓扑排序：邻接矩阵存储O(n^3)，邻接表O(n+e)

二、java重要接口和类
    
    Integer：parseInt(), parseDouble()
    Scanner：nextLine() next() 
    String：split("正则化"), trim(), length(), charAt(i)，toCharArray(),substring, replace
            new String(charArray)
    Array：sort()
    StringBuilder，StringBuffer：

	Collection接口：
		add(e) addAll(s); 
		remove(e) removeAll(s); 
		contains(e) containsAll(s);
		clear() isEmpty() size();
		hashCode() equals(e);
		iterator() toArray();
	List接口：
		add(i, e) addAll(i, s);
		remove(i) set(i, e);
		subList(i, j);
		indexOf(e) lastIndexOf(e) get(i);
		listIterator();
	Queue接口：
		offer(e) poll() peek()
	Deque接口：
	Set接口：
		HashSet:无序
		LinkedHashSet：可以记住插入顺序
		TreeSet:有序
	Sorted接口：
	Map接口：
		put(k, v) putAll(map);
		containsKey(k) containsValue(v);
		get(k) remove(k) entrySet() keySet() values();
		isEmpty() size() clear();
	Map.Entry内部类：
			getKey() getValue() setValue()
	SortedMap接口：


	Iterator, ListIterator:双向迭代输出；只能通过List接口实例化, Enumeration
		hasNext() next() remove()

	ArrayList类: 
	Vector类：
		可以Enumeration输出：elements()	
	ArrayDeque类：循环数组实现
	PriorityQueue类：允许高效删除最小元素的集合，最小堆
	LinkedList类：
		实现了Queue接口和List接口
		addFirst(e) addLast(e)
		removeFirst() removeLast()
	Stack类继承自Vector
		push(e) pop() empty() peek() search(e)
	HashMap类:
	HashTable:旧的类
	TreeMap: 排序
	LinkedHashMap:可以记住键值项顺序
	WeakHashMap:
	IdentityHashMap:

	
字典树
双指针
优先队列
高级结构
有序表
线性表

模拟
复杂度
高级算法
思维
数学
逆元
快速幂
矩阵快速幂
欧拉函数
二分
前缀和
三分
拓扑排序
后缀数组
语法题
并查集
计算几何



三、数据结构典型代码

*/
	//链表：指定位置插入节点
	class Node {
		int val;
		Node next;
	}
	插入：s.next = p.next; p.next = s;
	删除：p = p.next.next;
	反转：
	双链表：插入 s.next = p.next; p.next.prior = s; p.next = s; s.prior = p;
	        删除 p.prior.next = p.next; p.next.prior = p.prior;
	        反转：

	public Node add(Node pHead, int index , Node pNode) {
		if (pHead == null || index == 1) {
			pNode.next = pHead;
			return pNode;
		} 
		Node curNode = pHead;
		for (int i = 0; i < index - 2; i++) {
			curNode = curNode.next;
		}
		Node beforeNode = curNode;
		Node afterNode = curNode.next;
		beforeNode.next = pNode;
		pNode.next = afterNode;
		return pHead;
	}

	public Node remove(Node pHead, int index) {
		if (index == 1) {
			return pHead.next;
		}
		Node curNode = pHead;
		for (int i = 0; i < index - 2; i++) {
			curNode = curNode.next;
		}
		Node afterNode = curNode.next.next;
		curNode.next = afterNode;
		return pHead;
	}

	public boolean contains1(Node pHead, int element) {
		Node curNode = pHead;
		while (curNode != null) {
			if (curNode.val == element) {
				return true;
			}
			curNode = curNode.next;
		}
		return false;
	}

	public boolean contains2(Node pHead, int element) {
		if (pHead == null) {
			return false;
		}
		if (pHead.val == element) {
			return true;
		} else {
			return contains2(pHead.next, element);
		}
	}
	//有序：增序
	public boolean contains3(Node pHead, int element) {
		Node curNode = pHead;
		while (curNode != null) {
			if (curNode.val == element) {
				return true;
			} else if (curNode.val > element) {
				return false;
			}
			curNode = curNode.next;
		}
		return false;
	}

	//树节点
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	//先序遍历
	public ArrayList<Integer> preOrder(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tn = root;
		while (tn !=null || stack.size() > 0) {
			if (tn != null) {
				stack.push(tn);
				ret.add(tn.val);
				tn = tn.left;
			} else {
				tn = stack.pop();
				tn = tn.right;
			}
		}
		return ret;
	}	
	//中序遍历
	public ArrayList<Integer> inOrder(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tn = root;
		while (tn !=null || stack.size() > 0) {
			if (tn != null) {
				stack.push(tn);
				tn = tn.left;
			} else {
				tn = stack.pop();		
				ret.add(tn.val);
				tn = tn.right;
			}
		}
		return ret;
	}
	//后序遍历
	public ArrayList<Integer> postOrder(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> output = new Stack<TreeNode>();
		TreeNode tn = root;
		while (tn !=null || stack.size() > 0) {
			if (tn != null) {
				output.push(tn);
				stack.push(tn);
				tn = tn.right;
			} else {
				tn = stack.pop();
				tn = tn.left;
			}
		}
		while (output.size() > 0) {
			ret.add(output.pop().val);
		}
		return ret;
	}
	//层次遍历
	public ArrayList<Integer> levelOrder(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (queue.size() > 0) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				TreeNode  temp = queue.poll();
				ret.add(temp.val);
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			}
		}		
		return ret;
	}	

	//	广度优先遍历
	getBreadthFirstTraversal(originVertex) {
		vertexQueue = 存放邻接点的新队列；
		traversalOrder = 存放得到的遍历顺序的新队列；

		将originVertex标记为已访问；
		traversalOrder.offer(originVertex);
		vertexQueue.offer(originVertex);
		while (vertexQueue.size() > 0) {
			frontVertex = vertexQueue.poll();
			while (frontVertex有一个未访问邻接点) {
				nextNeighbor = frontVertex的下一个未访问的邻接点；
				将nextNeighbor标记为已访问；
				traversalOrder.offer(nextNeighbor);
				vertexQueue.offer(nextNeighbor);
			}
		}
		return traversalOrder;
	}
	//深度优先遍历
	getDepthFirstTraversal(originVertex) {
		vertexStack = 存放已访问订点的新栈；
		traversalOrder = 存放得到的遍历顺序的新队列；

		将originVertex标记为已访问；
		traversalOrder.offer(originVertex);
		vertexStack.push(originVertex);
		while (!vertexStack.empty()) {
			topVertex = vertexStack.peek();

			if (topVertex有一个未访问的邻接点) {
				nextNeighbor = topVertex的下一个未访问的邻接点；
				标记nextNeighbor为已访问;
				traversalOrder.offer(nextNeighbor);
				vertexStack.push(nextNeighbor);
			} else {
				vertexStack.pop();
			}
		}
		return traversalOrder;
	}


}