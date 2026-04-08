package pekan3_2511532017;
import java.util.*;
public class NilaiMaksimum_2511532017 {
	public static int max_2017(Stack<Integer>s_2017) {
		Stack<Integer> backup = new Stack<Integer>();
		int MaxValue_2017 = s_2017.pop();
		backup.push (MaxValue_2017);
		while (!s_2017.isEmpty()) {
			int next_2017 = s_2017.pop();
			backup.push(next_2017);
			MaxValue_2017 = Math.max(MaxValue_2017, next_2017);
		}while (!backup.isEmpty()) {
			s_2017.push(backup.pop());
		}
		return MaxValue_2017;
	}
	public static void main (String[]args) {
		Stack<Integer>s_2017 = new Stack<Integer>();
		s_2017.push(70);
		s_2017.push(12);
		s_2017.push(20);
		System.out.println("isi stack "+ s_2017);
		System.out.println("stack teratas "+ s_2017.peek());
		System.out.println("nilai maksimum "+ max_2017(s_2017));
	}

}
