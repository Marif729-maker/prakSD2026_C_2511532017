package pekan7_2511532017;

public class InsertionSort_2511532017 {
	public static void InsertionSort_2511532017 (int[]arr) {
	int n_2017 = arr.length;
	for (int i_2017 =1; i_2017 < n_2017; i_2017++) {
		int key = arr[i_2017];
		int j_2017 = i_2017 - 1;
		while (j_2017 >= 0 && arr[j_2017] > key) {
			arr[j_2017 + 1] = arr[j_2017];
			j_2017--;
		}
		arr [j_2017 + 1] = key;
	}

}
public static void main (String [] args) {
	int arr_2017[] = {23, 78, 45, 8, 32, 56, 1};
	int n_2017 = arr_2017.length;
	System.out.printf("array yang belum terurut:\n");
	for (int i_2017 =0; i_2017 < n_2017; i_2017++)
		System.out.print(arr_2017[i_2017] + " ");
	System.out.println("");
	InsertionSort_2511532017 (arr_2017);
	System.out.printf("array yang terurut:\n");
	for (int i = 0; i < n_2017 ; i++)
		System.out.print(arr_2017[i] + " ");
	System.out.println("");
	
}
}