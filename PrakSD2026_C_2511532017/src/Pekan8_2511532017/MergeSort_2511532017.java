package Pekan8_2511532017;

public class MergeSort_2511532017 {
	void merge_2017 (int arr_2017[], int l_2017, int m_2017, int r_2017) {
		//find size of two subarray to be merged
		int n1_2017 = m_2017 - l_2017 + 1;
		int n2_2017 = r_2017 - m_2017;
		//create temp array
		int L[] = new int[n1_2017];
		int R[] = new int[n2_2017];
		//copy data to temp array
		for (int i_2017 = 0; i_2017 < n1_2017; ++i_2017)
			L[i_2017] = arr_2017[l_2017 + i_2017];
		for (int j_2017 = 0; j_2017 < n2_2017; ++j_2017)
			R[j_2017] = arr_2017[m_2017 + 1 + j_2017];
		int i_2017 = 0, j_2017 = 0;
		//intital index pg merged subarray array
		int k_2017 = l_2017;
		while ( i_2017 < n1_2017 && j_2017 < n2_2017) {
			if (L [i_2017] <= R[j_2017]) {
				arr_2017[k_2017] = L[i_2017];
				i_2017++;
			}else {
				arr_2017[k_2017] = R[j_2017];
				j_2017++;
			}
			k_2017++;
		}
		while (i_2017 < n1_2017) {
			arr_2017[k_2017] = L[i_2017];
			i_2017++;
			k_2017++;
		}
		while (j_2017 < n2_2017) {
			arr_2017[k_2017] = R[j_2017];
			j_2017++;
			k_2017++;
		}
	}
	void sort_2017 (int arr_2017[], int l_2017, int r_2017) {
		if(l_2017 < r_2017) {
			int m_2017 = (l_2017 + r_2017) / 2;
			sort_2017 (arr_2017, l_2017,m_2017);
			sort_2017 (arr_2017, m_2017 + 1, r_2017);
			merge_2017 (arr_2017,l_2017,m_2017,r_2017);
		}
	}
	
	static void printArray_2017 (int arr_2017[]) {
		int n_2017 =arr_2017.length;
		for (int i_2017 = 0; i_2017 < n_2017; ++i_2017)
			System.out.print(arr_2017[i_2017] + " ");
		System.out.println();
	}
	public static void main (String [] args) {
		int arr_2017[] = {12,11,13,5,6,7};
		System.out.print("sebelum di urtkan: ");
		printArray_2017(arr_2017);
		MergeSort_2511532017 ob_2017 = new MergeSort_2511532017();
		ob_2017.sort_2017(arr_2017, 0, arr_2017.length-1);
		System.out.print("\nSesudah terurut menggunakan mergeSort: ");
		printArray_2017(arr_2017);
	}

}
