package pekan9_2511532017;

public class BTree_2511532017 {
	private Node_2511532017 root_2017;
	private Node_2511532017 currentNode_2017;
	public BTree_2511532017 () {
		root_2017 = null;
	}
	public boolean search_2017 (int data_2017) {
		return search_2017 (root_2017, data_2017);
	}
	private boolean search_2017 (Node_2511532017 node_2017, int data_2017) {
		if (node_2017.getData_2017() == data_2017)
			return true;
		if (node_2017.getLeft_2017() != null)
			if (search_2017(node_2017.getLeft_2017(), data_2017))
				return true;
		if (node_2017.getRight_2017() != null)
			if (search_2017(node_2017.getRight_2017(), data_2017))
				return true;
		return false;

	}
	public void printInorder_2017() {
		root_2017.printInorder_2017(root_2017);
	}
	public void printPreorder_2017() {
		root_2017.printPreorder_2017(root_2017);
	}
	public void printPostorder_2017() {
		root_2017.printPostorder_2017(root_2017);
	}
	
	public Node_2511532017 getRoot_2017() {
		return root_2017;
	}
	
	public boolean isEmpty_2017 () {
		return root_2017 == null;
	}
	
	public int countNodes_2017() {
		return countNodes_2017 (root_2017);
	}
	
	private int countNodes_2017 (Node_2511532017 node_2017) {
		int count_2017 = 1;
		if ( node_2017 == null) {
			return 0;
		}else {
			count_2017 += countNodes_2017 (node_2017.getLeft_2017());
			count_2017 += countNodes_2017 (node_2017.getRight_2017());
			return count_2017;
		}
	}
	
	public void print () {
		root_2017.print_2511532017();
		}
	
	public Node_2511532017 getCurrent_2017() {
		return currentNode_2017;
	}
	
	public void setCurrent (Node_2511532017 node_2017) {
		this.currentNode_2017 = node_2017;
	}
	
	public void setRoot_2017 (Node_2511532017 root_2017) {
		this.root_2017 = root_2017;
	}
	

}
