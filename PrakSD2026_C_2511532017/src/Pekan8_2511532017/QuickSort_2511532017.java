package Pekan8_2511532017;

public class QuickSort_2511532017 {
	static void swap_2017 (int [] arr_2017, int i_2017, int j_2017) {
		int temp_2017 = arr_2017[i_2017];
		arr_2017[i_2017] = arr_2017[j_2017];
		arr_2017[j_2017] = temp_2017;
	}
	//metode tambahan untuk mengatur pivot menggnakan Median-of-Three
	static void medianOfThree_2017 (int[] arr_2017, int low_2017, int high_2017) {
		int mid_2017 = low_2017 + (high_2017 - low_2017)/2;
		
		//urutkan elemen low, mid, dan high
		if (arr_2017[low_2017] > arr_2017[mid_2017]) {
			swap_2017 (arr_2017,low_2017,mid_2017);
		}
		if (arr_2017[low_2017] > arr_2017[high_2017]) {
			swap_2017 (arr_2017,low_2017,high_2017);
		}
		if (arr_2017[mid_2017] > arr_2017[high_2017]) {
			swap_2017 (arr_2017,mid_2017,high_2017);
		}
		swap_2017 (arr_2017,mid_2017,high_2017);
	}
	static int partition_2017 (int[] arr_2017, int low_2017, int high_2017) {
		//pangggil fungsi medianOfThree sebelum mengurutkan pivot
		medianOfThree_2017(arr_2017,low_2017,high_2017);
		
		int pivot_2017 = arr_2017[high_2017];
		int i_2017 = (low_2017 -1);
		
		for (int j_2017 = low_2017; j_2017 <= high_2017-1; j_2017++) {
			if( arr_2017[j_2017] < pivot_2017) {
				i_2017++;
				swap_2017 (arr_2017,i_2017,j_2017);
			}
		}
		swap_2017 (arr_2017, i_2017+1, high_2017 );
		return (i_2017 + 1);
	}
	static void QuickSort_2511532017 (int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition_2017 (arr, low,  high);
			QuickSort_2511532017 (arr, low, pi -1);
			QuickSort_2511532017(arr, pi+1, high); 
		}
	}
	public static void printArr_2017 (int [] arr_2017) {
		for (int i_2017 = 0; i_2017< arr_2017.length; i_2017++) {
			System.out.print(arr_2017[i_2017]+" ");
		}
		System.out.println();
	}
	public static void main (String []args) {
		int [] arr_2017 = {10,7,8,9,1,5};
		int N = arr_2017.length;
		System.out.print("Data sebelum diurtutakn: ");
		printArr_2017(arr_2017);
		
		QuickSort_2511532017 (arr_2017, 0, N-1);
		
		System.out.print("data setelah diurutkan dengan qucksrot: ");
		printArr_2017(arr_2017);
	}

}
