package Pekan8_2511532017;

public class ShellSort_2511532017 {
	public static void ShellSort_2511532017 (int [] A_2017){
	int n_2017 = A_2017.length;
	int gap_2017 = n_2017/2;
	while (gap_2017 > 0) {
		for (int i_2017 = gap_2017; i_2017 < n_2017; i_2017++) {
			int temp_2017 = A_2017[i_2017];
			int j_2017 = i_2017;
			while ( j_2017 >= gap_2017 && A_2017[j_2017 - gap_2017] > temp_2017) {
				A_2017[j_2017] = A_2017[j_2017-gap_2017];
				j_2017 = j_2017 - gap_2017;
			}
			A_2017[j_2017] = temp_2017;
		}
		gap_2017 = gap_2017/2;
	}

}
	public static void main (String []args) {
		int [] data_2017 = {3,10,4,6,8,9,7,2,1,5};
		
		System.out.print("Sebelum: ");
		printArray_2017(data_2017);
		
		ShellSort_2511532017(data_2017);
		
		System.out.print("Sesudah (ShellSort): ");
		printArray_2017(data_2017);
	}
	public static void printArray_2017 (int [] arr_2017) {
		for (int i_2017 : arr_2017) System.out.print(i_2017 + " ");
		System.out.println();
	}
}
