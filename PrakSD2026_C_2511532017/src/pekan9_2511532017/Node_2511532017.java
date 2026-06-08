package pekan9_2511532017;

public class Node_2511532017 {
	int data_2017;
	Node_2511532017 left_2017;
	Node_2511532017 right_2017;
	public Node_2511532017 (int data_2017) {
		this.data_2017 = data_2017;
		left_2017 = null;
		right_2017 = null;
		}
	public void setLeft_2511532017 (Node_2511532017 node_2017) {
		if (left_2017 == null)
			left_2017 = node_2017;
	}
	public void setRight_2511532017 (Node_2511532017 node_2017) {
		if (right_2017 == null)
			right_2017 = node_2017;
	}
	public Node_2511532017 getLeft_2017 () {
		return left_2017;
	}
	public Node_2511532017 getRight_2017 () {
		return right_2017;
	}
	public int getData_2017 () {
		return data_2017;
	}
	public void setData_2017 (int data_2017) {
		this.data_2017 = data_2017;
	}
	void printPreorder_2017 (Node_2511532017 node_2017) {
		if (node_2017 == null)
			return;
		System.out.print(node_2017.data_2017 + " ");
		printPreorder_2017 (node_2017.left_2017);
		printPreorder_2017 (node_2017.right_2017);
	}
	void printPostorder_2017 (Node_2511532017 node_2017) {
		if (node_2017 == null)
			return;
		printPostorder_2017 (node_2017.left_2017);
		printPostorder_2017 (node_2017.right_2017);
		System.out.print(node_2017.data_2017 + " ");
	}
	void printInorder_2017 (Node_2511532017 node) {
		if (node == null)
			return;
		printInorder_2017 (node.left_2017);
		System.out.print(node.data_2017 + " ");
		printInorder_2017 (node.right_2017);
			
	}
	public String print_2511532017 () {
		return this.print_2017("", true, "");
	}
	public String print_2017 (String prefix_2017, boolean isTail_2017, String sb_2017) {
		if (right_2017 != null) {
			right_2017.print_2017(prefix_2017 +( isTail_2017 ? "|   ": "    "),false, sb_2017);
		}
		System.out.println(prefix_2017+(isTail_2017 ? "\\--" : "/--")+data_2017);
		if (left_2017 != null) {
			left_2017.print_2017(prefix_2017 +(isTail_2017 ? "    ": "|   "),true, sb_2017);
		}
		return sb_2017;
	}

}
