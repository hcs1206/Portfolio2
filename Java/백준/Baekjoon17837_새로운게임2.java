import java.util.Scanner;

public class Baekjoon17837_새로운게임2 {
	static int[] dr = {0,0,0,-1,1};
	static int[] dc = {0,1,-1,0,0};
	static int[][] map;
	static int[][] chessMap;
	static Chess[] ch;
	static class Chess{
		public Chess(int r, int c, int index, int dest, int upC, int downC) {
			R = r;
			C = c;
			this.index = index;
			this.dest = dest;
			this.upC = upC;
			this.downC = downC;
		}
		int R;
		int C;
		int index;
		int dest;
		int upC;
		int downC;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		map = new int[N+2][N+2];
		chessMap = new int[N+2][N+2];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(i < 1 || i > N || j < 1 || j > N)
					map[i][j] = 2;
				else {
					map[i][j] = sc.nextInt();
				}
			}
		}
		ch = new Chess[K+1];
		for(int i=1; i<=K; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			ch[i] = new Chess(R, C,i, sc.nextInt(), 0,0);
			chessMap[R][C] = i;
		}
		
		int turn = 0;
		while(turn++ <= 1000) {
			for (int i = 1; i <= K; i++) {
				Chess c = ch[i];
				int curR = c.R;
				int curC = c.C;
				int curDest = c.dest;
				int curUp = c.upC;
				int curDown = c.downC;
				
				int nextR = curR+dr[curDest];
				int nextC = curC+dc[curDest];
				
				if(map[nextR][nextC] == 1) {
					moveOne(curR, curC, curDest, i);				
				}
				else if(map[nextR][nextC] == 2) {
					moveTwo(i);
				}
				else {
					moveZero(i);
				}
			}
		}
	}
	
	static void moveOne(int curR, int curC, int curDest, int i) {
		if(curDest == 1)
			curDest =2;
		else if(curDest == 2) 
			curDest = 1;
		else if(curDest == 3) 
			curDest = 4;					
		else if(curDest == 4)
			curDest = 3;
		
		int nextR = curR+dr[curDest];
		int nextC = curC+dr[curDest];
		
		if(map[nextR][nextC] == 1) {
			ch[i].dest = curDest;
		}
		else if(map[nextR][nextC] == 2) {
			
		}
		else {
			ch[i].dest = curDest;
			moveZero(i);
		}
	}
	
	static void moveTwo(int i) {
		if(ch[i].upC > 0) { // 위에 말이 있으면
			int nextR = ch[i].R + dr[ch[i].dest];
			int nextC = ch[i].C + dc[ch[i].dest];
			if(ch[i].downC > 0) { // 아래 말이 있으면
				int dI = ch[i].downC;
				chessMap[ch[dI].R][ch[dI].C] = dI;
				ch[dI].upC = 0;
				ch[i].downC = 0;
			}
			else { // 없으면
				chessMap[ch[i].R][ch[i].C] = 0;
			}
			
			ch[i].R = nextR;
			ch[i].C = nextC;
			
			ch[i].upC = 0;
			chessMap[nextR][nextC] = i;
			
			int upIdx = ch[i].upC;
			
			while(true) {
				ch[upIdx].R = nextR;
				ch[upIdx].C = nextC;
				
				if(ch[upIdx].upC > 0)
					upIdx = ch[upIdx].upC;
				else
					break;
			}
			
			ch[upIdx].upC = ch[upIdx].downC;
			
			
			
			if(chessMap[nextR][nextC] > 0) { // 이동한 곳에 말이 있으면
				int nI = chessMap[nextR][nextC];
				ch[i].downC = nI;
				ch[nI].upC = i;
			}
			else { // 없으면
				ch[i].downC = 0;
			}
			
			
			
			chessMap[nextR][nextC] = upIdx;
			
			
			
			
		}
		else {
			int nextR = ch[i].R + dr[ch[i].dest];
			int nextC = ch[i].C + dc[ch[i].dest];
			if(ch[i].downC > 0) { // 아래 말이 있으면
				int dI = ch[i].downC;
				chessMap[ch[dI].R][ch[dI].C] = dI;
				ch[dI].upC = 0;
				ch[i].downC = 0;
			}
			else { // 없으면
				chessMap[ch[i].R][ch[i].C] = 0;
			}
			if(chessMap[nextR][nextC] > 0) { // 이동한 곳에 말이 있으면
				int nI = chessMap[nextR][nextC];
				ch[i].downC = nI;
				ch[nI].upC = i;
			}
			else { // 없으면
				ch[i].downC = 0;
			}
			
			ch[i].R = nextR;
			ch[i].C = nextC;
			
			chessMap[nextR][nextC] = i;
			
		}
	}
	
	static void moveZero(int i) {
		if(ch[i].upC > 0) { // 위에 말이 있으면
			int nextR = ch[i].R + dr[ch[i].dest];
			int nextC = ch[i].C + dc[ch[i].dest];
			if(ch[i].downC > 0) { // 아래 말이 있으면
				int dI = ch[i].downC;
				chessMap[ch[dI].R][ch[dI].C] = dI;
				ch[dI].upC = 0;
				ch[i].downC = 0;
			}
			else { // 없으면
				chessMap[ch[i].R][ch[i].C] = 0;
			}
			if(chessMap[nextR][nextC] > 0) { // 이동한 곳에 말이 있으면
				int nI = chessMap[nextR][nextC];
				ch[i].downC = nI;
				ch[nI].upC = i;
			}
			else { // 없으면
				ch[i].downC = 0;
			}
			
			ch[i].R = nextR;
			ch[i].C = nextC;
			
			int upIdx = ch[i].upC;
			
			while(true) {
				ch[upIdx].R = nextR;
				ch[upIdx].C = nextC;
				
				if(ch[upIdx].upC > 0)
					upIdx = ch[upIdx].upC;
				else
					break;
			}
			
			chessMap[nextR][nextC] = upIdx;
			
			
			
			
		}
		else {
			int nextR = ch[i].R + dr[ch[i].dest];
			int nextC = ch[i].C + dc[ch[i].dest];
			if(ch[i].downC > 0) { // 아래 말이 있으면
				int dI = ch[i].downC;
				chessMap[ch[dI].R][ch[dI].C] = dI;
				ch[dI].upC = 0;
				ch[i].downC = 0;
			}
			else { // 없으면
				chessMap[ch[i].R][ch[i].C] = 0;
			}
			if(chessMap[nextR][nextC] > 0) { // 이동한 곳에 말이 있으면
				int nI = chessMap[nextR][nextC];
				ch[i].downC = nI;
				ch[nI].upC = i;
			}
			else { // 없으면
				ch[i].downC = 0;
			}
			
			ch[i].R = nextR;
			ch[i].C = nextC;
			
			chessMap[nextR][nextC] = i;
			
		}
	}

}
