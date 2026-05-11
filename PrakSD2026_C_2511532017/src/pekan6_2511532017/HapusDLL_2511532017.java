package pekan6_2511532017;

public class HapusDLL_2511532017 {
	
	public static NodeDLL_2511532017 delHead_2017 (NodeDLL_2511532017 head_2017) {
		if (head_2017 == null) {
			return null;
		}
		NodeDLL_2511532017 temp_2017 = head_2017;
		head_2017 = head_2017.next_2017;
		if(head_2017 != null) {
			head_2017.prev_2017 = null;
		}
		return head_2017;
	}
	
	public static NodeDLL_2511532017 delLast_2017 (NodeDLL_2511532017 head_2017) {
		if( head_2017 == null) {
			return null;
		}
		if (head_2017.next_2017 == null) {
			return null;
		}
		NodeDLL_2511532017 curr_2017 = head_2017;
		while (curr_2017.next_2017 != null) {
			curr_2017 = curr_2017.next_2017;
		}
		
		if (curr_2017.prev_2017 != null) {
			curr_2017.prev_2017.next_2017 = null;
		}
		return head_2017;
	}
	
	public static NodeDLL_2511532017 delPos_2017 (NodeDLL_2511532017 head_2017, int pos_2017) {
		if (head_2017 == null) {
			return head_2017;
		}
		
		NodeDLL_2511532017 curr_2017 = head_2017;
		for (int i = 1; curr_2017 != null && i < pos_2017; ++i) {
			curr_2017 = curr_2017.next_2017;
		}
		
		if (curr_2017 == null) {
			return head_2017;
		}
		if (curr_2017.prev_2017 != null) {
			curr_2017.prev_2017.next_2017 = curr_2017.next_2017;
		}
		if (curr_2017.next_2017 != null) {
			curr_2017.next_2017.prev_2017 = curr_2017.prev_2017;
		}
		if (head_2017 == curr_2017) {
			head_2017 = curr_2017.next_2017;
		}
		return head_2017;
		
	}
	
	public static void printList_2017 (NodeDLL_2511532017 head_2017) {
		NodeDLL_2511532017 curr_2017 = head_2017;
		while (curr_2017 != null) {
			System.out.print(curr_2017.data_2017+" ");
			curr_2017 = curr_2017.next_2017;
		}
		System.out.println();
	}
	
	public static void main (String [] args) {
		NodeDLL_2511532017 head_2017 = new NodeDLL_2511532017 (1);
		head_2017.next_2017 = new NodeDLL_2511532017 (2);
		head_2017.next_2017.prev_2017 = head_2017;
		head_2017.next_2017.next_2017 = new NodeDLL_2511532017(3);
		head_2017.next_2017.next_2017.prev_2017 = head_2017.next_2017;
		head_2017.next_2017.next_2017.next_2017 = new NodeDLL_2511532017 (4);
		head_2017.next_2017.next_2017.next_2017.prev_2017 = head_2017.next_2017.next_2017;
		head_2017.next_2017.next_2017.next_2017.next_2017 = new NodeDLL_2511532017 (5);
		head_2017.next_2017.next_2017.next_2017.next_2017.prev_2017 = head_2017.next_2017.next_2017.next_2017;
		
		System.out.print("DLL awal: ");
		printList_2017(head_2017);
		
		System.out.print("setelah head dihapus: ");
		head_2017 = delHead_2017 (head_2017);
		printList_2017(head_2017);
		
		System.out.print("setelah node terakhi dihapus: ");
		head_2017 = delLast_2017 (head_2017);
		printList_2017(head_2017);
		
		System.out.print("menghapus node ke 2: ");
		head_2017 = delPos_2017 (head_2017, 2);
		printList_2017 (head_2017);
	}

}
