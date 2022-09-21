package uk.co.argon.common.datastructures;

public class CodingChallenge {

	public static void main(String[] args) {
		//System.out.println(encode("abcdefghijklmnopqrstuvwxyzzzz"));
		c();
	}
	
	private static int a(int i, int j) {
		if(i==j)
			return i;
		if(i>=20000 || j>=20000)
			return -1;
		
		System.out.println("i: " + i + " j: " + j);
		i = a(nextNum(i), nextNum(j));
		return i;
	}
	
	private static int nextNum(int num) {
		return num + b(num,0);
	}
	
	private static int b(int num, int sum) {
		if(num/10 > 0) {
			sum += b(num/10, sum);
		}
		sum += num%10;
		return sum;
	}
	
	public static String encode(String str) {
		StringBuilder sb = new StringBuilder();
		
		int len = str.length();
		char[] arr = str.toCharArray();
		
		int j=1;
		for(int i=1; i<=len; i++) {
			if(i==len) {
				sb.append(j + String.valueOf(str.charAt(i-1)));
				j=1;
			}
			else if(str.charAt(i)==str.charAt(i-1))
				j++;
			
		}
		
		return sb.toString();
	}
	
	private static void c() {
		System.out.println("werabcsss".indexOf("abcd"));
	}

}
