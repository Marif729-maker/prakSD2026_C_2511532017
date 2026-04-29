package pekan4_2511532017;

public class QueueArray_2511532017 {
	int front_2017, rear_2017, size_2017;
	int capacity_2017;
	int array_2017[];
	
	public QueueArray_2511532017 (int capacity_2017) {
		this.capacity_2017 = capacity_2017;
		front_2017 = this.size_2017=0;
		rear_2017 = capacity_2017-1;
		array_2017 = new int [this.capacity_2017];
	}
	boolean isFull_2511532017(QueueArray_2511532017 queue) {
		return (queue.size_2017 == queue.capacity_2017);
	}
	boolean isEmpty_2511532017(QueueArray_2511532017 queue) {
		return (queue.size_2017==0);
	}
	void enqueue_2511532017 (int item) {
		if (isFull_2511532017 (this))
			return;
		this.rear_2017=(this.rear_2017+1) % this.capacity_2017;
		this.array_2017[this.rear_2017 ]= item;
		this.size_2017= this.size_2017+1;
				System.out.println(item + " enqueue to queue");
	}
	int dequeue_2511532017 () {
		if (isEmpty_2511532017 (this))
			return Integer.MIN_VALUE;
		int item = this.array_2017[this.front_2017];
		this.front_2017 = (this.front_2017+1) % this.capacity_2017;
		this.size_2017=this.size_2017-1;
		return item;
	}
	int front_2511532017() {
		if (isEmpty_2511532017 (this))
			return Integer.MIN_VALUE;
		
		return this.array_2017[this.front_2017];
		
	}
	int rear_2511532017() {
		if (isEmpty_2511532017(this))
			return Integer.MIN_VALUE;
		return this.array_2017[this.rear_2017];
	}
	void display_2511532017 () {
		int i;
		if (front_2017 == rear_2017) {
			System.out.println("\nAntrian Kosong\n");
			return;
		}
		for (i=front_2017; i<=rear_2017; i++) {
			System.out.printf(" %d <--", array_2017[i]);
		}
		return;
		
	}
}
