package SW;

import java.util.HashMap;
import java.util.Map;

public class Kakao2020_가사검색 {
	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };
		solution(words, queries);

	}
	
//	class TrieNode{
//		private Map<Character, TrieNode> childNodes = new HashMap<>();
//		private boolean isLastChar;
//		
//		Map<Character, TrieNode> getChildNodes() {
//			return this.childNodes;
//		}
//		
//		// 마지막 글자인지 여부 Getter
//		boolean isLastChar() {
//			return this.isLastChar;
//		}
//		
//		// 마지막 글자인지 여부 Setter
//		void setIsLastChar(boolean isLastChar) {
//			this.isLastChar = isLastChar;
//		}		
//	}

	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		
		Map<Character, Map> trie = new HashMap<>();
		
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				
			}
		}

		

		return answer;

	}

}
