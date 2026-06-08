package pekan9_2511532017;

public class BTreeDriver_2511532017 {

	public static void main(String[] args) {
		//membuat Pohon
		BTree_2511532017 tree_2017 = new  BTree_2511532017();
		System.out.print("Jumlah Simpul awal pohon: ");
		System.out.println(tree_2017.countNodes_2017());
		//menambahkan simpul data 1
		Node_2511532017 root_2017 = new Node_2511532017(1);
		//menjadikan simpul 1 sebagai root
		tree_2017.setRoot_2017(root_2017);
		System.out.println("Jumlah simpul jika hanya ada root");
		System.out.println(tree_2017.countNodes_2017());
		Node_2511532017 node2 =new Node_2511532017(2);
		Node_2511532017 node3 =new Node_2511532017(3);
		Node_2511532017 node4 =new Node_2511532017(4);
		Node_2511532017 node5 =new Node_2511532017(5);
		Node_2511532017 node6 =new Node_2511532017(6);
		Node_2511532017 node7 =new Node_2511532017(7);
		Node_2511532017 node8 =new Node_2511532017(8);
		Node_2511532017 node9 =new Node_2511532017(9);
		
		root_2017.setLeft_2511532017(node2);
		node2.setLeft_2511532017(node4);
		node2.setRight_2511532017(node5);
		node4.setRight_2511532017(node8);
		root_2017.setRight_2511532017(node3);
		node3.setLeft_2511532017(node6);
		node3.setRight_2511532017(node7);
		node6.setLeft_2511532017(node9);
		
		//set root
		tree_2017.setCurrent(tree_2017.getRoot_2017());
		System.out.println("menampilkan simpul terakhir: ");
		System.out.println(tree_2017.getCurrent_2017().getData_2017());
		System.out.println("jumlah simpul; setelah simpul 7 ditambahkan ");
		System.out.println(tree_2017.countNodes_2017());
		System.out.println("InOrder: ");
		tree_2017.printInorder_2017();
		System.out.println("\nPreOrder: ");
		tree_2017.printPreorder_2017();
		System.out.println("\nPostOrder: ");
		tree_2017.printPostorder_2017();
		System.out.println("\nmenampilkan simpul dalam bentuk pohon");
		tree_2017.print();

	}

}
