package pekan3_2511532017;

import java.util.*;

public class stackPostfix_2511532017 {
	public static int postfixEvaluate_2511532017(String expression) {
		Stack<Integer> s = new Stack<Integer>();
		Scanner input = new Scanner (expression);
		while (input.hasNext()) {
			if(input.hasNextInt()) {
			
				s.push(input.nextInt());
			}else {
				String operator_2017 = input.next();
				int operand2 = s.pop();
				int operand1 = s.pop();
				if(operator_2017.equals ("+")) {
					s.push(operand1 + operand2);
				}else if (operator_2017.equals ("-")) {
					s.push (operand1 - operand2);
				}else if (operator_2017.equals ("*")) {
					s.push (operand1 * operand2);
				}else {
					s.push(operand1 / operand2);
				}
			}
		
		}input.close();
		return s.pop();
	}
	public static void main (String[]args) {
		System.out.println("hasil positifx = "+ postfixEvaluate_2511532017("5 2 4 * +  7 -"));
	}
}
