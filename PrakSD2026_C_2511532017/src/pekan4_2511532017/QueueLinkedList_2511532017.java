package pekan4_2511532017;

import java.util.*;

public class QueueLinkedList_2511532017 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		for (int i_2017 = 0; i_2017<6; i_2017++)
			q.add(i_2017);
		System.out.println("Element Antrian "+q);
		int hapus_2017 = q.remove();
		System.out.println("Hapus Elemen = " + hapus_2017);
		System.out.println(q);
		int depan_2017 = q.peek();
		System.out.println("Kepala Antrian = " + depan_2017);
		
		int banyak_2017 = q.size();
		System.out.println(" Size Antrian = "+banyak_2017);
		
	}

}
