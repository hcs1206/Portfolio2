import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author yangyu
 * ���� �м�
 *  >> �θ� ������ �ó����� �������� ������ �ɰ��� �Ѵ�. �����Ѱ� ? Yes or No!
 *  
 * Ư�̻��� 1: �ó��� ������ ������ K����°� �Է��� �־����µ�.. �׷��� ��ü �ѿ��� �������?
 *  >> A B, C D, E F �̷��� ������ �ִ� �ο� 2K��.
 * Ư�̻��� 2: ���� ��ġ���� �� ������ ������� �ó����� �ݴ������� �����⸸ �ϸ� ��. �׷� ���� ���� �ó��� �� ���� ������ BFS
 * Ư�̻��� 3: ������ ���� ������ �ó��� ȿ���� ������� �۾��� �ؾ��ϴµ� ������ ��ȣ���ƴ� ���ڿ� �̸����� ��;;;
 *  >> �̸��� ���� ���� ��ȣ�� �ٿ��� �츮�� �ͼ��� ���� ����� �ε��� ���·� Ȱ���Ҽ� �ְ� �۾��� �غ���! *
 */
public class SWEA7988_������� {
    static int K; // �ó��� ȿ���� ����
    static HashMap<String, Integer> player; // �̸�, �׻�� ��ȣ
    static boolean[][] map; // �� ���� ���̿� �ó����� �ִ� ���ٸ� �Ǵ��ϴ� �뵵�� ���� ���
    static int[] teamInfo; // �� ������ ���� ��� ���� �ִ����� ����� �迭
    static boolean ans; // �ȴ� �ȵȴ� ����� ����
    static int pcnt; // �� �ο��� ������ �Է����� �ȵ���. ���ߵ�. 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        
        for(int tc=1; tc<=TC; tc++) {
            K = sc.nextInt();
            
            map = new boolean[2*K][2*K]; // �ϴ� ��������� ������ ũ��
            
            player = new HashMap<String, Integer>();
            pcnt = 0; // �÷��̾� ��ȣ 0������ ������!
            for(int i=0; i< K; i++) {                
            	String name1 = sc.next();
                String name2 = sc.next();
                
                if(!player.containsKey(name1)) { // ������ �����ߴ� �ְ� �ƴ϶�� ? �����̽� ! ��ȣ������!
                    player.put(name1,pcnt++);
                }
                
                if(!player.containsKey(name2)) { // ������ �����ߴ� �ְ� �ƴ϶�� ? �����̽� ! ��ȣ������!
                    player.put(name2,pcnt++);
                }
                
                map[player.get(name1)][player.get(name2)] = true;
                map[player.get(name2)][player.get(name1)] = true;
            }
            
            teamInfo = new int[pcnt]; // ������ ������ ���� �Ҽӵɰ���. 1���� �Ǵ� 2����. ���� ������������ 0���� ����
            
            ans=true;
            for(int i=0; i < pcnt; i++) {        
            		if(teamInfo[i]==0) { // ���� ������ �ȵ� �ִ� ?! �ó��� ȿ���� ó������ ������ �Ǵ� �ֳ� ! �ƹ� ���̳� ���� 
                    teamInfo[i] = 1;
                    bfs(i);
                }
                
                if(!ans)
                    break;
            }
            
            System.out.println("#"+tc+" "+(ans?"Yes":"No"));
        }
        
        
    }
    
    static void bfs(int idx) { // ����ϴ� ���� �ó����� ���� �������� ! 
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(idx); 
        
        while(!queue.isEmpty()) { 
            int me = queue.poll(); // ���� ��������  
            for(int i=0; i<pcnt; i++) {
            		if(map[me][i]) { // ���� �ó��� �ִ� i�� !! 
                    if(teamInfo[i]!=0 && teamInfo[i] == teamInfo[me]) { // ���� ������ �ֳ� ? �ٵ� ���� �̹� ������?? ..
                        ans = false;
                        return;
                    }
                    
                    if(teamInfo[i]==0) { // ���� �ó��� �ִ� �ص� ���� �����̳�?! ���ΰ� ~ 
                        teamInfo[i] = teamInfo[me]==1? 2: 1;
                        queue.add(i); // �� �׷� ���� �ó��� �ִ� �ָ� �� �ݴ������� ���� ~ 
                    }
                    
                }
            }
        }
    }
}
