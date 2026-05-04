package pekan5_2511532017;

public class HapusSLL_2511532017 {
	//fungsi untuk menghapus head
	public static NodeSLL_2511532017 deleteHead_2017 (NodeSLL_2511532017 head_2017) {
		//jika SLL kosong
		if (head_2017 == null) 
		return null;
		//pindahkan head ke node berikutnya
		head_2017 = head_2017.next_2017;
		//return head baru
		return head_2017;	}
	public static NodeSLL_2511532017 removeLastNode (NodeSLL_2511532017 head_2017) {
		//jika list kosong, return null
		if (head_2017 == null) {
			return null;
		}
		//jika list satu node, hapus node dan return null
		if ( head_2017.next_2017 == null) {
			return null;
		}
		//temukan node terakhir ke dua
		NodeSLL_2511532017 secondLast = head_2017;
		while (secondLast.next_2017 != null) {
			secondLast = secondLast.next_2017;
		}
		//hapus node terakhir
		secondLast.next_2017 = null;
		return head_2017;
		
	}
	
	// function to delete node in a certain position
		public static NodeSLL_2511532017 deleteNode_2017(NodeSLL_2511532017 head_2017, int pos_2017) {
			NodeSLL_2511532017 temp_2017 = head_2017;
			NodeSLL_2511532017 prev_2017 = null;
			
			// if linked list is null
			if (temp_2017 == null)
				return head_2017;
			
			// case 1 : head is deleted
			if (pos_2017 == 1) {
				head_2017 = temp_2017.next_2017;
				return head_2017;
			}
			
			// kasus 2 : menghapus node di tengah
			// search to the targeted node that will to be deleted
			for (int i_2017 = 1; temp_2017 != null && i_2017 < pos_2017; i_2017++) {
				prev_2017 = temp_2017;
				temp_2017 = temp_2017.next_2017;
			}
			// if founded, delete node
			if (temp_2017 != null) {
				prev_2017.next_2017 = temp_2017.next_2017;
			} else {
				System.out.println("Data tidak ditemukan");
			}
			return head_2017;		
		}
		// function to print SLL
		public static void printList_2017(NodeSLL_2511532017 head_2017) {
			NodeSLL_2511532017 curr_2017 = head_2017;
			while (curr_2017.next_2017 != null) {
				System.out.print(curr_2017.data_2017 + "-->");
				curr_2017 = curr_2017.next_2017;
			}
			if (curr_2017.next_2017 == null) {
				System.out.print(curr_2017.data_2017);
			}
			System.out.println();
		}
		
		// Driver/Main class
		public static void main(String[] args) {
			// Create SLL 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
			NodeSLL_2511532017 head_2017 = new NodeSLL_2511532017(1);
			head_2017.next_2017 = new NodeSLL_2511532017(2);
			head_2017.next_2017.next_2017 = new NodeSLL_2511532017(3);
			head_2017.next_2017.next_2017.next_2017 = new NodeSLL_2511532017(4);
			head_2017.next_2017.next_2017.next_2017.next_2017 = new NodeSLL_2511532017(5);
			head_2017.next_2017.next_2017.next_2017.next_2017.next_2017 = new NodeSLL_2511532017(6);
			
			// print early list
			System.out.println("list awal : ");
			printList_2017(head_2017);
			
			// delete head
			head_2017 = deleteHead_2017(head_2017);
			System.out.println("List setelah simpul terakhir di hapus : ");
			printList_2017(head_2017);
			
			// deleteing node at pos[2]
			int pos2_2017 = 2;
			head_2017 = deleteNode_2017(head_2017, pos2_2017);
			// print list after deletion
			System.out.println("List setelah posisi 2 dihapus : ");
			printList_2017(head_2017);
		}

}
