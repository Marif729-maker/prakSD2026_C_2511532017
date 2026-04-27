package pekan4_2511532017;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;

public class IterasiQueue_2511532017 {

	public static void main(String[] args) {

		Queue<String> q = new LinkedList <>();
		q.add("Praktikum");
		q.add("Struktur");
		q.add("Data");
		q.add("Dan");
		q.add("Algoritma");
		Iterator<String> iterator= q.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}

	}

}
