package pekan7_2511532017;

public class SelectionSort_2511532017 {
	public static void SelectionSort_2511532017 (int[]arr_2017) {
		int n_2017 = arr_2017.length;
		for (int i_2017=0; i_2017 < n_2017 ; i_2017++) {
			int minIndex_2017 = i_2017;
			for (int j_2017=i_2017 + 1; j_2017 < n_2017; j_2017++) {
				if (arr_2017[j_2017] < arr_2017[minIndex_2017]) {
					minIndex_2017 = j_2017;
				}
			}
			int temp_2017 = arr_2017[i_2017];
			arr_2017[i_2017] = arr_2017[minIndex_2017];
			arr_2017[minIndex_2017] = temp_2017;
		}
	}
	public static void main (String[] args) {
		int arr[] = {23, 78, 45, 8, 32, 56, 1};
		int n = arr.length;
		System.out.printf("array yang belum terurut :\n");
		for (int i =0; i<n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
		SelectionSort_2511532017(arr);
		System.out.printf("array yang terurut :\n");
		for (int i =0; i<n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

}
