package pekan7_2511532017;

public class BubleSort_2511532017 {
	public static void BubleSort_2511532017(int[]arr_2017) {
		int n_2017 = arr_2017.length;
		for (int i_2017 =0; i_2017 < n_2017; i_2017++) {
			for (int j_2017 = 0; j_2017< n_2017-i_2017-1; j_2017++) {
				if(arr_2017[j_2017] > arr_2017[j_2017 +1]) {
					int temp = arr_2017[j_2017];
					arr_2017[j_2017] = arr_2017[j_2017+1];
					arr_2017[j_2017+1]= temp;
					//system.out.println("data;" +arr[j]+arr[j+1]);
				}
			}
		}
	}
	public static void main(String[]args) {
		int arr[] = {23,78,45,8, 32, 56, 1};
		int n =arr.length;
		System.out.print("array yang belum terurut:");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i]+" ");
		System.out.println("");
		BubleSort_2511532017(arr);
		System.out.print("array yang terurut:");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i]+" ");
		System.out.println("");
	}

}
