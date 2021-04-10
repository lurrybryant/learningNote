public class Suanfa2 {
	/*
一、十大排序算法；

	稳定排序有：插入；冒泡；归并；基数；
	时间复杂度，空间复杂度；

	排序：假设entry为非空数组：计数排序；堆排序，基数排序，希尔排序；外部排序（多路归并排序）
	*/
	public void bubbleSort(int[] a) {	//flag改进	
        int temp=0;  
        for(int i=0;i<a.length-1;i++){  
	        for(int j=0;j<a.length-1-i;j++){  
		        if(a[j]>a[j+1]){  
		            temp=a[j];  
		            a[j]=a[j+1];  
		            a[j+1]=temp;  
		        }  
		    }
        }      
	}
	
	public void insertSort(int[] entry) {
		int len = entry.length;
		for (int i = 1; i < len; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (entry[i] < entry[j]) {
					entry[j + 1] = entry[j];
				} else {
					break;
				}
			}
			entry[j] = entry[i];
		}
	}
	public void selectSort(int[] entry) {
		int len = entry.length;
		for (int i = 0; i < len - 1; i++) {
			int indexOfMin = i + 1;
			for (int j = i + 1; j < len; j++) {
				if (entry[j] < entry[indexOfMin]) {
					indexOfMin = j;
				}
			}
			if (entry[indexOfMin] < entry[i]) {
				entry[indexOfMin] <==> entry[i]
			}
		}
	}
	public void mergeSort(int[] entry, int start, int end) {
		if (start > end) {
			return;
		} else {
			int mid = (start + end) / 2;
			mergeSort(entry, start, mid);
			mergeSort(entry, mid + 1, end);
			merge(entry, start, mid, end);
		}
	}
	private void merge(int[] entry, start, mid, end) {
		int[] temp = new int[end-start+1]; 
		int leftStart = start;
		int leftEnd = mid;
		int rightStart = mid + 1;
		int rightEnd = end;
		int index = start;
		int copyIndex = start;
		while (leftStart <= leftEnd && rightStart <= rightEnd) {
			if (entry[leftStart] < entry[rightStart]) {
				temp[index++] = entry[leftStart++];
			} else {
				temp[index++] = entry[rightStart++];
			}
		}
		while (leftStart <= leftEnd) {
			temp[index++] = entry[leftStart++];
		}
		while (rightStart <= rightEnd) {
			temp[index++] = entry[rightStart++];
		}
		while (copyIndex < end) {
			entry[copyIndex] = temp[copyIndex];
			copyIndex++;
		}
	}
	public void quickSort(int[] entry, int start, int end) {
		if (start > end) {
			return;	
		}
		int j = partition(entry, start, end);
		quickSort(entry, start, j - 1);
		quickSort(entry, j + 1, end);
	}
    private int partition(int[] entry, int start, int end) {
		int p = start;
		for (int q = start; q <= end; q++) {
			if (entry[q] < entry[end]) {
				entry[q] <==> entry[p];
		        p++;
			}
		}
		entry[p] <==> entry[end];
		return p;
	}
	/*
二、七大查找（静态查找：线性表结构；动态查找：二叉搜索树，哈希表）
     线性顺序查找；线性索引查找（稠密，分块，倒排）
     块内无序；块间有序；索引存取；索引表；
	*/
	public boolean contains(int[] entry, int element) {
		if (entry == null || entry.length == 0) {
			return false;
		}
		for (int i = 0; i < entry.length; i++) {
			if (entry[i] == element) {
				return true;
			}
		}
		return false;
	}
	public boolean contains2(int[] entry, int start, int end, int element) {
		if (entry == null || entry.length == 0 || start < 0 || end >= entry.length || start > end) {
			return false;
		}
		if (entry[start] == element) {
			return true;
		} else {
			return contains2(entry, start + 1, end, element);
		}
	}

	public boolean binarySearch(int[] entry, int start, int end, int element) {
		if (entry == null || entry.length == 0 || start < 0 || end >= entry.length || start > end) {
			return false;
		}
		int mid = (start + end) / 2;
		if (entry[mid] == element) {
			return true;
		} else if (entry[mid] > element){
			return binarySearch(entry, start, mid - 1, element);
		} else {
			return binarySearch(entry, mid +1, end, element);
		}
	}
	public boolean binarySearch(int[] entry, int start, int end, int element) {
		if (entry == null || entry.length == 0 || start < 0 || end >= entry.length || start > end) {
			return false;
		}
		while (start <= end) {
			int mid = (start + end) / 2;
			if (entry[mid] == element) {
				return true;
			} else if (entry[mid] > element) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

}



