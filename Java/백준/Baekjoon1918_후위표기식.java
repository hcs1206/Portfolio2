package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1918_후위표기식 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				System.out.print(str.charAt(i));
			} else if (str.charAt(i) == '(') {						
				st.push(str.charAt(i));
			} else if (str.charAt(i) == ')') {
				while(st.peek() != '(')
					System.out.print(st.pop() + "");
				
				st.pop();

			} else {
				while(!st.isEmpty() && priority(st.peek()) >= priority(str.charAt(i))) {
					System.out.print(st.pop());
				}
				st.push(str.charAt(i));				
			}
		}

		while (!st.isEmpty()) {
			char c = st.pop();
			if(c != '(')
				System.out.print(c);
		}

	}

	private static int priority(char c) {
		if(c == '(')
			return 0;
		else if(c=='+' || c=='-')
			return 1;
		else
			return 2;		
	}

}
