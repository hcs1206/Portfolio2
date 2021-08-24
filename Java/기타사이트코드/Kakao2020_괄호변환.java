package SW;

public class Kakao2020_괄호변환 {
	public static void main(String[] args) {
		String str = "()))((()";
		String a = solution(str);
		
		System.out.println(a);

	}
	
	public static String solution(String p) {
        String answer = correctString(p);     
        
        return answer;
    }
	
	public static String correctString(String p) {
        int cnt = 0;
        String str = "";
        String u = "";
        String v = "";
        
        if(p.length() == 0)
        	return str;
        
        for (int i = 0; i < p.length(); i++) {
        	if(p.charAt(i) == '(')
        		cnt++;
        	else
        		cnt--;
        	
        	if(cnt == 0) {
        		u = p.substring(0,i+1);
        		v = p.substring(i+1);
        		break;
        	}
		}
        
        for (int i = 0; i <= u.length(); i++) {
        	if(i == u.length()) {
        		v = correctString(v);
        		str = u+v;
        		break;
        	}
        	
        	
        	if(p.charAt(i) == '(')
        		cnt++;
        	else
        		cnt--;
        	
        	if(cnt < 0) {
        		str = "(";
        		v = correctString(v);
        		str += v;
        		str += ")";
        		
        		for (int j = 1; j < u.length()-1; j++) {
					if(u.charAt(j) == '(')
						str += ")";
					else
						str += "(";
				}
        		
        		break;
        	}
		}
        
		
		
		return str;
	}

}
