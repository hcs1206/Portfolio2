package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1935_후위표기식2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		double[] operand = new double[N];
		

		for (int i = 0; i < N; i++) {
			operand[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> st = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '*') {
				Double b = st.pop();
				Double a = st.pop();
				st.push(a*b);
				
			} else if(str.charAt(i) == '+') {
				Double b = st.pop();
				Double a = st.pop();
				st.push(a+b);
			} else if(str.charAt(i) == '/') {
				Double b = st.pop();
				Double a = st.pop();
				st.push(a/b);
			} else if(str.charAt(i) == '-') {
				Double b = st.pop();
				Double a = st.pop();
				st.push(a-b);
			} else {
				st.push(operand[str.charAt(i)-65]);
			}
		}
		
		System.out.printf("%.2f", st.pop());

	}

}
