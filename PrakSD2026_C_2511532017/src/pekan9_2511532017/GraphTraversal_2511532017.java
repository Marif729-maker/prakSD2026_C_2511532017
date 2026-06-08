package pekan9_2511532017;
import java.util.*;
public class GraphTraversal_2511532017 {
	private Map<String, List<String>> graph = new HashMap<>();
	
	//menambahkan edge (graf tak berarah)
	public void adEdge (String node1, String node2) {
		graph.putIfAbsent(node1, new ArrayList<>());
		graph.putIfAbsent(node2, new ArrayList<>());
		graph.get (node1).add(node2);
		graph.get (node2).add(node1);
	}
	//menampilkan graf awal
	public void printGraph () {
		System.out.println("Graf Awal (Adjaceny List): ");
		for (String node_2017 : graph.keySet()) {
			System.out.print(node_2017 + " -->");
			List <String> neighbors = graph.get(node_2017);
			System.out.println(String.join(",",neighbors));
		}
		System.out.println();
	}
	//DFS rekursif
	public void dfs (String start) {
		Set <String> visited = new HashSet<>();
		System.out.println("Penelusuran DFS: ");
		dfsHelper (start, visited);
		System.out.println();
	}
	private void dfsHelper (String current, Set<String> visited) {
		if (visited.contains(current)) return;
		visited.add(current);
		System.out.print(current + " ");
		for (String neighbor : graph.getOrDefault(current,new ArrayList <>())) {
			dfsHelper (neighbor, visited);
		}
	}
	//BFS iteratif
	public void bfs (String start) {
		Set <String> visited = new HashSet <>();
		Queue <String> queue = new LinkedList <>();
		queue.add(start);
		visited.add(start);
		System.out.println("Penelusuran BFS: ");
		while (!queue.isEmpty()) {
			String current = queue.poll();
			System.out.print(current + " ");
			for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
				if (!visited.contains(neighbor)) {
				queue.add(neighbor);
				visited.add(neighbor);
			}
		}
	}
	System.out.println();

}
	public static void main (String[] args) {
		GraphTraversal_2511532017 graph = new GraphTraversal_2511532017 ();
		
		//contoh graf: A-B, A-C, B-D, B-E
		graph.adEdge("A", "B");
		graph.adEdge("A", "C");
		graph.adEdge("B", "D");
		graph.adEdge("B", "E");
		
		//cetak graf awal
		System.out.println("Graf awal adalah: ");
		graph.printGraph();
		//lakukan penelusan
		graph.dfs("A");
		graph.bfs("A");
	}
}