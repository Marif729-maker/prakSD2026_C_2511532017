package pekan3_2511532017;

public class stackArray_2511532017 {
	static final int max_2017 = 1000;
	int top_2017;
	int a[] = new int [max_2017];
	boolean isEmpty()
	{
		return (top_2017 < -1);
	}
	 stackArray_2511532017(){
		top_2017 = -1;
	}
	boolean push(int x) {
		if(top_2017 >= (max_2017 - 1)) {
			System.out.println("stack overflow");
			return false;
		} else {
			a[++top_2017] = x;
			System.out.println(x +" dimasukkan ke dalam stack");
			return true;
		}
	}
	int pop() {
		if(top_2017 < 0) {
			System.out.println("stack underflow");
			return 0;
		} else {
			int x = a[top_2017--];
			return x;
		}
	}
	int peek() {
		if (top_2017 < 0) {
			System.out.println("stack underflow");
			return 0;
		} else {
			int x = a[top_2017];
			return x;
		}
	}
	void print () {
		for (int i = top_2017; i>-1;i--) {
			System.out.print(" "+ a[i]);
		}
	}
}
