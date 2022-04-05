public int[] dailyTemperatures(int[] T) {
 2    Stack<Integer> stack = new Stack<>();
 3    int[] ret = new int[T.length];
 4    for (int i = 0; i < T.length; i++) {
 5        while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
 6            int idx = stack.pop();
 7            ret[idx] = i - idx;
 8        }
 9        stack.push(i);
10    }
11    return ret;
12}