package SW;

import java.io.IOException;
import java.util.Stack;

public class Programmers_수식최대화 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String str = "100-200*300-500+20";
		
		solution(str);
		

	}
	
	// +<-<*
	// +<*<-
	// *<+<-
	// *<-<+
	// -<*<+
	// -<+<*
	
	public static long solution(String expression) {
        long answer = 0;
        
        int[][] priorityArr = {
        		{0,1,2},
        		{0,2,1},
        		{1,2,0},
        		{2,1,0},
        		{2,0,1},
        		{1,0,2}
        };
        
        String[] str = new String[6];
        
        for (int i = 0; i < 6; i++) {
        	StringBuilder sb = new StringBuilder();
        	Stack<Character> st = new Stack<>();
        	for (int j = 0; j < expression.length(); j++) {
        		if(expression.charAt(j) >= '0' && expression.charAt(j) <='9') {
        			sb.append(expression.charAt(j));
        		}
        		else {
        			while(!st.isEmpty() && comparePriority(priorityArr[i], st.peek()) >= comparePriority(priorityArr[i], expression.charAt(j))) {
        				sb.append(",").append(st.pop());        				
        			}
        			sb.append(",");
        			st.push(expression.charAt(j));
        		}	
        	}
        	
        	while(!st.isEmpty()) {
				sb.append(",").append(st.pop());
        	}
        	
        	str[i] = sb.toString();
		}
        
        for (int i = 0; i < str.length; i++) {
        	Stack<Long> st = new Stack<>();
        	for (int j = 0; j < str[i].length(); j++) {
				if(str[i].charAt(j) >= '0' && str[i].charAt(j) <= '9') {
					String temp = "";
					while(str[i].charAt(j) != ',') {
						temp += str[i].charAt(j) + "";
						j++;
					}
					st.push(Long.parseLong(temp));
				}
				else if(str[i].charAt(j) == ',') {
					continue;
				}
				else {
					long b = st.pop();
					long a = st.pop();
					if(str[i].charAt(j) == '*') {
						st.push(a*b);
					} else if(str[i].charAt(j) == '+') {
						st.push(a+b);
					} else {
						st.push(a-b);
					}
				}
			}
        	
        	if(answer < Math.abs(st.peek()))
        		answer = Math.abs(st.pop()); 
		}
        
        return answer;
    }

	private static int comparePriority(int[] priorityArr, Character c) {
		if(c=='+')
			return priorityArr[0];
		else if(c=='-')
			return priorityArr[1];
		else
			return priorityArr[2];	
		
	}

}
