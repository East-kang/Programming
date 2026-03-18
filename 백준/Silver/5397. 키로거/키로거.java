import java.io.*;
import java.util.*;
public class Main {

	static class Password{
		Character word;
		Password prev, next;
		public Password(Character word, Password prev, Password next) {
			super();
			this.word = word;
			this.prev = prev;
			this.next = next;
		}
	}
	 
	static String str;
	static Password dummy, cur;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();
			str = br.readLine();
			dummy = new Password(null, null, null);
			cur = dummy;
			for(int i=0; i<str.length(); i++) {
				inputPassword(str.charAt(i));
			}
			for(Password pw = dummy.next; pw != null; pw = pw.next) {
				sb.append(pw.word);
			}
			System.out.println(sb);
		}
	}
	
	private static void inputPassword(char order) {
		if(order == '<') {
			if(cur != dummy)
				cur = cur.prev;
		} else if(order == '>') {
			if(cur.next != null)
				cur = cur.next;
		} else if(order == '-') {
			if(cur != dummy) {
				if(cur.next != null)
					cur.next.prev = cur.prev;
				cur.prev.next = cur.next;
				cur = cur.prev;
			}
		} else {
			Password newWord = new Password(order, cur, cur.next);
			if(cur.next != null) {
				cur.next.prev = newWord;
			}
			cur.next = newWord;
			cur = cur.next;
		}
	}
}