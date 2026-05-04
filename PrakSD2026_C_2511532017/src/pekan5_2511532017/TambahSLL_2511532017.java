package pekan5_2511532017;

public class TambahSLL_2511532017 {
	public static NodeSLL_2511532017 insertAtFront (NodeSLL_2511532017 head_2017, int value_2017) {
		NodeSLL_2511532017 new_node = new NodeSLL_2511532017 (value_2017);
		new_node.next_2017 = head_2017;
		return new_node;
	}
	//fungsi menambahkan node di akhir SLL
	public static NodeSLL_2511532017 insertAtEnd (NodeSLL_2511532017 head_2017, int value_2017) {
		//buat sebuah node dengan sebuah nilai
		NodeSLL_2511532017 newNode_2017 = new NodeSLL_2511532017 (value_2017);
		//jika list kosong maka node jadi head
		if (head_2017 == null) {
			return newNode_2017;
		}
		//simpan head ke variabel sementara
		NodeSLL_2511532017 last_2017 = head_2017;
		//telusuri ke node akhir
		while (last_2017.next_2017 != null) {
			last_2017 = last_2017.next_2017;
		}
		//ubah pointer
		last_2017.next_2017 = newNode_2017;
		return head_2017;
	}
	static NodeSLL_2511532017 GetNode_2017 (int data_2017) {
		return new NodeSLL_2511532017 (data_2017);
	}
	static NodeSLL_2511532017 insertPos (NodeSLL_2511532017 headNode_2017, int position_2017, int value_2017) {
		NodeSLL_2511532017 head_2017 = headNode_2017;
		if (position_2017 < 1) {
			System.out.println("Invalid position");
		}
			if (position_2017 == 1) {
				NodeSLL_2511532017 new_node = new NodeSLL_2511532017 (value_2017);
				new_node.next_2017 = head_2017;
				return new_node;
			}else {
				while (position_2017-- != 0) {
					if (position_2017 == 1) {
						NodeSLL_2511532017 newNode_2017 = GetNode_2017 (value_2017);
						newNode_2017.next_2017 = headNode_2017.next_2017;
						headNode_2017.next_2017 = newNode_2017;
						break;
					}
					headNode_2017 = headNode_2017.next_2017;
				}
				if (position_2017 != 1) {
					System.out.println("posisi diluar jangkauan"); }
			}
		
		return head_2017;
		}
					public static void printList (NodeSLL_2511532017 head_2017) {
						NodeSLL_2511532017 curr_2017 = head_2017;
						while (curr_2017.next_2017 != null) {
							System.out.print(curr_2017.data_2017+"-->");
							curr_2017 = curr_2017.next_2017;
					}
						if (curr_2017.next_2017 == null) {
							System.out.println(curr_2017.data_2017);
						} System.out.println();
				}
			
		
	
	public static void main (String [] args) {
		//buat linked List 2-->3-->5-->6
		NodeSLL_2511532017 head_2017 = new NodeSLL_2511532017 (2);
		head_2017.next_2017 = new NodeSLL_2511532017 (3);
		head_2017.next_2017.next_2017 = new NodeSLL_2511532017 (5);
		head_2017.next_2017.next_2017.next_2017 = new NodeSLL_2511532017 (6);
		//cetak list asli
		System.out.print("Senarai berantai dari awal :" );
		printList(head_2017);
		//tambahkan node baru didepan
		System.out.print("tambah 1 simpul di depan : ");
		int data_2017 = 1;
		head_2017 = insertAtFront (head_2017, data_2017);
		//cetak update list
		printList (head_2017);
		//tambahkan node baru dibelakang
		System.out.print("tambah 1 simpul ke belakang : ");
		int data2_2017 = 7;
		head_2017 = insertAtEnd (head_2017, data2_2017);
		printList (head_2017);
		System.out.print("tambah 1 simpul ke data 4 : ");
		int data3_2017 = 4;
		int position_2017 = 4;
		head_2017 = insertPos (head_2017, position_2017, data3_2017);
		printList (head_2017);
	}
	

}
