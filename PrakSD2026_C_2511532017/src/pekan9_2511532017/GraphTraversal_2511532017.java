package pekan9_2511532017;
import java.util.*;
public class GraphTraversal_2511532017 {
	private Map<String, List<String>> graph_2017 = new HashMap<>();
	
	//menambahkan edge (graf tak berarah)
	public void adEdge_2017 (String node1_2017, String node2_2017) {
		graph_2017.putIfAbsent(node1_2017, new ArrayList<>());
		graph_2017.putIfAbsent(node2_2017, new ArrayList<>());
		graph_2017.get (node1_2017).add(node2_2017);
		graph_2017.get (node2_2017).add(node1_2017);
	}
	//menampilkan graf awal
	public void printGraph_2017 () {
		System.out.println("Graf Awal (Adjaceny List): ");
		for (String node_2017 : graph_2017.keySet()) {
			System.out.print(node_2017 + " -->");
			List <String> neighbors = graph_2017.get(node_2017);
			System.out.println(String.join(",",neighbors));
		}
		System.out.println();
	}
	//DFS rekursif
	public void dfs_2017 (String start) {
		Set <String> visited = new HashSet<>();
		System.out.println("Penelusuran DFS: ");
		dfsHelper_2017 (start, visited);
		System.out.println();
	}
	private void dfsHelper_2017 (String current, Set<String> visited) {
		if (visited.contains(current)) return;
		visited.add(current);
		System.out.print(current + " ");
		for (String neighbor_2017 : graph_2017.getOrDefault(current,new ArrayList <>())) {
			dfsHelper_2017 (neighbor_2017, visited);
		}
	}
	//BFS iteratif
	public void bfs_2017 (String start_2017) {
		Set <String> visited_2017 = new HashSet <>();
		Queue <String> queue_2017 = new LinkedList <>();
		queue_2017.add(start_2017);
		visited_2017.add(start_2017);
		System.out.println("Penelusuran BFS: ");
		while (!queue_2017.isEmpty()) {
			String current = queue_2017.poll();
			System.out.print(current + " ");
			for (String neighbor : graph_2017.getOrDefault(current, new ArrayList<>())) {
				if (!visited_2017.contains(neighbor)) {
				queue_2017.add(neighbor);
				visited_2017.add(neighbor);
			}
		}
	}
	System.out.println();

}
	public static void main (String[] args) {
		GraphTraversal_2511532017 graph_2017 = new GraphTraversal_2511532017 ();
		
		//contoh graf: A-B, A-C, B-D, B-E
		graph_2017.adEdge_2017("A", "B");
		graph_2017.adEdge_2017("A", "C");
		graph_2017.adEdge_2017("B", "D");
		graph_2017.adEdge_2017("B", "E");
		
		//cetak graf awal
		System.out.println("Graf awal adalah: ");
		graph_2017.printGraph_2017();
		//lakukan penelusan
		graph_2017.dfs_2017("A");
		graph_2017.bfs_2017("A");
	}
}