import java.io.*;
import java.util.*;
// 노드 Class로 구현 연습
public class Main {
	static class Node {
		int value;
		Node left, right;
		
		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	static Node nodes[];
	static int N;
	static BufferedWriter bw;
	
    public static void main(String[] args) throws Exception {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		bw = new BufferedWriter(new OutputStreamWriter(System.out));
    		N = Integer.parseInt(br.readLine());
    		nodes = new Node[N];
    		for(char i=0; i<N; i++)
    			nodes[i] = new Node(i);
    		
    		for(int i=0; i<N; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			char node = st.nextToken().charAt(0);
    			char left_node = st.nextToken().charAt(0);
    			char right_node = st.nextToken().charAt(0);
    			
    			if(left_node != '.')
    				nodes[node-'A'].left = nodes[left_node-'A'];
    			if(right_node != '.')
    				nodes[node-'A'].right = nodes[right_node-'A'];
    		}
    		
    		char root = 'A';
    		preOrder(nodes[root-'A']);	bw.write("\n");
    		inOrder(nodes[root-'A']); 	bw.write("\n");
    		postOrder(nodes[root-'A']);
    		bw.close();
	}
    
    private static void preOrder(Node node) throws Exception {
    		if(node == null) return;
    		bw.write(node.value+'A');
    		preOrder(node.left);
    		preOrder(node.right);
    }
    
    private static void inOrder(Node node) throws Exception {
		if(node == null) return;
    		inOrder(node.left);
    		bw.write(node.value+'A');
    		inOrder(node.right);
    }

    private static void postOrder(Node node) throws Exception {
		if(node == null) return;
    		postOrder(node.left);
    		postOrder(node.right);
		bw.write(node.value+'A');
    }
}