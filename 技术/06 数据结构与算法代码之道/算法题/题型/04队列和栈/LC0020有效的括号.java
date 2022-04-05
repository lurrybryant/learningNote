public boolean isValid(String s) {
 2    Stack<Character> stack = new Stack<>();
 3    char[] chars = s.toCharArray();
 4    //遍历所有的元素
 5    for (char c : chars) {
 6        //如果是左括号，就把他们对应的右括号压栈
 7        if (c == '(') {
 8            stack.push(')');
 9        } else if (c == '{') {
10            stack.push('}');
11        } else if (c == '[') {
12            stack.push(']');
13        } else if (stack.isEmpty() || stack.pop() != c) {
14            //否则就只能是右括号。
15            //1，如果栈为空，说明括号无法匹配。
16            //2，如果栈不为空，栈顶元素就要出栈，和这个右括号比较。
17            //如果栈顶元素不等于这个右括号，说明无法匹配，
18            //直接返回false。
19            return false;
20        }
21    }
22    //最后如果栈为空，说明完全匹配，是有效的括号。
23    //否则不完全匹配，就不是有效的括号
24    return stack.isEmpty();
25}