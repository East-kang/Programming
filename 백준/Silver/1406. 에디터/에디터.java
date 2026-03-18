import java.io.*;
import java.util.*;

public class Main {

	static class Word {
		Character value;
		Word pre = null, next = null;
		public Word(Character value, Word pre, Word next) {
			super();
			this.value = value;
			this.pre = pre;
			this.next = next;
		}
	}
	
	static String str;
	static Word cur, dummy;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		str = br.readLine();
		int n = Integer.parseInt(br.readLine());
		dummy = new Word(null, null, null);
		cur = dummy;
		for(int i=0; i<str.length(); i++) {
			Word word = new Word(str.charAt(i), cur, null);
			cur.next = word;
			cur = cur.next;
		}
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char order = st.nextToken().charAt(0);
			Character value = null;
			if(order == 'P') {
				value = st.nextToken().charAt(0);
			}
			changeStr(order, value);
		}
		for(Word w = dummy.next; w!=null; w = w.next)
			sb.append(w.value);
		System.out.println(sb);
	}

	private static void changeStr(char order, Character value) {
		if(order == 'L') {
			if(cur != dummy)
				cur = cur.pre;
		} else if(order == 'D') {
			if(cur.next != null)
				cur = cur.next;
		} else if(order == 'B') {
			if(cur != dummy) {
				cur.pre.next = cur.next;
				if(cur.next != null)
					cur.next.pre = cur.pre;
				cur = cur.pre;
			}
		} else if(order == 'P') {
			Word newWord = new Word(value, cur, cur.next);
			if(cur.next != null) {
				cur.next.pre = newWord;
			}
			cur.next = newWord;
			cur = newWord;
		}	
	}
}