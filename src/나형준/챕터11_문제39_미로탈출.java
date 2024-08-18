package 나형준;
import java.util.*;
public class 챕터11_문제39_미로탈출 {
	public static class Node{
		public int row, col;
		public Node(int _x, int _y) {
			row= _x;
			col = _y;
		}
	}
	public static final int[] moveX = {0,1,0,-1}; // 상,우,하,좌 순서
	public static final int[] moveY = {-1,0,1,0};
	
	public static int solution(String[] maps) {
		
	}
	public static int bfs(String[] maps, Node start, Node end) { // 시작점부터 도착점까지 걸리는 최소 시간을 반환해주는 함수.
		int n = maps.length;
		int m = maps[0].length();
		boolean[][] visited = new boolean[n][m]; // 매번 방문 여부를 새로 만든다
		int count=0;
		
		Queue<Node> queue = new ArrayDeque<>(); // bfs에 사용할 큐(검사할 노드들을 담고 있음)
		queue.add(start); // 시작 노드 추가
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			++count;
			if(now.equals(end)) break;
			for(int i=0; i<4; ++i) {
				Node next = new Node(now.row+moveX[i], now.col+moveY[i]);
				if(next.row<0 || next.row>=n || next.col<0 || next.col>=m) continue; // 범위 벗어나면 취소 
				if(maps[next.row].charAt(next.col)=='X') continue; // 다음 노드가 벽인 경우 
				
				
			}
		}
		return count;
	}
}
