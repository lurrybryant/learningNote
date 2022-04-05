public static void merge(int[] nums1, int m, int[] nums2, int n) {
 2    int temp[] = new int[m + n];
 3    int index = 0;
 4    int i = 0;
 5    int j = 0;
 6    while (i < m && j < n) {
 7        if (nums1[i] <= nums2[j])
 8            temp[index++] = nums1[i++];
 9        else
10            temp[index++] = nums2[j++];
11    }
12    for (; i < m; ) {
13        temp[index++] = nums1[i++];
14    }
15    for (; j < n; ) {
16        temp[index++] = nums2[j++];
17    }
18    for (int k = 0; k <m + n ; k++) {
19        nums1[k]=temp[k];
20    }
21}


public void merge(int[] nums1, int m, int[] nums2, int n) {
2    int i = m - 1, j = n - 1, tar = m + n - 1;
3    while (j >= 0) {
4        nums1[tar--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
5    }
6}