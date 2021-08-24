package SW;

public class MergeSort {

	public static int[] src;
	public static int[] tmp;

	public static void main(String[] args) {
		src = new int[] { 1, 9, 8, 5, 4, 2, 3, 7, 6 };
		tmp = new int[src.length];
		printArray(src);
		mergeSort(0, src.length - 1);
		printArray(src);

	}

	private static void mergeSort(int start, int end) {
		if (end - start < 1)
			return;

		int mid = (start + end) / 2;
		mergeSort(start, mid);
		mergeSort(mid+1, end);
		merge(start,mid,end);

	}

	private static void merge(int start, int mid, int end) {
		
		int index = start;
		int l = start;
		int h = mid+1;
		
		while(l <= mid && h <= end) {
			if(src[l] > src[h])
				tmp[index++] = src[h++];
			else
				tmp[index++] = src[l++];
		}
		
		while(h <= end) {
			tmp[index++] = src[h++];
		}
		
		while(l <= mid) {
			tmp[index++] = src[l++];
		}
		
		for (int i = start; i <= end; i++) {
			src[i] = tmp[i];
		}
		
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

}
