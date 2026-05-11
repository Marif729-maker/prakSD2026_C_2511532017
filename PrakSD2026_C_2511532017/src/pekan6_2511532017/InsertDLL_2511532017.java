package pekan6_2511532017;

public class InsertDLL_2511532017 {
//	menambahkan node di awal DLL
	static NodeDLL_2511532017 InsertBegin_2017 (NodeDLL_2511532017 head_2017, int data_2017) {
		//buat node baru
		NodeDLL_2511532017 new_node = new NodeDLL_2511532017 (data_2017);
		//jadikan next pointer head
		new_node.next_2017 = head_2017;
		//jadikan pointer prev head ke new_node
		if (head_2017 != null) {
			head_2017.prev_2017 = new_node;
		}
		return new_node;
		
	}
	//fungsi untuk menampilkan node di akhir
	public static NodeDLL_2511532017 InsertEnd_2017 (NodeDLL_2511532017 head_2017, int newData_2017) {
		//buat node baru
		NodeDLL_2511532017 newNode_2017 = new NodeDLL_2511532017 (newData_2017);
		//jika dll null jadikan head
		if (head_2017 == null) {
			head_2017 = newNode_2017;
		}
		else {
			NodeDLL_2511532017 curr_2017 = head_2017;
			while (curr_2017.next_2017 != null ) {
				curr_2017 = curr_2017.next_2017;
			}
			curr_2017.next_2017 = newNode_2017;
			newNode_2017.prev_2017 = curr_2017; 
		}
		return head_2017;
	}
	
	public static NodeDLL_2511532017 insertAtPosition_2017 (NodeDLL_2511532017 head_2017, int pos_2017, int new_data_2017) {
		//buat node baru
		NodeDLL_2511532017 new_node_2017 = new NodeDLL_2511532017 (new_data_2017);
		if(pos_2017 == 1) {
			new_node_2017.next_2017 = head_2017;
			if (head_2017 == null) {
				head_2017.prev_2017 = new_node_2017;
			}
			head_2017 = new_node_2017;
			return head_2017;
		}
		NodeDLL_2511532017 curr_2017 = head_2017;
		for(int i = 1; i <pos_2017-1 && curr_2017 != null; ++i) {
			curr_2017 = curr_2017.next_2017; 
			}
		
		if (curr_2017 == null) {
			System.out.println("Posisi tidak ada");
			return head_2017;
		}
		
		new_node_2017.prev_2017 = curr_2017;
		new_node_2017.next_2017 = curr_2017.next_2017;
		curr_2017.next_2017 = new_node_2017;
		
		if (new_node_2017.next_2017 != null) {
			new_node_2017.next_2017.prev_2017 = new_node_2017;
		}
		return head_2017;
	}
	
	public static void printList_2017 (NodeDLL_2511532017 head_2017) {
		NodeDLL_2511532017 curr_2017 = head_2017;
		while (curr_2017 != null) {
			System.out.print(curr_2017.data_2017 +" <--> ");
			curr_2017 = curr_2017.next_2017;
		}
		System.out.println();
	}
	public static void main (String [] args) {
		//membuat dll
		NodeDLL_2511532017 head_2017 = new NodeDLL_2511532017 (2);
		head_2017.next_2017 = new NodeDLL_2511532017 (3);
		head_2017.next_2017.prev_2017 = head_2017;
		head_2017.next_2017.next_2017 = new NodeDLL_2511532017 (5);
		head_2017.next_2017.next_2017.prev_2017 = head_2017.next_2017;
		
		System.out.print("DLL Awal: ");
		printList_2017(head_2017);
		//tambah 1 di awal
		head_2017 = InsertBegin_2017 (head_2017, 1);
		System.out.print("Simpul 1 ditambah di awal : ");
		printList_2017 (head_2017);
		
		
		System.out.print(" simpul 6 ditambah di akhir: ");
		int data_2017 = 6;
		head_2017 = InsertEnd_2017 (head_2017, data_2017);
		printList_2017 (head_2017);
		
		System.out.print("tambah node 4 diposisi 4 : ");
		int data2_2017 = 4;
		int pos_2017 = 4;
		head_2017 = insertAtPosition_2017 (head_2017, pos_2017, data2_2017);
		printList_2017 (head_2017);
		
	}

}
