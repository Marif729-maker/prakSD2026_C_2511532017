package pekan4_2511532017;

public class QueueArrayDriver_2511532017 {

	public static void main(String[] args) {
		QueueArray_2511532017 queue = new QueueArray_2511532017(1000);
		queue.enqueue_2511532017(10);
		queue.enqueue_2511532017(20);
		queue.enqueue_2511532017(30);
		queue.enqueue_2511532017(40);
		System.out.println("item didepan "+ queue.front_2511532017());
		System.out.println("item paling dibelakang "+ queue.rear_2511532017());
		System.out.println("tampilan queue");
		queue.display_2511532017();
		System.out.println();
		System.out.println(queue.dequeue_2511532017()+" dihapus dari queue");
		System.out.println("item didepan "+queue.front_2511532017() );
		System.out.println("item dibelakang "+ queue.rear_2511532017());
		System.out.println("tampilan queue setelah satu data dihapus");
		queue.display_2511532017();

	}

}
