package pekan6_2511532017;

public class PenelusuranDLL_2511532017 {
	
	static void forwardTraversal_2017 (NodeDLL_2511532017 head_2017) {
		NodeDLL_2511532017 curr_2017 = head_2017;
		while (curr_2017 != null) {
			System.out.print(curr_2017.data_2017 +" <--> ");
			curr_2017 = curr_2017.next_2017;
		}
		
		System.out.println();
	}
	
	static void backwardTraversal_2017 (NodeDLL_2511532017 tail_2017) {
		NodeDLL_2511532017 curr_2017 = tail_2017;
		while (curr_2017 != null) {
			System.out.print(curr_2017.data_2017 + " <--> ");
			curr_2017 = curr_2017.prev_2017;
		}
		System.out.println();
	}
	
	public static void main (String [] args) {
		NodeDLL_2511532017 head_2017 = new NodeDLL_2511532017 (1);
		NodeDLL_2511532017 second_2017 = new NodeDLL_2511532017 (2);
		NodeDLL_2511532017 third_2017 = new NodeDLL_2511532017 (3);
		
		head_2017.next_2017 = second_2017;
		second_2017.prev_2017 = head_2017;
		second_2017.next_2017 = third_2017;
		third_2017.prev_2017 = second_2017;
		
		System.out.println("penelusuran maju: ");
		forwardTraversal_2017(head_2017);
		
		System.out.println("penelusuran mundur: ");
		backwardTraversal_2017 (third_2017);
	}

}
