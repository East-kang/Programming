import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int value;
		Node prev, next;
		public Node(int value, Node prev, Node next) {
			super();
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}
	
	static Node node[];
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		node = new Node[1000001];
		
		st = new StringTokenizer(br.readLine());
		int c = 0;
		node[0] = new Node(0, null, null);
		for(int n=0; n<N; n++) {
			int idx = Integer.parseInt(st.nextToken());
			node[idx] = new Node(idx, node[c], (n < N-1 ? null : node[0]));
			node[c].next = node[idx];
			c = idx;
		}
		node[c].next = node[0].next;
		node[0].next.prev = node[c];
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int i = Integer.parseInt(st.nextToken());
			int j = -1;
			if(order.charAt(0) == 'B')
				j = Integer.parseInt(st.nextToken());
			updateLine(order, i, j);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void updateLine(String order, int i, int j) {
		Node cur = node[i];
		if(order.equals("BN")) {
			Node newNode = new Node(j, cur, cur.next);
			sb.append(cur.next.value);
			cur.next.prev = newNode;
			cur.next = newNode;
		} else if(order.equals("BP")) {
			Node newNode = new Node(j, cur.prev, cur);
			sb.append(cur.prev.value);
			cur.prev.next = newNode;
			cur.prev = newNode;
		} else if(order.equals("CP")) {
			Node delNode = cur.prev;
			sb.append(delNode.value);
			delNode.next.prev = delNode.prev;
			delNode.prev.next = delNode.next;
			delNode = new Node(delNode.value, null, null);
		} else if(order.equals("CN")) {
			Node delNode = cur.next;
			sb.append(delNode.value);
			delNode.next.prev = delNode.prev;
			delNode.prev.next = delNode.next;
			delNode = new Node(delNode.value, null, null);
		}
	}
}