package SW;

public class Kakao2020_문자열압축 {
	public static void main(String[] args) {
		String str = "ababcdcdababcdcdx";
		int a = solution(str);
		
		System.out.println(a);

	}
	
	public static int solution(String s) {
		int ans = s.length();
		
		for(int i = 1; i <= s.length()/2; i++) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for (int j = 0; j <= s.length(); j = j+i) {
				if(j+2*i > s.length()) {
					if(count > 1)
						sb.append(count);
					sb.append(s.substring(j));
					break;
				}
				else if(s.substring(j, j+i).equals(s.substring(j+i, j+2*i))) {
					count++;
					if(j == s.length() - 2*i) {
						sb.append(count).append(s.substring(j, j+i));
						break;
					}

				}
				else{
					if(count > 1) {
						sb.append(count+"");
						count = 1;
					}
					sb.append(s.substring(j, j+i));					
				}
			}
			if(sb.length() < ans)
				ans = sb.length();
		}
		
		
		return ans;
		
//		int answer = s.length();
//
//		for (int sLen = 1; sLen <= s.length() / 2; sLen++) {
//			StringBuilder sb = new StringBuilder();
//
//			for (int i = 0; i < s.length(); i++) {
//				int n = 1;
//				if (i + sLen * 2 > s.length()) {
//					sb.append(s.substring(i));
//					break;
//				}
//				String str = s.substring(i, i + sLen);
//
//				while (str.equals(s.substring(i + sLen, i + sLen * 2))) {
//					n++;
//					i = i + sLen;
//					if (i + sLen * 2 > s.length()) {
//						break;
//					}
//				}
//
//				if (n > 1) {
//					sb.append(n).append(str);
//					i = i + sLen - 1;
//				} else {
//					sb.append(str);
//					i = i + sLen - 1;
//				}
//			}
//			if(answer > sb.length()) {
//				answer = sb.length();
//			}
//		}
//
//		return answer;
	}

}
