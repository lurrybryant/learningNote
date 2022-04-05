public int mySqrt(int x) {
 2    if (x == 0)
 3        return 0;
 4    int left = 1, right = Integer.MAX_VALUE;
 5    while (true) {
 6        int mid = left + (right - left) / 2;
 7        if (mid > x / mid) {
 8            right = mid - 1;
 9        } else {
10            if (mid + 1 > x / (mid + 1))
11                return mid;
12            left = mid + 1;
13        }
14    }
15}


public int mySqrt(int x) {
2    long r = x;
3    while (r * r > x)
4        r = (r + x / r) >> 1;
5    return (int) r;
6} }