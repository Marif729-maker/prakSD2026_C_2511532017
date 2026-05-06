package pekan5_2511532017;

public class PencarianSLL_2511532017 {
	static boolean searchKey (NodeSLL_2511532017 head_2017, int key_2017) {
		NodeSLL_2511532017 curr_2017 = head_2017;
		while (curr_2017 != null) {
			if (curr_2017.data_2017 == key_2017)
				return true;
			curr_2017 = curr_2017.next_2017;}
		return false;	}
	public static void traversal (NodeSLL_2511532017 head_2017) {
		//mulai dari head
		NodeSLL_2511532017 curr_2017 = head_2017;
		//telusuri sampai pointer null
		while (curr_2017 != null) {
			System.out.print(" "+ curr_2017.data_2017);
			curr_2017 = curr_2017.next_2017;	}
		System.out.println(); 	}
	public static void main (String [] args) {
		NodeSLL_2511532017 head_2017 = new NodeSLL_2511532017 (14);
		head_2017.next_2017 = new NodeSLL_2511532017 (21);
		head_2017.next_2017.next_2017 = new NodeSLL_2511532017 (13);
		head_2017.next_2017.next_2017.next_2017 = new NodeSLL_2511532017 (30);
		head_2017.next_2017.next_2017.next_2017.next_2017 = new NodeSLL_2511532017 (10);
		System.out.print("Penelusuran SLL : ");
		traversal (head_2017);
		//data yang akan dicari
		int key_2017 = 30;
		System.out.print("cari data "+ key_2017 + " = ");
		if (searchKey(head_2017, key_2017))
			System.out.print("ketemu");
		else
			System.out.print("tidak ada");
		}
	}


