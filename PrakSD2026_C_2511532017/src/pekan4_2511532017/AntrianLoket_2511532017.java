package pekan4_2511532017;
import java.util.*;
public class AntrianLoket_2511532017 {
	int front_2017, rear_2017, size_2017;
	int capacity_2017;
	String array_2017[];
	
	public AntrianLoket_2511532017 (int capacity_2017) {
		this.capacity_2017 = capacity_2017;
		front_2017 = this.size_2017=0;
		rear_2017 = capacity_2017-1;
		array_2017 = new String [this.capacity_2017];
	}
	//cek penuh atau belum
	boolean isFull_2511532017() {
		return (this.size_2017 == this.capacity_2017);
	}
	//cek kosong atau enggak
	boolean isEmpty_2511532017() {
		return (this.size_2017==0);
	}
	//masukkan antrian
	void enqueue_2511532017 (String nama_2017) {
		if (isFull_2511532017 ()) {
			System.out.println("Antrian penuh");
			return;
		}
			
		this.rear_2017=(this.rear_2017+1) % this.capacity_2017;
		this.array_2017[this.rear_2017 ]= nama_2017;
		this.size_2017++;
				System.out.println( "Data berhasil ditambahkan ke antrian");
	}
	//hapus antrian
	String dequeue_2511532017 () {
		if (isEmpty_2511532017 ()) {
			System.out.println("Antrian kosong");
		return null;}
		String nama_2017= this.array_2017[this.front_2017];
		this.front_2017 = (this.front_2017+1) % this.capacity_2017;
		this.size_2017=this.size_2017-1;
		return nama_2017;
	}
	
	String front_2511532017() {
		if (isEmpty_2511532017 ())return null;
			return this.array_2017[this.front_2017];
		
	}
	String rear_2511532017() {
		if (isEmpty_2511532017())
			return null;
		return this.array_2017[this.rear_2017];
	}
	//reverse antrian
	public void reverseQueue_2511532017() {
		if(isEmpty_2511532017()) {
			System.out.println("antrian kosong"); return;
		}
		Stack<String> stack = new Stack <>();
		while (!isEmpty_2511532017()) {
			String nama_2017 = dequeue_2511532017();
			if(nama_2017 != null) {
				stack.push(nama_2017);
			}
	}
		while (!stack.isEmpty()) {
			enqueue_2511532017(stack.pop());
		}
		}
	//tampilkan antrian
	void display_2511532017 () {
		if (this.size_2017 == 0) {
			System.out.println("\nAntrian Kosong\n");
			return;
		}
		System.out.println("isi antrian: ");
		for (int i=0; i<size_2017; i++) {
			int idx = (this.front_2017 +i)% this.capacity_2017;
			System.out.printf("\n   %d. %s", (i+1), array_2017[idx] );
		}
		System.out.println("\n");;
		
	}
}
